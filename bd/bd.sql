CREATE SCHEMA `carrefour` ;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema carrefour
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carrefour
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carrefour` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `carrefour` ;

-- -----------------------------------------------------
-- Table `carrefour`.`categorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carrefour`.`categorie` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrefour`.`produit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carrefour`.`produit` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) NULL,
  `prix` INT NULL,
  `categorie_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produit_categorie1_idx` (`categorie_id` ASC) VISIBLE,
  CONSTRAINT `fk_produit_categorie1`
    FOREIGN KEY (`categorie_id`)
    REFERENCES `carrefour`.`categorie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrefour`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carrefour`.`client` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) NULL,
  `prenom` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrefour`.`ville`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carrefour`.`ville` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrefour`.`magasin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carrefour`.`magasin` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) NULL,
  `ville_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_magasin_ville_idx` (`ville_id` ASC) VISIBLE,
  CONSTRAINT `fk_magasin_ville`
    FOREIGN KEY (`ville_id`)
    REFERENCES `carrefour`.`ville` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrefour`.`commande`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carrefour`.`commande` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `client_id` BIGINT NOT NULL,
  `magasin_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_commande_client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_commande_magasin1_idx` (`magasin_id` ASC) VISIBLE,
  CONSTRAINT `fk_commande_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `carrefour`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commande_magasin1`
    FOREIGN KEY (`magasin_id`)
    REFERENCES `carrefour`.`magasin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carrefour`.`commande_has_produit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carrefour`.`commande_has_produit` (
  `commande_id` BIGINT NOT NULL,
  `produit_id` BIGINT NOT NULL,
  PRIMARY KEY (`commande_id`, `produit_id`),
  INDEX `fk_commande_has_produit_produit1_idx` (`produit_id` ASC) VISIBLE,
  INDEX `fk_commande_has_produit_commande1_idx` (`commande_id` ASC) VISIBLE,
  CONSTRAINT `fk_commande_has_produit_commande1`
    FOREIGN KEY (`commande_id`)
    REFERENCES `carrefour`.`commande` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commande_has_produit_produit1`
    FOREIGN KEY (`produit_id`)
    REFERENCES `carrefour`.`produit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
