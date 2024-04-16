-- Profesores
insert into miembrosusc (dni, nombreCompleto, correoElectronico, contrasenha, telefono, saldo, rol, fechaIngreso) VALUES
('54654082X', 'José María Alonso Moral', 'josemaria.alonso@usc.es', hash_password('JMAM432'), '881816432', 45, 'usuario', '2008-05-23'),
('99104956A', 'Dora Blanco Heras', 'dora.blanco@usc.es', hash_password('DBH462'), '881816462', 152, 'usuario', '2009-10-12'),
('19681229Z', 'José Carlos Cabaleiro Domínguez', 'jc.cabaleiro@usc.es', hash_password('JCCD421'), '881816421', 58, 'usuario', '2010-07-08'),
('18491235V', 'María José Carreira Nouche', 'mariajose.carreira@usc.es', hash_password('MJCN431'), '881816431', 159, 'usuario', '2011-02-14'),
('06124565X', 'Nelly Condori Fernández', 'n.condori.fernandez@usc.es', hash_password('NCF445'), '881816445', 133, 'usuario', '2012-09-19'),
('97288336S', 'Francisco Fernández Rivera', 'ff.rivera@usc.es', hash_password('FFR470'), '881816470', 22, 'usuario', '2013-06-25'),
('28372890K', 'Julián Flores González', 'julian.flores@usc.es', hash_password('JFG456'), '881816456', 113, 'usuario', '2014-03-31'),
('21982530G', 'Manuel Lama Penín', 'manuel.lama@usc.es', hash_password('MLP420'), '881816420', 84, 'usuario', '2015-11-05'),
('04579694A', 'David Enrique Losada Carril', 'david.losada@usc.es', hash_password('DELC451'), '881816451', 8, 'usuario', '2016-08-11'),
('48040257L', 'Javier López Fandiño', 'javier.lopez.fandino@usc.es', hash_password('JLF392'), '881816392', 156, 'usuario', '2017-05-17'),
('24451980J', 'Xosé Manuel Pardo López', 'xose.pardo@usc.es', hash_password('XMPL438'), '881816438', 180, 'usuario', '2018-02-22'),
('79529917B', 'Silvia Rodríguez Alcaraz', 'silvia.alcaraz@usc.es', hash_password('SRA473'), '881816473', 59, 'usuario', '2019-09-28'),
('29606531B', 'José Ramón Ríos Viqueira', 'jrr.viqueira@usc.es', hash_password('JRRV463'), '881816463', 114, 'usuario', '2020-06-04'),
('90129726V', 'Jorge Alberto Suárez Garea', 'jorge.suarez.garea@usc.es', hash_password('JASG392'), '881816392', 11, 'usuario', '2021-03-10'),
('78631558D', 'Pablo Quesada Barriuso', 'pablo.quesada@usc.es', hash_password('PQB538'), '881813538', 47, 'usuario', '2012-05-10'),
('13905382L', 'José Varela Pet', 'jose.varela.pet@usc.es', hash_password('JVP006'), '881816006', 159, 'usuario', '2010-11-20'),
('38289664T', 'Marcos Fernández Pichel', 'marcosfernandez.pichel@usc.es', hash_password('MFP444'), '881816444', 38, 'usuario', '2015-07-15');
   
   
-- Otros trabajadores creados aleatoriamente
insert into miembrosusc (dni, nombreCompleto, correoElectronico, contrasenha, telefono, saldo, rol, fechaIngreso) VALUES
('10460185S', 'María Carmen Torres García', 'mariacarmen.torres@usc.es', hash_password('MCTG543'), '881817543', '150.50', 'usuario', '2007-09-04'),
('21044998K', 'David Romero Fuentes', 'david.romero@usc.es', hash_password('DRF452'), '881817452', '32.10', 'usuario', '2008-10-15'),
('76136103P', 'Sara Muñoz Ruiz', 'sara.munoz.ruiz@usc.es', hash_password('SMR361'), '881817361', '178.70', 'usuario', '2009-11-26'),
('34434504P', 'Marta Sánchez Serrano', 'marta.sanchez@usc.es', hash_password('MSS270'), '881817270', '89.00', 'usuario', '2010-12-07'),
('82666207K', 'Diego Álvarez Santos', 'diego.alvarez.santos@usc.es', hash_password('DAS189'), '881817189', '200.00', 'usuario', '2011-01-18'),
('62118129M', 'Javier Pérez Méndez', 'javier.perez@usc.es', hash_password('JPM109'), '881817109', '65.20', 'usuario', '2012-02-29'),
('04769786T', 'Cristina García Iglesias', 'cristina.garcia@usc.es', hash_password('CGI018'), '881817018', '130.80', 'usuario', '2013-04-12'),
('38645600B', 'Pablo Castro Rodríguez', 'pablo.castro.rodriguez@usc.es', hash_password('PCRH907'), '881817907', '44.90', 'usuario', '2014-05-23'),
('21279600T', 'Elena González Moreno', 'elena.gonzalez.moreno@usc.es', hash_password('EGM816'), '881817816', '175.30', 'usuario', '2015-06-03'),
('16399190Y', 'Daniel Gutiérrez Santos', 'daniel.gutierrez@usc.es', hash_password('DGS705'), '881817705', '88.60', 'usuario', '2016-07-14'),
('24131339S', 'Isabel Ortiz Castro', 'isabel.ortiz.castro@usc.es', hash_password('IOC634'), '881817634', '12.90', 'usuario', '2017-08-25'),
('87103569Q', 'Alejandro Ramos García', 'alejandro.ramos@usc.es', hash_password('ARG523'), '881817523', '99.20', 'usuario', '2018-10-06'),
('11337766P', 'Lorena Flores Álvarez', 'lorena.flores.alvarez@usc.es', hash_password('LFA412'), '881817412', '78.30', 'usuario', '2019-11-17'),
('32145992L', 'Roberto González Fernández', 'roberto.gonzalez@usc.es', hash_password('RGF098'), '881817098', '18.30', 'usuario', '2020-12-28'),
('22192079T', 'Carmen Sánchez Pérez', 'carmen.sanchez.perez@usc.es', hash_password('CSP987'), '881817987', '6.70', 'usuario', '2008-02-08'),
('25525387X', 'Javier García Vázquez', 'javier.garcia.vazquez@usc.es', hash_password('JGV876'), '881817876', '8.40', 'usuario', '2009-03-19'),
('54068034W', 'Ana Belén Sánchez Ramos', 'ana.belen.sanchez@usc.es', hash_password('ABSR934'), '881814934', '12.90', 'usuario', '2012-03-12'),
('29936682C', 'Antonio García Casal', 'antonio.garcia.casal@usc.es', hash_password('AGC391'), '881816391', '10.30', 'usuario', '2013-09-15'),
('11327077Z', 'Lucía Castro Otero', 'lucia.castro@usc.es', hash_password('LCO402'), '881814402', '79.70', 'usuario', '2018-05-07'),
('49788433B', 'Fernando Fernández Varela', 'fernando.fernandez.varela@usc.es', hash_password('FFV293'), '881816293', '27.30', 'usuario', '2019-12-03');


