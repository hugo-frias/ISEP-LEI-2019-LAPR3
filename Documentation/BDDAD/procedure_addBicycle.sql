create or replace procedure addBicycle(v_id in VARCHAR, v_weight in NUMBER, v_lat in NUMBER, 
v_long in NUMBER, v_aero in NUMBER, v_frontal in NUMBER, b_size in NUMBER) is
aux VARCHAR(10);

BEGIN
    INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
    VALUES(v_id, v_weight, v_lat, v_long, v_aero, v_frontal);
    
    INSERT INTO bicycle(id_bicycle, wheel_size)
    VALUES(v_id, b_size);


    SELECT id_Place into aux
    FROM Place
    WHERE latitude_place = v_lat AND longitude_place = v_long;

    UPDATE Park SET available_bicycles = available_bicycles + 1 WHERE id_park = aux;

--COMMIT;

end;
/
