-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 11, 2017 at 02:50 AM
-- Server version: 5.7.17-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `daneta`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_business`
--

CREATE TABLE `tb_business` (
  `id` int(11) NOT NULL,
  `category` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `submittime` datetime DEFAULT NULL,
  `ms` varchar(50) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_business`
--

INSERT INTO `tb_business` (`id`, `category`, `name`, `submittime`, `ms`, `img`) VALUES
(1, 'FEM Software', 'Doctor Bridge', '2017-08-10 00:00:00', 'asdfasd', ''),
(3, 'Software', 'Kabasky', '2017-08-09 00:00:00', 'old', 'asdfasd');

-- --------------------------------------------------------

--
-- Table structure for table `tb_category`
--

CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL,
  `category` varchar(50) NOT NULL,
  `submittime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tb_news`
--

CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `submittime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_news`
--

INSERT INTO `tb_news` (`id`, `title`, `content`, `author`, `submittime`) VALUES
(0, 'Trump2', 'Trump is building his wall!', 'Andrew', '2017-08-08 00:00:00'),
(2, 'kafad', 'adfadsf', 'adsf', '2017-08-10 00:00:00'),
(3, 'kasasfad', 'adfadsf', 'adsf', '2017-08-10 00:00:00'),
(4, 'vxxcbv', 'afadfer', 'qwer', '2017-08-09 00:00:00'),
(5, 'vxasdfxcbv', 'afadfer', 'qwer', '2017-08-09 00:00:00'),
(6, 'nmmnwert', '啊速度发', '中国', '2017-08-09 00:00:00'),
(7, 'nmm21nwert', '啊速度发', '中国', '2017-08-09 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tb_usertable`
--

CREATE TABLE `tb_usertable` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_usertable`
--

INSERT INTO `tb_usertable` (`id`, `name`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_business`
--
ALTER TABLE `tb_business`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_category`
--
ALTER TABLE `tb_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_news`
--
ALTER TABLE `tb_news`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_usertable`
--
ALTER TABLE `tb_usertable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_business`
--
ALTER TABLE `tb_business`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tb_category`
--
ALTER TABLE `tb_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_news`
--
ALTER TABLE `tb_news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tb_usertable`
--
ALTER TABLE `tb_usertable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_category`
--
ALTER TABLE `tb_category`
  ADD CONSTRAINT `tb_category_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tb_business` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
