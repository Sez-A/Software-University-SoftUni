# Problem 1
SELECT `department_id`, COUNT(*) AS `Numbers of employees`
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

# Problem 2
SELECT `department_id`, ROUND(AVG(`salary`), 2)
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

# Problem 3
SELECT `department_id`, MIN(`salary`) AS `Min Salary`
FROM `employees`
GROUP BY `department_id`
HAVING `Min Salary` > 800
ORDER BY `department_id`;

# Problem 4
SELECT COUNT(*) FROM `products`
WHERE `category_id` = 2 AND `price` > 8;

# Problem 5
SELECT `category_id`,
ROUND(AVG(`price`), 2) AS `Average Price`,
ROUND(MIN(`price`), 2) AS `Cheapest Product`,
ROUND(MAX(`price`), 2) AS `Most Expensive Product` 
FROM `products`
GROUP BY `category_id`;