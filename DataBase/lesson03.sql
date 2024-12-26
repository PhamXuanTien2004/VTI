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


-- Aggregate funcion -  Các hàm tổng hợp 
-- count, sum - tổng, min, max, avg
-- count(*) đếm số dòng
-- count (duration) đếm số dòng của duration khác null
-- count (distinct duration) đếm số dòng của duration có gtri khac nhau
-- chú ý: áp dụng cho các giá trị khác null
-- vd: lấy ra công việc
SELECT COUNT(*) 
FROM department;
-- vd: lấy ta số lượng tgian thi
select 
	count(*),
    count(duration),
    count( distinct duration),
    count(3)
from exam;

-- mệnh đề group by
-- vd: thống kê mỗi chức vụ có bnh nhân viên
SELECT position_id, count(account_id) as account_count
from account
group by position_id;
 
-- mệnh đề having
SELECT *
from account
group by position_id
having count(account_id) >2;

-- cập nhật dữ liệu
-- vd: đổi tên phòng ban số 1 thành phòng chờ
UPDATE department
SET department_name = "Phòng chờ"
WHERE department_id = 1;

-- xóa dữ liệu
-- vd: xóa phòng ban số 1
DELETE from department
where department_id=1;








