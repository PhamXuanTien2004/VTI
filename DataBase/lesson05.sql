-- Subquery: truy vấn con 
-- được bọc ở trong ngược tròn 
-- vd: lấy ra department của account có id =2
SELECT *
FROM account
JOIN department USING (department_id)
WHERE account_id=2;

-- dùng truy vấn con
SELECT department_name
FROM department
WHERE department_id IN 
	(
		SELECT department_id
		FROM account
		WHERE account_id=2
    );
 
-- toán tử: in, any, exists
-- any chỉ cần bằng 1 trong cách giá trị con 
-- all bằng tất cả các giá trị
-- exists: tồn tại 
-- VD: Lấy ra department của account có id > 2
SELECT department_name
FROM department
WHERE department_id = ANY
    (SELECT department_id
    FROM account
    WHERE account_id > 2);
    
-- vd: lấy ra câu hỏi có nhiều caai trả lời nhất
SELECT question.*	, count(answer_id) as answer_count
FROM question
LEFT JOIN answer USING(question_id)
GROUP BY question_id
HAVING count(answer_id) =( 
	SELECT MAX(answer_count)
	FROM (SELECT count(answer_id) as answer_count
		FROM question
		LEFT JOIN answer USING(question_id)
		GROUP BY question_id) as t);
    
SELECT question.*	, count(answer_id) as answer_count
FROM question
LEFT JOIN answer USING(question_id)
GROUP BY question_id
HAVING count(answer_id) >= ALL (
    SELECT count(answer_id) as answer_count
	FROM question
	LEFT JOIN answer USING(question_id)
	GROUP BY question_id);
    
 -- View : Bảng ảo
 -- Vd: tạo view chứa tất cả phòng ban
DROP VIEW IF EXISTS view_01;
CREATE OR REPLACE VIEW view_01 AS
SELECT *
FROM department;
SELECT *
FROM view_01;

-- CTE: bảng tạm - tờ nháp 
-- VD: lấy ra câu hỏi có nhiều câu trả lời nhất
 WITH c1 AS (
	SELECT question.*, count(answer_id) as answer_count
    FROM question
    LEFT JOIN answer USING(question_id)
    GROUP BY question_id
)
SELECT *
FROM c1
WHERE answer_count = 
	(SELECT MAX(answer_count)
	FROM c1);
    
-- CTE RECURSIVE
--  ví dụ: tạo cột tháng đánh số từ 1 -> 12
WITH RECURSIVE c1 (thang) AS (
	SELECT 1 
    UNION ALL
    SELECT thang + 1
    FROM c1
    WHERE thang <12
)
SELECT *
FROM c1;
 
 -- VD: Thống kê mỗi tháng có bnh năm 
WITH RECURSIVE c1 (thang) AS (
	SELECT 1 
    UNION ALL
    SELECT thang + 1
    FROM c1
    WHERE thang <12
),
c2 AS(
	SELECT *, month(created_date) AS thang
	FROM account
)
SELECT thang, count(account_id)
FROM c1
LEFT JOIN c2 USING(thang)
GROUP BY thang;
 

 
 
 
 
 
 
 
 