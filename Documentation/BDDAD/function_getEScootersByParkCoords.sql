create or replace FUNCTION getEScootersByParkCoords(latitudePar in NUMBER, longitudePar in NUMBER) RETURN
SYS_REFCURSOR is resultado sys_refcursor;

BEGIN
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
