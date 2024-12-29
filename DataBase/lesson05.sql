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
