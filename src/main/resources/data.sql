--INSERT INTO USERS (id, email, name, password, enabled) VALUES
--(1, 'user1@example.com', 'user', '$2a$12$7gmBpL3sK6WIVTwmgqs3UOajs0zJaeBmefO732qmNlz/CSdbCcIRG', 'Y'),
--(2, 'user2@example.com', 'admin', '$2a$12$7gmBpL3sK6WIVTwmgqs3UOajs0zJaeBmefO732qmNlz/CSdbCcIRG', 'Y');
--
--INSERT INTO AUTHORITIES (user_id, authority) VALUES
--(1, 'ROLE_STUDENT'),
--(2, 'ROLE_TEACHER'),
--(2, 'ROLE_ADMIN');

--ALTER SEQUENCE USERS_ID_SEQ RESTART WITH 3;
--ALTER SEQUENCE AUTHORITIES RESTART WITH 3;
SELECT * FROM AUTHORITIES;