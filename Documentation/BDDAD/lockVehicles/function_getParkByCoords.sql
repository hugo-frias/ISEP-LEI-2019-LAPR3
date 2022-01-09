create or replace FUNCTION getParkByCoords(latitude in NUMBER, longitude in NUMBER) 
return SYS_REFCURSOR is resultado sys_refcursor;
begin
OPEN resultado FOR
    select Place.*, Park.max_numbicycles, Park.max_numescooters, Park.available_bicycles, Park.available_escooters, Park.input_voltage_park, Park.input_current_park 
    from Park 
    INNER JOIN Place ON Park.id_park = Place.id_place
    WHERE LATITUDE_Place = latitude
    		AND LONGITUDE_Place = longitude;
return (resultado);

end;
/

