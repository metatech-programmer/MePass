CREATE TABLE accesos (
  cod_usuario int NOT NULL,
  correo_acceso varchar(200)  NOT NULL,
  clave_acceso varchar(200) NOT NULL,
	constraint PK_ACCESO PRIMARY KEY(cod_usuario)
);


CREATE TABLE contrasenasGuardadas (
  cod_numero_contra int AUTO_INCREMENT NOT NULL,
  cod_usuario int NOT NULL,
  nombre_pagina varchar(200)  NOT NULL,
  url varchar(200) NOT NULL,
  nombre_usuario varchar(200)NOT NULL,
  contrasena varchar(200)NOT NULL,
	constraint PK_CONTRAGUARD PRIMARY KEY(cod_numero_contra)
); 


CREATE TABLE usuarios (
  cod_usuario int AUTO_INCREMENT NOT NULL,
  documento_usuario varchar(50) NOT NULL,
  nombres_usuario varchar(200) NOT NULL,
  apellidos_usuario varchar(200) NOT NULL,
  fecha_nacimiento_usuario date NOT NULL,
	constraint PK_USUARIO PRIMARY KEY(cod_usuario)
);

ALTER TABLE accesos
  ADD CONSTRAINT fk_accesos_ref_usuarios FOREIGN KEY (cod_usuario) REFERENCES usuarios (cod_usuario) ON DELETE RESTRICT ON UPDATE CASCADE


ALTER TABLE contrasenasGuardadas
ADD CONSTRAINT fk_contrasenasGuardadas_ref_accesos FOREIGN KEY (cod_usuario) REFERENCES accesos (cod_usuario) ON DELETE RESTRICT ON UPDATE CASCADE;



ALTER TABLE usuarios AUTO_INCREMENT = 1;
ALTER TABLE accesos AUTO_INCREMENT = 1;
ALTER TABLE contrasenasGuardadas AUTO_INCREMENT = 1;