package eimontaite.aiste.vehicleleasingapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
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
}

