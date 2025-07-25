-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-07-2025 a las 02:12:05
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parqueo_inteligente`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `vehiculo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `id_vehiculo` int(11) NOT NULL,
  `placa` varchar(20) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `propietario` varchar(100) NOT NULL,
  `color` varchar(30) NOT NULL,
  `espacioAsignado` varchar(20) NOT NULL,
  `horaIngreso` time NOT NULL,
  `horaSalida` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id_vehiculo`, `placa`, `marca`, `tipo`, `propietario`, `color`, `espacioAsignado`, `horaIngreso`, `horaSalida`) VALUES
(1, 'TY7879', 'Honda', 'estandar', 'Maria Zegarra', 'Azul', 'casillaC', '00:33:11', NULL),
(2, 'ED6767', 'Honda', 'estandar', 'Maria Lopez', 'Plateado', 'no asignado', '00:58:45', NULL),
(3, 'T678H', 'Toyota', 'especial', 'Juan Rojas', 'Azul', 'no asignado', '01:00:51', NULL),
(4, 'TY7856', 'Honda', 'especial', 'Marcelo Perez', 'negro', 'no asignado', '01:22:34', NULL),
(6, 'ET77888', 'Suzuki', 'estandar', 'Rosio Lopez', 'Azul', 'no asignado', '12:29:16', NULL),
(7, '1ñ233434', 'rdasldf', 'resdlsa', 'romel', 'red', 'asignado', '12:43:47', NULL),
(8, 'ER6777', 'Toyota', 'estandar', 'Maria', 'azul', 'no asignado', '13:30:56', NULL),
(9, 'TY6777', 'Toyota', 'especial', 'juan Perez', 'negro', 'no asignado', '14:08:14', NULL),
(10, 'TY677U', 'Honda', 'estandar', 'Juan Rojas', 'negro', 'no asignado', '15:26:03', NULL),
(11, '12344', 'nissa{red', 'rodo', 'romel', 'red', 'no asignado', '15:31:11', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`id_vehiculo`),
  ADD UNIQUE KEY `placa` (`placa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
