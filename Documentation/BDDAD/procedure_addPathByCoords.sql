create or replace procedure addPathByCoords(start_lati in NUMBER, start_longi in NUMBER, end_lati in NUMBER, end_longi in NUMBER, tp_kinetic in NUMBER, tp_wind_direc in NUMBER, tp_wind_speed in NUMBER) is
tp_start VARCHAR(30);
tp_end VARCHAR(30);

begin
    SELECT id_place INTO tp_start FROM Place WHERE latitude_place = start_lati AND longitude_place = start_longi;

    SELECT id_place INTO tp_end FROM Place WHERE latitude_place = end_lati AND longitude_place = end_longi;

    INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
    VALUES(tp_start, tp_end, tp_kinetic, tp_wind_direc, tp_wind_speed);

--COMMIT;

end;
/

