--liquibase formatted sql
--changeset aleksandra.kopera:5

CREATE TABLE reservations(
id BIGINT PRIMARY KEY ,
reservation_number VARCHAR (120) NOT NULL,
hotel_id BIGINT REFERENCES hotels(id),
room_id BIGINT REFERENCES rooms(id),
usr_id BIGINT REFERENCES users(id),
date_from DATE NOT NULL,
date_to DATE NOT NULL
);

CREATE INDEX idx_reservation_hotel_id ON reservations(hotel_id);
CREATE INDEX idx_reservation_room_id ON reservations(room_id);
CREATE INDEX idx_reservation_user_id ON reservations(usr_id);

--rollback drop index if exists idx_reservation_hotel_id;
--rollback drop index if exists idx_reservation_room_id;
--rollback drop index if exists idx_reservation_user_id;
--rollback drop table reservations;
