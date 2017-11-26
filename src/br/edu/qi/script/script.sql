/**
 * Criação do banco e tabelas do projeto.
 *
 * Author:  Marcelo Zilio Correa
 * Created: 22/11/2017
 */
CREATE DATABASE `n2`;

USE `n2`;

CREATE TABLE `proprietario` (
  `idProprietario` int(11) AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `cidade` varchar(60) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `telefone` varchar(14) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`idProprietario`)
);

CREATE TABLE `automovel` (
  `idAutomovel` int(11) AUTO_INCREMENT,
  `idProprietario` int(11) NOT NULL,
  `ano` varchar(10) NOT NULL,
  `marca` varchar(60) NOT NULL,
  `modelo` varchar(60) NOT NULL,
  `cor` varchar(40) NOT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  `estado` varchar(5) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `acessorios` varchar(150) DEFAULT NULL,
  `vendido` int(1) NOT NULL,
  PRIMARY KEY (`idAutomovel`),
  FOREIGN KEY (`idProprietario`) REFERENCES `proprietario` (`idProprietario`)
);

CREATE TABLE `cliente` (
  `idCliente` int(11) AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `cidade` varchar(60) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `telefone` varchar(14) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`idCliente`)
);

CREATE TABLE `venda` (
  `idVenda` int(11) AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `idAutomovel` int(11) NOT NULL,
  `dataVenda` datetime NOT NULL,
  `valor` decimal(10,5) NOT NULL,
  `qtdParcelas` int(2), 
  `aVista` int(1),
  PRIMARY KEY (`idVenda`),
  FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  FOREIGN KEY (`idAutomovel`) REFERENCES `automovel` (`idAutomovel`)
);

CREATE TABLE `parcela` (
  `idParcela` int(11) AUTO_INCREMENT,
  `sq_parcela` int NOT NULL,
  `idVenda` int(11) NOT NULL,
  `valor` decimal(10,5) NOT NULL,
  `multa` decimal(10,5),
  `dataParcela` date NOT NULL,
  `dataPgto` date,
  `pago` int NOT NULL,
  PRIMARY KEY (`idParcela`, `sq_parcela`),
  FOREIGN KEY (`idVenda`) REFERENCES `venda` (`idVenda`)
);