/**
 * Author:  if.garcia
 * Created: 3/05/2018
 */
delete from ventaEntity;
delete from compraEntity;
delete from prospectoCompraEntity;
delete from automovilEntity;
delete from calificacionTiendaEntity;
delete from quejaReclamoEntity;
delete from vendedorEntity;
delete from medioDePagoEntity;
delete from modelEntity;
delete from calificacionCarroEntity;
delete from marcaEntity;
delete from puntoDeVentaEntity;
delete from clienteEntity;

-- clientes ---
insert into ClienteEntity (cedula, nombre) values (1, 'Ardyth Fontenot');
insert into ClienteEntity (cedula, nombre) values (2, 'Sharyl Clem');
insert into ClienteEntity (cedula, nombre) values (3, 'Bailie MacLeese');
insert into ClienteEntity (cedula, nombre) values (4, 'Helen McGarvie');
insert into ClienteEntity (cedula, nombre) values (5, 'Felicdad Sefton');
insert into ClienteEntity (cedula, nombre) values (6, 'Elmer Dunster');
insert into ClienteEntity (cedula, nombre) values (7, 'Dennet Casseldine');
insert into ClienteEntity (cedula, nombre) values (8, 'Malory Lorimer');
insert into ClienteEntity (cedula, nombre) values (9, 'Tyler Thackston');
insert into ClienteEntity (cedula, nombre) values (10, 'Myron Edwin');

-- marcas --
insert into MarcaEntity(id,name, logo) values(11,'BMW', 'https://static1.squarespace.com/static/51df34b1e4b08840dcfd2841/t/52582669e4b0e21ea0b65df6/1381508714671/bmw-logo.jpg');
insert into MarcaEntity(id,name, logo) values(12,'Audi', 'https://es.vector.me/files/images/5/1/51786/audi.png');
insert into MarcaEntity(id,name, logo) values(13,'Toyota', 'https://i.pinimg.com/originals/46/ef/49/46ef49663956ce61f44bb08813d7e338.jpg');
insert into MarcaEntity(id,name, logo) values(14,'Mazda', 'https://motorrotulo.com/5156-large_default/adhesivo-mazda-logo.jpg');
insert into MarcaEntity(id,name, logo) values(15,'Mercedes Benz', 'http://4.bp.blogspot.com/-4Iilk9zuYAc/TicdXsQK8KI/AAAAAAAAAD0/40gqnLKYIwI/s1600/logo+piramidal.jpg');
insert into MarcaEntity(id,name, logo) values(16,'Chevrolet', 'https://thunderbirdautorepair.com/wp-content/uploads/2017/04/Chevrolet-Logo-PNG-Transparent-Image.png');
insert into MarcaEntity(id,name, logo) values(17,'Renault', 'https://i.pinimg.com/originals/44/50/64/44506461f9071d45dd113f33a3e59007.jpg');

--puntos de venta--
insert into PuntoDeVentaEntity(id, direccion, name, telefono) values (21, 'Cr 127 # 7 - 21', 'Los Ángeles', 7204356);
insert into PuntoDeVentaEntity(id, direccion, name, telefono) values (22, 'Cll 53 # 30 - 14', 'Florida', 4200454);
insert into PuntoDeVentaEntity(id, direccion, name, telefono) values (23, 'Cr 68 # 68 - 18', 'Washington', 7705943);
insert into PuntoDeVentaEntity(id, direccion, name, telefono) values (24, 'Cr 7 - 132 -14', 'Michigan', 5544397);

--calificaciones carro-
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (31, 'aaa', 'Pedro Pedraza', 4.5);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (32, 'bbb', 'Isabella Izasa', 4.1);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (33, 'ccc', 'Thomas Thombson', 4.7);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (34, 'ddd', 'Camilo Cabrera', 4.3);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (35, 'eee', 'Julia Jones', 4.4);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (36, 'fff', 'Nathaly Norton', 3.9);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (37, 'ggg', 'Nicolas Navarro', 4.7);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (38, 'hhh', 'Alejandro Alzate', 4.5);

