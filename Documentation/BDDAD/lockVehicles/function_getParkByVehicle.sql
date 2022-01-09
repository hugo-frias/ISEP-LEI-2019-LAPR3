create or replace FUNCTION getParkByVehicle(VehicleID_parameter in VARCHAR) RETURN
SYS_REFCURSOR is resultado sys_refcursor;
lati NUMBER(8,6);
longi NUMBER(8,6);

BEGIN
    select latitude_vehicle into lati
    from Vehicle
    where id_vehicle = vehicleID_parameter;

    select longitude_vehicle into longi
    from Vehicle
    where id_vehicle = vehicleID_parameter;

OPEN resultado FOR

    SELECT * FROM Park
    INNER JOIN Place ON Park.id_park = Place.id_place
    WHERE latitude_place = lati
    AND longitude_place = longi;

RETURN (resultado);
END;
/
