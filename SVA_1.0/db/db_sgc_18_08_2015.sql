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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuestionario`
--

LOCK TABLES `cuestionario` WRITE;
/*!40000 ALTER TABLE `cuestionario` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`idencuesta`),
  KEY `foreign_key01` (`id_autoevaluacion`),
  CONSTRAINT `encuesta_ibfk_1` FOREIGN KEY (`id_autoevaluacion`) REFERENCES `autoevaluacion` (`idautoevaluacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuesta`
--

LOCK TABLES `encuesta` WRITE;
/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
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
  `resultado_comite_interno` tinyint(1) DEFAULT NULL,
  `resultado_encuesta_docente` tinyint(1) DEFAULT NULL,
  `resultado_encuesta_administrativo` tinyint(1) DEFAULT NULL,
  `resultado_encuesta_egresado` tinyint(1) DEFAULT NULL,
  `resultado_encuesta_estudiante` tinyint(1) DEFAULT NULL,
  `resultado_encuesta_grupoint` tinyint(1) DEFAULT NULL,
  `resultado_cuestionario` tinyint(1) DEFAULT NULL,
  `resultado_informe_sgc` tinyint(1) DEFAULT NULL,
  `resultado_final` tinyint(1) NOT NULL COMMENT 'pasa a ser analizado o no',
  `observacion` text,
  `estado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idmatriz`),
  KEY `foreign_key01` (`id_estandar`),
  KEY `foreign_key02` (`id_autoevaluacion`),
  CONSTRAINT `matriz_recoleccion_datos_ibfk_1` FOREIGN KEY (`id_estandar`) REFERENCES `estandar` (`idestandar`),
  CONSTRAINT `matriz_recoleccion_datos_ibfk_2` FOREIGN KEY (`id_autoevaluacion`) REFERENCES `autoevaluacion` (`idautoevaluacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta_cuestionario`
--

LOCK TABLES `pregunta_cuestionario` WRITE;
/*!40000 ALTER TABLE `pregunta_cuestionario` DISABLE KEYS */;
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
  `tipo_encuesta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idpreguntaencuesta`),
  KEY `foreign_key01` (`id_encuesta`),
  KEY `foreign_key02` (`id_estandar`),
  CONSTRAINT `pregunta_encuesta_ibfk_1` FOREIGN KEY (`id_encuesta`) REFERENCES `encuesta` (`idencuesta`),
  CONSTRAINT `pregunta_encuesta_ibfk_2` FOREIGN KEY (`id_estandar`) REFERENCES `estandar` (`idestandar`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta_encuesta`
--

LOCK TABLES `pregunta_encuesta` WRITE;
/*!40000 ALTER TABLE `pregunta_encuesta` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
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
  CONSTRAINT `respuesta_cuestionario_ibfk_1` FOREIGN KEY (`id_preguntacuestionario`) REFERENCES `pregunta_cuestionario` (`idpreguntacuestionario`),
  CONSTRAINT `respuesta_cuestionario_ibfk_2` FOREIGN KEY (`id_docente`) REFERENCES `docente` (`iddocente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
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
  `fecha_hora` datetime DEFAULT CURRENT_TIMESTAMP,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idrespuestaencuesta`),
  KEY `foreign_key01` (`id_preguntaencuesta`),
  KEY `foreign_key02` (`id_usuario`),
  CONSTRAINT `respuesta_encuesta_ibfk_1` FOREIGN KEY (`id_preguntaencuesta`) REFERENCES `pregunta_encuesta` (`idpreguntaencuesta`),
  CONSTRAINT `respuesta_encuesta_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta_encuesta`
--

LOCK TABLES `respuesta_encuesta` WRITE;
/*!40000 ALTER TABLE `respuesta_encuesta` DISABLE KEYS */;
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
INSERT INTO `rol` VALUES (4,'Administrativo',1),(5,'Alumno',1),(10,'ComisiÃ³n interna',1),(11,'Docente',1),(12,'Egresado',1),(13,'Grupo de interÃ©s',1),(14,'Administrador',1);
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

-- Dump completed on 2015-08-18 10:30:33
