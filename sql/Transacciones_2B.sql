
---------- TRANSACCIONES DE LA BASE DE DATOS ----------


--- TRANSACCIONES ASOCIADAS AL ADMINISTRADOR ---

--Transaccion 1: Introducir los datos de registro de un nuevo usuario en la base de datos.
begin transaction;

	insert into miembrosusc (dni, nombreCompleto, correoElectronico, contrasenha, telefono, saldo, rol, fechaIngreso)
	values ('54654082X', 'José María Alonso Moral', 'josemaria.alonso@usc.es',
            hash_password('JMAM432'), '881816432', 45, 'usuario', '2008-05-23');

commit transaction;

--Transaccion 2: Actualizar el numero de infracciones de un vehiculo.
begin transaction;

	-- Se actualiza el numero de infracciones de un vehiculo
	update vehiculos set numeroInfracciones = numeroInfracciones + 1 where matricula like '3457RGF';
	
	-- Guardamos los cambios sobre el atributo numeroInfracciones por si tenemos que revertir la transaccion
	savepoint save1;

	-- Se consulta el numero de infracciones totales del miembro de la USC en cuestion (utilizando una de las vistas)
	with totalInfracciones as (
	    select sum(numeroInfracciones) as totalInfracciones
	    from vehiculos_con_infracciones 
	    where dni like '3457RGF')
	
	-- Si el miembro tiene 5 infracciones totales se le veta del sistema asignando el rol correspondiente
	update miembrosusc set rol = 'vetado' where dni in (
	    select dni
	    from totalInfracciones
	    where totalInfracciones = 5);

commit transaction;

-- Transaccion 3: Modificar el saldo de los usuarios.
begin transaction;

	update miembrosusc set saldo = saldo + 100 where dni like '54654082X';

commit transaction;

-- Transaccion 4: Asignar plazas a los profesores de la universidad.
begin transaction;

	insert into asignar (fechaInicio, fechaFin, dniPDI, campusParking, centroParking, idPlaza)
	values ('2015-05-09', null, '54654082X', 'Santiago Sur', 'ETSE', 1);

commit transaction;

-- Transaccion 5: Liberar la plaza asignada a un profesor de la universidad.
begin transaction;

	update asignar
	set fechaFin = current_date;
	where dniPDI = '54654082X' and campusParking = 'Santiago Sur' and centroParking = 'ETSE' and idPlaza = 1;

commit transaction;

-- Transaccion 6: Registrar un aparcamiento de un vehiculo en un parking.
begin transaction;

	insert into aparcar (fechaEntrada, fechaSalida, precioHora, matriculaVehiculo, campusParking, centroParking, idPlaza)
	values ('2018-07-23 12:00:00', null, 1.47, '3457RGF', 'Santiago Sur', 'CIBUS', 4);

commit transaction;

-- Transaccion 7: Registrar la salida de un vehiculo de un parking.
begin transaction;

	update aparcar set fechaSalida = current_date where matriculavehiculo like '3457RGF';

commit transaction;


--- TRANSACCIONES ASOCIADAS AL USUARIO ---

-- Transaccion 8: Ingresar un nuevo vehiculo, con todos sus datos asociados.
begin transaction;

	insert into vehiculos (matricula, tipo, marca, modelo, numeroInfracciones, dniMiembroUSC)
	values ('3457RGF', 'coche', 'Audi', 'A3', 2, '54654082X');

commit transaction;

-- Transaccion 9: Retirar un vehiculo.
begin transaction;

	update vehiculos set matricula = default where matricula like '3457RGF';

commit transaction;

-- Transaccion 10: Registrar una reserva de un vehiculo en un parking
begin transaction;

	insert into reservar (fechaInicio, fechaFin, precioHora, dniMiembroUSC, campusParking, centroParking, idPlaza)
	values ('2022-09-09 20:00:00', '2024-11-09 22:00:00', 0.89, '54654082X', 'Santiago Sur', 'Facultade de Física', 10);

commit transaction;

