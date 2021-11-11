CREATE DATABASE locadora;
USE locadora;

CREATE TABLE `categoria` (
	`cod_categoria` INT NOT NULL AUTO_INCREMENT,
	`descricao` VARCHAR(50) NULL,
	PRIMARY KEY (`cod_categoria`)
);

CREATE TABLE filme (
	`cod_filme` INT NOT NULL AUTO_INCREMENT,
	`cod_categoria` INT NOT NULL,
	`descricao` VARCHAR(50) NULL,
	`ano` DATE NULL,
	PRIMARY KEY (`cod_filme`),
	CONSTRAINT `fk_filme_cod_categoria`
		FOREIGN KEY (`cod_categoria`)
		REFERENCES `categoria` (`cod_categoria`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE	
);

CREATE TABLE `cliente` (
	`cod_cliente` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(100) NULL,
	`telefone` VARCHAR(50) NULL,
	`celular` VARCHAR(50) NULL,
	`email` VARCHAR(255) NULL,
	PRIMARY KEY (`cod_cliente`)
);

CREATE TABLE `midia` (
	`cod_midia` INT NOT NULL AUTO_INCREMENT,
	`cod_filme` INT NOT NULL,
	`inutilizada` CHAR(1) NULL,
	PRIMARY KEY (`cod_midia`),
	CONSTRAINT `fk_midia_cod_filme`
	FOREIGN KEY (`cod_filme`)
	REFERENCES `filme` (`cod_filme`)
	ON DELETE NO ACTION 
	ON UPDATE CASCADE
);

CREATE TABLE `locacao` (
	`cod_locacao` INT NOT NULL AUTO_INCREMENT,
	`cod_cliente` INT NOT NULL, 
	`cod_midia` INT NOT NULL, 
	`data_emprestimo` DATE NULL, 
	`hora_emprestimo` TIME NULL, 
	`data_devolucao` DATE NULL, 
	`obs` TEXT NULL, 
	PRIMARY KEY (`cod_locacao`, `cod_cliente`, `cod_midia`), 
	CONSTRAINT `fk_locacao_cod_cliente`
		FOREIGN KEY (`cod_cliente`)
		REFERENCES `cliente` (`cod_cliente`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE, 
	CONSTRAINT `fk_locacao_cod_midia`
		FOREIGN KEY (`cod_midia`)
		REFERENCES `midia` (`cod_midia`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
);

CREATE TABLE `endereco` (
	`cod_cliente` INT NOT NULL, 
	`rua` VARCHAR(100) NULL, 
	`numero` INT NULL, 
	`bairro` VARCHAR(100) NULL, 
	`cidade` VARCHAR(100) NULL, 
	`estado` CHAR(2) NULL, 
	`cep` VARCHAR(10) NULL, 
	`complemento` TEXT NULL, 
	PRIMARY KEY (`cod_cliente`), 
	CONSTRAINT `fk_endereco_cod_cliente`
		FOREIGN KEY (`cod_cliente`)
		REFERENCES `cliente` (`cod_cliente`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
);

