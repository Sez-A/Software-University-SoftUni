# Problem 1
CREATE TABLE `minions` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45) NOT NULL,
`age` INT NOT NULL
);

CREATE TABLE `towns` (
`town_id` INT AUTO_INCREMENT PRIMARY KEY,
`name` 	VARCHAR(45) NOT NULL
);

# Problem 2
ALTER TABLE `minions` 
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT `fk_minions_towns` 
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`); 

# Problem 3
INSERT INTO `towns` 
			 
VALUES 
(1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna');

INSERT INTO `minions` 
VALUES
(1,'Kevin',22,1),
(2,'Bob',15,3),
(3,'Steward',NULL,2);

# Problem 4
TRUNCATE `minions`;

# Problem 5
DROP TABLE  `minions`;
DROP TABLE `towns`;

# Problem 6
CREATE TABLE `people` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR (200) NOT NULL,
`picture` BLOB,
`height` FLOAT(5,2),
`weight` FLOAT(5,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people` 
(`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)
VALUES
('Ivan',NULL,175,65,'m','2000-01-03',NULL),
('Seza',NULL,NULL,NUll,'m','2000-01-04',"I`m Seza, Hello everyone"),
('Asko',NULL,180,80,'m','2005-05-20',NULL),
('Zu',NULL,NULL,NUll,'f','1995-12-12', 'I`m a Zu'),
('Mimi',NULL,160,40,'f','2010-08-25', NULL);

# Problem 7
CREATE TABLE `users` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users` 
VALUES
(1, 'Seza', 'mypass',NULL,'2021-09-05 15:10:12',false),
(2, 'Asen', 'mypass1',NULL,'2021-08-06 16:30:58',false),
(3, 'Ivan', 'mypass2',NULL,'2010-10-10 10:10:10',true),
(4, 'Zu', 'zuzuzuzu',NULL,'2020-12-12 12:13:14',true),
(5, 'Seli', 'selitoo',NULL,'2015-02-15 23:35:41',false);

# Problem 8
ALTER TABLE `users` 
DROP PRIMARY KEY,
ADD CONSTRAINT 
PRIMARY KEY `users` (`id`,`username`);

# Problem 9
ALTER TABLE `users` 
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP() ;

# Problem 10
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT PRIMARY KEY `users`(`id`);

ALTER TABLE `users` 
ADD CONSTRAINT UNIQUE `users`(`username`);

# Problem 11
CREATE TABLE `directors`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`director_name` VARCHAR(45) NOT NULL,
`notes` TEXT
);

INSERT INTO `directors` 
VALUES 
(1, 'Seza', NULL),
(2, 'Asko', NULL),
(3, 'Fasko', NULL),
(4, 'Jimy', 'I haven`t a notes'),
(5, 'Nqkyv', 'I have a notes');


CREATE TABLE `genres`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`genre_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);

INSERT INTO `genres` 
VALUES 
(1, 'Action', 'I`m a Action'),
(2, 'Comedy', 'I`m a Comedy'),
(3, 'Drama', 'I`m a Drama'),
(4, 'Fantasy', 'I`m a Fantasy'),
(5, 'Horror', 'I`m a Horror');

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`category_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);

INSERT INTO `categories` 
VALUES 
(1, 'Family', 'I`m a Family'),
(2, 'Couple', NULL),
(3, 'Kids', NULL),
(4, 'Popular science', 'I`m a popular science category'),
(5, 'Entertaining', 'I`m a Entertaining');



CREATE TABLE `movies`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`title` VARCHAR(45) NOT NULL,
`director_id` INT,
`copyright_year` DATE,
`length` TIME,
 `genre_id` INT,
 `category_id` INT,
 `rating` FLOAT(3,1),
 `notes` TEXT
);

INSERT INTO `movies` 
VALUES(1, 'The Game Plan',3,'2007-09-28','01:50:00', 2, 1, 7, NULL),
(2, 'My movies ',2,'2021-09-05','02:39:00', 1, 1, NULL, NULL),
(3, 'Third movies ',4,'2019-10-15','01:34:00', 3, 3, 10, NULL),
(4, 'Fourth movies ',2,'2015-03-15','01:32:00', 2, 4, 0, NULL),
(5, 'Fifth movies ',5,'2017-02-15','00:34:00', 1, 3, 5, NULL);

# Problem 12
CREATE TABLE `categories` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`category` VARCHAR(45),
`daily_rate` FLOAT(2,1),
`weekly_rate` FLOAT(2,1),
`monthly_rate` FLOAT(2,1),
`weekend_rate` FLOAT(2,1)
);


INSERT INTO `categories`
VALUES
(1,'SEDAN',5.5,4.5,7,8),
(2,'COUPE',2.5,7.5,NULL,NULL),
(3,'CONVERTIBLE',2.5,2.5,1,5);

