create or replace FUNCTION getParkIdByVehicle(VehicleID_parameter in VARCHAR) RETURN
VARCHAR is resultado varchar(10);
lati NUMBER(8,6);
longi NUMBER(8,6);

BEGIN
    select latitude_vehicle into lati
    from Vehicle
    where id_vehicle = vehicleID_parameter;

    select longitude_vehicle into longi
    from Vehicle
    where id_vehicle = vehicleID_parameter;



    SELECT id_place into resultado FROM Park
    INNER JOIN Place ON Park.id_park = Place.id_place
    WHERE latitude_place = lati
    AND longitude_place = longi;

return resultado;
END;
/

