package domainapp.modules.simple.fixture;

import org.apache.isis.applib.services.registry.ServiceRegistry;
import org.apache.isis.testing.fixtures.applib.personas.PersonaWithBuilderScript;
import org.apache.isis.testing.fixtures.applib.personas.PersonaWithFinder;
import org.apache.isis.testing.fixtures.applib.setup.PersonaEnumPersistAll;

import domainapp.modules.simple.dom.so.PetOwner;
import domainapp.modules.simple.dom.so.PetOwners;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PetOwner_persona
implements PersonaWithBuilderScript<PetOwnerBuilder>, PersonaWithFinder<PetOwner> {

    FOO("Foo"),
    BAR("Bar"),
    BAZ("Baz"),
    FRODO("Frodo"),
    FROYO("Froyo"),
    FIZZ("Fizz"),
    BIP("Bip"),
    BOP("Bop"),
    BANG("Bang"),
    BOO("Boo");

    private final String name;

    @Override
    public PetOwnerBuilder builder() {
        return new PetOwnerBuilder().setName(name);
    }

    @Override
    public PetOwner findUsing(final ServiceRegistry serviceRegistry) {
        PetOwners petOwners = serviceRegistry.lookupService(PetOwners.class).orElse(null);
        return petOwners.findByNameExact(name);
    }

    public static class PersistAll
    extends PersonaEnumPersistAll<PetOwner_persona, PetOwner> {

        public PersistAll() {
            super(PetOwner_persona.class);
        }
    }
}
