DROP DATABASE IF EXISTS `spring_security_custom_user`;
CREATE DATABASE `spring_security_custom_user`;
USE `spring_security_custom_user`;

DROP TABLE IF EXISTS `spring_security_custom_user`.`users`;
CREATE TABLE `spring_security_custom_user`.`users` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(80) NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `USERNAME_INDEX` (`username`),
    UNIQUE KEY `EMAIL_INDEX` (`email`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `spring_security_custom_user`.`roles`;
CREATE TABLE `spring_security_custom_user`.`roles` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `role` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ROLE_INDEX` (`role`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `spring_security_custom_user`.`users_roles`;
CREATE TABLE `spring_security_custom_user`.`users_roles`(
	`user_id` INT(11) NOT NULL,
    `role_id` INT(11) NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    CONSTRAINT `FK_USER_ID` FOREIGN KEY (`user_id`)
		REFERENCES `spring_security_custom_user`.`users` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `FK_ROLE_ID` FOREIGN KEY (`role_id`)
		REFERENCES `spring_security_custom_user`.`roles` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `spring_security_custom_user`.`users` (username, password, first_name, last_name, email) VALUES
('john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','John','Doe','john@gmail.com'),
('mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Mary','Public','mary@hotmail.com'),
('susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Susan','Adams','susan@gmail.com');

INSERT INTO `spring_security_custom_user`.`roles` (role) VALUES
('EMPLOYEE'),('MANAGER'),('ADMIN'), ('CUSTOMER'), ('ASSOCIATE');

INSERT INTO `spring_security_custom_user`.`users_roles` (user_id, role_id) VALUES
(1,1),
(2,1),
(2,2),
(3,1),
(3,3);
