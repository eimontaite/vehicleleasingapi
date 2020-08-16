package eimontaite.aiste.vehicleleasingapi.controllers;

import eimontaite.aiste.vehicleleasingapi.models.Application;
import eimontaite.aiste.vehicleleasingapi.models.ApplicationDTO;
import eimontaite.aiste.vehicleleasingapi.services.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	private ApplicationService applicationService;

	public ApplicationController(
			ApplicationService applicationService
	) {
		this.applicationService = applicationService;
	}

	enum MaritalStatus {
		MARRIED,
		SINGLE
	}

	enum Status {
		APPROVED,
		REJECTED
	}

	public String determineApplicationStatus(String maritalStatus, int numberOfChildren, int monthlyIncome, long requestedAmount, long leasingPeriod) {
		int familySize = 1;
		if (maritalStatus.equals(MaritalStatus.MARRIED.toString())) {
			familySize++;
		}

		familySize += numberOfChildren;

		if (((monthlyIncome - requestedAmount / leasingPeriod) / familySize) >= 600) {
			return Status.APPROVED.toString();
		} else {
			return Status.REJECTED.toString();
		}
	}

	@PostMapping(value = "/applications", consumes = "application/json", produces = "application/json")
	public long createApplication(@RequestBody ApplicationDTO applicationDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Application application = modelMapper.map(applicationDTO, Application.class);

		application.setStatus(determineApplicationStatus(
				application.getMaritalStatus(),
				application.getChildren(),
				application.getFamilyMonthlyIncome(),
				application.getRequestedAmount(),
				application.getLeasingPeriod())
		);
		
		return applicationService.create(application).getId();
	}
}