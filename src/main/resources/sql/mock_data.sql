DELIMITER //
CREATE PROCEDURE insert_book
(IN title VARCHAR(255),
publisher VARCHAR(255))
BEGIN
  SELECT Name, HeadOfState FROM Country
  WHERE Continent = con;
END //
DELIMITER ;
