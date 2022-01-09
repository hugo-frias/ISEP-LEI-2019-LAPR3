create or replace FUNCTION getEScootersForEnergy(id_parameter in VARCHAR, energy in NUMBER) RETURN
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

	SELECT Vehicle.*, Electric_Scooter.type_escooter, Electric_Scooter.max_battery, Electric_Scooter.actual_battery, Electric_Scooter.motor
        FROM Vehicle, Electric_Scooter
    	WHERE Vehicle.latitude_vehicle = lati
     	AND Vehicle.longitude_vehicle = longi
	AND Vehicle.id_vehicle = Electric_Scooter.id_escooter
  AND Electric_Scooter.actual_battery >= energy;

	RETURN (resultado);
END;
/