--modelos--
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(411, 3200, 150, 'BMW 507', 2, 'mecanica', 11);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(412, 4900, 400, 'BMW Z8', 2, 'mecanica', 11);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(413, 4400, 600, 'BMW M5', 4, 'automatico', 11);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(414, 1500, 74, 'Audi 80 B1', 4, 'mecanica', 12);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(415, 1984, 150, 'Audi A4 B6', 4, 'mecanica', 12);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(416, 4000, 520, 'Audi A8', 2, 'automatica', 12);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(417, 2200, 61, 'Toyota Land-Cruiser', 4, 'mecanica', 13);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(418, 1800, 129, 'Toyota Avensis', 4, 'mecanica', 13);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(419, 2400, 171, 'Toyota Hilux', 4, 'mecanica', 13);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(421, 2000, 110, 'Mazda 626', 4, 'mecanica', 14);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(422, 2000, 165, 'Mazda 3 sedan', 4, 'mecanica', 14);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(423, 2800, 115, 'Mazda MX-5 Roadster coupe',  2, 'mecanica', 14);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(424, 6000, 408, 'Mercedes Benz C112', 2, 'automatica', 15);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(425, 3200, 272, 'Mercedes Benz CLC', 4, 'automatica', 15);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(426, 6300, 517, 'Mercedes Benz S63 AMG', 2, 'automatica', 15);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(427, 1600, 110, 'Chevrolet Monza', 4, 'mecanica', 16);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(428, 2000, 125, 'Chevrolet Evanda', 4, 'mecanica', 16);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(429, 6200, 1014, 'Chevrolet Camaro ss', 2, 'mecanica', 16);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(431, 1400, 60, 'Renault 9/11', 4, 'mecanica', 17);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(432, 1600, 85, 'Renault Logan', 4, 'mecanica', 17);
insert into ModelEntity(id, centcubicos, cilindraje, name, numeroPuertas, transmision, marca_id) values(433, 2000, 175, 'Renault Koleos', 4, 'mecanica', 17);


--vendedores--
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Carla Simek', 5776, 1007097750, 21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Hinze Redbourn', 6696, 3866353918, 21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Gregg Jammet', 1538, 2796466569, 21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Pavlov Kirwood', 9035, 5342831412, 21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Gawain Canner', 476, 9028000433, 21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Lesli Simmig', 5915, 3689419640, 22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Rozalie Tilley', 9487, 3892397957, 22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Zed Filov', 4343, 6705228597, 22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Denise Trendle', 6473, 9206874986, 22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Winny Bugden', 2732, 7000671839, 22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Julio Ramirez', 5788, 3634419680, 23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Marcelo Castro', 9433, 7892388957, 23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Aquiles Castro', 6363, 6704428598, 23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Dillan Utterson', 6813, 9204899986, 23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Edgar Poe', 2112, 7220671879, 23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Mateo Martinez', 5515, 3634419680, 24);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Fernando de Aragon', 8687, 7892388957, 24);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Isabel de Castilla', 4443, 6704428598, 24);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Enrique Quevedo', 6123, 9204899986, 24);
insert into VendedorEntity (nombre, carnetVendedor, cedula, puntoDeVenta_id) values ('Arthur Conan Doyle', 2782, 7220671879, 24);

--medios de pago--
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (1, 'CREDITO', 1);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (2, 'PAY_PAL', 2);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (3, 'CREDITO', 3);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (4, 'PSE', 4);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (5, 'PSE', 5);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (6, 'PSE', 6);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (7, 'PAY_PAL', 7);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (8, 'PSE', 8);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (9, 'PSE', 9);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (10, 'PSE', 10);

