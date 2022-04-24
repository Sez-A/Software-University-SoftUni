# Problem 1

CREATE TABLE `mountains`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(45)
);

CREATE TABLE `peaks` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`mountain_id` INT,
CONSTRAINT `fk_mountain_id` 
FOREIGN KEY(`mountain_id`)
REFERENCES `mountains`(`id`)
);

# Problem 2
SELECT v.`driver_id`, v.`vehicle_type`, CONCAT(c.first_name, ' ', c.last_name) AS `driver_name` 
FROM `vehicles` AS `v`
JOIN `campers` AS `c`
ON v.`driver_id` = `c`.`id`;

# Problem 3

SELECT r.`starting_point`, r.`end_point`, r.`leader_id`, CONCAT(c.`first_name`,' ',c.`last_name`) AS `leader_name`
FROM `routes` AS `r`
JOIN `campers` AS `c` 
ON `leader_id` = c.`id`;

# Problem 4

ALTER TABLE `peaks`
ADD CONSTRAINT `fk_peaks_mountians`
FOREIGN KEY (`mountain_id`)
REFERENCES `mountains`(`id`)
ON DELETE CASCADE;

DELETE FROM `mountains` WHERE `id` = 2;

# Problem 5

CREATE TABLE `clients` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(100)
);

CREATE TABLE `projects`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`client_id`INT,
`project_lead_id` INT,
CONSTRAINT `fk_projects_clients` 
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
); 

CREATE TABLE `employees` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`project_id` INT,
CONSTRAINT `fk_employees_projects`
FOREIGN KEY (`project_id`)
REFERENCES `projects`(`id`)
);

ALTER TABLE `projects`
ADD CONSTRAINT `fk_projects_employees`
FOREIGN KEY (`project_lead_id`)
REFERENCES `employees`(`id`);

