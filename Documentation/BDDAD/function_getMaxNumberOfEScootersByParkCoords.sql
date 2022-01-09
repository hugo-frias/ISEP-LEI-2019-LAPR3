create or replace function getMaxNumberOfEScootersByParkCoords(latitudePar in NUMBER, longitudePar in NUMBER) return NUMBER is
    maxNumberOfEScooters NUMBER(2,0);
BEGIN
    SELECT MAX_NUMESCOOTERS
    into maxNumberOfEScooters
    FROM Park INNER JOIN Place
    ON Park.id_park = Place.id_place
    WHERE Place.LATITUDE_Place = latitudePar
      AND Place.LONGITUDE_Place = longitudePar;

    return maxNumberOfEScooters;

END;
/
