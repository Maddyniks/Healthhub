-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
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
-- Table structure for table `doctorappointments`
--

DROP TABLE IF EXISTS `doctorappointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctorappointments` (
  `transactionID` varchar(11) DEFAULT NULL,
  `userID` varchar(20) NOT NULL,
  `userName` varchar(40) NOT NULL,
  `doctorID` varchar(5) NOT NULL,
  `doctorName` varchar(40) NOT NULL,
  `doctorPrice` double DEFAULT NULL,
  `doctorCategory` varchar(30) NOT NULL,
  `doctorCity` varchar(30) NOT NULL,
  `doctorZip` varchar(10) NOT NULL,
  `doctorLat` varchar(25) NOT NULL,
  `doctorLon` varchar(25) NOT NULL,
  `appointmentDate` varchar(15) NOT NULL,
  `appointmentTime` varchar(15) NOT NULL,
  `appointmentDesc` varchar(100) NOT NULL,
  `currentStatus` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctorappointments`
--

LOCK TABLES `doctorappointments` WRITE;
/*!40000 ALTER TABLE `doctorappointments` DISABLE KEYS */;
INSERT INTO `doctorappointments` VALUES ('424584','1602341465','chirag','d16','Leonora Choiniere',622,'Physician','Oklahoma City','73152','35.551409','-97.407537','2020-12-29','20:39','Cough and Cold','Pending'),('851111','1602341465','chirag','d12','Hunter Moctezuma',678,'Dentist','Sherman Oaks','91413','33.786594','-118.298662','2020-12-14','23:42','Root Canal','Pending'),('361090','1602465977','harsh','d32','Modesta Anspach',632,'Allergist','Lake Forest','92630','33.640223','-117.69108','2020-12-07','11:05','Dummy Data 1','Pending'),('361090','1602465977','harsh','d26','Celeste Woolverton',669,'Surgeon','Oklahoma City','73152','35.551409','-97.407537','2020-12-10','12:06','Dummy data 2','Pending'),('950430','1602462193','nishant','d2','Tamar Biles',647,'Cardiologist','Boise','83744','43.459855','-116.243984','2020-12-07','14:46','heartache','Pending'),('297252','1602462193','nishant','d14','Pasquale Spilman',683,'Dentist','Eudora','66025','38.917032','-95.06455','2020-12-14','08:30','Toothache','Pending'),('647972','1602465967','ninad','d15','Krystle Wyche',604,'Physician','Eudora','66025','38.917032','-95.06455','2020-12-14','11:49','Cough','Pending'),('734758','1602465967','ninad','d11','Zetta Glascock',669,'Dentist','Pricedale','15072','40.13848','-79.85575','2020-12-21','12:30','Root Canal','Pending'),('450957','1602465951','satyaveer','d19','Samatha Gardner',663,'Physician','Oklahoma City','73152','35.551409','-97.407537','2021-01-20','17:30','Cough and cold','Pending'),('333299','1602465951','satyaveer','d31','Tanika Wickman',635,'Allergist','Eudora','66025','38.917032','-95.06455','2021-02-10','17:45','Skin Treatment','Pending'),('132432','1602465989','mounin','d5','Patti Shoultz',632,'Endocrinologist','Rancho Santa Fe','92067','33.016492','-117.20264','2021-02-10','14:45','Metabolism','Pending'),('952348','1602465989','mounin','d13','Eliza Federico',637,'Dentist','Oklahoma City','73152','35.551409','-97.407537','2021-02-23','14:30','Teeth Whitening','Pending'),('421344','1602465989','mounin','d30','Garrett Rolen',613,'Allergist','Durham','3824','43.128085','-70.96035','2021-02-16','00:50','skin treatment','Pending'),('256111','1602466011','shloka','d6','Stephanie Ahumada',633,'Endocrinologist','Parsons','26287','39.141165','-79.67466','2021-01-12','15:30','Respirtion Problem','Pending'),('239364','1602466011','shloka','d11','Zetta Glascock',669,'Dentist','Pricedale','15072','40.13848','-79.85575','2021-02-09','10:00','Braces','Pending'),('466824','1602466033','omar','d20','Barb Wold',692,'Dermatologist','Philadelphia','19132','39.995412','-75.16977','2021-02-09','16:00','Laser Therapy','Pending'),('333933','1602466033','omar','d28','Connie Lisi',641,'Surgeon','Savanna','74565','34.831398','-95.83967','2021-02-04','08:00','Heart Surgery','Pending'),('642145','1602465977','harsh','d10','Stephane Capshaw',655,'Dentist','Oklahoma City','73152','35.551409','-97.407537','2020-12-22','15:38','Inquiry','Pending'),('753233','1602465977','harsh','d4','Valentine Clevenger',607,'Cardiologist','Kansas City','64944','39.035038','-94.356728','2020-12-08','10:44','Operation','Pending'),('662918','1602465977','harsh','d16','Leonora Choiniere',622,'Physician','Oklahoma City','73152','35.551409','-97.407537','2020-12-06','10:00','Cough and Cold','Pending');
/*!40000 ALTER TABLE `doctorappointments` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance` (
  `id` varchar(5) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `subcategory` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(15) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` varchar(30) DEFAULT NULL,
  `emailId` varchar(40) DEFAULT NULL,
  `deductables` double DEFAULT NULL,
  `totalcoverage` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` VALUES ('I00','United Health Dental Insurance Plan 1','United Health','Dental',905,'00000.png','This is a dummy description for Dental Insurance provided by United Health','1year','support0@unitedhealth.com',755,13575),('I01','United Health Vision Insurance Plan 2','United Health','Vision',4635,'00001.png','This is a dummy description for Vision Insurance provided by United Health','5year','support0@unitedhealth.com',688,69525),('I02','United Health Health Insurance Plan 3','United Health','Health',3476,'00002.png','This is a dummy description for Health Insurance provided by United Health','4year','support0@unitedhealth.com',812,52140),('I03','United Health Mental-Health Insurance Plan 4','United Health','Mental-Health',2270,'00003.png','This is a dummy description for Mental-Health Insurance provided by United Health','2year','support0@unitedhealth.com',635,34050),('I04','United Health Crtical-Illness Insurance Plan 5','United Health','Crtical-Illness',3009,'00004.png','This is a dummy description for Crtical-Illness Insurance provided by United Health','3year','support0@unitedhealth.com',686,45135),('I10','Aetna Health Dental Insurance Plan 1','Aetna Health','Dental',2192,'00010.png','This is a dummy description for Dental Insurance provided by Aetna Health','2year','support1@aetnahealth.com',801,32880),('I11','Aetna Health Vision Insurance Plan 2','Aetna Health','Vision',4780,'00011.png','This is a dummy description for Vision Insurance provided by Aetna Health','5year','support1@aetnahealth.com',896,71700),('I12','Aetna Health Health Insurance Plan 3','Aetna Health','Health',4488,'00012.png','This is a dummy description for Health Insurance provided by Aetna Health','4year','support1@aetnahealth.com',878,67320),('I13','Aetna Health Mental-Health Insurance Plan 4','Aetna Health','Mental-Health',3066,'00013.png','This is a dummy description for Mental-Health Insurance provided by Aetna Health','3year','support1@aetnahealth.com',648,45990),('I14','Aetna Health Crtical-Illness Insurance Plan 5','Aetna Health','Crtical-Illness',5310,'00014.png','This is a dummy description for Crtical-Illness Insurance provided by Aetna Health','5year','support1@aetnahealth.com',677,79650),('I20','Kaiser Foundation Dental Insurance Plan 1','Kaiser Foundation','Dental',5460,'00020.png','This is a dummy description for Dental Insurance provided by Kaiser Foundation','5year','support2@kaiserfo.com',614,81900),('I21','Kaiser Foundation Vision Insurance Plan 2','Kaiser Foundation','Vision',3243,'00021.png','This is a dummy description for Vision Insurance provided by Kaiser Foundation','3year','support2@kaiserfo.com',680,48645),('I22','Kaiser Foundation Health Insurance Plan 3','Kaiser Foundation','Health',4800,'00022.png','This is a dummy description for Health Insurance provided by Kaiser Foundation','4year','support2@kaiserfo.com',651,72000),('I23','Kaiser Foundation Mental-Health Insurance Plan 4','Kaiser Foundation','Mental-Health',1966,'00023.png','This is a dummy description for Mental-Health Insurance provided by Kaiser Foundation','2year','support2@kaiserfo.com',721,29490),('I24','Kaiser Foundation Crtical-Illness Insurance Plan 5','Kaiser Foundation','Crtical-Illness',2336,'00024.png','This is a dummy description for Crtical-Illness Insurance provided by Kaiser Foundation','2year','support2@kaiserfo.com',734,35040);
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurancetransaction`
--

DROP TABLE IF EXISTS `insurancetransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurancetransaction` (
  `transactionID` varchar(11) DEFAULT NULL,
  `userID` varchar(20) NOT NULL,
  `userName` varchar(40) NOT NULL,
  `insuranceID` varchar(5) NOT NULL,
  `insuranceName` varchar(40) NOT NULL,
  `insuranceCategory` varchar(30) NOT NULL,
  `insuranceSubCategory` varchar(30) NOT NULL,
  `insurancePrice` double NOT NULL,
  `insuranceDuration` varchar(30) NOT NULL,
  `deductables` double NOT NULL,
  `totalcoverage` double NOT NULL,
  `email` varchar(25) NOT NULL,
  `phName` varchar(35) NOT NULL,
  `phAge` varchar(3) NOT NULL,
  `phAddress1` varchar(55) NOT NULL,
  `phAddress2` varchar(55) NOT NULL,
  `phCity` varchar(25) NOT NULL,
  `phZIP` varchar(10) NOT NULL,
  `phPhone` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurancetransaction`
--

LOCK TABLES `insurancetransaction` WRITE;
/*!40000 ALTER TABLE `insurancetransaction` DISABLE KEYS */;
INSERT INTO `insurancetransaction` VALUES ('995872','1602465977','harsh','I00','United Health Dental Insurance Plan 1','United Health','Dental',905,'1year',755,13575,'harshvora242@gmail.com','Harsh','23','2740 S Prairie Avenue','215','Chicago','60616','3127925717'),('974003','1602465951','satyaveer','I11','Aetna Health Vision Insurance Plan 2','Aetna Health','Vision',4780,'5year',896,71700,'sathyaveer@gmail.com','Sathyaveer','24','2750 S Prairie Avenue','206','Chicago','64454','12321312123'),('796326','1602341465','chirag','I02','United Health Health Insurance Plan 3','United Health','Health',3476,'4year',812,52140,'chirag@gmail.com','Chira','23','2740 S Prairie Avenue','201','Chicago','60616','3127925717'),('823765','1602341465','chirag','I10','Aetna Health Dental Insurance Plan 1','Aetna Health','Dental',2192,'2year',801,32880,'chirag@gmail.com','Chirag','23','2740 S Prairie Avenue','201','Chicago','60616','3127925717'),('876913','1602465967','ninad','I11','Aetna Health Vision Insurance Plan 2','Aetna Health','Vision',4780,'5year',896,71700,'Ninad@gmail.com','Ninad','26','2750 S Prairie Avenue','211','Chicago','Illinois','31426624511'),('132142','1602465989','mounin','I10','Aetna Health Dental Insurance Plan 1','Aetna Health','Dental',2192,'2year',801,32880,'mounin@yahoo.in','Mounin','25','2740 S Prairie Avenue','201','Chicago','60616','3124566236'),('505646','1602465989','mounin','I10','Aetna Health Dental Insurance Plan 1','Aetna Health','Dental',2192,'2year',801,32880,'mounin@yahoo.com','Sathyaveer','25','2740 S Prairie Avenue','201','Chicago','60616','31256464652'),('592248','1602465920','akash','I02','United Health Health Insurance Plan 3','United Health','Health',3476,'4year',812,52140,'akash@yahoo.com','Aakash','25','500 E 33rd St','415','Chicago','61123','3145252143'),('301198','1602465931','dhiraj','I00','United Health Dental Insurance Plan 1','United Health','Dental',905,'1year',755,13575,'dhiraj@gmail.com','Dhiraj','25','500 e 33rd','251','Chicago','60616','3127925717'),('920625','1607188205','user1','I11','Aetna Health Vision Insurance Plan 2','Aetna Health','Vision',4780,'5year',896,71700,'user1@gmail.com','User1','24','2740 S Prairie Avenue','221','Chicago','60616','3127925717'),('322372','1607244287','saurabh','I00','United Health Dental Insurance Plan 1','United Health','Dental',905,'1year',755,13575,'saurabh@yahoo.in','Saurabh','24','b/7 om shyam sarjit mathuradas','road Kandivali west','MUMBAI','400067','08108728737'),('795628','1602466165','shivani','I11','Aetna Health Vision Insurance Plan 2','Aetna Health','Vision',4780,'5year',896,71700,'shivani@yahoo.com','Shivani','24','al karama','215','abu dhabi','60616','3127925766');
/*!40000 ALTER TABLE `insurancetransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy`
--

DROP TABLE IF EXISTS `pharmacy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy` (
  `id` varchar(5) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `image` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `emailId` varchar(40) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `latitude` varchar(25) DEFAULT NULL,
  `longitude` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy`
--

LOCK TABLES `pharmacy` WRITE;
/*!40000 ALTER TABLE `pharmacy` DISABLE KEYS */;
INSERT INTO `pharmacy` VALUES ('p1','Walgreens pharmacy','0001.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3046878372','info1@walgreens.com','Sidney Center','13839','42.236762','-75.25901'),('p2','Costco pharmacy','0002.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3036076441','info2@costcopharma.com','Caguas','00626','18.235003','-66.037318'),('p3','CVS pharmacy','0003.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3176404385','info3@cvshealth.com','Big Sioux','57949','42.505818','-96.499259'),('p4','Walgreens pharmacy','0004.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3466378753','info4@walgreens.com','Lawai','96765','21.930922','-159.499342'),('p5','Costco pharmacy','0005.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3056192990','info5@costcopharma.com','Whitefield','74472','35.259201','-95.24701'),('p6','CVS pharmacy','0006.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3006163400','info6@cvshealth.com','Atlanta','30378','33.844371','-84.47405'),('p7','Walgreens pharmacy','0007.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3806853106','info7@walgreens.com','Jacksonville','32255','30.287041','-81.389305'),('p8','Costco pharmacy','0008.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3426077034','info8@costcopharma.com','Winnebago','68071','42.232805','-96.48868'),('p9','CVS pharmacy','0009.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3716747380','info9@cvshealth.com','Bruno','68014','41.28216','-96.9594'),('p10','Walgreens pharmacy','00010.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3006165573','info10@walgreens.com','Stedman','28391','35.016373','-78.6941'),('p11','Costco pharmacy','00011.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3326349235','info11@costcopharma.com','Graham','73437','34.363418','-97.43017'),('p12','CVS pharmacy','00012.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3566435270','info12@cvshealth.com','Red Bluff','96080','40.183837','-122.24074'),('p13','Walgreens pharmacy','00013.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3766397763','info13@walgreens.com','Big Sioux','57949','42.505818','-96.499259'),('p14','Costco pharmacy','00014.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3186096036','info14@costcopharma.com','Crystal River','34429','28.872108','-82.5961'),('p15','CVS pharmacy','00015.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3266981861','info15@cvshealth.com','Charleston','25317','38.335647','-81.613794'),('p16','Walgreens pharmacy','00016.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3906032530','info16@walgreens.com','Richardson','75082','32.993405','-96.65901'),('p17','Costco pharmacy','00017.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3726717213','info17@costcopharma.com','Bedias','77831','30.74577','-95.91892'),('p18','CVS pharmacy','00018.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3136493772','info18@cvshealth.com','Casselberry','32730','28.653875','-81.34387'),('p19','Walgreens pharmacy','00019.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3346787029','info19@walgreens.com','Crawfordsville','97336','44.359301','-122.850752'),('p20','Costco pharmacy','00020.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3356981271','info20@costcopharma.com','Great Neck','11025','40.754757','-73.601772'),('p21','CVS pharmacy','00021.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3166351638','info21@cvshealth.com','Cowlesville','14037','42.814667','-78.46076'),('p22','Walgreens pharmacy','00022.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3396036940','info22@walgreens.com','Georgetown','83239','42.483479','-111.35333'),('p23','Costco pharmacy','00023.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3706599336','info23@costcopharma.com','Bruno','68014','41.28216','-96.9594'),('p24','CVS pharmacy','00024.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3376295282','info24@cvshealth.com','Bruno','68014','41.28216','-96.9594'),('p25','Walgreens pharmacy','00025.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3086478109','info25@walgreens.com','Caguas','00626','18.235003','-66.037318'),('p26','Costco pharmacy','00026.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3226948619','info26@costcopharma.com','Casselberry','32730','28.653875','-81.34387'),('p27','CVS pharmacy','00027.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3566958115','info27@cvshealth.com','Savannah','31401','32.068658','-81.09258'),('p28','Walgreens pharmacy','00028.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3056531355','info28@walgreens.com','Atlanta','30378','33.844371','-84.47405'),('p29','Costco pharmacy','00029.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','4006246040','info29@costcopharma.com','Lakeland','33804','28.002553','-81.61864'),('p30','CVS pharmacy','00030.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3176812531','info30@cvshealth.com','Lakeland','33804','28.002553','-81.61864'),('p31','Walgreens pharmacy','00031.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3916386730','info31@walgreens.com','Lawai','96765','21.930922','-159.499342'),('p32','Costco pharmacy','00032.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3246951177','info32@costcopharma.com','East Berlin','06023','41.612748','-72.72017'),('p33','CVS pharmacy','00033.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3166132707','info33@cvshealth.com','Jonesburg','63351','38.862422','-91.31284'),('p34','Walgreens pharmacy','00034.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3946327222','info34@walgreens.com','Graham','73437','34.363418','-97.43017'),('p35','Costco pharmacy','00035.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3366902460','info35@costcopharma.com','Sidney Center','13839','42.236762','-75.25901'),('p36','CVS pharmacy','00036.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3216843941','info36@cvshealth.com','Bellflower','63333','39.03288','-91.32983'),('p37','Walgreens pharmacy','00037.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3466522629','info37@walgreens.com','Savannah','31401','32.068658','-81.09258'),('p38','Costco pharmacy','00038.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3946314231','info38@costcopharma.com','Whitefield','74472','35.259201','-95.24701'),('p39','CVS pharmacy','00039.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3206758481','info39@cvshealth.com','Lake Harbor','33459','26.645895','-80.430269'),('p40','Walgreens pharmacy','00040.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3436481183','info40@walgreens.com','Jonesburg','63351','38.862422','-91.31284'),('p41','Costco pharmacy','00041.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3486962281','info41@costcopharma.com','Red Bluff','96080','40.183837','-122.24074'),('p42','CVS pharmacy','00042.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3336711726','info42@cvshealth.com','Lakeland','33804','28.002553','-81.61864'),('p43','Walgreens pharmacy','00043.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3616374453','info43@walgreens.com','Casselberry','32730','28.653875','-81.34387'),('p44','Costco pharmacy','00044.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3766231343','info44@costcopharma.com','Graham','73437','34.363418','-97.43017'),('p45','CVS pharmacy','00045.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3176795664','info45@cvshealth.com','Little Rock','72221','34.751918','-92.392487'),('p46','Walgreens pharmacy','00046.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3636893106','info46@walgreens.com','Big Sioux','57949','42.505818','-96.499259'),('p47','Costco pharmacy','00047.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3926759192','info47@costcopharma.com','Georgetown','83239','42.483479','-111.35333'),('p48','CVS pharmacy','00048.png',' This is a dummy description for Pharmacy CVS-Health','CVS-Health','3746246545','info48@cvshealth.com','Little Rock','72221','34.751918','-92.392487'),('p49','Walgreens pharmacy','00049.png',' This is a dummy description for Pharmacy Walgreens','Walgreens','3786422224','info49@walgreens.com','Stedman','28391','35.016373','-78.6941'),('p50','Costco pharmacy','00050.png',' This is a dummy description for Pharmacy Costco-Wholesale-Corp','Costco-Wholesale-Corp','3756912088','info50@costcopharma.com','Hawaii National Park','96718','19.435739','-155.26648');
/*!40000 ALTER TABLE `pharmacy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacyappointments`
--

DROP TABLE IF EXISTS `pharmacyappointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacyappointments` (
  `transactionID` varchar(11) DEFAULT NULL,
  `userID` varchar(20) NOT NULL,
  `userName` varchar(40) NOT NULL,
  `pharmacyID` varchar(5) NOT NULL,
  `pharmacyName` varchar(40) NOT NULL,
  `pharmacyCategory` varchar(30) NOT NULL,
  `pharmacyCity` varchar(30) NOT NULL,
  `pharmacyZip` varchar(10) NOT NULL,
  `pharmacyLat` varchar(25) NOT NULL,
  `pharmacyLon` varchar(25) NOT NULL,
  `appointmentDate` varchar(15) NOT NULL,
  `appointmentTime` varchar(15) NOT NULL,
  `appointmentDesc` varchar(100) NOT NULL,
  `currentStatus` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacyappointments`
--

LOCK TABLES `pharmacyappointments` WRITE;
/*!40000 ALTER TABLE `pharmacyappointments` DISABLE KEYS */;
INSERT INTO `pharmacyappointments` VALUES ('764823','1602465977','harsh','p3','CVS pharmacy','CVS-Health','Big Sioux','57949','42.505818','-96.499259','2020-12-17','15:14','Buying Medicines','Pending'),('545675','1602465977','harsh','p6','CVS pharmacy','CVS-Health','Atlanta','30378','33.844371','-84.47405','2020-12-15','18:00','Medicine Purchase','Pending'),('245951','1602465977','harsh','p1','Walgreens pharmacy','Walgreens','Sidney Center','13839','42.236762','-75.25901','2020-12-14','16:00','Inquiry','Pending'),('770486','1602465977','harsh','p5','Costco pharmacy','Costco-Wholesale-Corp','Whitefield','74472','35.259201','-95.24701','2021-01-04','18:00','Medicine Purchase','Pending'),('395408','1602341465','chirag','p4','Walgreens pharmacy','Walgreens','Lawai','96765','21.930922','-159.499342','2020-12-15','16:55','Inquiry','Pending'),('464741','1602341465','chirag','p10','Walgreens pharmacy','Walgreens','Stedman','28391','35.016373','-78.6941','2020-12-15','17:55','Medicine Purchase','Pending'),('190980','1602466011','shloka','p4','Walgreens pharmacy','Walgreens','Lawai','96765','21.930922','-159.499342','2020-12-30','18:05','Medicine Inquiry','Pending'),('742996','1602465967','ninad','p2','Costco pharmacy','Costco-Wholesale-Corp','Caguas','00626','18.235003','-66.037318','2020-12-14','17:00','Medicine','Pending'),('694151','1602465967','ninad','p5','Costco pharmacy','Costco-Wholesale-Corp','Whitefield','74472','35.259201','-95.24701','2020-12-08','16:10','Inquiry','Pending'),('642313','1602465951','satyaveer','p2','Costco pharmacy','Costco-Wholesale-Corp','Caguas','00626','18.235003','-66.037318','2020-12-22','17:10','Prescription Medicine','Pending'),('747111','1602465951','satyaveer','p4','Walgreens pharmacy','Walgreens','Lawai','96765','21.930922','-159.499342','2021-01-11','17:10','Inquiry','Pending'),('300718','1602465989','mounin','p5','Costco pharmacy','Costco-Wholesale-Corp','Whitefield','74472','35.259201','-95.24701','2020-12-29','12:00','Medicine Purchase','Pending'),('550141','1602465931','dhiraj','p4','Walgreens pharmacy','Walgreens','Lawai','96765','21.930922','-159.499342','2020-12-22','18:15','Inquiry','Pending'),('349363','1602465920','akash','p4','Walgreens pharmacy','Walgreens','Lawai','96765','21.930922','-159.499342','2020-12-28','08:00','Medicine Inquiry','Pending'),('683862','1602466022','kevin','p4','Walgreens pharmacy','Walgreens','Lawai','96765','21.930922','-159.499342','2020-12-15','12:30','Inquiry','Pending'),('491464','1602466022','kevin','p6','CVS pharmacy','CVS-Health','Atlanta','30378','33.844371','-84.47405','2021-01-18','13:00','Medicine Purchase','Pending'),('263946','1602466033','omar','p2','Costco pharmacy','Costco-Wholesale-Corp','Caguas','00626','18.235003','-66.037318','2020-12-15','19:05','Prescription Medicine','Pending'),('746509','1602466033','omar','p6','CVS pharmacy','CVS-Health','Atlanta','30378','33.844371','-84.47405','2021-02-24','08:00','Medicine Purchase','Pending'),('285382','1602466043','nadeen','p1','Walgreens pharmacy','Walgreens','Sidney Center','13839','42.236762','-75.25901','2020-12-31','11:07','Inquiry','Pending'),('174974','1602466072','chris','p4','Walgreens pharmacy','Walgreens','Lawai','96765','21.930922','-159.499342','2021-01-05','09:10','Medicine Inquiry','Pending'),('310553','1602466072','chris','p5','Costco pharmacy','Costco-Wholesale-Corp','Whitefield','74472','35.259201','-95.24701','2021-01-13','19:10','Medicine Purchase','Pending'),('203650','1602466090','jean','p3','CVS pharmacy','CVS-Health','Big Sioux','57949','42.505818','-96.499259','2021-01-01','19:08','Buying Medicines','Pending'),('221461','1602465977','harsh','p50','Costco pharmacy','Costco-Wholesale-Corp','Hawaii National Park','96718','19.435739','-155.26648','2020-12-14','12:00','Medicine Purchase','Pending');
/*!40000 ALTER TABLE `pharmacyappointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
  `userID` varchar(11) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `usertype` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (NULL,'admin','admin123','retailer'),('1602341465','chirag','1234','customer'),('1602462193','nishant','1234','customer'),('1602465920','akash','1234','customer'),('1602465931','dhiraj','1234','customer'),('1602465951','satyaveer','1234','customer'),('1602465967','ninad','1234','customer'),('1602465977','harsh','1234','customer'),('1602465989','mounin','1234','customer'),('1602466001','akshay','1234','customer'),('1602466011','shloka','1234','customer'),('1602466022','kevin','1234','customer'),('1602466033','omar','1234','customer'),('1602466043','nadeen','1234','customer'),('1602466056','jeanperre','1234','customer'),('1602466072','chris','1234','customer'),('1602466080','jose','1234','customer'),('1602466090','jean','1234','customer'),('1602466150','gauri','1234','customer'),('1602466165','shivani','1234','customer'),('1602466177','sarthak','1234','customer'),('1602468478','testuser','1234','customer'),('1607188205','user1','1234','customer'),('1607244287','saurabh','1234','customer');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-06 22:30:45
