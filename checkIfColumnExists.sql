USE kafedra;

show tables;

desc `math1`;

SHOW COLUMNS FROM `math1` LIKE 's7';

SELECT * 
FROM information_schema.COLUMNS 
WHERE 
    TABLE_SCHEMA = 'kafedra' 
AND TABLE_NAME = 'math1'
AND COLUMN_NAME = 's2';