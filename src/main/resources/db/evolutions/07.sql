--liquibase formatted sql
--changeset arkadiusz.cholewa:7
CREATE OR REPLACE FUNCTION log_email_changes()
  RETURNS trigger AS
'
BEGIN
 IF NEW.email <> OLD.email THEN
 INSERT INTO user_audits(user_id,email,changed_on)
 VALUES(OLD.id,OLD.email,now());
 END IF;

 RETURN NEW;
END;
'LANGUAGE plpgsql
