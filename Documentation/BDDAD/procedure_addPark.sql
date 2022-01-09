create or replace procedure addPark(p_id in VARCHAR, p_lat in NUMBER, p_long in NUMBER, p_elev in NUMBER, 
p_desc in CHAR, numBic in NUMBER, numSco in NUMBER, avaiBic in NUMBER, avaiSco in NUMBER, 
volt in NUMBER, curr in NUMBER) is
begin
    INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
    VALUES(p_id, p_lat, p_long, p_elev, p_desc);
    
    INSERT INTO park(id_park, max_numbicycles, max_numescooters, available_bicycles, 
    available_escooters, input_voltage_park, input_current_park)
    VALUES(p_id, numBic, numSco, avaiBic, avaiSco, volt, curr);

--COMMIT;

end;
/
