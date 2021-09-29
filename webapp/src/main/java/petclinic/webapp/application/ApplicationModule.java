package petclinic.webapp.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import petclinic.modules.pets.PetsModule;

@Configuration
@Import(PetsModule.class)
@ComponentScan
public class ApplicationModule {

}