--calificaciones tienda--
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (331, 'aaa', 'Michigan', 4.5, 1);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (332, 'bbb', 'Florida', 4.1, 1);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (333, 'ccc', 'Florida', 4.7, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (334, 'ddd', 'Los Ángeles', 4.3, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (335, 'eee', 'Michigan', 4.4, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (336, 'fff', 'Washington', 3.9, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (337, 'ggg', 'Michigano', 4.7, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (338, 'hhh', 'Alejandro Alzate', 4.5, 2);

--automoviles--
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (501, 1976, 1234, 'Plateado', '11/06/2010', 'BMW 507 1', '861-PDI', 160000000, 11, 411, 21, null, 'https://1.bp.blogspot.com/-vzt9wxbU-tY/Wq0UPgzwQCI/AAAAAAABo5U/pgLggGmND1QraS6wSIeCcL8inQ1oCEHfACLcBGAs/s1600/AP3T3146.JPG');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (502, 1960, 1234, 'Negro', '07/04/2012', 'BMW 507 2', '347-FNK', 165000000, 11, 411, 21, null, 'https://i.pinimg.com/736x/62/bc/0e/62bc0e9b24a7ae38c581760b2ed9d9a4--bmw-roadster-antique-cars.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (503, 1972, 1234, 'Rojo', '06/30/2011', 'BMW 507 2', '440-HYE', 160000000, 11, 411, 22, null, 'https://i.pinimg.com/736x/a5/7c/d0/a57cd0f4f1e8e06600eeafd94df6952d--bmw-classic-bmw-cars.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (504, 2000, 1234, 'Azul', '02/17/2015', 'BMW Z8 1', '048-UKX', 280000000, 11, 412, 22, null, 'https://www.classicdriver.com/sites/default/files/styles/two_third_slider/public/cars_images/feed_499796/1ac4a62afa629b31a6cda86f8ecae8810e3d7e72.jpg?itok=7o2i3cRu');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (505, 2002, 1234, 'Rojo', '01/15/2015', 'BMW Z8 2', '696-NXU', 286000000, 11, 412, 23, null, 'https://cloud10.todocoleccion.online/coches-a-escala/tc/2015/09/17/00/51323358_27661983.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (506, 2004, 1234, 'Plateado', '10/05/2017', 'BMW Z8 3', '772-CWX', 284000000, 11, 412, 24, null, 'https://s13252.pcdn.co/wp-content/uploads/2018/01/5a69148c6d14e_15161338087dff9f98764daZ89-940x541.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (507, 2017, 4567, 'Azul', '02/05/2013', 'BMW M5 1', '638-EVN', 368000000, 11, 413, 21, null, 'http://www.caranddriver.es/themes/ee/site/CD/asset/img/contenidos/10607/bmw-m5-2018__pinned.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (508, 2018, 4567, 'Vinotinto', '06/23/2011', 'BMW M5 2', '387-CPS', 370000000, 11, 413, 23, null, 'https://i.gaw.to/photos/3/0/4/304864_2018_BMW_5_Series.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (509, 2016, 4567, 'Blanco', '01/21/2015', 'BMW M5 3', '285-URW', 378000000, 11, 413, 23, null, 'https://icdn-3.motor1.com/images/mgl/BnpBR/s4/2018-bmw-m5-with-m-performance-parts.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (510, 1972, 5678, 'Verde', '12/14/2014', 'Audi 80B1 1', '626-HMM', 125000000, 12, 414, 21, null, 'https://i.pinimg.com/originals/39/0a/a9/390aa9b1f35862d15902f57a65f46966.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (511, 1972, 5678, 'Azul', '05/02/2012', 'Audi 80B1 2', '591-PKE', 115000000, 12, 414, 21, null, 'https://images.honestjohn.co.uk/imagecache/file/fit/730x700/media/5723205/Audi%2080%20(4).jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (512, 1974, 5678, 'Naranja', '03/27/2011', 'Audi 80B1 3', '012-AVC', 115000000, 12, 414, 24, null, 'http://www.autoslavia.com/wp-content/uploads/2017/08/1975-Audi-80-B1-3870E-772x580.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (513, 2001, 5678, 'Rojo', '01/19/2014', 'Audi A4 B6 1', '019-FCU', 185000000, 12, 415, 22, null, 'https://www.tuningblog.eu/tr/wp-content/uploads/2016/07/Audi-A4-B8-Limousine-ROT-RED-Tuning-Vossen-Wheels.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (514, 2007, 5678, 'Plateado', '10/19/2016', 'Audi A4 B6 2', '480-XEB', 194000000, 12, 415, 23, null, 'https://images.honestjohn.co.uk/imagecache/file/fit/730x700/media/7180406/Audi~A4~2001~(2).jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (515, 2004, 5678, 'Azul', '09/10/2017', 'Audi A4 B6 3', '504-JXA', 190000000, 12, 415, 21, null, 'http://tzwqcc.com/wp-content/uploads/2017/07/Unique-Audi-A4-2004-29-in-addition-Vehicle-Ideas-with-Audi-A4-2004.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (516, 2016, 5678, 'Rojo', '10/28/2014', 'Audi A8 1', '104-IXB', 235000000, 12, 416, 21, null, 'https://img.autocosmos.com/noticias/fotosprinc/NAZ_040dfdce154f4717881c61b8dd7e4475.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (517, 2017, 5678, 'Negro', '12/02/2014', 'Audi A8 2', '919-GUB', 227000000, 12, 416, 24, null, 'https://img.drive.ru/i/0/58dce0c4ec05c49074000011.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (518, 2018, 5678, 'Blanco', '03/01/2018', 'Audi A8 3', '940-ZHZ', 232000000, 12, 416, 24, null, 'https://images.dealer.com/autodata/us/large_stockphoto-color/2018/USC80AUC041A0/2Y2Y.jpg?impolicy=resize&w=650');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (519, 1985, 7890, 'Negro', '02/21/2015', 'Toyota Land-Cruiser 1', '469-FIJ', 62000000, 13, 417, 21, null, 'http://www.2040-cars.com/_content/cars/images/41/335941/001.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (520, 1986, 7890, 'Rojo', '07/15/2015', 'Toyota Land-Cruiser 2', '680-WPA', 62000000, 13, 417, 23, null, 'https://s13252.pcdn.co/wp-content/uploads/2017/12/5a39b5d08b84c_IMG_6810-940x665.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (521, 1990, 7890, 'Blanco', '12/30/2008', 'Toyota Land-Cruiser 3', '852-PPD', 66000000, 13, 417, 22, null, 'https://i.pinimg.com/originals/ef/66/86/ef6686cf3eccc5375be09b8eccfd2159.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (522, 2004, 7890, 'Plateado', '04/01/2018', 'Toyota Avenis 1', '751-PNX', 94000000, 13, 418, 24, null, 'https://images.toyota-europe.com/eu/avensis/width/1200/exterior-3.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (523, 2003, 7890, 'Azul Oscuro', '10/31/2011', 'Toyota Avenis 2', '808-BUK', 98000000, 13, 418, 24, null, 'https://images.toyota-europe.com/ro/avensis/width/1200/exterior-3.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (524, 2007, 7890, 'Gris', '10/12/2010', 'Toyota Avenis 3', '610-OKA', 98000000, 13, 418, 23, null, 'https://acs2.blob.core.windows.net/imgcatalogo/l/P_7e6576512ddc4aa0a5e99fefb4bf0d41.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (525, 2016, 1029, 'Blanco', '12/17/2017', 'Toyota Hilux 1', '760-UVH', 245000000, 13, 419, 23, null, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_b4ebb804b7574e6fada6c6332c429c8a.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (526, 2017, 1029, 'Rojo', '04/30/2018', 'Toyota Hilux 2', '311-LZC', 250000000, 13, 419, 22, null, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_d4b5b1ff1c7649da9909f90405cb4efc.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (527, 2016, 1029, 'Fuscia', '05/30/2015', 'Toyota Hilux 3', '780-YWH', 253000000, 13, 419, 21, null, 'https://i.blogs.es/332cab/toyota-hilux-invincible-50-chrome-2018-2-/450_1000.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (528, 1978, 1029, 'Bronce', '01/23/2010', 'Mazda 626 1', '051-MBI', 32000000, 14, 421, 21, null, 'https://http2.mlstatic.com/capot-mazda-artis-sedan-1995-al-1999-D_NQ_NP_361211-MLC20487939747_112015-F.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (529, 1980, 1029, 'Verde Claro', '06/15/2012', 'Mazda 626 2', '806-SLZ', 30000000, 14, 421, 21, null, 'http://www.motor.com.co/files/article_main//files/crop//uploads/2016/01/22/56a2849a4da78.r_1453739689437.0-189-871-625.jpeg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (530, 1979, 1029, 'Rojo', '08/28/2013', 'Mazda 626 3', '495-QDQ', 32000000, 14, 421, 24, null, 'https://s.aolcdn.com/commerce/autodata/images/20MAGED1.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (531, 2010, 1029, 'Blanco', '12/14/2008', 'Mazda 3 sedan 1', '445-GHO', 54000000, 14, 422, 23, null, 'https://www.mazda.es/Canvas/all-new-showroom/mazda3-IPM-Fastback/l10n/master/Colour/images/LHD/Artic%20White/00.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (532, 2006, 1029, 'Azul Plata', '01/12/2005', 'Mazda 3 sedan 2', '361-KNB', 54000000, 14, 422, 23, null, 'http://st.motortrendenespanol.com/uploads/sites/5/2017/05/2017-Mazda3-S-GT-front-three-quarter-in-motion-02-e1495488067784.jpg?interpolation=lanczos-none&fit=around%7C660%3A440');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (533, 2009, 1029, 'Blue', '02/13/2004', 'Mazda 3 sedan 3', '558-IWJ', 56000000, 14, 422, 22, null, 'http://www.toyotapachuca.com.mx/seminuevos/Mazda-3-S-MT-2015-Negro/34.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (534, 2017, 4598, 'Blanco', '02/05/2014', 'Mazda  MX-5 Roadster coupe 1', '093-BHQ', 68000000, 14, 423, 23, null, 'https://images.autouncle.com/es/car_images/f7d46e3b-a8bb-47d1-88ef-6a05659c04bb_mazda-mx5-roadster-coupe-2-0-luxury.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (535, 2015, 4598, 'Negro', '08/10/2011', 'Mazda  MX-5 Roadster coupe 2', '574-SQG', 74000000, 14, 423, 24, null, 'https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/MazMX5RoadsterCoupe0409_794_529_70.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (536, 2016, 4598, 'Amarillo', '03/21/2009', 'Mazda  MX-5 Roadster coupe 3', '252-EGY', 72000000, 14, 423, 21, null, 'https://carimages.com.au/8dfLMkJdolc9Jt3BlkfiKV-KYto=/fit-in/1000x750/filters:stretch(FFFFFF)/editorial/articleLeadwide-12bkk.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (537, 1994, 4598, 'Plateado', '07/27/2010', 'Mercedes Benz C112 1', '071-VVJ', 182000000, 15, 424, 22, null, 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Mercedes-Benz_C112_1991_frontleft_2010-04-08_A.jpg/640px-Mercedes-Benz_C112_1991_frontleft_2010-04-08_A.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (538, 1998, 4598, 'Dorado a rallas', '12/03/2010', 'Mercedes Benz C1121 2', '234-WPF', 184000000, 15, 424, 23, null, 'https://i.pinimg.com/originals/0c/a5/66/0ca566eb3c4dc571034980e649685156.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (539, 1996, 4598, 'Plateado', '11/06/2013', 'Mercedes Benz C1121 3', '978-TKI', 182000000, 15, 424, 24, null, 'https://i.pinimg.com/originals/e1/4f/12/e14f12a5d9f9b66698a7ff85abf93fec.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (540, 2008, 4598, 'Blanco', '01/06/2016', 'Mercedes Benz CLC 1', '842-FKW', 246000000, 15, 425, 21, null, 'https://www.lloydmotorgroup.com/ImageLibrary/Vehicle/906989-yVdAswkS1rMv7fAOUw.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (541, 2005, 4598, 'Negro', '12/04/2006', 'Mercedes Benz CLC 2', '899-JNL', 250000000, 15, 425, 22, null, 'https://images.demotores.com.ar/autos-0km/mercedes-benz-clc-250-sport_604x400_133_2_0_1.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (542, 2009, 4598, 'Rojo', '05/10/2017', 'Mercedes Benz CLC 3', '716-FXA', 246000000, 15, 425, 22, null, 'https://parkers-images.bauersecure.com/pagefiles/199240/cut-out/600x400/merc_clc.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (543, 2015, 7788, 'Plateado', '07/17/2012', 'Mercedes Benz S63 AMG 1', '806-JED', 340000000, 15, 426, 23, null, 'https://images.techhive.com/images/article/2014/08/2014_mercedes-benz_s63_amg_3qtr-100409514-large.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (544, 2017, 7788, 'Negro', '05/16/2017', 'Mercedes Benz S63 AMG 1', '996-TRW', 345000000, 15, 426, 24, null, 'https://s1.cdn.autoevolution.com/images/testdrive2_chapters/mercedes-benz-s63-amg-4matic-review-2014-1.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (545, 2017, 7788, 'Blanco', '08/29/2010', 'Mercedes Benz S63 AMG 1', '060-VEA', 343000000, 15, 426, 21, null, 'http://www.dupontregistry.com/autos/remote.jpg.ashx?404=default&width=644&height=428&urlb64=aHR0cHM6Ly93d3cuYXJkZW1vdG9yY2Fycy5jb20vZ2FsbGVyaWFfaW1hZ2VzLzMzLzMzX21haW5fbC5qcGc&hmac=JeqctzSrQPg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (546, 1992, 7788, 'Rojo', '09/08/2010', 'Chevrolet Monza 1', '911-RQC', 32000000, 16, 427, 22, null, 'http://www.elcarrocolombiano.com/wp-content/uploads/2018/01/20180107-CHEVROLET-MONZA-COLOMBIA-HISTORIA-01B.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (547, 1994, 7788, 'Azul', '08/19/2011', 'Chevrolet Monza 2', '588-WYC', 32000000, 16, 427, 23, null, 'http://carphotos.cardomain.com/ride_images/1/2908/1981/7268490001_large.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (548, 1993, 7788, 'Negro', '03/03/2012', 'Chevrolet Monza 3', '786-MDT', 3400000, 16, 427, 24, null, 'http://carphotos.cardomain.com/ride_images/3/1843/2081/29606040001_large.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (549, 2008, 7788, 'Plateado', '08/03/2014', 'Chevrolet Evanda 1', '415-QIF', 52000000, 16, 428, 21, null, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpDGuJHHjAjt6MAF_2czi5vIrfch33AjSzocaQFk1rbn1FDvEmjQ');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (550, 2007, 7788, 'Negro', '09/01/2008', 'Chevrolet Evanda 2', '931-JWM', 54000000, 16, 428, 21, null, 'https://thumbs.img-sprzedajemy.pl/1000x901c/f7/00/8a/chevrolet-evanda-20-16v-z-niemiec-bezwypadkowy-45-lubuskie-475446811.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (551, 2005, 7788, 'Azul', '12/01/2017', 'Chevrolet Evanda 3', '920-KXG', 52000000, 16, 428, 24, null, 'https://images.autouncle.com/es/car_images/a6b83e5b-8766-4dcf-8863-85da49a1ac63_chevrolet-evanda-2-0-cdx.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (552, 2017, 1001, 'Amarillo', '12/08/2017', 'Chevrolet Camaro ss 1', '997-QOI', 676000000, 16, 429, 22, null, 'https://i.ndtvimg.com/i/2015-02/chevrolet-camaross_678x352_81422948306.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (553, 2017, 1001, 'Blanco', '03/12/2017', 'Chevrolet Camaro ss 2', '736-BTS', 700000000, 16,429, 23, null, 'http://veh-markets.com/uploads/postfotos/2013-chevrolet-camaro-ss-1le-7000-miles-1-owner-silver-ice-metallic-mint-1.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (554, 2018, 1001, 'Rojo', '03/01/2018', 'Chevrolet Camaro ss 3', '088-RAT', 740000000, 16, 429, 24, null, 'http://autoproyecto.com/wp-content/uploads/2009/05/2010-Chevrolet-Camaro-SS.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (555, 1995, 1001, 'Rojo', '12/12/2008', 'Renault 9/11 1', '416-MXI', 14000000, 17, 431, 22, null, 'https://i.ytimg.com/vi/phD7RO3Ek84/maxresdefault.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (556, 1993, 1001, 'Blanco', '05/01/2009', 'Renault 9/11 2', '037-AOW', 17000000, 17, 431, 22, null, 'https://upload.wikimedia.org/wikipedia/commons/0/0f/WhiteRenault11GTLfront.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (557, 1991, 1001, 'Negro', '08/07/2015', 'Renault 9/11 3', '779-QKG', 15000000, 17, 431, 21, null, 'https://tecnoautos.com/wp-content/uploads/2010/11/Renault94.jpg?fb01da');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (558, 2002, 1001, 'Marrón', '12/08/2011', 'Renault Logan 1', '824-ZTF', 18000000, 17, 432, 22, null, 'https://http2.mlstatic.com/renault-logan-16-privilege-105cv-cd-D_NQ_NP_747701-MLA20395486637_082015-F.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (559, 2004, 1001, 'Plateado', '07/21/2018', 'Renault Logan 2', '670-ADK', 21000000, 17, 432, 24, null, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_cbe53375b05441ac8744299ac8163817.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (560, 2007, 1001, 'Azul', '03/25/2011', 'Renault Logan 3', '189-BDR', 19000000, 17, 432, 23, null, 'https://http2.mlstatic.com/accesorios-pisa-pies-renault-logan-sandero-simbol-cromados-D_NQ_NP_677883-MCO25897275170_082017-F.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (561, 2011, 1001, 'Blanco', '01/23/2011', 'Renault Koleos 1', '473-KOM', 52000000, 17, 433, 22, null, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_3f87d2e0039c4d05a424712a70606461.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (562, 2014, 1001, 'Plateado', '08/12/2016', 'Renault Koleos 2', '741-AIP', 48000000, 17, 433, 21, null, 'https://www.cdn.renault.com/content/dam/Renault/CL/personal-cars/koleos/hzg-koleos/hzg-phase1/COLORES/XZG-E3-34AvGMineralBeigeLedAllume19pFdBl.jpg.ximg.l_12_m.smart.jpg');
insert into AutomovilEntity (id, anio, chasis, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, compra_idcompra, imagen) values (563, 2016, 1001, 'Azul', '03/29/2010', 'Renault Koleos 3', '983-THP', 50000000, 17, 433, 24, null, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_bb96aa63edc84d33a5c93625aa20b6c1.jpg');

--prospectos de compra--
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(611, 'aaa', 543, 1, 1538);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(612, 'aaa', 563, 1, 5776);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(613, 'aaa', 521, 3, 2782);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(614, 'aaa', 508, 3, 6123);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(615, 'aaa', 541, 5, 6473);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(616, 'aaa', 529, 5, 9035);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(617, 'aaa', 554, 5, 1538);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(618, 'aaa', 544, 7, 5788);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(619, 'aaa', 528, 8, 5788);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(610, 'aaa', 503, 10, 6813);

--ventas--

--compras--
