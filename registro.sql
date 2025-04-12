-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 12, 2025 at 07:44 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `registro_usuario`
--

-- --------------------------------------------------------

--
-- Table structure for table `registro`
--

CREATE TABLE `registro` (
  `usuario` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `contrasena` varchar(60) NOT NULL,
  `rol` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registro`
--

INSERT INTO `registro` (`usuario`, `telefono`, `correo`, `contrasena`, `rol`) VALUES
('Alexander Chavarria', '34679876', 'alex@gmail.com', 'alex123', 'Paciente'),
('AngrodTralari', '12457856', 'angrod@gmail.com', 'angrod123', 'Paciente'),
('Elena Quesada', '23678956', 'elena@gmail.com', 'elena1234', 'Paciente'),
('Fernanda Fajardo', '83713634', 'fer@gmail.com', 'fer123', 'Médico'),
('Henry Arias', '67123456', 'henrya@gmail.com', 'henrya123', 'Médico'),
('Ivannia Chavarria', '98235681', 'iva@gmail.com', 'iva123456', 'Médico'),
('Jasmin Lopez', '34561233', 'jaz12@gmail.com', 'jas1234', 'Paciente'),
('Jenaro Maltez', '34561236', 'jenaro@gmail.com', 'jenaro123', 'Paciente'),
('Kristel Fajardo', '23456789', 'kris@gmail.com', 'kris123', 'Paciente'),
('Mariana Fajardo', '23457890', 'mariana@gmail.com', 'mariana123', 'Paciente'),
('Mario Chavez', '67234590', 'mchavez@gmail.com', 'mchavez123', 'Médico'),
('Martin Gomez', '34783456', 'martin@gmail.com', 'martin123', 'Médico'),
('Odilie Fajardo', '12567890', 'odi@gmail.com', 'odilie123', 'Paciente'),
('Pilar Gomez', '78989898', 'pilga@gmail.com', 'pili123', 'Paciente'),
('Violet Anderson', '23679012', 'vanderson@gmail.com', 'violeta123', 'Médico');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`usuario`),
  ADD UNIQUE KEY `correo` (`correo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
