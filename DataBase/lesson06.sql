-- STORED PROCEDURE: Thủ tục lưu trữ 
-- VD: Tìm kiếm department theo id
DROP PROCEDURE IF EXISTS sp_01;

DELIMITER $$
CREATE PROCEDURE sp_01 (IN in_department_id INT)
BEGIN
	SELECT *
	FROM department
	WHERE department_id = in_department_id;
END $$
DELIMITER ;

-- Gọi thủ tục 
CALL sp_01(9);

-- Tham số IN

DROP PROCEDURE IF EXISTS sp_02;

DELIMITER $$
CREATE PROCEDURE sp_02 (IN in_a INT, IN in_b INT)
BEGIN
	SELECT in_a;
	SELECT in_b;
	SELECT in_a + in_b;
	
END $$
DELIMITER ;

-- Tạo biến
SET @a = 1;
SET @b = 2;
CALL sp_02(@a,@b);

-- Tham số: OUT 
DROP PROCEDURE IF EXISTS sp_03;
DELIMITER $$
CREATE PROCEDURE sp_03 (OUT out_result INT)
BEGIN
	SELECT 100 INTO out_result;
END $$
DELIMITER ;

SET @result = 0;
CALL sp_03 (@result);
SELECT @result;

-- Tham số: INOUT (Kết hợp IN và OUT)

-- LOCAL VARIABLE: Biến cục bộ
-- VD: Lấy ra nhân viên thuộc phòng ban "Sale"
DROP PROCEDURE IF EXISTS sp_04;
DELIMITER $$
CREATE PROCEDURE sp_04 ()
BEGIN
    DECLARE v_department_id INT;
    
    SELECT department_id INTO v_department_id
    FROM department
    WHERE department_name = "Sale";
    SELECT *
    FROM account
    WHERE department_id = v_department_id;
END $$
DELIMITER ;
CALL sp_04();

-- FUNCTION: Hàm
-- VD: Tạo function trả về tên phòng ban theo id
DROP FUNCTION IF EXISTS fn_01;
DELIMITER $$
CREATE FUNCTION fn_01 (in_department_id INT) RETURNS VARCHAR(50)
BEGIN
    DECLARE v_department_name VARCHAR(50);
    
    SELECT department_name INTO v_department_name
    FROM department
    WHERE department_id = in_department_id;
    
    RETURN v_department_name;
END $$
DELIMITER ;
-- Sử dụng function
SELECT fn_01(5);
SET GLOBAL log_bin_trust_function_creators = 1;


