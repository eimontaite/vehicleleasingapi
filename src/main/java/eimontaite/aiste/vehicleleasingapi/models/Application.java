package eimontaite.aiste.vehicleleasingapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Table(name = "applications")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Column(name = "id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "personal_code")
	private long personalCode;

	@Column(name = "type_of_document")
	private String typeOfDocument;

	@Column(name = "document_number")
	private String documentNumber;

	@Getter
	@Column(name = "family_monthly_income")
	private int familyMonthlyIncome;

	@Getter
	@Column(name = "marital_status")
	private String maritalStatus;

	@Getter
	@Column(name = "children")
	private int children;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "vehicle_brand")
	private String vehicleBrand;

	@Column(name = "vehicle_model")
	private String vehicleModel;

	@Column(name = "vehicle_year")
	private int vehicleYear;

	@Column(name = "vehicle_price")
	private int vehiclePrice;

	@Getter
	@Column(name = "requested_amount")
	private long requestedAmount;

	@Getter
	@Column(name = "leasing_period")
	private long leasingPeriod;

	@Getter
	@Column(name = "status")
	private String status;

//	public Application(int id,
//	                   String firstName,
//	                   String lastName,
//	                   int personalCode,
//	                   String typeOfDocument,
//	                   String documentNumber,
//	                   int familyMonthlyIncome,
//	                   String maritalStatus,
//	                   int numberOfChildren,
//	                   String country,
//	                   String city,
//	                   String address,
//	                   String email,
//	                   String vehicleBrand,
//	                   String vehicleModel,
//	                   int vehicleYear,
//	                   int vehiclePrice,
//	                   int requestedAmount,
//	                   int leasingPeriod,
//	                   String applicationStatus) {
//	}

	public static String determineApplicationStatus(
			String maritalStatus,
			int numberOfChildren,
			int monthlyIncome,
			long requestedAmount,
			long leasingPeriod
	) {
		int familySize = 1;
		if (maritalStatus.equals(MaritalStatus.MARRIED.toString())) {
			familySize++;
		}

		familySize += numberOfChildren;

		if (((monthlyIncome - requestedAmount / leasingPeriod) / familySize) >= 600) {
			return ApplicationStatus.APPROVED.toString();
		} else {
			return ApplicationStatus.REJECTED.toString();
		}
	}
}
