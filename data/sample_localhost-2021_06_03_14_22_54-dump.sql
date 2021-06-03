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
-- Table structure for table `ADDRESS`
--

DROP TABLE IF EXISTS `ADDRESS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADDRESS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADDRESS`
--

LOCK TABLES `ADDRESS` WRITE;
/*!40000 ALTER TABLE `ADDRESS` DISABLE KEYS */;
INSERT INTO `ADDRESS` (`id`, `detail`) VALUES (1,'address2'),(2,'address2'),(3,'address2'),(5,'test add address'),(6,'test update address'),(7,'test add address'),(8,'addr add'),(9,'1111');
/*!40000 ALTER TABLE `ADDRESS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COURSE`
--

DROP TABLE IF EXISTS `COURSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COURSE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COURSE`
--

LOCK TABLES `COURSE` WRITE;
/*!40000 ALTER TABLE `COURSE` DISABLE KEYS */;
INSERT INTO `COURSE` (`id`, `courseName`) VALUES (1,'1&1'),(2,'c2&c1'),(3,'3&3'),(4,'3&3');
/*!40000 ALTER TABLE `COURSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MANYTOMANYCOURSE`
--

DROP TABLE IF EXISTS `MANYTOMANYCOURSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MANYTOMANYCOURSE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COMMENT='多对多：课程';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MANYTOMANYCOURSE`
--

LOCK TABLES `MANYTOMANYCOURSE` WRITE;
/*!40000 ALTER TABLE `MANYTOMANYCOURSE` DISABLE KEYS */;
INSERT INTO `MANYTOMANYCOURSE` (`id`, `courseName`) VALUES (1,'3'),(2,'3'),(3,'3'),(4,'333'),(5,'c4'),(6,'4'),(15,'1'),(16,'1'),(19,'1'),(20,'1');
/*!40000 ALTER TABLE `MANYTOMANYCOURSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MANYTOMANYTEACHER`
--

DROP TABLE IF EXISTS `MANYTOMANYTEACHER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MANYTOMANYTEACHER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(64) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='多对多：老师';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MANYTOMANYTEACHER`
--

LOCK TABLES `MANYTOMANYTEACHER` WRITE;
/*!40000 ALTER TABLE `MANYTOMANYTEACHER` DISABLE KEYS */;
INSERT INTO `MANYTOMANYTEACHER` (`id`, `teacherName`, `age`, `gender`) VALUES (1,'1',1,1);
/*!40000 ALTER TABLE `MANYTOMANYTEACHER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MANYTOMANY_REF_TEACHER_COURSE`
--

DROP TABLE IF EXISTS `MANYTOMANY_REF_TEACHER_COURSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MANYTOMANY_REF_TEACHER_COURSE` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(20) NOT NULL,
  `course_id` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 COMMENT='多对多：关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MANYTOMANY_REF_TEACHER_COURSE`
--

LOCK TABLES `MANYTOMANY_REF_TEACHER_COURSE` WRITE;
/*!40000 ALTER TABLE `MANYTOMANY_REF_TEACHER_COURSE` DISABLE KEYS */;
INSERT INTO `MANYTOMANY_REF_TEACHER_COURSE` (`id`, `teacher_id`, `course_id`) VALUES (1,2,3),(2,2,4),(11,1,15),(12,1,16),(13,1,20),(14,1,19);
/*!40000 ALTER TABLE `MANYTOMANY_REF_TEACHER_COURSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MENTOR`
--

DROP TABLE IF EXISTS `MENTOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MENTOR` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MENTOR`
--

LOCK TABLES `MENTOR` WRITE;
/*!40000 ALTER TABLE `MENTOR` DISABLE KEYS */;
INSERT INTO `MENTOR` (`id`, `teacherName`, `age`, `gender`) VALUES (1,'11',11,'11');
/*!40000 ALTER TABLE `MENTOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ONETOMANYCOURSE`
--

DROP TABLE IF EXISTS `ONETOMANYCOURSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ONETOMANYCOURSE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(64) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ONETOMANYCOURSE`
--

LOCK TABLES `ONETOMANYCOURSE` WRITE;
/*!40000 ALTER TABLE `ONETOMANYCOURSE` DISABLE KEYS */;
INSERT INTO `ONETOMANYCOURSE` (`id`, `courseName`, `teacher_id`) VALUES (42,'v',15),(43,'b',15),(44,'f',15),(45,'15',15),(46,'15',15);
/*!40000 ALTER TABLE `ONETOMANYCOURSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ONETOMANYTEACHER`
--

DROP TABLE IF EXISTS `ONETOMANYTEACHER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ONETOMANYTEACHER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(64) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COMMENT='一对多：老师';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ONETOMANYTEACHER`
--

LOCK TABLES `ONETOMANYTEACHER` WRITE;
/*!40000 ALTER TABLE `ONETOMANYTEACHER` DISABLE KEYS */;
INSERT INTO `ONETOMANYTEACHER` (`id`, `teacherName`, `age`, `gender`) VALUES (15,'15',15,15);
/*!40000 ALTER TABLE `ONETOMANYTEACHER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STU`
--

DROP TABLE IF EXISTS `STU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STU` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STU`
--

LOCK TABLES `STU` WRITE;
/*!40000 ALTER TABLE `STU` DISABLE KEYS */;
INSERT INTO `STU` (`id`, `name`, `gender`, `major`) VALUES (7,'kkk','123','123'),(8,'testAdd','male','add'),(9,'123','123','123'),(10,'testAdd','male','add'),(11,'123','123','123'),(12,'1111','111','111');
/*!40000 ALTER TABLE `STU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STUDENT`
--

DROP TABLE IF EXISTS `STUDENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STUDENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student` (`address_id`),
  CONSTRAINT `fk_student` FOREIGN KEY (`address_id`) REFERENCES `ADDRESS` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STUDENT`
--

LOCK TABLES `STUDENT` WRITE;
/*!40000 ALTER TABLE `STUDENT` DISABLE KEYS */;
INSERT INTO `STUDENT` (`id`, `name`, `gender`, `major`, `address_id`) VALUES (6,'testAdd','male','add',7),(7,'kkk','male','cs',8),(8,'111','111','111',9);
/*!40000 ALTER TABLE `STUDENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TEACHER`
--

DROP TABLE IF EXISTS `TEACHER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEACHER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TEACHER`
--

LOCK TABLES `TEACHER` WRITE;
/*!40000 ALTER TABLE `TEACHER` DISABLE KEYS */;
INSERT INTO `TEACHER` (`id`, `teacherName`, `age`, `gender`, `courseId`) VALUES (1,'1',1,'1',1),(2,'2',2,'2',2),(3,'3',3,'3',3),(4,'3',3,'3',4);
/*!40000 ALTER TABLE `TEACHER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `pass` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `role`, `pass`) VALUES (1,'Kevin','admin','123'),(2,'Alice','guest','123'),(3,'Bob','guest','123'),(4,'Clark','guest','123');
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

-- Dump completed on 2021-06-03 14:22:54
