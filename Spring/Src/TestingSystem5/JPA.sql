-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TotalMember				TINYINT	UNSIGNED,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department(DepartmentName, TotalMember) 
VALUES
						(N'Marketing'	, 1),
						(N'Sale'		, 2),
						(N'Bảo vệ'		, 3),
						(N'Nhân sự'		, 4),
						(N'Kỹ thuật'	, 5),
						(N'Tài chính'	, 6),
						(N'Phó giám đốc', 7),
						(N'Giám đốc'	, 8),
						(N'Thư kí'		, 9),
						(N'Bán hàng'	, 10);