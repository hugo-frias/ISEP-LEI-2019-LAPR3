create or replace FUNCTION getChargingEScootersByParkID(id_parameter in VARCHAR) RETURN
SYS_REFCURSOR AS
resultado sys_refcursor;
lati NUMBER(8,6);
longi NUMBER(8,6);

BEGIN
    SELECT latitude_place into lati
    FROM Place
    WHERE id_place = id_parameter;

    SELECT longitude_place into longi
    FROM Place
    WHERE id_place = id_parameter;

	OPEN resultado FOR
	
	SELECT Vehicle.*, Electric_Scooter.type_escooter, Electric_Scooter.max_battery, Electric_Scooter.actual_battery, Electric_Scooter.motor,((Electric_Scooter.max_battery - Electric_Scooter.actual_battery) * 60) / 1000 * 60
        FROM Vehicle, Electric_Scooter
    	WHERE Vehicle.latitude_vehicle = lati
     	AND Vehicle.longitude_vehicle = longi
	    AND Vehicle.id_vehicle = Electric_Scooter.id_escooter
        AND Electric_Scooter.actual_battery < Electric_Scooter.max_battery
        ORDER BY ((Electric_Scooter.max_battery - Electric_Scooter.actual_battery) * 60) / 1000 * 60 DESC, Electric_Scooter.id_escooter ASC;
    
	RETURN (resultado);
END;
/
