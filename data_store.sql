-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 16, 2022 at 04:23 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `animal_details`
--

DROP TABLE IF EXISTS `animal_details`;
CREATE TABLE IF NOT EXISTS `animal_details` (
  `Animal_ID` int(10) NOT NULL,
  `Reg_Name` varchar(20) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Born_Date` varchar(12) NOT NULL,
  `Species` varchar(50) NOT NULL,
  `Birth_weight` varchar(5) NOT NULL,
  `Img_Path` varchar(100) NOT NULL,
  PRIMARY KEY (`Animal_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
CREATE TABLE IF NOT EXISTS `attendance` (
  `Record_ID` int(10) NOT NULL,
  `Record_Status` varchar(2) NOT NULL,
  `Date_Record` varchar(20) NOT NULL,
  `Time_Record` varchar(30) NOT NULL,
  `Emp_ID` int(11) DEFAULT NULL,
  KEY `Emp_ID` (`Emp_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`Record_ID`, `Record_Status`, `Date_Record`, `Time_Record`, `Emp_ID`) VALUES
(27834, 'P', '2022-05-03', '20:54:32.260', 2944799),
(11541, 'P', '2022-05-06', '21:29:17.876', 2944799),
(20178, 'P', '2022-05-07', '11:21:02.682', 2944799),
(78957, 'P', '2022-05-10', '15:30:36.734', 2944799);

-- --------------------------------------------------------

--
-- Table structure for table `devices`
--

DROP TABLE IF EXISTS `devices`;
CREATE TABLE IF NOT EXISTS `devices` (
  `device_ID` int(11) NOT NULL,
  `device_Name` varchar(45) NOT NULL,
  `status` varchar(3) NOT NULL,
  `last_active` varchar(45) NOT NULL,
  PRIMARY KEY (`device_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `devices`
--

INSERT INTO `devices` (`device_ID`, `device_Name`, `status`, `last_active`) VALUES
(2944799, 'Sensor Box A', 'D', '23232'),
(3012594, 'Sensor Box B', 'D', '2342'),
(2605093, 'Attendance Maneger', 'A', '2022-05-17 | 21:23:50.183'),
(3032489, 'Access Manager A', 'A', '2022-06-02 | 11:50:29.535'),
(2944800, 'Access Manager B', 'D', '1231313'),
(2649500, 'Access Manager C', 'D', '1231313'),
(2619500, 'Access Manager D', 'D', '1231313'),
(2644500, 'Access Manager E', 'D', '1231313');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(11) NOT NULL,
  `emp_name` varchar(45) DEFAULT NULL,
  `emp_nic` varchar(12) NOT NULL,
  `mobile_number` varchar(10) DEFAULT NULL,
  `emp_type` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `section` varchar(45) NOT NULL,
  `p1` varchar(45) NOT NULL,
  `p2` varchar(45) NOT NULL,
  `p3` varchar(45) NOT NULL,
  `p4` varchar(45) NOT NULL,
  `p5` varchar(45) NOT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_nic_UNIQUE` (`emp_nic`),
  UNIQUE KEY `mobile_number_UNIQUE` (`mobile_number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_name`, `emp_nic`, `mobile_number`, `emp_type`, `gender`, `section`, `p1`, `p2`, `p3`, `p4`, `p5`) VALUES
(2944799, 'Sudarshani Perera', '73268732642', '0455677365', 'TEMPORARY WORK', 'FEMALE', 'INDOOR PLANTING ROOM', 'true', 'false', 'false', 'false', 'true'),
(2943813, 'Sameera', '8498535985', '0455677369', 'PERMANENT EMPLOYEE', 'MALE', 'GREEN HOUSE', 'true', 'true', 'true', 'false', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `medical_data`
--

DROP TABLE IF EXISTS `medical_data`;
CREATE TABLE IF NOT EXISTS `medical_data` (
  `Record_ID` int(12) NOT NULL,
  `Animal_ID` int(20) NOT NULL,
  `Checked_By` varchar(50) NOT NULL,
  `Checked_Date` varchar(12) NOT NULL,
  `Record` varchar(500) NOT NULL,
  `Next_Checkup` varchar(12) NOT NULL,
  PRIMARY KEY (`Record_ID`),
  KEY `Animal_ID` (`Animal_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `real_time_box_1`
--

DROP TABLE IF EXISTS `real_time_box_1`;
CREATE TABLE IF NOT EXISTS `real_time_box_1` (
  `Record_ID` int(10) NOT NULL,
  `Record_Date` varchar(12) NOT NULL,
  `Record_Time` varchar(10) NOT NULL,
  `Temperature` varchar(5) NOT NULL,
  `Humidity` varchar(5) NOT NULL,
  `Heat_Index` varchar(5) NOT NULL,
  `Gas_Value` varchar(5) NOT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `real_time_box_1`
--

INSERT INTO `real_time_box_1` (`Record_ID`, `Record_Date`, `Record_Time`, `Temperature`, `Humidity`, `Heat_Index`, `Gas_Value`) VALUES
(409, '2022-05-10', '15:43:15', '25', '95', '36.18', '571');

-- --------------------------------------------------------

--
-- Table structure for table `real_time_box_2`
--

DROP TABLE IF EXISTS `real_time_box_2`;
CREATE TABLE IF NOT EXISTS `real_time_box_2` (
  `Record_ID` int(10) NOT NULL,
  `Record_Date` varchar(12) NOT NULL,
  `Record_Time` varchar(10) NOT NULL,
  `Water_Level` varchar(5) NOT NULL,
  `Soil_Moisture` varchar(45) NOT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `real_time_box_2`
--

INSERT INTO `real_time_box_2` (`Record_ID`, `Record_Date`, `Record_Time`, `Water_Level`, `Soil_Moisture`) VALUES
(1689, '2022-05-10', '15:43:05', '2', '496');

-- --------------------------------------------------------

--
-- Table structure for table `real_time_box_3`
--

DROP TABLE IF EXISTS `real_time_box_3`;
CREATE TABLE IF NOT EXISTS `real_time_box_3` (
  `Record_ID` int(10) NOT NULL,
  `Record_Date` varchar(12) NOT NULL,
  `Record_Time` varchar(10) NOT NULL,
  `Soil_Moisture` varchar(5) NOT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `real_time_box_3`
--

INSERT INTO `real_time_box_3` (`Record_ID`, `Record_Date`, `Record_Time`, `Soil_Moisture`) VALUES
(1689, '55', '55', '55');

-- --------------------------------------------------------

--
-- Table structure for table `sensor_box_01`
--

DROP TABLE IF EXISTS `sensor_box_01`;
CREATE TABLE IF NOT EXISTS `sensor_box_01` (
  `Record_ID` int(10) NOT NULL,
  `Record_Date` varchar(12) NOT NULL,
  `Record_Time` varchar(10) NOT NULL,
  `Temperature` varchar(5) NOT NULL,
  `Humidity` varchar(5) NOT NULL,
  `Heat_Index` varchar(5) NOT NULL,
  `Gas_Value` varchar(5) NOT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sensor_box_01`
--

INSERT INTO `sensor_box_01` (`Record_ID`, `Record_Date`, `Record_Time`, `Temperature`, `Humidity`, `Heat_Index`, `Gas_Value`) VALUES
(80301968, '2022-04-18', '23:30:07', '10', '29.20', '39.42', '542'),
(64517167, '2022-04-18', '23:32:16', '29.20', '95', '39.42', '542'),
(71975018, '2022-04-18', '23:32:21', '29.20', '95', '39.42', '542'),
(67252008, '2022-04-18', '23:32:26', '29.20', '95', '39.42', '542'),
(3415213, '2022-04-18', '23:32:31', '29.20', '95', '39.42', '542'),
(78527189, '2022-04-18', '23:32:36', '29.20', '95', '39.42', '542'),
(41949604, '2022-04-18', '23:32:41', '29.20', '95', '39.42', '542'),
(89686241, '2022-04-18', '23:32:46', '29.20', '95', '39.42', '542'),
(7101271, '2022-04-24', '13:04:15', '29.30', '95', '39.79', '569'),
(50529595, '2022-04-24', '13:12:13', '28.80', '95', '37.95', '568'),
(10088455, '2022-04-24', '13:17:13', '28.70', '95', '37.59', '567'),
(74208769, '2022-04-30', '12:24:31', '27.90', '95', '34.83', '594'),
(39075182, '2022-04-24', '13:27:14', '28.80', '95', '37.95', '560'),
(79478843, '2022-04-24', '13:32:14', '28.60', '95', '37.23', '569'),
(60883260, '2022-04-24', '13:37:14', '28.50', '95', '36.88', '566'),
(52142134, '2022-04-24', '13:42:14', '28.40', '95', '36.53', '562'),
(95122991, '2022-04-24', '13:47:14', '28.40', '95', '36.53', '562'),
(33038206, '2022-04-24', '13:52:14', '28.50', '95', '36.88', '572'),
(5784670, '2022-04-24', '13:57:14', '28.40', '95', '36.53', '570'),
(83605739, '2022-04-24', '14:02:14', '28.40', '95', '36.53', '565'),
(47986396, '2022-04-24', '14:07:14', '28.30', '95', '36.18', '562'),
(63522836, '2022-04-30', '12:39:31', '27.70', '95', '34.18', '463'),
(26576219, '2022-04-30', '12:54:31', '27.90', '95', '34.83', '423'),
(30477530, '2022-04-30', '13:09:31', '27.70', '95', '34.18', '398'),
(63267066, '2022-04-30', '13:24:31', '27.70', '95', '34.18', '380'),
(42410171, '2022-04-30', '13:39:31', '27.80', '95', '34.50', '393'),
(20777378, '2022-04-30', '13:54:31', '28.10', '95', '35.50', '376'),
(23026688, '2022-04-30', '14:09:31', '28.20', '95', '35.84', '382'),
(95433722, '2022-04-30', '14:24:31', '28.20', '95', '35.84', '374'),
(16890593, '2022-04-30', '14:39:31', '28.20', '95', '35.84', '367'),
(10544552, '2022-04-30', '14:54:32', '28.10', '95', '35.50', '367'),
(63490795, '2022-04-30', '15:09:32', '28.00', '93', '35.16', '373'),
(81673636, '2022-04-30', '15:24:32', '28.20', '95', '35.84', '381'),
(12047923, '2022-04-30', '15:39:32', '28.30', '95', '36.18', '384'),
(66808144, '2022-04-30', '15:54:32', '28.30', '95', '36.18', '382'),
(98805563, '2022-04-30', '16:09:32', '28.20', '95', '35.84', '380'),
(78219646, '2022-04-30', '16:24:32', '28.30', '95', '36.18', '386'),
(48537908, '2022-04-30', '16:39:32', '28.30', '95', '36.18', '388'),
(25712621, '2022-04-30', '16:54:32', '28.50', '95', '36.88', '396'),
(93015304, '2022-05-09', '18:13:33', '32.20', '95', '52.46', '572'),
(77273448, '2022-05-09', '18:23:42', '32.00', '95', '51.48', '572'),
(57473187, '2022-05-09', '19:18:32', '32.00', '95', '51.48', '572'),
(22963417, '2022-05-09', '19:33:32', '31.20', '95', '47.69', '595'),
(84039878, '2022-05-09', '19:45:46', '31.30', '95', '48.15', '593'),
(52866159, '2022-05-09', '19:49:32', '31.30', '95', '48.15', '593'),
(14747507, '2022-05-09', '19:50:55', '31.30', '95', '48.15', '593'),
(2098758, '2022-05-09', '20:05:55', '29.40', '95', '40.17', '595'),
(96913256, '2022-05-09', '20:20:55', '28.70', '95', '37.59', '593'),
(52721722, '2022-05-09', '20:35:55', '28.70', '95', '37.59', '593'),
(74586515, '2022-05-09', '20:50:55', '28.70', '95', '37.59', '593'),
(13011804, '2022-05-10', '10:47:30', '28.70', '95', '37.59', '593'),
(84179131, '2022-05-10', '15:27:02', '29.10', '95', '39.04', '584'),
(557730, '2022-05-10', '11:31:20', '29.00', '95', '38.67', '584'),
(46366622, '2022-05-10', '11:46:20', '28.60', '95', '37.23', '585'),
(91672719, '2022-05-10', '12:01:20', '28.80', '95', '37.95', '582'),
(35365354, '2022-05-17', '12:16:20', '28.80', '95', '37.95', '581'),
(64324386, '2022-05-17', '12:31:20', '28.80', '95', '37.95', '582'),
(24536550, '2022-05-17', '12:46:20', '28.80', '95', '37.95', '581'),
(63465578, '2022-05-17', '13:01:20', '28.70', '95', '37.59', '581'),
(22028804, '2022-05-17', '13:16:21', '29.20', '95', '39.42', '584'),
(1452535, '2022-05-17', '13:31:21', '29.00', '95', '38.67', '583'),
(97876167, '2022-05-17', '15:42:02', '28.30', '95', '36.18', '569');

-- --------------------------------------------------------

--
-- Table structure for table `sensor_box_02`
--

DROP TABLE IF EXISTS `sensor_box_02`;
CREATE TABLE IF NOT EXISTS `sensor_box_02` (
  `Record_ID` int(10) NOT NULL,
  `Record_Date` varchar(12) NOT NULL,
  `Record_Time` varchar(10) NOT NULL,
  `Water_Level` varchar(5) NOT NULL,
  `Soil_Moisture` varchar(45) NOT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sensor_box_02`
--

INSERT INTO `sensor_box_02` (`Record_ID`, `Record_Date`, `Record_Time`, `Water_Level`, `Soil_Moisture`) VALUES
(65553347, '2022-04-29', '20:12:02', '6', '6'),
(13352035, '2022-04-29', '20:12:33', '6', '7'),
(23290381, '2022-04-29', '20:15:32', '5', '5'),
(71827637, '2022-04-29', '20:30:32', '7', '7'),
(2847640, '2022-04-29', '20:45:32', '7', '7'),
(12580840, '2022-04-29', '21:00:32', '6', '6'),
(66137799, '2022-04-29', '21:15:32', '10', '9'),
(32946458, '2022-04-29', '21:30:32', '10', '10'),
(56264272, '2022-04-29', '21:45:33', '9', '9'),
(30257133, '2022-04-29', '22:00:33', '8', '8'),
(13430229, '2022-04-29', '22:15:33', '5', '5'),
(56542751, '2022-04-30', '22:30:33', '6', '5'),
(38014630, '2022-04-30', '22:45:33', '5', '6'),
(77109147, '2022-05-09', '18:09:11', '6', '6'),
(60595420, '2022-05-09', '18:13:33', '6', '6'),
(69820037, '2022-05-09', '18:23:42', '0', '496'),
(48620108, '2022-05-09', '19:18:32', '1', '496'),
(47521904, '2022-05-09', '19:33:32', '0', '496'),
(94658764, '2022-05-09', '19:45:46', '1', '496'),
(32146724, '2022-05-09', '19:49:32', '1', '496'),
(73772268, '2022-05-09', '19:50:55', '1', '496'),
(88133714, '2022-05-09', '20:05:55', '1', '496'),
(62764065, '2022-05-10', '10:47:30', '2', '496'),
(61410018, '2022-05-10', '11:02:30', '25', '496'),
(9856769, '2022-05-10', '11:17:30', '22', '496'),
(5887723, '2022-05-10', '11:31:20', '19', '496'),
(29379424, '2022-05-10', '11:46:20', '25', '496'),
(21057869, '2022-05-10', '12:01:20', '26', '496'),
(38041933, '2022-05-10', '12:16:20', '23', '496'),
(33461068, '2022-05-10', '12:31:20', '22', '496'),
(48174322, '2022-05-10', '12:46:20', '20', '496'),
(24574648, '2022-05-10', '13:01:20', '18', '496'),
(77265915, '2022-05-10', '13:16:21', '23', '496'),
(62872541, '2022-05-10', '13:31:21', '19', '496'),
(26209974, '2022-05-10', '15:27:02', '3', '496');

-- --------------------------------------------------------

--
-- Table structure for table `sensor_box_03`
--

DROP TABLE IF EXISTS `sensor_box_03`;
CREATE TABLE IF NOT EXISTS `sensor_box_03` (
  `Record_ID` int(10) NOT NULL,
  `Record_Date` varchar(12) NOT NULL,
  `Record_Time` varchar(10) NOT NULL,
  `Soil_Moisture` varchar(5) NOT NULL,
  PRIMARY KEY (`Record_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `to_do`
--

DROP TABLE IF EXISTS `to_do`;
CREATE TABLE IF NOT EXISTS `to_do` (
  `Activity_ID` int(12) NOT NULL,
  `TASK_DATE` varchar(12) NOT NULL,
  `LOCATION_data` varchar(20) NOT NULL,
  `Activity` varchar(500) NOT NULL,
  PRIMARY KEY (`Activity_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `to_do`
--

INSERT INTO `to_do` (`Activity_ID`, `TASK_DATE`, `LOCATION_data`, `Activity`) VALUES
(68677, '2022-05-27', 'Green House', 'Smart Greenhouses A smart greenhouse designed with the help of IoT intelligently monitors as well as controls the climate, eliminating the need for manual intervention.'),
(96009, '2022-05-24', 'Hydroponic', 'For example, a sudden 30-minute power shortage may not affect soil temperatures enough to harm the plants. However, as water is more sensitive to the environment, its temperature might change quickly, impacting the roots and stressing the plant.'),
(45203, '2022-04-28', 'Green House', 'Providing and Balancing Lighting and Radiation'),
(54778, '2022-05-26', 'green house', 'green house'),
(41171, '2022-04-05', 'Green House', 'Controlling Humidity.'),
(8764, '2022-05-12', 'Green House', 'The Spruce Sensor’s soil moisture is expressed as volumetric water content (%).  Simply stated, this is the quantity of water contained in the soil (with the soil itself, water, and air comprising 100%).  Generally, soil moisture will range from 10% to 45%, but can be higher during and after watering.\n\n');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
