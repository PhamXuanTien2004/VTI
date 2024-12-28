DROP DATABASE IF EXISTS lesson_04;
CREATE DATABASE lesson_04;
USE lesson_04;

DROP TABLE IF EXISTS boy;
CREATE TABLE boy (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS girl;
CREATE TABLE girl (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

INSERT INTO boy (id, name   )
VALUES          (1 , "Khoa" ),
                (2 , "Duy"  ),
                (3 , "Hùng" ),
                (4 , "Cường"),
                (6 , "Linh" );

INSERT INTO girl (id, name      )
VALUES           (1 , "Thương"  ),
                 (2 , "Ngọc Anh"),
                 (5 , "Trang"   ),
                 (6 , "Linh"    );
                 
-- mệnh đề JOIN
-- nối với nhau xem chiều ngang
-- inner join
-- vd: lấy ra các cặp có id giống nhau                 
select *
from boy
join girl on boy.id=girl.id;
-- từ khóa using
-- điều kiện
-- tên cột giống nhau
-- liên kết với nhau bởi dấu =
select *
from boy
inner join girl using(id);                 

-- chú ý viết trước bên trái viết sau bên phải
-- left join
select *
from boy
left join girl using(id);                 
                 
-- left/ right excluding join
-- lấy ra phần k giao nhau 
-- giống join thêm Where A. khóa chính is null
select *
from boy
left join girl using(id)
where girl.id is null;

-- cross join 1 phần tử ở bảng A 
-- nối với tất cả các dòng ở bảng B
SELECT *
from boy
cross join girl;

-- union/ union all
-- ghép theo chiều dọc 
-- union: loại bỏ dòng trùng nhau 
-- union all in ra 
-- điều kiện số lượng cột giống nhau 
SELECT *
FROM boy
UNION
SELECT *
FROM girl;

-- intersect: phép giao 2 tập hợp 
SELECT *
FROM boy
intersect 
SELECT *
FROM girl;

-- except: Phép trừu 2 tập hợp
SELECT *
FROM girl;
except
SELECT *
FROM boy;










                 
                 
                 
                 