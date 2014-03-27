-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-03-2014 a las 14:03:22
-- Versión del servidor: 5.6.12-log
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `kupoi`
--
CREATE DATABASE IF NOT EXISTS `kupoi` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `kupoi`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comercio`
--

CREATE TABLE IF NOT EXISTS `comercio` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `businessName` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `fbid` varchar(250) DEFAULT NULL,
  `password` varchar(250) NOT NULL,
  `registreDate` date DEFAULT NULL,
  `lastLogin` date DEFAULT NULL,
  `country` varchar(250) NOT NULL,
  `fullAddress` varchar(250) NOT NULL,
  `city` varchar(250) NOT NULL,
  `stateOrProvince` varchar(250) NOT NULL,
  `cp` varchar(250) NOT NULL,
  `latitude` decimal(65,0) DEFAULT NULL,
  `longitude` decimal(65,0) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `profileImageUrl` varchar(250) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `franquiciaid` int(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bussinessName` (`businessName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `comercio`
--

INSERT INTO `comercio` (`id`, `businessName`, `email`, `fbid`, `password`, `registreDate`, `lastLogin`, `country`, `fullAddress`, `city`, `stateOrProvince`, `cp`, `latitude`, `longitude`, `description`, `profileImageUrl`, `active`, `franquiciaid`) VALUES
(1, 'Mena Coop', 'axel@coop.es', 'XAFQWfa234##', '86057438fbc6889b91f258c30d1da4db8d71d7c8', NULL, NULL, 'Mena Paradise', 'Calle Mena', 'Menaland', 'Root', '07009', '26', '101', 'Fabricante de menas', 'localhost/a.png', 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cupon`
--

CREATE TABLE IF NOT EXISTS `cupon` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `businessId` int(250) NOT NULL,
  `code` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `dateStart` date NOT NULL,
  `dateExpiration` date NOT NULL,
  `backgroundImageUrl` varchar(250) DEFAULT NULL,
  `price` decimal(65,0) DEFAULT NULL,
  `realPrice` decimal(65,0) DEFAULT NULL,
  `conditions` varchar(250) DEFAULT NULL,
  `availQuota` int(250) NOT NULL,
  `couponImageUrl` varchar(250) NOT NULL,
  `qr` varchar(250) DEFAULT NULL,
  `barcode` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_cupon_comercio` (`businessId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `cupon`
--

INSERT INTO `cupon` (`id`, `businessId`, `code`, `name`, `title`, `description`, `dateStart`, `dateExpiration`, `backgroundImageUrl`, `price`, `realPrice`, `conditions`, `availQuota`, `couponImageUrl`, `qr`, `barcode`) VALUES
(1, 1, 'XGXAsladf5~swa', 'Cosa', 'Cupon inverso', 'Este cupon es una cosa', '2009-02-01', '2009-02-01', 'images/url.png', '100', '50', 'Mayor de 19 años', 1, 'images/cupon.png', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuponesusuario`
--

CREATE TABLE IF NOT EXISTS `cuponesusuario` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `Id_Usuario` int(250) NOT NULL,
  `Id_cupon` int(250) NOT NULL,
  `Fecha_compra` date NOT NULL,
  `Precio` decimal(65,0) NOT NULL,
  `Estado` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_USERID` (`Id_Usuario`),
  UNIQUE KEY `FK_COMERCIOID` (`Id_cupon`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `cuponesusuario`
--

INSERT INTO `cuponesusuario` (`id`, `Id_Usuario`, `Id_cupon`, `Fecha_compra`, `Precio`, `Estado`) VALUES
(1, 1, 1, '2009-02-01', '27', 'Apagado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `franquicia`
--

CREATE TABLE IF NOT EXISTS `franquicia` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `franquiciadoid` int(250) NOT NULL,
  `fulladdress` varchar(250) NOT NULL,
  `cp` varchar(250) NOT NULL,
  `stateorprovince` varchar(250) NOT NULL,
  `city` varchar(250) NOT NULL,
  `latitude` decimal(65,0) DEFAULT NULL,
  `longitude` decimal(65,0) DEFAULT NULL,
  `profileimageurl` varchar(250) DEFAULT NULL,
  `background` varchar(250) DEFAULT NULL,
  `country` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `franquiciadoid` (`franquiciadoid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `franquicia`
--

INSERT INTO `franquicia` (`id`, `name`, `franquiciadoid`, `fulladdress`, `cp`, `stateorprovince`, `city`, `latitude`, `longitude`, `profileimageurl`, `background`, `country`) VALUES
(1, 'Franquisia', 1, 'C/blablabla', '07005', 'Balares', 'ciudad', '26', '26', 'http://images', 'a', 'España');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `franquiciado`
--

CREATE TABLE IF NOT EXISTS `franquiciado` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `nif` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `telefono` varchar(250) NOT NULL,
  `surname` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `fbid` varchar(250) DEFAULT NULL,
  `profileimageurl` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `franquiciado`
--

INSERT INTO `franquiciado` (`id`, `name`, `nif`, `address`, `email`, `telefono`, `surname`, `password`, `fbid`, `profileimageurl`) VALUES
(1, 'name', 'NIF', 'address', 'email', 'telefono', 'surname', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', NULL, NULL),
(2, 'name', 'NIF', 'address', 'correo', '983849', 'surname', 'password', NULL, NULL),
(3, 'name', 'NIF', 'address', 'email2', 'telefono', 'surname', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', NULL, NULL),
(4, 'name', 'NIF', 'address', 'email3', 'telefono', 'surname', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', NULL, NULL),
(5, 'name', 'NIF', 'address', 'email35', 'telefono', 'surname', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', NULL, NULL),
(6, 'name', 'NIF', 'address', 'email35@gmail.com', 'telefono', 'surname', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE IF NOT EXISTS `mensaje` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `from_id` int(250) NOT NULL,
  `to_id` int(250) NOT NULL,
  `fecha_enviado` date NOT NULL,
  `asunto` varchar(250) NOT NULL,
  `mensaje` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_FROMID_MSG` (`from_id`),
  UNIQUE KEY `FK_TOID_MSG` (`to_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`id`, `from_id`, `to_id`, `fecha_enviado`, `asunto`, `mensaje`) VALUES
(1, 1, 1, '2009-02-01', 'a', 'mensaje');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificacion`
--

CREATE TABLE IF NOT EXISTS `notificacion` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `from_id` int(250) NOT NULL,
  `to_id` int(250) NOT NULL,
  `fecha_enviado` date NOT NULL,
  `asunto` varchar(250) NOT NULL,
  `mensaje` varchar(250) NOT NULL,
  `enlace` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_FROMID_USER` (`from_id`),
  UNIQUE KEY `FK_TOID_USER` (`to_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `notificacion`
--

INSERT INTO `notificacion` (`id`, `from_id`, `to_id`, `fecha_enviado`, `asunto`, `mensaje`, `enlace`) VALUES
(1, 1, 1, '2009-02-01', 'a', 'Mensaje', 'a.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `userName` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `fbid` varchar(250) DEFAULT NULL,
  `password` varchar(250) NOT NULL,
  `registerDate` date DEFAULT NULL,
  `lastLogin` date DEFAULT NULL,
  `country` varchar(250) NOT NULL,
  `fullAddress` varchar(250) DEFAULT NULL,
  `city` varchar(250) DEFAULT NULL,
  `stateOrProvince` varchar(250) NOT NULL,
  `cp` varchar(250) DEFAULT NULL,
  `latitude` decimal(65,0) DEFAULT NULL,
  `longitude` decimal(65,0) DEFAULT NULL,
  `profileImageUrl` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `userName`, `email`, `fbid`, `password`, `registerDate`, `lastLogin`, `country`, `fullAddress`, `city`, `stateOrProvince`, `cp`, `latitude`, `longitude`, `profileImageUrl`) VALUES
(1, 'juan', 'kronifacio@gmail.com ', '2', 'yo', '2009-02-01', NULL, ' spain', '2', '2', 'baleares', '56', '21', '101', NULL),
(2, 'Mena', 'axel@axel.es', NULL, '786e986d9f3be89a43901c485bfb528194ca9e3c', NULL, NULL, 'España', NULL, NULL, 'Baleares', NULL, NULL, NULL, NULL);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cupon`
--
ALTER TABLE `cupon`
  ADD CONSTRAINT `FK_CUPON_COMERCIO` FOREIGN KEY (`businessId`) REFERENCES `comercio` (`id`);

--
-- Filtros para la tabla `cuponesusuario`
--
ALTER TABLE `cuponesusuario`
  ADD CONSTRAINT `cuponesusuario_ibfk_2` FOREIGN KEY (`Id_cupon`) REFERENCES `cupon` (`id`),
  ADD CONSTRAINT `cuponesusuario_ibfk_1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `franquicia`
--
ALTER TABLE `franquicia`
  ADD CONSTRAINT `franquicia_ibfk_1` FOREIGN KEY (`franquiciadoid`) REFERENCES `franquiciado` (`id`);

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `mensaje_ibfk_1` FOREIGN KEY (`from_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `mensaje_ibfk_2` FOREIGN KEY (`to_id`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD CONSTRAINT `notificacion_ibfk_1` FOREIGN KEY (`from_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `notificacion_ibfk_2` FOREIGN KEY (`to_id`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
