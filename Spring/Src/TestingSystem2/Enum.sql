DROP DATABASE IF EXISTS testingsystem;
CREATE DATABASE testingsystem;
USE testingsystem;
-- create table 1: Article ORDINAL
DROP TABLE IF EXISTS Article;
CREATE TABLE Article(
	id 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title				NVARCHAR(50) NOT NULL UNIQUE KEY,
    `status` 			TINYINT UNSIGNED NOT NULL -- 0: Open, 1: Review, 2: Approved, 3: rejected
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Article
INSERT INTO Article		(title,		 	`status`) 
VALUES
						('Article 1',		0	),
						('Article 2',		1	),
						('Article 3',		2	);

-- ===================================================================

-- create table 1: Article STRING
DROP TABLE IF EXISTS Article;
CREATE TABLE Article(
	id 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title				NVARCHAR(50) NOT NULL UNIQUE KEY,
    `status` 			ENUM('OPEN','REVIEW','APPROVED','REJECTED') NOT NULL
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Article
INSERT INTO Article		(title,		 	`status`		) 
VALUES
						('Article 1',		'OPEN'		),
						('Article 2',		'REVIEW'	),
						('Article 3',		'APPROVED'	);

-- ===================================================================

-- create table 1: Article CONVERTER
DROP TABLE IF EXISTS Article;
CREATE TABLE Article(
	id 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title				NVARCHAR(50) NOT NULL UNIQUE KEY,
    `status` 			ENUM('O','REV','A','REJ') NOT NULL -- O: OPEN, REV: REVIEW, A: APPROVED, REJ: REJECTED
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Article
INSERT INTO Article		(title,		 	`status`		) 
VALUES
						('Article 1',		'O'		),
						('Article 2',		'REV'	),
						('Article 3',		'A'	);