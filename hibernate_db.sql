DROP SCHEMA IF EXISTS `hb_04_one_to_many_uni`;
CREATE SCHEMA `hb_04_one_to_many_uni`;
USE `hb_04_one_to_many_uni`;

-- FOREIGN_KEY_CHECKS is a system variable. 1 = ON (default), 0 = OFF.
-- This variable checks the foreign keys, and in normal operation we leave it ON.
-- TURNING OFF is usefull when:
--    dropping a table referenced by a foreign key. Such table can be dropped only with FKC = OFF.
--    read more on https://dev.mysql.com/doc/refman/5.6/en/create-table-foreign-keys.html
SET FOREIGN_KEY_CHECKS = 0; -- see ex
DROP TABLE IF EXISTS `hb_04_one_to_many_uni`.`instructor_details`;

CREATE TABLE `hb_04_one_to_many_uni`.`instructor_details` (
	`id` 				INT(11) NOT NULL AUTO_INCREMENT,
    `youtube_channel` 	VARCHAR(128) DEFAULT NULL,
    `hobby` 			VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS `hb_04_one_to_many_uni`.`instructor`;

CREATE TABLE `hb_04_one_to_many_uni`.`instructor` (
	`id` 					INT(11) 	NOT NULL AUTO_INCREMENT,
    `first_name` 			VARCHAR(45) DEFAULT NULL,
    `last_name` 			VARCHAR(45) DEFAULT NULL,
    `email` 				VARCHAR(45) DEFAULT NULL,
	`instructor_details_id` INT(11) 	DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_DETAIL_idx` (`instructor_details_id`),
    CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_details_id`)
		REFERENCES `hb_04_one_to_many_uni`.`instructor_details` (`id`)
        ON DELETE NO ACTION										 -- we can manage CASCADE through Hibernate
        ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `hb_04_one_to_many_uni`.`courses`;

CREATE TABLE `hb_04_one_to_many_uni`.`courses` (
	`id` 			INT(11) 		NOT NULL AUTO_INCREMENT,
    `title` 		VARCHAR(128) 	DEFAULT NULL,
    `instructor_id` INT(11) 		DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`title`),			-- forbids dublicates AND creates Key
    KEY `INSTRUCTOR_ID_idx` (`instructor_id`),
    CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`instructor_id`)
		REFERENCES `hb_04_one_to_many_uni`.`instructor` (`id`)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hb_04_one_to_many_uni`.`reviews`;

CREATE TABLE `hb_04_one_to_many_uni`.`reviews` (
	`id`		INT(11) 		NOT NULL AUTO_INCREMENT,
    `comment` 	VARCHAR(256) 	DEFAULT NULL,
    `course_id` INT(11) 		DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `COURSE_ID_idx` (`course_id`),
    CONSTRAINT `FK_COURSE_ID` FOREIGN KEY (`course_id`)
		REFERENCES `hb_04_one_to_many_uni`.`courses` (`id`)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hb_04_one_to_many_uni`.`students`;

CREATE TABLE `hb_04_one_to_many_uni`.`students` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` 			VARCHAR(45) DEFAULT NULL,
    `last_name` 			VARCHAR(45) DEFAULT NULL,
    `email` 				VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hb_04_one_to_many_uni`.`courses_students`;

CREATE TABLE `hb_04_one_to_many_uni`.`courses_students` (
	`course_id` INT(11) NOT NULL,
    `student_id` INT(11) NOT NULL,
    PRIMARY KEY (`course_id`, `student_id`),
    KEY `COURSE_ID_idx_2` (`course_id`),
    KEY `STUDENT_ID_idx` (`student_id`),
    CONSTRAINT `FK_COURSE_ID_2` FOREIGN KEY (`course_id`) 
		REFERENCES `hb_04_one_to_many_uni`.`courses` (`id`) 
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT `FK_STUDENT_ID` FOREIGN KEY (`student_id`) 
		REFERENCES `hb_04_one_to_many_uni`.`students` (`id`) 
        ON UPDATE NO ACTION ON DELETE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;