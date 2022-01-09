create or replace procedure addEScooter(v_id in VARCHAR, v_weight in NUMBER, v_lat in NUMBER, 
v_long in NUMBER, v_aero in NUMBER, v_frontal in NUMBER, s_type in CHAR, s_max in NUMBER, s_actual in NUMBER, s_motor in NUMBER) is
aux VARCHAR(10);

begin
    INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
    VALUES(v_id, v_weight, v_lat, v_long, v_aero, v_frontal);
    
    INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
    VALUES(v_id, s_type, s_max, s_actual, s_motor);


    SELECT id_Place into aux
    FROM Place
    WHERE latitude_place = v_lat AND longitude_place = v_long;

    UPDATE Park SET available_escooters = available_escooters + 1 WHERE id_park = aux;

--COMMIT;

end;
/
