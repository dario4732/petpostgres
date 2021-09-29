package petclinic.modules.pets.fixture;

import javax.inject.Inject;

import org.apache.isis.testing.fixtures.applib.personas.BuilderScriptWithResult;

import petclinic.modules.pets.dom.petowner.PetOwner;
import petclinic.modules.pets.dom.petowner.PetOwners;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class PetOwnerBuilder extends BuilderScriptWithResult<PetOwner> {

    @Getter @Setter
    private String name;

    @Override
    protected PetOwner buildResult(final ExecutionContext ec) {

        checkParam("name", ec, String.class);

        return wrap(petOwners).create(name);
    }

    // -- DEPENDENCIES

    @Inject PetOwners petOwners;

}
