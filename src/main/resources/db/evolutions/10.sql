--liquibase formatted sql
--changeset arkadiusz.cholewa:10

 CREATE TEMPORARY TABLE IF NOT EXISTS user_statistics
 (
      numberOfUsers int
 )
 ON COMMIT DELETE ROWS;

BEGIN TRANSACTION;
   INSERT INTO user_statistics (numberOfUsers) SELECT COUNT(username) as numberOfUsers FROM users;
   SELECT * FROM user_statistics;
COMMIT;
