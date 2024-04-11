
INSERT INTO Members (first_name, last_name, email, phone, join_date, credit_card_balance) 
VALUES 
('Krist', 'Loth', 'cate.loth@example.com', '613-233-4444', '2022-01-01', '1000'),
('Sam', 'Jona', 'sam.jona@example.com', NULL, '2022-01-15', '1000'),
('Mere', 'Flow', 'mere.flow@example.com', '513-555-1234', '2022-06-15', '1000');




INSERT INTO Trainers (first_name, last_name) 
VALUES 
('Michael', 'Smith'),
('Emily', 'Jones'),
('David', 'Brown');



INSERT INTO Dashboard (first_name, last_name, goals, achievements, active_time) 
VALUES 
('Krist', 'Loth', 'Lose 10 lbs', 'Ran 5 miles', '60'),
('Jane', 'Smith', 'Gain muscle mass', 'Increased bench press', '45'),
('Alice', 'Johnson', 'Improve flexibility', 'Completed yoga sessions', '120');



INSERT INTO Schedule (trainer_name, member_name, room_number, workout_time, available_date) 
VALUES 
('Michael', NULL, '101', NULL, '2022-01-01'),
('Emily', NULL,'102', NULL, '2022-01-02'),
('David', NULL,'103', NULL, '2022-01-02');



INSERT INTO Rooms (trainer_name, room_number, workout_time, status, maintenance) 
VALUES 
('Michael', '101', NULL, 'room pending', 'cleaned'),
('Emily', '102', NULL, 'room pending', 'being used'),
('David', '103', NULL, 'room pending', 'being used');



INSERT INTO Payment (first_name, last_name, fee_type, amount) 
VALUES 
('Amy', 'Duncan', 'fitness class', 20);



