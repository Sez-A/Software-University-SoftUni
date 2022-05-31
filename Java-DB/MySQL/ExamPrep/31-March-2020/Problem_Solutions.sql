CREATE SCHEMA instd;
USE instd;

# Problem 1

CREATE TABLE `users`(
`id` INT PRIMARY KEY,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(30) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`gender` CHAR NOT NULL,
`age` INT NOT NULL,
`job_title` VARCHAR(40) NOT NULL,
`ip` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address` VARCHAR(30) NOT NULL,
`town` VARCHAR(30) NOT NULL,
`country` VARCHAR(30) NOT NULL,
`user_id` INT NOT NULL,
CONSTRAINT `fk_addresses_users` FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`)
);

CREATE TABLE `photos`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`description` TEXT NOT NULL, 
`date` DATETIME NOT NULL,
`views` INT DEFAULT 0 NOT NULL
);

CREATE TABLE `comments` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT `fk_comments_photos` FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);

CREATE TABLE `users_photos` (
`user_id` INT NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT `fk_users_photos_users` FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),
CONSTRAINT `fk_users_photos_photos` FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);

CREATE TABLE `likes` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`photo_id` INT,
`user_id` INT,
CONSTRAINT `fk_likes_users` FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),
CONSTRAINT `fk_likes_photos` FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);

# Problem 2

INSERT INTO `addresses` (`address`, `town`, `country`, `user_id`)
SELECT `username`, `password`, `ip`, `age`
FROM `users`
WHERE `gender` = 'M';


# Problem 3

UPDATE `addresses` 
SET 
    `country` = CASE
        WHEN LEFT(`country`, 1) = 'B' THEN 'Blocked'
        WHEN LEFT(`country`, 1) = 'T' THEN 'Test'
        WHEN LEFT(`country`, 1) = 'P' THEN 'In Progress'
    END
WHERE
    LEFT(`country`, 1) IN ('B' , 'T', 'P');
    
# Problem 4

DELETE FROM `addresses` 
WHERE (`id` % 3) = 0;

# Problem 5

SELECT `username`, `gender`, `age`
FROM `users`
ORDER BY `age` DESC, `username`;

# Problem 6

SELECT p.`id`, p.`date`, p.`description`, COUNT(c.`id`) AS `commentsCount`
FROM `photos` AS p
JOIN `comments` AS c ON c.`photo_id` = p.`id`
GROUP BY p.`id`
ORDER BY `commentsCount` DESC, p.`id`
LIMIT 5; 

# Problem 7

SELECT CONCAT_WS(' ', u.`id`, u.`username`) AS `id_username`, u.`email`
FROM `users` u
JOIN `users_photos` AS up ON u.`id` = up.`user_id`
JOIN `photos` AS p ON up.`photo_id` = p.`id`
WHERE u.`id` = p.`id`
ORDER BY u.`id`;

# Problem 8
SELECT p.`id` AS `photo_id`,
(SELECT COUNT(l.`id`) FROM `likes` l JOIN `photos` p1 ON p1.`id` = l.`photo_id` WHERE p1.`id` = p.`id`) AS `likes_count`,
 (SELECT COUNT(c.`id`) FROM `comments` c JOIN `photos` p2 ON p2.`id` = c.`photo_id` WHERE p.`id` = p2.`id`) AS `comments_count`
FROM `photos` p
ORDER BY `likes_count` DESC, `comments_count` DESC, p.`id`;

# Problem 9

SELECT `description` AS `summary`, `date`
FROM `photos`
WHERE DAY(`date`) = 10 AND char_length(`description`) > 30
ORDER BY `date` DESC;

# Problem 10

DELIMITER $$ 
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30)) 
RETURNS INT 
BEGIN
RETURN (SELECT COUNT(up.`photo_id`) 
FROM `users_photos` AS up
JOIN `users` u ON up.`user_id` = u.`id`
WHERE u.`username` = username);
END$$

DELIMITER ;
SELECT udf_users_photos_count('ssantryd') AS photosCount;

# Problem 11
DELIMITER $$
CREATE PROCEDURE udp_modify_user (address_param VARCHAR(30), city VARCHAR(30)) 
BEGIN
UPDATE `users` AS u
JOIN `addresses` ON `user_id` = u.`id`
SET `age` = `age` + 10
WHERE `address` = address_param AND `town` = city;
END$$

DELIMITER ;
CALL udp_modify_user ('97 Valley Edge Parkway', 'Divinópolis');
SELECT u.username, u.email,u.gender,u.age,u.job_title FROM users AS u
WHERE u.username = 'eblagden21';



