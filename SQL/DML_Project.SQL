
INSERT INTO Members (first_name, last_name, email, phone, join_date, credit_card_balance) 
VALUES 
('Krist', 'Loth', 'kristloth@gmail.com', '613-233-4456', '2021-06-01', '1000'),
('Lilly', 'Blake', 'lillyblake@gmail.com', '613-523-1234', '2022-06-11', '1000'),
('Ben', 'Flore', 'benflore@gmail.com', '613-618-9823', '2023-01-17', '1000'),
('James', 'Potter', 'jamespotter@gmail.com', '613-555-5129', '2024-06-19', '1000');




INSERT INTO Trainers (first_name, last_name, email, phone) 
VALUES 
('Kevin', 'Cheng', 'kevincheng@gmail.com', '613-431-4289'),
('Dawson', 'Mills', 'dawsonmills@gmail.com', '613-923-4121'),
('Dan', 'Ryder', 'danryder@gmail.com', '613-825-3120');



INSERT INTO Dashboard (first_name, last_name, goals, achievements, active_time) 
VALUES 
('Krist', 'Loth', 'build back muscle', 'ab workout', 60),
('Lilly', 'Blake', 'become more toned', 'lose 5 pounds', 0),
('Ben', 'Flore', 'lose 15 pounds', 'made a meal plan', 0),
('Mere', 'Flow', 'merethon training', 'built running schedule', 120);



INSERT INTO Schedule (trainer_name, member_name, available_date, workout_time, room_number) 
VALUES 
('Kevin', NULL, '2023-02-07', NULL, '101'),
('Dawson', NULL,'102', '2023-02-07', NULL, '102'),
('Dan', NULL,'103', '2023-02-07', NULL, '103');



INSERT INTO Rooms (trainer_name, room_number, workout_time, status, maintenance) 
VALUES 
('Kevin', '101', NULL, 'room pending', 'cleaned'),
('Dawson', '102', NULL, 'room pending', 'cleaned'),
('Dan', '103', NULL, 'room pending', 'cleaned');



INSERT INTO Payment (first_name, last_name, fee_type, amount) 
VALUES 
('Krist', 'Loth', 'new membership', 100),
('Lilly', 'Blake', 'new membership', 100),
('Ben', 'Flore', 'new membership', 100),
('James', 'Potter', 'new membership', 100);



