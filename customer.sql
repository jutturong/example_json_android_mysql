-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 08, 2016 at 10:31 AM
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
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `CUSTOMER_ID` varchar(4) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `COUNTRY_CODE` varchar(2) NOT NULL,
  `BUDGET` decimal(18,2) NOT NULL,
  `USED` decimal(18,2) NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CUSTOMER_ID`, `NAME`, `EMAIL`, `COUNTRY_CODE`, `BUDGET`, `USED`) VALUES
('C001', 'Win Weerachai', 'win.weerachai@thaicreate.com', 'TH', 1000000.00, 600000.00),
('C002', 'John  Smith', 'john.smith@thaicreate.com', 'UK', 2000000.00, 800000.00),
('C003', 'Jame Born', 'jame.born@thaicreate.com', 'US', 3000000.00, 600000.00),
('C004', 'Chalee Angel', 'chalee.angel@thaicreate.com', 'US', 4000000.00, 100000.00);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
