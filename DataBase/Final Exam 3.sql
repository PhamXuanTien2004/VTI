DROP DATABASE IF EXISTS final_exam_03;
CREATE DATABASE final_exam_03;
USE final_exam_03;

-- 2. Viết lệnh để 
-- a) Lấy tất cả các nhân viên thuộc Việt nam  
WITH c1 as (
SELECT *
FROM country
LEFT JOIN location USING(country_id))

SELECT employee.*, country_name
FROM employee
LEFT JOIN c1 USING (location_id)
WHERE country_name ='Việt Nam';
-- b) Lấy ra tên quốc gia của employee có email là "nn03@gmail.com" 
WITH c1 as (
SELECT *
FROM country
LEFT JOIN location USING(country_id))
SELECT employee.*, country_name
FROM employee
LEFT JOIN c1 USING (location_id)
WHERE email ='nn03@gmail.com';
-- c) Thống kê mỗi country, mỗi location có bao nhiêu employee đang 
-- làm việc. 
SELECT location.*, count(location_id)
FROM location
LEFT JOIN employee USING(location_id)
GROUP BY location_id ;

-- Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 
-- 10 employee 

DROP TRIGGER IF EXISTS trigger_01;
DELIMITER $$
CREATE TRIGGER trigger_01
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN
    DECLARE v_count INT;
    
    SELECT COUNT( employee_id)
    INTO v_count
    FROM employee  
    INNER JOIN location  USING(location_id)
    WHERE  country_id = NEW.location_id;

    IF v_count >= 10 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Each country can have a maximum of 10 employees';
    END IF;
END $$
DELIMITER ;



DROP TABLE IF EXISTS Country;
CREATE TABLE Country(
country_id INT PRIMARY KEY, 
country_name VARCHAR(50)
); 

DROP TABLE IF EXISTS Location;
CREATE TABLE Location(
location_id INT PRIMARY KEY, 
street_address VARCHAR(50), 
postal_code INT, 
country_id INT,
FOREIGN KEY(country_id)
	REFERENCES Country (country_id)
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
employee_id INT PRIMARY KEY, 
full_name VARCHAR (50), 
email varchar(50), 
location_id INT,
FOREIGN KEY(location_id)
	REFERENCES Location (location_id)
); 


INSERT INTO Country(country_id, country_name) 
VALUES             (1         , 'Việt Nam'        ),
				   (2         , 'TL'        ),
                   (3         , 'HQ'        );

INSERT INTO Location(location_id, street_address , postal_code, country_id)
VALUES              (1          , '132 thánh thiên', 1404       , 1         ),
					(2          , '26 hòa yên'     , 1910       , 3         ),
					(3          , '327 Bach Dang'  , 2023       , 2         );

INSERT INTO employee (employee_id, full_name, email, location_id)
VALUES 
    (1, 'Nguyen Van A', 'nguyenvana@example.com', 1),
    (2, 'Tran Thi B', 'nn03@gmail.com', 2),
    (3, 'Le Van C', 'levanc@example.com', 3);






