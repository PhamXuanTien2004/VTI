-- Mệnh đề SELECT
SELECT
    CURRENT_DATE AS "today",
    PI() AS PI,
    1 + 2 AS sum,
    "MySQL" AS "language";

-- Mệnh đề FROM
-- VD: Lấy ra tất cả phòng ban
SELECT department_id, department_name
FROM department;
-- VD: Lấy ra tất cả đề thi
SELECT *
FROM exam;
-- VD: Lấy ra duration (không trùng nhau) trong đề thi
SELECT DISTINCT duration
FROM exam;

-- Mệnh đề WHERE
-- Toán tử so sánh: >, >=, <, <=, =, != (<>)
-- VD: Lấy ra phòng ban có id > 5
select department_id, department_name
from department;
-- vd: lấy tất cả đề thi
select *
from exam;
-- vd: lấy ra duration (k trùng nhau )
select distinct duration
from exam;

-- mệnh đề where
-- toán tử so sánh: >, >=,<,<=, =, != (<>)
-- vd:l lấy phòng ban có id>5
SELECT *
FROM department
WHERE department_id > 5;
-- toán tử quan hệ and or
-- vd:l lấy phòng ban có id>5
select *
from deparment
where deparment_id > 5;








select *
from department
where department_id in (2,4,6,8); 
-- toán tử like/not like
-- _ là đại diện cho 1 ký tự bất kỳ 
-- % là đại diện cho không hoặc nhiều ký tự bất kỳ 
-- vd: lấy ra phòng ban chứa ký tự "n"
select *
from department
where department_name LIKE "n%";
-- toán tử null/not null
SELECT * 
FROM department 
WHERE department_name IS NOT NULL ;

-- mệnh đề order by
-- tăng dần asc mặc định
-- giảm dần desc 
-- vd: lấy ta đề thi tăng dần theo created_date
select *
from exam
order by created_date asc;
-- vd: lấy ra đề thi duration tăng dần, create_date giảm dần
select *
from exam
order by 
	duration asc ,
	created_date desc;

-- menh de limit
-- vd lay ra phong ban co id lon nhat 
select *
from department
order by department_id desc
limit 1;







