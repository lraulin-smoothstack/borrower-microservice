INSERT INTO borrower (id, address, name, phone_number) VALUES (1, '1325 S 76TH Ave. Yakima, Washington', 'Joe Smith', '509-287-4787');
INSERT INTO borrower (id, address, name, phone_number) VALUES (2, '1827 Tod Rd. Arlington, Virginia', 'Steve Cook', '706-287-2998');

INSERT INTO library_branch (id, address, name) VALUES (1, '1837 5th Ave. Seattle, Wa', 'Seattle Library');
INSERT INTO library_branch (id, address, name) VALUES (2, '17637 Fairlakes Parkway Fairfax, Virginia', 'Chantilly Regional Library');

INSERT INTO genre (id, name) VALUES (1, 'Fiction');
INSERT INTO genre (id, name) VALUES (2, 'Suspense Fiction');

INSERT INTO publisher (id, address, name, phone_number) VALUES (1, '1234 Arlington Ave. Fairfax Virginia 27363', 'Penguin House Inc.', '762-282-8787');
INSERT INTO publisher (id, address, name, phone_number) VALUES (2, '32605 5th Ave. Seattle, Washington', 'Macmillan Publishers', '206-716-2787');
INSERT INTO publisher (id, address, name, phone_number) VALUES (3, '88781 51 St. Portland, Oregon', 'Simon & Schuster', '506-287-8878');

INSERT INTO author (id, name) VALUES (1, 'J.K. Rolling');
INSERT INTO author (id, name) VALUES (2, 'George Martin');
INSERT INTO author (id, name) VALUES (3, 'Brian McClellan');
INSERT INTO author (id, name) VALUES (4, 'Robert Jordan');
INSERT INTO author (id, name) VALUES (5, 'James Patterson');
INSERT INTO author (id, name) VALUES (6, 'Joe Abercrombie');

INSERT INTO book (id, title, publisher_id) VALUES (1, 'Harry Potter and the Goblet of Fire', 1);
INSERT INTO book (id, title, publisher_id) VALUES (2, 'Sins of Empire', 2);
INSERT INTO book (id, title, publisher_id) VALUES (3, 'Servant of the Crown', 2);
INSERT INTO book (id, title, publisher_id) VALUES (7, 'Game of Thrones', 1);
INSERT INTO book (id, title, publisher_id) VALUES (8, 'Winters Heart', 3);
INSERT INTO book (id, title, publisher_id) VALUES (9, 'The Blade Itself', 1);
insert into book (id, title, publisher_id) values (10, 'Bells of Innocence', 1);
insert into book (id, title, publisher_id) values (11, 'Curb Dance', 2);
insert into book (id, title, publisher_id) values (12, 'Get Educated: Paathshaala', 3);
insert into book (id, title, publisher_id) values (13, 'Taipei Exchanges (Di 36 ge gu shi)', 1);
insert into book (id, title, publisher_id) values (14, 'LEGO DC Comics Super Heroes: Justice League vs. Bizarro League', 2);
insert into book (id, title, publisher_id) values (15, 'Puppet Master 5: The Final Chapter', 3);
insert into book (id, title, publisher_id) values (16, 'Phantom Stagecoach, The', 1);
insert into book (id, title, publisher_id) values (17, 'Looking for Palladin', 2);
insert into book (id, title, publisher_id) values (18, 'Tristan & Isolde', 3);
insert into book (id, title, publisher_id) values (19, 'Ice Cream Man', 1);
insert into book (id, title, publisher_id) values (20, 'Strange Circus (Kimyô na sâkasu)', 2);
insert into book (id, title, publisher_id) values (21, 'Charleston', 3);
insert into book (id, title, publisher_id) values (22, 'Back Street', 1);
insert into book (id, title, publisher_id) values (23, 'On the Double ', 2);
insert into book (id, title, publisher_id) values (24, 'Quo Vadis, Baby?', 3);
insert into book (id, title, publisher_id) values (25, 'Foolproof', 1);
insert into book (id, title, publisher_id) values (26, 'Episode 3: Enjoy Poverty', 2);
insert into book (id, title, publisher_id) values (27, 'Ghost in the Shell Arise - Border 1: Ghost Pain', 2);
insert into book (id, title, publisher_id) values (28, 'S.P.L.: Kill Zone (Saat po long)', 3);
insert into book (id, title, publisher_id) values (29, 'Snowbeast', 1);
insert into book (id, title, publisher_id) values (30, '18 Fingers of Death!', 2);
insert into book (id, title, publisher_id) values (31, 'How to Eat Your Watermelon in White Company (and Enjoy It)', 3);
insert into book (id, title, publisher_id) values (32, '7 Faces of Dr. Lao', 1);
insert into book (id, title, publisher_id) values (33, 'À l''aventure', 2);
insert into book (id, title, publisher_id) values (34, 'Muppets From Space', 3);
insert into book (id, title, publisher_id) values (35, 'Honkytonk Man', 1);
insert into book (id, title, publisher_id) values (36, 'Love Life', 2);
insert into book (id, title, publisher_id) values (37, 'Timecrimes (Cronocrímenes, Los)', 3);
insert into book (id, title, publisher_id) values (38, 'Dr. T and the Women', 1);
insert into book (id, title, publisher_id) values (39, 'O Amor das Três Romãs', 2);
insert into book (id, title, publisher_id) values (40, 'Brighton Rock', 3);
insert into book (id, title, publisher_id) values (41, 'Cry in the Dark, A', 1);
insert into book (id, title, publisher_id) values (42, 'Kedma', 2);


