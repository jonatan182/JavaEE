-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-01-2016 a las 16:01:17
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `saludguru`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE IF NOT EXISTS `citas` (
  `idCita` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idMedico` int(11) NOT NULL,
  `horaCita` datetime DEFAULT NULL,
  PRIMARY KEY (`idCita`),
  KEY `idPaciente` (`idPaciente`),
  KEY `idMedico` (`idMedico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcar la base de datos para la tabla `citas`
--

INSERT INTO `citas` (`idCita`, `idPaciente`, `idMedico`, `horaCita`) VALUES
(0, 4, 1, NULL),
(2, 4, 1, '2015-04-10 02:59:00'),
(3, 1, 2, '2015-03-28 02:59:00'),
(4, 1, 2, '2015-03-28 02:59:00'),
(5, 2, 2, '2015-03-28 03:29:00'),
(6, 1, 2, '2015-03-28 02:59:00'),
(7, 1, 3, '2015-03-28 02:59:00'),
(19, 1, 1, '2015-01-10 15:01:00'),
(78, 4, 1, '2015-03-28 02:59:00'),
(89, 3, 2, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE IF NOT EXISTS `medico` (
  `idMedico` int(11) NOT NULL,
  `nombreMedico` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idMedico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcar la base de datos para la tabla `medico`
--

INSERT INTO `medico` (`idMedico`, `nombreMedico`) VALUES
(1, 'Jonatan'),
(2, 'Edisson  Velandia'),
(3, 'Camila Castro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `idPaciente` int(11) NOT NULL,
  `nombrePaciente` varchar(30) DEFAULT NULL,
  `edadPaciente` int(11) DEFAULT NULL,
  `seguro` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcar la base de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombrePaciente`, `edadPaciente`, `seguro`) VALUES
(1, 'Pepe Perez', 56, 'NuevaEps'),
(2, 'Jonatan', 22, 'EPS'),
(3, 'Javier Velandia', 43, 'Colsubsidio'),
(4, 'Sandy', 23, 'Colsanitas'),
(5, 'lll', 70, 'NuevaEps');

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`idMedico`);
