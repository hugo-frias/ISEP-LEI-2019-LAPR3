create or replace function getNumberOfBicyclesByParkCoords(latitudePar in NUMBER, longitudePar in NUMBER) return NUMBER is
    numberOfBicycles NUMBER(2,0);
BEGIN
    SELECT COUNT(*)
    into numberOfBicycles
FROM Vehicle INNER JOIN Bicycle
ON Vehicle.id_vehicle = Bicycle.id_bicycle
    WHERE VEHICLE.latitude_vehicle = latitudePar
    AND VEHICLE.longitude_vehicle = longitudePar;

    return numberOfBicycles;

END;
/