-- From https://marschall.github.io/2020/04/12/oracle-docker-container.html
-- user.sql
-- ALTER SESSION SET CONTAINER = XEPDB1;

--CREATE USER test_user IDENTIFIED BY "some-password";

-- permissions.sql
--GRANT CONNECT TO test_user CONTAINER=CURRENT;
--GRANT CREATE SESSION TO test_user CONTAINER=CURRENT;
--GRANT RESOURCE TO test_user CONTAINER=CURRENT;
--ALTER USER test_user QUOTA 100M ON USERS;

-- objects.sql
ALTER SESSION SET CURRENT_SCHEMA = myuser;

CREATE TABLE EMPLOYEE
(
    ID INT ,
    NAME CHARACTER (100)
);

INSERT INTO EMPLOYEE VALUES(1,'Homer');
INSERT INTO EMPLOYEE VALUES(2,'Bart');

COMMIT;

SELECT * FROM EMPLOYEE;