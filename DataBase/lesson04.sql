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
                 
                 
                 
                 
                 