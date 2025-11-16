CREATE DATABASE userdb;
USE userdb;

CREATE TABLE users (
  user_id VARCHAR(50) PRIMARY KEY,
  password VARCHAR(50)
);

INSERT INTO users VALUES ('admin', 'admin123');
