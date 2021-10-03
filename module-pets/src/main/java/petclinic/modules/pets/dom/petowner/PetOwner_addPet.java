package petclinic.modules.pets.dom.petowner;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.repository.RepositoryService;

import lombok.RequiredArgsConstructor;

import petclinic.modules.pets.types.PetName;

@Action(
        semantics = SemanticsOf.IDEMPOTENT,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(associateWith = "pets")
@RequiredArgsConstructor
public class PetOwner_addPet {

    private final PetOwner petOwner;

    public PetOwner act(
            @PetName final String name,
            final PetSpecies petSpecies
            ) {
        repositoryService.persist(new Pet(petOwner, name, petSpecies));
        return petOwner;
    }
    public String validate0Act(final String name) {
        return petRepository.findByPetOwnerAndName(petOwner, name).isPresent()
                ? String.format("Pet with name '%s' already defined for this owner", name)
                : null;
    }

    @Inject PetRepository petRepository;
    @Inject RepositoryService repositoryService;
}
