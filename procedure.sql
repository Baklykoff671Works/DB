USE kafedra;

DROP PROCEDURE IF EXISTS InsertEmployee;
DELIMITER $$
CREATE PROCEDURE InsertEmployee(
	first_name  varchar(99),
    name        varchar(99),
    birthday    date,
    passport    varchar(99),
    expirience  int,
    position    int,
    status      int,
    degree      int
)
BEGIN
	INSERT INTO employee(first_name, name, birthday, passport, expirience, position, status, degree)
	VALUES (first_name, name, birthday, passport, expirience, position, status, degree);
END$$
DELIMITER ;

call InsertEmployee('Andriy', 'Zenoviy', date('1961.05.27'), 'UA-876543',  60, 1, 3, 3);

DROP PROCEDURE IF EXISTS InsertEmployeeAndDiscipline;
DELIMITER $$
CREATE PROCEDURE InsertEmployeeAndDiscipline(
	employeeId int,
    disciplineId int
)
BEGIN
	IF EXISTS(SELECT * FROM employee WHERE id = employeeId) 
    AND EXISTS (SELECT * FROM discipline WHERE id = disciplineId)
    AND NOT EXISTS(SELECT * FROM employee_discipline WHERE employee = employeeId AND discipline = disciplineId)
		THEN INSERT INTO employee_discipline(employee,discipline) VALUES (employeeId, disciplineId);
    END IF;
END$$
DELIMITER ;

call InsertEmployeeAndDiscipline(2, 2);
SELECT * FROM employee_discipline;


DROP PROCEDURE IF EXISTS CreateTableByDisciplineNameCursor;
DELIMITER $$
CREATE PROCEDURE CreateTableByDisciplineNameCursor()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE NamePar VARCHAR(45);
    DECLARE DisciplineNameCursor CURSOR FOR
    SELECT name FROM discipline;
    DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET done = TRUE, @seed = 2, @counter = 1;
    OPEN DisciplineNameCursor;
    DisciplineNameCursorLoop: LOOP
        FETCH DisciplineNameCursor INTO NamePar;
        IF done = TRUE THEN LEAVE DisciplineNameCursorLoop;
        END IF;
        SET @counter = 0;
        SET @seed = 1 + RAND();
        SET @seed = ((@seed+RAND())) + @counter;
        select @seed;
        SET @request = CONCAT('CREATE TABLE IF NOT EXISTS ', '`',NamePar,'`', ' (id INT, name VARCHAR(45));');
		PREPARE myQuery FROM @request;
		EXECUTE myQuery;
        label1:WHILE @counter < @seed DO
				IF NOT EXISTS (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = 'kafedra' AND TABLE_NAME = NamePar AND COLUMN_NAME = CONCAT('s',CONVERT(SUBSTRING_INDEX(@seed+@counter,'-',-1),UNSIGNED INTEGER)))
                THEN
					SET @new_table = CONCAT('ALTER TABLE ', '`',NamePar,'`', ' ADD s',CONVERT(SUBSTRING_INDEX(@seed+@counter,'-',-1),UNSIGNED INTEGER),' VARCHAR(45);');
					SELECT @new_table;
					PREPARE my_query FROM @new_table;
					EXECUTE my_query;
                END IF;
                SET @counter = @counter + 1;
            END WHILE;
    END LOOP;
    DEALLOCATE PREPARE myQuery;
CLOSE DisciplineNameCursor;
END$$
DELIMITER ;

call CreateTableByDisciplineNameCursor();
