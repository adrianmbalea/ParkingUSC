-- 1. Obtener los datos de registro introducidos por un usuario en la pantalla de registro 
-- (correo electrónico y contraseña) en la tabla de usuarios para comprobar si el usuario existe. 
-- A mayores, si el usuario acumula 5 infracciones entre todos sus vehículos, no se permitirá su 
-- acceso en la interfaz de registro, de forma que la consulta devu elve este número. 
-- También se devuelve el rol para determinar qué tipo de acceso se obtiene.
select m.correoelectronico, m.rol, sum(v.numeroinfracciones)
from miembrosusc m, vehiculos v
where m.dni = v.dnimiembrousc 
and m.correoelectronico = 'josemaria.alonso@usc.es'
group by m.correoelectronico, m.rol ;

-- 2. Obtener los datos asociados a todos los vehículos de un usuario concreto para su 
-- representación por pantalla.
select *
from vehiculos v 
where v.dnimiembrousc = '97288336S'

-- 3. Obtener la información asociada al usuario para su representación por pantalla.
select *
from miembrosusc m 
where m.dni = '24451980J'

-- 4. Mostrar los datos asociados a todas las plazas de un determinado parking: 
-- número de plaza, su ocupación, tipo (privada o pública) y tamaño. Uso de vistas
select cp.numero_plaza,
       case 
           when oa.matriculaVehiculo is null then 'Libre'
           else 'Ocupada'
       end as ocupacion,
       cp.tipo_plaza,
       cp.tamanho_plaza
from parkings p
join combined_plazas cp on p.campus = cp.campusParking and p.centro = cp.centroParking
left join ocupacion_actual oa on cp.campusParking = oa.campusParking and 
cp.centroParking = oa.centroParking and cp.numero_plaza = oa.idPlaza
where p.campus = 'Lugo' and p.centro = 'Escola Técnica de Enxeñaría';


-- 5. Mostrar todas las reservas realizadas por un usuario en cada párking, 
-- así como las plazas asignadas.
select r.fechaInicio, r.fechaFin, p.campus, p.centro 
from reservar r
left join plazasPrivadas pp on r.campusParking = pp.campusParking and 
r.centroParking = pp.centroParking and r.idPlaza = pp.id
left join plazasPublicas pb on r.campusParking = pb.campusParking and 
r.centroParking = pb.centroParking and r.idPlaza = pb.id
inner join parkings p on p.campus = coalesce(pp.campusParking, pb.campusParking) 
and p.centro = coalesce(pp.centroParking, pb.centroParking)
where r.dniMiembroUSC = '24451980J'
order by r.fechaInicio asc;

-- 6. Obtener el numero de vehiculos en funcion de su tipo
select tipo, count(*) as cantidad
from vehiculos
group by tipo;

-- 7. Obtener la cantidad de vehículos de cada marca 
-- y modelo que han cometido infracciones:
select marca, modelo, count(*) as cantidad_infracciones
from vehiculos
where numeroInfracciones > 0
group by marca, modelo
order by modelo asc;

-- 8. Obtener el numero de plazas publicas disponibles en un parking concreto
select count(*) as cantidad
from plazasPublicas
where campusParking = 'Santiago Norte'
and centroParking = 'Facultade de Economia'
and id not in(select idPlaza
			  from aparcar
  			  where campusParking = 'Santiago Norte' and 
  			  centroParking = 'Facultade de Economia'
  			  and fechaSalida is null);

-- 9. Obtener cual es el centro con el mayor numero de plazas privadas 
select p.campus, p.centro, count(*) as cantidadPrivadas
from parkings p
inner join plazasPrivadas pp on p.campus = pp.campusParking
and p.centro = pp.centroParking
group by p.campus, p.centro
having count(*) = (
    select max(cantidad)
    from (
        select count(*) as cantidad
        from plazasPrivadas
        group by campusParking, centroParking
    ) cantidad
);

-- 10. Obtener aquellos parkings en los que un determinado PDI tenga una plaza asignada
select distinct a. pp.campusParking, pp.centroParking
from plazasPrivadas pp
join asignar a on pp.campusParking = a.campusParking 
and pp.centroParking = a.centroParking and pp.id = a.idPlaza
where a.dniPDI = '38289664T';

