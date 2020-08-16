DROP TABLE IF EXISTS applications;

CREATE TABLE applications (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  personal_code BIGINT NOT NULL,
  type_of_document VARCHAR(250) NOT NULL,
  document_number VARCHAR(250) NOT NULL,
  family_monthly_income INT NOT NULL,
  marital_status VARCHAR(50) NOT NULL,
  children INT NOT NULL DEFAULT 0,
  country VARCHAR(50) NOT NULL,
  city VARCHAR(50) NOT NULL,
  address VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  vehicle_brand VARCHAR(50) NOT NULL,
  vehicle_model VARCHAR(50) NOT NULL,
  vehicle_year INT NOT NULL,
  vehicle_price INT NOT NULL,
  requested_amount INT NOT NULL,
  leasing_period INT NOT NULL,
  status VARCHAR(20)
);