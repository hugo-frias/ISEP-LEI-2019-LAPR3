create or replace FUNCTION addRentToMSeconds(id_rent_parameter in VARCHAR, id_vehicle_parameter in VARCHAR, user_email_parameter in VARCHAR,
                                    id_park_start_parameter in VARCHAR) 
return NUMBER as resultado NUMBER(10,0);
bicla VARCHAR(10);
scooter VARCHAR(10);
comeco TIMESTAMP;

begin

SELECT CURRENT_TIMESTAMP into comeco FROM DUAL;

    INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance)
    values (id_rent_parameter, user_email_parameter, id_vehicle_parameter, id_park_start_parameter, null, comeco, null, 0, 0);


    UPDATE VEHICLE
    SET latitude_vehicle = null, longitude_vehicle = null
    WHERE Vehicle.id_vehicle = id_vehicle_parameter;


    SELECT id_bicycle into bicla
    FROM Bicycle
    WHERE id_bicycle = id_vehicle_parameter;

    SELECT id_escooter into scooter
    FROM Electric_Scooter
    WHERE id_escooter = id_vehicle_parameter;


IF id_vehicle_parameter = bicla THEN
	UPDATE PARK
    	SET available_bicycles = available_bicycles - 1
    	WHERE PARK.ID_PARK = id_park_start_parameter;
ELSE IF id_vehicle_parameter = scooter THEN
	UPDATE PARK
    	SET available_escooters = available_escooters - 1
   	WHERE PARK.ID_PARK = id_park_start_parameter; 
end if;
end if;

    resultado := getTimestampInMiliseconds(comeco);

return (resultado);

end;
/
