-----------------------------------------
-- Initial DDL and DML of the project ---
-- File for ilustration proporses only --
-----------------------------------------


--Create specific schema for the application
CREATE schema restapp DEFAULT CHARACTER SET = utf8 DEFAULT COLLATE = utf8_general_ci;

DROP TABLE USER;

--Create table for authentication and user entity
CREATE TABLE USER (
        ID INT(9) AUTO_INCREMENT PRIMARY KEY,
        USERNAME VARCHAR(100) NOT NULL UNIQUE,
        EMAIL VARCHAR(100) NOT NULL UNIQUE,
        PASSWORD VARCHAR(200) NOT NULL,
        ROLE VARCHAR(50) NOT NULL,
        ACTIVE INT(1) NOT NULL,
        CREATE_TS TIMESTAMP NOT NULL,
        LAST_UPDT_TS TIMESTAMP 
);

--Create User row (to test only)
INSERT INTO USER (USERNAME, EMAIL, PASSWORD, ROLE, ACTIVE, CREATE_TS, LAST_UPDT_TS) VALUES ('chuuck_sc', 'carlos.salazar@codesolt.com', '$2a$10$wo70hYHAe2KFtjG94hYVdO.xoTxQzooKbQESYcc0e7pPHutsVSrcy', 'ROLE_ADMIN', 1, now(), now());
INSERT INTO USER (USERNAME, EMAIL, PASSWORD, ROLE, ACTIVE, CREATE_TS, LAST_UPDT_TS) VALUES ('user1', 'user1@mail.com', '$2a$10$wo70hYHAe2KFtjG94hYVdO.xoTxQzooKbQESYcc0e7pPHutsVSrcy', 'ROLE_USER', 1, now(), now());
INSERT INTO USER (USERNAME, EMAIL, PASSWORD, ROLE, ACTIVE, CREATE_TS, LAST_UPDT_TS) VALUES ('user2', 'user2@mail.com', '$2a$10$wo70hYHAe2KFtjG94hYVdO.xoTxQzooKbQESYcc0e7pPHutsVSrcy', 'ROLE_USER', 0, now(), now());

--Create user for application
CREATE USER restuser IDENTIFIED BY 'RestPass123';

--Allow the app user to connect remotly 
--(Connect with restuser from the app)
GRANT ALL PRIVILEGES ON restapp.* TO 'restuser'@'%' IDENTIFIED BY 'RestPass123' WITH GRANT OPTION;

--Query complete User table
SELECT * FROM USER;
SELECT ID, USERNAME, EMAIL, ROLE, ACTIVE, CREATE_TS, LAST_UPDT_TS FROM USER;

--Application will run this authentication querys
SELECT USERNAME, PASSWORD, ACTIVE FROM USER WHERE USERNAME = 'username';
SELECT USERNAME, ROLE FROM USER WHERE USERNAME = 'username';
