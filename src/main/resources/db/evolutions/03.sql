--liquibase formatted sql
--changeset aleksandra.kopera:3
CREATE TABLE hotels(
  id BIGINT PRIMARY KEY,
  name VARCHAR (255) NOT NULL UNIQUE,
  street_and_number VARCHAR (255) NOT NULL,
  city VARCHAR (120) NOT NULL,
  postal_code VARCHAR (10) NOT NULL,
  phone_number VARCHAR (40)
);

CREATE TABLE hotel_employees (
	hotel_id BIGINT NOT NULL REFERENCES hotels(id) ON DELETE CASCADE,
	user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
	PRIMARY KEY (hotel_id, user_id)
);

CREATE INDEX idx_hotel_name ON hotels(name);
CREATE INDEX idx_city ON hotels(city);
CREATE INDEX idx_street_and_number ON hotels(street_and_number);
CREATE INDEX idx_postal_code ON hotels(postal_code);
CREATE INDEX idx_hotel_employees_id ON hotel_employees(hotel_id);


INSERT INTO hotels(id,name,street_and_number,city,postal_code,phone_number)
VALUES ((SELECT nextval('hibernate_sequence')),'hotel','test 3','Krakow','12-222','123456789');

--rollback delete from hotels where name = 'hotel';
--rollback drop index if exists idx_hotel_name;
--rollback drop index if exists idx_city;
--rollback drop index if exists idx_street_and_number;
--rollback drop index if exists idx_postal_code;
--rollback drop index if exists idx_hotel_employees_id;
--rollback drop table hotel_employees;
--rollback drop table hotel;
