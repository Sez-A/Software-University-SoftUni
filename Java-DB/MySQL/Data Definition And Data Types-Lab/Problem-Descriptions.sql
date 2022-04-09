# Problem 1
CREATE TABLE  `employees` (
 `id` INT PRIMARY KEY AUTO_INCREMENT,
 `first_name` VARCHAR(45) NOT NULL,
 `last_name` VARCHAR(45) NOT NULL
); 

CREATE TABLE `categories` (
 `id` INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(45) NOT NULL
);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL 
);

ALTER TABLE `products`
ADD COLUMN `category_id` INT NOT NULL;

# Problem 2
INSERT INTO `employees`
(`first_name`,`last_name`) 
VALUES
('Sezgin', 'Beyhanov');

INSERT INTO `employees` 
(`first_name`, `last_name`)
VALUES
('Asen', 'Asenov'),
('Lee', 'Davidson');

# Problem 3
ALTER TABLE `employees` 
ADD COLUMN `middle_name` VARCHAR(45);

# Problem 4
ALTER TABLE `products`
ADD CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`);

# Problem 5
ALTER TABLE `employees`
CHANGE COLUMN `middle_name` `middle_name` VARCHAR(100);
