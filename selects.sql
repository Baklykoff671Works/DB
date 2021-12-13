USE labor_sql;

SELECT class, displacement FROM Classes WHERE displacement > 40000 ORDER BY type;

SELECT * FROM trip WHERE TIME(time_in) BETWEEN '17:00:00' AND '23:00:00';

SELECT DISTINCT(t.ID_comp), t.plane, c.name
FROM Trip as t
LEFT JOIN Company as c
ON t.ID_comp = c.ID_comp
WHERE t.plane = 'Boeing';

SELECT DISTINCT(maker) FROM Product WHERE
maker = SOME(SELECT maker FROM Product WHERE type = 'PC') AND maker != ALL(SELECT maker FROM Product WHERE type = 'Laptop');

SELECT DISTINCT(maker) FROM Product 
JOIN PC ON Product.model = PC.model
WHERE type = 'PC' AND speed >= 750;

SELECT date(date) as date FROM Battles;

SELECT AVG(hd)
FROM Product as pr JOIN PC as p ON pr.model = p.model 
WHERE type = 'PC' AND maker = SOME(SELECT maker FROM Product WHERE type = 'PC') AND maker = SOME(SELECT maker FROM Product WHERE type = 'Printer');

SELECT speed, AVG(price) FROM PC
WHERE speed > 600
GROUP BY speed;

SELECT * FROM (SELECT name, numGuns, bore, displacement, type,country, launched, c.class, 
(numGuns = 12) + (bore = 16) + (displacement = 46000) + (type = 'bc') + (country = 'Gt.Britain') + (launched = 1941) + (c.class = 'North Carolina') AS coincidence
FROM ships as s JOIN classes as c ON s.class  = c.class) as res    
WHERE coincidence >= 4;

SELECT name FROM ships WHERE class = name
UNION
SELECT ship as name FROM classes as c, outcomes as o WHERE c.class = o.ship;
