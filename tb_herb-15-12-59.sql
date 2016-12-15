-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 15, 2016 at 03:38 PM
-- Server version: 5.5.53-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dental`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_herb`
--

CREATE TABLE IF NOT EXISTS `tb_herb` (
  `id_herb` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf16_bin NOT NULL,
  `name_sci` varchar(100) COLLATE utf16_bin NOT NULL,
  `name_local` varchar(100) COLLATE utf16_bin NOT NULL,
  `general` text COLLATE utf16_bin NOT NULL,
  `properties` text COLLATE utf16_bin NOT NULL,
  `usage` text COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`id_herb`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf16 COLLATE=utf16_bin AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tb_herb`
--

INSERT INTO `tb_herb` (`id_herb`, `name`, `name_sci`, `name_local`, `general`, `properties`, `usage`) VALUES
(1, 'กระเจียน', 'Polyalthia cerasoides (Roxb.) Bent.ex Bedd', 'ทรายเด่น พญารากดำ นมแมวป่า', 'เป็นพันธุ์ไม้พุ่มขนาดเล็กถึงขนาดกลางในความสูงระหว่าง 3 ถึง 8 เมตร\r\nลำต้นเปล่าตรง ผิวลำต้นเรียบ ใบเป็นใบเดี่ยว รูปใบหอกแกมขอบขนาน\r\nใบอ่อนมีขนนุ่มๆ  ทั่วใบ ดอกเป็นดอกเดีี่ยวออกเป็นกลุ่มตามง่ามใบ\r\nกลีบเลี้ยง 3 กลีบ กลีบดอกสีเขียวอ่อน เรียงสลับกันสองชั้น แต่ละดอก\r\nจะมีเกสรตัวผู้อยู่เป็นจำนวนมาก ผลเป็นกลุ่ม อยู่บนแกนตุ้มกลม\r\nรูปทรงป้อมกลม ปลายติ่ง ผลอ่อนสีเขียว ผลแก่ จัดสีน้ำตาลแดง', 'ราก - แก้ไข้, แก้กษัย บำรุงกำลังในบุรุษ\r\nใบสด - ตำพอกรักษาแผลสด\r\nเนื้อไม้ - แก้วัณโรค แก้ปวดเมื่อย', 'ราก - แห้ง ต้มน้ำดื่ม แก้ไข้ แก้กษัย บำรุงกำลังในบุรุษ\r\nใบ - สด ตำพอกรักษาแผลสด\r\nเนิื้อไม้ - แห้ง ต้มดื่ม แก้วัณโรค แก้ปวดเมื่อย'),
(2, 'กระตังใบ', 'Leea indica Merr', 'ต้างไก่ใหญ่ กระตังใบ', 'เป็นไม้พุ่มขนาดเล็กในความสูงระห่วาง 50 เซนติเมตร ถึง 2 เมตร\r\nใบเป็นใบประกอบ ใบย่อยรูปไข่ ปลายใบแหลม ขอบจัก สีเขียมเข้ม\r\nดอกขนาดเล็กสีน้ำตาลแดงรวมกันเป็นช่อ ผลขนาดเล็ก กลมแป้น\r\nสีเขียวอ่อน เมื่อผลแก่จะมีสีดำ', 'ราก - แก้ไข้ แก้ปวดเมื่อยตามร่างกาย ดับร้อน ขับเหงื่อ', 'ราก - แห้ง ต้มน้ำดื่ม แก้ไข้ แก้ปวดเมื่อยตามร่างกาย ดับร้อน\r\nขับเหงื่อ'),
(3, 'กระทือ', 'Zingiber zerumbet Smith', 'กระทือ กระทือป่า กะแวน กะแอน เฮียงแดง', '', '', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
