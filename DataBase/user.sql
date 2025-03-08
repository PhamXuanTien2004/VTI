DROP DATABASE IF EXISTS Final_Demo;
CREATE DATABASE Final_Demo ;
USE Final_Demo;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    FullName VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL UNIQUE,
    `PassWord` VARCHAR(12) NOT NULL,
    `Role` ENUM('Admin', 'Employee') NOT NULL,
    ExpInYear INT, 
    ProSkill VARCHAR(50),
    CHECK (`Role` = 'Admin' OR ProSkill IS NOT NULL), 
    CHECK (`Role` = 'Employee' OR ExpInYear IS NOT NULL)
);

INSERT INTO `User` (FullName, Email, `PassWord`, `Role`, ExpInYear, ProSkill)
VALUES  
    (N'Phạm Xuân Tiến' , 'px.tien.2004@gmail.com'    , 'Pxtien'  , 'Admin'   , 5 , NULL),
    (N'Phạm Xuân Tâm'  , 'px.tam.2006@gmail.com'     , 'Pxtam'   , 'Employee', NULL, 'java'),
    (N'Phạm Xuân Quỳnh', 'px.quynh.1973@gmail.com'   , 'Pxtquynh', 'Admin'   , 10 , NULL),
    (N'Đỗ Thị Diệp'    , 'dothi.diep.1978@gmail.com' , 'Dotdiep' , 'Employee', NULL, 'test'),
    (N'Vũ Thùy Dương'  , 'duongvu.2006@gmail.com'    , 'Duongvu' , 'Admin'   , 7 , NULL),
    (N'Nguyễn Văn A'   , 'nguyen.vana.2005@gmail.com', 'Nvana'   , 'Employee', NULL, 'dev' );
