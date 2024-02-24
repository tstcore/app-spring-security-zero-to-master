drop database if exists db_easy_bank;

create database if not exists db_easy_bank;

use db_easy_bank;

drop table `users`;
drop table `authorities`;
drop table `customer`;
-- newly updated schema - 17 February 2024
-- Customer table
CREATE TABLE `customer` (
  `customer_id` BIGINT AUTO_INCREMENT NOT NULL,
   `name` VARCHAR(100) NOT NULL,
   `mobile_number` VARCHAR(20) NOT NULL,
   `email` VARCHAR(100) NOT NULL,
   `pwd` VARCHAR(500) NOT NULL,
   `role` VARCHAR(100) NOT NULL,
   `created_date` date default NULL,
   CONSTRAINT pk_customer PRIMARY KEY (`customer_id`));
-- insert customer statement
INSERT CUSTOMER `customer`(`name`,`mobile_number`,`email`,`pwd`,`role`,`created_date`)
 VALUES('Happy','9876548337','happy1@example.com','$2y$','admin',CURDATE());
-- accounts table


-- CREATE TABLE `users` (
-- `id` INT NOT NULL AUTO_INCREMENT,
-- `username` VARCHAR(45) NOT NULL,
-- `password` VARCHAR(45) NOT NULL,
-- `enabled` INT NOT NULL,
-- PRIMARY KEY (`id`));

-- CREATE TABLE `authorities` (
--  `id` int NOT NULL AUTO_INCREMENT,
--  `username` varchar(45) NOT NULL,
--  `authority` varchar(45) NOT NULL,
--  PRIMARY KEY (`id`));

-- INSERT IGNORE INTO `users` VALUES (NULL, 'happy', '12345', '1');
-- INSERT IGNORE INTO `authorities` VALUES (NULL, 'happy', 'write');

-- CREATE TABLE `customer` (
--  `id` int NOT NULL AUTO_INCREMENT,
--  `email` varchar(45) NOT NULL,
--  `pwd` varchar(200) NOT NULL,
--  `role` varchar(45) NOT NULL,
--  PRIMARY KEY (`id`)
-- );

-- INSERT INTO `customer` (`email`, `pwd`, `role`)
-- VALUES ('johndoe@example.com', '54321', 'admin');