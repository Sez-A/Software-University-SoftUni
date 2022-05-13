# Problem 1
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000() 
BEGIN
	SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    `salary` > 35000
ORDER BY `first_name` , `last_name` , `employee_id`;
END $$

DELIMITER ;
CALL usp_get_employees_salary_above_35000();

# Problem 2
DELIMITER $$

CREATE PROCEDURE usp_get_employees_salary_above(target DECIMAL(19,4))
BEGIN
	SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    `salary` > target
ORDER BY `first_name` , `last_name` , `employee_id`;
END $$

DELIMITER ;
CALL usp_get_employees_salary_above(45000);

# Problem 3

DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with(start_str VARCHAR(50))
BEGIN
SELECT `name`
FROM `towns`
WHERE `name` LIKE CONCAT(start_str,'%')
ORDER BY `name`;
END $$

DELIMITER ;

CALL usp_get_towns_starting_with('s');

# Problem 4

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
SELECT e.`first_name`, e.`last_name`
FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t
ON a.`town_id` = t.`town_id`
WHERE t.`name` LIKE town_name
ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
END $$

DELIMITER ;
CALL usp_get_employees_from_town('Sofia');

# Problem 5

DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
RETURN (CASE
    WHEN salary < 30000 THEN 'Low'
    WHEN salary <= 50000 THEN 'Average'
    WHEN salary > 50000 THEN 'High'
END);
END $$ 

DELIMITER ;
SELECT ufn_get_salary_level(30000);

# Problem 6

DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(level_of_salary VARCHAR(10))
BEGIN
SELECT `first_name`, `last_name`
FROM `employees`
WHERE ufn_get_salary_level(`salary`) = level_of_salary
ORDER BY `first_name`DESC, `last_name`DESC;
END $$

DELIMITER ;
CALL usp_get_employees_by_salary_level('High');


# Problem 7
-- I only test how regex work in MySQL 
SELECT * FROM `towns`
WHERE  `name` REGEXP '[ofsia]+';

SELECT 'halves'  REGEXP '\\b[ofsia]+\\b';

-- Here I succeeded solve this problem! I'm very proud of myself!!! :) 

DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50)) 
RETURNS INT
DETERMINISTIC
BEGIN 
	DECLARE pattern VARCHAR(60);
    SET pattern = CONCAT('\\b','[',set_of_letters,']+\\b');
 RETURN (SELECT word REGEXP pattern);
END $$

DELIMITER ;
SELECT ufn_is_word_comprised('pppp', 'Guy');

# Problem 8
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name() 
BEGIN
SELECT 
    CONCAT(`first_name`, ' ', `last_name`) AS `full_name`
FROM
    `account_holders`
ORDER BY `full_name` , `id`;
END $$

DELIMITER ;
CALL usp_get_holders_full_name();

DELIMITER $$
CREATE FUNCTION ufn_sum_from_all_accounts() 
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN
RETURN  (SELECT SUM(`balance`)
	FROM accounts
GROUP BY `account_holder_id`);
END $$

DELIMITER ;

# Problem 9

/*
-- I make some test here for reach the result which I want! 
SELECT ah.`id`, ah.`first_name`, ah.`last_name`, a.`account_holder_id`, a.`balance` 
FROM `account_holders` AS ah
JOIN `accounts` AS a
ON ah.`id` = a.`account_holder_id`
WHERE a.`balance` > 7000
GROUP BY a.`account_holder_id`
ORDER BY ah.`id`;

SELECT first_name,account_holder_id,SUM(`balance`) 
FROM accounts AS a
JOIN account_holders AS ah
ON ah.`id` = a.`account_holder_id`
GROUP BY `account_holder_id`;

SELECT SUM(`balance`)
	FROM accounts
GROUP BY `account_holder_id`;

*/
-- Here I reach to the result. 
SELECT  ah.`first_name`, ah.`last_name`
FROM `account_holders` AS ah
JOIN `accounts` AS a
ON ah.`id` = a.`account_holder_id`
GROUP BY a.`account_holder_id`
HAVING  SUM(a.`balance`) > 7000 
ORDER BY ah.`id`;

-- Here is the solution to the problem 
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(target_salary DECIMAL(19,4))
BEGIN
SELECT  ah.`first_name`, ah.`last_name`
FROM `account_holders` AS ah
JOIN `accounts` AS a
ON ah.`id` = a.`account_holder_id`
GROUP BY a.`account_holder_id`
HAVING  SUM(a.`balance`) > target_salary 
ORDER BY ah.`id`;
END $$

DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);


# Problem 10

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DOUBLE, interest DECIMAL(19,4), years INT)
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN
DECLARE total_value DECIMAL(19,4);
SET total_value := initial_sum * POW((1 + interest), years);
RETURN total_value;
END $$