-- PDI
insert into pdi (dniMiembroUSC) values
('54654082X'),
('99104956A'),
('19681229Z'),
('18491235V'),
('06124565X'),
('97288336S'),
('28372890K'),
('21982530G'),
('04579694A'),
('48040257L'),
('24451980J'),
('79529917B'),
('29606531B'),
('90129726V'),
('78631558D'),
('13905382L'),
('38289664T');


-- Vehículos de profesores

-- Vehículos de José María Alonso Moral
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('3457RGF', 'coche', 'Audi', 'A3', 2, '54654082X'),
('6789GKL', 'moto', 'Yamaha', 'MT-07', 0, '54654082X');


-- Vehículos de Dora Blanco Heras
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('1234VFD', 'coche', 'Toyota', 'Corolla', 0, '99104956A');


-- Vehículos de José Carlos Cabaleiro Domínguez
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('4647JJB', 'coche', 'Ford', 'Focus', 0, '19681229Z');


-- Vehículos de María José Carreira Nouche
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('4940FJK', 'coche', 'Renault', 'Clio', 1, '18491235V'),
('2581FMD', 'moto', 'Ducati', 'Monster', 1, '18491235V'),
('2345VWX', 'coche', 'Peugeot', '208', 0, '18491235V');


-- Vehículos de Nelly Condori Fernández
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('9012BCD', 'moto', 'Kawasaki', 'Z650', 5, '06124565X');


-- Vehículos de Francisco Fernández Rivera
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('9737HHH', 'coche', 'Volkswagen', 'Golf', 0, '97288336S'),
('8111LML', 'moto', 'Suzuki', 'GSX-S750', 1, '97288336S');


-- Vehículos de Julián Flores González
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('7890KLM', 'coche', 'Opel', 'Astra', 1, '28372890K'),
('9183DCB', 'moto', 'Triumph', 'Street Triple', 3, '28372890K');


-- Vehículos de Manuel Lama Penín
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('8632BGJ', 'coche', 'Volkswagen', 'Golf', 2, '21982530G'),
('6734NDD', 'moto', 'Yamaha', 'R6', 0, '21982530G');


