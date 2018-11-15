--liquibase formatted sql
--changeset aleksandra.kopera:1
CREATE SEQUENCE hibernate_sequence;

CREATE TABLE users (
  id BIGINT PRIMARY KEY,
  username VARCHAR(80) NOT NULL UNIQUE,
  email VARCHAR(254) NOT NULL UNIQUE,
  name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR (50) NOT NULL CHECK (role IN('ADMIN','EMPLOYEE', 'CLIENT', 'USER'))
);
--rollback drop table users;
--rollback drop sequence hibernate_sequence;

