-- 1. Exercise 1:
DROP DATABASE IF EXISTS extra_01;
CREATE DATABASE extra_01;
USE extra_01;
-- Database để quản lý fresher, có table Trainee với các trường như sau:
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee (
-- • TraineeID: định danh của thực tập sinh (auto increment)
	Trainee_id INT PRIMARY KEY AUTO_INCREMENT,
-- • Full_Name: tên đầy đủ của thực tập sinh
	full_name VARCHAR(50),
-- • Birth_Date: ngày sinh của thực tập sinh
	birth_date DATE,
-- • Gender: chỉ có 3 giá trị male, female, and unknown
	gender ENUM('male', 'female', 'unknown'),
-- • ET_IQ: Entry test point (IQ) - Điểm test đầu vào của thực tập sinh (integer có
-- giá trị từ 0 -> 20)
	et_iq INT CHECK (et_iq BETWEEN 0 AND 20) ,
-- • ET_Gmath: Entry test point (Gmath) - Điểm test đầu vào của thực tập sinh
-- (integer có giá trị từ 0 -> 20)
	et_gmath INT CHECK (et_gmath BETWEEN 0 AND 20) ,
-- • ET_English: Entry test point (English) - Điểm test đầu vào của thực tập sinh
-- (integer có giá trị từ 0 -> 50)
	et_english INT CHECK (et_english BETWEEN 0 AND 50) ,
-- • Training_Class: mã lớp của thực tập sinh đang học
	training_class INT,
-- • Evaluation_Notes: 1 vài note đánh giá (free text).
	evaluation_notes TEXT
)











