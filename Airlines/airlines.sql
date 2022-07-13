-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2022 at 10:21 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airlines`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `adminid` varchar(50) NOT NULL,
  `adminpassword` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`adminid`, `adminpassword`) VALUES
('chintans@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `ticketid` int(11) NOT NULL,
  `PName` varchar(50) DEFAULT NULL,
  `flightcode` varchar(20) DEFAULT NULL,
  `Pgender` varchar(10) DEFAULT NULL,
  `Ppnumber` varchar(20) DEFAULT NULL,
  `amount` varchar(10) DEFAULT NULL,
  `nationality` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`ticketid`, `PName`, `flightcode`, `Pgender`, `Ppnumber`, `amount`, `nationality`) VALUES
(1, 'CS', 'Airindia001', 'Male', 'ind001', '1800', 'India'),
(2, 'CS', 'Airindia001', 'Male', 'ind001', '1800', 'India'),
(3, 'CS', 'Airindia001', 'Male', 'ind001', '1800', 'India');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `flightcode` varchar(20) NOT NULL,
  `flightsource` varchar(50) DEFAULT NULL,
  `flightdestination` varchar(50) DEFAULT NULL,
  `flightdate` varchar(10) DEFAULT NULL,
  `flightseats` int(11) DEFAULT NULL,
  `Amount` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`flightcode`, `flightsource`, `flightdestination`, `flightdate`, `flightseats`, `Amount`) VALUES
('Airindia001', 'Banglore', 'Mumbai', '3/1/2022', 100, '1800');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `fname`, `lname`, `mobile`, `email`, `password`) VALUES
(4, 'Chintan', 'sawant', '785454433', 'chintans@gmail.com', '1234567');

-- --------------------------------------------------------

--
-- Table structure for table `passengers`
--

CREATE TABLE `passengers` (
  `PId` int(11) NOT NULL,
  `PName` varchar(50) DEFAULT NULL,
  `PNat` varchar(10) DEFAULT NULL,
  `PGen` varchar(10) DEFAULT NULL,
  `PPnumber` varchar(10) DEFAULT NULL,
  `PAdress` varchar(50) DEFAULT NULL,
  `PPhone` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `passengers`
--

INSERT INTO `passengers` (`PId`, `PName`, `PNat`, `PGen`, `PPnumber`, `PAdress`, `PPhone`) VALUES
(1, 'CS', 'India', 'Male', 'ind001', 'marcel', '797652314');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `ticketid` int(11) DEFAULT NULL,
  `amount` varchar(10) DEFAULT NULL,
  `cardnumber` varchar(50) NOT NULL,
  `expiry` varchar(10) NOT NULL,
  `cvv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`ticketid`, `amount`, `cardnumber`, `expiry`, `cvv`) VALUES
(1, '1800', '123456789012', '1/23', 123);

-- --------------------------------------------------------

--
-- Table structure for table `ticketcancellation`
--

CREATE TABLE `ticketcancellation` (
  `cancelid` int(11) NOT NULL,
  `ticketid` int(11) DEFAULT NULL,
  `flightcode` varchar(20) DEFAULT NULL,
  `canceldate` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`ticketid`),
  ADD KEY `flightcode` (`flightcode`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`flightcode`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `passengers`
--
ALTER TABLE `passengers`
  ADD PRIMARY KEY (`PId`);

--
-- Indexes for table `ticketcancellation`
--
ALTER TABLE `ticketcancellation`
  ADD PRIMARY KEY (`cancelid`),
  ADD KEY `ticketid` (`ticketid`),
  ADD KEY `flightcode` (`flightcode`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `ticketid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `passengers`
--
ALTER TABLE `passengers`
  MODIFY `PId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ticketcancellation`
--
ALTER TABLE `ticketcancellation`
  MODIFY `cancelid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`flightcode`) REFERENCES `flight` (`flightcode`);

--
-- Constraints for table `ticketcancellation`
--
ALTER TABLE `ticketcancellation`
  ADD CONSTRAINT `ticketcancellation_ibfk_1` FOREIGN KEY (`ticketid`) REFERENCES `bookings` (`ticketid`) ON DELETE CASCADE,
  ADD CONSTRAINT `ticketcancellation_ibfk_2` FOREIGN KEY (`flightcode`) REFERENCES `flight` (`flightcode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
