package petclinic.modules.visits.dom.visit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import petclinic.modules.pets.dom.pet.Pet;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findByPetOrderByVisitAtDesc(Pet pet);

}
