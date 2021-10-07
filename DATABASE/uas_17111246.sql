-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 28, 2019 at 10:53 PM
-- Server version: 5.7.24-0ubuntu0.16.04.1
-- PHP Version: 7.2.14-1+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_17111246`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_price_buy` int(11) NOT NULL,
  `item_price_sale` int(11) NOT NULL,
  `item_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `type_item_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price_buy` int(11) NOT NULL,
  `price_sale` int(11) NOT NULL,
  `stock` int(11) DEFAULT '0',
  `barcode` varchar(255) NOT NULL,
  `plu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `supplier_id`, `type_item_id`, `name`, `price_buy`, `price_sale`, `stock`, `barcode`, `plu`) VALUES
(1, 1, 1, 'Cable RG 45', 75000, 83000, 0, '88998847788377', '788377'),
(2, 2, 4, 'KINGSTON', 700000, 850000, 0, '888776677667778', '667778'),
(3, 3, 6, 'SAMSUNG EVO 60', 1000000, 1200000, 0, '88899898898989', '898989'),
(5, 2, 3, 'LOGITEC BLUETOOTH', 120000, 150000, 0, '8998980909097', '909097');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `phone`, `address`) VALUES
(1, 'PT ABADI JAYA TECH', '0225679801', 'JL RAYA LASWI NO 178 BANDUNG INDONESIA'),
(2, 'PT INTI TECH INDONESIA', '02178374834', 'JL SUDIRMAN NO 78 JAKARTA SELATAN'),
(3, 'PT MAS SINAR JAYA KOMPUTER', '022563456354', 'JL IBRAHIM ADJIE NO 122 BANDUNG');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `trans_no` int(11) NOT NULL,
  `qty_total` int(11) NOT NULL,
  `price_total` int(11) NOT NULL,
  `pay_amount` int(11) NOT NULL,
  `trans_date` date NOT NULL,
  `type_trans` enum('1','2') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction_details`
--

CREATE TABLE `transaction_details` (
  `id` int(11) NOT NULL,
  `trans_no` varchar(255) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_price_buy` int(11) NOT NULL,
  `item_price_sale` int(11) NOT NULL,
  `item_qty` int(11) NOT NULL,
  `amount_total` int(11) NOT NULL,
  `trans_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_item`
--

CREATE TABLE `type_item` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_item`
--

INSERT INTO `type_item` (`id`, `name`, `description`) VALUES
(1, 'CABLE', 'CABLE DESCRIPTION'),
(2, 'FIBER OPTIK', 'FIBER OPTIK DESCRIPTION'),
(3, 'MOUSE', 'MOUSE DESCRIPTION'),
(4, 'HARDISK', 'HARDISK DESCRIPTION'),
(5, 'MONITOR', 'MONITOR DESCRIPTION'),
(6, 'SSD', 'STATE SOLID DRIVE'),
(7, 'MODEM', 'MODEM DESCRIPTION'),
(8, 'LAPTOP', 'LAPTOP DESCRIPTION'),
(9, 'MOTHERBOARD', 'MOTHERBOARD DESCIPTION'),
(10, 'SOFTWARE', 'SOFTWARE DESCRIPTION'),
(11, 'KEYBOARD', 'KEYBOARD DESCRIPTION'),
(12, 'WIFI CARD', 'WIFI CARD DESCRIPTION'),
(13, 'SOUND CARD', 'SOUND CARD DESCRIPTION'),
(14, 'VGA CARD', 'VGA CARD DESCRIPTION'),
(15, 'MEMORY', 'MEMORY DESCRIPTION');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nik` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `birth_of_date` date NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `nik`, `name`, `username`, `password`, `birth_of_date`, `phone`, `address`, `role`) VALUES
(1, 19070001, 'Rangga Darmajati', 'rangga', 'rangga', '1992-11-21', '085721731478', 'Munjul Komp. BSI 3 Blok G no 20 Baleendah Kab. Bandung', 'ADMIN'),
(3, 19070003, 'Taka Hiro', 'taka', 'taka', '1991-11-21', '087364736464', 'Alamsjahasdg Taka Hirao Motirta', 'USER'),
(4, 19070004, 'Toru Kurokawa', 'toru', 'toru', '1992-11-21', '08565327573624', 'Jl Soekarno Hatta no 789 Bandung Indonesia', 'USER'),
(5, 19070005, 'Elista Tia Rachmawati', 'elista', 'elista', '1994-01-07', '082237873837', 'Jl Laswie Biru No 128 Baleendah Bandung Indonesia', 'ADMIN'),
(6, 19070006, 'Baru', 'baru', 'baru', '2019-07-05', '0832978324', 'alamat baru', 'USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction_details`
--
ALTER TABLE `transaction_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_item`
--
ALTER TABLE `type_item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_nik` (`nik`),
  ADD UNIQUE KEY `unique_username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transaction_details`
--
ALTER TABLE `transaction_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_item`
--
ALTER TABLE `type_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
