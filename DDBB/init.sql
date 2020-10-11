create database bdRegistro;
use bdRegistro;

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `usuario` VALUES (1,'Maria','Perez'),(2,'Juan','Gorosito'),(3,'Maria','Fernandez'),(4,'Francisco','Fernandez'),(5,'Pepe','Casas'),(6,'Maria','Sanchez'),(7,'Julio','Fernandez'),(8,'Federico','Perez'),(9,'Federico 2','Perez 2'),(10,'Maria','Gimenez');

DROP PROCEDURE IF EXISTS `crearUsuario`;
DELIMITER $

CREATE PROCEDURE `crearUsuario` (IN Unombre varchar(45), IN Uapellido varchar(45))
BEGIN
	INSERT INTO usuario(nombre,apellido) VALUES (Unombre,Uapellido);
END $
DELIMITER ;