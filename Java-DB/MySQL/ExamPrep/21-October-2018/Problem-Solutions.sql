CREATE SCHEMA  colonial_journey_management_system_db;

USE colonial_journey_management_system_db;

# Problem 0
CREATE TABLE planets (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE spaceports (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
planet_id INT,
CONSTRAINT fk_spaceports_planets FOREIGN KEY (planet_id)
REFERENCES planets(id)
);

CREATE TABLE spaceships (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
manufacturer VARCHAR(30) NOT NULL,
light_speed_rate INT DEFAULT 0
);

CREATE TABLE colonists (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
ucn CHAR(10) NOT NULL UNIQUE,
birth_date DATE NOT NULL
);

CREATE TABLE journeys (
id INT PRIMARY KEY AUTO_INCREMENT,
journey_start DATETIME NOT NULL,
journey_end DATETIME NOT NULL,
purpose ENUM('Medical','Technical','Educational','Military') NOT NULL,
destination_spaceport_id INT ,
spaceship_id INT,
CONSTRAINT fk_journeys_spaceports FOREIGN KEY (destination_spaceport_id)
REFERENCES spaceports(id),
CONSTRAINT fk_journeys_spaceships FOREIGN KEY (spaceship_id)
REFERENCES spaceships(id)
);

CREATE TABLE travel_cards(
id INT PRIMARY KEY AUTO_INCREMENT,
card_number CHAR(10) NOT NULL UNIQUE,
job_during_journey ENUM('Pilot','Engineer','Trooper','Cleaner','Cook') NOT NULL,
colonist_id INT,
journey_id INT,
CONSTRAINT fk_travel_cards_colonists FOREIGN KEY (colonist_id)
REFERENCES colonists(id),
CONSTRAINT fk_travel_cards_journeys FOREIGN KEY (journey_id)
REFERENCES journeys(id)
);

# Problem 1
INSERT INTO travel_cards(card_number,job_during_journey,journey_id, colonist_id)
SELECT IF(birth_date > '1980-01-01', CONCAT(YEAR(birth_date),DAY(birth_date),LEFT(ucn,4)),CONCAT(YEAR(birth_date),MONTH(birth_date),RIGHT(ucn,4))),
IF((id % 2 = 0 ),'Pilot', IF(id % 3 = 0,'Cook','Engineer')),
LEFT(ucn,1),
id
FROM colonists
WHERE id BETWEEN 96 AND 100;

# Problem 2
 SET SQL_SAFE_UPDATES = 0;
 
UPDATE journeys SET purpose = CASE
    WHEN id % 2 = 0 THEN 'Medical'
    WHEN id % 3 = 0 THEN 'Technical'
    WHEN id % 5 = 0 THEN 'Educational'
    WHEN id % 7 = 0 THEN 'Military'
    ELSE purpose
    END;
    
# Problem 3
DELETE c, tc
FROM colonists AS c
LEFT JOIN travel_cards AS tc
ON c.id = tc.colonist_id
WHERE tc.colonist_id IS NULL;

# Problem 4
SELECT card_number, job_during_journey
FROM travel_cards
ORDER BY card_number;

# Problem 5
SELECT id, CONCAT_WS(' ', first_name, last_name) AS full_name, ucn
FROM colonists     
ORDER BY first_name, last_name, id;

# Problem 6
SELECT id, journey_start, journey_end
FROM journeys
WHERE purpose = 'Military'
ORDER BY journey_start;

# Problem 7
SELECT c.id,  CONCAT_WS(' ', first_name, last_name) AS full_name
FROM colonists AS c
JOIN travel_cards AS tc ON c.id = tc.colonist_id
WHERE job_during_journey = 'Pilot'
ORDER BY id;

# Problem 8
SELECT COUNT(c.id) AS count
FROM colonists AS c
RIGHT JOIN travel_cards AS tc ON c.id = tc.colonist_id
RIGHT JOIN journeys AS j ON tc.journey_id = j.id
WHERE j.purpose = 'Technical';

# Problem 9
SELECT ship.`name` AS spaceship_name, ports.`name` AS spaceport_name
FROM spaceships AS ship
JOIN journeys AS j ON ship.id = j.spaceship_id
JOIN spaceports AS ports ON j.destination_spaceport_id = ports.id
ORDER BY light_speed_rate DESC LIMIT 1;

# Problem 10
SELECT DISTINCT name, manufacturer
FROM spaceships AS ship
 JOIN journeys AS j ON j.spaceship_id = ship.id
 JOIN travel_cards AS tc ON j.id = tc.journey_id
 JOIN colonists AS c ON tc.colonist_id = c.id
WHERE c.birth_date >= '1989-01-01' AND tc.job_during_journey = 'Pilot'
ORDER BY name; 

# Problem 11
SELECT p.`name` AS planet_name, s.`name` AS spaceport_name
FROM planets AS p
JOIN spaceports AS s ON p.id = s.planet_id 
JOIN journeys AS j ON s.id = j.destination_spaceport_id
WHERE purpose = 'Educational'
ORDER BY s.`name` DESC;

# Problem 12
SELECT p.`name` AS planet_name, COUNT(j.id) AS journeys_count
FROM planets AS p
JOIN spaceports AS s ON p.id = s.planet_id 
JOIN journeys AS j ON s.id = j.destination_spaceport_id
GROUP BY p.id 
ORDER BY journeys_count DESC, p.`name`;

# Problem 13
SELECT j.id, p.name, s.name, j.purpose
FROM journeys j 
JOIN spaceports s ON j.destination_spaceport_id = s.id
JOIN planets p ON s.planet_id = p.id
ORDER BY j.journey_end - j.journey_start 
LIMIT 1; 

# Problem 14
SELECT tc.job_during_journey
FROM travel_cards tc
WHERE tc.journey_id =  (
  SELECT j.id
  FROM journeys j
  ORDER BY DATEDIFF(j.journey_end, j.journey_start) DESC
  LIMIT 1
)
GROUP BY tc.job_during_journey
ORDER BY count(tc.job_during_journey)
LIMIT 1;
