--liquibase formatted sql
--changeset aleksandra.kopera:4

CREATE TABLE rooms (
id BIGINT PRIMARY KEY ,
room_number VARCHAR (20) NOT NULL,
hotel_id BIGINT REFERENCES hotels(id),
price_per_day NUMERIC(20,2) CHECK(price_per_day>=0),
amount_of_people INTEGER NOT NULL,
room_state INT NOT NULL DEFAULT 0 CHECK(room_state IN (0,1,2,3))
);

CREATE INDEX idx_room_amount_of_people ON rooms(amount_of_people);
CREATE INDEX idx_room_hotel_id ON rooms(hotel_id);
CREATE INDEX idx_room_price_per_day ON rooms(price_per_day);

--rollback drop index if exists idx_room_amount_of_people;
--rollback drop index if exists idx_room_hotel_id;
--rollback drop index if exists idx_room_price_per_day;
--rollback drop table rooms;
