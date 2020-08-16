package eimontaite.aiste.vehicleleasingapi.services;

import eimontaite.aiste.vehicleleasingapi.models.Application;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public interface ApplicationService {
	Optional<Application> getApplicationById(long applicationId);

	Application create(Application application);
}
