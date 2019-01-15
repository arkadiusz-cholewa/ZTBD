--liquibase formatted sql
--changeset arkadiusz.cholewa:11

Create table loyalty_account (
   id BIGINT PRIMARY KEY,
   user_id BIGINT REFERENCES users(id),
   balance real not null
);
--rollback drop table loyalty_account;