-- Vehículos de David Enrique Losada Carril
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('7341HPR', 'coche', 'Toyota', 'Corolla', 0, '04579694A'),
('2189DKL', 'coche', 'Ford', 'Escape', 2, '04579694A');


-- Vehículos de Javier López Fandiño
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('9823LKW', 'coche', 'Nissan', 'Sentra', 1, '48040257L'),
('1286BXS', 'coche', 'Audi', 'Q5', 0, '48040257L'),
('0689CLN', 'moto', 'Honda', 'CBR 600', 0, '48040257L');


-- Vehículos de Xosé Manuel Pardo López
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('7813KMM', 'coche', 'BMW', 'Serie 3', 3, '24451980J');


-- Vehículos de Silvia Rodríguez Alcaraz
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('5621FGT', 'coche', 'Hyundai', 'Elantra', 0, '79529917B'),
('1935SQL', 'coche', 'Jeep', 'Renegade', 1, '79529917B');


-- Vehículos de José Ramón Ríos Viqueira
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('5429VNX', 'coche', 'Volvo', 'S60', 2, '29606531B'),
('3827KPH', 'coche', 'Nissan', 'Rogue', 0, '29606531B');


-- Vehículos de Jorge Alberto Suárez Garea
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('7128RJX', 'coche', 'Ford', 'F-150', 1, '90129726V');


-- Vehículos de Pablo Quesada Barriuso
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('9372MVG', 'coche', 'Audi', 'A6', 0, '78631558D');


-- Vehículos de José Varela Pet
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('5627DGH', 'coche', 'Toyota', 'Camry', 2, '13905382L'),
('3281WNZ', 'coche', 'BMW', 'Serie 5', 1, '13905382L');


-- Vehículos de Marcos Fernández Pichel
insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('8901HQW', 'coche', 'Hyundai', 'Kona', 1, '38289664T'),
('4203PCX', 'coche', 'Ford', 'Mustang', 0, '38289664T');


-- Vehículos de otros trabajadores
INSERT INTO vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC) VALUES
('3214XYZ', 'moto', 'Honda', 'Gold Wing', 2, '10460185S'),
('9876BCC', 'coche', 'BMW', 'Serie 3', 3, '21044998K'),
('5432KLM', 'moto', 'Yamaha', 'MT-09', 1, '76136103P'),
('1111FGH', 'coche', 'Toyota', 'Corolla', 0, '34434504P'),
('2222LMN', 'coche', 'Hyundai', 'Santa Fe', 4, '82666207K'),
('4444PQR', 'moto', 'Suzuki', 'V-Strom 1050', 0, '62118129M'),
('7777FVW', 'coche', 'Volkswagen', 'Golf', 5, '04769786T'),
('1234BVC', 'moto', 'Honda', 'CBR600RR', 3, '38645600B'),
('5678DBF', 'coche', 'BMW', 'X5', 1, '21279600T'),
('9012GHK', 'moto', 'Suzuki', 'Hayabusa', 2, '16399190Y'),
('3456JKL', 'coche', 'Toyota', 'RAV4', 0, '24131339S'),
('7890MNJ', 'moto', 'Kawasaki', 'Ninja ZX-10R', 4, '87103569Q'),
('1234PQR', 'coche', 'Volkswagen', 'Passat', 3, '11337766P'),
('5678STM', 'moto', 'Ducati', 'Panigale V4', 0, '32145992L'),
('9012VWX', 'coche', 'Volvo', 'XC60', 2, '22192079T'),
('3456YZY', 'moto', 'Yamaha', 'MT-09', 1, '25525387X'),
('7890BCD', 'coche', 'Hyundai', 'Kona', 0, '54068034W'),
('1234TFG', 'moto', 'Honda', 'Gold Wing', 2, '29936682C'),
('5489HJB', 'moto', 'Yamaha', 'MT-09', 2, '11327077Z'),
('9861BKF', 'coche', 'Toyota', 'Tacoma', 3, '49788433B');


-- Parkings
insert into parkings (campus, centro, capacidad, maximoPrivadas) values 
('Santiago Sur', 'Facultade de Química', 22, 0),
('Santiago Sur', 'CIBUS', 22, 8),
('Santiago Sur', 'Facultade de Farmacia', 22, 2),
('Santiago Sur', 'Facultade de Física', 22, 11),
('Santiago Sur', 'ETSE', 22, 10),
('Santiago Norte', 'Facultade de Periodismo', 22, 14),
('Santiago Norte', 'Facultade de Economia', 22, 8),
('Santiago Norte', 'Facultade de Filoloxía', 22, 0),
('Lugo', 'Facultade de Veterinaria', 22, 10),
('Lugo', 'Escola Técnica de Enxeñaría', 22, 10),
('Lugo', 'Facultade de Formación do Profesorado', 22, 0);


