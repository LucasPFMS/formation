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

INSERT INTO formation VALUES(
1,"JAVA","Java SE 8 : Syntaxe & Poo", 20, "Présentiel",30.21)

INSERT INTO formation VALUES(
2,"JAVA avancé","EXCEPTIONS, fichiers, Jdbc, THREAD ...", 20, "Distantiel",41.95)

INSERT INTO formation VALUES(
3,"Spring","Spring Core/Mvc/Security", 20, "Présentiel",99.57)

INSERT INTO formation VALUES(
4,"Php Frameworks","Symphony", 15, "Distantiel",30.21)

INSERT INTO formation VALUES(
5,"C#","DotNet Core", 20, "Présentiel",32.32)