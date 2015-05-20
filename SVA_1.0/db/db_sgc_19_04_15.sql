CREATE DATABASE  IF NOT EXISTS `db_sgc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_sgc`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: db_sgc
-- ------------------------------------------------------
-- Server version	5.6.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrativo`
--

DROP TABLE IF EXISTS `administrativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrativo` (
  `idadministrativo` bigint(20) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(80) DEFAULT NULL,
  `dependencia` varchar(80) DEFAULT NULL,
  `id_persona` bigint(20) NOT NULL,
  `condicion_laboral` varchar(30) DEFAULT NULL COMMENT 'Nombrado, contratado, CAS',
  `nivel_estudios` varchar(40) DEFAULT NULL COMMENT 'Superior universitario, Superior tecnico, secundaria completa, primaria completa, otro',
  PRIMARY KEY (`idadministrativo`),
  KEY `foreign_key01` (`id_persona`),
  CONSTRAINT `administrativo_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrativo`
--

LOCK TABLES `administrativo` WRITE;
/*!40000 ALTER TABLE `administrativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `idalumno` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) NOT NULL,
  `serie` varchar(10) DEFAULT NULL,
  `fecha_ingreso` datetime DEFAULT NULL,
  `id_persona` bigint(20) NOT NULL,
  PRIMARY KEY (`idalumno`),
  KEY `foreign_key01` (`id_persona`),
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autoevaluacion`
--

DROP TABLE IF EXISTS `autoevaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autoevaluacion` (
  `idautoevaluacion` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_unidadacademica` bigint(20) NOT NULL,
  `id_modelocalidad` bigint(20) NOT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `titulo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idautoevaluacion`),
  KEY `foreign_key01` (`id_unidadacademica`),
  KEY `foreign_key02` (`id_modelocalidad`),
  CONSTRAINT `autoevaluacion_ibfk_1` FOREIGN KEY (`id_unidadacademica`) REFERENCES `unidad_academica` (`idunidadacademica`),
  CONSTRAINT `autoevaluacion_ibfk_2` FOREIGN KEY (`id_modelocalidad`) REFERENCES `modelo_calidad` (`idmodelocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autoevaluacion`
--

LOCK TABLES `autoevaluacion` WRITE;
/*!40000 ALTER TABLE `autoevaluacion` DISABLE KEYS */;
INSERT INTO `autoevaluacion` VALUES (1,18,4,'2014-09-14 19:00:00','2015-06-08 19:00:00',1,'PROCESO DE AUTOEVALUACION-2015'),(2,18,3,NULL,NULL,1,'zxc'),(3,18,3,'2015-04-10 00:29:01','2015-04-10 00:29:01',1,'Proceso de Autoevaluacion 2015'),(5,18,3,'2015-04-10 00:33:31','2015-04-10 00:33:31',1,'Proceso de Autoevaluacion 2015'),(6,18,3,'2015-04-10 00:34:04','2015-04-10 00:34:04',1,'Proceso de Autoevaluacion 2015');
/*!40000 ALTER TABLE `autoevaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comite_interno`
--

DROP TABLE IF EXISTS `comite_interno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comite_interno` (
  `idcomiteinterno` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `doc_ref` varchar(100) DEFAULT NULL,
  `id_unidad_academica` bigint(20) NOT NULL,
  PRIMARY KEY (`idcomiteinterno`),
  KEY `foreign_key01` (`id_unidad_academica`),
  CONSTRAINT `comite_interno_ibfk_1` FOREIGN KEY (`id_unidad_academica`) REFERENCES `unidad_academica` (`idunidadacademica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comite_interno`
--

LOCK TABLES `comite_interno` WRITE;
/*!40000 ALTER TABLE `comite_interno` DISABLE KEYS */;
/*!40000 ALTER TABLE `comite_interno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criterio`
--

DROP TABLE IF EXISTS `criterio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `criterio` (
  `idcriterio` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_factor` bigint(20) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `titulo` varchar(200) DEFAULT NULL,
  `descripcion` text,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idcriterio`),
  KEY `foreign_key01` (`id_factor`),
  CONSTRAINT `criterio_ibfk_1` FOREIGN KEY (`id_factor`) REFERENCES `factor` (`idfactor`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criterio`
--

LOCK TABLES `criterio` WRITE;
/*!40000 ALTER TABLE `criterio` DISABLE KEYS */;
INSERT INTO `criterio` VALUES (8,5,45,'dfg','dfg',1),(9,6,1,'Organización, dirección y control','',1),(10,7,4,'Estrategias de enseñanza - aprendizaje','',1);
/*!40000 ALTER TABLE `criterio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuestionario`
--

DROP TABLE IF EXISTS `cuestionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuestionario` (
  `idcuestionario` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_autoevaluacion` bigint(20) NOT NULL,
  `titulo_cuestionario` varchar(300) DEFAULT NULL,
  `fecha_hora_inicio` datetime DEFAULT NULL,
  `fecha_hora_fin` datetime DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idcuestionario`),
  KEY `foreign_key01` (`id_autoevaluacion`),
  CONSTRAINT `cuestionario_ibfk_1` FOREIGN KEY (`id_autoevaluacion`) REFERENCES `autoevaluacion` (`idautoevaluacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuestionario`
--

LOCK TABLES `cuestionario` WRITE;
/*!40000 ALTER TABLE `cuestionario` DISABLE KEYS */;
INSERT INTO `cuestionario` VALUES (1,1,'CUESTIONARIO PARA DOCENTES','2015-03-01 19:00:00','2015-03-25 19:00:00',1);
/*!40000 ALTER TABLE `cuestionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dimension`
--

DROP TABLE IF EXISTS `dimension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dimension` (
  `iddimension` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_modelocalidad` bigint(20) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `titulo` varchar(180) DEFAULT NULL,
  `descripcion` varchar(600) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`iddimension`),
  KEY `foreign_key01` (`id_modelocalidad`),
  CONSTRAINT `dimension_ibfk_1` FOREIGN KEY (`id_modelocalidad`) REFERENCES `modelo_calidad` (`idmodelocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dimension`
--

LOCK TABLES `dimension` WRITE;
/*!40000 ALTER TABLE `dimension` DISABLE KEYS */;
INSERT INTO `dimension` VALUES (2,3,2,'aaaa','SDSDSD',1),(3,4,1,'Gestión de la carrera','',1),(4,4,2,'Formacion profesional','',1);
/*!40000 ALTER TABLE `dimension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docente` (
  `iddocente` bigint(20) NOT NULL AUTO_INCREMENT,
  `grado_academico` varchar(60) DEFAULT NULL,
  `id_persona` bigint(20) DEFAULT NULL,
  `condicion` varchar(15) DEFAULT NULL COMMENT 'Nombrado, Contratado',
  `categoria` varchar(20) DEFAULT NULL COMMENT 'Auxiliar, asociado, principal y jefe de practica',
  PRIMARY KEY (`iddocente`),
  KEY `foreign_key01` (`id_persona`),
  CONSTRAINT `docente_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egresado`
--

DROP TABLE IF EXISTS `egresado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `egresado` (
  `idegresado` bigint(20) NOT NULL AUTO_INCREMENT,
  `anio_egreso` int(11) DEFAULT NULL,
  `id_persona` bigint(20) NOT NULL,
  PRIMARY KEY (`idegresado`),
  KEY `foreign_key01` (`id_persona`),
  CONSTRAINT `egresado_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresado`
--

LOCK TABLES `egresado` WRITE;
/*!40000 ALTER TABLE `egresado` DISABLE KEYS */;
/*!40000 ALTER TABLE `egresado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encuesta`
--

DROP TABLE IF EXISTS `encuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encuesta` (
  `idencuesta` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_autoevaluacion` bigint(20) NOT NULL,
  `titulo_encuesta` varchar(200) DEFAULT NULL,
  `fecha_hora_inicio` datetime DEFAULT NULL,
  `fecha_hora_fin` datetime DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL COMMENT 'Almacena la fecha de creacion de la encuesta',
  `agradecimiento` text COMMENT 'Agrademiento por responder las preguntas de la encuesta',
  `tipo_usuario` varchar(25) DEFAULT NULL COMMENT 'A quien esta dirigido la encuesta',
  `id_usuario` bigint(20) DEFAULT NULL COMMENT 'Almacenar internamenete quien crea la encuesta',
  `tipo_encuestado` varchar(20) DEFAULT NULL COMMENT 'Alumno, docente ....etc',
  PRIMARY KEY (`idencuesta`),
  KEY `foreign_key01` (`id_autoevaluacion`),
  CONSTRAINT `encuesta_ibfk_1` FOREIGN KEY (`id_autoevaluacion`) REFERENCES `autoevaluacion` (`idautoevaluacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuesta`
--

LOCK TABLES `encuesta` WRITE;
/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
INSERT INTO `encuesta` VALUES (1,1,'aaaa','2015-03-02 19:00:00','2015-03-18 19:00:00',1,'aaa',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `encuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estandar`
--

DROP TABLE IF EXISTS `estandar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estandar` (
  `idestandar` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_criterio` bigint(20) NOT NULL,
  `id_unidadacademica` bigint(20) NOT NULL,
  `numero_estandar` int(11) DEFAULT NULL,
  `titulo` text,
  `descripcion` text,
  `tipo_estandar` varchar(20) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idestandar`),
  KEY `foreign_key01` (`id_criterio`),
  CONSTRAINT `estandar_ibfk_1` FOREIGN KEY (`id_criterio`) REFERENCES `criterio` (`idcriterio`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estandar`
--

LOCK TABLES `estandar` WRITE;
/*!40000 ALTER TABLE `estandar` DISABLE KEYS */;
INSERT INTO `estandar` VALUES (3,8,0,45,'dfg','dfggggggggggggggggggvvvvv','Satisfacción',1),(4,9,0,8,'La unidad académica tiene un sistema de gestión de calidad implementado','','Sistémico',1),(5,10,0,29,'Los estudiantes estan de acuerdo con las estrategias aplicadas de enseñanza - aprendizaje','','Satisfacción',1),(6,10,0,30,'Los estudiantes estan de acuerdo con las estrategias apliacas para desarrollar su capacidad de investigación, en cuanto a generación de conocimientos y aplicación de los ya existentes','','Satisfacción',1);
/*!40000 ALTER TABLE `estandar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factor`
--

DROP TABLE IF EXISTS `factor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factor` (
  `idfactor` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_dimension` bigint(20) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `titulo` varchar(600) DEFAULT NULL,
  `descripcion` text,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idfactor`),
  KEY `foreign_key01` (`id_dimension`),
  CONSTRAINT `factor_ibfk_1` FOREIGN KEY (`id_dimension`) REFERENCES `dimension` (`iddimension`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factor`
--

LOCK TABLES `factor` WRITE;
/*!40000 ALTER TABLE `factor` DISABLE KEYS */;
INSERT INTO `factor` VALUES (5,2,12,'sd','sdsdasdasd',1),(6,3,1,'Planificación, organización, dirección y control','',1),(7,4,2,'Enseñanaza - aprendizaje','',1);
/*!40000 ALTER TABLE `factor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facultad`
--

DROP TABLE IF EXISTS `facultad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facultad` (
  `idfacultad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) DEFAULT NULL,
  `id_universidad` bigint(20) NOT NULL,
  PRIMARY KEY (`idfacultad`),
  KEY `foreign_key01` (`id_universidad`),
  CONSTRAINT `facultad_ibfk_1` FOREIGN KEY (`id_universidad`) REFERENCES `universidad` (`iduniversidad`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facultad`
--

LOCK TABLES `facultad` WRITE;
/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
INSERT INTO `facultad` VALUES (25,'INGENIERÍA DE MINAS, GEOLOGÍA Y CIVIL',86),(26,'Facultad de obstetricia',86),(27,'Facultad de enfermeria',86);
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_interes`
--

DROP TABLE IF EXISTS `grupo_interes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_interes` (
  `idgrupointeres` bigint(20) NOT NULL AUTO_INCREMENT,
  `institucion` varchar(80) DEFAULT NULL,
  `cargo` varchar(80) DEFAULT NULL,
  `id_persona` bigint(20) NOT NULL,
  PRIMARY KEY (`idgrupointeres`),
  KEY `foreign_key01` (`id_persona`),
  CONSTRAINT `grupo_interes_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_interes`
--

LOCK TABLES `grupo_interes` WRITE;
/*!40000 ALTER TABLE `grupo_interes` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo_interes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iniciativa_mejora`
--

DROP TABLE IF EXISTS `iniciativa_mejora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iniciativa_mejora` (
  `idiniciativa` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_estandar` bigint(20) NOT NULL,
  `id_autoevaluacion` bigint(20) NOT NULL,
  `alternativa_solucion_consensuada` text,
  `estado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idiniciativa`),
  KEY `foreign_key01` (`id_estandar`),
  KEY `foreign_key02` (`id_autoevaluacion`),
  CONSTRAINT `iniciativa_mejora_ibfk_1` FOREIGN KEY (`id_estandar`) REFERENCES `estandar` (`idestandar`),
  CONSTRAINT `iniciativa_mejora_ibfk_2` FOREIGN KEY (`id_autoevaluacion`) REFERENCES `autoevaluacion` (`idautoevaluacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iniciativa_mejora`
--

LOCK TABLES `iniciativa_mejora` WRITE;
/*!40000 ALTER TABLE `iniciativa_mejora` DISABLE KEYS */;
/*!40000 ALTER TABLE `iniciativa_mejora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matriz_recoleccion_datos`
--

DROP TABLE IF EXISTS `matriz_recoleccion_datos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matriz_recoleccion_datos` (
  `idmatriz` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_estandar` bigint(20) NOT NULL,
  `id_autoevaluacion` bigint(20) NOT NULL,
  `fecha_registro` date DEFAULT NULL,
  `resultado_comite_interno` int(11) DEFAULT NULL,
  `resultado_encuesta_docente` int(11) DEFAULT NULL,
  `resultado_encuesta_administrativo` int(11) DEFAULT NULL,
  `resultado_encuesta_egresado` int(11) DEFAULT NULL,
  `resultado_encuesta_estudiante` int(11) DEFAULT NULL,
  `resultado_encuesta_grupoint` int(11) DEFAULT NULL,
  `resultado_cuestionario` int(11) DEFAULT NULL,
  `resultado_informe_sgc` int(11) DEFAULT NULL,
  `resultado_final` tinyint(1) NOT NULL COMMENT 'pasa a ser analizado o no',
  `observacion` text,
  `estado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idmatriz`),
  KEY `foreign_key01` (`id_estandar`),
  KEY `foreign_key02` (`id_autoevaluacion`),
  CONSTRAINT `matriz_recoleccion_datos_ibfk_1` FOREIGN KEY (`id_estandar`) REFERENCES `estandar` (`idestandar`),
  CONSTRAINT `matriz_recoleccion_datos_ibfk_2` FOREIGN KEY (`id_autoevaluacion`) REFERENCES `autoevaluacion` (`idautoevaluacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matriz_recoleccion_datos`
--

LOCK TABLES `matriz_recoleccion_datos` WRITE;
/*!40000 ALTER TABLE `matriz_recoleccion_datos` DISABLE KEYS */;
/*!40000 ALTER TABLE `matriz_recoleccion_datos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro_comite_interno`
--

DROP TABLE IF EXISTS `miembro_comite_interno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miembro_comite_interno` (
  `idcomision` bigint(20) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(80) DEFAULT NULL,
  `id_persona` bigint(20) NOT NULL,
  `fecha_desde` date DEFAULT NULL,
  `fecha_hasta` date DEFAULT NULL,
  `id_comite_interno` bigint(20) NOT NULL,
  PRIMARY KEY (`idcomision`),
  KEY `foreign_key01` (`id_persona`),
  KEY `foreign_key02` (`id_comite_interno`),
  CONSTRAINT `miembro_comite_interno_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`),
  CONSTRAINT `miembro_comite_interno_ibfk_2` FOREIGN KEY (`id_comite_interno`) REFERENCES `comite_interno` (`idcomiteinterno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro_comite_interno`
--

LOCK TABLES `miembro_comite_interno` WRITE;
/*!40000 ALTER TABLE `miembro_comite_interno` DISABLE KEYS */;
/*!40000 ALTER TABLE `miembro_comite_interno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo_calidad`
--

DROP TABLE IF EXISTS `modelo_calidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo_calidad` (
  `idmodelocalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(180) DEFAULT NULL,
  `resolucion` varchar(20) DEFAULT NULL,
  `fecha_publicacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idmodelocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo_calidad`
--

LOCK TABLES `modelo_calidad` WRITE;
/*!40000 ALTER TABLE `modelo_calidad` DISABLE KEYS */;
INSERT INTO `modelo_calidad` VALUES (3,'Ingenieria','2014','2014-10-13 00:00:00'),(4,'Modelo de Calidad para la Acreditación de las Carreras Profesionales Universitarias','RM 01','2014-11-03 00:00:00');
/*!40000 ALTER TABLE `modelo_calidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(60) DEFAULT NULL,
  `apellido_paterno` varchar(60) DEFAULT NULL,
  `apellido_materno` varchar(60) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `id_unidad_academica` bigint(20) NOT NULL,
  `sexo` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  KEY `foreign_key01` (`id_unidad_academica`),
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_unidad_academica`) REFERENCES `unidad_academica` (`idunidadacademica`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (22,'Jorge Luis','Sulca','Gonzalez','44038362','999188003','jlsulcag@gmail.com',18,'M'),(23,'as','as','as','12345678','123456','',18,'F'),(24,'xzc','zxc','zxc','zxc','','',18,NULL),(25,'Andres','Sulca','Gonzalez','15896532','','',18,'M');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta_cuestionario`
--

DROP TABLE IF EXISTS `pregunta_cuestionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregunta_cuestionario` (
  `idpreguntacuestionario` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_cuestionario` bigint(20) NOT NULL,
  `id_estandar` bigint(20) NOT NULL,
  `pregunta` text,
  `ayuda` text,
  PRIMARY KEY (`idpreguntacuestionario`),
  KEY `foreign_key01` (`id_cuestionario`),
  KEY `foreign_key02` (`id_estandar`),
  CONSTRAINT `pregunta_cuestionario_ibfk_1` FOREIGN KEY (`id_cuestionario`) REFERENCES `cuestionario` (`idcuestionario`),
  CONSTRAINT `pregunta_cuestionario_ibfk_2` FOREIGN KEY (`id_estandar`) REFERENCES `estandar` (`idestandar`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta_cuestionario`
--

LOCK TABLES `pregunta_cuestionario` WRITE;
/*!40000 ALTER TABLE `pregunta_cuestionario` DISABLE KEYS */;
INSERT INTO `pregunta_cuestionario` VALUES (1,1,4,'asd',NULL),(2,1,5,'hjhk',NULL);
/*!40000 ALTER TABLE `pregunta_cuestionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta_encuesta`
--

DROP TABLE IF EXISTS `pregunta_encuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregunta_encuesta` (
  `idpreguntaencuesta` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_encuesta` bigint(20) NOT NULL,
  `id_estandar` bigint(20) NOT NULL,
  `pregunta` text,
  `ayuda` text,
  PRIMARY KEY (`idpreguntaencuesta`),
  KEY `foreign_key01` (`id_encuesta`),
  KEY `foreign_key02` (`id_estandar`),
  CONSTRAINT `pregunta_encuesta_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`idencuesta`),
  CONSTRAINT `pregunta_encuesta_ibfk_2` FOREIGN KEY (`id_estandar`) REFERENCES `estandar` (`idestandar`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta_encuesta`
--

LOCK TABLES `pregunta_encuesta` WRITE;
/*!40000 ALTER TABLE `pregunta_encuesta` DISABLE KEYS */;
INSERT INTO `pregunta_encuesta` VALUES (1,1,4,'¿como ...?',NULL),(2,1,5,'¿Cual es la forma adecuada ...?',NULL);
/*!40000 ALTER TABLE `pregunta_encuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_grado_cumplimiento`
--

DROP TABLE IF EXISTS `registro_grado_cumplimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_grado_cumplimiento` (
  `idgradocumplimiento` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_estandar` bigint(20) NOT NULL,
  `id_autoevalucion` bigint(20) NOT NULL,
  `cumplimiento` tinyint(1) DEFAULT NULL,
  `explicacion_consolidada` text,
  `estado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idgradocumplimiento`),
  KEY `foreign_key01` (`id_estandar`),
  KEY `foreign_key02` (`id_autoevalucion`),
  CONSTRAINT `registro_grado_cumplimiento_ibfk_1` FOREIGN KEY (`id_estandar`) REFERENCES `estandar` (`idestandar`),
  CONSTRAINT `registro_grado_cumplimiento_ibfk_2` FOREIGN KEY (`id_autoevalucion`) REFERENCES `autoevaluacion` (`idautoevaluacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_grado_cumplimiento`
--

LOCK TABLES `registro_grado_cumplimiento` WRITE;
/*!40000 ALTER TABLE `registro_grado_cumplimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_grado_cumplimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_resultado`
--

DROP TABLE IF EXISTS `registro_resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_resultado` (
  `idregistroresultado` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_estandar` bigint(20) NOT NULL,
  `id_autoevaluacion` bigint(20) NOT NULL,
  `fecha_taller` date DEFAULT NULL,
  `explicacion_consolidada` text,
  `alternativa_solucion_consolidada` text,
  `estado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idregistroresultado`),
  KEY `foreign_key01` (`id_estandar`),
  KEY `foreign_key02` (`id_autoevaluacion`),
  CONSTRAINT `registro_resultado_ibfk_1` FOREIGN KEY (`id_estandar`) REFERENCES `estandar` (`idestandar`),
  CONSTRAINT `registro_resultado_ibfk_2` FOREIGN KEY (`id_autoevaluacion`) REFERENCES `autoevaluacion` (`idautoevaluacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_resultado`
--

LOCK TABLES `registro_resultado` WRITE;
/*!40000 ALTER TABLE `registro_resultado` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta_cuestionario`
--

DROP TABLE IF EXISTS `respuesta_cuestionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta_cuestionario` (
  `idrespuestacuestionario` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_preguntacuestionario` bigint(20) NOT NULL,
  `id_docente` bigint(20) NOT NULL,
  `respuesta` varchar(3) DEFAULT NULL,
  `explicacion_docente` text,
  `alternativa_solucion_docente` text,
  `fecha_hora` datetime DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idrespuestacuestionario`),
  KEY `foreign_key01` (`id_preguntacuestionario`),
  KEY `foreign_key02` (`id_docente`),
  CONSTRAINT `respuesta_cuestionario_ibfk_2` FOREIGN KEY (`id_docente`) REFERENCES `docente` (`iddocente`),
  CONSTRAINT `respuesta_cuestionario_ibfk_1` FOREIGN KEY (`id_preguntacuestionario`) REFERENCES `pregunta_cuestionario` (`idpreguntacuestionario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta_cuestionario`
--

LOCK TABLES `respuesta_cuestionario` WRITE;
/*!40000 ALTER TABLE `respuesta_cuestionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuesta_cuestionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta_encuesta`
--

DROP TABLE IF EXISTS `respuesta_encuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta_encuesta` (
  `idrespuestaencuesta` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_preguntaencuesta` bigint(20) NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `respuesta` varchar(3) DEFAULT NULL,
  `fecha_hora` datetime DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idrespuestaencuesta`),
  KEY `foreign_key01` (`id_preguntaencuesta`),
  KEY `foreign_key02` (`id_usuario`),
  CONSTRAINT `respuesta_encuesta_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `respuesta_encuesta_ibfk_1` FOREIGN KEY (`id_preguntaencuesta`) REFERENCES `pregunta_encuesta` (`idpreguntaencuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta_encuesta`
--

LOCK TABLES `respuesta_encuesta` WRITE;
/*!40000 ALTER TABLE `respuesta_encuesta` DISABLE KEYS */;
INSERT INTO `respuesta_encuesta` VALUES (1,1,NULL,'DA',NULL,NULL),(2,1,NULL,'DA',NULL,NULL);
/*!40000 ALTER TABLE `respuesta_encuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idrol` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(40) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (4,'Administrativo',1),(5,'Alumno',1),(10,'Comisión interna',1),(11,'Docente',1),(12,'Egresado',1),(13,'Grupo de interés',1),(14,'Administrador',1);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_academica`
--

DROP TABLE IF EXISTS `unidad_academica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_academica` (
  `idunidadacademica` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_facultad` bigint(20) NOT NULL,
  `nombre` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`idunidadacademica`),
  KEY `foreign_key01` (`id_facultad`),
  CONSTRAINT `unidad_academica_ibfk_1` FOREIGN KEY (`id_facultad`) REFERENCES `facultad` (`idfacultad`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_academica`
--

LOCK TABLES `unidad_academica` WRITE;
/*!40000 ALTER TABLE `unidad_academica` DISABLE KEYS */;
INSERT INTO `unidad_academica` VALUES (18,25,'ESCUELA DE FORMACIÓN PROFESIONAL DE INGENIERÍA DE SISTEMAS'),(19,26,'obstetricia'),(20,27,'Enfermeria');
/*!40000 ALTER TABLE `unidad_academica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `universidad`
--

DROP TABLE IF EXISTS `universidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `universidad` (
  `iduniversidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`iduniversidad`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `universidad`
--

LOCK TABLES `universidad` WRITE;
/*!40000 ALTER TABLE `universidad` DISABLE KEYS */;
INSERT INTO `universidad` VALUES (86,'UNIVERSIDAD NACIONAL DE SAN CRISTÓBAL DE HUAMANGA'),(87,'UNIVERSIDAD NACIONAL MAYOR DE SAN MARCOS');
/*!40000 ALTER TABLE `universidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_persona` bigint(20) NOT NULL,
  `nombre_usuario` varchar(60) DEFAULT NULL,
  `contrasenia` varchar(60) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idusuario`),
  KEY `foreign_key01` (`id_persona`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (19,22,'jlsulcag','kokito',NULL,NULL,1),(20,23,'as','as',NULL,NULL,0),(21,24,'sad','asd',NULL,NULL,0),(22,25,'alumno','alumno',NULL,NULL,0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_rol` (
  `idusuariorol` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_rol` bigint(20) NOT NULL,
  `id_usuario` bigint(20) NOT NULL,
  PRIMARY KEY (`idusuariorol`),
  KEY `foreign_key01` (`id_rol`),
  KEY `foreign_key02` (`id_usuario`),
  CONSTRAINT `usuario_rol_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`idrol`),
  CONSTRAINT `usuario_rol_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,14,19),(2,10,20),(3,4,21),(4,5,22);
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_sgc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-19 23:21:02
