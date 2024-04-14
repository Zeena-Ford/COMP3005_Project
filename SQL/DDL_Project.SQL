CREATE TABLE Trainers (
    trainer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(20) UNIQUE NOT NULL,
    last_name VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(15)
	
);



CREATE TABLE Dashboard (
    dashboard_id SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL REFERENCES Members(first_name),
    last_name VARCHAR(20) NOT NULL REFERENCES Members(last_name),
    goals TEXT,
    achievements TEXT,
    active_time INT 


);


CREATE TABLE Schedule (
    schedule_id SERIAL PRIMARY KEY,
    trainer_name VARCHAR(20) NOT NULL REFERENCES Trainers(first_name), 
    member_name VARCHAR(20) REFERENCES Members(first_name),
    available_date DATE DEFAULT CURRENT_DATE,
    workout_time VARCHAR(20),
    room_number INT UNIQUE 
    
    
);

CREATE TABLE Rooms (
    room_id SERIAL PRIMARY KEY,
    trainer_name VARCHAR(20) REFERENCES Trainers(first_name),
    room_number INT, 
    workout_time VARCHAR(20),
    status VARCHAR(20),
    maintenance VARCHAR(20)
);



CREATE TABLE Payment (
    payment_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    fee_type VARCHAR(255) NOT NULL, 
    amount INT 
);
