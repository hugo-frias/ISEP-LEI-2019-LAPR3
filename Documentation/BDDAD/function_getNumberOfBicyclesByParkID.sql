create or replace function getNumberOfBicyclesByParkID(id_parameter in VARCHAR) return NUMBER is
numberOfBicycles NUMBER(2,0);
lati NUMBER(8,6);
longi NUMBER(8,6);

BEGIN
    SELECT latitude_place into lati
    FROM Place
    WHERE UPPER(id_place) LIKE UPPER(id_parameter);

    SELECT longitude_place into longi
    FROM Place
    WHERE UPPER(id_place) LIKE UPPER(id_parameter);

    SELECT COUNT(*) into numberOfBicycles
FROM Vehicle INNER JOIN Bicycle
ON Vehicle.id_vehicle = Bicycle.id_bicycle
    WHERE VEHICLE.latitude_vehicle = lati
    AND VEHICLE.longitude_vehicle = longi;

return numberOfBicycles;

END;
/
