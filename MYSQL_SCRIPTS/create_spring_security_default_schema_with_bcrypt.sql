DROP DATABASE IF EXISTS `spring_security_demo_bcrypt`;
CREATE DATABASE `spring_security_demo_bcrypt`;
USE `spring_security_demo_bcrypt`;

DROP TABLE IF EXISTS `spring_security_demo_bcrypt`.`users`;
CREATE TABLE `spring_security_demo_bcrypt`.`users`(
	`username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(68) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,
    PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `spring_security_demo_bcrypt`.`users` VALUES
('john','{bcrypt}$2a$10$doyV/Mg56U2Wji2.TY2MCuQlMwCCPOVb0X5dQG6HgzTVdQeInV0t2',1),
('mary','{bcrypt}$2a$10$BdRx3uWUl0o0zGHoWZYKLOzQGWqLpJoZAJO5ie1JILEiW1Rv0dtQW',1),
('susan','{bcrypt}$2a$10$jcvbG8H/FQWgCcTHvcFYhelw43TgZhvY1Ru8IsO.BbBkXKgIW5W02',1),
('george','{bcrypt}$2a$10$.p8RthhQZzX9WqWkno5KIuG6tjdT0ofbNTNkYK7gc2lCEua2fjgnS',1);

DROP TABLE IF EXISTS `spring_security_demo_bcrypt`.`authorities`;
CREATE TABLE `spring_security_demo_bcrypt`.`authorities`(
	`username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    UNIQUE KEY `authorities_index_1` (`username`, `authority`),
    CONSTRAINT `username_fk_1` FOREIGN KEY (`username`)
		REFERENCES `spring_security_demo_bcrypt`.`users` (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `spring_security_demo_bcrypt`.`authorities` VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_ADMIN'),
('george', 'ROLE_ASSOCIATE');
