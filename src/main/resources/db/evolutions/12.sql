--liquibase formatted sql
--changeset arkadiusz.cholewa:12

BEGIN WORK;
	UPDATE loyalty_account SET balance = balance - 100.00 WHERE user_id = 1;
	UPDATE loyalty_account SET balance = balance + 100.00 WHERE user_id = 2;
	select * from loyalty_account where balance>5000 for update;
COMMIT WORK;