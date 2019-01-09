--liquibase formatted sql
--changeset aleksandra.kopera:9
CREATE VIEW actual_reservation_view(id, usr_id, usr_name, hotel_name, room_number,fromDate, toDate)
AS SELECT row_number() over(), u.id, u.username,h.name,rm.room_number, r.date_from, r.date_to
FROM reservations r LEFT JOIN hotels h ON r.hotel_id = h.id LEFT JOIN rooms rm ON r.room_id=rm.id LEFT JOIN users u ON r.usr_id = u.id
WHERE r.date_from <= CURRENT_DATE  AND r.date_to >=CURRENT_DATE;
--rollback drop view actual_reservation_view;