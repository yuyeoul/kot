DROP DATABASE IF EXISTS kot;
CREATE DATABASE kot;

USE kot;

DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Image`;
DROP TABLE IF EXISTS `MatchResult`;
DROP TABLE IF EXISTS `match_wait`;
DROP TABLE IF EXISTS `Board`;
DROP TABLE IF EXISTS `Reply`;

CREATE TABLE `User` (
	`userId`	INT PRIMARY KEY AUTO_INCREMENT,
	`name`	VARCHAR(30)	NOT NULL,
	`loginId`	VARCHAR(30)	NOT NULL,
	`pass`	VARCHAR(30)	NOT NULL,
	`email`	VARCHAR(30)	NOT NULL,
	`phone`	VARCHAR(30)	NOT NULL,
	`gender`	VARCHAR(30)	NOT NULL,
	`age`	VARCHAR(30)	NOT NULL,
	`address`	VARCHAR(50)	NOT NULL,
	`regDate`	datetime	NOT NULL,
	`rate`	int	NOT NULL,
	`status`	boolean	NOT NULL
);

INSERT INTO `User`(`name`, `loginId`, `pass`,`email`,`phone`,`gender`,`age`,`address`,`regdate`,`rate`,`status`) VALUES
('김중광','jg','1234', 'jg@ssafy.com', '010-1111-1111','m',26,'경기도 화성시',now(),1043,FALSE),
('김소광','sg','1234', 'sg@ssafy.com', '010-1111-2222','m',27,'경기도 화성시',now(),1230,FALSE),
('김대광','dg','1234', 'dg@ssafy.com', '010-1111-3333','m',28,'경기도 화성시',now(),1190,FALSE),
('전금평','gp','1234', 'gp@ssafy.com', '010-2222-1111','m',29,'서울시 양천구',now(),790,FALSE),
('전은평','ep','1234', 'ep@ssafy.com', '010-2222-2222','m',28,'서울시 양천구',now(),936,FALSE),
('전동평','dp','1234', 'dp@ssafy.com', '010-2222-3333','m',27,'서울시 양천구',now(),1341,FALSE),
('김유경','kim','1234', 'kim@ssafy.com', '010-3333-1111','f',25,'서울시 서초구',now(),1230,FALSE),
('권유경','kwon','1234', 'kwon@ssafy.com', '010-3333-2222','f',27,'서울시 강남구',now(),1278,FALSE),
('정유경','jeong','1234', 'jeong@ssafy.com', '010-3333-3333','f',27,'서울시 관악구',now(),1018,FALSE),
('문성현','nanto','1234', 'nanto@ssafy.com', '010-4444-1111','f',28,'서울시 마포구',now(),1823,FALSE),
('배유열','array','1234', 'array@ssafy.com', '010-4444-2222','m',28,'경기도 과천시',now(),1983,FALSE),
('석지명','jm','1234', 'jm@ssafy.com', '010-5555-1111','m',29,'서울시 성동구',now(),573,FALSE),
('석지순','js','1234', 'js@ssafy.com', '010-5555-2222','f',29,'서울시 성동구',now(),680,FALSE),
('김남준','nj','1234', 'nj@ssafy.com', '010-5555-3333','m',28,'서울시 관악구',now(),1326,FALSE),
('김남순','ns','1234', 'ns@ssafy.com', '010-5555-4444','f',28,'서울시 관악구',now(),1490,FALSE),
('조용환','yh','1234', 'yh@ssafy.com', '010-5555-5555','m',29,'경기도 성남시',now(),1978,FALSE),
('조용순','ys','1234', 'ys@ssafy.com', '010-5555-6666','f',29,'경기도 성남시',now(),1632,FALSE),
('김갑현','gh','1234', 'gh@ssafy.com', '010-6666-1111','m',29,'경기도 수원시',now(),349,FALSE),
('김병현','bh','1234', 'bh@ssafy.com', '010-6666-3333','m',29,'경기도 수원시',now(),934,FALSE);


CREATE TABLE `image` (
	`imgId` INT PRIMARY KEY AUTO_INCREMENT,
    `loginId` VARCHAR(30) NOT NULL,
    `orgTitle` VARCHAR(100) NOT NULL,
    `newTitle` VARCHAR(100) NOT NULL,
    `path` VARCHAR(100) NOT NULL,
    `contentType` VARCHAR(30) NOT NULL,
    FOREIGN KEY(loginId) REFERENCES user(loginID)
);

CREATE TABLE `matchwait` (
	`matchId`	INT PRIMARY KEY AUTO_INCREMENT,
	`userId`	int	NOT NULL,
	`sender`	VARCHAR(30)	NOT NULL,
	`receiver`	VARCHAR(30)	NOT NULL,
	`status`	boolean	NOT NULL,
	`match`	boolean	NOT NULL,
	`mdate`	DATE	NOT NULL,
    FOREIGN KEY(userId)REFERENCES user(userId)
);

CREATE TABLE `MatchResult` (
	`matchingId`	INT PRIMARY KEY AUTO_INCREMENT,
	`matchId`	int	NOT NULL,
	`user1`	VARCHAR(30)	NOT NULL,
	`user2`	VARCHAR(30)	NOT NULL,
	`matchDate`	datetime	NOT NULL,
	`fdate`	datetime	NULL,
	`result`	VARCHAR(30)	NULL,
    FOREIGN KEY(matchId)REFERENCES matchwait(matchId)
);

CREATE TABLE `Board` (
	`boardId`	INT PRIMARY KEY AUTO_INCREMENT,
	`userId`	int	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(500)	NOT NULL,
	`regdate`	datetime	NOT NULL,
	`view`	int	NOT NULL,
	`delstatus`	boolean	NOT NULL,
	FOREIGN KEY(userId)REFERENCES user(userId)
);

INSERT INTO Board(userId,title,content,regdate,view,delstatus) VALUES
(1,'안녕','안녕하세요',now(),12,false),
(1,'반가워','반가워요',now(),1,false),
(1,'잘가','잘가세요',now(),2,false),
(1,'배고프네','배고파요',now(),123,false),
(1,'춥다','추워요',now(),122,true),
(1,'커피','속쓰려',now(),111,false),
(1,'역삼','가기싫다',now(),5,false);

CREATE TABLE `Reply` (
	`replyId`	INT PRIMARY KEY AUTO_INCREMENT,
	`boardId`	int	NOT NULL,
	`userId`	int	NOT NULL,
	`content`	VARCHAR(500)	NOT NULL,
	`regdate`	datetime	NOT NULL,
	`delstatus`	boolean	NOT NULL,
    FOREIGN KEY(userId)REFERENCES user(userId),
    FOREIGN KEY(boardId)REFERENCES board(boardId)
);



