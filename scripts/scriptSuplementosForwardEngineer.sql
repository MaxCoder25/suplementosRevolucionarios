-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`PROVINCIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PROVINCIA` (
  `cod_provincia` INT(2) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_provincia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CANTON`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CANTON` (
  `cod_canton` INT(2) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `PROVINCIA_cod_provincia` INT(2) NOT NULL,
  PRIMARY KEY (`cod_canton`, `PROVINCIA_cod_provincia`),
  INDEX `fk_CANTON_PROVINCIA_idx` (`PROVINCIA_cod_provincia` ASC) VISIBLE,
  CONSTRAINT `fk_CANTON_PROVINCIA`
    FOREIGN KEY (`PROVINCIA_cod_provincia`)
    REFERENCES `mydb`.`PROVINCIA` (`cod_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PARROQUIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PARROQUIA` (
  `cod_parroquia` INT(2) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `CANTON_cod_canton` INT(2) NOT NULL,
  `CANTON_PROVINCIA_cod_provincia` INT(2) NOT NULL,
  PRIMARY KEY (`cod_parroquia`, `CANTON_cod_canton`, `CANTON_PROVINCIA_cod_provincia`),
  INDEX `fk_PARROQUIA_CANTON1_idx` (`CANTON_cod_canton` ASC, `CANTON_PROVINCIA_cod_provincia` ASC) VISIBLE,
  CONSTRAINT `fk_PARROQUIA_CANTON1`
    FOREIGN KEY (`CANTON_cod_canton` , `CANTON_PROVINCIA_cod_provincia`)
    REFERENCES `mydb`.`CANTON` (`cod_canton` , `PROVINCIA_cod_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CLIENTES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CLIENTES` (
  `id_cliente` INT(6) NOT NULL,
  `ced_cliente` INT(10) NULL,
  `nomb_cliente` CHAR(45) NULL,
  `apell_cliente` CHAR(45) NULL,
  `dir_cliente` VARCHAR(45) NULL,
  `tlf_cliente` INT(10) NULL,
  `email_cliente` VARCHAR(30) NULL,
  `genero_cliente` CHAR(1) NULL,
  `otros_detalles` VARCHAR(45) NULL,
  `PARROQUIA_cod_parroquia` INT(2) NOT NULL,
  `PARROQUIA_CANTON_cod_canton` INT(2) NOT NULL,
  `PARROQUIA_CANTON_PROVINCIA_cod_provincia` INT(2) NOT NULL,
  PRIMARY KEY (`id_cliente`, `PARROQUIA_cod_parroquia`, `PARROQUIA_CANTON_cod_canton`, `PARROQUIA_CANTON_PROVINCIA_cod_provincia`),
  INDEX `fk_CLIENTES_PARROQUIA1_idx` (`PARROQUIA_cod_parroquia` ASC, `PARROQUIA_CANTON_cod_canton` ASC, `PARROQUIA_CANTON_PROVINCIA_cod_provincia` ASC) VISIBLE,
  CONSTRAINT `fk_CLIENTES_PARROQUIA1`
    FOREIGN KEY (`PARROQUIA_cod_parroquia` , `PARROQUIA_CANTON_cod_canton` , `PARROQUIA_CANTON_PROVINCIA_cod_provincia`)
    REFERENCES `mydb`.`PARROQUIA` (`cod_parroquia` , `CANTON_cod_canton` , `CANTON_PROVINCIA_cod_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EMPRESA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EMPRESA` (
  `ruc_empresa` INT(11) NOT NULL,
  `nombre_empresa` VARCHAR(45) NULL,
  `dir_empresa` VARCHAR(45) NULL,
  `tlf_empresa` INT(10) NULL,
  `email_empresa` CHAR(30) NULL,
  PRIMARY KEY (`ruc_empresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CARGO_EMPLEADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CARGO_EMPLEADO` (
  `cod_cargo` INT(2) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_cargo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EMPLEADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EMPLEADO` (
  `id_empleado` INT(3) NOT NULL,
  `nombre_empleado` VARCHAR(45) NULL,
  `CARGO_EMPLEADO_cod_cargo` INT(2) NOT NULL,
  PRIMARY KEY (`id_empleado`, `CARGO_EMPLEADO_cod_cargo`),
  INDEX `fk_EMPLEADO_CARGO_EMPLEADO1_idx` (`CARGO_EMPLEADO_cod_cargo` ASC) VISIBLE,
  CONSTRAINT `fk_EMPLEADO_CARGO_EMPLEADO1`
    FOREIGN KEY (`CARGO_EMPLEADO_cod_cargo`)
    REFERENCES `mydb`.`CARGO_EMPLEADO` (`cod_cargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CABECERA_FACTURA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CABECERA_FACTURA` (
  `num_factura` INT(3) NOT NULL,
  `fecha_emision` DATE NULL,
  `EMPRESA_ruc_empresa` INT(11) NOT NULL,
  `CLIENTES_id_cliente` INT(6) NOT NULL,
  `EMPLEADO_id_empleado` INT(3) NOT NULL,
  PRIMARY KEY (`num_factura`, `EMPRESA_ruc_empresa`, `CLIENTES_id_cliente`, `EMPLEADO_id_empleado`),
  INDEX `fk_CABECERA_FACTURA_EMPRESA1_idx` (`EMPRESA_ruc_empresa` ASC) VISIBLE,
  INDEX `fk_CABECERA_FACTURA_EMPLEADO1_idx` (`EMPLEADO_id_empleado` ASC) VISIBLE,
  INDEX `fk_CABECERA_FACTURA_CLIENTES1_idx` (`CLIENTES_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_CABECERA_FACTURA_EMPRESA1`
    FOREIGN KEY (`EMPRESA_ruc_empresa`)
    REFERENCES `mydb`.`EMPRESA` (`ruc_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CABECERA_FACTURA_EMPLEADO1`
    FOREIGN KEY (`EMPLEADO_id_empleado`)
    REFERENCES `mydb`.`EMPLEADO` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CABECERA_FACTURA_CLIENTES1`
    FOREIGN KEY (`CLIENTES_id_cliente`)
    REFERENCES `mydb`.`CLIENTES` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DESCUENTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DESCUENTOS` (
  `cod_descuento` INT(5) NOT NULL,
  `valor_descuento` DOUBLE(5,2) NULL,
  PRIMARY KEY (`cod_descuento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`IMPUESTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`IMPUESTOS` (
  `cod_impuesto` INT(5) NOT NULL,
  `valor_impuesto` DOUBLE(5,2) NULL,
  PRIMARY KEY (`cod_impuesto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ANABOLICOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ANABOLICOS` (
  `cod_anabolicos` INT(5) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_anabolicos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CARBOHIDRATOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CARBOHIDRATOS` (
  `cod_carbohidratos` INT(5) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_carbohidratos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CREATINA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CREATINA` (
  `cod_creatina` INT(5) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_creatina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`VITAMINAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`VITAMINAS` (
  `cod_vitaminas` INT(5) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_vitaminas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PROTEINAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PROTEINAS` (
  `cod_proteinas` INT(5) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_proteinas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PRODUCTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PRODUCTO` (
  `id_producto` INT(5) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `precio_producto` DOUBLE(3,2) NULL,
  `ANABOLICOS_cod_anabolicos` INT(5) NOT NULL,
  `CARBOHIDRATOS_cod_carbohidratos` INT(5) NOT NULL,
  `CREATINA_cod_creatina` INT(5) NOT NULL,
  `VITAMINAS_cod_vitaminas` INT(5) NOT NULL,
  `PROTEINAS_cod_proteinas` INT(5) NOT NULL,
  PRIMARY KEY (`id_producto`, `ANABOLICOS_cod_anabolicos`, `CARBOHIDRATOS_cod_carbohidratos`, `CREATINA_cod_creatina`, `VITAMINAS_cod_vitaminas`, `PROTEINAS_cod_proteinas`),
  INDEX `fk_PRODUCTO_ANABOLICOS1_idx` (`ANABOLICOS_cod_anabolicos` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_CARBOHIDRATOS1_idx` (`CARBOHIDRATOS_cod_carbohidratos` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_CREATINA1_idx` (`CREATINA_cod_creatina` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_VITAMINAS1_idx` (`VITAMINAS_cod_vitaminas` ASC) VISIBLE,
  INDEX `fk_PRODUCTO_PROTEINAS1_idx` (`PROTEINAS_cod_proteinas` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTO_ANABOLICOS1`
    FOREIGN KEY (`ANABOLICOS_cod_anabolicos`)
    REFERENCES `mydb`.`ANABOLICOS` (`cod_anabolicos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_CARBOHIDRATOS1`
    FOREIGN KEY (`CARBOHIDRATOS_cod_carbohidratos`)
    REFERENCES `mydb`.`CARBOHIDRATOS` (`cod_carbohidratos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_CREATINA1`
    FOREIGN KEY (`CREATINA_cod_creatina`)
    REFERENCES `mydb`.`CREATINA` (`cod_creatina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_VITAMINAS1`
    FOREIGN KEY (`VITAMINAS_cod_vitaminas`)
    REFERENCES `mydb`.`VITAMINAS` (`cod_vitaminas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTO_PROTEINAS1`
    FOREIGN KEY (`PROTEINAS_cod_proteinas`)
    REFERENCES `mydb`.`PROTEINAS` (`cod_proteinas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DETALLE_FACTURA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DETALLE_FACTURA` (
  `detalles` VARCHAR(45) NOT NULL,
  `cantidad` INT(3) NULL,
  `precio` DOUBLE(3,2) NULL,
  `DESCUENTOS_cod_descuento` INT(5) NOT NULL,
  `IMPUESTOS_cod_impuesto` INT(5) NOT NULL,
  `CABECERA_FACTURA_num_factura` INT(3) NOT NULL,
  `PRODUCTO_id_producto` INT(5) NOT NULL,
  PRIMARY KEY (`detalles`, `DESCUENTOS_cod_descuento`, `IMPUESTOS_cod_impuesto`, `CABECERA_FACTURA_num_factura`, `PRODUCTO_id_producto`),
  INDEX `fk_DETALLE_FACTURA_DESCUENTOS1_idx` (`DESCUENTOS_cod_descuento` ASC) VISIBLE,
  INDEX `fk_DETALLE_FACTURA_IMPUESTOS1_idx` (`IMPUESTOS_cod_impuesto` ASC) VISIBLE,
  INDEX `fk_DETALLE_FACTURA_CABECERA_FACTURA1_idx` (`CABECERA_FACTURA_num_factura` ASC) VISIBLE,
  INDEX `fk_DETALLE_FACTURA_PRODUCTO1_idx` (`PRODUCTO_id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_DETALLE_FACTURA_DESCUENTOS1`
    FOREIGN KEY (`DESCUENTOS_cod_descuento`)
    REFERENCES `mydb`.`DESCUENTOS` (`cod_descuento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETALLE_FACTURA_IMPUESTOS1`
    FOREIGN KEY (`IMPUESTOS_cod_impuesto`)
    REFERENCES `mydb`.`IMPUESTOS` (`cod_impuesto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETALLE_FACTURA_CABECERA_FACTURA1`
    FOREIGN KEY (`CABECERA_FACTURA_num_factura`)
    REFERENCES `mydb`.`CABECERA_FACTURA` (`num_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETALLE_FACTURA_PRODUCTO1`
    FOREIGN KEY (`PRODUCTO_id_producto`)
    REFERENCES `mydb`.`PRODUCTO` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
