package petclinic.modules.pets.dom.petowner;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PetRepository extends Repository<Pet, Long> {

    List<Pet> findByPetOwner(PetOwner petOwner);
}
