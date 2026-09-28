DROP DATABASE IF EXISTS formation;
CREATE DATABASE formation;
USE formation;

CREATE TABLE formation(
   id INT,
   name VARCHAR(50) NOT NULL,
   description TEXT,
   time_ INT NOT NULL,
   type VARCHAR(20) NOT NULL,
   price DECIMAL(4,2) NOT NULL,
   PRIMARY KEY(id)
);
