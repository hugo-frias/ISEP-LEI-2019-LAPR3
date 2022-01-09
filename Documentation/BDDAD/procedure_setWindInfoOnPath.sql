create or replace PROCEDURE setWindInfoOnPath(infoStartLatitude in NUMBER, infoStartLongitude in NUMBER, new_wind_direction NUMBER, new_wind_speed NUMBER)
AS
    retorno_funcao VARCHAR(10);

BEGIN
    retorno_funcao := getPlace(infoStartLatitude, infoStartLongitude);

     UPDATE Travel_Path
    SET wind_direction = new_wind_direction, wind_speed = new_wind_speed
    WHERE Travel_Path.id_place_start = retorno_funcao;

COMMIT;

END;
/