-- Campus Santiago Sur | Facultade de Química
insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Santiago Sur', 'Facultade de Química', 1, 'coche'),
('Santiago Sur', 'Facultade de Química', 2, 'coche'),
('Santiago Sur', 'Facultade de Química', 3, 'coche'),
('Santiago Sur', 'Facultade de Química', 4, 'coche'),
('Santiago Sur', 'Facultade de Química', 5, 'coche'),
('Santiago Sur', 'Facultade de Química', 6, 'coche'),
('Santiago Sur', 'Facultade de Química', 7, 'coche'),
('Santiago Sur', 'Facultade de Química', 8, 'coche'),
('Santiago Sur', 'Facultade de Química', 9, 'coche'),
('Santiago Sur', 'Facultade de Química', 10, 'coche'),
('Santiago Sur', 'Facultade de Química', 11, 'coche'),
('Santiago Sur', 'Facultade de Química', 12, 'coche'),
('Santiago Sur', 'Facultade de Química', 13, 'coche'),
('Santiago Sur', 'Facultade de Química', 14, 'coche'),
('Santiago Sur', 'Facultade de Química', 15, 'coche'),
('Santiago Sur', 'Facultade de Química', 16, 'coche'),
('Santiago Sur', 'Facultade de Química', 17, 'coche'),
('Santiago Sur', 'Facultade de Química', 18, 'moto'),
('Santiago Sur', 'Facultade de Química', 19, 'moto'),
('Santiago Sur', 'Facultade de Química', 20, 'moto'),
('Santiago Sur', 'Facultade de Química', 21, 'moto'),
('Santiago Sur', 'Facultade de Química', 22, 'moto');


-- Campus Santiago Sur | CIBUS
insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Santiago Sur', 'CIBUS', 1, 'coche'),
('Santiago Sur', 'CIBUS', 2, 'coche'),
('Santiago Sur', 'CIBUS', 3, 'coche'),
('Santiago Sur', 'CIBUS', 4, 'coche'),
('Santiago Sur', 'CIBUS', 5, 'coche'),
('Santiago Sur', 'CIBUS', 6, 'coche'),
('Santiago Sur', 'CIBUS', 7, 'coche'),
('Santiago Sur', 'CIBUS', 8, 'coche'),
('Santiago Sur', 'CIBUS', 9, 'coche'),
('Santiago Sur', 'CIBUS', 10, 'coche'),
('Santiago Sur', 'CIBUS', 11, 'coche'),
('Santiago Sur', 'CIBUS', 12, 'coche'),
('Santiago Sur', 'CIBUS', 21, 'moto'),
('Santiago Sur', 'CIBUS', 22, 'moto');

insert into plazasprivadas (campusParking, centroParking, id, tamanho) values
('Santiago Sur', 'CIBUS', 13, 'coche'),
('Santiago Sur', 'CIBUS', 14, 'coche'),
('Santiago Sur', 'CIBUS', 15, 'coche'),
('Santiago Sur', 'CIBUS', 16, 'coche'),
('Santiago Sur', 'CIBUS', 17, 'coche'),
('Santiago Sur', 'CIBUS', 18, 'moto'),
('Santiago Sur', 'CIBUS', 19, 'moto'),
('Santiago Sur', 'CIBUS', 20, 'moto');

-- Campus Santiago Sur | Facultade de Farmacia
insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Santiago Sur', 'Facultade de Farmacia', 1, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 2, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 3, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 4, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 5, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 6, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 7, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 8, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 9, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 10, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 11, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 12, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 13, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 14, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 15, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 16, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 18, 'moto'),
('Santiago Sur', 'Facultade de Farmacia', 19, 'moto'),
('Santiago Sur', 'Facultade de Farmacia', 20, 'moto'),
('Santiago Sur', 'Facultade de Farmacia', 21, 'moto');

insert into plazasprivadas (campusParking, centroParking, id, tamanho) values
('Santiago Sur', 'Facultade de Farmacia', 17, 'coche'),
('Santiago Sur', 'Facultade de Farmacia', 22, 'moto');


