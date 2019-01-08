--liquibase formatted sql
--changeset arkadiusz.cholewa:6
CREATE TABLE user_audits  (
  id SERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL,
  email varchar(254) NOT NULL,
  changed_on timestamp(6) NOT NULL
);
--rollback drop table user_audits;
--rollback drop sequence hibernate_sequence;

