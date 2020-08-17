package eimontaite.aiste.vehicleleasingapi;

import eimontaite.aiste.vehicleleasingapi.models.Application;
import eimontaite.aiste.vehicleleasingapi.repositories.ApplicationRepository;
import eimontaite.aiste.vehicleleasingapi.services.ApplicationService;
import eimontaite.aiste.vehicleleasingapi.services.ApplicationServiceImpl;
import eimontaite.aiste.vehicleleasingapi.utils.ModelMapperUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceImplTest {

	@Mock
	private ApplicationRepository applicationRepository;

	@InjectMocks
	private ApplicationService applicationService = new ApplicationService() {
		@Override
		public Optional<Application> getApplicationById(long applicationId) {
			return applicationRepository.findById(applicationId);
		}

		@Override
		public Application create(Application application) {
			return applicationRepository.save(application);
		}
	};


	@Mock
	private ModelMapperUtil modelMapper;
	private Application application = new Application();

	@Before
	public void setUp() {

		application.setId(1L);
		application.setFirstName("Vardenis");
		application.setLastName("Pavardenis");
		application.setPersonalCode(31214446634L);
		application.setTypeOfDocument("PASSPORT");
		application.setDocumentNumber("312144");
		application.setFamilyMonthlyIncome(2000);
		application.setMaritalStatus("SINGLE");
		application.setChildren(1);
		application.setCountry("Lithuania");
		application.setCity("Kaunas");
		application.setAddress("Gatvele 4-42");
		application.setEmail("vardenis.pavardenis@pastas.lt");
		application.setVehicleBrand("Volkswagen");
		application.setVehicleModel("Passat");
		application.setVehicleYear(2017);
		application.setVehiclePrice(15000);
		application.setLeasingPeriod(12);
		application.setRequestedAmount(15000);
	}

	@Test
	public void testGetId() throws Throwable {
		when(applicationRepository.findById(anyLong())).thenReturn(Optional.of(application));

		Optional<Application> result = applicationService.getApplicationById(1L);

		assertEquals(1L, result.get().getId());
		assertNotNull(result);

	}

	@Test
	public void testGetFamilyMonthlyIncome() throws Throwable {
		when(applicationRepository.findById(anyLong())).thenReturn(Optional.of(application));

		Optional<Application> result = applicationService.getApplicationById(1L);

		assertEquals(2000, result.get().getFamilyMonthlyIncome());
		assertNotNull(result);

	}

	@Test
	public void testGetRequestedAmount() throws Throwable {
		when(applicationRepository.findById(anyLong())).thenReturn(Optional.of(application));

		Optional<Application> result = applicationService.getApplicationById(1L);

		assertEquals(15000L, result.get().getRequestedAmount());
		assertNotNull(result);

	}
}