-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: account
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `user_id` varchar(45) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('082','æ','123','123','13723578956','manager'),('1','1','123','455','null','ordinary'),('150916','bg','123','13760254672','13760254672','ordinary'),('2','2','123','D1210','null','ordinary'),('2015150081','oupei','123','1210','123','ordinary'),('2015150901','901','123','1210','132','ordinary'),('2015150902','902','123','522','123','manager'),('5','556','123','13756956985','45','ordinary'),('78','98','123','15','13758698569','manager'),('sd232','sds','123','sd','13756985698','ordinary');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(45) NOT NULL,
  `book_author` varchar(45) DEFAULT NULL,
  `book_residual_number` int(11) NOT NULL DEFAULT '0',
  `book_total_number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'鲁滨逊漂流记','我op',1,10),(2,'解忧杂货店','东野圭吾',2,3),(3,'人生最美是清欢','林清玄',2,2),(4,'后记落叶听雨声','朱光潜',1,1),(5,'月亮与六便士','毛姆',4,4),(6,'穷查理宝典','我',2,2),(7,'性学三论','未知',1,1),(8,'洛丽塔','未知',2,2),(9,'呐喊','鲁迅',2,2),(10,'沉沦','郁达夫',2,3),(11,'彷徨','鲁迅',1,1),(12,'巴黎圣母院','未知',5,5),(13,'人性的弱点','卡耐基',6,6),(14,'独居日记','梅萨藤',1,1),(15,'爱的艺术','弗洛姆',1,1),(16,'幽梦影','涨潮',1,1),(17,'我与地坛','史铁生',3,3),(18,'当我在跑步的时候我谈些什么','村上春树',5,5),(19,'白鹿原','陈忠实',1,1),(20,'苏菲女士的日记','丁玲',1,1),(21,'双城记','狄更斯',3,3),(22,'浮士德','卢梭',2,2),(23,'流浪者之歌','未知',1,1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow` (
  `borrow_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `borrow_book_name` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `volunteer_id` int(11) DEFAULT NULL,
  `borrow_time` datetime DEFAULT NULL,
  `borrow_book_num` int(11) DEFAULT NULL,
  `borrow_book_author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`borrow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
INSERT INTO `borrow` VALUES (1,2015150081,'解忧杂货店','已完成',NULL,'2018-01-03 18:38:27',1,'null'),(2,2015150081,'人生最美是清欢','已完成',NULL,'2018-01-03 18:38:27',1,'null'),(3,2015150081,'后记落叶听雨声','已完成',NULL,'2018-01-03 18:38:27',1,'null'),(4,1,'鲁滨逊漂流记','已完成',NULL,'2018-01-03 18:42:41',1,'null'),(5,1,'解忧杂货店','已完成',NULL,'2018-01-03 18:42:41',1,'null'),(6,1,'人生最美是清欢','已完成',NULL,'2018-01-03 18:42:41',1,'null'),(7,1,'鲁滨逊漂流记','已完成',NULL,'2018-01-03 18:44:46',1,'null'),(8,1,'解忧杂货店','已完成',NULL,'2018-01-03 18:44:46',1,'null'),(9,1,'鲁滨逊漂流记','已完成',NULL,'2018-01-03 19:39:22',2,'null'),(10,1,'鲁滨逊漂流记','审核中',NULL,'2018-01-03 19:41:38',1,'null'),(11,1,'月亮与六便士','审核中',NULL,'2018-01-03 19:44:03',2,'null'),(12,1,'月亮与六便士','审核中',NULL,'2018-01-03 20:40:23',1,'毛姆'),(13,1,'鲁滨逊漂流记','审核中',NULL,'2018-01-03 20:47:17',1,'我op'),(14,1,'性学三论','审核中',NULL,'2018-01-03 20:47:17',1,'未知'),(15,2015150081,'鲁滨逊漂流记','审核中',NULL,'2018-01-04 00:48:13',2,'我op'),(16,2015150081,'鲁滨逊漂流记','审核中',NULL,'2018-01-04 00:54:45',2,'我op'),(17,2015150081,'鲁滨逊漂流记','审核中',NULL,'2018-01-04 01:01:09',2,'我op'),(18,78,'解忧杂货店','已完成',NULL,'2018-01-04 13:43:56',1,'东野圭吾'),(19,2015150081,'沉沦','审核中',NULL,'2018-01-04 14:41:53',1,'郁达夫'),(20,2015150081,'鲁滨逊漂流记','已完成',NULL,'2018-01-04 15:24:14',1,'我op');
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donate`
--

DROP TABLE IF EXISTS `donate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donate` (
  `donate_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `donate_book_name` varchar(45) DEFAULT NULL,
  `donate_book_author` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `volunteer_id` int(11) DEFAULT NULL,
  `donate_time` datetime DEFAULT NULL,
  `donate_book_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`donate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donate`
--

LOCK TABLES `donate` WRITE;
/*!40000 ALTER TABLE `donate` DISABLE KEYS */;
INSERT INTO `donate` VALUES (1,2015150081,'2','2','已完成',NULL,'2018-01-04 01:26:55',2),(2,150916,'123','123','已完成',NULL,'2018-01-04 12:32:47',2),(3,82,'2','2','已完成',NULL,'2018-01-04 12:33:48',32),(4,5,'1','1','已完成',NULL,'2018-01-04 12:43:41',1),(5,78,'5645','5645','已完成',NULL,'2018-01-04 13:44:35',3),(6,78,'2','2','已完成',NULL,'2018-01-04 13:55:05',3),(7,78,'253','253','已完成',NULL,'2018-01-04 13:55:10',3),(8,78,'1','1','审核中',NULL,'2018-01-04 13:58:10',2),(9,78,'6','6','审核中',NULL,'2018-01-04 13:58:22',6),(10,1,'1','1','已完成',NULL,NULL,NULL);
/*!40000 ALTER TABLE `donate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,1,'111','111','已读',NULL),(2,2,'22','22','未读',NULL),(3,3,'4123','32','未读',NULL),(4,23,'23','23','未读',NULL),(5,23,'13','12','未读',NULL),(6,32,'32','32','已读',NULL),(7,150916,'1','2580616628qq.com','未读',NULL),(8,82,'45','78','未读',NULL),(9,150916,'1','2580616628qq.com','未读',NULL),(10,5,'868','85687','未读',NULL),(11,78,'45567','867','未读',NULL),(12,2015150081,'68','545','已读',NULL);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'account'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-05 17:01:45
