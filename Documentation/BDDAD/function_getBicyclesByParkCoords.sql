create or replace FUNCTION getBicyclesByParkCoords(latitudePar NUMBER, longitudePar in NUMBER) RETURN
SYS_REFCURSOR is resultado sys_refcursor;

BEGIN
	OPEN resultado FOR
	
	SELECT Vehicle.*, Bicycle.wheel_size
        FROM Vehicle, Bicycle
    	WHERE Vehicle.latitude_vehicle = latitudePar
     	AND Vehicle.longitude_vehicle = longitudePar
	AND Vehicle.id_vehicle = Bicycle.id_bicycle
    	ORDER BY Bicycle.ID_BICYCLE ASC;
	
	RETURN (resultado);
END;
/
