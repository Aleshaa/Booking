CREATE DATABASE IF NOT EXISTS `booking_db` /*!40100 DEFAULT CHARACTER SET latin1*/;  
USE `booking_db`;  

DROP TABLE IF EXISTS `Check_r`;
DROP TABLE IF EXISTS `Reservation`;
DROP TABLE IF EXISTS `Room`;
DROP TABLE IF EXISTS `TypeRoom`;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Role`;
DROP TABLE IF EXISTS `Picture`;

CREATE TABLE IF NOT EXISTS `Picture` (
  `idPicture` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `FileName` VARCHAR(45) NOT NULL,
  `UploadedNname` VARCHAR(45) NOT NULL,
  `Width` INT NOT NULL,
  `Height` INT NOT NULL,
  PRIMARY KEY (`idPicture`),
  UNIQUE INDEX `idPicture_UNIQUE` (`idPicture` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `picture` VALUES(1, "pic1", "pic1.jpg", 200, 200),(2, "pic2", "pic2.jpg", 200, 200),(3, "pic3", "pic3.jpg", 200, 200);

CREATE TABLE IF NOT EXISTS `Role` (
	`idRole` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `NameRole` VARCHAR(45) NOT NULL,
	PRIMARY KEY (`idRole`),
    UNIQUE INDEX `idRole_UNIQUE` (`idRole` ASC),
    UNIQUE INDEX `NameRole_UNIQUE` (`NameRole` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `role` VALUES(1,'ROLE_ADMIN'),(2,'ROLE_USER');

CREATE TABLE IF NOT EXISTS `User` (
  `idUser` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idRole` INT UNSIGNED NOT NULL,
  `SecondName` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `Patronymic` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `DOB` DATE NOT NULL,
  `Sex` boolean NOT NULL,
  `PassportSeries` VARCHAR(45) NOT NULL,
  `PassportN` INT(45) NOT NULL,
  `IdentificationN` VARCHAR(45) NOT NULL,
  `Cash` DECIMAL(64,3) NOT NULL,
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC),
  UNIQUE INDEX `IdentificationN_UNIQUE` (`IdentificationN` ASC),
  CONSTRAINT `idRole` FOREIGN KEY (`idRole`) REFERENCES `Role` (`idRole`) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (`idUser`)
 )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

insert into `User` values(1,1,"Kurganovich","Alexey","Andrevich","Adminn","$2a$11$O5/3AFMwU9zodHlzKzGUH.dt5LjG12N.MsOscr3TCooImvr2ydGcm","1996-03-30", true, "MP", 3039657, "330A014PB1", 10000);
insert into `User` values(2,2,"Bakan","Vladislav","Dmitrievich","Userrr","$2a$11$O5/3AFMwU9zodHlzKzGUH.dt5LjG12N.MsOscr3TCooImvr2ydGcm","1992-01-22", true, "MС", 2219257, "122A014PB1", 10000);

CREATE TABLE IF NOT EXISTS `TypeRoom` (
  `idTRoom` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `NameTRoom` VARCHAR(45) NOT NULL,
  `Roominess` INT NOT NULL,
  `Price` DECIMAL(64,2) NOT NULL,
  `idPicture` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idTRoom`),
  UNIQUE INDEX `idTRoom_UNIQUE` (`idTRoom` ASC),
  CONSTRAINT `idPicture` FOREIGN KEY (`idPicture`) REFERENCES `Picture` (`idPicture`) ON UPDATE CASCADE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `typeroom` VALUES(1,"Lux", 3, 150.00, 1);
INSERT INTO `typeroom` VALUES(2,"Double", 2, 75.00, 2);
INSERT INTO `typeroom` VALUES(3,"Delux", 1, 50.00, 3);


CREATE TABLE IF NOT EXISTS `Room` (
  `idRoom` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `NRoom` INT NOT NULL,
  `idTRoom` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idRoom`),
  UNIQUE INDEX `idRoom_UNIQUE` (`idRoom` ASC),
  UNIQUE INDEX `NRoom_UNIQUE` (`NRoom` ASC),
  CONSTRAINT `idTRoom` FOREIGN KEY (`idTRoom`) REFERENCES `TypeRoom` (`idTRoom`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `room` VALUES(1, 101, 1);
INSERT INTO `room` VALUES(2, 201, 1);
INSERT INTO `room` VALUES(3, 102, 2);
INSERT INTO `room` VALUES(4, 202, 2);
INSERT INTO `room` VALUES(5, 103, 3);
INSERT INTO `room` VALUES(6, 203, 3);


CREATE TABLE IF NOT EXISTS `Reservation` (
  `idReserv` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idUser` INT UNSIGNED NOT NULL,
  `idRoom` INT UNSIGNED NOT NULL,
  `Check_inDate` DATE NOT NULL,
  `Check_outDate` DATE NOT NULL,
  `Complete` boolean NOT NULL,
  `InterestPayment` FLOAT NOT NULL,
  `Arrived` boolean NOT NULL,
  PRIMARY KEY (`idReserv`),
  UNIQUE INDEX `idReserv_UNIQUE` (`idReserv` ASC),
  CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idRoom` FOREIGN KEY (`idRoom`) REFERENCES `Room` (`idRoom`) ON DELETE CASCADE ON UPDATE CASCADE
 )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `reservation` VALUES(1,2,1,"2016-05-04", "2016-05-20", false, 0.5, false);

CREATE TABLE IF NOT EXISTS `Check_r` (
  `idCheck` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idReserv` INT UNSIGNED NOT NULL,
  `Payment` DECIMAL(64,2) NOT NULL,
  PRIMARY KEY (`idCheck`),
  UNIQUE INDEX `idCheck_UNIQUE` (`idCheck` ASC),
  UNIQUE INDEX `idReserv_UNIQUE` (`idReserv` ASC),
  CONSTRAINT `idReserv` FOREIGN KEY (`idReserv`) REFERENCES `Reservation` (`idReserv`) ON UPDATE CASCADE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `check_r` VALUES(1,1, 1200.00);