create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table inventario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 valor_base double not null,
 tiempo_vegetacion int(8) not null,
 fecha_ingreso date not null,
 fecha_germinacion date not null,
 fecha_plantula date not null,
 fecha_macollamiento date not null,
 fecha_reproduccion date not null,
 primary key (id)
);

create table venta (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 precio double not null,
 fase varchar(20) not null,
 fecha_ingreso date not null,
 fecha_venta date not null,
 primary key (id)
);