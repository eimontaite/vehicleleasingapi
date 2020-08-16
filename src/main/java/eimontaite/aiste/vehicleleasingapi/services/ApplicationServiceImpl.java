package eimontaite.aiste.vehicleleasingapi.services;

import eimontaite.aiste.vehicleleasingapi.models.Application;
import eimontaite.aiste.vehicleleasingapi.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
	private ApplicationRepository applicationRepository;

	public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	@Override
	public Optional<Application> getApplicationById(long applicationId) {
		return applicationRepository.findById(applicationId);
	}

	@Override
	public Application create(Application application) {
		return applicationRepository.save(application);
	}
}
