DROP DATABASE IF EXISTS assignment_06;
CREATE DATABASE assignment_06;
USE assignment_06;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó.

DROP PROCEDURE IF EXISTS sp_01;
DELIMITER $$
CREATE PROCEDURE sp_01 (IN in_department_name VARCHAR(50))
	BEGIN
		DECLARE v_department_id INT;
        SELECT department_id INTO v_department_id
        FROM department
        WHERE department_name = 'Nhân sự';
        
        SELECT *
        FROM account
        WHERE department_id = v_department_id;
    END $$
DELIMITER ;

CALL sp_01 ('Nhân sự');
-- Question 2: Tạo store để in ra số lượng account trong mỗi group.

DROP PROCEDURE IF EXISTS sp_02;
DELIMITER $$
CREATE PROCEDURE sp_02 ()
	BEGIN
		SELECT `group`.*, count(account_id) as count
		FROM group_account
        Right join `group` using (group_id)
        group by group_id;
        
    END $$
DELIMITER ;

CALL sp_02();
-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại.
DROP PROCEDURE IF EXISTS sp_03;
DELIMITER $$ 
CREATE PROCEDURE sp_03()
	BEGIN
		DECLARE v_current_date INT DEFAULT month(current_date());
        
        WITH c1 AS (
			SELECT question_id, type_id
            from question
            WHERE month(created_date) = v_current_date
        )
        SELECT type_question.*, count(question_id)
        FROM c1
        RIGHT JOIN  type_question USING(type_id)
        GROUP BY type_id;
    END $$
DELIMITER ;

CALL sp_03();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất.
DROP PROCEDURE IF EXISTS sp_04;
DELIMITER $$ 
CREATE PROCEDURE sp_04(OUT out_type_id INT)
	BEGIN
		DECLARE v_type_id INT;
        
        WITH c1 AS (
			SELECT type_question.*, COUNT(question_id) AS question_count
            from type_question
            LEFT JOIN question USING(type_id)
            GROUP BY type_id
        )
        SELECT type_id INTO out_type_id 
        FROM c1
        WHERE question_count >= ALL (
        SELECT question_count
        FROM c1
        );
    END $$
DELIMITER ;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question.

SET @type_id = NULL;
CALL sp_04(@type_id);

SELECT type_name
FROM type_question
WHERE type_id = @type_id;
-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào.
DROP PROCEDURE IF EXISTS sp_06;
DELIMITER $$
CREATE PROCEDURE sp_06 (IN in_search VARCHAR(50))
BEGIN
    SELECT "group" AS type, group_name AS name
    FROM `group`
    WHERE group_name LIKE CONCAT("%", in_search, "%")
    UNION ALL
    SELECT "account" AS type, username AS name
    FROM account
    WHERE username LIKE CONCAT("%", in_search, "%");
END $$
DELIMITER ;

CALL sp_06("n");
-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS sp_07;
DELIMITER $$ 
CREATE PROCEDURE sp_07(IN in_full_name VARCHAR(50), IN in_email VARCHAR(50))
	BEGIN
		DECLARE v_username VARCHAR(50);
        DECLARE v_position_id INT;
        DECLARE v_department_id INT;
        
        SELECT substring_index(in_email, "@", 1) INTO v_username;
        
        SELECT department_id INTO v_department_id
        FROM department
        WHERE department_name = "Phòng chờ";
        
        SELECT position_id INTO v_position_id
        FROM position
        WHERE position_name = "Dev";
        
        INSERT INTO account (email   , username  , full_name   , department_id  , position_id  )
		VALUES              (in_email, v_username, in_full_name, v_department_id, v_position_id);
    
		SELECT *
    FROM account
    WHERE email = in_email;
    END $$
DELIMITER ;

CALL sp_07("Pham Xuan Tien", "px.tien.2004@gmail.com");
-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS sp_08;
DELIMITER $$
CREATE PROCEDURE sp_08( IN in_type_question ENUM("Essay", "Multiple-Choice"))
BEGIN
	DECLARE v_type_id INT;
    
    SELECT type_id INTO v_type_id
    FROM type_question
    WHERE type_name = in_type_question;
    WITH c1 AS (
		SELECT *, char_length(content) as content_length
		FROM question
		WHERE type_id = v_type_id
    )
    SELECT * 
    FROM c1
    WHERE content_length >= all 
    (SELECT content_length
    from c1);
END$$
DELIMITER ;

CALL sp_08('Essay');
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_09;
DELIMITER $$
CREATE PROCEDURE sp_09 (IN in_exam_id INT)
BEGIN
    DELETE FROM exam
    WHERE exam_id = in_exam_id;
