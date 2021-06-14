CREATE DATABASE schooldb;
USE schooldb;

CREATE TABLE client (
    idClient int primary key auto_increment,
    name varchar(45),
    email varchar(45),
    age int
);

CREATE TABLE product (
    idproduct int primary key auto_increment,
    produs varchar(45),
    quantity int,
    stock int
);

CREATE TABLE orderr (
    irdorderr int primary key auto_increment,
    idClient int,
    idProduct int,
    quantity int
);

ALTER TABLE client auto_increment = 0;
ALTER TABLE product auto_increment = 0;
ALTER TABLE orderr auto_increment = 0;

INSERT INTO client (idClient, name, email, age)
VALUES
(1, 'George', 'geocoblisan@gmail.com', 20),
(2, 'Darius', 'dariuscorpodean@gmail.com', 21),
(3, 'Eduard', 'edipopescu@gmail.com', 20),
(4, 'Andreea', 'andreea@yahoo.com', 26),
(5, 'Raluca', 'raluca@yahoo.com', 19),
(6, 'Andrei', 'andrei@icloud.com', 24);

INSERT INTO product (produs, quantity, stock)
VALUES
('caramida', 50, 100),
('tigla', 20, 60),
('polistiren', 60, 120),
('becuri', 10, 40),
('ciment', 120, 200);


