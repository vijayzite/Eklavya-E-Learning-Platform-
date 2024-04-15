-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: eklavya
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `approve`
--

DROP TABLE IF EXISTS `approve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `approve` (
  `apv_id` bigint NOT NULL,
  `certifications` varchar(255) DEFAULT NULL,
  `descr` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `qualify` varchar(255) DEFAULT NULL,
  `u_status` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`apv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approve`
--

LOCK TABLES `approve` WRITE;
/*!40000 ALTER TABLE `approve` DISABLE KEYS */;
INSERT INTO `approve` VALUES (66,'cdac','teacher','10','Dinesh','yes',65,NULL,NULL),(94,'BE ','teacher','10','Ashok Pate','yes',93,NULL,NULL),(107,'BE','teacher','10','teacherone','yes',106,NULL,NULL),(123,'CDAC','Something','10','Teachertwo','yes',122,NULL,NULL),(139,'CDAC','Teacher','10yr','Pranita','yes',138,NULL,NULL),(159,'CDAC','TEacher','10yr','Ankur','yes',158,NULL,NULL),(169,'CDAC','Teacher ','10','lokesh','yes',168,NULL,NULL);
/*!40000 ALTER TABLE `approve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chapter`
--

DROP TABLE IF EXISTS `chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chapter` (
  `chapter_id` bigint NOT NULL,
  `chapter_index_no` varchar(255) DEFAULT NULL,
  `chapter_title` varchar(255) DEFAULT NULL,
  `chapter_desc` varchar(255) DEFAULT NULL,
  `chapter_thumb_path` varchar(255) DEFAULT NULL,
  `chapter_file_path` varchar(255) DEFAULT NULL,
  `chapter_video_path` varchar(255) DEFAULT NULL,
  `course_course_id` bigint DEFAULT NULL,
  PRIMARY KEY (`chapter_id`),
  KEY `FKlrspswalo0vcy1h4fqqiyxt0i` (`course_course_id`),
  CONSTRAINT `FKlrspswalo0vcy1h4fqqiyxt0i` FOREIGN KEY (`course_course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chapter`
--

LOCK TABLES `chapter` WRITE;
/*!40000 ALTER TABLE `chapter` DISABLE KEYS */;
INSERT INTO `chapter` VALUES (110,'1','States In React','basic of states','','','',108),(116,'2','Hooks','basic of hooks','','','',108),(118,'3.','Bootstap MDB','as','','','',108),(119,'4','react BOOTSTRAP MDB  19/05/2023','as','','','',108),(125,'1','OOPS concept','Basic of oops','','','',124),(142,'1','HOOKS','Basic of hooks','','','',140),(143,'2','Libary','basic of library','','','',140),(161,'1','OOPS CONCEPT','Basic of oops','','','',160),(171,'1','OOPS CONCEPT','basic of oops','','','',170),(179,'1','Oops concept','ajhds','','','',178);
/*!40000 ALTER TABLE `chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` bigint NOT NULL,
  `course_title` varchar(255) DEFAULT NULL,
  `course_desc` varchar(255) DEFAULT NULL,
  `course_type` varchar(255) DEFAULT NULL,
  `course_price` float DEFAULT NULL,
  `course_thumb_path` varchar(255) DEFAULT NULL,
  `intro_video_path` varchar(255) DEFAULT NULL,
  `course_category_course_cat_id` int DEFAULT NULL,
  `user_user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FKq7jjyiy7lxt4b95lmcqcpk5mr` (`course_category_course_cat_id`),
  KEY `FKq41d267juo4gigglkch82iyyc` (`user_user_id`),
  CONSTRAINT `FKq41d267juo4gigglkch82iyyc` FOREIGN KEY (`user_user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKq7jjyiy7lxt4b95lmcqcpk5mr` FOREIGN KEY (`course_category_course_cat_id`) REFERENCES `course_category` (`course_cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (108,'react Native ','basic t advanced react native ','paid',799,'','',4,106),(124,'Core Java','Basic of java','paid',799,'','',1,122),(140,'React native','Basic of react native','paid',899,'','',1,138),(160,'Java Sandeep Sir','Basic of java','paid',799,'','',1,158),(170,'DotNet','Full Dotnet course','paid',700,'','',1,168),(178,'Advance Java ','Advance Java ','paid',700,'','',1,106);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_category`
--

DROP TABLE IF EXISTS `course_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_category` (
  `course_cat_id` int NOT NULL,
  `course_cat_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_category`
--

LOCK TABLES `course_category` WRITE;
/*!40000 ALTER TABLE `course_category` DISABLE KEYS */;
INSERT INTO `course_category` VALUES (1,'Technology'),(2,'Business'),(3,'Helth'),(4,'Language');
/*!40000 ALTER TABLE `course_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enroll_details`
--

DROP TABLE IF EXISTS `enroll_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enroll_details` (
  `enroll_detail_id` bigint NOT NULL,
  `course_id` bigint DEFAULT NULL,
  `price` float DEFAULT NULL,
  `inst_id` bigint DEFAULT NULL,
  PRIMARY KEY (`enroll_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enroll_details`
--

LOCK TABLES `enroll_details` WRITE;
/*!40000 ALTER TABLE `enroll_details` DISABLE KEYS */;
INSERT INTO `enroll_details` VALUES (75,67,799,65),(81,76,999,65),(85,67,799,65),(92,86,0,65),(101,95,799,65),(105,67,799,65),(115,108,799,106),(133,124,799,122),(137,124,799,122),(149,140,899,138),(153,140,899,138),(157,140,899,138),(167,160,799,158),(177,170,700,168);
/*!40000 ALTER TABLE `enroll_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrolled_courses`
--

DROP TABLE IF EXISTS `enrolled_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrolled_courses` (
  `enroll_id` bigint NOT NULL,
  `u_id` bigint DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `c_type` varchar(255) DEFAULT NULL,
  `c_id` bigint DEFAULT NULL,
  PRIMARY KEY (`enroll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrolled_courses`
--

LOCK TABLES `enrolled_courses` WRITE;
/*!40000 ALTER TABLE `enrolled_courses` DISABLE KEYS */;
INSERT INTO `enrolled_courses` VALUES (74,72,'Core','paid',67),(80,72,'ADVANCE JAVA','paid',76),(84,82,'Core','paid',67),(91,82,'React','free',86),(100,72,'E-book Store','paid',95),(104,102,'Core','paid',67),(114,102,'react Native ','paid',108),(132,130,'Core Java','paid',124),(136,102,'Core Java','paid',124),(148,146,'React native','paid',140),(152,150,'React native','paid',140),(156,154,'React native','paid',140),(166,146,'Java Sandeep Sir','paid',160),(176,174,'DotNet','paid',170);
/*!40000 ALTER TABLE `enrolled_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (182);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `ord_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `total_amt` float DEFAULT NULL,
  `ord_date` varchar(255) DEFAULT NULL,
  `user_user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ord_id`),
  KEY `FK38709695otpk064vi3y92u08s` (`user_user_id`),
  CONSTRAINT `FK38709695otpk064vi3y92u08s` FOREIGN KEY (`user_user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (73,'pankaj',799,'22/02/2023',72),(79,'pankaj',999,'25/02/2023',72),(83,'adaresh',799,'30/04/2023',82),(90,'adaresh',0,'30/04/2023',82),(99,'pankaj',799,'10/05/2023',72),(103,'pallavi',799,'19/05/2023',102),(113,'pallavi',799,'19/05/2023',102),(131,'studentone',799,'25/05/2023',130),(135,'pallavi',799,'25/08/2023',102),(147,'abhinav',899,'25/08/2023',146),(151,'ramesh',899,'25/08/2023',150),(155,'rameshone',899,'25/08/2023',154),(165,'abhinav',799,'26/08/2023',146),(175,'sujit',700,'17/02/2024',174);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Instructor'),(3,'Student');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_topic`
