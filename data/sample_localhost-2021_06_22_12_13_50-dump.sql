-- MySQL dump 10.13  Distrib 5.6.14, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sample
-- ------------------------------------------------------
-- Server version	5.7.34

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
-- Table structure for table `BOOKBOOK`
--

DROP TABLE IF EXISTS `BOOKBOOK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BOOKBOOK` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书id',
  `name` varchar(128) CHARACTER SET latin1 NOT NULL COMMENT '图书名称',
  `isbn` varchar(128) CHARACTER SET latin1 NOT NULL COMMENT '图书书号',
  `author` varchar(64) CHARACTER SET latin1 DEFAULT NULL COMMENT '作者',
  `publishTime` datetime DEFAULT NULL COMMENT '出版时间',
  `price` double NOT NULL COMMENT '价格',
  `category` varchar(64) CHARACTER SET latin1 DEFAULT NULL COMMENT '图书类别',
  `count` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='图书表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOOKBOOK`
--

LOCK TABLES `BOOKBOOK` WRITE;
/*!40000 ALTER TABLE `BOOKBOOK` DISABLE KEYS */;
INSERT INTO `BOOKBOOK` (`bookId`, `name`, `isbn`, `author`, `publishTime`, `price`, `category`, `count`) VALUES (1,'Call Me by Your Name','ISBN 978-1-2501-6944-0','Andre Aciman','2017-06-19 00:14:12',25,'I',98),(3,'Harry Potter and the Goblet of Fire','ISBN 978-0-4391-3959-5','J.K. Rowling','2000-07-21 23:54:05',45,'I',100),(4,'Harry Potter and the Sorcerer\'s Stone','ISBN 978-0-5903-5340-3','J.K. Rowling','1998-07-21 00:00:00',48,'I',46),(5,'Harry Potter and The Cursed Child – Parts One and Two','ISBN 978-1-7811-0704-1','J.K. Rowling','2021-01-21 00:00:00',60,'I',100),(6,'Call Me by Your Name 2','ISBN 978-1-2501-6944-0','Andre Aciman','2017-06-19 00:00:00',25,'I',100),(7,'Call Me by Your Name 3','ISBN 978-1-2501-6944-0','Andre Aciman','2017-06-19 00:00:00',25,'I',100),(8,'Call Me by Your Name 2','ISBN 978-1-2501-6944-0','Andre Aciman','2017-06-19 00:00:00',25,'I',100),(9,'Call Me by Your Name 4','ISBN 978-1-2501-6944-0','Andre Aciman','2017-06-19 00:00:00',25,'I',100),(10,'Call Me by Your Name 6','ISBN 978-1-2501-6944-0','Andre Aciman','2017-06-19 00:00:00',25,'I',100),(13,'Harry Potter and The Cursed Child – Parts One and Two 1','ISBN 978-1-7811-0704-1','J.K. Rowling','2021-01-21 00:00:00',60,'I',100);
/*!40000 ALTER TABLE `BOOKBOOK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BOOKORDER`
--

DROP TABLE IF EXISTS `BOOKORDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BOOKORDER` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `address` varchar(128) NOT NULL COMMENT '配送地址',
  `deliveryTime` datetime NOT NULL COMMENT '配送时间',
  `receiverName` varchar(64) NOT NULL COMMENT '收件人姓名',
  `tel` varchar(64) NOT NULL COMMENT '电话',
  `total` double NOT NULL COMMENT '总钱数',
  PRIMARY KEY (`orderId`),
  KEY `BOOKORDER_BOOKUSER_userId_fk` (`userId`),
  CONSTRAINT `BOOKORDER_BOOKUSER_userId_fk` FOREIGN KEY (`userId`) REFERENCES `BOOKUSER` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOOKORDER`
--

LOCK TABLES `BOOKORDER` WRITE;
/*!40000 ALTER TABLE `BOOKORDER` DISABLE KEYS */;
INSERT INTO `BOOKORDER` (`orderId`, `userId`, `address`, `deliveryTime`, `receiverName`, `tel`, `total`) VALUES (1,1,'jlu','2021-06-20 20:13:07','jlu','13756489946',1),(2,3,'address','2017-06-19 00:00:00','wyy','1234566',25),(6,3,'address','2017-06-19 00:00:00','wyy','1234566',25),(7,3,'address','2017-06-19 00:00:00','wyy','1234566',25),(8,3,'address','2017-06-19 00:00:00','wyy','1234566',121),(9,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(10,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(11,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(12,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(13,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(14,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(15,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(16,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(17,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(18,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(19,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(20,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(21,3,'address','2017-06-19 00:00:00','wyy','1234566',0),(22,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(23,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(24,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(25,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(26,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(27,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(28,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(29,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(30,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(31,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(32,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(33,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(34,3,'address','2017-06-19 00:00:00','wyy','1234566',96),(35,3,'address','2017-06-19 00:00:00','wyy','1234566',96);
/*!40000 ALTER TABLE `BOOKORDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BOOKSUBORDER`
--

DROP TABLE IF EXISTS `BOOKSUBORDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BOOKSUBORDER` (
  `subOrderId` int(11) NOT NULL AUTO_INCREMENT COMMENT '子订单id',
  `orderId` int(11) NOT NULL COMMENT '订单id',
  `bookId` int(11) NOT NULL COMMENT '图书id',
  `num` int(11) NOT NULL DEFAULT '1' COMMENT '个数',
  `price` double NOT NULL COMMENT '单价',
  PRIMARY KEY (`subOrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='子订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOOKSUBORDER`
--

LOCK TABLES `BOOKSUBORDER` WRITE;
/*!40000 ALTER TABLE `BOOKSUBORDER` DISABLE KEYS */;
INSERT INTO `BOOKSUBORDER` (`subOrderId`, `orderId`, `bookId`, `num`, `price`) VALUES (1,1,1,1,25),(2,1,3,1,45),(3,6,1,1,25),(4,7,1,1,25),(5,8,4,2,96),(6,8,1,1,25),(7,9,4,2,96),(8,10,4,2,96),(9,11,4,2,96),(10,12,4,2,96),(11,13,4,2,96),(12,14,4,2,96),(13,15,4,2,96),(14,16,4,2,96),(15,17,4,2,96),(16,18,4,2,96),(17,19,4,2,96),(18,20,4,2,96),(19,22,4,2,96),(20,23,4,2,96),(21,24,4,2,96),(22,25,4,2,96),(23,26,4,2,96),(24,27,4,2,96),(25,28,4,2,96),(26,29,4,2,96),(27,30,4,2,96),(28,31,4,2,96),(29,32,4,2,96),(30,33,4,2,96),(31,34,4,2,96),(32,35,4,2,96);
/*!40000 ALTER TABLE `BOOKSUBORDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BOOKUSER`
--

DROP TABLE IF EXISTS `BOOKUSER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BOOKUSER` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(128) CHARACTER SET latin1 NOT NULL COMMENT '用户名称',
  `password` varchar(64) CHARACTER SET latin1 NOT NULL COMMENT '用户密码',
  `userType` int(11) DEFAULT '1' COMMENT '用户类型:0admin;1user',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `BOOKUSER_userName_uindex` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='user和admin表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOOKUSER`
--

LOCK TABLES `BOOKUSER` WRITE;
/*!40000 ALTER TABLE `BOOKUSER` DISABLE KEYS */;
INSERT INTO `BOOKUSER` (`userId`, `userName`, `password`, `userType`) VALUES (1,'wyy','wyy',0),(2,'www','www',1),(3,'user','user',1),(4,'user1','user1',1),(5,'wyy1','wyy1',1),(7,'wyy2','wyy2',1);
/*!40000 ALTER TABLE `BOOKUSER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22 12:13:52
