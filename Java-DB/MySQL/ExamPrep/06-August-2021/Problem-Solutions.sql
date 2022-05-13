CREATE SCHEMA `soft_uni_game_db`;

USE `soft_uni_game_db`;

# Problem 1
CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE `offices`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`workspace_capacity` INT NOT NULL,
`website` VARCHAR(50),
`address_id` INT NOT NULL,
CONSTRAINT fk_offices_addresses FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`)
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,	
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`job_title` VARCHAR(20) NOT NULL,
`happiness_level` CHAR NOT NULL
);

CREATE TABLE `teams` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`office_id` INT NOT NULL,
`leader_id` INT NOT NULL UNIQUE,
CONSTRAINT fk_teams_offices FOREIGN KEY (`office_id`)
REFERENCES `offices`(`id`),
CONSTRAINT fk_teams_employees FOREIGN KEY (`leader_id`)
REFERENCES `employees`(`id`)
);

CREATE TABLE `games` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
`description` TEXT,
`rating` FLOAT NOT NULL DEFAULT 5.5,
`budget` DECIMAL(10, 2) NOT NULL,
`release_date` DATE,
`team_id` INT NOT NULL,
CONSTRAINT fk_games_teams FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`)
);

CREATE TABLE `games_categories` (
`game_id` INT NOT NULL,
`category_id` INT NOT NULL,
PRIMARY KEY(`game_id`, `category_id`),
CONSTRAINT fk_games_categories_games FOREIGN KEY (`game_id`)
REFERENCES `games`(`id`),
CONSTRAINT fk_games_categories_categories FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`)
);

# Problem 2

INSERT INTO `games`(`name`,`rating`,`budget`,`team_id`)
SELECT LOWER(REVERSE(RIGHT(`name`, CHAR_LENGTH(`name`) - 1))), `id`, (`leader_id` * 1000), `id` 
FROM `teams`
WHERE `id` BETWEEN 1 AND 9;

# Problem 3
UPDATE `employees` 
SET `salary` = `salary` + 1000
WHERE `age` < 40 AND `salary` < 5000;
SELECT * FROM games
WHERE `category_id` IS NULL AND `release_date` IS NULL;

# Problem 4
DELETE g, gc
FROM `games` AS g
LEFT JOIN `games_categories` AS gc
ON g.`id` = gc.`game_id`
WHERE gc.`game_id` IS NULL AND g.release_date IS NULL;

# Problem 5
SELECT `first_name`, `last_name`, `age`, `salary`, `happiness_level`  FROM `employees`
ORDER BY `salary`, `id`;

# Problem 6
SELECT t.`name` AS `team_name`, a.`name` AS `address_name`, char_length(a.`name`) AS `count_of_characters`
FROM `teams` AS t
JOIN `offices` AS o ON `office_id` = o.`id`
JOIN `addresses` AS a ON o.`address_id` = a.`id`
WHERE o.`website` IS NOT NULL
ORDER BY t.`name`, a.`name`;

# Problem 7

SELECT c.`name`, COUNT(g.`id`) AS `games_count`, ROUND(AVG(g.`budget`), 2) AS `avg_budget`, MAX(g.`rating`) AS `max_rating`
FROM `categories` AS c
JOIN `games_categories` AS gc ON gc.`category_id` = c.`id`
JOIN `games` AS g ON gc.`game_id` = g.`id`
GROUP BY c.`id`
HAVING `max_rating` > 9.4
ORDER BY `games_count` DESC, c.`name`;

# Problem 8
SELECT g.`name`, g.`release_date`, CONCAT_WS('', LEFT(g.`description`, 10), '...') AS `summary`, 
IF(MONTH(g.`release_date`) IN (1,2,3), 'Q1', 
IF(MONTH(g.`release_date`) IN (4,5,6), 'Q2', 
IF(MONTH(g.`release_date`) IN (7,8,9), 'Q3', 'Q4' ))) AS `quarter`,
t.`name` AS `team_name` 
FROM `games` AS g
JOIN `teams` AS t ON g.`team_id` = t.`id`
WHERE RIGHT(g.`name`, 1) = '2' AND (MONTH(g.`release_date`) % 2 = 0) AND YEAR(g.`release_date`) = '2022'
ORDER BY `quarter`;

# Problem 9

SELECT g.`name`, IF(g.`budget` < 50000, 'Normal budget', 'Insufficient budget') AS `budget_level`, t.`name` AS `team_name`, a.`name`  AS `address_name`
FROM `games` AS g
JOIN `teams` AS t ON g.`team_id` = t.`id`
JOIN `offices` AS o ON t.`office_id` = o.`id`
JOIN `addresses` AS a ON o.`address_id` = a.`id`
LEFT JOIN `games_categories` gc ON gc.`game_id` = g.`id`
LEFT JOIN `categories` c ON c.`id` = gc.`category_id`
WHERE gc.`game_id` IS NULL AND g.`release_date` IS NULL
ORDER BY g.`name`;

# Problem 10
DELIMITER $$
CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20)) 
RETURNS VARCHAR(255)
BEGIN
RETURN (SELECT CONCAT_WS(' ', 'The', g.`name`, 'is developed by a', t.`name`,'in an office with an address', a.`name`)
FROM `games` AS g
JOIN `teams` AS t ON g.`team_id` = t.`id`
JOIN `offices` AS o ON t.`office_id` = o.`id`
JOIN `addresses` AS a ON o.`address_id` = a.`id`
WHERE g.`name` = `game_name`);
END $$

DELIMITER ;

SELECT udf_game_info_by_name('Bitwolf') AS info;

# Problem 11
DELIMITER $$
CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
BEGIN
UPDATE `games` AS g 
LEFT JOIN `games_categories` gc ON gc.`game_id` = g.`id`
LEFT JOIN `categories` c ON c.`id` = gc.`category_id`
SET g.`budget` = (g.`budget` + 100000), `release_date` = ADDDATE(`release_date`, INTERVAL 1 YEAR)
WHERE gc.`game_id` IS NULL AND g.`release_date` IS NOT NULL AND g.`rating` > `min_game_rating`;
END$$

CALL udp_update_budget (8);
