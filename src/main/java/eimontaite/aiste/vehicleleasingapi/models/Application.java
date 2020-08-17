package eimontaite.aiste.vehicleleasingapi.models;

import javax.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "family_monthly_income")
	private int familyMonthlyIncome;

	@Column(name = "marital_status")
	private String maritalStatus;

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

	@Column(name = "requested_amount")
	private long requestedAmount;

	@Column(name = "leasing_period")
	private long leasingPeriod;

	@Column(name = "status")
	private String status;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPersonalCode(long personalCode) {
		this.personalCode = personalCode;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public void setFamilyMonthlyIncome(int familyMonthlyIncome) {
		this.familyMonthlyIncome = familyMonthlyIncome;
	}

	public int getFamilyMonthlyIncome() {
		return familyMonthlyIncome;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getChildren() {
		return children;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public void setVehicleYear(int vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public void setVehiclePrice(int vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public void setRequestedAmount(long requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public long getRequestedAmount() {
		return requestedAmount;
	}

	public void setLeasingPeriod(long leasingPeriod) {
		this.leasingPeriod = leasingPeriod;
	}

	public long getLeasingPeriod() {
		return leasingPeriod;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

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
