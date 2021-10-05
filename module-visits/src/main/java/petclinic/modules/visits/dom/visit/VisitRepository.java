package petclinic.modules.visits.dom.visit;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import petclinic.modules.pets.dom.pet.Pet;
import petclinic.modules.pets.dom.petowner.PetOwner;

public interface VisitRepository extends Repository<Visit, Long> {

    List<Visit> findByPetOrderByVisitAtDesc(Pet pet);

}
