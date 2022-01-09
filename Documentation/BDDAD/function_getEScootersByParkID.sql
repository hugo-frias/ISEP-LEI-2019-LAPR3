create or replace FUNCTION getEScootersByParkID(id_parameter in VARCHAR) RETURN
SYS_REFCURSOR AS
resultado sys_refcursor;
latitudePar NUMBER(8,6);
longitudePar NUMBER(8,6);

BEGIN
    SELECT latitude_place into latitudePar
    FROM Place
    WHERE id_place = id_parameter;

    SELECT longitude_place into longitudePar
    FROM Place
    WHERE id_place = id_parameter;

	OPEN resultado FOR
	
	SELECT Vehicle.*, Electric_Scooter.type_escooter, Electric_Scooter.max_battery, Electric_Scooter.actual_battery, Electric_Scooter.motor
        FROM Vehicle, Electric_Scooter
    	WHERE Vehicle.latitude_vehicle = latitudePar
     	AND Vehicle.longitude_vehicle = longitudePar
        AND Vehicle.id_vehicle = Electric_Scooter.id_escooter
        ORDER BY Electric_Scooter.id_escooter ASC;

	RETURN (resultado);
END;
/
