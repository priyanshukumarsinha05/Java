CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE Student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    grade DOUBLE
);

INSERT INTO Student VALUES (1, 'Alice', 85.5);