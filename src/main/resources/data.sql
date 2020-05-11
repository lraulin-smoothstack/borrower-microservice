
INSERT INTO `publisher` (`id`, `address`, `name`, `phone_number`) VALUES
(1,	'1234 Arlington Ave. Fairfax Virginia 27363',	'Penguin House Inc.',	'762-282-8787'),
(2,	'32605 5th Ave. Seattle, Washington',	'Macmillan Publishers',	'206-716-2787'),
(3,	'88781 51 St. Portland, Oregon',	'Simon & Schuster',	'506-287-8878');

INSERT INTO `author` (`id`, `name`) VALUES
(1,	'J.K. Rolling'),
(2,	'George Martin'),
(3,	'Brian McClellan'),
(4,	'Robert Jordan'),
(5,	'James Patterson'),
(6,	'Joe Abercrombie');

INSERT INTO `genre` (`id`, `name`) VALUES
(1,	'Fiction'),
(2,	'Suspense Fiction');

INSERT INTO `book` (`id`, `title`, `publisher_id`) VALUES
(1,	'Harry Potter and the Goblet of Fire',	1),
(2,	'Sins of Empire',	2),
(3,	'Servant of the Crown',	2),
(7,	'Game of Thrones',	1),
(8,	'Winter\'s Heart',	3),
(9,	'The Blade Itself',	1),
(10,	'Criss Cross',	3);

INSERT INTO `book_authors` (`book_id`, `author_id`) VALUES
(1,	1),
(7,	2),
(2,	3),
(3,	3),
(8,	4),
(10,	5),
(9,	6);

INSERT INTO `book_genres` (`book_id`, `genre_id`) VALUES
(1,	1),
(2,	1),
(3,	1),
(7,	1),
(8,	1),
(9,	1),
(10,	2);

INSERT INTO `borrower` (`id`, `address`, `name`, `phone_number`) VALUES
(1,	'1325 S 76TH Ave. Yakima, Washington',	'Joe Smith',	'509-287-4787'),
(2,	'1827 Tod Rd. Arlington, Virginia',	'Steve Cook',	'706-287-2998');

INSERT INTO `library_branch` (`id`, `address`, `name`) VALUES
(1,	'172 1st St. Seattle Wa 172673',	'Seattle Library'),
(2,	'17637 Fairlakes Parkway Fairfax, Virginia',	'Chantilly Regional Library');

INSERT INTO `book_copy` (`book_id`, `branch_id`, `amount`) VALUES
(1,	1,	12),
(1,	2,	28),
(2,	1,	100),
(3,	2,	6),
(7,	1,	48),
(8,	1,	0),
(8,	2,	1),
(9,	2,	0),
(10,	2,	16);

INSERT INTO `book_loan` (`book_id`, `borrower_id`, `branch_id`, `date_in`, `date_out`, `due_date`) VALUES
(1,	1,	2,	NULL,	'2020-04-20',	'2020-04-27'),
(2,	2,	1,	NULL,	'2020-04-19',	'2020-04-26'),
(3,	1,	1,	'2020-04-21',	'2020-04-18',	'2020-04-25'),
(7,	2,	1,	NULL,	'2020-04-15',	'2020-04-22'),
(8,	2,	2,	'2020-04-19',	'2020-04-16',	'2020-04-23');
