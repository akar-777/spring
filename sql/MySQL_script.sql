create database football;

CREATE TABLE `matches` (
  `matchId` int NOT NULL,
  `homeTeamName` int NOT NULL,
  `awayTeamName` int NOT NULL,
  `homeTeamGoal` int DEFAULT NULL,
  `awayTeamGoal` int DEFAULT NULL,
  `homeTeamPreGoal` int DEFAULT NULL,
  `awayTeamPreGoal` int DEFAULT NULL,
  `score` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`matchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teams` (
  `teamId` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `shortName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teamId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;