-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 07, 2016 at 10:59 PM
-- Server version: 5.5.49-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test_android`
--

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE IF NOT EXISTS `images` (
  `ImageID` int(11) NOT NULL AUTO_INCREMENT,
  `ImageName` varchar(50) NOT NULL,
  `ImagePath_Thumbnail` varchar(150) NOT NULL,
  `ImagePath_FullPhoto` varchar(150) NOT NULL,
  PRIMARY KEY (`ImageID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`ImageID`, `ImageName`, `ImagePath_Thumbnail`, `ImagePath_FullPhoto`) VALUES
(1, 'Image 1', 'http://www.thaicreate.com/android/img1_thum.jpg', 'http://www.thaicreate.com/android/img1_full.jpg'),
(2, 'Image 2', 'http://www.thaicreate.com/android/img2_thum.jpg', 'http://www.thaicreate.com/android/img2_full.jpg'),
(3, 'Image 3', 'http://www.thaicreate.com/android/img3_thum.jpg', 'http://www.thaicreate.com/android/img3_full.jpg'),
(4, 'Image 4', 'http://www.thaicreate.com/android/img4_thum.jpg', 'http://www.thaicreate.com/android/img4_full.jpg'),
(5, 'Image 5', 'http://www.thaicreate.com/android/img5_thum.jpg', 'http://www.thaicreate.com/android/img5_full.jpg'),
(6, 'Image 6', 'http://www.thaicreate.com/android/img6_thum.jpg', 'http://www.thaicreate.com/android/img6_full.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `MemberID` int(2) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Tel` varchar(50) NOT NULL,
  PRIMARY KEY (`MemberID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`MemberID`, `Name`, `Tel`) VALUES
(1, 'Weerachai', '0819876107'),
(2, 'Win', '021978032'),
(3, 'Eak', '0876543210');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