-- Campus Santiago Sur | Facultade de Física
insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Santiago Sur', 'Facultade de Física', 1, 'coche'),
('Santiago Sur', 'Facultade de Física', 2, 'coche'),
('Santiago Sur', 'Facultade de Física', 3, 'coche'),
('Santiago Sur', 'Facultade de Física', 4, 'coche'),
('Santiago Sur', 'Facultade de Física', 5, 'coche'),
('Santiago Sur', 'Facultade de Física', 6, 'coche'),
('Santiago Sur', 'Facultade de Física', 7, 'coche'),
('Santiago Sur', 'Facultade de Física', 8, 'coche'),
('Santiago Sur', 'Facultade de Física', 9, 'coche'),
('Santiago Sur', 'Facultade de Física', 19, 'moto'),
('Santiago Sur', 'Facultade de Física', 20, 'moto');

insert into plazasPrivadas (campusParking, centroParking, id, tamanho) values 
('Santiago Sur', 'Facultade de Física', 10, 'coche'),
('Santiago Sur', 'Facultade de Física', 11, 'coche'),
('Santiago Sur', 'Facultade de Física', 12, 'coche'),
('Santiago Sur', 'Facultade de Física', 13, 'coche'),
('Santiago Sur', 'Facultade de Física', 14, 'coche'),
('Santiago Sur', 'Facultade de Física', 15, 'coche'),
('Santiago Sur', 'Facultade de Física', 16, 'coche'),
('Santiago Sur', 'Facultade de Física', 17, 'coche'),
('Santiago Sur', 'Facultade de Física', 18, 'coche'),
('Santiago Sur', 'Facultade de Física', 21, 'moto'),
('Santiago Sur', 'Facultade de Física', 22, 'moto');


-- Campus Santiago Sur | ETSE
insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Santiago Sur', 'ETSE', 1, 'coche'),
('Santiago Sur', 'ETSE', 2, 'coche'),
('Santiago Sur', 'ETSE', 3, 'coche'),
('Santiago Sur', 'ETSE', 4, 'coche'),
('Santiago Sur', 'ETSE', 5, 'coche'),
('Santiago Sur', 'ETSE', 6, 'coche'),
('Santiago Sur', 'ETSE', 7, 'coche'),
('Santiago Sur', 'ETSE', 8, 'coche'),
('Santiago Sur', 'ETSE', 9, 'coche'),
('Santiago Sur', 'ETSE', 10, 'coche'),
('Santiago Sur', 'ETSE', 11, 'coche'),
('Santiago Sur', 'ETSE', 12, 'coche');

insert into plazasprivadas (campusParking, centroParking, id, tamanho) values
('Santiago Sur', 'ETSE', 13, 'coche'),
('Santiago Sur', 'ETSE', 14, 'coche'),
('Santiago Sur', 'ETSE', 15, 'coche'),
('Santiago Sur', 'ETSE', 16, 'coche'),
('Santiago Sur', 'ETSE', 17, 'coche'),
('Santiago Sur', 'ETSE', 18, 'moto'),
('Santiago Sur', 'ETSE', 19, 'moto'),
('Santiago Sur', 'ETSE', 20, 'moto'),
('Santiago Sur', 'ETSE', 21, 'moto'),
('Santiago Sur', 'ETSE', 22, 'moto');


-- Campus Santiago Norte | Facultade de Filoloxía
insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Santiago Norte', 'Facultade de Filoloxía', 1, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 2, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 3, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 4, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 5, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 6, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 7, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 8, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 9, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 10, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 11, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 12, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 13, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 14, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 15, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 16, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 17, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 19, 'moto'),
('Santiago Norte', 'Facultade de Filoloxía', 20, 'moto'),
('Santiago Norte', 'Facultade de Filoloxía', 21, 'moto');

insert into plazasPrivadas (campusParking, centroParking, id, tamanho) values 
('Santiago Norte', 'Facultade de Filoloxía', 18, 'coche'),
('Santiago Norte', 'Facultade de Filoloxía', 22, 'moto');


-- Campus Santiago Norte | Facultade de Economia
insert into plazasPrivadas (campusParking, centroParking, id, tamanho) values 
('Santiago Norte', 'Facultade de Economia', 1, 'coche'),
('Santiago Norte', 'Facultade de Economia', 2, 'coche'),
('Santiago Norte', 'Facultade de Economia', 3, 'coche'),
('Santiago Norte', 'Facultade de Economia', 4, 'coche'),
('Santiago Norte', 'Facultade de Economia', 5, 'coche'),
('Santiago Norte', 'Facultade de Economia', 6, 'coche'),
('Santiago Norte', 'Facultade de Economia', 7, 'coche'),
('Santiago Norte', 'Facultade de Economia', 8, 'coche'),
('Santiago Norte', 'Facultade de Economia', 9, 'coche'),
('Santiago Norte', 'Facultade de Economia', 10, 'coche'),
('Santiago Norte', 'Facultade de Economia', 11, 'coche'),
('Santiago Norte', 'Facultade de Economia', 12, 'coche'),
('Santiago Norte', 'Facultade de Economia', 21, 'moto'),
('Santiago Norte', 'Facultade de Economia', 22, 'moto');


insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Santiago Norte', 'Facultade de Economia', 15, 'coche'),
('Santiago Norte', 'Facultade de Economia', 16, 'coche'),
('Santiago Norte', 'Facultade de Economia', 17, 'coche'),
('Santiago Norte', 'Facultade de Economia', 18, 'coche'),
('Santiago Norte', 'Facultade de Economia', 19, 'moto'),
('Santiago Norte', 'Facultade de Economia', 20, 'moto'),
('Santiago Norte', 'Facultade de Economia', 13, 'coche'),
('Santiago Norte', 'Facultade de Economia', 14, 'coche');


-- Campus Santiago Norte | Facultade de Periodismo
insert into plazasPrivadas (campusParking, centroParking, id, tamanho) values 
('Santiago Norte', 'Facultade de Periodismo', 1, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 2, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 3, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 4, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 5, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 6, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 21, 'moto'),
('Santiago Norte', 'Facultade de Periodismo', 22, 'moto');



insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Santiago Norte', 'Facultade de Periodismo', 7, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 8, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 9, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 10, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 11, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 12, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 13, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 14, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 15, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 16, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 17, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 18, 'coche'),
('Santiago Norte', 'Facultade de Periodismo', 19, 'moto'),
('Santiago Norte', 'Facultade de Periodismo', 20, 'moto');


-- Campus Lugo | Plazas de Facultade de Formación do Profesorado
insert into plazasPublicas (campusParking, centroParking, id, tamanho) values 
('Lugo', 'Facultade de Formación do Profesorado', 1, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 2, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 3, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 4, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 5, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 6, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 7, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 8, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 9, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 10, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 11, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 12, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 13, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 14, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 15, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 16, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 17, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 18, 'coche'),
('Lugo', 'Facultade de Formación do Profesorado', 19, 'moto'),
('Lugo', 'Facultade de Formación do Profesorado', 20, 'moto'),
('Lugo', 'Facultade de Formación do Profesorado', 21, 'moto'),
('Lugo', 'Facultade de Formación do Profesorado', 22, 'moto');


-- Campus Lugo | Plazas de Facultade de Veterinaria
insert into plazasPrivadas (campusParking, centroParking, id, tamanho) values
('Lugo', 'Facultade de Veterinaria', 1, 'coche'),
('Lugo', 'Facultade de Veterinaria', 2, 'coche'),
('Lugo', 'Facultade de Veterinaria', 3, 'coche'),
('Lugo', 'Facultade de Veterinaria', 4, 'coche'),
('Lugo', 'Facultade de Veterinaria', 5, 'coche'),
('Lugo', 'Facultade de Veterinaria', 6, 'coche'),
('Lugo', 'Facultade de Veterinaria', 7, 'coche'),
('Lugo', 'Facultade de Veterinaria', 8, 'coche'),
('Lugo', 'Facultade de Veterinaria', 9, 'coche'),
('Lugo', 'Facultade de Veterinaria', 10, 'coche'),
('Lugo', 'Facultade de Veterinaria', 11, 'coche'),
('Lugo', 'Facultade de Veterinaria', 22, 'moto');

insert into plazasPublicas (campusParking, centroParking, id, tamanho) values
('Lugo', 'Facultade de Veterinaria', 12, 'coche'),
('Lugo', 'Facultade de Veterinaria', 13, 'coche'),
('Lugo', 'Facultade de Veterinaria', 14, 'coche'),
('Lugo', 'Facultade de Veterinaria', 15, 'coche'),
('Lugo', 'Facultade de Veterinaria', 16, 'coche'),
('Lugo', 'Facultade de Veterinaria', 17, 'coche'),
('Lugo', 'Facultade de Veterinaria', 18, 'coche'),
('Lugo', 'Facultade de Veterinaria', 19, 'moto'),
('Lugo', 'Facultade de Veterinaria', 20, 'moto'),
('Lugo', 'Facultade de Veterinaria', 21, 'moto');


-- Campus Lugo | Plazas da Escola Técnica de Enxeñaría
insert into plazasPrivadas (campusParking, centroParking, id, tamanho) values 
('Lugo', 'Escola Técnica de Enxeñaría', 1, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 2, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 3, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 4, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 5, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 6, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 7, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 8, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 9, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 10, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 11, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 12, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 13, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 14, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 15, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 16, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 17, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 18, 'coche'),
('Lugo', 'Escola Técnica de Enxeñaría', 19, 'moto'),
('Lugo', 'Escola Técnica de Enxeñaría', 20, 'moto');

