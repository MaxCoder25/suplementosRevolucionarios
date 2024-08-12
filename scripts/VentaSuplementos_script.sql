#CREATE TABLE EMPRESA (
  ruc_empresa INT(11) NOT NULL,
  nombre_empresa VARCHAR(45),
  dir_empresa VARCHAR(45) ,
  tlf_empresa INT(10) ,
  email_empresa CHAR(30));

#CREATE TABLE EMPLEADO(
id_empleado INT(3) NOT NULL,
CARGO_EMPLEADO_cod_cargo INT(2) NOT NULL,
nombre_empleado VARCHAR(45));

#CREATE TABLE CARGO_EMPLEADO (
  cod_cargo INT(2) NOT NULL,
  descripcion VARCHAR(45) );

#CREATE TABLE CLIENTES (
  id_cliente INT(6) NOT NULL,
  PARROQUIA_cod_parroquia INT(2) NOT NULL,
  PARROQUIA_CANTON_cod_canton INT(2) NOT NULL,
  PARROQUIA_CANTON_PROVINCIA_cod_provincia INT(2) NOT NULL ,   
  ced_cliente INT(10),
  nomb_cliente CHAR(45),
  apell_cliente CHAR(45),
  dir_cliente VARCHAR(45),
  tlf_cliente INT(10),
  email_cliente VARCHAR(30),
  genero_cliente CHAR(1),
  otros_detalles VARCHAR(45));

#CREATE TABLE PARROQUIA(
  cod_parroquia INT(2) NOT NULL,
  CANTON_cod_canton INT(2) NOT NULL,
  CANTON_PROVINCIA_cod_provincia INT(2) NOT NULL,
  descripcion VARCHAR(45));

#CREATE TABLE CANTON (
cod_canton INT(2) NOT NULL,
 PROVINCIA_cod_provincia INT(2) NOT NULL,
descripcion VARCHAR(45));

#CREATE TABLE PROVINCIA (
  cod_provincia INT(2) NOT NULL,
  descripcion VARCHAR(45) );


#CREATE TABLE CABECERA_FACTURA (
num_factura int(3) not null,
fecha_emision date,
EMPRESA_ruc_empresa int(11),
CLIENTES_id_cliente int(6),
EMPLEADO_id_empleado int(3));

#ALTER TABLE `nuevabase`.`cabecera_factura` 
ADD PRIMARY KEY (`num_factura`);
;
drop table DETALLE_FACTURA;
CREATE TABLE DETALLE_FACTURA (
detalles VARCHAR (45) not null,
cantidad INT(3),
precio double(5,2),
DESCUENTOS_cod_descuento int(5),
IMPUESTOS_cod_impuesto int(5),
CABECERA_FACTURA_num_factura int(3),
PRODUCTO_id_producto int(5));


#La creo de nuevo con un mejor orden y agregado valor total
CREATE TABLE DETALLE_FACTURA (
PRODUCTO_id_producto int(5) not null,
detalles VARCHAR (45),
cantidad INT(3),
valor_unitario double(5,2),
valor_total double(5,2),
DESCUENTOS_cod_descuento int(5),
IMPUESTOS_cod_impuesto int(5),
CABECERA_FACTURA_num_factura int(3));




#CREATE TABLE IMPUESTOS(
cod_impuesto int(5) not null,
valor_impuesto double(5,2));

#CREATE TABLE DESCUENTOS(
cod_descuento int(5) not null,
valor_descuento double(5,2));

#CREATE TABLE PRODUCTO (
id_producto int(5) not null,
descripcion varchar(45),
precio_producto double(5,2),
ANABOLICOS_cod_anabolicos int(5),
CARBOHIDRATOS_cod_carbohidratos int(5),
CREATINA_cod_creatina int(5),
VITAMINAS_cod_vitaminas int(5),
PROTEINAS_cod_vitaminas int (5));

#CREATE TABLE ANABOLICOS (
cod_anabolicos int(5) not null,
ADD PRIMARY KEY (`cod_anabolicos`),
descripcion varchar (45));

#CREATE TABLE CARBOHIDRATOS(
cod_carbohidratos int(5) not null,
descropcion varchar (45));

#CREATE TABLE CREATINA(
cod_creatina int(5)not null,
descripcion varchar(45));

#CREATE TABLE VITAMINAS(
cod_vitaminas int (5) not null,
descripcion varchar(45));

#CREATE TABLE PROTEINAS (
cod_proteinas int (5) not null,
descripcion varchar (45));



#delete from producto;



select * from clientes;
select * from producto;
select * from CABECERA_FACTURA;
select * from DETALLE_FACTURA;
select * from proteinas;
select * from creatina;
select * from carbohidratos;

insert into producto values (1,"Proteina De Suero", 25.55 , 0, 0, 0 ,0 ,12345);
insert into producto values (2,"Creatina Iso-Pure", 18.23 , 0, 0, 23456 ,0 ,0);
insert into producto values (3,"Maltodextrina", 255.12 , 0, 34567, 0 ,0 ,0);

insert into CABECERA_FACTURA values (1,"2019-07-06",1738291345,1,1);
insert into CABECERA_FACTURA values (2,"2019-07-07",1738291345,2,1);
insert into CABECERA_FACTURA values (3,"2019-07-08",1738291345,1,2);

#Detalles factura cambiado
insert into DETALLE_FACTURA values (1, "Proteina De Suero", 2, 25.55, cantidad * valor_unitario, 0, 0, 001);
insert into DETALLE_FACTURA values (2, "Creatina Iso-Pure", 3, 18.23,cantidad * valor_unitario, 0, 0, 001);
insert into DETALLE_FACTURA values (3, "Maltodextrina", 1, 25.55, cantidad * valor_unitario, 0, 0, 001);

insert into DETALLE_FACTURA values (3, "Maltodextrina", 8, 25.55, cantidad * valor_unitario, 0, 0, 002);

#detalle factura original
insert into DETALLE_FACTURA values ("Proteina De Suero", 2, 25.55,0 , 0, 001,1);
insert into DETALLE_FACTURA values ("Creatina Iso-Pure", 3, 18.23, 0, 0, 001, 2);
insert into DETALLE_FACTURA values ("Maltodextrina", 1, 25.55,0, 0, 001, 3);

insert into DETALLE_FACTURA values ("Maltodextrina", 8, 25.55, 0, 0, 002, 3);

SELECT COUNT(*) from clientes;

delete from proteinas;

insert into proteinas values (12345, "Proteina De Suero"),
							 (54321, "Proteina de Carne");

insert into creatina values (23456, "Creatina Iso-Pure"),
							 (65432, "Creatina Hidrolizada");
                             
insert into carbohidratos values (34567, "Maltodextrina"),
							 (76543, "Fructosa");                             