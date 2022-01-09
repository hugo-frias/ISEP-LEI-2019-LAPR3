create or replace FUNCTION getVehicle(latitude in NUMBER, longitude in NUMBER) RETURN
SYS_REFCURSOR is resultado sys_refcursor;

BEGIN
    OPEN resultado FOR

    SELECT id_vehicle FROM Vehicle 
    WHERE VEHICLE.latitude_vehicle = latitude
    AND VEHICLE.longitude_vehicle = longitude;

RETURN (resultado);
END;
/