# •	cars (id, plate_number, make, model, car_year, category_id, doors, picture, car_condition, available)
CREATE TABLE `cars` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`plate_number` VARCHAR(15),
`make` VARCHAR(45),
`model` VARCHAR(45),
`car_year` DATE,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(45),
`available` BOOLEAN
);

INSERT INTO `cars`
VALUES
(1,'H0530BT','Audi','A3','2001-05-05',2,2,NULL,'Good',true),
(2,'B0535BB','Audi','A6','2012-01-04',1,4,NULL,'Good',true),
(3,'CA5555CA','Mercedes-Benz','CLS','2015-04-25',2,4,NULL,'Good',false);

# •	employees (id, first_name, last_name, title, notes)

CREATE TABLE `employees`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name`VARCHAR(45),
`last_name`VARCHAR(45),
`title`VARCHAR(45),
`notes`TEXT
);

INSERT INTO `employees`
VALUES
(1,'Seza','B','Software-Developer','Hello I`m a Seza'),
(2,'Velko','Velkov','Kick-Boxer','Hello I`m a Velko'),
(3,'Jet','Mee','Student',NULL);

# •	customers (id, driver_licence_number, full_name, address, city, zip_code, notes)
CREATE TABLE `customers` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`driver_licence_number` VARCHAR(15),
`full_name` VARCHAR(100),
`address` VARCHAR(100),
`city` VARCHAR(45),
`zip_code` VARCHAR(100),
`notes` TEXT
);

INSERT INTO `customers`
VALUES
(1,'010501','Seza B','Nqkade v Bg','Varna','Varna zip code',NULL),
(2,'000500','Seli Selito','Nqkade v Eng','London','London zip code','I don`t know :D'),
(3,'123456','Jet Jetov','Nqkade v France','Paris','Paris zip code', NULL);

# •	rental_orders (id, employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end,
# total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes)

CREATE TABLE `rental_orders`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`employee_id` INT,
`customer_id` INT,
`car_id` INT,
`car_condition` VARCHAR(45),
`tank_level` FLOAT(5,2),
`kilometrage_start` FLOAT(8,2),
`kilometrage_end`FLOAT(8,2),
`total_kilometrage`FLOAT(8,2),
`start_date` DATE,
`end_date` DATE,
`total_days` INT,
`rate_applied` FLOAT(3,1),
`tax_rate` DECIMAL,
`order_status` VARCHAR(45),
`notes` TEXT
);

INSERT INTO `rental_orders`
VALUES
(1,1,1,1,'GOOD',100,10,100,100,'2021-09-06','2021-09-06',1,NULL,1.1,'Ordered',NULL),
(2,2,2,2,'GOOD',100,10,100,100,'2021-09-03','2021-09-06',3,NULL,0.7,'Ordered',NULL),
(3,3,3,3,'NOT GOOD',100,10,100,100,'2021-08-03','2021-09-03',30,NULL,0.5,'Ordered',NULL);

# Problem 13
 INSERT INTO `towns`
 VALUES
 (1,'Sofia'),
 (2,'Plovdiv'),
 (3,'Varna'),
 (4,'Burgas');

 INSERT INTO `addresses`
 VALUES
 (1, NULL,1),
 (2, NULL,2),
 (3, NULL,3);

INSERT INTO `departments`
 VALUES
 (1,'Engineering'),
 (2,'Sales'),
 (3,'Marketing'),
 (4,'Software Development'),
 (5,'Quality Assurance');

 INSERT INTO `employees`
 VALUES
 (1,'Ivan','Ivanov','Ivanov','.NET Developer',4,'2013-02-01',3500,NULL),
 (2,'Petar','Petrov','Petrov','Senior Engineer',1,'2004-03-02',4000,NULL),
 (3,'Maria','Petrova','Ivanova','Intern',5,'2016-08-28',525.25,NULL),
 (4,'Georgi','Terziev','Ivanov','CEO',2,'2007-12-09',3000,NULL),
 (5,'Peter','Pan','Pan','Intern',3,'2016-08-28',599.88,NULL);
 
# Problem 14
 SELECT * FROM `towns`;
 SELECT * FROM `departments`;
 SELECT * FROM `employees`;

# Problem 15
SELECT * FROM `towns` ORDER BY `name`;
SELECT * FROM `departments` ORDER BY `name`;
SELECT * FROM `employees` ORDER BY `salary` DESC;

# Problem 16
SELECT `name` FROM `towns` ORDER BY `name`;
 SELECT `name` FROM `departments` ORDER BY `name`;
 SELECT `first_name`,`last_name`,`job_title`,`salary` FROM `employees`	ORDER BY `salary` DESC;
 
# Problem 17
UPDATE `employees`
SET `salary` = `salary` * 1.1;

SELECT `salary`  FROM `employees`;

# Problem 18
TRUNCATE TABLE `occupancies`;