END $$
DELIMITER ;

CALL sp_09(3);
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi
-- removing
DROP PROCEDURE IF EXISTS sp_10;
DELIMITER $$
CREATE PROCEDURE sp_10 ()
BEGIN
	DECLARE v_exam_count INT;
	DECLARE v_exam_question_count INT;

	select count(*) INTO v_exam_count
	FROM exam
	WHERE created_date < CURRENT_DATE - INTERVAL 5 YEAR;

	SELECT COUNT(*) INTO v_exam_question_count
	FROM exam
	WHERE created_date < CURRENT_DATE - INTERVAL 5 YEAR;

	
    DELETE FROM exam
    where current_date()- created_date >5;
     SELECT v_exam_count + v_exam_question_count as removed;
     
END $$
DELIMITER ;

CAll sp_10();
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS sp_11;
DELIMITER $$
CREATE PROCEDURE sp_11 (IN in_department_name VARCHAR(50))
BEGIN
    DECLARE v_old_department_id INT;
    DECLARE v_new_department_id INT;

    SELECT department_id INTO v_old_department_id
    FROM department
    WHERE department_name = in_department_name;

    SELECT department_id INTO v_new_department_id
    FROM department
    WHERE department_name = "Phòng chờ";
    
    UPDATE account
    SET department_id = v_new_department_id
    WHERE department_id = v_old_department_id;
    
    DELETE FROM department
    WHERE department_id = v_old_department_id;
END $$
DELIMITER ;

CALL sp_11("Marketing");

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS sp_12;
DELIMITER $$
CREATE PROCEDURE sp_12 ()
BEGIN
	WITH RECURSIVE c1 (month) AS (
    SELECT 1
    UNION ALL
    SELECT month + 1 FROM c1 WHERE month < 12
), c2 AS (
    SELECT YEAR(CURRENT_DATE) AS year, month
    FROM c1
), c3 AS (
    SELECT *, YEAR(created_date) AS year, MONTH(created_date) AS month
    FROM question
    WHERE YEAR(created_date) = YEAR(CURRENT_DATE)
)
SELECT year, month, COUNT(question_id)
FROM c2
LEFT JOIN c3 USING (year, month)
GROUP BY year, month;
    

END $$
DELIMITER ;
CALL sp_12();
-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS sp_13;
DELIMITER $$
CREATE PROCEDURE sp_13 ()
BEGIN
	WITH RECURSIVE c1 (date) AS (
    SELECT CURRENT_DATE - INTERVAL 1 MONTH
    UNION ALL
    SELECT date - INTERVAL 1 MONTH
    FROM c1
    WHERE date > CURRENT_DATE - INTERVAL 6 MONTH
), c2 AS (
    SELECT YEAR(date) AS year, MONTH(date) AS month
    FROM c1
), c3 AS (
    SELECT *, YEAR(created_date) AS year, MONTH(created_date) AS month
    FROM question
)
SELECT year, month, COUNT(question_id)
FROM c2
LEFT JOIN c3 USING (year, month)
GROUP BY year, month;
    

END $$
DELIMITER ;
CALL sp_13();





-- Tạo bảng department
DROP TABLE IF EXISTS department;
CREATE TABLE department (
	department_id INT PRIMARY KEY AUTO_INCREMENT,
	department_name VARCHAR(50)
);

-- Tạo bảng position
DROP TABLE IF EXISTS position;
CREATE TABLE position (
	position_id INT PRIMARY KEY AUTO_INCREMENT,
	position_name ENUM("Dev", "Test", "Scrum Master", "PM") 
);

