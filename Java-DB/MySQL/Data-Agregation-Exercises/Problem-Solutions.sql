USE  gringotts;

# Problem 1
SELECT COUNT(`id`) FROM `wizzard_deposits`;

# Problem 2
SELECT MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM `wizzard_deposits`;

# Problem 3
SELECT `deposit_group`, MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `longest_magic_wand`, `deposit_group`;

# Problem 4
SELECT `deposit_group`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
HAVING (SELECT AVG(MIN(`magic_wand_size`)))
LIMIT 1;

# Problem 5
SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;

# Problem 6
SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;

# Problem 7
SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

# Problem 8
SELECT `deposit_group`, `magic_wand_creator`, MIN(`deposit_charge`) AS `min_deposit_charge`
FROM `wizzard_deposits`
GROUP BY `deposit_group`,`magic_wand_creator`
ORDER BY `magic_wand_creator`, `deposit_group`;

# Problem 9
SELECT 
IF(`age` >= 0 AND `age` <= 10 , '[0-10]',  
IF (`age` >= 11 AND `age` <= 20, '[11-20]',
 IF(`age` >= 21 AND `age` <= 30, '[21-30]',
 IF (`age` >= 31 AND `age` <= 40, '[31-40]',
 IF (`age` >= 41 AND `age` <= 50, '[41-50]',
 IF (`age` >= 51 AND `age` <= 60, '[51-60]',
 '[61+]')))))

) AS `age_group`
,COUNT(*) `wizard_count`
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `wizard_count`;

# Problem 10
SELECT LEFT(`first_name`,1) AS `first_letter`
FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
 GROUP BY `first_letter`
 ORDER BY `first_letter`;
 
# Problem 11
SELECT `deposit_group`,`is_deposit_expired`, AVG(`deposit_interest`) AS `average_interest`
FROM `wizzard_deposits`
WHERE `deposit_start_date` > '1985-01-01'
GROUP BY `deposit_group`, `is_deposit_expired`
ORDER BY `deposit_group` DESC, `is_deposit_expired`;

USE soft_uni;

# Problem 12
SELECT `department_id`, MIN(`salary`) AS `minimum_salary`
FROM `employees` 
WHERE `department_id` IN(2,5,7) AND `hire_date` > '2000-01-01'
GROUP BY `department_id` 
ORDER BY `department_id`;

# Problem 13
CREATE TABLE `high_paid_employees`  AS
SELECT * FROM `employees`
WHERE `salary` > 30000;

DELETE FROM `high_paid_employees`
WHERE `manager_id` = 42;

UPDATE `high_paid_employees` 
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

SELECT `department_id`, AVG(`salary`) AS `average_salary`
FROM `high_paid_employees`
GROUP BY `department_id` 
ORDER BY `department_id`;

# Problem 14
SELECT `department_id`, MAX(`salary`) `max_salary`
FROM `employees`
GROUP BY `department_id`
HAVING `max_salary` < 30000 OR `max_salary` > 70000
ORDER BY `department_id`;

# Problem 15
SELECT COUNT(*) AS `count`
FROM `employees`
WHERE `manager_id` IS NULL;

# Problem 16
SELECT `department_id`, 
(SELECT DISTINCT `e2`.`salary` 
FROM `employees` AS `e2` 
WHERE `e2`.`department_id` = `e`.`department_id` 
ORDER BY `e2`.`salary` DESC
LIMIT 2,1) AS `third_highest_salary`
FROM `employees` AS `e`
GROUP BY `department_id`
HAVING `third_highest_salary` IS NOT NULL
ORDER BY `department_id`;

# Problem 17
SELECT `first_name`, `last_name`, `department_id`
FROM `employees` AS `e`
WHERE `e`.`salary` > (SELECT AVG(salary)
FROM `employees` AS `e2`
WHERE `e`.`department_id` = `e2`.`department_id`
GROUP BY `department_id`)
ORDER BY `department_id`, `employee_id`
LIMIT 10;

# Problem 18
SELECT `department_id`,SUM(`salary`) AS `total_salary`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;