INSERT INTO book_authors (book_id, author_id) VALUES (1, 1);
INSERT INTO book_authors (book_id, author_id) VALUES (7, 2);
INSERT INTO book_authors (book_id, author_id) VALUES (2, 3);
INSERT INTO book_authors (book_id, author_id) VALUES (3, 3);
INSERT INTO book_authors (book_id, author_id) VALUES (8, 4);
INSERT INTO book_authors (book_id, author_id) VALUES (9, 6);
INSERT INTO book_authors (book_id, author_id) VALUES (10, 5);
insert into book_authors (book_id, author_id) values (11, 1);
insert into book_authors (book_id, author_id) values (12, 2);
insert into book_authors (book_id, author_id) values (13, 3);
insert into book_authors (book_id, author_id) values (14, 4);
insert into book_authors (book_id, author_id) values (15, 5);
insert into book_authors (book_id, author_id) values (16, 6);
insert into book_authors (book_id, author_id) values (17, 1);
insert into book_authors (book_id, author_id) values (18, 2);
insert into book_authors (book_id, author_id) values (19, 3);
insert into book_authors (book_id, author_id) values (20, 4);
insert into book_authors (book_id, author_id) values (21, 5);
insert into book_authors (book_id, author_id) values (22, 6);
insert into book_authors (book_id, author_id) values (23, 1);
insert into book_authors (book_id, author_id) values (24, 2);
insert into book_authors (book_id, author_id) values (25, 3);
insert into book_authors (book_id, author_id) values (26, 4);
insert into book_authors (book_id, author_id) values (27, 5);
insert into book_authors (book_id, author_id) values (28, 6);
insert into book_authors (book_id, author_id) values (29, 1);
insert into book_authors (book_id, author_id) values (30, 2);
insert into book_authors (book_id, author_id) values (31, 3);
insert into book_authors (book_id, author_id) values (32, 4);
insert into book_authors (book_id, author_id) values (33, 5);
insert into book_authors (book_id, author_id) values (34, 6);
insert into book_authors (book_id, author_id) values (35, 1);
insert into book_authors (book_id, author_id) values (36, 2);
insert into book_authors (book_id, author_id) values (37, 3);
insert into book_authors (book_id, author_id) values (38, 4);
insert into book_authors (book_id, author_id) values (39, 5);
insert into book_authors (book_id, author_id) values (40, 6);
insert into book_authors (book_id, author_id) values (41, 1);
insert into book_authors (book_id, author_id) values (42, 2);

INSERT INTO book_genres (book_id, genre_id) VALUES (1, 1);
INSERT INTO book_genres (book_id, genre_id) VALUES (2, 1);
INSERT INTO book_genres (book_id, genre_id) VALUES (3, 1);
INSERT INTO book_genres (book_id, genre_id) VALUES (7, 1);
INSERT INTO book_genres (book_id, genre_id) VALUES (8, 1);
INSERT INTO book_genres (book_id, genre_id) VALUES (9, 1);
INSERT INTO book_genres (book_id, genre_id) VALUES (10, 2);
insert into book_genres (book_id, genre_id) values (11, 1);
insert into book_genres (book_id, genre_id) values (12, 2);
insert into book_genres (book_id, genre_id) values (13, 1);
insert into book_genres (book_id, genre_id) values (14, 2);
insert into book_genres (book_id, genre_id) values (15, 1);
insert into book_genres (book_id, genre_id) values (16, 2);
insert into book_genres (book_id, genre_id) values (17, 1);
insert into book_genres (book_id, genre_id) values (18, 2);
insert into book_genres (book_id, genre_id) values (19, 1);
insert into book_genres (book_id, genre_id) values (20, 2);
insert into book_genres (book_id, genre_id) values (21, 1);
insert into book_genres (book_id, genre_id) values (22, 2);
insert into book_genres (book_id, genre_id) values (23, 1);
insert into book_genres (book_id, genre_id) values (24, 2);
insert into book_genres (book_id, genre_id) values (25, 1);
insert into book_genres (book_id, genre_id) values (26, 2);
insert into book_genres (book_id, genre_id) values (27, 1);
insert into book_genres (book_id, genre_id) values (28, 2);
insert into book_genres (book_id, genre_id) values (29, 1);
insert into book_genres (book_id, genre_id) values (30, 1);
insert into book_genres (book_id, genre_id) values (31, 2);
insert into book_genres (book_id, genre_id) values (32, 1);
insert into book_genres (book_id, genre_id) values (33, 1);
insert into book_genres (book_id, genre_id) values (34, 2);
insert into book_genres (book_id, genre_id) values (35, 1);
insert into book_genres (book_id, genre_id) values (36, 2);
insert into book_genres (book_id, genre_id) values (37, 1);
insert into book_genres (book_id, genre_id) values (38, 1);
insert into book_genres (book_id, genre_id) values (39, 2);
insert into book_genres (book_id, genre_id) values (40, 1);
insert into book_genres (book_id, genre_id) values (41, 2);
insert into book_genres (book_id, genre_id) values (42, 1);

