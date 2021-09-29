package petclinic.modules.pets.dom.petowner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import petclinic.modules.pets.dom.petowner.PetOwner;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

    List<PetOwner> findByNameContaining(final String name);

    PetOwner findByName(final String name);

}
