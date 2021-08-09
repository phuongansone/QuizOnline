-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quiz_online
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `answer_id` int NOT NULL AUTO_INCREMENT,
  `question_id` int NOT NULL,
  `answer_content` varchar(1000) NOT NULL,
  `is_correct` tinyint NOT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`answer_id`),
  KEY `answer_quiz_fk_idx` (`question_id`),
  CONSTRAINT `answer_quiz_fk` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (6,3,'stopped()',0,'2021-04-20 07:13:32','2021-04-21 07:06:37'),(7,3,'run()',1,'2021-04-20 07:13:32',NULL),(8,3,'runThread()',0,'2021-04-20 07:13:32',NULL),(9,3,'stopThread()',0,'2021-04-20 07:13:32',NULL),(10,4,'Runnable',1,'2021-04-20 07:15:00',NULL),(11,4,'Connections',0,'2021-04-20 07:15:00',NULL),(12,4,'Set',0,'2021-04-20 07:15:00',NULL),(13,4,'MapConnections',0,'2021-04-20 07:15:00',NULL),(14,5,'A thread can be formed by implementing Runnable interface only.',0,'2021-04-20 07:16:25',NULL),(15,5,'A thread can be formed by a class that extends Thread class.',0,'2021-04-20 07:16:25',NULL),(16,5,'start() method is used to begin execution of the thread.',0,'2021-04-20 07:16:25',NULL),(17,5,'run() method is used to begin execution of a thread before start() method in special',1,'2021-04-20 07:16:26',NULL),(18,6,'sleep()',0,'2021-04-20 07:18:00',NULL),(19,6,'isAlive()',0,'2021-04-20 07:18:00',NULL),(20,6,'join()',1,'2021-04-20 07:18:00',NULL),(21,6,'stop()',0,'2021-04-20 07:18:00',NULL),(22,7,'set()',0,'2021-04-20 07:18:49',NULL),(23,7,'make()',0,'2021-04-20 07:18:49',NULL),(24,7,'setPriority()',1,'2021-04-20 07:18:50',NULL),(25,7,'makePriority()',0,'2021-04-20 07:18:50',NULL),(26,8,'It\'s a process of handling situations when two or more threads need access to a shared resource.',0,'2021-04-20 07:19:43',NULL),(27,8,'It\'s a process by which many threads are able to access the same shared resource simultaneously.',1,'2021-04-20 07:19:43',NULL),(28,8,'Its a process by which a method is able to access many different threads simultaneously.',0,'2021-04-20 07:19:43',NULL),(29,8,'Its a method that allow to many threads to access any information required.',0,'2021-04-20 07:19:43',NULL),(30,9,'RecordSet',0,'2021-04-20 07:21:45',NULL),(31,9,'ResultSet',1,'2021-04-20 07:21:45',NULL),(32,9,'DataSet',0,'2021-04-20 07:21:45',NULL),(33,9,'DataSet',0,'2021-04-20 07:21:45',NULL),(34,10,'Single -tier and two tier',0,'2021-04-20 07:23:34',NULL),(35,10,'Single -tier and two tier',0,'2021-04-20 07:23:34',NULL),(36,10,'Three-tier and four tier',0,'2021-04-20 07:23:34',NULL),(37,10,'Two-tier and three-tier',1,'2021-04-20 07:23:34',NULL),(38,11,'True,false',0,'2021-04-20 07:24:29',NULL),(39,11,'True,true',1,'2021-04-20 07:24:29',NULL),(40,11,'False, false',0,'2021-04-20 07:24:29',NULL),(41,11,'False, True',0,'2021-04-20 07:24:29',NULL),(42,12,'java.awt.BorderLayout',0,'2021-04-20 07:26:25',NULL),(43,12,'java.awt.GridLayout',1,'2021-04-20 07:26:25',NULL),(44,12,'java.awt.GridLayout',0,'2021-04-20 07:26:25',NULL),(45,12,'java.awt.FlowLayout',0,'2021-04-20 07:26:25',NULL),(46,14,'java.awt.FontMetric',0,'2021-04-20 07:27:52',NULL),(47,14,'java.util.FontMetric',0,'2021-04-20 07:27:52',NULL),(48,14,'javax.swing.FontMetric',0,'2021-04-20 07:27:52',NULL),(49,14,'java.awt.FontMetrics',1,'2021-04-20 07:27:52',NULL),(50,15,'Vary the priorities of your threads',0,'2021-04-20 07:28:41',NULL),(51,15,'Synchronize access to all shared variables',0,'2021-04-20 07:28:41',NULL),(52,15,'There is no single technique that can guarantee non-deadlocking code',1,'2021-04-20 07:28:41',NULL),(53,15,'Make sure all threads yield from time to time',0,'2021-04-20 07:28:41',NULL),(54,16,'GridLayout',0,'2021-04-20 07:29:36',NULL),(55,16,'FlowLayout',1,'2021-04-20 07:29:36',NULL),(56,16,'GridBagLayout',0,'2021-04-20 07:29:36',NULL),(57,16,'BorderLayout',0,'2021-04-20 07:29:36',NULL),(58,17,'Access the variables only via synchronized methods',1,'2021-04-20 07:30:23',NULL),(59,17,'Mark all variables as volatile',0,'2021-04-20 07:30:23',NULL),(60,17,'Use only static variables',0,'2021-04-20 07:30:23',NULL),(61,17,'Mark all variables as synchronized',0,'2021-04-20 07:30:23',NULL),(62,18,'Only statement 1 is true',0,'2021-04-20 07:32:41',NULL),(63,18,'Only statement 2 is true',0,'2021-04-20 07:32:41',NULL),(64,18,'Both 1 and 2 are true',1,'2021-04-20 07:32:41',NULL),(65,18,'Both 1 and 2 are not true',0,'2021-04-20 07:32:41',NULL),(66,19,'The user has closed all his/her browser windows.',0,'2021-04-20 07:38:22',NULL),(67,19,'The request is the first request from the user.',0,'2021-04-20 07:38:22',NULL),(68,19,'The user\'s browser does not support URL rewriting.',0,'2021-04-20 07:38:22',NULL),(69,19,'The session attribute of page directive is set to false',1,'2021-04-20 07:38:22',NULL),(70,21,'HttpServletSession',0,'2021-04-20 07:39:46',NULL),(71,21,'HttpResponseSession',0,'2021-04-20 07:39:46',NULL),(72,21,'HttpRequestSession',0,'2021-04-20 07:39:46',NULL),(73,21,'HttpSession',1,'2021-04-20 07:39:46',NULL),(74,22,'DoGet, DoPost',0,'2021-04-20 07:41:23',NULL),(75,22,'doGet, doPost',1,'2021-04-20 07:41:23',NULL),(76,22,'doGET, doPOST',0,'2021-04-20 07:41:23',NULL),(77,22,'Get, Post',0,'2021-04-20 07:41:23',NULL),(78,23,'taguri',0,'2021-04-20 07:42:11',NULL),(79,23,'info',0,'2021-04-20 07:42:11',NULL),(80,23,'taglib-location',1,'2021-04-20 07:42:12',NULL),(81,23,'display-name',0,'2021-04-20 07:42:12',NULL),(82,24,'getValue(\"userid\");',0,'2021-04-20 07:43:00',NULL),(83,24,'get(\"userid\");',0,'2021-04-20 07:43:00',NULL),(84,24,'getAttribute(\"userid\");',1,'2021-04-20 07:43:00',NULL),(85,24,'getParameter(\"userid\");',0,'2021-04-20 07:43:00',NULL),(86,25,'HTML FORM is used to capture username and password.',0,'2021-04-20 07:43:36',NULL),(87,25,'Password is transmitted in an encrypted form.',0,'2021-04-20 07:43:36',NULL),(88,25,'Password is transmitted as text',1,'2021-04-20 07:43:37',NULL),(89,25,'Password is transmitted either in encrypted text or in plain text depending on the browser.',0,'2021-04-20 07:43:37',NULL),(90,26,'They are used to represent data stored in a RDBMS',1,'2021-04-20 07:44:23',NULL),(91,26,'They are used to implement business logic',0,'2021-04-20 07:44:23',NULL),(92,26,'They are an Enterprises Beans',0,'2021-04-20 07:44:23',NULL),(93,26,'They are CANNOT hold client state',0,'2021-04-20 07:44:23',NULL),(94,27,'scriptlets',1,'2021-04-20 07:45:18',NULL),(95,27,'expressions',0,'2021-04-20 07:45:18',NULL),(96,27,'declarations',0,'2021-04-20 07:45:18',NULL),(97,27,'none of the others',0,'2021-04-20 07:45:18',NULL),(98,28,'Session beans and web components',0,'2021-04-20 07:45:52',NULL),(99,28,'Only stateless session beans',0,'2021-04-20 07:45:52',NULL),(100,28,'Only stateful session beans',1,'2021-04-20 07:45:52',NULL),(101,28,'Any EJB component',0,'2021-04-20 07:45:52',NULL),(102,30,'EVAL_PAGE',1,'2021-04-20 07:47:53',NULL),(103,30,'EVAL_B0DY',0,'2021-04-20 07:47:53',NULL),(104,30,'EVAL_PAGE_INCLUDE',0,'2021-04-20 07:47:53',NULL),(105,30,'EVAL_BODY_INCLUDE',0,'2021-04-20 07:47:53',NULL),(106,31,'JMS',0,'2021-04-20 07:52:02','2021-04-21 08:00:32'),(107,31,'Stateless session beans',0,'2021-04-20 07:52:02','2021-04-21 08:00:32'),(108,31,'Stateful session beans',1,'2021-04-20 07:52:02','2021-04-21 08:00:32'),(109,31,'Entity beans',0,'2021-04-20 07:52:02','2021-04-21 08:00:32'),(110,32,'jsp page is complied-->Jsp page is translated ~>jsplnit is called ->JspService is called ->jspDestroy is called',0,'2021-04-20 07:52:37',NULL),(111,32,'Jsp page is translated -->jsp page is complied-->jsplnit is called ->JspService is called -->jspDestroy is called',1,'2021-04-20 07:52:37',NULL),(112,32,'Jsp page is translated -->jsp page is complied-->jspService is called ->jsplnit is called ->JspDestroy is called',0,'2021-04-20 07:52:37',NULL),(113,32,'jsp page is complied-->Jsp page is translated --> JspService is called -->jsplnit is called -->jspDestroy is called',0,'2021-04-20 07:52:37',NULL),(114,33,'Its conversational state is lost after passivation unless the bean class saves it to a database',0,'2021-04-20 07:53:17',NULL),(115,33,'Its conversational state is retained across method invocations but NOT across transaction boundaries',0,'2021-04-20 07:53:17',NULL),(116,33,'Its conversational state is retained across method invocations and transactions',1,'2021-04-20 07:53:17',NULL),(117,33,'None of the others',0,'2021-04-20 07:53:17',NULL),(118,34,'A removed entity instance is NOT associated with a persistence context',0,'2021-04-20 08:15:44',NULL),(119,34,'A new entity instance is an instance with a fully populated state.',0,'2021-04-20 08:15:44',NULL),(120,34,'A managed entity instance is the instance associated with a persistence context',1,'2021-04-20 08:15:44',NULL),(121,34,'A detached entity instance is an instance with no persistent identity.',0,'2021-04-20 08:15:44',NULL),(126,36,'Instruction Register (IR)',0,'2021-04-20 08:18:49',NULL),(127,36,'Program Counter (PC)',0,'2021-04-20 08:18:49',NULL),(128,36,'Program Status Word (PSW)',1,'2021-04-20 08:18:49',NULL),(129,36,'None of the other choices',0,'2021-04-20 08:18:49',NULL),(130,37,'ISA (Industry Standard Architecture)',0,'2021-04-20 08:19:34',NULL),(131,37,'PCI (Peripheral Component Interconnect)',1,'2021-04-20 08:19:34',NULL),(132,37,'ISA and PCI',0,'2021-04-20 08:19:34',NULL),(133,37,'None of the other choices',0,'2021-04-20 08:19:34',NULL),(134,38,'Execution of a ROM-based POST sequence',0,'2021-04-20 08:20:12',NULL),(135,38,'Loading one or more bootstrap loaders',0,'2021-04-20 08:20:12',NULL),(136,38,'Loading the OS',0,'2021-04-20 08:20:12',NULL),(137,38,'Loading the command interpreter',1,'2021-04-20 08:20:12',NULL),(138,39,'Is typically faster than cache memory',0,'2021-04-20 08:20:49',NULL),(139,39,'Is volatile',1,'2021-04-20 08:20:49',NULL),(140,39,'Can only be read sequentially',0,'2021-04-20 08:20:49',NULL),(141,39,'Stores all the files on the computer',0,'2021-04-20 08:20:49',NULL),(142,40,'Is volatile',0,'2021-04-20 08:21:44',NULL),(143,40,'To hold the current time and date',0,'2021-04-20 08:21:44',NULL),(144,40,'To contain BIOS',1,'2021-04-20 08:21:44',NULL),(145,40,'To hold the configuration parameters',0,'2021-04-20 08:21:44',NULL),(146,41,'Network interface',0,'2021-04-20 08:22:20',NULL),(147,41,'CPU',0,'2021-04-20 08:22:20',NULL),(148,41,'Graphics accelerator',0,'2021-04-20 08:22:20',NULL),(149,41,'Main memory',1,'2021-04-20 08:22:20',NULL),(150,42,'TinyOS',0,'2021-04-20 08:23:13',NULL),(151,42,'QNX and VxWork',1,'2021-04-20 08:23:13',NULL),(152,42,'Symbian OS and Palm OS',0,'2021-04-20 08:23:13',NULL),(153,42,'e-COS',0,'2021-04-20 08:23:13',NULL),(154,43,'procedure library',1,'2021-04-20 08:23:52',NULL),(155,43,'operator',0,'2021-04-20 08:23:52',NULL),(156,43,'pointer',0,'2021-04-20 08:23:53',NULL),(157,43,'None of the other choices',0,'2021-04-20 08:23:53',NULL),(158,44,'Communication between processes',0,'2021-04-20 08:24:27',NULL),(159,44,'File manipulation',0,'2021-04-20 08:24:27',NULL),(160,44,'Execution of a program, I/O operations performed by it, and detecting and reporting errors caused by it',0,'2021-04-20 08:24:27',NULL),(161,44,'All of the other choices',1,'2021-04-20 08:24:27',NULL),(162,45,'Easier to extend',0,'2021-04-20 08:25:07',NULL),(163,45,'Easier to debug from lower to upper layer',0,'2021-04-20 08:25:07',NULL),(164,45,'Easier to extend and Easier to debug from lower to upper layer',1,'2021-04-20 08:25:07',NULL),(165,45,'None of the other choices',0,'2021-04-20 08:25:07',NULL),(166,46,'CreateProcess; fork',1,'2021-04-20 08:26:11',NULL),(167,46,'fork, CreateProcess',0,'2021-04-20 08:26:11',NULL),(168,46,'copy, CreateProcess',0,'2021-04-20 08:26:11',NULL),(169,46,'CreateProcess; copy',0,'2021-04-20 08:26:11',NULL),(170,47,'Running -> Blocked (waiting)',0,'2021-04-20 08:26:48',NULL),(171,47,'Running -> ready',0,'2021-04-20 08:26:48',NULL),(172,47,'Blocked (waiting) -> ready',1,'2021-04-20 08:26:48',NULL),(173,47,'Ready -> Blocked (waiting)',0,'2021-04-20 08:26:48',NULL),(174,48,'50%',0,'2021-04-20 08:27:18',NULL),(175,48,'25%',0,'2021-04-20 08:27:18',NULL),(176,48,'75%',1,'2021-04-20 08:27:19',NULL),(177,48,'None of the other choices',0,'2021-04-20 08:27:19',NULL),(178,49,'Pop-up',1,'2021-04-20 08:27:52',NULL),(179,49,'Upcall',0,'2021-04-20 08:27:52',NULL),(180,49,'Activator',0,'2021-04-20 08:27:52',NULL),(181,49,'Distributed',0,'2021-04-20 08:27:52',NULL),(182,50,'Java Desktop',1,'2021-04-22 17:58:50','2021-04-22 18:01:13'),(183,50,'Java Web',0,'2021-04-22 17:58:50','2021-04-22 18:01:13'),(184,50,'OS',0,'2021-04-22 17:58:50','2021-04-22 18:01:13'),(185,50,'No',0,'2021-04-22 17:58:50','2021-04-22 18:01:13'),(186,51,'A',0,'2021-04-22 21:38:29',NULL),(187,51,'B',0,'2021-04-22 21:38:29',NULL),(188,51,'C',1,'2021-04-22 21:38:29',NULL),(189,51,'D',0,'2021-04-22 21:38:29',NULL),(190,52,'A',1,'2021-04-22 21:38:51',NULL),(191,52,'B',0,'2021-04-22 21:38:51',NULL),(192,52,'C',0,'2021-04-22 21:38:51',NULL),(193,52,'D',0,'2021-04-22 21:38:51',NULL),(194,53,'A update',0,'2021-04-22 21:39:17','2021-04-22 21:40:36'),(195,53,'B update',1,'2021-04-22 21:39:17','2021-04-22 21:40:36'),(196,53,'C update',0,'2021-04-22 21:39:17','2021-04-22 21:40:36'),(197,53,'D update',0,'2021-04-22 21:39:17','2021-04-22 21:40:36');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `question_content` varchar(1000) NOT NULL,
  `is_active` tinyint NOT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(50) NOT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `create_by_idx` (`create_by`),
  KEY `update_by_fk_idx` (`update_by`),
  CONSTRAINT `create_by_fk` FOREIGN KEY (`create_by`) REFERENCES `user` (`email`),
  CONSTRAINT `update_by_fk` FOREIGN KEY (`update_by`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (3,1,'Which of these methods is used to implement the Runnable interface?',0,'2021-04-20 07:13:31',NULL,'admin@gmail.com',NULL),(4,1,'Which of these interfaces is implemented by the Thread class?',0,'2021-04-20 07:15:00',NULL,'admin@gmail.com',NULL),(5,1,'Which of these statement is incorrect?',1,'2021-04-20 07:16:25','2021-04-21 08:29:13','admin@gmail.com','admin@gmail.com'),(6,2,'updated content',0,'2021-04-20 07:18:00','2021-04-21 08:18:03','admin@gmail.com','admin@gmail.com'),(7,1,'Which of these method is used to explicitly set the priority of a thread?',1,'2021-04-20 07:18:49',NULL,'admin@gmail.com',NULL),(8,1,'What is synchronization in reference to a thread?',1,'2021-04-20 07:19:43',NULL,'admin@gmail.com',NULL),(9,1,'Statement object return SQL query result as ____ objects',1,'2021-04-20 07:21:45',NULL,'admin@gmail.com',NULL),(10,1,'JDBC supports ____ and____ models',1,'2021-04-20 07:23:34',NULL,'admin@gmail.com',NULL),(11,1,'With respect to networking and the client-sever model\r\n(1) A sever runs on a specific computer and has a socket that is bounds to a specific port number. the server just waits,.........\r\n(2) To connect to the server, the client must know the hostname or IP of the machine on which the server is running .......',1,'2021-04-20 07:24:29',NULL,'admin@gmail.com',NULL),(12,1,'Which of the following layout manager will present components with the same size?',1,'2021-04-20 07:26:25',NULL,'admin@gmail.com',NULL),(14,1,'To get metric data of a font, the class ___ should be used',1,'2021-04-20 07:27:52',NULL,'admin@gmail.com',NULL),(15,1,'How can you ensure that multithreaded code does not deadlock',1,'2021-04-20 07:28:41',NULL,'admin@gmail.com',NULL),(16,1,'The default layout manager of every JPanel',1,'2021-04-20 07:29:36',NULL,'admin@gmail.com',NULL),(17,1,'How do you prevent shared data from being computed in a multithreaded evironment?',1,'2021-04-20 07:30:23',NULL,'admin@gmail.com',NULL),(18,2,'Study the statements:\r\n1) URL rewriting may be used when a browser is disabled cookies.\r\n2) In URL encoding the session id is included as part of the URL\r\nWhich is the correct option ?',1,'2021-04-20 07:32:41',NULL,'admin@gmail.com',NULL),(19,2,'A JSP page will not have access to session implicit variable if.',1,'2021-04-20 07:38:22',NULL,'admin@gmail.com',NULL),(21,2,'HttpServletRequest.getSession() method returns a_____object.',1,'2021-04-20 07:39:46',NULL,'admin@gmail.com',NULL),(22,2,'Class HttpServlet defines the methods _____ and _______ to response to get and post request from a client.',1,'2021-04-20 07:41:22',NULL,'admin@gmail.com',NULL),(23,2,'Which of the elements defined within the taglib element of taglib descriptor file are required? Select one correct answer.',1,'2021-04-20 07:42:11',NULL,'admin@gmail.com',NULL),(24,2,'Which of the following method calls can be used to retrieve an object from the session that was stored using the name \"userid\"?',1,'2021-04-20 07:43:00',NULL,'admin@gmail.com',NULL),(25,2,'Which of the following statements are correct about HTTP Basic authentication mechanism?',1,'2021-04-20 07:43:36',NULL,'admin@gmail.com',NULL),(26,2,'Which is NOT true about stateless session beans?',1,'2021-04-20 07:44:23',NULL,'admin@gmail.com',NULL),(27,2,'JSP_let you insert arbitrary code into the servlet\'s JspService method (which is called by service).',1,'2021-04-20 07:45:18',NULL,'admin@gmail.com',NULL),(28,2,'Which component can use a container-managed entity manager with an extended persistent context?',1,'2021-04-20 07:45:52',NULL,'admin@gmail.com',NULL),(30,2,'Which of these is legal return types of the doEndTag method defined in a class that extends TagSupport class? Select one correct answer.',1,'2021-04-20 07:47:53',NULL,'admin@gmail.com',NULL),(31,2,'A developer must implement a \'shopping cart\" object for a web-based application. The shopping cart must be able to maintain the state of the cart but the state is not stored persistently. Which JEE (J2EE) tech?',1,'2021-04-20 07:52:02','2021-04-21 08:29:54','admin@gmail.com','admin@gmail.com'),(32,2,'Which is the correct sequence?',1,'2021-04-20 07:52:37',NULL,'admin@gmail.com',NULL),(33,2,'Which statement is true about the EJB 3.0 stateful session beans?',1,'2021-04-20 07:53:17',NULL,'admin@gmail.com',NULL),(34,2,'Which statement about an entity instance lifecycle is correct?',1,'2021-04-20 08:15:44',NULL,'admin@gmail.com',NULL),(36,3,'Which of special register contains the Mode Bit (user or kernel)?',1,'2021-04-20 08:18:49',NULL,'admin@gmail.com',NULL),(37,3,'Which of main bus in the IBM PC computer, that can run at 66 MHz and transfer 8 bytes at a time?',1,'2021-04-20 08:19:34',NULL,'admin@gmail.com',NULL),(38,3,'Booting a general purpose computer involves the following steps except',1,'2021-04-20 08:20:12',NULL,'admin@gmail.com',NULL),(39,3,'Which of the following statements about Random Access memory (RAM) is correct?',1,'2021-04-20 08:20:49',NULL,'admin@gmail.com',NULL),(40,3,'Which of the following statements is incorrect about the CMOS?',1,'2021-04-20 08:21:44',NULL,'admin@gmail.com',NULL),(41,3,'Which is not an example of a resource that is commonly time-multiplexed?',1,'2021-04-20 08:22:20',NULL,'admin@gmail.com',NULL),(42,3,'A well-known Embedded operating system is:',1,'2021-04-20 08:23:13',NULL,'admin@gmail.com',NULL),(43,3,'A(n) _________ is provided to make system calls from some programming languages',1,'2021-04-20 08:23:52',NULL,'admin@gmail.com',NULL),(44,3,'The major operating system services provide mechanisms for secure and efficient are',1,'2021-04-20 08:24:27',NULL,'admin@gmail.com',NULL),(45,3,'Which of the following is correct about the advantages of layered system?',1,'2021-04-20 08:25:07',NULL,'admin@gmail.com',NULL),(46,3,'OS Win32 use system call_____, while OS Unix use system call______ to create a new process',1,'2021-04-20 08:26:11',NULL,'admin@gmail.com',NULL),(47,3,'Which of the following process state transitions is illegal?',1,'2021-04-20 08:26:48',NULL,'admin@gmail.com',NULL),(48,3,'How many percent is CPU utilization, when a computer system has enough room to hold two program and these programs are idle waiting for I/O half the time?',1,'2021-04-20 08:27:18',NULL,'admin@gmail.com',NULL),(49,3,'An arrival message causes the system to create a new thread to handle this message. This new thread is call______',1,'2021-04-20 08:27:52',NULL,'admin@gmail.com',NULL),(50,1,'PRJ311 is the subject code for?',1,'2021-04-22 17:58:50','2021-04-22 18:01:53','admin@gmail.com','admin@gmail.com'),(51,2,'Choose C',1,'2021-04-22 21:38:29',NULL,'admin@gmail.com',NULL),(52,2,'Choose A',1,'2021-04-22 21:38:51',NULL,'admin@gmail.com',NULL),(53,3,'Choose B update',1,'2021-04-22 21:39:17','2021-04-22 21:40:36','admin@gmail.com','admin@gmail.com');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz` (
  `quiz_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `score` double DEFAULT NULL,
  `is_active` tinyint NOT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `quiz_meta_id` int NOT NULL,
  PRIMARY KEY (`quiz_id`),
  UNIQUE KEY `quiz_id_UNIQUE` (`quiz_id`),
  KEY `quiz_user_fk_idx` (`email`),
  KEY `quiz_meta_fk_idx` (`quiz_meta_id`),
  CONSTRAINT `quiz_meta_fk` FOREIGN KEY (`quiz_meta_id`) REFERENCES `quiz_meta` (`quiz_meta_id`),
  CONSTRAINT `quiz_user_fk` FOREIGN KEY (`email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (54,'emailtest@gmail.com',0,1,'2021-04-22 21:18:10','2021-04-22 21:18:52',1),(55,'emailtest@gmail.com',2,1,'2021-04-22 21:19:35','2021-04-22 21:20:08',1),(56,'emailtest@gmail.com',3,1,'2021-04-22 21:20:29','2021-04-22 21:21:20',3),(57,'emailtest@gmail.com',1,1,'2021-04-22 21:22:54','2021-04-22 21:22:59',1),(58,'emailtest@gmail.com',6,1,'2021-04-22 21:24:20','2021-04-22 21:25:48',1),(59,'emailtest@gmail.com',8,1,'2021-04-22 21:26:31','2021-04-22 21:27:28',1),(60,'emailtest@gmail.com',10,1,'2021-04-22 21:28:07','2021-04-22 21:28:45',1),(61,'emailtest@gmail.com',5,1,'2021-04-22 21:28:50','2021-04-22 21:29:11',1),(62,'emailtest@gmail.com',9,1,'2021-04-22 21:30:07','2021-04-22 21:30:33',2),(63,'phuongansone@gmail.com',8,1,'2021-04-22 21:32:03','2021-04-22 21:32:30',2),(64,'phuongansone@gmail.com',10,1,'2021-04-22 21:32:50','2021-04-22 21:33:35',2),(65,'phuongansone@gmail.com',7,1,'2021-04-22 21:33:53','2021-04-22 21:34:25',2),(66,'phuongansone@gmail.com',7,1,'2021-04-22 21:34:30','2021-04-22 21:34:59',2),(67,'phuongansone@gmail.com',9,1,'2021-04-22 21:35:05','2021-04-22 21:35:30',2),(68,'phuongansone@gmail.com',0,1,'2021-04-22 21:35:40','2021-04-22 21:35:41',2),(69,'phuongansone@gmail.com',7,1,'2021-04-22 21:36:08','2021-04-22 21:36:38',1),(70,'phuongansone@gmail.com',4,1,'2021-04-22 21:36:44','2021-04-22 21:36:57',3),(71,'phuongansone@gmail.com',0,1,'2021-04-22 21:41:17','2021-04-22 21:41:19',1),(72,'phuongansone@gmail.com',1,1,'2021-04-22 21:41:23','2021-04-22 21:41:47',1);
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_meta`
--

DROP TABLE IF EXISTS `quiz_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_meta` (
  `quiz_meta_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `title` varchar(100) NOT NULL,
  `is_active` tinyint NOT NULL,
  `question_no` int DEFAULT NULL,
  `duration` int NOT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`quiz_meta_id`),
  KEY `subject_fk_idx` (`subject_id`),
  CONSTRAINT `subject_fk` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_meta`
--

LOCK TABLES `quiz_meta` WRITE;
/*!40000 ALTER TABLE `quiz_meta` DISABLE KEYS */;
INSERT INTO `quiz_meta` VALUES (1,1,'Quiz lesson 1',1,10,10,'2021-04-21 10:21:51',NULL),(2,2,'Quiz 1',1,10,10,'2021-04-21 10:21:51',NULL),(3,3,'Quiz practice',1,10,10,'2021-04-21 10:22:07',NULL);
/*!40000 ALTER TABLE `quiz_meta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_question`
--

DROP TABLE IF EXISTS `quiz_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_question` (
  `quiz_question_id` int NOT NULL AUTO_INCREMENT,
  `quiz_id` int NOT NULL,
  `question_id` int NOT NULL,
  `answer_id` int NOT NULL,
  `is_correct` varchar(45) NOT NULL,
  `score` double NOT NULL,
  `answer_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`quiz_question_id`),
  KEY `quiz_fk_idx` (`quiz_id`),
  KEY `question_fk_idx` (`question_id`),
  CONSTRAINT `question_fk` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`),
  CONSTRAINT `quiz_fk` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=434 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_question`
--

LOCK TABLES `quiz_question` WRITE;
/*!40000 ALTER TABLE `quiz_question` DISABLE KEYS */;
INSERT INTO `quiz_question` VALUES (244,54,7,22,'0',0,'2021-04-22 21:18:52'),(245,54,15,51,'0',0,'2021-04-22 21:18:52'),(246,54,17,59,'0',0,'2021-04-22 21:18:52'),(247,54,5,14,'0',0,'2021-04-22 21:18:52'),(248,54,10,36,'0',0,'2021-04-22 21:18:52'),(249,54,9,30,'0',0,'2021-04-22 21:18:52'),(250,54,50,183,'0',0,'2021-04-22 21:18:52'),(251,54,8,28,'0',0,'2021-04-22 21:18:52'),(252,54,11,38,'0',0,'2021-04-22 21:18:52'),(253,54,14,47,'0',0,'2021-04-22 21:18:52'),(254,55,17,58,'1',1,'2021-04-22 21:20:08'),(255,55,15,50,'0',0,'2021-04-22 21:20:08'),(256,55,8,26,'0',0,'2021-04-22 21:20:08'),(257,55,7,22,'0',0,'2021-04-22 21:20:08'),(258,55,5,14,'0',0,'2021-04-22 21:20:08'),(259,55,9,30,'0',0,'2021-04-22 21:20:08'),(260,55,14,46,'0',0,'2021-04-22 21:20:08'),(261,55,50,182,'1',1,'2021-04-22 21:20:08'),(262,55,16,54,'0',0,'2021-04-22 21:20:08'),(263,55,12,42,'0',0,'2021-04-22 21:20:08'),(264,56,49,178,'1',1,'2021-04-22 21:21:20'),(265,56,41,147,'0',0,'2021-04-22 21:21:20'),(266,56,42,151,'1',1,'2021-04-22 21:21:20'),(267,56,43,155,'0',0,'2021-04-22 21:21:20'),(268,56,48,175,'0',0,'2021-04-22 21:21:20'),(269,56,45,164,'1',1,'2021-04-22 21:21:20'),(270,56,39,138,'0',0,'2021-04-22 21:21:20'),(271,56,44,159,'0',0,'2021-04-22 21:21:20'),(272,56,46,169,'0',0,'2021-04-22 21:21:20'),(273,56,47,171,'0',0,'2021-04-22 21:21:20'),(274,57,17,58,'1',1,'2021-04-22 21:22:59'),(275,57,14,48,'0',0,'2021-04-22 21:22:59'),(276,57,12,-1,'0',0,'2021-04-22 21:22:59'),(277,57,8,-1,'0',0,'2021-04-22 21:22:59'),(278,57,11,-1,'0',0,'2021-04-22 21:22:59'),(279,57,15,-1,'0',0,'2021-04-22 21:22:59'),(280,57,16,-1,'0',0,'2021-04-22 21:22:59'),(281,57,9,-1,'0',0,'2021-04-22 21:22:59'),(282,57,5,-1,'0',0,'2021-04-22 21:22:59'),(283,57,7,-1,'0',0,'2021-04-22 21:22:59'),(284,58,12,43,'1',1,'2021-04-22 21:25:48'),(285,58,10,36,'0',0,'2021-04-22 21:25:48'),(286,58,8,27,'1',1,'2021-04-22 21:25:48'),(287,58,7,23,'0',0,'2021-04-22 21:25:48'),(288,58,17,58,'1',1,'2021-04-22 21:25:48'),(289,58,15,51,'0',0,'2021-04-22 21:25:48'),(290,58,50,182,'1',1,'2021-04-22 21:25:48'),(291,58,16,55,'1',1,'2021-04-22 21:25:48'),(292,58,11,38,'0',0,'2021-04-22 21:25:48'),(293,58,9,31,'1',1,'2021-04-22 21:25:48'),(294,59,5,14,'0',0,'2021-04-22 21:27:28'),(295,59,50,-1,'0',0,'2021-04-22 21:27:28'),(296,59,8,27,'1',1,'2021-04-22 21:27:28'),(297,59,12,43,'1',1,'2021-04-22 21:27:28'),(298,59,14,49,'1',1,'2021-04-22 21:27:28'),(299,59,17,58,'1',1,'2021-04-22 21:27:28'),(300,59,16,55,'1',1,'2021-04-22 21:27:28'),(301,59,11,39,'1',1,'2021-04-22 21:27:28'),(302,59,9,31,'1',1,'2021-04-22 21:27:28'),(303,59,10,37,'1',1,'2021-04-22 21:27:28'),(304,60,15,52,'1',1,'2021-04-22 21:28:45'),(305,60,7,24,'1',1,'2021-04-22 21:28:45'),(306,60,9,31,'1',1,'2021-04-22 21:28:45'),(307,60,14,49,'1',1,'2021-04-22 21:28:45'),(308,60,11,39,'1',1,'2021-04-22 21:28:45'),(309,60,5,17,'1',1,'2021-04-22 21:28:45'),(310,60,8,27,'1',1,'2021-04-22 21:28:45'),(311,60,10,37,'1',1,'2021-04-22 21:28:45'),(312,60,12,43,'1',1,'2021-04-22 21:28:45'),(313,60,16,55,'1',1,'2021-04-22 21:28:45'),(314,61,7,23,'0',0,'2021-04-22 21:29:11'),(315,61,50,182,'1',1,'2021-04-22 21:29:11'),(316,61,11,-1,'0',0,'2021-04-22 21:29:11'),(317,61,8,27,'1',1,'2021-04-22 21:29:11'),(318,61,12,-1,'0',0,'2021-04-22 21:29:11'),(319,61,14,49,'1',1,'2021-04-22 21:29:11'),(320,61,16,-1,'0',0,'2021-04-22 21:29:11'),(321,61,17,58,'1',1,'2021-04-22 21:29:11'),(322,61,10,-1,'0',0,'2021-04-22 21:29:11'),(323,61,5,17,'1',1,'2021-04-22 21:29:11'),(324,62,34,120,'1',1,'2021-04-22 21:30:33'),(325,62,21,73,'1',1,'2021-04-22 21:30:33'),(326,62,18,64,'1',1,'2021-04-22 21:30:33'),(327,62,23,80,'1',1,'2021-04-22 21:30:33'),(328,62,26,90,'1',1,'2021-04-22 21:30:33'),(329,62,19,67,'0',0,'2021-04-22 21:30:33'),(330,62,27,94,'1',1,'2021-04-22 21:30:33'),(331,62,22,75,'1',1,'2021-04-22 21:30:33'),(332,62,31,108,'1',1,'2021-04-22 21:30:33'),(333,62,25,88,'1',1,'2021-04-22 21:30:33'),(334,63,24,84,'1',1,'2021-04-22 21:32:30'),(335,63,31,108,'1',1,'2021-04-22 21:32:30'),(336,63,25,88,'1',1,'2021-04-22 21:32:30'),(337,63,33,116,'1',1,'2021-04-22 21:32:30'),(338,63,18,64,'1',1,'2021-04-22 21:32:30'),(339,63,32,111,'1',1,'2021-04-22 21:32:30'),(340,63,19,69,'1',1,'2021-04-22 21:32:30'),(341,63,23,79,'0',0,'2021-04-22 21:32:30'),(342,63,21,73,'1',1,'2021-04-22 21:32:30'),(343,63,22,-1,'0',0,'2021-04-22 21:32:30'),(344,64,33,116,'1',1,'2021-04-22 21:33:35'),(345,64,30,102,'1',1,'2021-04-22 21:33:35'),(346,64,31,108,'1',1,'2021-04-22 21:33:35'),(347,64,28,100,'1',1,'2021-04-22 21:33:35'),(348,64,34,120,'1',1,'2021-04-22 21:33:35'),(349,64,27,94,'1',1,'2021-04-22 21:33:35'),(350,64,32,111,'1',1,'2021-04-22 21:33:35'),(351,64,26,90,'1',1,'2021-04-22 21:33:35'),(352,64,23,80,'1',1,'2021-04-22 21:33:35'),(353,64,19,69,'1',1,'2021-04-22 21:33:35'),(354,65,19,69,'1',1,'2021-04-22 21:34:25'),(355,65,26,91,'0',0,'2021-04-22 21:34:25'),(356,65,31,107,'0',0,'2021-04-22 21:34:25'),(357,65,22,75,'1',1,'2021-04-22 21:34:25'),(358,65,34,120,'1',1,'2021-04-22 21:34:26'),(359,65,27,94,'1',1,'2021-04-22 21:34:26'),(360,65,25,88,'1',1,'2021-04-22 21:34:26'),(361,65,32,111,'1',1,'2021-04-22 21:34:26'),(362,65,24,84,'1',1,'2021-04-22 21:34:26'),(363,65,33,115,'0',0,'2021-04-22 21:34:26'),(364,66,23,78,'0',0,'2021-04-22 21:34:59'),(365,66,30,102,'1',1,'2021-04-22 21:34:59'),(366,66,32,111,'1',1,'2021-04-22 21:34:59'),(367,66,34,120,'1',1,'2021-04-22 21:34:59'),(368,66,22,75,'1',1,'2021-04-22 21:34:59'),(369,66,26,-1,'0',0,'2021-04-22 21:34:59'),(370,66,19,67,'0',0,'2021-04-22 21:34:59'),(371,66,24,84,'1',1,'2021-04-22 21:34:59'),(372,66,28,100,'1',1,'2021-04-22 21:34:59'),(373,66,18,64,'1',1,'2021-04-22 21:34:59'),(374,67,21,73,'1',1,'2021-04-22 21:35:30'),(375,67,28,-1,'0',0,'2021-04-22 21:35:30'),(376,67,25,88,'1',1,'2021-04-22 21:35:30'),(377,67,24,84,'1',1,'2021-04-22 21:35:30'),(378,67,22,75,'1',1,'2021-04-22 21:35:30'),(379,67,26,90,'1',1,'2021-04-22 21:35:30'),(380,67,27,94,'1',1,'2021-04-22 21:35:30'),(381,67,23,80,'1',1,'2021-04-22 21:35:30'),(382,67,34,120,'1',1,'2021-04-22 21:35:30'),(383,67,19,69,'1',1,'2021-04-22 21:35:30'),(384,68,26,-1,'0',0,'2021-04-22 21:35:41'),(385,68,22,-1,'0',0,'2021-04-22 21:35:41'),(386,68,24,-1,'0',0,'2021-04-22 21:35:41'),(387,68,31,-1,'0',0,'2021-04-22 21:35:41'),(388,68,30,-1,'0',0,'2021-04-22 21:35:41'),(389,68,21,-1,'0',0,'2021-04-22 21:35:41'),(390,68,33,-1,'0',0,'2021-04-22 21:35:41'),(391,68,32,-1,'0',0,'2021-04-22 21:35:41'),(392,68,28,-1,'0',0,'2021-04-22 21:35:41'),(393,68,23,-1,'0',0,'2021-04-22 21:35:41'),(394,69,14,47,'0',0,'2021-04-22 21:36:38'),(395,69,11,39,'1',1,'2021-04-22 21:36:38'),(396,69,8,27,'1',1,'2021-04-22 21:36:38'),(397,69,50,182,'1',1,'2021-04-22 21:36:38'),(398,69,7,24,'1',1,'2021-04-22 21:36:38'),(399,69,10,37,'1',1,'2021-04-22 21:36:38'),(400,69,16,-1,'0',0,'2021-04-22 21:36:38'),(401,69,15,52,'1',1,'2021-04-22 21:36:38'),(402,69,5,-1,'0',0,'2021-04-22 21:36:38'),(403,69,17,58,'1',1,'2021-04-22 21:36:38'),(404,70,43,154,'1',1,'2021-04-22 21:36:57'),(405,70,48,176,'1',1,'2021-04-22 21:36:57'),(406,70,45,164,'1',1,'2021-04-22 21:36:57'),(407,70,47,172,'1',1,'2021-04-22 21:36:57'),(408,70,40,143,'0',0,'2021-04-22 21:36:57'),(409,70,36,-1,'0',0,'2021-04-22 21:36:57'),(410,70,42,-1,'0',0,'2021-04-22 21:36:57'),(411,70,41,-1,'0',0,'2021-04-22 21:36:57'),(412,70,39,-1,'0',0,'2021-04-22 21:36:57'),(413,70,49,-1,'0',0,'2021-04-22 21:36:57'),(414,71,8,-1,'0',0,'2021-04-22 21:41:19'),(415,71,50,-1,'0',0,'2021-04-22 21:41:19'),(416,71,16,-1,'0',0,'2021-04-22 21:41:19'),(417,71,9,-1,'0',0,'2021-04-22 21:41:19'),(418,71,15,-1,'0',0,'2021-04-22 21:41:19'),(419,71,7,-1,'0',0,'2021-04-22 21:41:19'),(420,71,17,-1,'0',0,'2021-04-22 21:41:19'),(421,71,5,-1,'0',0,'2021-04-22 21:41:19'),(422,71,10,-1,'0',0,'2021-04-22 21:41:19'),(423,71,12,-1,'0',0,'2021-04-22 21:41:19'),(424,72,9,30,'0',0,'2021-04-22 21:41:47'),(425,72,7,22,'0',0,'2021-04-22 21:41:47'),(426,72,12,42,'0',0,'2021-04-22 21:41:47'),(427,72,16,54,'0',0,'2021-04-22 21:41:47'),(428,72,8,26,'0',0,'2021-04-22 21:41:47'),(429,72,11,38,'0',0,'2021-04-22 21:41:47'),(430,72,5,14,'0',0,'2021-04-22 21:41:47'),(431,72,17,58,'1',1,'2021-04-22 21:41:47'),(432,72,10,34,'0',0,'2021-04-22 21:41:47'),(433,72,15,50,'0',0,'2021-04-22 21:41:47');
/*!40000 ALTER TABLE `quiz_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Student'),(2,'Admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'New'),(2,'Deactivated');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) NOT NULL,
  `is_active` tinyint NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'PRJ311 - Java Desktop',1),(2,'PRJ321 - Java Web',1),(3,'OSG202 - Operating System',1);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `role_id` int NOT NULL,
  `status_id` int NOT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `user_role_idx` (`role_id`),
  KEY `user_status_fk_idx` (`status_id`),
  CONSTRAINT `user_role_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_status_fk` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('abc@gmail.com','123456','ABC',1,1,'2021-04-19 05:03:43'),('admin@gmail.com','dcc230acec699b5c5cbb4d5a0cbbfe051863fa4a2fbc746e2470419e78beb5bf','Phương An',2,1,'2021-04-19 05:07:07'),('andtp21@gmail.com','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','An Dao',1,1,'2021-04-18 00:18:01'),('demo','demo','demo',1,1,'2021-04-19 07:49:03'),('email@gmail.com','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','Phương An',1,1,'2021-04-19 05:06:27'),('emailtest@gmail.com','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','Email Test',1,1,'2021-04-22 21:16:59'),('phuongansone@gmail.com','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','Phuong An',1,1,'2021-04-18 00:26:55'),('testinguser@gmail.com','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','test user',1,1,'2021-04-22 17:47:50'),('user@email.com','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','user',1,1,'2021-04-22 17:44:04');
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

-- Dump completed on 2021-04-22 21:44:14
