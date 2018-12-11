--liquibase formatted sql
--changeset aleksandra.kopera:2

INSERT INTO users(id, username,password, name, role, email)
VALUES((SELECT nextval('hibernate_sequence')), 'admin', '$2a$10$Lm4KPqtrlgNPGfsvWRqdYeaFfccMQ2EQSYWa9UkNFla19msVD8fmi','Jan Kowalski', 'ADMIN', 'admin@test.com');
INSERT INTO users(id, username,password, name, role, email)
VALUES((SELECT nextval('hibernate_sequence')), 'user', '$2a$10$/1kfDnV0KjsbgBHKN/e8oumjxWqwXsh/R.6Z4FVbnfspE6hAbTbhy','Jan Nowak', 'USER', 'user@test.com');
--rollback DELETE FROM users WHERE username = 'admin';
--rollback DELETE FROM users WHERE username = 'user';