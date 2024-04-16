-- VISTAS

-- 1. Vista de vehiculos y sus respectivos propietarios
create or replace view vehiculos_con_propietarios as
select v.matricula, v.tipo, v.marca, v.modelo, v.numeroInfracciones, m.dni, 
m.nombreCompleto, m.correoElectronico, m.telefono
from vehiculos v
join miembrosusc m on v.dniMiembroUSC = m.dni;

-- 2. Vista que devuelve todas la asignaciones de la base de datos
create or replace view asignaciones_pdi as
select a.dniPDI, a.campusParking, a.centroParking, a.idPlaza, 
a.fechaInicio, a.fechaFin, m.nombreCompleto, m.correoElectronico, 
m.telefono
from asignar a
join pdi p on a.dniPDI = p.dniMiembroUSC
join miembrosusc m on p.dniMiembroUSC = m.dni;


-- 3. Vista que devuelve los vehiculos que hayan cometido infracciones
create or replace view vehiculos_con_infracciones as
select v.matricula, v.marca, v.modelo, v.numeroInfracciones, m.dni, 
m.nombreCompleto, m.correoElectronico, m.telefono
from vehiculos v
join miembrosusc m on v.dniMiembroUSC = m.dni
where v.numeroInfracciones > 0
order by v.numeroInfracciones desc;


-- 4. Vista que devuelve todas las plazas publicas y privadas con sus caracteristicas
create or replace view combined_plazas as (
    select pp.id as numero_plaza,'Privada' as tipo_plaza,
           pp.tamanho as tamanho_plaza,pp.campusParking,pp.centroParking
    from plazasPrivadas pp
    union all
    select pb.id as numero_plaza,'Publica' as tipo_plaza, pb.tamanho as tamanho_plaza,
    pb.campusParking, pb.centroParking
    from plazasPublicas pb
);

select * from combined_plazas cp;


-- 5. Vista para consultar la ocupacion actual de plazas publicas
create or replace view ocupacion_actual as (
    select matriculaVehiculo, campusParking, centroParking, idPlaza
    from aparcar
    where fechaSalida is null
);

select * from ocupacion_actual oa 

-- 6. 