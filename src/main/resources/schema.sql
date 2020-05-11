-- Adminer 4.7.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `publisher_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgtvt7p649s4x80y6f4842pnfq` (`publisher_id`),
  CONSTRAINT `FKgtvt7p649s4x80y6f4842pnfq` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `book_authors`;
CREATE TABLE `book_authors` (
  `book_id` bigint(20) NOT NULL,
  `author_id` bigint(20) NOT NULL,
  PRIMARY KEY (`book_id`,`author_id`),
  KEY `FK78gu95lglhc6cs2u5jfudx6e5` (`author_id`),
  CONSTRAINT `FK78gu95lglhc6cs2u5jfudx6e5` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FKs4xm7q8i3uxvaiswj1c35nnxw` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `book_copy`;
CREATE TABLE `book_copy` (
  `book_id` bigint(20) NOT NULL,
  `branch_id` bigint(20) NOT NULL,
  `amount` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`book_id`,`branch_id`),
  KEY `FKnrnrxe9isytf7at2eclgen7mo` (`branch_id`),
  CONSTRAINT `FKnrnrxe9isytf7at2eclgen7mo` FOREIGN KEY (`branch_id`) REFERENCES `library_branch` (`id`),
  CONSTRAINT `FKpqftp65hd66ae8wsx7pp2cxcs` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `book_genres`;
CREATE TABLE `book_genres` (
  `book_id` bigint(20) NOT NULL,
  `genre_id` bigint(20) NOT NULL,
  PRIMARY KEY (`book_id`,`genre_id`),
  KEY `FK9h3nddtxgapfvc95fjt1x146m` (`genre_id`),
  CONSTRAINT `FK6soimqwnss59p5wt6m3afnuoo` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FK9h3nddtxgapfvc95fjt1x146m` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `book_loan`;
CREATE TABLE `book_loan` (
  `book_id` bigint(20) NOT NULL,
  `borrower_id` bigint(20) NOT NULL,
  `branch_id` bigint(20) NOT NULL,
  `date_in` date DEFAULT NULL,
  `date_out` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  PRIMARY KEY (`book_id`,`borrower_id`,`branch_id`),
  KEY `FK5tedwdmib2nudnd4tm0u9sej0` (`borrower_id`),
  KEY `FKlyufp6fqdud9tfeqvm1es51w` (`branch_id`),
  CONSTRAINT `FK5tedwdmib2nudnd4tm0u9sej0` FOREIGN KEY (`borrower_id`) REFERENCES `borrower` (`id`),
  CONSTRAINT `FKd0pola0sj2fp9719x3b8lpb7s` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKlyufp6fqdud9tfeqvm1es51w` FOREIGN KEY (`branch_id`) REFERENCES `library_branch` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `library_branch`;
CREATE TABLE `library_branch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- 2020-04-27 01:35:17
