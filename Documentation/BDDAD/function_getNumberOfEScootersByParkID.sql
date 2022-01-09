create or replace function getNumberOfEScootersByParkID(id_parameter in VARCHAR) return NUMBER is
numberOfEScooters NUMBER(2,0);
lati NUMBER(8,6);
longi NUMBER(8,6);

BEGIN
    SELECT latitude_place into lati
    FROM Place
    WHERE UPPER(id_place) LIKE UPPER(id_parameter);

    SELECT longitude_place into longi
    FROM Place
    WHERE UPPER(id_place) LIKE UPPER(id_parameter);

    SELECT COUNT(*) into numberOfEScooters
FROM Vehicle INNER JOIN Electric_Scooter
ON Vehicle.id_vehicle = Electric_Scooter.id_escooter
    WHERE VEHICLE.latitude_vehicle = lati
    AND VEHICLE.longitude_vehicle = longi;

return numberOfEScooters;

END;
/
