package petclinic.webapp.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import petclinic.modules.visits.VisitsModule;

@Configuration
@Import(VisitsModule.class)
@ComponentScan
public class ApplicationModule {

}
