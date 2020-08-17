package eimontaite.aiste.vehicleleasingapi.controllers;

import eimontaite.aiste.vehicleleasingapi.models.Application;
import eimontaite.aiste.vehicleleasingapi.models.ApplicationDTO;
import eimontaite.aiste.vehicleleasingapi.services.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ApplicationController {
	private ApplicationService applicationService;

	public ApplicationController(
			ApplicationService applicationService
	) {
		this.applicationService = applicationService;
	}

	@PostMapping(value = "/applications", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createApplication(@RequestBody ApplicationDTO applicationDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Application application = modelMapper.map(applicationDTO, Application.class);

		application.setStatus(Application.determineApplicationStatus(
				application.getMaritalStatus(),
				application.getChildren(),
				application.getFamilyMonthlyIncome(),
				application.getRequestedAmount(),
				application.getLeasingPeriod())
		);

		long applicationId = applicationService.create(application).getId();

		Optional<Application> createdApplication = applicationService.getApplicationById(applicationId);

		StringBuilder response = new StringBuilder();
		response.append("Thank you. Your application status: ");
		createdApplication.ifPresentOrElse(
				a -> response.append(a.getStatus()),
				() -> response.append("Failed to find application"));
		response.append(", application ID: ");
		response.append(applicationId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/applications/{id}")
	public @ResponseBody
	String getApplicationById(@PathVariable long id) {
		return applicationService.getApplicationById(id).map(Application::getStatus).orElse("Application not found");
	}
}