create or replace function getMaxNumberOfEScootersByParkID(id_parameter in VARCHAR) return NUMBER is
    maxNumberOfEScooters NUMBER(2,0);
BEGIN
    SELECT MAX_NUMESCOOTERS
    into maxNumberOfEScooters
    FROM Park
    WHERE UPPER(Park.id_park) LIKE UPPER(id_parameter);

    return maxNumberOfEScooters;

END;
/
