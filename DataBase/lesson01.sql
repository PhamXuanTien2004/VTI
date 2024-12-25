-- hiện thị danh sách database
SHOW DATABASES;

-- xóa database nếu tồn tại 
DROP DATABASE IF EXISTS lesson_01;

-- Tạo database
CREATE DATABASE lesson_01;

-- CÁC KIỂU DỮ LIỆu
-- SỐ NGUYÊN: TINYINT SMALLINT MEDIUMINT INT BIG INT\
-- SỐ THỰC: FLOAT DOUBLE
-- LOGIC: BOOLEAN (TRUE HOẶC FALSE)
-- CHUỖI KÝ TỰ (STRING): CHAR, VARCHAR
-- THOI GIAN: DATE(YYYY-MM-DD  HH:MM:SS)
-- ENUM: tập hợp hữu hạn các giá trị 
-- ENUM("MALE", "FEMALE", "UNKNOWN")
-- gender: Male, Female, Unknown

-- CHỌN DATABASE
USE lesson_01;

-- hiển thị danh sách các table
SHOW TABLES;

-- TẠO TABLE
CREATE TABLE customer(
	id INT UNSIGNED,
    name VARCHAR(50),
    birthdate DATE,
    active BOOLEAN    
);

-- MÔ TẢ TABLE
DESCRIBE customer;

-- DDL table
SHOW CREATE TABLE customer;

-- thêm dữ liệu vào table
INSERT INTO	customer(id, name, birthdate, active)
VALUES (1,"Tiến", "2004-04-01", TRUE),
	   (2,"Tâm", "2006-10-19", false);
       
 -- xem dữ liệu trong table
 TABLE 	customer;
       
-- ràng buộc dữ liệu (constraints)
-- NULL/ NOT NULL 
CREATE TABLE student(
    name VARCHAR(50) NOT NULL
);

 -- unique key: duy nhất 
 CREATE TABLE account(
    email VARCHAR(50) UNIQUE
);

-- primary key: khóa chính
-- yêu cầu: UNIQUE + NOT NULL
-- 1. một bảng có tối đa 1 khóa chính
-- 2. một khóa chính có thể gồm nhiều cột 
-- AUTO_INCREMENT: Tự động tăng
-- VD: Khóa chính 1 cột
CREATE TABLE product (
	id INT PRIMARY KEY AUTO_INCREMENT
);

-- VD khóa chính 2 cột
CREATE TABLE group_user (
	user_id INT NOT NULL,
    group_id INT NOT NULL,
    joined_date DATE,
    PRIMARY KEY (user_id, group_id)
);

-- DEFAULT: mặc định       
 CREATE TABLE department (
	name varchar(50) default "Phong cho",
    created_date DATE DEFAULT (current_date())
);     

create table UI(
	state ENUM("Loading", "Success")
); 
insert into ui (state)
values ("L)ading");

-- CHECK TABLE: kiem tra gia tri
create table user(
	age INT CHECK (age >=18)
);	
insert into user(age)
values (17);

-- Foreign key: khóa ngoại 
-- sự kiện: UPDATE, DELETE
-- Hành động: RESTRICT (Cấm), SET DEFAULT (con default), SET NULL, CASEDE (Bố sao con vậy)
create table department (
	id INT,
    name VARCHAR(50)
);

create table account (
	id INT,
	department_id INT,
    -- tạo 1 mũi tên xuất phát từ department_id chỉ tới id ở department
    foreign key (department_id) 
		references department (id)
        on update cascade 
        on delete cascade
);














       
       