create or replace FUNCTION getParkById(parkId in varchar) 
return SYS_REFCURSOR is resultado sys_refcursor;
BEGIN
OPEN resultado FOR

    SELECT Place.*, Park.max_numbicycles, Park.max_numescooters, Park.available_bicycles, Park.available_escooters, Park.input_voltage_park, Park.input_current_park FROM Park
    INNER JOIN Place ON Park.id_park = Place.id_place
    WHERE  Place.id_place = parkId;

RETURN (resultado);
END;
/