-- Transaccion 11: Cancelar una reserva de un vehiculo en un parking
begin transaction;
	
	-- Se le devuelve la mitad del coste de la reserva al cancelarla
	update miembrosusc set saldo = saldo + 
		(select (extract(epoch FROM age(fechaFin, fechaInicio)) / 3600) * precioHora * 0.5
		from reservar
		where fechaInicio = '2022-09-09 20:00:00'
		and dnimiembrousc = '54654082X'
		and campusParking = 'Santiago Sur'
		and centroParking = 'Facultade de Física'
		and idPlaza = 10
		and extract(epoch from age(fechaFin, current_date)) > 0)
	where dni = '54654082X';

	-- Guardamos los cambios sobre el saldo por si tenemos que revertir la transaccion
	savepoint save1;

	-- Actualizamos fechaFin ala fecha en la que se ejecuta la transaccion, de esta forma indicamos que la plaza queda libre
	update reservar set fechaFin = current_date
		where fechaInicio = '2022-09-09 20:00:00'
		and dnimiembrousc like '54654082X'
		and campusparking like 'Santiago Sur'
		and centroparking like 'Facultade de Física'
		and idplaza = 10
		and extract(epoch from age(fechaFin, current_date)) > 0;

commit transaction;

-- Transaccion 12: Modificar los datos de la cuenta.
begin transaction;

	update miembrosusc
	set nombreCompleto = 'Josema Alonso Moral', contrasenha = hash_password('JAM275'), telefono = '881815439'
	where dni like '54654082X' and contrasenha like hash_password('JMAM432');

commit transaction;

-- Transaccion 13: Eliminar cuenta.
begin transaction;

	update miembrosusc set dni = default where dni like '54654082X';

commit transaction;


--- TRANSACCIONES ADICIONALES (NO JAVA) ---

-- Transaccion 14: Agregar una nueva plaza publica a un parking.
begin transaction;

	insert into plazaspublicas (campusParking, centroParking, id, tamanho)
	values ('Santiago Sur', 'ETSE', 1, 'coche');

commit transaction;


-- Transaccion 15: Agregar un nuevo parking al conjunto de aparcamientos de la USC.
begin transaction;

	insert into parkings (campus, centro, capacidad, maximoPrivadas)
	values ('Santiago Sur', 'ETSE', 22, 0);

commit transaction;

-- Transaccion 16: Eliminar una plaza publica de un parking.
begin transaction;

	delete from plazaspublicas
	where campusParking = 'Santiago Sur' and centroParking = 'ETSE' and id = 1;

commit transaction;

-- Transaccion 17: Eliminar un parking del conjunto de aparcamientos de la USC.
begin transaction;

	delete from parkings
	where campus = 'Santiago Sur' and centro = 'ETSE';

commit transaction;

-- Transaccion 18: Aumentar en 10€ el saldo de los miembros con una antigüedad superior a 10 años sin infracciones en un vehiculo
begin transaction;

	-- Se actualiza el saldo de los miembros de la USC
	update miembrosusc
	set saldo = saldo + 10
	
	-- Subconsulta para filtrar los miembros que tienen al menos un vehiculo sin infracciones
	from (
	    select dni
	    from vehiculos_con_propietarios 
	    where numeroInfracciones = 0
	) as v
	
	-- Se obtienen los miembros con una antigüedad superior a 10 años
	where miembrosusc.dni = v.dni
	and date_part('year', age(current_date, fechaIngreso)) > 10;

commit transaction;

-- Transaccion 19: Modificar el rol de un miembro de la USC
begin transaction;

	update miembrosusc set rol = 'administrador' where dni like '54654082X';

commit transaction;

-- Transaccion 20: Poner una multa a un miembro de la universidad
begin transaction;
	
	-- Se reduce el saldo del propietario en funcion de la multa
	update miembrosusc
	set saldo = saldo - 100.0
	where dni in (
		select dni
	  	from vehiculos_con_propietarios 
	  	where matricula = '3457RGF'); 
	  
  	-- Guardamos los cambios sobre el atributo saldo por si tenemos que revertir la transaccion
	savepoint save1;

	-- Se cambia el rol del miembro de la universidad si el saldo es negativo
	update miembrosusc set rol = 'moroso' where saldo < 0 and dni in (
	  	select dni
	  	from vehiculos_con_propietarios 
	  	where matricula = '3457RGF');

commit transaction;
