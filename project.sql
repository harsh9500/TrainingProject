use project;

create table candidate
(
   id integer not null auto_increment,
   name varchar(255) not null, 
   institute varchar(255) not null,
   email varchar(255) not null,
   contact long not null,
   description varchar(255) default "SDE Intern" not null,
   location varchar(255) not null,
   skills varchar(1024) default " ",
   joiningDate date not null,
   feedback varchar(1024) default " ",
   created timestamp DEFAULT CURRENT_TIMESTAMP,
   modified timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key(id)
);


CREATE TABLE history LIKE candidate;

ALTER TABLE history MODIFY COLUMN id integer NOT NULL, 
   DROP PRIMARY KEY, ADD action VARCHAR(8) DEFAULT 'insert' FIRST, 
   ADD revision INT(6) NOT NULL AUTO_INCREMENT AFTER action,
   ADD dt_datetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER revision,
   ADD PRIMARY KEY (revision);
   


CREATE TRIGGER data__ai AFTER INSERT ON candidate FOR EACH ROW
    INSERT INTO history SELECT 'insert', NULL, NOW(), d.* 
    FROM candidate AS d WHERE d.id = NEW.id;

CREATE TRIGGER data__au AFTER UPDATE ON candidate FOR EACH ROW
    INSERT INTO history SELECT 'update', NULL, NOW(), d.*
    FROM candidate AS d WHERE d.id = NEW.id;

CREATE TRIGGER data__bd BEFORE DELETE ON candidate FOR EACH ROW
    INSERT INTO history SELECT 'delete', NULL, NOW(), d.* 
    FROM candidate AS d WHERE d.id = OLD.id;
    
