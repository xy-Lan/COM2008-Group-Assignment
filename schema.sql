-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: stusql.dcs.shef.ac.uk    Database: team015
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `house_number` varchar(255) NOT NULL,
  `post_code` varchar(255) NOT NULL,
  `road_name` varchar(255) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`house_number`,`post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES ('1','1','1','1');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_card`
--

DROP TABLE IF EXISTS `bank_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_card` (
  `card_number` varchar(255) NOT NULL,
  `expiry_month` int NOT NULL,
  `expiry_year` int NOT NULL,
  `security_code` int NOT NULL,
  `user_id` INT DEFAULT NULL,
  PRIMARY KEY (`card_number`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bank_card_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_card`
--

LOCK TABLES `bank_card` WRITE;
/*!40000 ALTER TABLE `bank_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boxed_set`
--

DROP TABLE IF EXISTS `boxed_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boxed_set` (
  `product_code` varchar(255) NOT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `boxed_set_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boxed_set`
--

LOCK TABLES `boxed_set` WRITE;
/*!40000 ALTER TABLE `boxed_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `boxed_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carriage`
--

DROP TABLE IF EXISTS `carriage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carriage` (
  `product_code` varchar(255) NOT NULL,
  `carriage_type` enum('CORRIDOR_FIRST','OPEN_FIRST','CORRIDOR_SECOND','SLEEPER_CAR','RESTAURANT_CAR','BUFFET_CAR','COMPOSITE_COACH','GENERAL_UTILITY_VAN','OPEN_SECOND','POST_OFFICE_SORTING_VAN','BRAKE_VAN','BRAKE_SECOND','COMPOSITE_BRAKE_VAN','PULLMAN','STANDARD_CALSS') DEFAULT NULL,
  `era` enum('ERA_1','ERA_2','ERA_3','ERA_4','ERA_5','ERA_6','ERA_8','ERA_7','ERA_9','ERA_10','ERA_11','ERA_12') DEFAULT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `carriage_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `part` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carriage`
--

LOCK TABLES `carriage` WRITE;
/*!40000 ALTER TABLE `carriage` DISABLE KEYS */;
/*!40000 ALTER TABLE `carriage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controller`
--

DROP TABLE IF EXISTS `controller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `controller` (
  `product_code` varchar(255) NOT NULL,
  `controller_type` enum('STANDARD_CONTROLLER','DCC_CONTROLLER','DCC_EDIT_CONTROLLER') DEFAULT NULL,
  `era` enum('ERA_1','ERA_2','ERA_3','ERA_4','ERA_5','ERA_6','ERA_8','ERA_7','ERA_9','ERA_10','ERA_11','ERA_12') DEFAULT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `controller_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `part` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controller`
--

LOCK TABLES `controller` WRITE;
/*!40000 ALTER TABLE `controller` DISABLE KEYS */;
/*!40000 ALTER TABLE `controller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hashed_passwords`
--

DROP TABLE IF EXISTS `hashed_passwords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hashed_passwords` (
  `user_id` INT NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `hashed_passwords_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hashed_passwords`
--

LOCK TABLES `hashed_passwords` WRITE;
/*!40000 ALTER TABLE `hashed_passwords` DISABLE KEYS */;
INSERT INTO `hashed_passwords` VALUES ('1','password');
/*!40000 ALTER TABLE `hashed_passwords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `product_code` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  KEY `product_code` (`product_code`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES ('1234',10);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locomotive`
--

DROP TABLE IF EXISTS `locomotive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locomotive` (
  `product_code` varchar(255) NOT NULL,
  `dcc_type` enum('ANALOGUE','DCC_READY','DCC_FITTED','DCC_SOUND') DEFAULT NULL,
  `era` enum('ERA_1','ERA_2','ERA_3','ERA_4','ERA_5','ERA_6','ERA_8','ERA_7','ERA_9','ERA_10','ERA_11','ERA_12') DEFAULT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `locomotive_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `part` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locomotive`
--

LOCK TABLES `locomotive` WRITE;
/*!40000 ALTER TABLE `locomotive` DISABLE KEYS */;
/*!40000 ALTER TABLE `locomotive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderline`
--

DROP TABLE IF EXISTS `orderline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderline` (
  `product_code` varchar(255) NOT NULL,
  `quantity` int DEFAULT NULL,
  `linecost` decimal(10,2) DEFAULT NULL,
  `order_number` varchar(255) NOT NULL,
  PRIMARY KEY (`product_code`,`order_number`),
  KEY `orderline_ibfk_1` (`order_number`),
  CONSTRAINT `orderline_ibfk_1` FOREIGN KEY (`order_number`) REFERENCES `orders` (`order_number`),
  CONSTRAINT `orderline_ibfk_2` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderline`
--

LOCK TABLES `orderline` WRITE;
/*!40000 ALTER TABLE `orderline` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_number` varchar(255) NOT NULL,
  `date` date DEFAULT NULL,
  `user_id` INT DEFAULT NULL,
  `order_status` enum('PENDING','CONFIRMED','FULFILLED') DEFAULT NULL,
  PRIMARY KEY (`order_number`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pack_boxed_set_association`
--

DROP TABLE IF EXISTS `pack_boxed_set_association`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pack_boxed_set_association` (
  `pack_product_code` varchar(255) NOT NULL,
  `boxed_set_product_code` varchar(255) NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`pack_product_code`,`boxed_set_product_code`),
  KEY `boxed_set_product_code` (`boxed_set_product_code`),
  CONSTRAINT `pack_boxed_set_association_ibfk_1` FOREIGN KEY (`pack_product_code`) REFERENCES `part` (`product_code`),
  CONSTRAINT `pack_boxed_set_association_ibfk_2` FOREIGN KEY (`boxed_set_product_code`) REFERENCES `boxed_set` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pack_boxed_set_association`
--

LOCK TABLES `pack_boxed_set_association` WRITE;
/*!40000 ALTER TABLE `pack_boxed_set_association` DISABLE KEYS */;
/*!40000 ALTER TABLE `pack_boxed_set_association` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `part` (
  `product_code` varchar(255) NOT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `part_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `transaction_id` varchar(255) NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `user_id` INT DEFAULT NULL,
  `payment_status` enum('PENDING','COMPLETED','FAILED','REFUNDED','CANCELLED') DEFAULT NULL,
  `payment_method` enum('CREDIT_CARD','PAYPAL','DEBIT_CARD','CASH') DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_code` varchar(255) NOT NULL,
  `brand_name` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `retail_price` decimal(10,2) DEFAULT NULL,
  `gauge_type` enum('OO_GAUGE','TT_GAUGE','N_GAUGE') DEFAULT NULL,
  PRIMARY KEY (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1234','tom','to0m',420.00,'OO_GAUGE');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track` (
  `product_code` varchar(255) NOT NULL,
  `track_type` enum('STRAIGHT','CURVE','POINT','CROSSOVER') DEFAULT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `track_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `part` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track_pack`
--

DROP TABLE IF EXISTS `track_pack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track_pack` (
  `product_code` varchar(255) NOT NULL,
  `pack_type` enum('STARTER_OVAL','EXTENSION_PACK') DEFAULT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `track_pack_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `boxed_set` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track_pack`
--

LOCK TABLES `track_pack` WRITE;
/*!40000 ALTER TABLE `track_pack` DISABLE KEYS */;
/*!40000 ALTER TABLE `track_pack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_set`
--

DROP TABLE IF EXISTS `train_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `train_set` (
  `product_code` varchar(255) NOT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `train_set_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `boxed_set` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_set`
--

LOCK TABLES `train_set` WRITE;
/*!40000 ALTER TABLE `train_set` DISABLE KEYS */;
/*!40000 ALTER TABLE `train_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address` (
  `user_address_id` int NOT NULL AUTO_INCREMENT,
  `user_id` INT DEFAULT NULL,
  `house_number` varchar(255) DEFAULT NULL,
  `post_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_address_id`),
  KEY `user_id` (`user_id`),
  KEY `house_number` (`house_number`,`post_code`),
  CONSTRAINT `user_address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `user_address_ibfk_2` FOREIGN KEY (`house_number`, `post_code`) REFERENCES `address` (`house_number`, `post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` INT AUTO_INCREMENT NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `forename` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `house_number` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `role` enum('CUSTOMER','STAFF','MANAGER') DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `users_ibfk_1` (`house_number`,`post_code`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`house_number`, `post_code`) REFERENCES `address` (`house_number`, `post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('1','laister.sam@gmail.com','Sam','Laister','1','1','MANAGER'),('2','a',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wagon`
--

DROP TABLE IF EXISTS `wagon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wagon` (
  `product_code` varchar(255) NOT NULL,
  `wagon_type` enum('CATTLE_WAGON','HORSE_BOX_WAGON','PARCELS_VAN','MINERAL_WAGON_16T','COAL_WAGON_6PLANK','COAL_WAGON_8PLANK','HOPPER_WAGON_20T','CLAM_BALLAST_WAGON_102T','URCHIN_BOGIE_OPEN_WAGON','COALFISH_OPEN_WAGON','BOGIE_BOLSTER_WAGON','BRAKE_VAN_20T','GWR_TOAD_GUARDS_VAN') DEFAULT NULL,
  `era` enum('ERA_1','ERA_2','ERA_3','ERA_4','ERA_5','ERA_6','ERA_8','ERA_7','ERA_9','ERA_10','ERA_11','ERA_12') DEFAULT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `wagon_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `part` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wagon`
--

LOCK TABLES `wagon` WRITE;
/*!40000 ALTER TABLE `wagon` DISABLE KEYS */;
/*!40000 ALTER TABLE `wagon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-15 23:53:40
