DROP DATABASE IF EXISTS Final_Demo;
CREATE DATABASE Final_Demo;
USE Final_Demo;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    FullName VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL UNIQUE,
    `PassWord` VARCHAR(12) NOT NULL
);

DROP TABLE IF EXISTS Manager;
CREATE TABLE Manager (
    id INT PRIMARY KEY,
    ExpInYear INT NOT NULL,
    ProjectId INT NOT NULL,
    FOREIGN KEY (id) REFERENCES `User`(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    id INT PRIMARY KEY, 
    ProjectId INT NOT NULL,
    ProSkill VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES `User`(id) ON DELETE CASCADE
);

INSERT INTO `User` (FullName, Email, `PassWord`)
 VALUES  
     (N'Phạm Xuân Tiến' , 'px.tien.2004@gmail.com'    , 'Pxtien'  ),
     (N'Phạm Xuân Tâm'  , 'px.tam.2006@gmail.com'     , 'Pxtam'   ),
     (N'Phạm Xuân Quỳnh', 'px.quynh.1973@gmail.com'   , 'Pxtquynh'),
     (N'Đỗ Thị Diệp'    , 'dothi.diep.1978@gmail.com' , 'Dotdiep' ),
     (N'Vũ Thùy Dương'  , 'duongvu.2006@gmail.com'    , 'Duongvu' ),
     (N'Nguyễn Văn A'   , 'nguyen.vana.2005@gmail.com', 'Nvana'   );
     
INSERT INTO Manager (Id, ExpInYear, ProjectId)
VALUES
	(1, 3, 1),
    (3, 6, 2),
    (6, 2, 2);
    
INSERT INTO Employee (id, ProSkill, ProjectId)
VALUES
    (2, 'java',1),
    (4, 'dev',2),
    (5, 'test',1);

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
