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

	@PostMapping(value = "/applications", consumes = "application/json", produces = "application/json")
	public long createApplication(@RequestBody ApplicationDTO applicationDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Application application = modelMapper.map(applicationDTO, Application.class);

		return applicationService.create(application).getId();
	}
}
