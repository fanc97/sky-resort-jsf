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
-- Table structure for table `mountain`
--

DROP TABLE IF EXISTS `mountain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mountain` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` mediumtext,
  `country` varchar(50) DEFAULT NULL,
  `highest_point` varchar(25) DEFAULT NULL,
  `top_elevation_m` int(10) DEFAULT NULL,
  `base_elevation_m` int(10) DEFAULT NULL,
  `picture` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mountain`
--

LOCK TABLES `mountain` WRITE;
/*!40000 ALTER TABLE `mountain` DISABLE KEYS */;
INSERT INTO `mountain` VALUES (1,'Kopaonik','Kopaonik is one of the larger mountain ranges of Serbia and Kosovo. It is located in the central part of Serbia and the northern parts of Kosovo. Its highest point, Pancic\'s Peak, is 2,017 m (6,617 ft) above sea level and is located on the border between the two countries. Kopaonik is the major ski resort of Serbia, and after Bulgaria\'s Bansko, largest in Southeast Europe. There are 25 ski lifts with capacity of 32,000 skiers per hour. A national park spread over 118.1 km2 (45.6 sq mi) of the central part of the Kopaonik plateau was established in 1981','Serbia','Pancic\'s Peak',2017,1770,_binary 'asset/images/mountain/kopaonik.jpg'),(2,'Jahorna','Jahorina is a mountain in Bosnia and Herzegovina, located near Pale in the Dinaric Alps. It borders Mount Trebevic, another Olympic mountain. Jahorina\'s highest peak, Ogorjelica, has a summit elevation of 1,916 metres (6,286 ft), making it the second-highest of Sarajevo\'s mountains, after Bjelasnica at 2,067 m (6,781 ft). Mount Jahorina hosted the women\'s alpine skiing events of the 1984 Winter Olympics. Jahorina is located 15 km (9.3 mi) from Pale and 30 km (19 mi) from Sarajevo. The international airport in Sarajevo is located 33 km (21 mi) from Jahorina, connected with the ski resort by a new motorway.','Bosina and Hercegovina','Ogorjelica',1916,1300,_binary 'asset/images/mountain/jahorina.jpg'),(3,'Krvavec','The Krvavec Ski Resort is the second-largest Slovenian ski resort, located in the Municipality of Cerklje na Gorenjskem in the Kamnik–Savinja Alps. The nearest city is Kranj and it is 25 km from Ljubljana. The resort is located 10 km from Ljubljana Joze Pucnik Airport and it is the nearest ski resort to an international airport in Europe. It has a total 30 km of ski slopes. Today 95% of skiable area is covered with artificial snow.','Slovenia','Krvavec',1971,1450,_binary 'asset/images/mountain/krvavec.jpg');
/*!40000 ALTER TABLE `mountain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `mountain_id` int(50) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `fullName` varchar(50) DEFAULT NULL,
  `from_d` date DEFAULT NULL,
  `to_d` date DEFAULT NULL,
  `price` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mountain_id` (`mountain_id`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`mountain_id`) REFERENCES `mountain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,1,'peco','Petar Markovic','2020-11-02','2020-11-03',3200),(2,3,'peco','Petar Markovic','2020-01-19','2020-01-19',7571);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sky_resort`
--

DROP TABLE IF EXISTS `sky_resort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sky_resort` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sky_resort`
--

LOCK TABLES `sky_resort` WRITE;
/*!40000 ALTER TABLE `sky_resort` DISABLE KEYS */;
INSERT INTO `sky_resort` VALUES (1,'Kopaonik'),(2,'Jahorina'),(3,'Krvavec');
/*!40000 ALTER TABLE `sky_resort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skypass`
--

DROP TABLE IF EXISTS `skypass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skypass` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mountain_id` int(25) DEFAULT NULL,
  `duration` int(50) DEFAULT NULL,
  `price` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mountain_id` (`mountain_id`),
  CONSTRAINT `skypass_ibfk_1` FOREIGN KEY (`mountain_id`) REFERENCES `mountain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skypass`
--

LOCK TABLES `skypass` WRITE;
/*!40000 ALTER TABLE `skypass` DISABLE KEYS */;
INSERT INTO `skypass` VALUES (1,1,1,3200),(2,1,2,5990),(3,1,3,8590),(4,1,4,10710),(5,1,5,12480),(6,1,6,14320),(7,1,7,15910),(8,2,1,2482),(9,2,2,4095),(10,2,3,6205),(11,2,4,7571),(12,2,5,9178),(13,2,6,10760),(14,2,7,11900),(15,3,1,3971),(16,3,2,7571),(17,3,3,10549),(18,3,4,11542),(19,3,5,13625),(20,3,6,15886),(21,3,7,17748);
/*!40000 ALTER TABLE `skypass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `mountain_id` int(25) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `lenght_km` float DEFAULT NULL,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mountain_id` (`mountain_id`),
  CONSTRAINT `track_ibfk_1` FOREIGN KEY (`mountain_id`) REFERENCES `mountain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
INSERT INTO `track` VALUES (1,1,'Krcmar',2.2,9.9),(2,1,'Crna duboka',1.4,9.3),(3,1,'Karaman greben',1.2,8.9),(4,1,'Suncana dolina',0.9,7.6),(5,1,'Bela reka',1.7,8.3),(6,1,'Gvozdac',1.5,7.7),(7,1,'Gobelja',0.8,7.5),(8,2,'Poljice',1.7,8),(9,2,'Olimpiski ski lift',1.4,9.5),(10,2,'Ogorjelica',1.4,9.5),(11,2,'Preca',0.8,8.8),(12,3,'Zvoh',1.7,7.9),(13,3,'Dom- Kriska planina',0.7,6.5),(14,3,'neteptani Zvoh (freeride)',1.8,7.7),(15,3,'Hanek',0.7,6.3),(16,3,'Vrh Krvavca - Gradisce - Tiha dolina',2,9.2);
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weather`
--

DROP TABLE IF EXISTS `weather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weather` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mountain_id` int(25) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `temperature_max` varchar(50) DEFAULT NULL,
  `temperature_min` varchar(50) DEFAULT NULL,
  `wind` varchar(50) DEFAULT NULL,
  `outlook` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mountain_id` (`mountain_id`),
  CONSTRAINT `weather_ibfk_1` FOREIGN KEY (`mountain_id`) REFERENCES `mountain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weather`
--

LOCK TABLES `weather` WRITE;
/*!40000 ALTER TABLE `weather` DISABLE KEYS */;
INSERT INTO `weather` VALUES (3,1,'2017-03-22T17:30:55.588Z','4','12','3','cloudy'),(4,1,'2017-03-23T17:30:55.588Z','6','18','1.4','rainy'),(5,1,'2017-03-24T17:30:55.588Z','5','19','1.7','sunny'),(6,1,'2017-03-25T17:30:55.588Z','0','4','1.2','snowy'),(7,1,'2017-03-26T17:30:55.588Z','-1','2','1.9','snowy'),(8,1,'2017-03-27T17:30:55.588Z','-2','0','1.6','snowy'),(9,2,'2017-03-28T17:30:55.588Z','-4','9','0.9','cloudy'),(10,2,'2017-03-22T17:30:55.588Z','-4','12','1.1','sunny'),(11,2,'2017-03-23T17:30:55.588Z','-3','12','1.4','cloudy'),(12,2,'2017-03-24T17:30:55.588Z','-4','12','1.9','rainy'),(13,2,'2017-03-25T17:30:55.588Z','-5','7','2.0','snowy'),(14,2,'2017-03-26T17:30:55.588Z','-5','5','2.0','snowy'),(15,2,'2017-03-27T17:30:55.588Z','-5','2','1.6','snowy'),(16,3,'2017-03-28T17:30:55.588Z','-4','3','1.1','cloudy'),(17,3,'2017-03-22T17:30:55.588Z','2','12','0.9','cloudy'),(18,3,'2017-03-23T17:30:55.588Z','1','10','1.1','cloudy'),(19,3,'2017-03-24T17:30:55.588Z','0','8','1.0','cloudy'),(20,3,'2017-03-25T17:30:55.588Z','-2','5','1.5','rainy'),(21,3,'2017-03-26T17:30:55.588Z','-3','2','1.6','rainy'),(22,3,'2017-03-27T17:30:55.588Z','-4','0','1.4','snowy'),(23,3,'2017-03-28T17:30:55.588Z','-3','4','1.1','sunny');
/*!40000 ALTER TABLE `weather` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