insert into plazasPublicas (campusParking, centroParking, id, tamanho) values 
('Lugo', 'Escola Técnica de Enxeñaría', 21, 'moto'),
('Lugo', 'Escola Técnica de Enxeñaría', 22, 'moto');


-- APARCAR
insert into aparcar (fechaEntrada, fechaSalida, precioHora, matriculaVehiculo, campusParking, centroParking, idPlaza) values
('2022-10-10 08:00:00', '2022-10-10 14:30:00', 1.45, '3457RGF', 'Santiago Sur', 'Facultade de Química', 1),
('2022-11-02 14:15:00', null, 1.45, '2189DKL', 'Santiago Sur', 'ETSE', 5),
('2022-11-23 10:30:00', '2022-11-23 17:00:00', 1.45, '1935SQL', 'Santiago Norte', 'Facultade de Filoloxía', 2),
('2022-12-20 17:30:00', '2022-12-20 21:00:00', 1.45, '3827KPH', 'Lugo', 'Facultade de Veterinaria', 15),
('2022-10-15 11:45:00', '2022-10-15 17:30:00', 1.45, '1234VFD', 'Santiago Sur', 'Facultade de Farmacia', 4),
('2022-11-12 08:30:00', null, 1.45, '4647JJB', 'Santiago Sur', 'Facultade de Física', 3),
('2022-11-27 14:15:00', '2022-11-27 20:00:00', 1.45, '4940FJK', 'Santiago Norte', 'Facultade de Economia', 18),
('2022-12-18 11:30:00', null, 1.45, '2581FMD', 'Santiago Norte', 'Facultade de Filoloxía', 2),
('2022-10-22 08:00:00', '2022-10-22 12:30:00', 1.45, '9737HHH', 'Santiago Sur', 'ETSE', 1),
('2022-11-10 14:15:00', null, 1.45, '8111LML', 'Santiago Sur', 'ETSE', 5),
('2022-11-30 10:30:00', '2022-11-30 17:00:00', 1.45, '7890KLM', 'Santiago Norte', 'Facultade de Filoloxía', 2),
('2023-04-23 09:30:00', NULL, 1.45, '3457RGF', 'Santiago Sur', 'Facultade de Química', 1),
('2023-04-23 10:15:00', '2023-04-23 12:30:00', 1.45, '9737HHH', 'Santiago Norte', 'Facultade de Economia', 20),
('2023-04-22 14:20:00', '2023-04-22 18:10:00', 1.45, '2581FMD', 'Lugo', 'Facultade de Veterinaria', 21),
('2023-04-22 08:00:00', null, 1.45, '7341HPR', 'Santiago Sur', 'Facultade de Física', 4),
('2023-04-21 12:00:00', '2023-04-21 15:30:00', 1.45, '4940FJK', 'Santiago Sur', 'ETSE', 5),
('2023-04-23 10:30:00', '2023-04-23 13:15:00', 1.45, '6734NDD', 'Lugo', 'Escola Técnica de Enxeñaría', 22),
('2023-04-23 09:00:00', null, 1.45, '9012BCD', 'Santiago Norte', 'Facultade de Filoloxía', 7),
('2023-04-21 14:45:00', '2023-04-21 17:30:00', 1.45, '1234VFD', 'Santiago Sur', 'Facultade de Física', 8),
('2023-04-20 16:00:00', '2023-04-20 18:30:00', 1.45, '1286BXS', 'Santiago Sur', 'Facultade de Farmacia', 9),
('2023-04-22 09:30:00', '2023-04-22 12:15:00', 1.45, '7890KLM', 'Santiago Norte', 'Facultade de Periodismo', 11),
('2023-04-23 15:00:00', '2023-04-23 17:45:00', 1.45, '8632BGJ', 'Santiago Sur', 'ETSE', 12),
('2023-04-21 11:00:00', null, 1.45, '9823LKW', 'Santiago Norte', 'Facultade de Filoloxía', 13);





