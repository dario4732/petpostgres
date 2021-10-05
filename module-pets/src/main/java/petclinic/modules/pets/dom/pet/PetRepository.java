package petclinic.modules.pets.dom.pet;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import petclinic.modules.pets.dom.petowner.PetOwner;

public interface PetRepository extends Repository<Pet, Long> {

    List<Pet> findByPetOwner(PetOwner petOwner);
    Optional<Pet> findByPetOwnerAndName(PetOwner petOwner, String name);
}
