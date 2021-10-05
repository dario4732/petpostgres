package petclinic.modules.pets.dom.petowner;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.xactn.TransactionService;

import lombok.RequiredArgsConstructor;

import petclinic.modules.pets.dom.pet.PetRepository;

@Action(
        semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE,
        commandPublishing = Publishing.ENABLED,
        executionPublishing = Publishing.ENABLED
)
@ActionLayout(
        associateWith = "name", position = ActionLayout.Position.PANEL,
        describedAs = "Deletes this object from the persistent datastore")
@RequiredArgsConstructor
public class PetOwner_delete {

    private final PetOwner petOwner;

    public void act(
            ) {
        petRepository.findByPetOwner(petOwner).forEach(repositoryService::remove);
        transactionService.flushTransaction();
        repositoryService.remove(petOwner);
        return;
    }

    @Inject PetRepository petRepository;
    @Inject RepositoryService repositoryService;
    @Inject TransactionService transactionService;
}
