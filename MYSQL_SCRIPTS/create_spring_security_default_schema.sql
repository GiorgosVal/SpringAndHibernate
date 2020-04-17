DROP DATABASE IF EXISTS `spring_security_demo_plaintext`;
CREATE DATABASE `spring_security_demo_plaintext`;
USE `spring_security_demo_plaintext`;

DROP TABLE IF EXISTS `spring_security_demo_plaintext`.`users`;
CREATE TABLE `spring_security_demo_plaintext`.`users`(
	`username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,
    PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `spring_security_demo_plaintext`.`users` VALUES
('john','{noop}1234',1),
('mary','{noop}1234',1),
('susan','{noop}1234',1),
('george','{noop}1234',1);

CREATE TABLE `spring_security_demo_plaintext`.`authorities`(
	`username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    UNIQUE KEY `authorities_index_1` (`username`, `authority`),
    CONSTRAINT `username_fk_1` FOREIGN KEY (`username`)
		REFERENCES `spring_security_demo_plaintext`.`users` (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `spring_security_demo_plaintext`.`authorities` VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_ADMIN'),
('george', 'ROLE_ASSOCIATE');

