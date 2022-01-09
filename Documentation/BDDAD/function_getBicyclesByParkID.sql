create or replace FUNCTION getBicyclesByParkID(id_parameter in VARCHAR) RETURN
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

	SELECT Vehicle.*, Bicycle.wheel_size
        FROM Vehicle, Bicycle
    	WHERE Vehicle.latitude_vehicle = latitudePar
     	AND Vehicle.longitude_vehicle = longitudePar
        AND Vehicle.id_vehicle = Bicycle.id_bicycle
        ORDER BY Bicycle.id_bicycle ASC;

	RETURN (resultado);
END;
/
