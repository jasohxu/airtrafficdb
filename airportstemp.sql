-- MySQL dump 10.13  Distrib 8.2.0, for macos13 (arm64)
--
-- Host: localhost    Database: AirportsTemp
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airline`
--

DROP TABLE IF EXISTS `airline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airline` (
  `abbreviation` varchar(255) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`abbreviation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airline`
--

LOCK TABLES `airline` WRITE;
/*!40000 ALTER TABLE `airline` DISABLE KEYS */;
INSERT INTO `airline` VALUES ('AA','American Airlines'),('BA','British Airways'),('CA','Air China'),('DL','Delta Airlines'),('EK','Emirates'),('KL','KLM'),('LH','Lufthansa'),('MF','Xiamen Airlines'),('MU','China Eastern'),('UA','United Airlines');
/*!40000 ALTER TABLE `airline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `abbreviation` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`abbreviation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES ('CDG','Paris','Paris Charles de Gaulle Airport'),('DEL','Delhi','Indira Gandhi International Airport'),('DXB','Dubai','Dubai International Airport'),('GRU','São Paulo','Governor André Franco Montoro International Airport'),('HND','Tokyo','Haneda Airport'),('JFK','New York','John F. Kennedy International Airport'),('LAX','Los Angeles','Los Angeles International Airport'),('LHR','London','Heathrow Airport'),('MAD','Madrid','Adolfo Suárez Madrid–Barajas Airport'),('PVG','Shanghai','Shanghai Pudong International Airport');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flight_number` int NOT NULL,
  `arrival_time` datetime(6) DEFAULT NULL,
  `departure_time` datetime(6) DEFAULT NULL,
  `airline` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`flight_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'1970-01-01 01:01:00.000000','1970-01-01 13:01:00.000000','CA','PVG','JFK'),(2,'1970-01-01 14:01:00.000000','1970-01-01 01:01:00.000000','AA','LAX','JFK'),(3,'1970-01-01 15:01:00.000000','1970-01-01 01:01:00.000000','KL','MAD','JFK'),(4,'1970-01-01 15:01:00.000000','1970-01-01 01:01:00.000000','LH','LHR','MAD'),(5,'1970-01-01 15:01:00.000000','1970-01-01 01:01:00.000000','MF','JFK','PVG'),(6,'1970-01-01 15:01:00.000000','1970-01-01 01:01:00.000000','MU','JFK','PVG'),(7,'1970-01-01 15:01:00.000000','1970-01-01 01:01:00.000000','EK','HND','CDG'),(8,'1970-01-01 15:01:00.000000','1970-01-01 01:01:00.000000','BA','DXB','LHR'),(9,'1970-01-01 15:01:00.000000','1970-01-01 01:01:00.000000','BA','PVG','DXB'),(10,'1970-01-01 15:01:00.000000','1970-01-01 01:01:00.000000','EK','PVG','DXB');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `passengerid` int NOT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`passengerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'1998-12-31 19:00:00.000000','Passenger 1'),(2,'1999-12-31 19:00:00.000000','Passenger 2'),(3,'2000-12-31 19:00:00.000000','Passenger 3'),(4,'2001-12-31 19:00:00.000000','Passenger 4'),(5,'2002-12-31 19:00:00.000000','Passenger 5'),(6,'2003-02-01 19:00:00.000000','Passenger 6'),(7,'2002-02-01 19:00:00.000000','Passenger 7'),(8,'2001-02-01 19:00:00.000000','Passenger 8'),(9,'2000-02-01 19:00:00.000000','Passenger 9'),(10,'1999-02-01 19:00:00.000000','Passenger 10');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `flight_number` int DEFAULT NULL,
  `passengerid` int DEFAULT NULL,
  `ticketid` int NOT NULL,
  `flight_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ticketid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,1,1,'2023-12-31 19:00:00.000000'),(2,2,2,'2024-02-01 19:00:00.000000'),(3,3,3,'2024-03-02 19:00:00.000000'),(4,4,4,'2024-04-03 20:00:00.000000'),(5,5,5,'2024-05-04 20:00:00.000000'),(6,6,6,'2024-06-05 20:00:00.000000'),(7,7,7,'2024-07-06 20:00:00.000000'),(8,8,8,'2024-08-07 20:00:00.000000'),(9,9,9,'2024-09-08 20:00:00.000000'),(10,10,10,'2024-10-09 20:00:00.000000');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-16 11:29:04
