package petclinic.modules.pets.dom.petowner;

import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.annotation.CollectionLayout;

import lombok.RequiredArgsConstructor;

import petclinic.modules.pets.dom.pet.Pet;
import petclinic.modules.pets.dom.pet.PetRepository;

@Collection
@CollectionLayout(defaultView = "table")
@RequiredArgsConstructor
public class PetOwner_pets {

    private final PetOwner petOwner;

    public List<Pet> coll() {
        return petRepository.findByPetOwner(petOwner);
    }

    @Inject PetRepository petRepository;
}
