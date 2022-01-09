create or replace function getNumberOfEScootersByParkCoords(latitudePar in NUMBER, longitudePar in NUMBER) return NUMBER is
    numberOfScooters NUMBER(2,0);
BEGIN
    SELECT COUNT(*)
    into numberOfScooters
FROM Vehicle INNER JOIN Electric_Scooter
ON Vehicle.id_vehicle = Electric_Scooter.id_escooter
    WHERE VEHICLE.latitude_vehicle = latitudePar
    AND VEHICLE.longitude_vehicle = longitudePar;

    return numberOfScooters;

END;
/
