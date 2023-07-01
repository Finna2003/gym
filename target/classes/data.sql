INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (5, 'Liza', 'Petrova', 'liza@mail.com','$2a$10$CJgEoobU2gm0euD4ygru4ukBf9g8fYnPrMvYk.q0GMfOcIDtUhEwC', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (6, 'Vova', 'Novik', 'vova@mail.com',  '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (4, 'Inna', 'Fisyuk', 'inna@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 1);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (7, 'Ivan', 'Rak', 'ivan@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 1);

INSERT INTO workouts(id, date, level, month, name, price, time, training_time, user_id) VALUES (8, 4, 'BEGINNER', 'JUNE', 'Волейбол', 110, 16, 50, 4);
INSERT INTO workouts(id, date, level, month, name, price, time, training_time, user_id) VALUES (7, 6, 'ADVANCED', 'JUNE', 'Йога', 200, 18, 70, 7);

INSERT INTO registrations(id, user_id, workout_id) VALUES (10, 6, 8);
INSERT INTO registrations(id, user_id, workout_id) VALUES (11, 5, 7);