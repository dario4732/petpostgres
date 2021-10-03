package petclinic.modules.pets.dom.petowner;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface PetRepository extends Repository<Pet, Long> {

    List<Pet> findByPetOwner(PetOwner petOwner);
    Optional<Pet> findByPetOwnerAndName(PetOwner petOwner, String name);
}