INSERT INTO book_copy (book_id, branch_id, amount) VALUES (1, 1, 7);
INSERT INTO book_copy (book_id, branch_id, amount) VALUES (1, 2, 10);
INSERT INTO book_copy (book_id, branch_id, amount) VALUES (3, 1, 30);
INSERT INTO book_copy (book_id, branch_id, amount) VALUES (7, 1, 0);
INSERT INTO book_copy (book_id, branch_id, amount) VALUES (8, 1, 1);
INSERT INTO book_copy (book_id, branch_id, amount) VALUES (10, 2, 7);
insert into book_copy (book_id, branch_id, amount) values (10, 1, 10);
insert into book_copy (book_id, branch_id, amount) values (11, 2, 11);
insert into book_copy (book_id, branch_id, amount) values (12, 1, 12);
insert into book_copy (book_id, branch_id, amount) values (13, 2, 13);
insert into book_copy (book_id, branch_id, amount) values (14, 1, 14);
insert into book_copy (book_id, branch_id, amount) values (15, 2, 15);
insert into book_copy (book_id, branch_id, amount) values (16, 1, 16);
insert into book_copy (book_id, branch_id, amount) values (17, 2, 17);
insert into book_copy (book_id, branch_id, amount) values (18, 1, 18);
insert into book_copy (book_id, branch_id, amount) values (19, 2, 19);
insert into book_copy (book_id, branch_id, amount) values (20, 1, 20);
insert into book_copy (book_id, branch_id, amount) values (21, 2, 21);
insert into book_copy (book_id, branch_id, amount) values (22, 1, 22);
insert into book_copy (book_id, branch_id, amount) values (23, 2, 23);
insert into book_copy (book_id, branch_id, amount) values (24, 1, 24);
insert into book_copy (book_id, branch_id, amount) values (25, 2, 25);
insert into book_copy (book_id, branch_id, amount) values (26, 1, 26);
insert into book_copy (book_id, branch_id, amount) values (27, 2, 27);
insert into book_copy (book_id, branch_id, amount) values (28, 1, 28);
insert into book_copy (book_id, branch_id, amount) values (29, 2, 29);
insert into book_copy (book_id, branch_id, amount) values (30, 1, 30);
insert into book_copy (book_id, branch_id, amount) values (31, 2, 31);
insert into book_copy (book_id, branch_id, amount) values (32, 1, 32);
insert into book_copy (book_id, branch_id, amount) values (33, 2, 33);
insert into book_copy (book_id, branch_id, amount) values (34, 1, 34);
insert into book_copy (book_id, branch_id, amount) values (35, 2, 35);
insert into book_copy (book_id, branch_id, amount) values (36, 1, 36);
insert into book_copy (book_id, branch_id, amount) values (37, 2, 37);
insert into book_copy (book_id, branch_id, amount) values (38, 1, 38);
insert into book_copy (book_id, branch_id, amount) values (39, 2, 39);
insert into book_copy (book_id, branch_id, amount) values (40, 1, 40);
insert into book_copy (book_id, branch_id, amount) values (41, 2, 41);
insert into book_copy (book_id, branch_id, amount) values (42, 1, 42);

INSERT INTO book_loan (book_id, borrower_id, branch_id, date_in, date_out, due_date) VALUES (1, 1, 2, NULL, '2020-04-20', '2020-04-27');
INSERT INTO book_loan (book_id, borrower_id, branch_id, date_in, date_out, due_date) VALUES (2, 2, 1, NULL, '2020-04-19', '2020-04-26');
INSERT INTO book_loan (book_id, borrower_id, branch_id, date_in, date_out, due_date) VALUES (3, 1, 1, '2020-04-21', '2020-04-18', '2020-04-25');
INSERT INTO book_loan (book_id, borrower_id, branch_id, date_in, date_out, due_date) VALUES (7, 2, 1, NULL, '2020-04-15', '2020-04-22');
INSERT INTO book_loan (book_id, borrower_id, branch_id, date_in, date_out, due_date) VALUES (8, 1, 1, '2020-05-04', '2020-05-03', '2020-05-10');
INSERT INTO book_loan (book_id, borrower_id, branch_id, date_in, date_out, due_date) VALUES (8, 2, 2, '2020-04-19', '2020-04-16', '2020-04-23');;
