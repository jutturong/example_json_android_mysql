-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 08, 2016 at 10:32 AM
-- Server version: 5.5.52-0ubuntu0.14.04.1
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
-- Table structure for table `audit`
--

CREATE TABLE IF NOT EXISTS `audit` (
  `AUDIT_ID` int(4) NOT NULL,
  `CUSTOMER_ID` varchar(4) NOT NULL,
  `LOG_DATE` date NOT NULL,
  `USED` decimal(18,2) NOT NULL,
  PRIMARY KEY (`AUDIT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `audit`
--

INSERT INTO `audit` (`AUDIT_ID`, `CUSTOMER_ID`, `LOG_DATE`, `USED`) VALUES
(1, 'C001', '2015-08-01', 100000.00),
(2, 'C001', '2015-08-05', 200000.00),
(3, 'C001', '2015-08-10', 300000.00),
(4, 'C002', '2015-08-02', 400000.00),
(5, 'C002', '2015-08-07', 100000.00),
(6, 'C002', '2015-08-15', 300000.00),
(7, 'C003', '2015-08-20', 400000.00),
(8, 'C003', '2015-08-25', 200000.00),
(9, 'C004', '2015-07-04', 100000.00);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
