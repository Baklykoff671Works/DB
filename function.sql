USE kafedra;

DROP function IF EXISTS MaxBirth;
DELIMITER //
CREATE FUNCTION MaxBirth()
RETURNS DATE READS SQL DATA
BEGIN
	RETURN (SELECT MAX(birthday) FROM employee);
END//
DELIMITER ;
SELECT MaxBirth();

DROP function IF EXISTS GetNameFromDiscipline;

DELIMITER //
CREATE FUNCTION GetNameFromDiscipline(disciplineID int)
RETURNS varchar(45) READS SQL DATA
BEGIN
    RETURN (SELECT name FROM acceptance_form WHERE id = ANY(SELECT form FROM discipline where id = disciplineID));
END//
DELIMITER ;

SELECT *,GetNameFromDiscipline(id) FROM discipline;