--

DROP TABLE IF EXISTS `sub_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_topic` (
  `subt_id` bigint NOT NULL,
  `subt_index_no` varchar(255) DEFAULT NULL,
  `subt_title` varchar(255) DEFAULT NULL,
  `subt_desc` varchar(255) DEFAULT NULL,
  `subt_thumb_path` varchar(255) DEFAULT NULL,
  `subt_file_path` varchar(255) DEFAULT NULL,
  `subt_video_path` varchar(255) DEFAULT NULL,
  `chapter_chapter_id` bigint DEFAULT NULL,
  `courseid_course_id` bigint DEFAULT NULL,
  PRIMARY KEY (`subt_id`),
  KEY `FK7ury91wapy3swl7f3cvjq8y6m` (`chapter_chapter_id`),
  KEY `FKn326ubxvhrdpo6uhaneg317go` (`courseid_course_id`),
  CONSTRAINT `FK7ury91wapy3swl7f3cvjq8y6m` FOREIGN KEY (`chapter_chapter_id`) REFERENCES `chapter` (`chapter_id`),
  CONSTRAINT `FKn326ubxvhrdpo6uhaneg317go` FOREIGN KEY (`courseid_course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_topic`
--

LOCK TABLES `sub_topic` WRITE;
/*!40000 ALTER TABLE `sub_topic` DISABLE KEYS */;
INSERT INTO `sub_topic` VALUES (111,'1.1','UseState','basic of usestate',NULL,'','',110,108),(112,'1.2','UseSelector','basic of use selector',NULL,'','',110,108),(117,'2.1','UseEffect','basic of use effect',NULL,'','',116,108),(120,'3.1','mdb','',NULL,'','',118,108),(121,'4.1','Basic of mdb ','',NULL,'','',119,108),(126,'1.1','Abstraction','Basic of Abstraction',NULL,'','',125,124),(127,'1.2','Encapsulation','Basic of encapsulation',NULL,'','',125,124),(128,'1.3','Polymorphism','kkashk',NULL,'','',125,124),(129,'1.4','Inheritance','sadk',NULL,'','',125,124),(144,'1.1','useSelector','basic of useSelector',NULL,'','',142,140),(145,'2.1','Bootstrap','basic of bootstrap',NULL,'','',143,140),(162,'1.1','Abstraction','basic of abstraction',NULL,'','',161,160),(163,'1.2','Encapsulation','basic of encapsulation',NULL,'','',161,160),(164,'1.3','Polymorphisam','Basic of ploy',NULL,'','',161,160),(172,'1.1','Abstraction','basic of abtraction',NULL,'','',171,170),(173,'1.2','Polymorphism','basic of polymorphism',NULL,'','',171,170),(180,'1.1','abstraction','ada',NULL,'','',179,178),(181,'1.2','polymorphism','ah',NULL,'','',179,178);
/*!40000 ALTER TABLE `sub_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_role_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKgx0oqf703aa8cmro1cimhh13v` (`role_role_id`),
  CONSTRAINT `FKgx0oqf703aa8cmro1cimhh13v` FOREIGN KEY (`role_role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'aurangabad','admin@gmail.com','admin','admin','123456','8007592194','admin',1),(72,'ch','pankaj@gmail.com','pankaj','ch','123456','8007592194','pankaj',3),(82,'plot no 9 s.no 33/2 Sairaj Nagar Beed by pass khadi road Aurangabad','adaresh@gmail.com','Adaresh','patil','123456','8007592194','adaresh',3),(102,'Banglore','pallavighuge170999@gmail.com','pallavi','ghuge','12345678','8007592914','pallavi',3),(106,'pune','teacherone@gmail.com','teacherone','patil','12345678','8007592194','teacherone',2),(122,'Pune','teachertwo@gmail.com','teachertwo','teachertwo','123456','8007592194','teachertwo',2),(130,'Pune','studentone@gmail.com','studentone','studentone','123456','8007592194','studentone',3),(138,'pune','pranitapatil@gmail.com','pranita','patil','123456','8007592194','pranita',2),(146,'pune','abhinaverma1495@gmail.com','abhinav','patil','123456','8007592194','abhinav',3),(150,'pune','ashokdpate@gmail.com','ramesh','patil','123456','8007592194','ramesh',3),(154,'pune','ashokdpate@gmail.com','rameshone','rameshone','123456','8007592194','rameshone',3),(158,'pune','anukurkumar@gmail.com','ankur','kumar','123456','8007592194','ankur123',2),(168,'pune','lokesh@gmail.com','lokesh','patil','Pass@123','8007592194','lokesh',2),(174,'pune','sujit.pallakhe@gmail.com','sujit','patil','Pass@123','8007592194','sujit',3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-21 10:47:05