-- Tạo bảng account
DROP TABLE IF EXISTS account;
CREATE TABLE account (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50),
    username VARCHAR(50),
    full_name VARCHAR(50),
    department_id INT,
    position_id INT,
    created_date DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (department_id)
        REFERENCES department (department_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (position_id)
        REFERENCES position (position_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
	group_id INT PRIMARY KEY AUTO_INCREMENT,
	group_name VARCHAR(50),
	creator_id INT,
	created_date DATE DEFAULT (CURRENT_DATE),
	FOREIGN KEY (creator_id)
		REFERENCES account (account_id)
		ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng group_account
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account (
	group_id INT,
	account_id INT,
	joined_date DATE DEFAULT (CURRENT_DATE),
	PRIMARY KEY (group_id, account_id),
	FOREIGN KEY (group_id)
		REFERENCES `group` (group_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (account_id)
		REFERENCES account (account_id)
		ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng type_question
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question (
	type_id INT PRIMARY KEY AUTO_INCREMENT,
	type_name ENUM("Essay", "Multiple-Choice") 
);

-- Tạo bảng category_question
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question (
	category_id INT PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(50) 
);

-- Tạo bảng question
DROP TABLE IF EXISTS question;
CREATE TABLE question (
	question_id INT PRIMARY KEY AUTO_INCREMENT,
	content VARCHAR(50),
	category_id INT,
	type_id INT,
	creator_id INT,
	created_date DATE DEFAULT (CURRENT_DATE),
	FOREIGN KEY (category_id)
		REFERENCES category_question (category_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (type_id)
		REFERENCES type_question (type_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (creator_id)
		REFERENCES account (account_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng answer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
	answer_id INT PRIMARY KEY AUTO_INCREMENT,
	content VARCHAR(50),
	question_id INT,
	is_correct BOOLEAN,
	FOREIGN KEY (question_id)
		REFERENCES question (question_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam (
	exam_id INT PRIMARY KEY AUTO_INCREMENT,
	code CHAR(10),
	title VARCHAR(50),
	category_id INT,
	duration INT,
	creator_id INT,
	created_date DATE DEFAULT (CURRENT_DATE),
	FOREIGN KEY (category_id)
		REFERENCES category_question (category_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (creator_id)
		REFERENCES account (account_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng exam_question
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question (
	exam_id INT,
	question_id INT,
	PRIMARY KEY (exam_id, question_id),
	FOREIGN KEY (exam_id)
		REFERENCES exam (exam_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (question_id)
		REFERENCES question (question_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Thêm dữ liệu cho bảng department
INSERT INTO department  (department_name)
VALUES                  ("Marketing"    ),
                        ("Sale"         ),
                        ("Bảo vệ"       ),
                        ("Nhân sự"      ),
                        ("Kỹ thuật"     ),
                        ("Tài chính"    ),
                        ("Phó giám đốc" ),
                        ("Giám đốc"     ),
                        ("Thư kí"       ),
                        ("Bán hàng"     ); 

-- Thêm dữ liệu cho bảng position
INSERT INTO position    (position_name )
VALUES                  ("Dev"         ),
                        ("Test"        ),
                        ("Scrum Master"),
                        ("PM"          );

-- Thêm dữ liệu cho bảng account
INSERT INTO account (email                           , username      , full_name           , department_id, position_id, created_date)
VALUES              ("haidang29productions@gmail.com", "dangblack"   , "Nguyen Hai Dang"   , 1            , 1          , "2019-01-15"),
                    ("account1@gmail.com"            , "quanganh"    , "Tong Quang Anh"    , 1            , 2          , "2020-02-25"),
                    ("account2@gmail.com"            , "vanchien"    , "Nguyen Van Chien"  , 1            , 3          , "2021-03-17"),
                    ("account3@gmail.com"            , "cocoduongqua", "Duong Do"          , 3            , 4          , "2022-03-08"),
                    ("account4@gmail.com"            , "doccocaubai" , "Nguyen Chien Thang", 4            , 4          , "2015-03-20"),
                    ("dapphatchetngay@gmail.com"     , "khabanh"     , "Ngo Ba Kha"        , 6            , 3          , "2016-04-05"),
                    ("songcodaoly@gmail.com"         , "huanhoahong" , "Bui Xuan Huan"     , 2            , 2          , "2017-04-14"),
                    ("sontungmtp@gmail.com"          , "tungnui"     , "Nguyen Thanh Tung" , 8            , 1          , "2018-04-18"),
                    ("duongghuu@gmail.com"           , "duongghuu"   , "Duong Van Huu"     , 9            , 2          , "2023-04-07"),
                    ("vtiaccademy@gmail.com"         , "vtiaccademy" , "Vi Ti Ai"          , 2            , 1          , "2024-04-29");

-- Thêm dữ liệu cho bảng group
INSERT INTO `group` (group_name        , creator_id, created_date)
VALUES              ("Testing System"  , 1        , "2019-03-15"),
                    ("Developement"    , 1        , "2020-03-27"),
                    ("VTI Sale 01"     , 2        , "2021-03-09"),
                    ("VTI Sale 02"     , 3        , "2022-01-10"),
                    ("VTI Sale 03"     , 3        , "2023-08-28"),
                    ("VTI Creator"     , 6        , "2024-08-06"),
                    ("VTI Marketing 01", 3        , "2024-10-17"),
                    ("Management"      , 8        , "2020-11-28"),
                    ("Chat with love"  , 9        , "2022-11-09"),
                    ("Vi Ti Ai"        , 3        , "2022-12-10");

-- Thêm dữ liệu cho bảng group_account
INSERT INTO group_account   (group_id, account_id, joined_date )
VALUES                      (1      , 1        , "2019-03-05"),
                            (2      , 1        , "2020-11-17"),
                            (3      , 1        , "2021-09-29"),
                            (4      , 1        , "2022-12-10"),
                            (5      , 5        , "2022-04-28"),
                            (2      , 6        , "2023-08-26"),
                            (7      , 2        , "2024-02-07"),
                            (3      , 8        , "2020-05-18"),
                            (2      , 2        , "2020-02-04"),
                            (10     , 10       , "2020-12-10");

-- Thêm dữ liệu cho bảng type_question
INSERT INTO type_question (type_name) VALUES ("Essay"), ("Multiple-Choice"); 

-- Thêm dữ liệu cho bảng category_question
INSERT INTO category_question   (category_name)
VALUES                          ("Java"       ),
                                ("ASP.NET"    ),
                                ("ADO.NET"    ),
                                ("SQL"        ),
                                ("Postman"    ),
                                ("Ruby"       ),
                                ("Python"     ),
                                ("C++"        ),
                                ("C Sharp"    ),
                                ("PHP"        ); 

-- Thêm dữ liệu cho bảng question
INSERT INTO question    (content          , category_id, type_id, creator_id, created_date)
VALUES                  ("Câu hỏi về Java", 1          , 1      , 1         , "2020-04-05"),
                        ("Câu Hỏi về PHP" , 1          , 2      , 2         , "2020-04-05"),
                        ("Hỏi về C#"      , 9          , 2      , 5         , "2020-04-06"),
                        ("Hỏi về Ruby"    , 6          , 1      , 5         , "2020-04-06"),
                        ("Hỏi về Postman" , 5          , 1      , 5         , "2020-04-06"),
                        ("Hỏi về ADO.NET" , 5          , 2      , 6         , "2020-04-06"),
                        ("Hỏi về ASP.NET" , 5          , 1      , 1         , "2020-04-06"),
                        ("Hỏi về C++"     , 5          , 1      , 8         , "2020-04-07"),
                        ("Hỏi về SQL"     , 4          , 2      , 3         , "2020-04-07"),
                        ("Hỏi về Python"  , 7          , 1      , 10        , "2020-04-07");

-- Thêm dữ liệu cho bảng answer
INSERT INTO answer  (content     , question_id, is_correct)
VALUES              ("Trả lời 01", 1          , 0         ),
                    ("Trả lời 02", 1          , 1         ),
                    ("Trả lời 03", 1          , 0         ),
                    ("Trả lời 04", 1          , 1         ),
                    ("Trả lời 05", 2          , 1         ),
                    ("Trả lời 06", 3          , 1         ),
                    ("Trả lời 07", 4          , 0         ),
                    ("Trả lời 08", 8          , 0         ),
                    ("Trả lời 09", 9          , 1         ),
                    ("Trả lời 10", 10         , 1         );

-- Thêm dữ liệu cho bảng exam
INSERT INTO exam    (code     , title           , category_id, duration, creator_id, created_date)
VALUES              ("VTIQ001", "Đề thi C#"     , 1          , 60      , 1         , "2019-04-05"),
                    ("VTIQ002", "Đề thi PHP"    , 1          , 60      , 1         , "2019-04-05"),
                    ("VTIQ003", "Đề thi C++"    , 9          , 120     , 2         , "2019-04-07"),
                    ("VTIQ004", "Đề thi Java"   , 2          , 60      , 3         , "2020-04-08"),
                    ("VTIQ005", "Đề thi Ruby"   , 2          , 120     , 4         , "2020-04-10"),
                    ("VTIQ006", "Đề thi Postman", 2          , 60      , 6         , "2020-04-05"),
                    ("VTIQ007", "Đề thi SQL"    , 2          , 60      , 1         , "2020-04-05"),
                    ("VTIQ008", "Đề thi Python" , 8          , 60      , 8         , "2020-04-07"),
                    ("VTIQ009", "Đề thi ADO.NET", 4          , 90      , 3         , "2020-04-07"),
                    ("VTIQ010", "Đề thi ASP.NET", 7          , 90      , 1         , "2020-04-08");

-- Thêm dữ liệu cho bảng exam_question
INSERT INTO exam_question   (question_id, exam_id)
VALUES                      (1         , 1      ),
                            (2         , 2      ),
                            (3         , 1      ),
                            (4         , 4      ),
                            (5         , 1      ),
                            (6         , 2      ),
                            (7         , 1      ),
                            (8         , 8      ),
                            (9         , 2      ),
                            (10        , 10     );