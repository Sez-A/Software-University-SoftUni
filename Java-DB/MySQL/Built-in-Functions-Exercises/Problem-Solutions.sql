# Problem 1
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE first_name LIKE 'Sa%'
ORDER BY employee_id;

# Problem 2
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

# Problem 3
SELECT `first_name` 
FROM `employees` 
WHERE `department_id` IN (3,10) AND year(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY employee_id;  

# Problem 4
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY employee_id;

# Problem 5
SELECT `name` 
FROM `towns`
WHERE LENGTH(`name`) BETWEEN 5 AND 6
ORDER BY `name`;

# Problem 6
SELECT * FROM `towns`
WHERE `name` LIKE 'M%' OR `name` LIKE 'K%' OR `name` LIKE  'B%' OR `name` LIKE 'E%'
ORDER BY `name`;

# Problem 7
SELECT * FROM `towns`
WHERE `name` NOT LIKE 'R%' AND `name` NOT LIKE 'B%' AND `name` NOT LIKE 'D%'
ORDER BY `name`;

# Problem 8
CREATE VIEW v_employees_hired_after_2000 AS
SELECT `first_name`, `last_name`
FROM `employees`
WHERE year(`hire_date`) > 2000;

SELECT * FROM v_employees_hired_after_2000;

# Problem 9
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE LENGTH(`last_name`) = 5;

# Problem 10
SELECT `country_name`,`iso_code`
 FROM `countries`
 WHERE `country_name` LIKE '%A%A%A%'
 ORDER BY `iso_code`;
 
 # Problem 11
SELECT `peak_name`,`river_name`,
    LOWER(CONCAT(LEFT(`peak_name`,
                        LENGTH(`peak_name`) - 1),
                    `river_name`)) AS `mix`
FROM`peaks`,`rivers`
WHERE
    SUBSTRING(`peak_name`, - 1) LIKE CONCAT(LEFT(river_name, 1), '%')
ORDER BY `mix`;

# Problem 12
SELECT `name`, DATE_FORMAT(`start`,'%Y-%m-%d') AS `start`
FROM `games`
WHERE year(`start`) BETWEEN 2011 AND 2012
ORDER BY `start`, `name`
LIMIT 50;

# Problem 13
SELECT `user_name`, SUBSTRING(`email`, 1 + LOCATE('@',`email`)) AS email
FROM `users`
ORDER BY `email`, `user_name`;

# Problem 14
SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

# Problem 15
SELECT `name`,
 IF (HOUR(`start`) >= 0 AND HOUR(`start`) < 12, 'Morning', IF (HOUR(`start`) < 18, 'Afternoon', 'Evening')) AS `Part of the Day`,
 IF (`duration` <= 3, 'Extra Short',  IF (`duration` <= 6, 'Short', IF(`duration` <= 10, 'Long', 'Extra Long'))) AS `Duration`
 FROM `games`;
 
 # Problem 16
 SELECT `product_name`, `order_date`,
 DATE_ADD(DATE(`order_date`), INTERVAL 3 DAY) AS `pay_due`,
 DATE_ADD(DATE(`order_date`), INTERVAL 1 MONTH) AS `deliver_due`
 FROM orders;


