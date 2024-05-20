-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ebook-ap
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `book_dtls`
--

DROP TABLE IF EXISTS `book_dtls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_dtls` (
  `bookId` int NOT NULL AUTO_INCREMENT,
  `bookname` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `bookCategory` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_dtls`
--

LOCK TABLES `book_dtls` WRITE;
/*!40000 ALTER TABLE `book_dtls` DISABLE KEYS */;
INSERT INTO `book_dtls` VALUES (13,'JavaScript','Mr.SaKetSir','888','New','Active','Html.jfif','admin'),(27,'React','mohit','77','Old','Active','lion1.png','jages@gmail.com'),(28,'AdvanceJava','SaketBthnagarSir','332','Old','Active','java.webp','sohit@gmail.com'),(29,'Cprogrammning','sohit','3333','Old','Active','background.png','priti@gmail.com'),(33,'JavaProgrammning','Md.MasoodAnshariSir','300','New','Active','java.webp','admin'),(36,'BootstrapOld','Deva','400','Old','Active','textsohit.png','nom@gmail.com'),(38,'Java','Mr.Shambhu Sir','336','New','Active','java.webp','admin'),(39,'AdvanceJava','Md.MasoodAnshariSir','777','New','Active','a5.jpg','admin'),(40,'OLdBookCss3','Nayan','600','Old','Active','a.webp','aryan@gmail.com');
/*!40000 ALTER TABLE `book_dtls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_order`
--

DROP TABLE IF EXISTS `book_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `book_name` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `payment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_order`
--

LOCK TABLES `book_order` WRITE;
/*!40000 ALTER TABLE `book_order` DISABLE KEYS */;
INSERT INTO `book_order` VALUES (1,'BOOK-ORD-00730','johit1','dom@gmail.com','Noida,Mother Dairy,delhi,UP,805196','982789043','HTMl5','sohitkumar','7777.0','COD'),(2,'BOOK-ORD-00300','johit1','dom@gmail.com','Noida,Mother Dairy,delhi,UP,805196','982789043','JavaProgrammning','Md.MasoodAnshariSir','300.0','COD'),(3,'BOOK-ORD-00350','johit1','dom@gmail.com','Noida,Mother Dairy,delhi,UP,805196','982789043','React','sohit','876.0','COD'),(4,'BOOK-ORD-00535','johit1','dom@gmail.com','Noida,Mother Dairy,delhi,UP,805196','982789043','AdvanceJava','Massod','555.0','COD'),(5,'BOOK-ORD-00171','johit1','dom@gmail.com','Nawada,Shiv Mandir,Rupow,Bihar,805107','982789043','HTMl5','sohitkumar','7777.0','COD'),(6,'BOOK-ORD-0045','johit1','dom@gmail.com','Nawada,Shiv Mandir,Rupow,Bihar,805107','982789043','JavaProgrammning','Md.MasoodAnshariSir','300.0','COD'),(7,'BOOK-ORD-00973','johit1','dom@gmail.com','Nawada,Shiv Mandir,Rupow,Bihar,805107','982789043','React','sohit','876.0','COD'),(8,'BOOK-ORD-00723','johit1','dom@gmail.com','Nawada,Shiv Mandir,Rupow,Bihar,805107','982789043','AdvanceJava','Massod','555.0','COD'),(9,'BOOK-ORD-00217','Mohit Kumar','priti@gmail.com','Nawada,Mother Dairy,Rupow,Bihar,805196','3456765435','HTMl5','sohitkumar','7777.0','COD'),(10,'BOOK-ORD-00500','Mohit Kumar','priti@gmail.com','Nawada,Mother Dairy,Rupow,Bihar,805196','3456765435','React','sohit','876.0','COD'),(11,'BOOK-ORD-0045','Mohit Kumar','priti@gmail.com','Nawada,Mother Dairy,Rupow,Bihar,805196','3456765435','AdvanceJava','Massod','555.0','COD'),(12,'BOOK-ORD-00905','johit1','dom@gmail.com','Nawada,Shiv Mandir,BIharSarif,Bihar,805107','982789043','JavaScript','Mr.SaKetSir','888.0','COD'),(13,'BOOK-ORD-00470','johit1','dom@gmail.com','Nawada,Shiv Mandir,BIharSarif,Bihar,805107','982789043','HTMl5','sohitkumar','7777.0','COD'),(14,'BOOK-ORD-00428','sohit','sohitbholu999@gmail.com','Nawada,Bihar,mother,bihar,bihar,789765','786545678','JavaProgrammning','Md.MasoodAnshariSir','300.0','COD'),(15,'BOOK-ORD-00986','sohit','sohitbholu999@gmail.com','Nawada,Bihar,mother,bihar,bihar,789765','786545678','AdvanceJava','Massod','555.0','COD'),(16,'BOOK-ORD-00893','rohan1','nom@gmail.com','Noida,mother,Rupow,Bihar,805196','982789043','JavaScript','Mr.SaKetSir','888.0','COD'),(17,'BOOK-ORD-00301','rohan1','nom@gmail.com','Noida,mother,Rupow,Bihar,805196','982789043','HTMl5','sohitkumar','7777.0','COD'),(18,'BOOK-ORD-00516','rohan1','nom@gmail.com','Noida,mother,Rupow,Bihar,805196','982789043','JavaProgrammning','Md.MasoodAnshariSir','300.0','COD'),(19,'BOOK-ORD-00891','rohan1','nom@gmail.com','Noida,Mother Dairy,Rupow,Bihar,805107','982789043','JavaScript','Mr.SaKetSir','888.0','COD'),(20,'BOOK-ORD-0093','rohan1','nom@gmail.com','Noida,Mother Dairy,Rupow,Bihar,805107','982789043','HTMl5','sohitkumar','7777.0','COD'),(21,'BOOK-ORD-00197','rohan1','nom@gmail.com','Noida,Mother Dairy,Rupow,Bihar,805107','982789043','JavaProgrammning','Md.MasoodAnshariSir','300.0','COD'),(22,'BOOK-ORD-00226','rohan1','nom@gmail.com','Noida,Mother Dairy,Rupow,Bihar,805107','982789043','Bootstrap','Mr.Sohit','122.0','COD'),(23,'BOOK-ORD-00781','amarjeet kumar','amarjeet@gmail.com','Nawada,Mother Dairy,Rupow,Nawada,805196','675879897879','Bootstrap','Mr.Sohit','122.0','COD'),(24,'BOOK-ORD-00272','amarjeet kumar','amarjeet@gmail.com','Nawada,Mother Dairy,Rupow,Nawada,805196','675879897879','JavaProgrammning','Md.MasoodAnshariSir','300.0','COD'),(25,'BOOK-ORD-00412','rohu','rohu1@gmail.com','Noida,Mother Dairy,Rupow,UP,805107','7543895568','JavaProgrammning','Md.MasoodAnshariSir','300.0','COD'),(26,'BOOK-ORD-00267','rohu','rohu1@gmail.com','Noida,Mother Dairy,Rupow,UP,805107','7543895568','React','sohit','876.0','COD'),(27,'BOOK-ORD-00824','amarjeet kumar','amarjeet@gmail.com','noida,noida,noida,uttar pradesh,272130','675879897879','Css','SaketBthnagarSir','9999.0','COD'),(28,'BOOK-ORD-00963','Aryan','aryan@gmail.com','Noida,Mother Dairy,delhi,Nawada,805107','7543895568','Java','Mr.Shambhu Sir','336.0','COD'),(29,'BOOK-ORD-00311','Aryan','aryan@gmail.com','Noida,Mother Dairy,delhi,Nawada,805107','7543895568','JavaProgrammning','Md.MasoodAnshariSir','300.0','COD'),(30,'BOOK-ORD-0024','amarjeet kumar','amarjeet@gmail.com','Noida,Mother Dairy,Rupow,Bihar,805196','675879897879','AdvanceJava','Md.MasoodAnshariSir','777.0','COD'),(31,'BOOK-ORD-00100','amarjeet kumar','amarjeet@gmail.com','Noida,Mother Dairy,Rupow,Bihar,805196','675879897879','Java','Mr.Shambhu Sir','336.0','COD');
/*!40000 ALTER TABLE `book_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `bid` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `book_name` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (138,13,8,'JavaScript','Mr.SaKetSir',888,888),(139,13,8,'JavaScript','Mr.SaKetSir',888,888),(140,10,8,'JavaProgrammning','saketsir',333,333),(141,10,8,'JavaProgrammning','saketsir',333,333),(166,11,10,'Mysql','NazimSir',999,999),(206,34,7,'HTMl5','sohitkumar',7777,7777),(207,30,7,'React','sohit',876,876),(208,16,7,'AdvanceJava','Massod',555,555),(212,34,3,'HTMl5','sohitkumar',7777,7777),(214,33,7,'JavaProgrammning','Md.MasoodAnshariSir',300,300),(217,33,15,'JavaProgrammning','Md.MasoodAnshariSir',300,300),(218,16,15,'AdvanceJava','Massod',555,555),(223,30,3,'React','sohit',876,876),(226,33,18,'JavaProgrammning','Md.MasoodAnshariSir',300,300),(229,30,18,'React','sohit',876,876),(232,38,19,'Java','Mr.Shambhu Sir',336,336),(233,33,19,'JavaProgrammning','Md.MasoodAnshariSir',300,300),(235,39,17,'AdvanceJava','Md.MasoodAnshariSir',777,777),(236,38,17,'Java','Mr.Shambhu Sir',336,336);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phno` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `adress` varchar(45) DEFAULT NULL,
  `landmark` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `pincode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sohi','rohit@gmail.com','7543895568','sohit123',NULL,NULL,NULL,NULL,NULL),(3,'sohit2','nom@gmail.com','982789043','1234',NULL,NULL,NULL,NULL,NULL),(4,'johit','dom@gmail.com','7534456567','1239',NULL,NULL,NULL,NULL,NULL),(5,'gona','gona@gmail.com','754367899','3456',NULL,NULL,NULL,NULL,NULL),(6,'njo','durga@gmail.com','7356786547','123',NULL,NULL,NULL,NULL,NULL),(7,'Mohit Kumar','priti@gmail.com','3456765435','12323',NULL,NULL,NULL,NULL,NULL),(8,'rohan','rohan@gmail.com','8765456787','1233',NULL,NULL,NULL,NULL,NULL),(9,'Dohit','Dohit@gmail.com','8765467897','123',NULL,NULL,NULL,NULL,NULL),(10,'Sohit kumar','sohit@gmail.com','765435678','123',NULL,NULL,NULL,NULL,NULL),(11,'anuj psnchal','panchslsnuj2912@gmmkd.cpm','79902681','Anuj',NULL,NULL,NULL,NULL,NULL),(12,'mohit','dom1@gmer.com','234454654','12',NULL,NULL,NULL,NULL,NULL),(13,'mohan','mohan@gmail.com','765456765','123',NULL,NULL,NULL,NULL,NULL),(14,'dohn','nohit@gmail.com','987689','999',NULL,NULL,NULL,NULL,NULL),(15,'sohit','sohitbholu999@gmail.com','786545678','123',NULL,NULL,NULL,NULL,NULL),(16,'roj','sohit@gmail.kwjdqcom','1234','12',NULL,NULL,NULL,NULL,NULL),(17,'amarjeet kumar','amarjeet@gmail.com','675879897879','123',NULL,NULL,NULL,NULL,NULL),(18,'rohu','rohu1@gmail.com','7543895568','123',NULL,NULL,NULL,NULL,NULL),(19,'Aryan1','aryan@gmail.com','7543895568','123',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-03 18:35:08
