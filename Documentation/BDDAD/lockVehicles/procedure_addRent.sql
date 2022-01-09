create or replace procedure addRent(id_rent_parameter in VARCHAR, id_vehicle_parameter in VARCHAR, user_name_parameter in VARCHAR) is

bicla VARCHAR(10);
scooter VARCHAR(10);
mail VARCHAR(20);
lati number(8,6);
longi number(8,6);
ex_null_coordinates exception;
id_park_variable VARCHAR(10);

begin
	--latitude e longitude do veiculo atual
    select latitude_vehicle into lati
    from vehicle
    where vehicle.id_vehicle = id_vehicle_parameter;
    
    select longitude_vehicle into longi
    from vehicle
    where vehicle.id_vehicle = id_vehicle_parameter;
    
    IF (longi is null and lati is null) then raise ex_null_coordinates;
    end if;
    -- id do parque inicial
    id_park_variable := getParkIdByVehicle(id_vehicle_parameter);
    -- email do user
    select user_email into mail
    from app_user 
    where user_name_parameter = app_user.user_name;

    INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance)
    values (id_rent_parameter, mail ,id_vehicle_parameter, id_park_variable, null, systimestamp, null, 0, 0);

    
    UPDATE VEHICLE
    SET latitude_vehicle = 0, longitude_vehicle = 0
    WHERE Vehicle.id_vehicle = id_vehicle_parameter;


EXCEPTION
    WHEN ex_null_coordinates THEN
        RAISE_APPLICATION_ERROR(-20021, 'The vehicle is not at a park (its currently rented!)');
--COMMIT;

end;
/