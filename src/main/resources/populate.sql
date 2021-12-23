USE mydb;

INSERT INTO attraction (name, max_visitors, min_permision, has_option_vip) VALUES
("Devil ring", 1000, 100, 0),
("Fortune train", 1000, 100, 0),
("Plane", 1000, 100, 0),
("Racer track", 1000, 100, 0),
("Hourse race", 1000, 100, 0),
("Astro Orbiter", 1000, 100, 0),
("The Barnstormer", 1000, 100, 0),
("Big Thunder Mountain Railroad", 1000, 100, 0),
("Cinderella Castle", 1000, 100, 0),
("Dumbo the Flying Elephant", 1000, 100, 0);

INSERT INTO park (name, visitors, location, max_visitors) VALUES 
("Visokiy", 100, "Lviv", 1000),
("Disney", 1000, "Washington", 100),
("Tylonskiy", 500, "Kyiv", 1000),
("First", 200, "Kyiv", 1000),
("Rock", 600, "Kharkiv", 1000),
("Disney", 300, "Munich", 1000),
("Disney", 300, "Rome", 1000),
("Disney", 300, "Amsterdam", 1000),
("Disney", 300, "San Francisco", 1000),
("Disney", 300, "London", 1000);

INSERT INTO show_entertainment (description, park_id) VALUES
("kids show", 1),
("animal dance", 1),
("quiz show", 1),
("dance show", 1),
("tip", 1),
("rank", 1),
("rap", 1),
("ring", 1),
("pior", 1),
("tiop", 1);


INSERT INTO park_attraction (park_id, attraction_id) VALUES 
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10);


INSERT INTO worker (first_name, last_name, position, passport_number, salary, permision, park_id) VALUES
("Ayana", "Downes", "owner", 96844473, 1000.0, 5, 1),
("Pixie", "Ramsay", "fixer", 95432345, 500.0, 4, 1),
("Hamish", "Macleod", "fixer", 95433346, 500.0 , 4, 1),
("Francesco", "Harrington", "fixer", 95432346, 500.0, 4, 1),
("Savanna", "Turner", "casher", 95432347, 500.0, 3, 1),
("Kaia", "Hogg", "casher", 95432348, 500.0, 3, 1),
("Tomas", "Mcfarlane", "casher", 95432349, 500.0, 3, 1),
("Darrell", "Bernard", "casher", 95432350, 500.0, 3, 1),
("Huw", "Rivera", "animator", 95432351, 500.0, 2, 1),
("Harriet", "Griffiths", "animator", 95432352, 500.0, 2, 1);

INSERT INTO paydesk (attraction_id, has_ticket, park_id) VALUES
(1, 1, 1),
(2, 1, 1),
(3, 1, 1),
(4, 0, 1),
(5, 0, 1),
(6, 0, 1),
(7, 0, 1),
(8, 1, 1),
(9, 1, 1),
(10, 1, 10);

INSERT INTO ticket (expiration_date, start_date, is_vip, price, park_attraction_id) VALUES 
("2021-09-29", "2021-09-30", 1 , 200, 1),
("2021-09-29", "2021-09-30", 1 , 200, 2),
("2021-09-29", "2021-09-30", 1 , 200, 3),
("2021-09-29", "2021-09-30", 1 , 200, 4),
("2021-09-29", "2021-09-30", 1 , 200, 5),
("2021-09-29", "2021-09-30", 1 , 200, 1),
("2021-09-29", "2021-09-30", 1 , 200, 1),
("2021-09-29", "2021-09-30", 1 , 200, 1),
("2021-09-29", "2021-09-30", 1 , 200, 1),
("2021-09-29", "2021-09-30", 1 , 200, 1);

INSERT INTO visitor (first_name, last_name, ticket_id) VALUES
("Isabell", "Duggan", 1),
("Philip", "Clayton", 2),
("Abbas", "Ryan", 3),
("Kia", "Mcfarlane", 4),
("Amba", "Naylor", 5),
("Ann", "Kay", 6),
("Aalia", "Werner", 7),
("Keir", "Merritt", 8),
("Kairon", "Waters", 9),
("Halima", "Massey", 3);
