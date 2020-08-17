**Data Query API**
----
### **Setup:**
   
  **Since only a few properties are used to calculate the status of the vehicle leasing application, I put all the information about the applicant in the same model (as it's essentially metadata. Should this information be used for other purposes, the model would be split).**
  
  **The application runs on localhost:8080. The database is available on localhost:8080/h2-console with the credentials provided in the application.properties file.**
  
### Methods
  
  `GET` | `POST`
  
### URL

  **The URLs are structured as follows:**
  
  `GET /applications/{id}`
  
  `POST /applications`
  
  `{
   	"firstName": "Vardenis", "lastName": "Pavardenis", "personalCode": 1254321, "typeOfDocument": "PASSPORT", "documentNumber": "2314352", "familyMonthlyIncome": 3000, "maritalStatus": "SINGLE", "children": 1, "country": "LITHUANIA", "city": "Vilnius", "address": "Gatvele 42", "email": "vardenis.pavardenis@gmail.com", "vehicleBrand": "FIAT", "vehicleModel": "PUNTO", "vehicleYear": 2010, "vehiclePrice": 17000, "requestedAmount": 15000, "leasingPeriod": 36
   }`
   
### Success Responses:
  
  **A successful `GET` request posted with the application status returns the following response:**

  * **Code:** 200 OK<br />
    **Content:** `APPROVED` | `REJECTED` | `Application not found`
                  
  **A successful `POST` request returns the following response:**
    
  * **Code:** 200 OK<br />
    **Content:** `Your application has been {application status}. Application ID: {application ID}`