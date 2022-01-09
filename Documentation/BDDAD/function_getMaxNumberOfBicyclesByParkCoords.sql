create or replace function getMaxNumberOfBicyclesByParkCoords(latitudePar in NUMBER, longitudePar in NUMBER) return NUMBER is
    maxNumberOfBicycles NUMBER(2,0);
BEGIN
    SELECT MAX_NUMBICYCLES
    into maxNumberOfBicycles
    FROM Park INNER JOIN Place
    ON Park.id_park = Place.id_place
    WHERE Place.LATITUDE_Place = latitudePar
      AND Place.LONGITUDE_Place = longitudePar;

    return maxNumberOfBicycles;

END;
/