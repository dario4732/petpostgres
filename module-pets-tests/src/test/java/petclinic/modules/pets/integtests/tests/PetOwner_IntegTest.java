package petclinic.modules.pets.integtests.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.isis.applib.services.wrapper.DisabledException;
import org.apache.isis.applib.services.wrapper.InvalidException;

import petclinic.modules.pets.dom.petowner.PetOwner;
import petclinic.modules.pets.fixture.PetOwner_persona;
import petclinic.modules.pets.integtests.PetsModuleIntegTestAbstract;

@Transactional
public class PetOwner_IntegTest extends PetsModuleIntegTestAbstract {

    PetOwner petOwner;

    @BeforeEach
    public void setUp() {
        // given
        petOwner = fixtureScripts.runPersona(PetOwner_persona.FOO);
    }


    @Nested
    public static class name extends PetOwner_IntegTest {

        @Test
        public void accessible() {
            // when
            final String name = wrap(petOwner).getLastName();

            // then
            assertThat(name).isEqualTo(petOwner.getLastName());
        }

        @Test
        public void not_editable() {

            // expect
            assertThrows(DisabledException.class, ()->{

                // when
                wrap(petOwner).setLastName("new name");
            });
        }

    }

    @Nested
    public static class updateName extends PetOwner_IntegTest {


        @Test
        public void can_be_updated_directly() {

            // when
            wrap(petOwner).updateName("new name");
            transactionService.flushTransaction();

            // then
            assertThat(wrap(petOwner).getLastName()).isEqualTo("new name");
        }

        @Test
        public void fails_validation() {

            // expect
            InvalidException cause = assertThrows(InvalidException.class, ()->{

                // when
                wrap(petOwner).updateName("new name!");
            });

            // then
            assertThat(cause.getMessage()).contains("Character '!' is not allowed");
        }
    }

}
