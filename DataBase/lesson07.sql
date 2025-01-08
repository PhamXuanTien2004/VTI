-- Local Variable: biến cục bộ 
-- Scope Phạm vi: trong khối Begin End
-- DECLARE

DROP PROCEDURE IF EXISTS sp_01;
DELIMITER $$
CREATE PROCEDURE sp_01 ()
BEGIN
    DECLARE a INT DEFAULT 100;
    SELECT a;
END $$
DELIMITER ;

CALL sp_01();

-- Session Variable: Biến session 
-- Scope: Trong 1 phiên lm vc
Set @a=110;

DROP PROCEDURE IF EXISTS sp_02;
DELIMITER $$
CREATE PROCEDURE sp_02 ()
BEGIN
    SELECT @a;
END $$
DELIMITER ;

CALL sp_02();

DROP PROCEDURE IF EXISTS sp_03;
DELIMITER $$
CREATE PROCEDURE sp_03 ()
BEGIN
    SELECT @a;
END $$
DELIMITER ;

CALL sp_03();
-- GLOBAL VARIABLE: Biến toàn cục
-- Phạm vi: Toàn bộ MySQL
SHOW VARIABLES;
SET GLOBAL connect_timeout = 3;

-- TRIGGER
-- Thời điểm: BEFORE, AFTER
-- Sự kiện: INSERT, UPDATE, DELETE
-- Tham chiếu: NEW, OLD
-- NEW: Bản ghi mới
-- OLD: Bản ghi cũ
-- VD:
DROP TRIGGER IF EXISTS trigger_01;
DELIMITER $$
CREATE TRIGGER trigger_01
BEFORE INSERT ON group_account
FOR EACH ROW
BEGIN
    IF NEW.joined_date > CURRENT_DATE THEN
        SIGNAL SQLSTATE "12345"
        SET MESSAGE_TEXT = "Thời gian tham gia không hợp lệ";
    END IF;
END $$
DELIMITER ;

INSERT INTO group_account   (group_id, account_id, joined_date )
VALUES                      (5       , 1         , "2030-03-05");



