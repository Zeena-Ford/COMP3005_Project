CREATE TABLE Members (
    member_id SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(15),
    join_date DATE DEFAULT CURRENT_DATE,
    credit_card_balance INT 
);


CREATE TABLE Trainers (
    trainer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(15),
	
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
    room_number INT,
    
    
);

CREATE TABLE Rooms (
    room_id SERIAL PRIMARY KEY,
    trainer_name VARCHAR(20) REFERENCES Trainers(first_name),
    room_number INT REFERENCES Rooms(room_number), 
    workout_time VARCHAR(20) REFERENCES Schedule(workout_time),
    status VARCHAR(20),
    maintenance VARCHAR(20)
);



CREATE TABLE Payment (
    payment_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL REFERENCES Members(first_name),
    last_name VARCHAR(255) NOT NULL REFERENCES Members(last_name),
    fee_type VARCHAR(255) NOT NULL, 
    amount INT 
);