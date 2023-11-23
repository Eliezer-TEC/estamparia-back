DROP DATABASE IF EXISTS DBESTAMPARIA;
CREATE DATABASE DBESTAMPARIA;
USE DBESTAMPARIA;

CREATE TABLE `DBESTAMPARIA`.`MODELO`(
 `ID` INT NOT NULL auto_increment,
 `VALOR_VENDA` double NOT NULL,
`DT_CADASTRO` DATE NOT NULL,
`DT_FIM_VIGENCIA` DATE NOT NULL,
`CUSTO` DOUBLE NOT NULL,
primary key(`ID`)
);

CREATE TABLE `DBESTAMPARIA`.`ENDERECO`(
	`ID` INT NOT NULL auto_increment,
    `RUA` VARCHAR(40) NOT NULL,
    `BAIRRO` VARCHAR(40) NOT NULL,
    `CEP` VARCHAR(9) NOT NULL,
    `NUMERO` VARCHAR(5) NOT NULL,
    `CIDADE` VARCHAR (40) NOT NULL,
    `ESTADO` VARCHAR(40) NOT NULL,
    primary key (`ID`)
);

CREATE TABLE `DBESTAMPARIA`.`CAMISA`(
	`ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `TAMANHO` CHAR(4) NOT NULL,
    `COR` VARCHAR(20) NOT NULL,
    `ESTAMPA` blob NOT NULL,
    `ID_MODELO` INT NOT NULL,
    `NOME_ARQUIVO` VARCHAR(30) NOT NULL,
	CONSTRAINT ID_MODELO
    FOREIGN KEY (ID_MODELO)
    REFERENCES DBESTAMPARIA.MODELO (id)
	ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 

 
 CREATE TABLE `DBESTAMPARIA`.`PESSOA` (
`ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NOT NULL,
  `CPF` VARCHAR(15) NOT NULL,
  `DT_NASC` DATE NOT NULL,
  `EMAIL` VARCHAR(255) NOT NULL,
  `DDD` VARCHAR(4) NOT NULL,
  `TELEFONE` VARCHAR(15) NOT NULL,
  `SENHA` VARCHAR(255) NOT NULL,
  `FUNCIONARIO` TINYINT NOT NULL,
  `ID_ENDERECO` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT ID_ENDERECO
    FOREIGN KEY (ID_ENDERECO)
    REFERENCES DBESTAMPARIA.ENDERECO (id)
	ON DELETE NO ACTION
    ON UPDATE NO ACTION
  );
  
 
CREATE TABLE `DBESTAMPARIA`.`PEDIDO`(
	`ID` INT NOT NULL AUTO_INCREMENT,
    `ID_PESSOA` INT NOT NULL,
    `ID_CAMISA` INT NOT NULL,
	`STATUS_PEDIDO` VARCHAR(20) NOT NULL,
    `TOTAL` DOUBLE NOT NULL,
    `QUANTIDADE` DOUBLE NOT NULL,
     `ID_ENDERECO` INT NOT NULL,
    PRIMARY KEY (`ID`),
	CONSTRAINT ID_PESSOA
    FOREIGN KEY (ID_PESSOA)
    REFERENCES DBESTAMPARIA.PESSOA (id),
    
    CONSTRAINT ID_CAMISA
    FOREIGN KEY (ID_CAMISA)
    REFERENCES DBESTAMPARIA.CAMISA (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

