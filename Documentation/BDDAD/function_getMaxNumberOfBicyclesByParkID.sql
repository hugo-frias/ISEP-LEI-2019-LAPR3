create or replace function getMaxNumberOfBicyclesByParkID(id_paramater in VARCHAR) return NUMBER is
    maxNumberOfBicycles NUMBER(2,0);
BEGIN
    SELECT MAX_NUMBICYCLES
    into maxNumberOfBicycles
    FROM Park
    WHERE UPPER(Park.id_park) LIKE UPPER(id_paramater);

    return maxNumberOfBicycles;

END;
/
