-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: farm-management
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chicken`
--

DROP TABLE IF EXISTS `chicken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chicken` (
  `chicken_id` int NOT NULL AUTO_INCREMENT,
  `farm_id` int NOT NULL,
  `birth_date` date DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`chicken_id`),
  KEY `farm_idx` (`farm_id`),
  CONSTRAINT `farm` FOREIGN KEY (`farm_id`) REFERENCES `farm` (`farm_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chicken`
--

LOCK TABLES `chicken` WRITE;
/*!40000 ALTER TABLE `chicken` DISABLE KEYS */;
INSERT INTO `chicken` VALUES (1,1,'2020-11-22','2021-11-22'),(2,1,'2020-11-22','2020-11-22'),(3,1,'2020-11-22','2020-11-22'),(5,9,'2020-11-28','2020-11-28'),(6,9,'2020-11-28','2021-11-28'),(7,9,'2020-11-28','2021-11-28'),(8,9,'2020-11-28','2021-11-28'),(9,1,'2020-12-01','2020-12-01');
/*!40000 ALTER TABLE `chicken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egg`
--

DROP TABLE IF EXISTS `egg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egg` (
  `egg_id` int NOT NULL AUTO_INCREMENT,
  `farm_id` int NOT NULL,
  `birth_date` date DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`egg_id`),
  KEY `farm_id_idx` (`farm_id`),
  CONSTRAINT `farm_id` FOREIGN KEY (`farm_id`) REFERENCES `farm` (`farm_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egg`
--

LOCK TABLES `egg` WRITE;
/*!40000 ALTER TABLE `egg` DISABLE KEYS */;
INSERT INTO `egg` VALUES (1,1,'2020-11-30','2020-11-30'),(3,1,'2020-11-29','2020-12-29'),(6,1,'2020-11-30','2020-12-30'),(10,9,'2020-11-28','2020-11-28'),(11,11,'2020-11-28','2020-11-28'),(12,11,'2020-11-28','2020-11-28'),(13,11,'2020-11-28','2020-11-28'),(14,11,'2020-12-01','2020-12-01');
/*!40000 ALTER TABLE `egg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farm`
--

DROP TABLE IF EXISTS `farm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farm` (
  `farm_id` int NOT NULL AUTO_INCREMENT,
  `farm_name` varchar(45) NOT NULL,
  `chicken_bought` int DEFAULT NULL,
  `chicken_sold` int DEFAULT NULL,
  `egg_bought` int DEFAULT NULL,
  `egg_sold` int DEFAULT NULL,
  `income` double DEFAULT NULL,
  `expenses` double DEFAULT NULL,
  PRIMARY KEY (`farm_id`),
  UNIQUE KEY `farm_id_UNIQUE` (`farm_id`),
  UNIQUE KEY `farm_name_UNIQUE` (`farm_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farm`
--

LOCK TABLES `farm` WRITE;
/*!40000 ALTER TABLE `farm` DISABLE KEYS */;
INSERT INTO `farm` VALUES (1,'Test Updated Farm',10,110,0,5000,900,200),(9,'Farm November',10,3,20,0,440,110),(10,'Farm Empty',0,0,0,0,0,0),(11,'Only Eggs Farm',0,0,0,0,0,0);
/*!40000 ALTER TABLE `farm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reference`
--

DROP TABLE IF EXISTS `reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reference` (
  `key` varchar(45) NOT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference`
--

LOCK TABLES `reference` WRITE;
/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
INSERT INTO `reference` VALUES ('chickenExpirationDate','365'),('chSalePrice','175'),('eggExpirationDate','21'),('eggSalePrice','50');
/*!40000 ALTER TABLE `reference` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-10 17:06:29
