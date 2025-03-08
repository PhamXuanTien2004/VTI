DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- Tao bang 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			VARCHAR(50) NOT NULL
);

-- Thêm dữ liệu cho bảng Department
INSERT INTO Department(DepartmentName) VALUES 
						('Trainee'		),
						('Sale'			),
						('Bảo vệ'		),
						('Nhân sự'		),
						('Kỹ thuật'		),
						('Tài chính'	),
						('Phó giám đốc'	),
						('Giám đốc'		),
						('Thư kí'		),
						('Bán hàng'		);
