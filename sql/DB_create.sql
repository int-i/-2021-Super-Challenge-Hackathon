-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Administrator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Administrator` (
  `Password` INT NOT NULL,
  PRIMARY KEY (`Password`),
  UNIQUE INDEX `Password_UNIQUE` (`Password` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Payer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Payer` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Phone_UNIQUE` (`Phone` ASC) VISIBLE,
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Product` (
  `Product_id` INT NOT NULL,
  `Product_name` VARCHAR(45) NOT NULL,
  `Product_num` INT NOT NULL,
  `State` INT NOT NULL,
  PRIMARY KEY (`Product_id`),
  UNIQUE INDEX `Product_id_UNIQUE` (`Product_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Reservation` (
  `Product_id` INT NOT NULL,
  `Payer_Id` INT NOT NULL,
  `Date` DATETIME NOT NULL,
  PRIMARY KEY (`Product_id`),
  UNIQUE INDEX `Product_id_UNIQUE` (`Product_id` ASC) VISIBLE,
  INDEX `fk_Reservation_Payer1_idx` (`Payer_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Reservation_Product`
    FOREIGN KEY (`Product_id`)
    REFERENCES `mydb`.`Product` (`Product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Payer1`
    FOREIGN KEY (`Payer_Id`)
    REFERENCES `mydb`.`Payer` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rental`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rental` (
  `Product_id` INT NOT NULL,
  `Payer_Id` INT NOT NULL,
  `Rental_date` TIMESTAMP NOT NULL,
  `Checker` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Product_id`),
  INDEX `fk_Rental_Payer1_idx` (`Payer_Id` ASC) VISIBLE,
  UNIQUE INDEX `Product_id_UNIQUE` (`Product_id` ASC) VISIBLE,
  CONSTRAINT `fk_Rental_Product1`
    FOREIGN KEY (`Product_id`)
    REFERENCES `mydb`.`Product` (`Product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rental_Payer1`
    FOREIGN KEY (`Payer_Id`)
    REFERENCES `mydb`.`Payer` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Demerit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Demerit` (
  `num` INT NOT NULL,
  `Id` INT NOT NULL,
  `Value` FLOAT NOT NULL,
  `Reason` TEXT NOT NULL,
  PRIMARY KEY (`num`),
  UNIQUE INDEX `num_UNIQUE` (`num` ASC) VISIBLE,
  INDEX `fk_Demerit_Payer1_idx` (`Id` ASC) VISIBLE,
  CONSTRAINT `fk_Demerit_Payer1`
    FOREIGN KEY (`Id`)
    REFERENCES `mydb`.`Payer` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

create user 'error'@'%' identified by 'error123!';

grant all privileges on mydb.* to error@'%';

flush privileges;

SET GLOBAL time_zone = '+9:00';
SET time_zone = '+9:00';