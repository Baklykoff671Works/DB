DROP SCHEMA IF EXISTS mydb ;

CREATE SCHEMA IF NOT EXISTS mydb ;
USE mydb ;

DROP TABLE IF EXISTS park ;
CREATE TABLE IF NOT EXISTS park (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
visitors INT NOT NULL,
location VARCHAR(45) NOT NULL,
max_visitors INT NOT NULL,
PRIMARY KEY (id));

DROP TABLE IF EXISTS worker ;
CREATE TABLE IF NOT EXISTS worker (
id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(45) NOT NULL,
last_name VARCHAR(45) NOT NULL,
position VARCHAR(45) NOT NULL,
passport_number INT UNSIGNED NOT NULL,
salary DOUBLE NOT NULL,
permision INT NOT NULL,
park_id INT NOT NULL,
PRIMARY KEY (id),
INDEX fk_worker_park_idx (park_id ASC) VISIBLE,
CONSTRAINT fk_worker_park
	FOREIGN KEY (park_id)
	REFERENCES park (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);

DROP TABLE IF EXISTS attraction ;
CREATE TABLE IF NOT EXISTS attraction (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
max_visitors INT NOT NULL,
min_permision INT NOT NULL,
has_option_vip TINYINT NOT NULL,
PRIMARY KEY (id));

DROP TABLE IF EXISTS park_attraction ;
CREATE TABLE IF NOT EXISTS park_attraction (
id INT NOT NULL AUTO_INCREMENT,
park_id INT NOT NULL,
attraction_id INT NOT NULL,
INDEX fk_park_attraction_park1_idx (park_id ASC) VISIBLE,
INDEX fk_park_attraction_attraction1_idx (attraction_id ASC) VISIBLE,
PRIMARY KEY (id),
CONSTRAINT fk_park_attraction_park1
	FOREIGN KEY (park_id)
	REFERENCES park (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,
CONSTRAINT fk_park_attraction_attraction1
	FOREIGN KEY (attraction_id)
	REFERENCES attraction (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);

DROP TABLE IF EXISTS ticket ;
CREATE TABLE IF NOT EXISTS ticket (
id INT NOT NULL AUTO_INCREMENT,
expiration_date DATE NOT NULL,
start_date DATE NOT NULL,
is_vip TINYINT NOT NULL,
price DOUBLE NOT NULL,
park_attraction_id INT NOT NULL,
PRIMARY KEY (id),
INDEX fk_ticket_park_attraction1_idx (park_attraction_id ASC) VISIBLE,
CONSTRAINT fk_ticket_park_attraction1
	FOREIGN KEY (park_attraction_id)
	REFERENCES park_attraction (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);

DROP TABLE IF EXISTS visitor ;
CREATE TABLE IF NOT EXISTS visitor (
id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(45) NOT NULL,
last_name VARCHAR(45) NOT NULL,
ticket_id INT NOT NULL,
PRIMARY KEY (id),
INDEX fk_visitor_ticket1_idx (ticket_id ASC) VISIBLE,
CONSTRAINT fk_visitor_ticket1
	FOREIGN KEY (ticket_id)
	REFERENCES ticket (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);

DROP TABLE IF EXISTS paydesk ;
CREATE TABLE IF NOT EXISTS paydesk (
id INT NOT NULL AUTO_INCREMENT,
attraction_id INT NOT NULL,
has_ticket TINYINT NOT NULL,
park_id INT NOT NULL,
PRIMARY KEY (id),
INDEX fk_paydesk_park1_idx (park_id ASC) VISIBLE,
CONSTRAINT fk_paydesk_park1
	FOREIGN KEY (park_id)
	REFERENCES park (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);

DROP TABLE IF EXISTS show_entertainment ;
CREATE TABLE IF NOT EXISTS show_entertainment (
id INT NOT NULL AUTO_INCREMENT,
description VARCHAR(45) NOT NULL,
park_id INT NOT NULL,
PRIMARY KEY (id),
INDEX fk_show_park1_idx (park_id ASC) VISIBLE,
CONSTRAINT fk_show_park1
	FOREIGN KEY (park_id)
	REFERENCES park (id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);
