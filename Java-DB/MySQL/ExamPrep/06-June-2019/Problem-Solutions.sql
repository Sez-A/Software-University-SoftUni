CREATE SCHEMA ruk_db;

USE ruk_db;

# Problem 1
CREATE TABLE `branches` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10, 2) NOT NULL,
`started_on` DATE NOT NULL,
`branch_id` INT NOT NULL,
CONSTRAINT fk_employees_branches FOREIGN KEY (`branch_id`)
REFERENCES `branches`(`id`)
);

CREATE TABLE `clients` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`full_name` VARCHAR(50) NOT NULL,
`age` INT NOT NULL
);

CREATE TABLE `employees_clients` (
`employee_id` INT,
`client_id` INT, 
CONSTRAINT fk_employees_clients_employees FOREIGN KEY (`employee_id`)
REFERENCES `employees`(`id`),
CONSTRAINT fk_employees_clients_clients FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `bank_accounts` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`account_number` VARCHAR(10) NOT NULL,
`balance` DECIMAL(10, 2) NOT NULL,
`client_id` INT NOT NULL UNIQUE,
CONSTRAINT fk_bank_accounts_clients FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `cards` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`card_number` VARCHAR(19) NOT NULL,
`card_status` VARCHAR(7) NOT NULL,
`bank_account_id` INT NOT NULL,
CONSTRAINT fk_cards_bank_accounts FOREIGN KEY (`bank_account_id`)
REFERENCES `bank_accounts`(`id`)
);

# Problem 2
INSERT INTO `cards`(`card_number`, `card_status`, `bank_account_id`)
SELECT REVERSE(`full_name`), 'Active', `id` FROM `clients`
WHERE `id` BETWEEN 191 AND 200;

# Problem 3 
UPDATE employees_clients
SET employee_id =  (SELECT employee_id
FROM `employees_clients`
GROUP BY `employee_id`
ORDER BY COUNT(`client_id`), `employee_id`
LIMIT 1)
WHERE `employee_id` = `client_id`;

# Problem 4
DELETE emp, emcl
FROM `employees` AS emp
LEFT JOIN `employees_clients` AS emcl
ON emp.`id` = emcl.`employee_id`
WHERE emcl.`client_id` IS NULL;

# Problem 5

SELECT `id`, `full_name`
FROM `clients`
ORDER BY `id`;


# Problem 6
SELECT `id`, CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`, CONCAT('$', `salary`) AS `salary`, `started_on` 
FROM `employees`
WHERE `salary` > 100000 AND `started_on` > '2018-01-01'
ORDER BY `salary` DESC, `id`;

# Problem 7
SELECT c.`id`, CONCAT_WS(' : ', `card_number`, `full_name`) AS `card_token`
FROM `cards` AS c
JOIN `bank_accounts` AS ba ON c.`bank_account_id` = ba.`id`
JOIN `clients` AS cl ON ba.`client_id` = cl.`id`
ORDER BY c.`id` DESC;

# Problem 8
SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS `name`, `started_on`, COUNT(`client_id`) AS `count_of_clients`
FROM `employees` AS e
JOIN `employees_clients` AS ec ON ec.`employee_id` = e.`id`
GROUP BY ec.`employee_id`
ORDER BY `count_of_clients` DESC, `id`
LIMIT 5;

# Problem 9
SELECT b.`name`, COUNT(ca.`id`) as count_of_cards
FROM `branches` as b
LEFT JOIN `employees` as e
ON b.`id`= e.`branch_id`
LEFT  JOIN `employees_clients` as ec
ON e.`id` = ec.`employee_id` 
LEFT JOIN `clients` as c
ON ec.`client_id` = c.`id`
LEFT JOIN `bank_accounts` as ba
ON c.`id` = ba.`client_id`
LEFT JOIN `cards` as ca
ON ba.`id` = ca.`bank_account_id`
GROUP BY b.`name`
ORDER BY `count_of_cards` DESC, b.`name`;

# Problem 10
DELIMITER $$ 
CREATE FUNCTION udf_client_cards_count(`name` VARCHAR(30))
RETURNS INT 
BEGIN
RETURN (SELECT COUNT(ca.`id`) 
FROM `cards` AS ca
JOIN `bank_accounts` AS ba ON ca.`bank_account_id` = ba.`id`
JOIN `clients` AS c ON ba.`client_id` = c.`id`
WHERE c.`full_name` = `name`
GROUP BY c.`id`);
END $$

DELIMITER ;

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';

# Problem 11
DELIMITER $$
CREATE PROCEDURE udp_clientinfo(`name` VARCHAR(255))
BEGIN
SELECT `full_name`, `age`, `account_number`, CONCAT('$',`balance`) AS `balance`
FROM `clients`AS c
JOIN `bank_accounts` ON c.`id` = `client_id`
WHERE `full_name` = `name`;
END$$

DELIMITER ;
CALL udp_clientinfo('Hunter Wesgate');