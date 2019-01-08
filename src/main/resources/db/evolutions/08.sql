--liquibase formatted sql
--changeset arkadiusz.cholewa:8

CREATE TRIGGER log_email_changes
  BEFORE UPDATE
  ON users
  FOR EACH ROW
  EXECUTE PROCEDURE log_email_changes();