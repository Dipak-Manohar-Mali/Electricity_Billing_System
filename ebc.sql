-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2022 at 04:46 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ebc`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `meter_no` varchar(20) DEFAULT NULL,
  `month` varchar(30) DEFAULT NULL,
  `units` varchar(20) DEFAULT NULL,
  `totalbill` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`meter_no`, `month`, `units`, `totalbill`, `status`) VALUES
('648631', 'January', '133', '1347', 'Paid'),
('648631', 'January', '176', '1734', 'Paid'),
('928506', 'January', '100', '550', 'Not Paid'),
('648631', 'February', '101', '1059', 'Not Paid');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `name` varchar(20) DEFAULT NULL,
  `meter_no` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`name`, `meter_no`, `address`, `city`, `state`, `email`, `phone`) VALUES
('Gunvant Vinod Desale', '928506', 'Dhule', 'Dhule', 'Maharastra', 'gunvantdesale123@gmail.com', '9087676534'),
('Jayesh Sunil Mali', '648631', 'Nagonbari Dhule', 'Dhule', 'Maharashtra', 'jayu123@gmail.com', '9090909012');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `meter_no` varchar(20) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`meter_no`, `username`, `name`, `password`, `user`) VALUES
('', 'DipakMali', 'Dipak', 'Mali123', 'Admin'),
('928506', 'Gunavant123', 'Gunvant Vinod Desale', 'desale@123', 'Customer'),
('721326', '', '', '', ''),
('648631', 'jayesh', 'Jayesh Sunil Mali', '12345', 'Customer'),
('', 'GunvantDesale', 'Gunvant', 'G@12345', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `meter_info`
--

CREATE TABLE `meter_info` (
  `meter_no` varchar(20) DEFAULT NULL,
  `meter_location` varchar(20) DEFAULT NULL,
  `meter_type` varchar(20) DEFAULT NULL,
  `phase_code` varchar(20) DEFAULT NULL,
  `bill_type` varchar(20) DEFAULT NULL,
  `days` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meter_info`
--

INSERT INTO `meter_info` (`meter_no`, `meter_location`, `meter_type`, `phase_code`, `bill_type`, `days`) VALUES
('928506', 'Inside', 'Electric Meter', '022', 'Normal', '30'),
('648631', 'Inside', 'Electric Meter', '011', 'Normal', '30');

-- --------------------------------------------------------

--
-- Table structure for table `tax`
--

CREATE TABLE `tax` (
  `meter_rent` varchar(20) DEFAULT NULL,
  `service_charge` varchar(20) DEFAULT NULL,
  `service_tax` varchar(20) DEFAULT NULL,
  `swacch_bharat_cess` varchar(20) DEFAULT NULL,
  `fixed_tax` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tax`
--

INSERT INTO `tax` (`meter_rent`, `service_charge`, `service_tax`, `swacch_bharat_cess`, `fixed_tax`) VALUES
('47', '22', '57', '6', '18');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
