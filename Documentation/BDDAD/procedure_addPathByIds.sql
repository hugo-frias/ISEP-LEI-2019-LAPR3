create or replace procedure addPath(tp_start in VARCHAR, tp_end in VARCHAR, tp_kinetic in NUMBER, tp_wind_direc in NUMBER, 
tp_wind_speed in NUMBER) is
begin
    INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
    VALUES(tp_start, tp_end, tp_kinetic, tp_wind_direc, tp_wind_speed);

--COMMIT;

end;
/
