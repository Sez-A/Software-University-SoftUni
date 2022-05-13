CREATE SCHEMA taxi_company;

use taxi_company;

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE drivers (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
age INT NOT NULL,
rating FLOAT DEFAULT 5.5
);

CREATE TABLE cars (
id INT PRIMARY KEY AUTO_INCREMENT,
make VARCHAR(20) NOT NULL,
model VARCHAR(20),
`year` INT DEFAULT 0 NOT NULL,
mileage INT DEFAULT 0,
`condition` CHAR NOT NULL,
category_id INT NOT NULL, 
CONSTRAINT fk_cars_categories FOREIGN KEY (category_id)
REFERENCES categories(id)
);

CREATE TABLE courses(
id INT PRIMARY KEY AUTO_INCREMENT,
from_address_id INT NOT NULL,
`start` DATETIME NOT NULL,
bill DECIMAL(10,2) DEFAULT 10,
car_id INT NOT NULL,
client_id INT NOT NULL,

CONSTRAINT fk_courses_addresses FOREIGN KEY (from_address_id)
REFERENCES addresses(id),
CONSTRAINT fk_courses_cars FOREIGN KEY (car_id)
REFERENCES cars(id),
CONSTRAINT fk_courses_clients FOREIGN KEY (client_id)
REFERENCES clients(id)
);

CREATE TABLE cars_drivers(
car_id INT NOT NULL,
driver_id INT NOT NULL,
CONSTRAINT fk_cars_drivers_cars FOREIGN KEY (car_id)
REFERENCES cars(id),
CONSTRAINT fk_cars_drivers_drivers FOREIGN KEY (driver_id)
REFERENCES drivers(id),
PRIMARY KEY(car_id, driver_id)
);

# Problem 2

INSERT INTO clients (`full_name`, `phone_number`)
SELECT  CONCAT_WS(' ', `first_name`, `last_name`) AS full_name, CONCAT_WS('', '(088) 9999' , id * 2) AS phone_number
FROM drivers
WHERE id BETWEEN 10 AND 20;

# Problem 3

UPDATE cars
SET `condition` = 'C' 
WHERE mileage >= 800000 OR mileage IS NULL AND `year` <= 2010 AND `make` NOT LIKE 'Mercedes-Benz';

# Problem 4
DELETE cl, cou
FROM `clients` AS cl
LEFT JOIN `courses` AS cou
ON cl.`id` = cou.`client_id`
WHERE cou.`client_id` IS NULL;

# Problem 5

SELECT make, model, `condition` 
FROM cars
ORDER BY id;

# Problem 6

SELECT first_name, last_name, make, model, mileage
FROM drivers d
JOIN cars_drivers cd ON cd.driver_id = d.id
JOIN cars c ON car_id = c.id
WHERE mileage IS NOT NULL
ORDER BY mileage DESC, first_name;

# Problem 7

SELECT c.id, c.make, c.mileage, COUNT(cou.id) AS count_of_courses,  FORMAT(AVG(bill), 2) AS avg_bill
FROM cars c 
LEFT JOIN courses cou ON c.id = cou.car_id
GROUP BY c.id 
HAVING count_of_courses <> 2
ORDER BY count_of_courses DESC, c.id;

# Problem 8
SELECT 
    full_name,
    COUNT(ca.id) AS count_of_cars,
    SUM(cou.bill) AS total_sum
FROM
    clients AS c
        JOIN
    courses AS cou ON c.id = cou.client_id
        JOIN
    cars AS ca ON ca.id = cou.car_id
GROUP BY c.id
HAVING RIGHT(LEFT(full_name, 2), 1) LIKE 'a'
    AND count_of_cars > 1
ORDER BY full_name;

# Problem 9
SELECT a.`name`, IF(HOUR(c.`start`) BETWEEN 6 AND 20, 'Day', 'Night') AS day_time, c.bill, cli.full_name, ca.make, ca.model, cat.`name` 
FROM 
courses AS c
JOIN addresses AS a ON a.id = c.from_address_id
JOIN clients AS cli ON c.client_id = cli.id
JOIN cars AS ca ON ca.id = c.car_id
JOIN categories AS cat ON ca.category_id = cat.id
ORDER BY c.id;

SELECT COUNT(*), cl.full_name
FROM courses c 
JOIN clients cl ON c.client_id = cl.id
WHERE phone_number LIKE '(803) 6386812'
GROUP BY cl.id;

# Problem 10
DELIMITER $$ 
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INT 
BEGIN
RETURN (SELECT COUNT(*)
FROM courses c 
JOIN clients cl ON c.client_id = cl.id
WHERE phone_number LIKE phone_num
GROUP BY cl.id);
END$$

DELIMITER ;
SELECT udf_courses_by_client ('(803) 6386812') as `count`; 

# Problem 11
DELIMITER $$
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
SELECT a.`name`, cl.full_name AS full_names, IF(bill <= 20, 'Low',IF(bill <= 30, 'Medium','High')) AS level_of_bill, ca.make, ca.`condition`, cat.`name` AS cat_name
FROM addresses AS a
JOIN courses AS cou ON cou.from_address_id = a.id
JOIN clients AS cl ON cou.client_id = cl.id
JOIN cars AS ca ON ca.id = cou.car_id
JOIN categories AS cat ON ca.category_id = cat.id
WHERE a.`name` =  address_name
ORDER BY ca.make, cl.full_name;
END$$

CALL udp_courses_by_address('700 Monterey Avenue');