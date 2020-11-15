# farm-rest-management
 
![0 (2)](https://user-images.githubusercontent.com/57782295/99152996-47f96f80-2684-11eb-9b39-844c60a01033.jpg)

# Creacion de la base de datos y sus respectivas tablas
<details>
  <summary>Click to expand!</summary>
  
   CREATE SCHEMA `farm-management` ;

   SET GLOBAL time_zone = '-3:00';

   CREATE TABLE `farm-management`.`farm` (
     `farm_id` INT NOT NULL AUTO_INCREMENT,
     `farm_name` VARCHAR(45) NOT NULL,
     `chicken_bought` INT NULL,
     `chicken_sold` INT NULL,
     `egg_bought` INT NULL,
     `egg_sold` INT NULL,
     `income` DOUBLE NULL,
     `expenses` DOUBLE NULL,
     PRIMARY KEY (`farm_id`),
     UNIQUE INDEX `farm_id_UNIQUE` (`farm_id` ASC) VISIBLE,
     UNIQUE INDEX `farm_name_UNIQUE` (`farm_name` ASC) VISIBLE);

   CREATE TABLE `farm-management`.`chicken` (
     `chicken_id` INT NOT NULL AUTO_INCREMENT,
     `farm_id` INT NOT NULL,
     `birth_date` DATE NULL,
     `expiration_date` DATE NULL,
     PRIMARY KEY (`chicken_id`));

   CREATE TABLE `farm-management`.`egg` (
     `egg_id` INT NOT NULL AUTO_INCREMENT,
     `farm_id` INT NOT NULL,
     `birth_date` DATE NULL,
     `expiration_date` DATE NULL,
     PRIMARY KEY (`egg_id`));

   CREATE TABLE `farm-management`.`reference` (
     `key` VARCHAR(45) NOT NULL,
     `value` VARCHAR(45) NULL);
</details>
