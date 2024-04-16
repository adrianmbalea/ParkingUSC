-- Script de creacion de tablas Proyecto BDII:

----------- FUNCIONES -----------

-- Funcion para llevar a cabo la comprobacion de la validez de un DNI
create or replace function is_valid_dni(dni char(9))
returns boolean as $$
declare 
dni_num integer;
dni_letter char(1);
letter char(1);
letters char(23) = 'TRWAGMYFPDXBNJZSQVHLCKE';
pos integer;
begin
-- Extrae el número y la letra del DNI
dni_num = substring(dni, 1, 8)::integer;
dni_letter = substring(dni, 9, 1);
-- Calcula la letra correcta para el DNI
pos = dni_num % 23;
letter = substring(letters, pos + 1, 1);
-- Comprueba si la letra del DNI es correcta
if dni_letter != letter then
return false;
end if;
-- Se confirma la validez del DNI
return true;
end;
$$
language plpgsql;

-- Funcion que valida el formato espanhol de las matriculas
create or replace function validar_matricula(matricula text) 
returns boolean as $$
begin
	-- Comprueba la estructura de la matricula, 4 numeros seguidos de 3 letras consonantes
    if matricula ~ '^[0-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}$' then
        return true;
    else
    -- Si no es correcta devuelve false
        return false;
    end if;
end;
$$ language plpgsql;

-- Funcion que hashea las contrasenhas para guardarlas en la base de datos
create or replace function hash_password(password text) returns text as $$
begin 
  return encode(digest(password, 'sha512'), 'hex'); -- Equivalente a 128 char (hexadecimal)
end;
$$ language plpgsql;



----------- TABLAS -----------

-- Tabla de miembros USC:
create table miembrosusc(
	dni char(9) not null default '99999999R',
	nombreCompleto varchar(50) not null,
	correoElectronico varchar(60) not null,
	contrasenha char(128) not null,
	telefono integer not null,
	saldo numeric(8,2) not null,
	rol varchar(30) not null,
	fechaIngreso date not null,

	constraint dni_es_valido check (is_valid_dni(dni)),

	primary key(dni),

	unique (correoElectronico, telefono)
);

-- Tabla de PDI
create table pdi(
	dniMiembroUSC char(9) not null,

	primary key(dniMiembroUSC),

	foreign key (dniMiembroUSC) references miembrosusc(dni) on delete set default on update cascade
);

-- Tabla de vehiculos registrados
create table vehiculos(
	matricula char(7) not null default '9999ZZZ',
	tipo varchar(10) not null,
	marca varchar(30) not null,
	modelo varchar(30) not null,
	numeroInfracciones integer not null,
	dniMiembroUSC char(9) not null,

	constraint matricula_valida check (validar_matricula(matricula)),

	constraint tipo_vehiculo check (tipo like 'coche' or tipo like 'moto'),

	constraint dni_es_valido check (is_valid_dni(dniMiembroUSC)),

	primary key(matricula),

	foreign key (dniMiembroUSC) references miembrosusc(dni) on delete set default on update cascade
);

-- Tabla de parkings
create table parkings(
	campus varchar(20) not null,
	centro varchar(50) not null,
	capacidad integer not null,
	maximoPrivadas integer not null,

	primary key (campus, centro)
);

-- Tabla de plazas privadas
create table plazasPrivadas(
	campusParking varchar(20) not null,
	centroParking varchar(50) not null,
	id integer not null,
	tamanho varchar(10),

	constraint validar_tamanho check (tamanho like 'coche' or tamanho like 'moto'),

	primary key (campusParking, centroParking, id),
	
	foreign key (campusParking, centroParking) references parkings(campus, centro)
	on delete no action on update cascade
);

-- Tabla de plazas publicas
create table plazasPublicas(
	campusParking varchar(20) not null,
	centroParking varchar(50) not null,
	id integer not null,
	tamanho varchar(10) not null,

	constraint validar_tamanho check (tamanho like 'coche' or tamanho like 'moto'),
	
	primary key (campusParking, centroParking, id),

	foreign key (campusParking, centroParking) references parkings(campus, centro) on delete no action on update cascade
);

-- Tabla de la relacion aparcar
create table aparcar(
	fechaEntrada timestamp not null,
	fechaSalida timestamp,
	precioHora numeric(6,2) not null,
	matriculaVehiculo char(7) not null,
	campusParking varchar(20) not null,
	centroParking varchar(50) not null,
	idPlaza integer not null,
	
	primary key(fechaEntrada, matriculaVehiculo, campusParking, centroParking, idPlaza),
	
	foreign key (matriculaVehiculo) references vehiculos(matricula) on delete set default on update cascade,
	
	foreign key (campusParking, centroParking, idPlaza) references plazasPublicas(campusParking, centroParking, id) on delete no action on update cascade
);

-- Tabla de la relacion reservar
create table reservar(
	fechaInicio timestamp not null,
	fechaFin timestamp not null,
	precioHora numeric(6,2) not null,
	dniMiembroUSC char(9) not null,
	campusParking varchar(20) not null,
	centroParking varchar(50) not null,
	idPlaza integer not null,

	primary key (fechaInicio, dniMiembroUSC, campusParking, centroParking, idPlaza),

	foreign key (dniMiembroUSC) references miembrosusc(dni) on delete set default on update cascade,

	foreign key (campusParking, centroParking, idPlaza) references plazasPrivadas(campusParking, centroParking, id) on delete no action on update cascade
);

-- Tabla de la relacion asignar
create table asignar(
	fechaInicio date not null,
	fechaFin date,
	dniPDI char(9) not null,
	campusParking varchar(20) not null,
	centroParking varchar(50) not null,
	idPlaza integer not null,

	primary key (fechaInicio, dniPDI, campusParking, centroParking, idPlaza),

	foreign key (dniPDI) references pdi(dniMiembroUSC) on delete set default on update cascade,

	foreign key (campusParking, centroParking, idPlaza) references plazasPrivadas(campusParking, centroParking, id) on delete no action on update cascade
	
);