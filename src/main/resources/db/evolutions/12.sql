--liquibase formatted sql
--changeset arkadiusz.cholewa:12

do $$
begin
  CREATE TABLE Foo(a int);

	UPDATE loyalty_account SET balance = balance - 100.00 WHERE user_id = 1;
	UPDATE loyalty_account SET balance = balance + 100.00 WHERE user_id = 2;
 	CREATE TABLE Foo(a int); -- this will cause an error

  EXCEPTION WHEN others THEN
    raise notice 'The transaction is in an uncommittable state. '
                 'Transaction was rolled back';
    raise notice '% %', SQLERRM, SQLSTATE;
end;
$$ language 'plpgsql';