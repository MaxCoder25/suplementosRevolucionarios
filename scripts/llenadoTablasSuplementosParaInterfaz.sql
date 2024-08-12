insert into producto values (00001, "Proteina en polvo", 25.55, "Proteinas");
insert into producto values (00020, "Maltodextrina", 13.75, "Carbohidratos");
insert into producto values (00040, "Creatina IsoPure", 33.13, "Creatina");
insert into producto values (00060, "Hongo Reishi", 60.67, "Anabolicos");
insert into producto values (00080, "Vitamina B-12", 15.82, "Vitaminas");

insert into producto values (00002, "Proteina de carne", 19.33, "Proteinas");


insert into clientes values (000001, 1783947584, "Kevin Ramiro", "Pazmiño Valverde", "Conocoto", 2837543, "krpazmino@uce.edu.ec", 'H', "Cliente frecuente" );
insert into clientes values (000002, 0348285829 , "Maria Jose", "Quintana Rea", "Chillogallo", 0994858293, "mjquintana@uce.edu.ec", 'M', "Cliente ocasional" ); 
insert into clientes values (123456, 1785357664, "Mateo Andres", "Candelejo", "Carapungo", 2547766, "macandelejo@uce.edu.ec", 'H', "Cliente frecuente" ); 
insert into clientes values (123457, 0412358395, "Andrea Rosa", "Alvear", "Cotocollao", 2436235, "aralvear@uce.edu.ec", 'M', "Cliente ocasional" );

insert into empresa values (1738492748, "Suplementos Revolucionarios", "Valle de los Chillos, Huancavilca y Av Ilalo", 2048395, "suplemRevolucion@gmail.com");

insert into empleado values (001, "Luis Romero", 11);
insert into empleado values (002, "Mario Bros", 11);
insert into empleado values (003, "Angelica Castillo", 12);

insert into cargo_empleado values (11 , "Cajero");
insert into cargo_empleado values (12, "Perchero");

insert into descuentos values (00, 0);
insert into descuentos values (01, 12.50);
insert into descuentos values (02, 20.65);
insert into descuentos values (03, 0.65);

insert into impuestos values (00, 0);
insert into impuestos values (01, 05.15);
insert into impuestos values (02, 10.32);
insert into impuestos values (03, 15.65);

insert into cabecera_factura values (1, "2019-07-10", 1738492748, 123456, 001);

insert into detalle_factura values ("Proteina en polvo", 5, 25.55, 0, 0, 1, 1);
insert into detalle_factura values ("Creatina IsoPure", 3, 33.13, 0, 0, 1, 40);
insert into detalle_factura values ("Maltodextrina", 5, 25.55, 0, 0, 1, 1);
insert into detalle_factura values ("Proteina en polvo", 5, 25.55, 0, 0, 1, 1);

select * from producto;
select * from clientes;
select * from empresa;
select * from empleado;
select * from cargo_empleado;
select * from cabecera_factura;
select * from detalle_factura;
select * from descuentos;
select * from impuestos;

