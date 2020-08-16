package eimontaite.aiste.vehicleleasingapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationDTO {
	@JsonProperty("firstName")
	public String firstName;

	@JsonProperty("lastName")
	public String lastName;

	@JsonProperty("personalCode")
	public long personalCode;

	@JsonProperty("typeOfDocument")
	public String typeOfDocument;

	@JsonProperty("documentNumber")
	public String documentNumber;

	@JsonProperty("familyMonthlyIncome")
	public int familyMonthlyIncome;

	@JsonProperty("maritalStatus")
	public String maritalStatus;

	@JsonProperty("children")
	public int children;

	@JsonProperty("country")
	public String country;

	@JsonProperty("city")
	public String city;

	@JsonProperty("address")
	public String address;

	@JsonProperty("email")
	public String email;

	@JsonProperty("vehicleBrand")
	public String vehicleBrand;

	@JsonProperty("vehicleModel")
	public String vehicleModel;

	@JsonProperty("vehicleYear")
	public int vehicleYear;

	@JsonProperty("vehiclePrice")
	public int vehiclePrice;

	@JsonProperty("leasingPeriod")
	public int leasingPeriod;

	@JsonProperty("requestedAmount")
	public int requestedAmount;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getPersonalCode() {
		return personalCode;
	}

	public String getTypeOfDocument() {
		return typeOfDocument;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public int getFamilyMonthlyIncome() {
		return familyMonthlyIncome;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public int getChildren() {
		return children;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public int getVehicleYear() {
		return vehicleYear;
	}

	public int getVehiclePrice() {
		return vehiclePrice;
	}

	public int getLeasingPeriod() {
		return leasingPeriod;
	}

	public int getRequestedAmount() {
		return requestedAmount;
	}
}

