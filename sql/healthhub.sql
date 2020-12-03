-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: healthhub
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id` varchar(5) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `latitude` varchar(25) DEFAULT NULL,
  `longitude` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES ('d1','Princess Dance',601,'0001.png',' This is a dummy description for Doctor 1','Cardiologist','3416013355','North Evans','14112','42.691742','-78.992658'),('d2','Tamar Biles',647,'0002.png',' This is a dummy description for Doctor 2','Cardiologist','3796472917','Boise','83744','43.459855','-116.243984'),('d3','Tyisha Yerby',700,'0003.png',' This is a dummy description for Doctor 3','Cardiologist','3067009767','Palomar Mountain','92060','33.308217','-116.8471'),('d4','Valentine Clevenger',607,'0004.png',' This is a dummy description for Doctor 4','Cardiologist','3866077559','Kansas City','64944','39.035038','-94.356728'),('d5','Patti Shoultz',632,'0005.png',' This is a dummy description for Doctor 5','Endocrinologist','3106322868','Rancho Santa Fe','92067','33.016492','-117.20264'),('d6','Stephanie Ahumada',633,'0006.png',' This is a dummy description for Doctor 6','Endocrinologist','3566332470','Parsons','26287','39.141165','-79.67466'),('d7','Hong Dudas',649,'0007.png',' This is a dummy description for Doctor 7','Endocrinologist','3596496751','Killingworth','6419','41.380594','-72.57637'),('d8','Bryanna Wheat',688,'0008.png',' This is a dummy description for Doctor 8','Endocrinologist','3106889268','Parsons','26287','39.141165','-79.67466'),('d9','Lynsey Melito',623,'0009.png',' This is a dummy description for Doctor 9','Endocrinologist','3906232787','Philadelphia','19148','39.919812','-75.15803'),('d10','Stephane Capshaw',655,'00010.png',' This is a dummy description for Doctor 10','Dentist','3266554919','Oklahoma City','73152','35.551409','-97.407537'),('d11','Zetta Glascock',669,'00011.png',' This is a dummy description for Doctor 11','Dentist','3256695806','Pricedale','15072','40.13848','-79.85575'),('d12','Hunter Moctezuma',678,'00012.png',' This is a dummy description for Doctor 12','Dentist','3396781177','Sherman Oaks','91413','33.786594','-118.298662'),('d13','Eliza Federico',637,'00013.png',' This is a dummy description for Doctor 13','Dentist','3576376518','Oklahoma City','73152','35.551409','-97.407537'),('d14','Pasquale Spilman',683,'00014.png',' This is a dummy description for Doctor 14','Dentist','3096836991','Eudora','66025','38.917032','-95.06455'),('d15','Krystle Wyche',604,'00015.png',' This is a dummy description for Doctor 15','Physician','3866043227','Eudora','66025','38.917032','-95.06455'),('d16','Leonora Choiniere',622,'00016.png',' This is a dummy description for Doctor 16','Physician','3086228105','Oklahoma City','73152','35.551409','-97.407537'),('d17','Reginald Kneip',602,'00017.png',' This is a dummy description for Doctor 17','Physician','3956026154','Durham','3824','43.128085','-70.96035'),('d18','Sudie Steffy',690,'00018.png',' This is a dummy description for Doctor 18','Physician','4006901259','Rancho Santa Fe','92067','33.016492','-117.20264'),('d19','Samatha Gardner',663,'00019.png',' This is a dummy description for Doctor 19','Physician','3366637953','Oklahoma City','73152','35.551409','-97.407537'),('d20','Barb Wold',692,'00020.png',' This is a dummy description for Doctor 20','Dermatologist','3086925703','Philadelphia','19132','39.995412','-75.16977'),('d21','Monet Tietjen',678,'00021.png',' This is a dummy description for Doctor 21','Dermatologist','3426786209','San Diego','92119','32.80225','-117.02431'),('d22','Hilaria Mcquade',698,'00022.png',' This is a dummy description for Doctor 22','Dermatologist','3096983965','Rehobeth','21857','38.092718','-75.888207'),('d23','Reggie Jhonson',692,'00023.png',' This is a dummy description for Doctor 23','Dermatologist','3066924009','Rancho Santa Fe','92067','33.016492','-117.20264'),('d24','Fonda Sharon',688,'00024.png',' This is a dummy description for Doctor 24','Dermatologist','3896889046','North Evans','14112','42.691742','-78.992658'),('d25','Kali Morado',673,'00025.png',' This is a dummy description for Doctor 25','Surgeon','3906736891','Idaho Falls','83402','43.497685','-112.07391'),('d26','Celeste Woolverton',669,'00026.png',' This is a dummy description for Doctor 26','Surgeon','3436697509','Oklahoma City','73152','35.551409','-97.407537'),('d27','Tonette Gowin',642,'00027.png',' This is a dummy description for Doctor 27','Surgeon','3406429733','Parsons','26287','39.141165','-79.67466'),('d28','Connie Lisi',641,'00028.png',' This is a dummy description for Doctor 28','Surgeon','3306417135','Savanna','74565','34.831398','-95.83967'),('d29','Dorine Bloomquist',651,'00029.png',' This is a dummy description for Doctor 29','Surgeon','3506515413','Rehobeth','21857','38.092718','-75.888207'),('d30','Garrett Rolen',613,'00030.png',' This is a dummy description for Doctor 30','Allergist','3846136091','Durham','3824','43.128085','-70.96035'),('d31','Tanika Wickman',635,'00031.png',' This is a dummy description for Doctor 31','Allergist','3756354289','Eudora','66025','38.917032','-95.06455'),('d32','Modesta Anspach',632,'00032.png',' This is a dummy description for Doctor 32','Allergist','3486328811','Lake Forest','92630','33.640223','-117.69108'),('d33','Audra Niver',686,'00033.png',' This is a dummy description for Doctor 33','Allergist','3766861832','Marked Tree','72345','35.531429','-90.414113'),('d34','Rubi Dallas',643,'00034.png',' This is a dummy description for Doctor 34','Allergist','3156439014','San Diego','92187','33.016928','-116.846046'),('d35','Georgie Rippel',612,'00035.png',' This is a dummy description for Doctor 35','Anesthesiologist','3966124963','Middletown Springs','5757','43.477827','-73.12311'),('d36','Wava Dade',602,'00036.png',' This is a dummy description for Doctor 36','Anesthesiologist','3516026573','Philadelphia','19132','39.995412','-75.16977'),('d37','Preston Schlenker',605,'00037.png',' This is a dummy description for Doctor 37','Anesthesiologist','3476054928','Denton','66017','39.720911','-95.27417'),('d38','Weston Agena',637,'00038.png',' This is a dummy description for Doctor 38','Anesthesiologist','3486371150','New Kensington','15068','40.571108','-79.74226'),('d39','Nolan Okeefe',696,'00039.png',' This is a dummy description for Doctor 39','Anesthesiologist','3866962751','Prospect','23960','37.310203','-78.55359'),('d40','Kylie Gafford',685,'00040.png',' This is a dummy description for Doctor 40','Physiotherapist','3436856815','Huntington Beach','92647','33.725167','-118.00509');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-02 20:22:40
