DROP SCHEMA IF EXISTS mydb;
CREATE SCHEMA IF NOT EXISTS mydb;
USE mydb;

DROP TABLE IF EXISTS park;
CREATE TABLE IF NOT EXISTS park (
  id 		INT NOT NULL AUTO_INCREMENT,
  name 		VARCHAR(45) NOT NULL,
  visitors 	INT NOT NULL,
  location 	VARCHAR(45) NOT NULL,
  max_visitors 	INT NOT NULL,

  INDEX(name),

  PRIMARY KEY (id));


DROP TABLE IF EXISTS worker;
CREATE TABLE IF NOT EXISTS worker (
  id 			INT NOT NULL AUTO_INCREMENT,
  first_name 		VARCHAR(45) NOT NULL,
  last_name 		VARCHAR(45) NOT NULL,
  position 		VARCHAR(45) NOT NULL,
  pasport_number 	INT NOT NULL,
  salary 		DOUBLE NOT NULL,
  permision 		INT NOT NULL,
  park_id 		INT NOT NULL,

  UNIQUE INDEX(pasport_number),
  INDEX(permision),
  INDEX(park_id),

  PRIMARY KEY (id),

  FOREIGN KEY (park_id) REFERENCES park(id));

DROP TABLE IF EXISTS attraction;

CREATE TABLE IF NOT EXISTS attraction (
  id 			INT NOT NULL AUTO_INCREMENT,
  name 			VARCHAR(45) NOT NULL,
  max_visitors 		INT NOT NULL,
  min_permision 	INT NOT NULL,
  has_option_vip 	TINYINT NOT NULL,

  INDEX(name),

  PRIMARY KEY (id));


DROP TABLE IF EXISTS ticket;
CREATE TABLE IF NOT EXISTS ticket(
  id 			INT NOT NULL AUTO_INCREMENT,
  expiration_date 	DATE NOT NULL,
  start_date 		DATE NOT NULL,
  is_vip 		TINYINT NOT NULL,
  attraction_id 	INT NOT NULL,
  price 		DOUBLE NOT NULL,
  park_id 		INT NOT NULL,

  INDEX(park_id),

  PRIMARY KEY (id),

  FOREIGN KEY (park_id) REFERENCES park (id));


DROP TABLE IF EXISTS visitor;
CREATE TABLE IF NOT EXISTS visitor (
  id 			INT NOT NULL AUTO_INCREMENT,
  first_name 		VARCHAR(45) NOT NULL,
  last_name 		VARCHAR(45) NOT NULL,
  ticket_id 		INT NOT NULL,

  INDEX(ticket_id),

  PRIMARY KEY (id),

  FOREIGN KEY (ticket_id) REFERENCES ticket(id));


DROP TABLE IF EXISTS park_attraction;
CREATE TABLE IF NOT EXISTS park_attraction(
  park_id 		INT NOT NULL,
  attraction_id 	INT NOT NULL,

  INDEX(park_id),
  INDEX(attraction_id),

  PRIMARY KEY (park_id, attraction_id),
  
  FOREIGN KEY (park_id) REFERENCES park(id),
  FOREIGN KEY (attraction_id) REFERENCES attraction(id));

DROP TABLE IF EXISTS paydesk;
CREATE TABLE IF NOT EXISTS paydesk (
  id 			INT NOT NULL AUTO_INCREMENT,
  attraction_id 	INT NOT NULL,
  has_ticket 		TINYINT NOT NULL,
  park_id 		INT NOT NULL,

  INDEX(park_id),

  PRIMARY KEY (id),

  FOREIGN KEY (park_id) REFERENCES park(id));

DROP TABLE IF EXISTS show_entertainment;
CREATE TABLE IF NOT EXISTS show_entertainment (
  id 			INT NOT NULL AUTO_INCREMENT,
  description 		VARCHAR(45) NOT NULL,
  park_id 		INT NOT NULL,

  INDEX(park_id),

  PRIMARY KEY (id),

  FOREIGN KEY (park_id) REFERENCES park(id));

