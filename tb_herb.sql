-- phpMyAdmin SQL Dump
-- version 4.4.14.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 10, 2016 at 11:59 AM
-- Server version: 5.6.25
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dental`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_herb`
--

CREATE TABLE IF NOT EXISTS `tb_herb` (
  `id_herb` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf16_bin NOT NULL,
  `name_sci` varchar(100) COLLATE utf16_bin NOT NULL,
  `name_local` varchar(100) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `tb_herb`
--

INSERT INTO `tb_herb` (`id_herb`, `name`, `name_sci`, `name_local`) VALUES
(1, 'กระเจียน', 'Polyalthia cerasoides (Roxb.) Bent.ex Bedd', 'ทรายเด่น พญารากดำ นมแมวป่า'),
(2, 'กระตังใบ', 'Leea indica Merr', 'ต้างไก่ใหญ่ กระตังใบ'),
(3, 'กระทือ', 'Zingiber zerumbet Smith', 'กระทือ กระทือป่า กะแวน กะแอน เฮียงแดง');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_herb`
--
ALTER TABLE `tb_herb`
  ADD PRIMARY KEY (`id_herb`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_herb`
--
ALTER TABLE `tb_herb`
  MODIFY `id_herb` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