-- 11. Consulta que nos devuelve si hay algun vehiculo aparcado en una plaza que no 
-- le corresponde por no ser de su tipo (coche o moto)
select a.matriculaVehiculo, a.fechaEntrada, a.campusParking, 
a.centroParking, a.idPlaza, v.tipo as tipo_vehiculo, pp.tamanho as tamanho_plaza
from aparcar a
join plazasPublicas pp on (a.campusParking, a.centroParking, a.idPlaza) = 
(pp.campusParking, pp.centroParking, pp.id)
join vehiculos v on a.matriculaVehiculo = v.matricula
where (v.tipo = 'coche' and pp.tamanho = 'moto') or (v.tipo = 'moto' 
and pp.tamanho = 'coche');

-- 12. Consultamos el numero de plazas de cada tipo que hay en cada centro
select p.campus, p.centro, count(*) as total_plazas_privadas, 
       (select count(*) from plazasPublicas where campusParking = p.campus and 
       centroParking = p.centro) as total_plazas_publicas
from plazasPrivadas pp
join parkings p on pp.campusParking = p.campus and pp.centroParking = p.centro
group by p.campus, p.centro;

--13. Consulta que muestra el estado de una plaza determinada de un parkin concreto 
-- en una fecha elegida
select 
  case 
    when a.matriculaVehiculo is not null then 'ocupada'
    when r.dniMiembroUSC is not null then 'reservada'
    when s.dniPDI is not null then 'asignada'
    else 'libre'
  end as estado_plaza
from 
  (select campusParking, centroParking, id, tamanho
   from plazasPublicas
   where campusParking = 'Santiago Sur' and centroParking = 'CIBUS' and id = 17
  union all
  select campusParking, centroParking, id, tamanho
  from plazasPrivadas
  where campusParking = 'Santiago Sur' and centroParking = 'CIBUS' and id = 17) as p
  left join aparcar a on p.campusParking = a.campusParking and p.centroParking = a.centroParking 
  and p.id = a.idPlaza and a.fechaEntrada <= '2023-10-30' and (a.fechaSalida is null or a.fechaSalida >= '2023-10-30')
  left join reservar r on p.campusParking = r.campusParking and p.centroParking = r.centroParking 
  and p.id = r.idPlaza and r.fechaInicio <= '2023-10-30' and r.fechaFin >= '2023-10-30'
  left join asignar s on p.campusParking = s.campusParking and p.centroParking = s.centroParking 
  and p.id = s.idPlaza and s.fechaInicio <= '2023-10-30' and (s.fechafin is null or s.fechafin >= '2023-10-30');
 
 -- 14. Consulta que devuelve todas las reservas activas de un usuario
 -- en un periodo de tiempo determinado
select *
from reservar
where dniMiembroUSC = 'DNI_USUARIO' and fechaInicio <= current_timestamp 
and fechaFin >= current_timestamp;

-- 15. Consulta que devuelve el porcentaje de ocupación en cada parking
with total_plazas as (
select campusParking, centroParking, count(*) as total
from (select * from plazasPublicas union all select * from plazasPrivadas) as pp
group by campusParking, centroParking),

ocupadas as (
select campusParking, centroParking, count(*) as ocupadas
from aparcar
where fechaSalida is null 
group by campusParking, centroParking)

select p.campus, p.centro, 
round(coalesce ((ocupadas.ocupadas * 100.0) / total_plazas.total, 0),2) 
as porcentaje_ocupacion
from parkings p
left join total_plazas on p.campus = total_plazas.campusParking 
and p.centro = total_plazas.centroParking
left join ocupadas on p.campus = ocupadas.campusParking 
and p.centro = ocupadas.centroParking
group by p.campus, p.centro, ocupadas.ocupadas, total_plazas.total
order by porcentaje_ocupacion desc;


--16. Consulta que devuelve el tipo de una plaza determinada
select 
    case 
        when exists (
            select * from plazasPrivadas 
            where campusParking = 'CampusX' 
            and centroParking = 'CentroY' 
            and id = 123
        ) then 'Privada'
        when exists (
            select * from plazasPublicas 
            where campusParking = 'CampusX' 
            and centroParking = 'CentroY' 
            and id = 123
        ) then 'Pública'
        else 'No encontrada'
    end as TipoDePlaza
    
    