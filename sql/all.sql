CREATE DATABASE  IF NOT EXISTS `pfm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pfm`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: pfm
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin',0.00);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income_category`
--

DROP TABLE IF EXISTS `income_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `income_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income_category`
--

LOCK TABLES `income_category` WRITE;
/*!40000 ALTER TABLE `income_category` DISABLE KEYS */;
INSERT INTO `income_category` VALUES (1,'Salary');
/*!40000 ALTER TABLE `income_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income_record`
--

DROP TABLE IF EXISTS `income_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `income_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,2) NOT NULL,
  `income_category_id` int NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `account_id` int NOT NULL DEFAULT '1',
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `income_category_id_idx` (`income_category_id`),
  KEY `account_id_idx` (`account_id`),
  CONSTRAINT `account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `income_category_id` FOREIGN KEY (`income_category_id`) REFERENCES `income_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income_record`
--

LOCK TABLES `income_record` WRITE;
/*!40000 ALTER TABLE `income_record` DISABLE KEYS */;
INSERT INTO `income_record` VALUES (1,500.00,1,NULL,1,'2020-08-23');
/*!40000 ALTER TABLE `income_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spend_category`
--

DROP TABLE IF EXISTS `spend_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spend_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `budget` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spend_category`
--

LOCK TABLES `spend_category` WRITE;
/*!40000 ALTER TABLE `spend_category` DISABLE KEYS */;
INSERT INTO `spend_category` VALUES (1,'Travel',1000.00),(2,'Groceries',1500.00);
/*!40000 ALTER TABLE `spend_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spend_record`
--

DROP TABLE IF EXISTS `spend_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spend_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,2) NOT NULL,
  `spend_category_id` int NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `account_id` int NOT NULL DEFAULT '1',
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id_idx` (`account_id`),
  KEY `spend_category_id_idx` (`spend_category_id`),
  CONSTRAINT `account_id_spend` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `spend_category_id` FOREIGN KEY (`spend_category_id`) REFERENCES `spend_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spend_record`
--

LOCK TABLES `spend_record` WRITE;
/*!40000 ALTER TABLE `spend_record` DISABLE KEYS */;
INSERT INTO `spend_record` VALUES (1,100.00,1,NULL,1,'2021-08-26'),(2,500.00,2,NULL,1,'2020-08-24');
/*!40000 ALTER TABLE `spend_record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-25 11:23:33
