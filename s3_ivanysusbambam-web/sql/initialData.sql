/**
 * Author:  if.garcia
 * Created: 3/05/2018
 */
delete from quejaReclamoEntity;
delete from ventaEntity;
delete from compraEntity;
delete from prospectoCompraEntity;
delete from automovilEntity;
delete from calificacionTiendaEntity;
delete from vendedorEntity;
delete from medioDePagoEntity;
delete from modelEntity;
delete from calificacionCarroEntity;
delete from marcaEntity;
delete from puntoDeVentaEntity;
delete from clienteEntity;

-- clientes ---
insert into ClienteEntity (cedula, imagen, nombre) values (1, 'http://www.universal.org.ar/wp-content/uploads/2016/08/84269135_00-690x390.jpg','Ardyth Fontenot');
insert into ClienteEntity (cedula, imagen, nombre) values (2, 'http://turankeo.com/wp-content/uploads/2013/05/size1_97908_felicidad.jpg','Sharyl Clem');
insert into ClienteEntity (cedula, imagen, nombre) values (3, 'https://image.freepik.com/photos-libre/concept-de-voyage-gros-plan-portrait-jeune-et-belle-femme-afro-americaine-attrayante-avec-un-sourire-a-la-mode-et-une-expression-joyeuse-fond-d-39-ecran-en-pastel-jaune-pastel-espace-de-copie_1258-921.jpg','Bailie MacLeese');
insert into ClienteEntity (cedula, imagen, nombre) values (4, 'http://s.glbimg.com/en/ce/media/photos/img/redeglobo.globo.com/cobertura/novelas/flor-do-caribe/2013/02/19/debora.jpg','Helen McGarvie');
insert into ClienteEntity (cedula, imagen, nombre) values (5, 'https://www.elpaisdelosjovenes.com/wp-content/uploads/2016/08/feliz-mascota-690x395.jpg','Felicidad Sefton');
insert into ClienteEntity (cedula, imagen, nombre) values (6, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQy_jJssdPB_oby5a0EGOBc89q-tLayslecWCRPDudapHZHX4YiZw','Elmer Dunster');
insert into ClienteEntity (cedula, imagen, nombre) values (7, 'https://s-media-cache-ak0.pinimg.com/736x/32/a2/97/32a297a5cec02cdf106e932cbe1c0011.jpg','Dennet Casseldine');
insert into ClienteEntity (cedula, imagen, nombre) values (8, 'https://www.ecestaticos.com/imagestatic/clipping/a67/446/a674467b78713f6f4f5741c4f644023b/la-mujer-que-te-explica-como-sera-el-sexo-del-futuro.jpg?mtime=1490356700','Malory Lorimer');
insert into ClienteEntity (cedula, imagen, nombre) values (9, 'https://blogmujeres.com/wp-content/uploads/2016/06/peinados-hombre-pelo-largo-medio-capas-600x900.jpg','Tyler Thackston');
insert into ClienteEntity (cedula, imagen, nombre) values (10, 'http://www.thecityreview.com/f14stribkunins.jpg','Myron Edwin');

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
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (30, 'abac', 'Pablo Robles', 4.8);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (31, 'abac', 'Pedro Pedraza', 4.5);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (32, 'abac', 'Isabella Izasa', 4.1);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (33, 'abac', 'Thomas Thombson', 4.7);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (34, 'abac', 'Camilo Cabrera', 4.3);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (35, 'abac', 'Julia Jones', 4.4);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (36, 'abac', 'Nathaly Norton', 3.9);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (37, 'abac', 'Nicolas Navarro', 4.7);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (38, 'abac', 'Alejandro Alzate', 4.5);
insert into CalificacionCarroEntity(id, comentario, name, puntaje) values (39, 'abac', 'Pietro Cagliaghi', 5.0);


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
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Carla Simek', 5776, 1007097750, 'http://susociodenegocios.com/wp-content/uploads/2015/06/grupo-de-vendedores.jpg',21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Hinze Redbourn', 6696, 3866353918, 'https://planemprendedor.co/wp-content/uploads/2016/05/Vendedor.jpg',21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Gregg Jammet', 1538, 2796466569, 'https://abasto.com/wp-content/uploads/2018/02/vendedor-eficiente.jpg',21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Pavlov Kirwood', 9035, 5342831412, 'http://vocevendedor.com.br/blog/wp-content/uploads/2017/10/httpvocevendedor.com_.brblog5-730x487.jpg',21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Gawain Canner', 476, 9028000433, 'https://vivaelnetworking.com/wp-content/uploads/2017/09/4-razones-las-vendedor-deberia-considerar-negocio-mlm.jpg',21);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Lesli Simmig', 5915, 3689419640, 'http://www.mujeresdeempresa.com/wp-content/uploads/2014/02/acuerdo2.jpg',22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Rozalie Tilley', 9487, 3892397957, 'https://www.nupciasmagazine.com/assets/images/Bienestar/retos_mujeres_emprendedoras.jpg',22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Zed Filov', 4343, 6705228597, 'http://www.blog-masculin.com/files/2017/07/homme-costume-ete.png',22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Denise Trendle', 6473, 9206874986, 'http://vinculamos.com.co/imagenes/oferta/imagen1/vendedora-punto-de-venta---medellin1657.jpg',22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Winny Bugden', 2732, 7000671839, 'http://cdn2.salud180.com/sites/default/files/styles/medium/public/field/image/2014/10/tratos_a_las_mujeres_en_los_negocios.jpg',22);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Julio Ramirez', 5788, 3634419680, 'https://fthmb.tqn.com/lS9mlOhI10yzyoJWNbhx3vk5kV0=/768x0/filters:no_upscale()/vendedor-56c482ad3df78c0b139b9ac1.jpg',23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Mariano Castro', 9433, 7892388957, 'http://guiadeofertasnaweb.com.br/custom/domain_1/image_files/sitemgr_photo_331.jpg',23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Aquiles Lopez', 6363, 6704428598, 'http://keyrenter.com/wp-content/uploads/2016/02/man-working-at-desk.jpg',23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Dillan Utterson', 6813, 9204899986, 'http://www.diario-economia.com/fe-848x442-data/fotos/vendedor14.jpg',23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Edgar Poe', 2112, 7220671879, 'https://pymex.com/wp-content/uploads/2016/09/frases-celebres.jpg',23);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Mateo Martinez', 5515, 3634419680, 'http://www.farmaceuticas.com.br/wp-content/uploads/2015/04/vaga-vendedor.jpg',24);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Fernando de Aragon', 8687, 7892388957, 'https://karrierebibel.de/wp-content/uploads/2018/07/Manager-auf-Zeit-Gehalt-Tagessatz-Jobs.jpg',24);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Isabel de Castilla', 4443, 6704428598, 'http://www.coase.com.ar/images/1vendedoramostrador.jpg',24);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Enrique Quevedo', 6123, 9204899986, 'http://richardcrookes.com.au/wp-content/uploads/2017/04/Tony-Grippi-Construction-Manager.jpg',24);
insert into VendedorEntity (nombre, carnetVendedor, cedula, imagen, puntoDeVenta_id) values ('Arthur Conan Doyle', 2782, 7220671879, 'http://tnews.com.pe/wp-content/uploads/2016/12/entrevista231216_f2.jpg',24);

--medios de pago--
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (1012, 'CREDITO', 1);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (2013, 'PAY_PAL', 2);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (3014, 'CREDITO', 3);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (4015, 'PSE', 4);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (5016, 'PSE', 5);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (6017, 'PSE', 6);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (7018, 'PAY_PAL', 7);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (8019, 'PSE', 8);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (9111, 'PSE', 9);
insert into MedioDePagoEntity (numero, tipo, cliente_cedula) values (1021, 'PSE', 10);

--calificaciones tienda--
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (331, 'zxyz', 'Michigan', 4.5, 1);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (332, 'zxyz', 'Florida', 4.1, 1);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (333, 'zxyz', 'Florida', 4.7, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (334, 'zxyz', 'Los Ángeles', 4.3, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (335, 'zxyz', 'Michigan', 4.4, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (336, 'zxyz', 'Washington', 3.9, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (337, 'zxyz', 'Michigano', 4.7, 2);
insert into CalificacionTiendaEntity(id, comentario, name, puntaje, cliente_cedula) values (338, 'zxyz', 'Alejandro Alzate', 4.5, 2);

--automoviles--
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (501, 1976, 1234, 100000, 'auto','Plateado', '11/06/2010', 'BMW 507 1', '861-PDI', 160000000, 11, 411, 21, 'https://1.bp.blogspot.com/-vzt9wxbU-tY/Wq0UPgzwQCI/AAAAAAABo5U/pgLggGmND1QraS6wSIeCcL8inQ1oCEHfACLcBGAs/s1600/AP3T3146.JPG');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (502, 1960, 1234, 90000, 'auto', 'Negro', '07/04/2012', 'BMW 507 2', '347-FNK', 165000000, 11, 411, 21, 'https://i.pinimg.com/736x/62/bc/0e/62bc0e9b24a7ae38c581760b2ed9d9a4--bmw-roadster-antique-cars.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (503, 1972, 1234, 105000, 'auto', 'Rojo', '06/30/2011', 'BMW 507 2', '440-HYE', 160000000, 11, 411, 22, 'https://i.pinimg.com/736x/a5/7c/d0/a57cd0f4f1e8e06600eeafd94df6952d--bmw-classic-bmw-cars.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (504, 2000, 1234, 20000, 'auto', 'Azul', '02/17/2015', 'BMW Z8 1', '048-UKX', 280000000, 11, 412, 22, 'https://www.classicdriver.com/sites/default/files/styles/two_third_slider/public/cars_images/feed_499796/1ac4a62afa629b31a6cda86f8ecae8810e3d7e72.jpg?itok=7o2i3cRu');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (505, 2002, 1234, 18000, 'auto', 'Rojo', '01/15/2015', 'BMW Z8 2', '696-NXU', 286000000, 11, 412, 23, 'https://cloud10.todocoleccion.online/coches-a-escala/tc/2015/09/17/00/51323358_27661983.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (506, 2004, 1234, 19000, 'auto', 'Plateado', '10/05/2017', 'BMW Z8 3', '772-CWX', 284000000, 11, 412, 24, 'https://s13252.pcdn.co/wp-content/uploads/2018/01/5a69148c6d14e_15161338087dff9f98764daZ89-940x541.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (507, 2017, 4567, 8000, 'auto', 'Azul', '02/05/2013', 'BMW M5 1', '638-EVN', 368000000, 11, 413, 21, 'http://www.caranddriver.es/themes/ee/site/CD/asset/img/contenidos/10607/bmw-m5-2018__pinned.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (508, 2018, 4567, 5000, 'auto', 'Vinotinto', '06/23/2011', 'BMW M5 2', '387-CPS', 370000000, 11, 413, 23, 'https://i.gaw.to/photos/3/0/4/304864_2018_BMW_5_Series.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (509, 2016, 4567, 1000, 'auto', 'Blanco', '01/21/2015', 'BMW M5 3', '285-URW', 378000000, 11, 413, 23, 'https://icdn-3.motor1.com/images/mgl/BnpBR/s4/2018-bmw-m5-with-m-performance-parts.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (510, 1972, 5678, 900000, 'auto', 'Verde', '12/14/2014', 'Audi 80B1 1', '626-HMM', 125000000, 12, 414, 21, 'https://i.pinimg.com/originals/39/0a/a9/390aa9b1f35862d15902f57a65f46966.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (511, 1972, 5678, 1005000, 'auto', 'Azul', '05/02/2012', 'Audi 80B1 2', '591-PKE', 115000000, 12, 414, 21, 'https://images.honestjohn.co.uk/imagecache/file/fit/730x700/media/5723205/Audi%2080%20(4).jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (512, 1974, 5678, 1000000, 'auto', 'Naranja', '03/27/2011', 'Audi 80B1 3', '012-AVC', 115000000, 12, 414, 24, 'http://www.autoslavia.com/wp-content/uploads/2017/08/1975-Audi-80-B1-3870E-772x580.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (513, 2001, 5678, 101000, 'auto', 'Rojo', '01/19/2014', 'Audi A4 B6 1', '019-FCU', 185000000, 12, 415, 22, 'https://www.tuningblog.eu/tr/wp-content/uploads/2016/07/Audi-A4-B8-Limousine-ROT-RED-Tuning-Vossen-Wheels.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (514, 2007, 5678, 45000, 'auto', 'Plateado', '10/19/2016', 'Audi A4 B6 2', '480-XEB', 194000000, 12, 415, 23, 'https://images.honestjohn.co.uk/imagecache/file/fit/730x700/media/7180406/Audi~A4~2001~(2).jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (515, 2004, 5678, 84000, 'auto', 'Azul', '09/10/2017', 'Audi A4 B6 3', '504-JXA', 190000000, 12, 415, 21, 'http://tzwqcc.com/wp-content/uploads/2017/07/Unique-Audi-A4-2004-29-in-addition-Vehicle-Ideas-with-Audi-A4-2004.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (516, 2016, 5678, 6000, 'auto', 'Rojo', '10/28/2014', 'Audi A8 1', '104-IXB', 235000000, 12, 416, 21, 'https://img.autocosmos.com/noticias/fotosprinc/NAZ_040dfdce154f4717881c61b8dd7e4475.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (517, 2017, 5678, 190000, 'auto', 'Negro', '12/02/2014', 'Audi A8 2', '919-GUB', 227000000, 12, 416, 24, 'https://img.drive.ru/i/0/58dce0c4ec05c49074000011.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (518, 2018, 5678, 80000, 'auto', 'Blanco', '03/01/2018', 'Audi A8 3', '940-ZHZ', 232000000, 12, 416, 24, 'https://images.dealer.com/autodata/us/large_stockphoto-color/2018/USC80AUC041A0/2Y2Y.jpg?impolicy=resize&w=650');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (519, 1985, 7890, 5000000, 'camioneta', 'Negro', '02/21/2015', 'Toyota Land-Cruiser 1', '469-FIJ', 62000000, 13, 417, 21, 'http://www.2040-cars.com/_content/cars/images/41/335941/001.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (520, 1986, 7890, 3080000, 'camioneta', 'Rojo', '07/15/2015', 'Toyota Land-Cruiser 2', '680-WPA', 62000000, 13, 417, 23, 'https://s13252.pcdn.co/wp-content/uploads/2017/12/5a39b5d08b84c_IMG_6810-940x665.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (521, 1990, 7890, 1700000, 'camioneta', 'Blanco', '12/30/2008', 'Toyota Land-Cruiser 3', '852-PPD', 66000000, 13, 417, 22, 'https://i.pinimg.com/originals/ef/66/86/ef6686cf3eccc5375be09b8eccfd2159.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (522, 2004, 7890, 808000, 'auto', 'Plateado', '04/01/2018', 'Toyota Avenis 1', '751-PNX', 94000000, 13, 418, 24, 'https://images.toyota-europe.com/eu/avensis/width/1200/exterior-3.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (523, 2003, 7890, 775000, 'auto', 'Azul Oscuro', '10/31/2011', 'Toyota Avenis 2', '808-BUK', 98000000, 13, 418, 24, 'https://images.toyota-europe.com/ro/avensis/width/1200/exterior-3.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (524, 2007, 7890, 300800, 'auto', 'Gris', '10/12/2010', 'Toyota Avenis 3', '610-OKA', 98000000, 13, 418, 23, 'https://acs2.blob.core.windows.net/imgcatalogo/l/P_7e6576512ddc4aa0a5e99fefb4bf0d41.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (525, 2016, 1029, 3060100, 'camioneta', 'Blanco', '12/17/2017', 'Toyota Hilux 1', '760-UVH', 245000000, 13, 419, 23, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_b4ebb804b7574e6fada6c6332c429c8a.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (526, 2017, 1029, 4070100, 'camioneta', 'Rojo', '04/30/2018', 'Toyota Hilux 2', '311-LZC', 250000000, 13, 419, 22, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_d4b5b1ff1c7649da9909f90405cb4efc.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (527, 2016, 1029, 5708000, 'camioneta', 'Fuscia', '05/30/2015', 'Toyota Hilux 3', '780-YWH', 253000000, 13, 419, 21, 'https://i.blogs.es/332cab/toyota-hilux-invincible-50-chrome-2018-2-/450_1000.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (528, 1978, 1029, 178000, 'auto', 'Bronce', '01/23/2010', 'Mazda 626 1', '051-MBI', 32000000, 14, 421, 21, 'https://http2.mlstatic.com/capot-mazda-artis-sedan-1995-al-1999-D_NQ_NP_361211-MLC20487939747_112015-F.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (529, 1980, 1029, 220000, 'auto', 'Verde Claro', '06/15/2012', 'Mazda 626 2', '806-SLZ', 30000000, 14, 421, 21, 'http://www.motor.com.co/files/article_main//files/crop//uploads/2016/01/22/56a2849a4da78.r_1453739689437.0-189-871-625.jpeg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (530, 1979, 1029, 175000, 'auto', 'Rojo', '08/28/2013', 'Mazda 626 3', '495-QDQ', 32000000, 14, 421, 24, 'https://s.aolcdn.com/commerce/autodata/images/20MAGED1.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (531, 2010, 1029, 537000, 'auto', 'Blanco', '12/14/2008', 'Mazda 3 sedan 1', '445-GHO', 54000000, 14, 422, 23, 'https://www.mazda.es/Canvas/all-new-showroom/mazda3-IPM-Fastback/l10n/master/Colour/images/LHD/Artic%20White/00.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (532, 2006, 1029, 484000, 'auto', 'Azul Plata', '01/12/2005', 'Mazda 3 sedan 2', '361-KNB', 54000000, 14, 422, 23, 'http://st.motortrendenespanol.com/uploads/sites/5/2017/05/2017-Mazda3-S-GT-front-three-quarter-in-motion-02-e1495488067784.jpg?interpolation=lanczos-none&fit=around%7C660%3A440');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (533, 2009, 1029, 709500, 'auto', 'Blue', '02/13/2004', 'Mazda 3 sedan 3', '558-IWJ', 56000000, 14, 422, 22, 'http://www.toyotapachuca.com.mx/seminuevos/Mazda-3-S-MT-2015-Negro/34.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (534, 2017, 4598, 45000, 'auto', 'Blanco', '02/05/2014', 'Mazda  MX-5 Roadster coupe 1', '093-BHQ', 68000000, 14, 423, 23, 'https://images.autouncle.com/es/car_images/f7d46e3b-a8bb-47d1-88ef-6a05659c04bb_mazda-mx5-roadster-coupe-2-0-luxury.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (535, 2015, 4598, 30000, 'auto', 'Negro', '08/10/2011', 'Mazda  MX-5 Roadster coupe 2', '574-SQG', 74000000, 14, 423, 24, 'https://d1ix0byejyn2u7.cloudfront.net/drive/images/made/drive/images/remote/https_f2.caranddriving.com/images/new/large/MazMX5RoadsterCoupe0409_794_529_70.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (536, 2016, 4598, 50000, 'auto', 'Amarillo', '03/21/2009', 'Mazda  MX-5 Roadster coupe 3', '252-EGY', 72000000, 14, 423, 21, 'https://carimages.com.au/8dfLMkJdolc9Jt3BlkfiKV-KYto=/fit-in/1000x750/filters:stretch(FFFFFF)/editorial/articleLeadwide-12bkk.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (537, 1994, 4598, 185000, 'auto', 'Plateado', '07/27/2010', 'Mercedes Benz C112 1', '071-VVJ', 182000000, 15, 424, 22, 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Mercedes-Benz_C112_1991_frontleft_2010-04-08_A.jpg/640px-Mercedes-Benz_C112_1991_frontleft_2010-04-08_A.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (538, 1998, 4598, 143500, 'auto', 'Dorado a rallas', '12/03/2010', 'Mercedes Benz C1121 2', '234-WPF', 184000000, 15, 424, 23, 'https://i.pinimg.com/originals/0c/a5/66/0ca566eb3c4dc571034980e649685156.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (539, 1996, 4598, 324500, 'auto', 'Plateado', '11/06/2013', 'Mercedes Benz C1121 3', '978-TKI', 182000000, 15, 424, 24, 'https://i.pinimg.com/originals/e1/4f/12/e14f12a5d9f9b66698a7ff85abf93fec.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (540, 2008, 4598, 65000, 'auto', 'Blanco', '01/06/2016', 'Mercedes Benz CLC 1', '842-FKW', 246000000, 15, 425, 21, 'https://www.lloydmotorgroup.com/ImageLibrary/Vehicle/906989-yVdAswkS1rMv7fAOUw.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (541, 2005, 4598, 10500, 'auto', 'Negro', '12/04/2006', 'Mercedes Benz CLC 2', '899-JNL', 250000000, 15, 425, 22, 'https://images.demotores.com.ar/autos-0km/mercedes-benz-clc-250-sport_604x400_133_2_0_1.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (542, 2009, 4598, 87000, 'auto', 'Rojo', '05/10/2017', 'Mercedes Benz CLC 3', '716-FXA', 246000000, 15, 425, 22, 'https://parkers-images.bauersecure.com/pagefiles/199240/cut-out/600x400/merc_clc.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (543, 2015, 7788, 40500, 'auto', 'Plateado', '07/17/2012', 'Mercedes Benz S63 AMG 1', '806-JED', 340000000, 15, 426, 23, 'https://images.techhive.com/images/article/2014/08/2014_mercedes-benz_s63_amg_3qtr-100409514-large.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (544, 2017, 7788, 30000, 'auto', 'Negro', '05/16/2017', 'Mercedes Benz S63 AMG 1', '996-TRW', 345000000, 15, 426, 24, 'https://s1.cdn.autoevolution.com/images/testdrive2_chapters/mercedes-benz-s63-amg-4matic-review-2014-1.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (545, 2017, 7788, 48500, 'auto', 'Blanco', '08/29/2010', 'Mercedes Benz S63 AMG 1', '060-VEA', 343000000, 15, 426, 21, 'http://www.dupontregistry.com/autos/remote.jpg.ashx?404=default&width=644&height=428&urlb64=aHR0cHM6Ly93d3cuYXJkZW1vdG9yY2Fycy5jb20vZ2FsbGVyaWFfaW1hZ2VzLzMzLzMzX21haW5fbC5qcGc&hmac=JeqctzSrQPg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (546, 1992, 7788, 109700, 'auto', 'Rojo', '09/08/2010', 'Chevrolet Monza 1', '911-RQC', 32000000, 16, 427, 22, 'http://www.elcarrocolombiano.com/wp-content/uploads/2018/01/20180107-CHEVROLET-MONZA-COLOMBIA-HISTORIA-01B.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (547, 1994, 7788, 113000, 'auto', 'Azul', '08/19/2011', 'Chevrolet Monza 2', '588-WYC', 32000000, 16, 427, 23, 'http://carphotos.cardomain.com/ride_images/1/2908/1981/7268490001_large.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (548, 1993, 7788, 940000, 'auto', 'Negro', '03/03/2012', 'Chevrolet Monza 3', '786-MDT', 3400000, 16, 427, 24, 'http://carphotos.cardomain.com/ride_images/3/1843/2081/29606040001_large.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (549, 2008, 7788, 111500, 'auto', 'Plateado', '08/03/2014', 'Chevrolet Evanda 1', '415-QIF', 52000000, 16, 428, 21, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpDGuJHHjAjt6MAF_2czi5vIrfch33AjSzocaQFk1rbn1FDvEmjQ');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (550, 2007, 7788, 94500, 'auto', 'Negro', '09/01/2008', 'Chevrolet Evanda 2', '931-JWM', 54000000, 16, 428, 21, 'https://thumbs.img-sprzedajemy.pl/1000x901c/f7/00/8a/chevrolet-evanda-20-16v-z-niemiec-bezwypadkowy-45-lubuskie-475446811.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (551, 2005, 7788, 107800, 'auto', 'Azul', '12/01/2017', 'Chevrolet Evanda 3', '920-KXG', 52000000, 16, 428, 24, 'https://images.autouncle.com/es/car_images/a6b83e5b-8766-4dcf-8863-85da49a1ac63_chevrolet-evanda-2-0-cdx.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (552, 2017, 1001, 35500, 'auto', 'Amarillo', '12/08/2017', 'Chevrolet Camaro ss 1', '997-QOI', 676000000, 16, 429, 22, 'https://i.ndtvimg.com/i/2015-02/chevrolet-camaross_678x352_81422948306.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (553, 2017, 1001, 10000, 'auto', 'Blanco', '03/12/2017', 'Chevrolet Camaro ss 2', '736-BTS', 700000000, 16,429, 23, 'http://veh-markets.com/uploads/postfotos/2013-chevrolet-camaro-ss-1le-7000-miles-1-owner-silver-ice-metallic-mint-1.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (554, 2018, 1001, 8700, 'auto', 'Rojo', '03/01/2018', 'Chevrolet Camaro ss 3', '088-RAT', 740000000, 16, 429, 24, 'http://autoproyecto.com/wp-content/uploads/2009/05/2010-Chevrolet-Camaro-SS.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (555, 1995, 1001, 1678000, 'auto', 'Rojo', '12/12/2008', 'Renault 9/11 1', '416-MXI', 14000000, 17, 431, 22, 'https://i.ytimg.com/vi/phD7RO3Ek84/maxresdefault.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (556, 1993, 1001, 5342000, 'auto', 'Blanco', '05/01/2009', 'Renault 9/11 2', '037-AOW', 17000000, 17, 431, 22, 'https://upload.wikimedia.org/wikipedia/commons/0/0f/WhiteRenault11GTLfront.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (557, 1991, 1001, 1102000, 'auto', 'Negro', '08/07/2015', 'Renault 9/11 3', '779-QKG', 15000000, 17, 431, 21, 'https://tecnoautos.com/wp-content/uploads/2010/11/Renault94.jpg?fb01da');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (558, 2002, 1001, 3408000, 'auto', 'Marrón', '12/08/2011', 'Renault Logan 1', '824-ZTF', 18000000, 17, 432, 22, 'https://http2.mlstatic.com/renault-logan-16-privilege-105cv-cd-D_NQ_NP_747701-MLA20395486637_082015-F.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (559, 2004, 1001, 1015000, 'auto', 'Plateado', '07/21/2018', 'Renault Logan 2', '670-ADK', 21000000, 17, 432, 24, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_cbe53375b05441ac8744299ac8163817.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (560, 2007, 1001, 2092000, 'auto', 'Azul', '03/25/2011', 'Renault Logan 3', '189-BDR', 19000000, 17, 432, 23, 'https://http2.mlstatic.com/accesorios-pisa-pies-renault-logan-sandero-simbol-cromados-D_NQ_NP_677883-MCO25897275170_082017-F.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (561, 2011, 1001, 130500, 'camioneta', 'Blanco', '01/23/2011', 'Renault Koleos 1', '473-KOM', 52000000, 17, 433, 22, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_3f87d2e0039c4d05a424712a70606461.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (562, 2014, 1001, 120600, 'camioneta', 'Plateado', '08/12/2016', 'Renault Koleos 2', '741-AIP', 48000000, 17, 433, 21, 'https://www.cdn.renault.com/content/dam/Renault/CL/personal-cars/koleos/hzg-koleos/hzg-phase1/COLORES/XZG-E3-34AvGMineralBeigeLedAllume19pFdBl.jpg.ximg.l_12_m.smart.jpg');
insert into AutomovilEntity (id, anio, chasis, kilometros, tipo, color, fechaListado, name, placa, valorListado, marca_id, model_id, puntoDeVenta_id, imagen) values (563, 2016, 1001, 110800, 'camioneta', 'Azul', '03/29/2010', 'Renault Koleos 3', '983-THP', 50000000, 17, 433, 24, 'https://acs2.blob.core.windows.net/imgcatalogo/l/VA_bb96aa63edc84d33a5c93625aa20b6c1.jpg');

--prospectos de compra--
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(611, 'aaa', 543, 1, 1538);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(612, 'bbb', 563, 1, 5776);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(613, 'ccc', 521, 3, 2782);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(614, 'ddd', 508, 3, 6123);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(615, 'eee', 541, 5, 6473);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(616, 'fff', 529, 5, 9035);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(617, 'ggg', 554, 5, 1538);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(618, 'hhh', 544, 7, 5788);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(619, 'iii', 528, 8, 5788);
insert into ProspectoCompraEntity (id, texto, automovil_id, cliente_cedula, vendedor_carnetvendedor) values(610, 'jjj', 503, 10, 6813);


--ventas--
insert into VentaEntity(idVenta, name, automovil_Id, cliente_cedula, medioDePago_numero, puntoDeVenta_id, vendedorEncargado_carnetVendedor, calificacionCarro_id) values(711, 'abcd', 528, 2, 6017, 21, 1538, 31);
insert into VentaEntity(idVenta, name, automovil_Id, cliente_cedula, medioDePago_numero, puntoDeVenta_id, vendedorEncargado_carnetVendedor, calificacionCarro_id) values(712, 'abcd', 503, 3, 3014, 22, 9487, 32);
insert into VentaEntity(idVenta, name, automovil_Id, cliente_cedula, medioDePago_numero, puntoDeVenta_id, vendedorEncargado_carnetVendedor, calificacionCarro_id) values(713, 'abcd', 514, 4, 2013, 23, 5788, 33);
insert into VentaEntity(idVenta, name, automovil_Id, cliente_cedula, medioDePago_numero, puntoDeVenta_id, vendedorEncargado_carnetVendedor, calificacionCarro_id) values(714, 'abcd', 530, 6, 3014, 24, 5515, 34);
insert into VentaEntity(idVenta, name, automovil_Id, cliente_cedula, medioDePago_numero, puntoDeVenta_id, vendedorEncargado_carnetVendedor, calificacionCarro_id) values(715, 'abcd', 545, 7, 1012, 21, 5776, 35);
insert into VentaEntity(idVenta, name, automovil_Id, cliente_cedula, medioDePago_numero, puntoDeVenta_id, vendedorEncargado_carnetVendedor, calificacionCarro_id) values(716, 'abcd', 552, 7, 1012, 22, 4343, 36);
insert into VentaEntity(idVenta, name, automovil_Id, cliente_cedula, medioDePago_numero, puntoDeVenta_id, vendedorEncargado_carnetVendedor, calificacionCarro_id) values(717, 'abcd', 563, 8, 2013, 24, 2782, 37);

--quejasReclamo--
insert into QuejaReclamoEntity(id, name, texto, tipo, cliente_cedula, venta_idVenta) values (811, 'dcba', 'uno de los rines del auto estaba dañado y nunca me lo notificaron', 'RECLAMO', 2, 711);
insert into QuejaReclamoEntity(id, name, texto, tipo, cliente_cedula, venta_idVenta) values (812, 'dcba', 'el vendedor que me atendió me regó un cafe encima y nunca volvió', 'QUEJA', 6, 714);
insert into QuejaReclamoEntity(id, name, texto, tipo, cliente_cedula, venta_idVenta) values (813, 'dcba', 'en el maletero del carro que compré apareció una bolsa con 50 g de cocaína', 'RECLAMO', 8, 717);
insert into QuejaReclamoEntity(id, name, texto, tipo, cliente_cedula, venta_idVenta) values (814, 'dcba', 'el automovil que compré me fue entregado 15 dias después de la fecha en otro punto de venta', 'QUEJA', 7, 716);
insert into QuejaReclamoEntity(id, name, texto, tipo, cliente_cedula, venta_idVenta) values (815, 'dcba', 'me fue confiscado el automovil por la policía local, debido a que era un carro robado', 'RECLAMO', 3, 712);

--compras--
insert into CompraEntity(idCompra, cliente_cedula, puntoDeVenta_id, vendedorEncargado_carnetVendedor, automovil_id ) values(911, 1, 22, 9487, 537);
insert into CompraEntity(idCompra, cliente_cedula, puntoDeVenta_id, vendedorEncargado_carnetVendedor, automovil_id ) values(912, 9, 23, 9433, 505);
insert into CompraEntity(idCompra, cliente_cedula, puntoDeVenta_id, vendedorEncargado_carnetVendedor, automovil_id ) values(913, 5, 24, 6123, 548);
insert into CompraEntity(idCompra, cliente_cedula, puntoDeVenta_id, vendedorEncargado_carnetVendedor, automovil_id ) values(914, 8, 21, 1538, 536);
insert into CompraEntity(idCompra, cliente_cedula, puntoDeVenta_id, vendedorEncargado_carnetVendedor, automovil_id ) values(915, 7, 22, 6473, 541);
insert into CompraEntity(idCompra, cliente_cedula, puntoDeVenta_id, vendedorEncargado_carnetVendedor, automovil_id ) values(916, 1, 23, 9487, 520);
insert into CompraEntity(idCompra, cliente_cedula, puntoDeVenta_id, vendedorEncargado_carnetVendedor, automovil_id ) values(917, 2, 24, 9487, 539);