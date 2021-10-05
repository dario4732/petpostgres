package petclinic.webapp.application.services.homepage;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Nature;
import org.apache.isis.applib.annotation.Projecting;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;

import petclinic.modules.pets.dom.pet.Pet;
import petclinic.modules.pets.dom.petowner.PetOwner;
import petclinic.modules.visits.dom.visit.Visit;

@DomainObject(nature=Nature.VIEW_MODEL, logicalTypeName = "petclinic.VisitPlusPetOwner")
@DomainObjectLayout(named = "Visit")
@XmlRootElement
@NoArgsConstructor
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class VisitPlusPetOwner {

    @Property(
            projecting = Projecting.PROJECTED,
            hidden = Where.EVERYWHERE
    )
    @Getter
    private Visit visit;

    VisitPlusPetOwner(Visit visit) {this.visit = visit;}

    public Pet getPet() {return visit.getPet();}
    public String getReason() {return visit.getReason();}
    public LocalDateTime getVisitAt() {return visit.getVisitAt();}

    public PetOwner getPetOwner() {
        return getPet().getPetOwner();
    }
}