DELIMITER;

SELECT ufn_calculate_future_value(1000, 0.5, 5);

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT, interest DOUBLE)
BEGIN
SELECT a.`id` AS account_id, ah.`first_name`, ah.`last_name`, a.`balance` AS current_balance, 
ufn_calculate_future_value(a.`balance`, interest, 5) AS `balance_in_5_years`
FROM `account_holders` AS ah
JOIN `accounts` AS a
ON ah.`id` = a.`account_holder_id`
WHERE a.`id` = acc_id;
END

DElIMITER ;

CALL usp_calculate_future_value_for_account(1, 0.1);

# Problem 12

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(acc_id INT, money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
IF(money_amount <= 0) THEN ROLLBACK;
ELSE 
UPDATE `accounts` 
SET `balance` = `balance` + money_amount
WHERE `id` = acc_id;
END IF;
END$$

DELIMITER ;
CALL usp_deposit_money(1, 10);

# Problem 13

DELIMITER $$

CREATE PROCEDURE usp_withdraw_money(acc_id INT, money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
	IF money_amount >= (SELECT a.balance FROM accounts AS a WHERE a.id = acc_id) OR money_amount <= 0
		THEN ROLLBACK;
ELSE 
UPDATE `accounts` AS a
SET a.`balance` = a.`balance` - money_amount
WHERE a.`id` = acc_id;
END IF;
END$$

DELIMITER ;

CALL usp_withdraw_money(7, 25);

# Problem 14

DELIMITER $$

CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
IF (SELECT COUNT(a.`id`) FROM `accounts` AS a WHERE a.`id` = from_account_id) <> 1
OR (SELECT COUNT(a2.`id`) FROM `accounts` AS a2 WHERE a2.`id` = to_account_id )<> 1
OR (amount < 0) 
OR amount > (SELECT a3.balance FROM accounts AS a3 WHERE a3.id = from_account_id) 
THEN ROLLBACK;
ELSE 
UPDATE `accounts` 
SET 
    balance = balance - amount
WHERE
    id = from_account_id;
	UPDATE `accounts` 
SET 
    balance = balance + amount
WHERE
    id = to_account_id;
END IF;
END $$



DELIMITER ;

SELECT * FROM `notification_emails`;

CALL usp_transfer_money(1, 2, 10);

# Problem 15

CREATE TABLE `logs`(
`log_id` INT PRIMARY KEY AUTO_INCREMENT,
`account_id` INT,
`old_sum` DECIMAL(19,2),
`new_sum` DECIMAL(19,2)
);

DELIMITER $$

CREATE TRIGGER tr_updated_accounts
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
INSERT INTO `logs`(`account_id`,`old_sum`, `new_sum`)
VALUES(OLD.`id`, OLD.`balance`, NEW.`balance`);
END;

DELIMITER ;

CREATE TABLE `notification_emails`
(`id` INT PRIMARY KEY AUTO_INCREMENT, 
`recipient` INT,
`subject` VARCHAR(500),
`body` VARCHAR(1000)
);

DELIMITER $$
CREATE TRIGGER tr_updated_logs
AFTER INSERT
ON `logs`
FOR EACH ROW
INSERT INTO `notification_emails`(`recipient`,`subject`,`body`)
VALUES(NEW.`account_id`, CONCAT('Balance change for account: ', NEW.account_id),
CONCAT('On ', LEFT(DATE_FORMAT(current_date, "%M"),3), ' ' ,  DATE_FORMAT(current_date, "%d"), ' ',
DATE_FORMAT(CURRENT_DATE, "%Y"), ' ', DATE_FORMAT(CURRENT_TIME, "%r"), ' ', 'your balance was changed from ',NEW.old_sum,' to ',NEW.new_sum,'.' )) $$

DELIMITER ;
DROP TRIGGER tr_updated_logs;

 # DEMO 
#On Sep 15 2016 at 11:44:06 AM your balance was changed from 133 to 143.
SELECT LEFT(DATE_FORMAT("2017-09-15", "%M"),3);

SELECT date(current_date);

SELECT time(current_time);

SELECT 'On Sep 15 2016 at 11:44:06 AM your balance was changed from 133 to 143.';

SELECT CONCAT('On ', LEFT(DATE_FORMAT(current_date, "%M"),3), ' ' ,  DATE_FORMAT(current_date, "%d"), ' ',
DATE_FORMAT(CURRENT_DATE, "%Y"), ' ', DATE_FORMAT(CURRENT_TIME, "%r"), ' ', 'your balance was changed from ',OLD.balance,' to ',NEW.balance,'.' ) AS a;