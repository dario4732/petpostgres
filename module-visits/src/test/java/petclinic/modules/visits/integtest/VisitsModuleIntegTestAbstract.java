package petclinic.modules.visits.integtest;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.ActiveProfiles;

import org.apache.isis.core.config.presets.IsisPresets;
import org.apache.isis.core.runtimeservices.IsisModuleCoreRuntimeServices;
import org.apache.isis.persistence.jpa.eclipselink.IsisModulePersistenceJpaEclipselink;
import org.apache.isis.security.bypass.IsisModuleSecurityBypass;
import org.apache.isis.testing.fakedata.applib.IsisModuleTestingFakeDataApplib;
import org.apache.isis.testing.fixtures.applib.IsisIntegrationTestAbstractWithFixtures;
import org.apache.isis.testing.fixtures.applib.IsisModuleTestingFixturesApplib;

import petclinic.modules.pets.PetsModule;
import petclinic.modules.visits.VisitsModule;


@SpringBootTest(
        classes = VisitsModuleIntegTestAbstract.TestApp.class
)
@ActiveProfiles("test")
public abstract class VisitsModuleIntegTestAbstract extends IsisIntegrationTestAbstractWithFixtures {

    @SpringBootConfiguration
    @EnableAutoConfiguration
    @Import({

            IsisModuleCoreRuntimeServices.class,
            IsisModuleSecurityBypass.class,
            IsisModulePersistenceJpaEclipselink.class,
            IsisModuleTestingFixturesApplib.class,

            IsisModuleTestingFakeDataApplib.class,

            VisitsModule.class
    })
    @PropertySources({
            @PropertySource(IsisPresets.H2InMemory_withUniqueSchema),
            @PropertySource(IsisPresets.UseLog4j2Test),
    })
    public static class TestApp {
    }
}
