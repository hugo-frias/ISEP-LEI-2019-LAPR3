create or replace FUNCTION getEScooterHighestBattery(park_id_parameter in VARCHAR) RETURN
SYS_REFCURSOR as 
resultado sys_refcursor;
lati NUMBER(8,6);
longi NUMBER(8,6);

BEGIN
    
select latitude_place into lati
    from place
    where id_place = park_id_parameter;

select longitude_place into longi
    from place
    where id_place = park_id_parameter;
    
OPEN resultado FOR

select * from ( SELECT Vehicle.*, Electric_Scooter.type_escooter, Electric_Scooter.max_battery, Electric_Scooter.actual_battery, Electric_Scooter.motor FROM Vehicle
    		INNER JOIN Electric_Scooter ON 
    		Vehicle.id_vehicle = Electric_Scooter.id_escooter 
    		WHERE latitude_vehicle = lati and longitude_vehicle = longi
            order by Electric_Scooter.actual_battery DESC )
            WHERE ROWNUM = 1;
            --FETCH FIRST ROW ONLY;

RETURN (resultado);
END;
/