INSERT INTO reservar (fechaInicio, fechaFin, precioHora, dniMiembroUSC, campusParking, centroParking, idPlaza) VALUES
('2023-05-03 10:30:00', '2023-05-03 22:30:00', 1.20, '19681229Z', 'Santiago Norte', 'Facultade de Periodismo', 4),
('2023-05-03 11:00:00', '2023-05-10 07:00:00', 1.20, '06124565X', 'Lugo', 'Escola Técnica de Enxeñaría', 5),
('2023-05-03 10:45:00', '2023-05-10 01:45:00', 1.20, '97288336S', 'Santiago Norte', 'Facultade de Economia', 3),
('2023-05-03 12:00:00', '2023-05-10 08:00:00', 1.20, '04579694A', 'Santiago Norte', 'Facultade de Economia', 5),
('2023-05-03 10:20:00', '2023-05-09 20:20:00', 1.20, '54654082X', 'Santiago Norte', 'Facultade de Periodismo', 1),
('2023-05-03 11:15:00', '2023-05-10 05:15:00', 1.20, '99104956A', 'Santiago Norte', 'Facultade de Periodismo', 4),
('2023-05-03 10:40:00', '2023-05-10 00:40:00', 1.20, '19681229Z', 'Santiago Norte', 'Facultade de Periodismo', 5),
('2023-05-03 11:30:00', '2023-05-10 03:30:00', 1.20, '18491235V', 'Lugo', 'Facultade de Veterinaria', 7),
('2023-05-03 11:45:00', '2023-05-10 05:45:00', 1.20, '06124565X', 'Lugo', 'Escola Técnica de Enxeñaría', 2),
('2023-05-03 10:50:00', '2023-05-10 02:50:00', 1.20, '97288336S', 'Santiago Norte', 'Facultade de Economia', 2),
('2023-05-03 10:10:00', '2023-05-09 18:10:00', 1.20, '28372890K', 'Lugo', 'Facultade de Veterinaria', 2),
('2023-05-03 11:20:00', '2023-05-10 03:20:00', 1.20, '21982530G', 'Lugo', 'Escola Técnica de Enxeñaría', 4),
('2023-05-03 12:15:00', '2023-05-10 08:15:00', 1.20, '04579694A', 'Santiago Norte', 'Facultade de Economia', 3),
('2023-05-03 11:10:00', '2023-05-10 03:10:00', 1.20, '24451980J', 'Santiago Norte', 'Facultade de Periodismo', 4),
('2023-05-03 12:30:00', '2023-05-10 08:30:00', 1.20, '13905382L', 'Lugo', 'Facultade de Veterinaria', 2),
('2023-05-03 10:35:00', '2023-05-10 00:35:00', 1.20, '19681229Z', 'Santiago Norte', 'Facultade de Economia', 4);

--  ASIGNAR
INSERT INTO asignar (fechaInicio, fechaFin, dniPDI, campusParking, centroParking, idPlaza) VALUES
('2023-09-01', '2024-06-01', '54654082X', 'Santiago Norte', 'Facultade de Periodismo', 1),
('2023-10-01', '2024-07-01', '54654082X', 'Santiago Norte', 'Facultade de Economia', 2),
('2023-11-01', '2024-08-01', '54654082X', 'Santiago Norte', 'Facultade de Filoloxía', 18),
('2023-10-01', '2024-07-01', '97288336S', 'Santiago Sur', 'CIBUS', 17),
('2023-10-01', '2024-07-01', '97288336S', 'Santiago Sur', 'Facultade de Farmacia', 22),
('2023-11-15', '2024-06-15', '19681229Z', 'Santiago Sur', 'ETSE', 13),
('2023-10-15', '2024-07-15', '13905382L', 'Lugo', 'Escola Técnica de Enxeñaría', 3),
('2023-10-01', '2024-07-01', '21982530G', 'Santiago Sur', 'Facultade de Física', 15),
('2023-12-01', '2024-09-01', '48040257L', 'Santiago Norte', 'Facultade de Periodismo', 2),
('2023-10-01', '2024-07-01', '48040257L', 'Santiago Norte', 'Facultade de Economia', 1),
('2022-01-01', '2022-09-30', '54654082X', 'Santiago Norte', 'Facultade de Economia', 2),
('2022-02-01', '2022-10-31', '54654082X', 'Lugo', 'Escola Técnica de Enxeñaría', 1),
('2022-04-01', '2022-11-30', '18491235V', 'Santiago Norte', 'Facultade de Economia', 1),
('2022-07-01', '2023-03-31', '48040257L', 'Santiago Norte', 'Facultade de Periodismo', 2),
('2022-08-01', '2023-03-31', '48040257L', 'Lugo', 'Escola Técnica de Enxeñaría', 2),
('2022-10-01', '2023-05-31', '13905382L', 'Lugo', 'Facultade de Veterinaria', 2),
('2023-02-01', '2023-09-30', '38289664T', 'Lugo', 'Escola Técnica de Enxeñaría', 2),
('2023-03-01', '2023-10-31', '38289664T', 'Lugo', 'Facultade de Veterinaria', 3);
