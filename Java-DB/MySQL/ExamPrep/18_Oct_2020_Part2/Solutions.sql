CREATE DATABASE `soft_uni_store_system`;
USE `soft_uni_store_system`;

# Problem 1
CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE 
);

CREATE TABLE `pictures`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`url` VARCHAR(100) NOT NULL,
`added_on` DATETIME NOT NULL
);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
`best_before` DATE,
`price` DECIMAL(10,2) NOT NULL,
`description` TEXT,
`category_id` INT NOT NULL,
`picture_id` INT NOT NULL,
CONSTRAINT `fk_products_categories`
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`),
CONSTRAINT `fk_products_pictures` 
FOREIGN KEY (`picture_id`)
REFERENCES `pictures`(`id`)
);

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL 
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT `fk_addresses_towns` 
FOREIGN KEY(`town_id`) 
REFERENCES `towns`(`id`)
);

CREATE TABLE `stores`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`rating` FLOAT NOT NULL,
`has_parking` TINYINT(1),
`address_id` INT NOT NULL,
CONSTRAINT `fk_stores_addresses`
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`)
);

CREATE TABLE `products_stores`(
`product_id` INT NOT NULL,
`store_id` INT NOT NULL,
CONSTRAINT `pk_products_stores`
PRIMARY KEY(`product_id`,`store_id`),
CONSTRAINT `fk_products_stores_products`
FOREIGN KEY (`product_id`)
REFERENCES `products`(`id`),
CONSTRAINT `fk_products_stores_stores`
FOREIGN KEY (`store_id`)
REFERENCES `stores`(`id`)
);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(15) NOT NULL,
`middle_name` CHAR(1),
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(19,2) NOT NULL DEFAULT 0.00,
`hire_date` DATE NOT NULL,
`manager_id` INT,
`store_id` INT NOT NULL,
CONSTRAINT `fk_employees_employees`
FOREIGN KEY (`manager_id`)
REFERENCES `employees`(`id`),
CONSTRAINT `fk_employees_stores`
FOREIGN KEY (`store_id`)
REFERENCES `stores`(`id`)
);

# Problem 2
INSERT INTO `products_stores`(`product_id`, `store_id`)
VALUES
(9,1),
(10,1),
(13,1),
(16,1),
(18,1);

# Problem 3
UPDATE `employees`
SET `manager_id` = 3, `salary` = `salary` - 500
WHERE `store_id` NOT IN(5, 14) AND YEAR(`hire_date`) > 2003;

# Problem 4
DELETE FROM `employees`
WHERE `salary` >= 6000 AND `manager_id` IS NOT NULL;

# Problem 5
SELECT `first_name`, `middle_name`, `last_name`, `salary`, 	`hire_date`
FROM `employees`
ORDER BY `hire_date` DESC;

# Problem 6
SELECT p.`name`, p.`price`, p.`best_before`, CONCAT(LEFT(p.`description`,10), '...') AS `short_description`, pic.`url`
FROM `products` AS p
JOIN `pictures` AS pic
ON p.`picture_id` = pic.`id`
WHERE CHAR_LENGTH(p.`description`) > 100 AND YEAR(pic.`added_on`) < 2019 AND p.`price` > 20
ORDER BY p.`price` DESC;

# Problem 7
SELECT s.`name`, COUNT(p.`name`) AS `product_count`, ROUND(AVG(p.`price`),2) AS `avg`
FROM `stores` AS s
LEFT JOIN `products_stores` AS ps
ON ps.`store_id` = s.`id`
LEFT JOIN `products` AS p
ON ps.`product_id` = p.`id`
GROUP BY s.`id`
ORDER BY `product_count` DESC, `avg` DESC, s.`id`;

# Problem 8
SELECT CONCAT_WS(' ', e.`first_name`, e.`last_name`)  AS `full_name`,
 s.`name` AS `Store_name`, 
 a.`name` AS `address`, 
 e.`salary`
FROM `employees` AS e
JOIN `stores` AS s
ON e.`store_id` = s.`id`
JOIN `addresses` AS a
ON s.`address_id` = a.`id`
WHERE e.`salary` < 4000 AND a.`name` LIKE '%5%' AND CHAR_LENGTH(s.`name`) > 8 AND RIGHT(e.`last_name`, 1) = 'n';

# Problem 9
SELECT 
    REVERSE(s.`name`) AS `reversed_name`,
    CONCAT(UPPER(t.`name`), '-', a.`name`) AS `full_address`,
    (SELECT 
            COUNT(e.`id`)
        FROM
            `employees` AS e
        WHERE
            e.`store_id` = s.`id`) AS `employees_count`
FROM
    `stores` AS s
        JOIN
    `addresses` AS a ON s.`address_id` = a.`id`
        JOIN
    `towns` AS t ON t.`id` = a.`town_id`
WHERE
    (SELECT 
            COUNT(e.`id`)
        FROM
            `employees` AS e
        WHERE
            e.`store_id` = s.`id`) > 0
ORDER BY `full_address`;

# Problem 10
DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50)) 
RETURNS VARCHAR(150)
BEGIN 
 RETURN (SELECT CONCAT_WS(' ',CONCAT(e.`first_name`,' ',e.`middle_name`,'.',' ', e.`last_name`),'works in store for', (2020-YEAR(e.`hire_date`)),'years')
FROM `employees` AS e
JOIN `stores` AS s
ON e.`store_id` = s.`id`
WHERE s.`name` = `store_name`
ORDER BY e.`salary` DESC 
LIMIT 1);
END $$

DELIMITER ;

SELECT UDF_TOP_PAID_EMPLOYEE_BY_STORE('Stronghold');

# Problem 11

DELIMITER $$
CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
CASE 
 WHEN LEFT(`address_name`,1) = 0 THEN 
 UPDATE `products` AS p
JOIN `products_stores` AS ps
ON p.`id` = ps.`product_id`
JOIN `stores` AS s
ON s.`id` = ps.`store_id`
JOIN `addresses` AS a
ON s.`address_id` = a.`id`
SET p.`price` = p.`price` + 100
WHERE a.`name` = `address_name`;
ELSE  UPDATE `products` AS p
JOIN `products_stores` AS ps
ON p.`id` = ps.`product_id`
JOIN `stores` AS s
ON s.`id` = ps.`store_id`
JOIN `addresses` AS a
ON s.`address_id` = a.`id`
SET p.`price` = p.`price` + 200
WHERE a.`name` = `address_name`;
END CASE;
END $$

DELIMITER ;