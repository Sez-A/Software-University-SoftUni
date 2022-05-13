CREATE SCHEMA fsd;

USE fsd;

# Problem 1

CREATE TABLE `countries` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`country_id` INT NOT NULL,
CONSTRAINT fk_towns_countries  FOREIGN KEY (`country_id`)
REFERENCES countries(`id`)
);

CREATE TABLE `stadiums` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`capacity` INT NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_stadiums_towns  FOREIGN KEY (`town_id`)
REFERENCES towns(`id`)
);

CREATE TABLE `teams` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`established` DATE NOT NULL,
`fan_base` BIGINT NOT NULL DEFAULT 0,
`stadium_id` INT NOT NULL,
CONSTRAINT fk_teams_stadiums  FOREIGN KEY (`stadium_id`)
REFERENCES stadiums(`id`)
);

CREATE TABLE `skills_data` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`dribbling` INT DEFAULT 0,
`pace` INT DEFAULT 0,
`passing` INT DEFAULT 0,
`shooting` INT DEFAULT 0,
`speed` INT DEFAULT 0,
`strength` INT DEFAULT 0
);

CREATE TABLE `coaches` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`coach_level` INT NOT NULL DEFAULT 0
);

CREATE TABLE `players` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`age` INT NOT NULL DEFAULT 0,
`position` CHAR NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`hire_date` DATETIME,
`skills_data_id` INT NOT NULL,
`team_id` INT,
CONSTRAINT fk_players_skills_data FOREIGN KEY (`skills_data_id`)
REFERENCES skills_data(`id`),
CONSTRAINT fk_players_teams FOREIGN KEY (`team_id`)
REFERENCES teams(`id`)
);

CREATE TABLE `players_coaches`(
`player_id` INT,
`coach_id` INT,
PRIMARY KEY(`player_id`, `coach_id`),
CONSTRAINT fk_players_coaches_players FOREIGN KEY (`player_id`)
REFERENCES players(`id`),
CONSTRAINT fk_players_coaches_coaches  FOREIGN KEY (`coach_id`)
REFERENCES coaches(`id`)
);

# Problem 2
INSERT INTO `coaches`(`first_name`, `last_name`, `salary`,`coach_level`)
SELECT `first_name`, `last_name`, (2 * `salary`), char_length(`first_name`) FROM `players` 
WHERE `age` >= 45;

# Problem 3
SET SQL_SAFE_UPDATES = 0;

UPDATE `coaches` c
JOIN `players_coaches` ps ON ps.`coach_id` = c.`id`
SET c.`coach_level` = (c.`coach_level` + 1)
WHERE ps.`player_id` IS NOT NULL AND LEFT(c.`first_name`, 1) LIKE 'A%';

# Problem 4
DELETE FROM `players`
WHERE `age` >= 45;

# Problem 5

SELECT `first_name`, `age`, `salary` 
FROM `players`
ORDER BY `salary` DESC;

# Problem 6
SELECT p.`id`, CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`, `age`, `position`, `hire_date`
FROM `players` AS p
JOIN `skills_data` AS sd ON `skills_data_id` = sd.`id` 
WHERE `age` < 23 AND `hire_date` IS NULL AND `position` LIKE 'A' AND `strength` > 50
ORDER BY `salary`, `age`; 

# Problem 7
SELECT t.`name` AS `team_name`, t.`established`, t.`fan_base`, COUNT(p.`id`) AS `players_count`
FROM `teams` AS t
LEFT JOIN `players` AS p ON p.`team_id` = t.`id`
GROUP BY t.`id`
ORDER BY `players_count` DESC, `fan_base` DESC;

# Problem 8
SELECT MAX(sd.`speed`) AS `max_speed`, town.`name` AS `town_name`
FROM `skills_data` AS sd
RIGHT JOIN `players` AS p ON p.`skills_data_id` = sd.`id`
RIGHT JOIN `teams` AS t ON p.`team_id` = t.`id`
RIGHT JOIN `stadiums` AS s ON t.`stadium_id` = s.`id`
RIGHT JOIN `towns` AS town ON s.`town_id` = town.`id`
WHERE t.`name` <> 'Devify'
GROUP BY town.`id`
ORDER BY `max_speed` DESC, town.`name`;

# Problem 9
SELECT c.`name`, COUNT(p.`id`) AS `total_count_of_players`, SUM(p.`salary`) AS `total_sum_of_salaries`
FROM `countries` AS c 
LEFT JOIN `towns` AS town ON town.`country_id` = c.`id`
LEFT JOIN `stadiums` AS s ON s.`town_id` = town.`id`
LEFT JOIN `teams` AS te ON te.`stadium_id` = s.`id`
LEFT JOIN `players` AS p ON p.`team_id` = te.`id`
GROUP BY c.`id`
ORDER BY `total_count_of_players` DESC, c.`name`;

# Problem 10
DELIMITER $$

CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30)) 
RETURNS VARCHAR(30)
BEGIN
RETURN (SELECT COUNT(p.`id`)
FROM `players` AS p 
JOIN `teams` AS t ON p.`team_id` = t.`id`
JOIN `stadiums` AS s ON t.`stadium_id` = s.`id`
WHERE s.`name` = `stadium_name`);
END $$

DELIMITER ;
SELECT udf_stadium_players_count ('Jaxworks') as `count`; 

# Problem 11
DELIMITER $$ 
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN
SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`, `age`, `salary`, sk.`dribbling`, sk.`speed`, t.`name`
FROM `players` AS p
JOIN `skills_data` sk ON p.`skills_data_id` = sk.`id`
JOIN `teams` AS t ON p.`team_id` = t.`id`
WHERE sk.`dribbling` > min_dribble_points AND t.`name` = team_name AND sk.`speed` > (SELECT AVG(`speed`)
FROM `skills_data` sk1 
JOIN `players` AS p ON p.`skills_data_id` = sk1.`id`
WHERE p.`team_id` = t.id)
ORDER BY sk.`speed` DESC 
LIMIT 1;
END$$

DELIMITER ;
CALL udp_find_playmaker (20, 'Skyble');
