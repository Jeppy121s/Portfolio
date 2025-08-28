CREATE DATABASE sportsdb;
USE sportsdb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    sport VARCHAR(50) NOT NULL,
    hashed_phone VARCHAR(64) NOT NULL,
    hashed_email VARCHAR(64) NOT NULL
);
