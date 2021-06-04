CREATE DATABASE `hello-world`; 

USE `hello-world`; 

CREATE TABLE `message` ( 
	`ID` BIGINT(20) NOT NULL AUTO_INCREMENT, 
	`TEXT` VARCHAR(255) NULL DEFAULT NULL, 
	PRIMARY KEY (`ID`) 
); 


CREATE TABLE `guide` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `staff_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enrollment_id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `guide_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb4ny3l3cnsxbbn601ev8mhlj5` (`guide_id`),
  CONSTRAINT `FKb4ny3l3cnsxbbn601ev8mhlj5` FOREIGN KEY (`guide_id`) REFERENCES `guide` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 
 