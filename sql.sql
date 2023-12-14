CREATE TABLE `User` (
	`userId`	int	NOT NULL,
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

CREATE TABLE `MatchResult` (
	`matchingId`	int	NOT NULL,
	`matchId`	int	NOT NULL,
	`userId`	int	NOT NULL,
	`user1`	VARCHAR(30)	NOT NULL,
	`user2`	VARCHAR(30)	NOT NULL,
	`matchDate`	datetime	NOT NULL,
	`fdate`	datetime	NULL,
	`result`	VARCHAR(30)	NULL
);

CREATE TABLE `match_wait` (
	`matchId`	int	NOT NULL,
	`userId`	int	NOT NULL,
	`sender`	VARCAHAR(30)	NOT NULL,
	`receiver`	VARCHAR(30)	NOT NULL,
	`status`	boolean	NOT NULL,
	`match`	boolean	NOT NULL,
	`mdate`	DATE	NOT NULL
);

CREATE TABLE `Board` (
	`boardId`	int	NOT NULL,
	`userId`	int	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(500)	NOT NULL,
	`regdate`	datetime	NOT NULL,
	`view`	int	NOT NULL,
	`delstatus`	boolean	NOT NULL
);

CREATE TABLE `Reply` (
	`replyId`	int	NOT NULL,
	`boardId`	int	NOT NULL,
	`userId`	int	NOT NULL,
	`content`	VARCAHR(500)	NOT NULL,
	`regdate`	datetime	NOT NULL,
	`delstatus`	boolean	NOT NULL
);

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`userId`
);

ALTER TABLE `MatchResult` ADD CONSTRAINT `PK_MATCHRESULT` PRIMARY KEY (
	`matchingId`
);

ALTER TABLE `match_wait` ADD CONSTRAINT `PK_MATCH_WAIT` PRIMARY KEY (
	`matchId`
);

ALTER TABLE `Board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`boardId`
);

ALTER TABLE `Reply` ADD CONSTRAINT `PK_REPLY` PRIMARY KEY (
	`replyId`
);

