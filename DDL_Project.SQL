CREATE TABLE Members (
    member_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(15),
    join_date DATE DEFAULT CURRENT_DATE,
    credit_card_balance INT 
);


CREATE TABLE Trainers (
    trainer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);



CREATE TABLE Dashboard (
    member_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    goals TEXT,
    achievements TEXT,
    active_time INT 


);


CREATE TABLE Schedule (
    trainer_name VARCHAR(255), 
    member_name VARCHAR(255),
    available_date DATE DEFAULT CURRENT_DATE,
    workout_time VARCHAR(255),
    room_number INT
    
    
);

CREATE TABLE Rooms (
    trainer_name VARCHAR(255),
    room_number INT, 
    workout_time VARCHAR(255),
    status VARCHAR(255),
    maintenance VARCHAR(255)
);



CREATE TABLE Payment (
    member_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    fee_type VARCHAR(255) NOT NULL, 
    amount INT 
);