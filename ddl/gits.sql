-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gits
-- -----------------------------------------------------
-- git分支管理
DROP SCHEMA IF EXISTS `gits` ;

-- -----------------------------------------------------
-- Schema gits
--
-- git分支管理
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gits` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `gits` ;

-- -----------------------------------------------------
-- Table `gits`.`gitrepos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gits`.`gitrepos` ;

CREATE TABLE IF NOT EXISTS `gits`.`gitrepos` (
                                               `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR(255) NOT NULL,
                                               `group` VARCHAR(255) NOT NULL,
                                               `repository` VARCHAR(2048) NOT NULL,
                                               `creation_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                               `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                               `deleted` TINYINT NOT NULL DEFAULT 0,
                                               PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gits`.`gitbranch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gits`.`gitbranch` ;

CREATE TABLE IF NOT EXISTS `gits`.`gitbranch` (
                                                `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
                                                `project_id` BIGINT(19) NOT NULL,
                                                `name` VARCHAR(255) NOT NULL,
                                                `chash` VARCHAR(40) NOT NULL,
                                                `base` VARCHAR(255) NOT NULL,
                                                `baseline` DATETIME NOT NULL,
                                                `creation_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                `deleted` TINYINT NOT NULL DEFAULT 0,
                                                PRIMARY KEY (`id`, `project_id`),
                                                INDEX `fk_branch_project_idx` (`project_id` ASC),
                                                CONSTRAINT `fk_branch_project`
                                                  FOREIGN KEY (`project_id`)
                                                    REFERENCES `gits`.`gitrepos` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
