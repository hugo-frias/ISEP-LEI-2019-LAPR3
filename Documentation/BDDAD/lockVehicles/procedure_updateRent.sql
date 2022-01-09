create or replace procedure updateRent(id_vehicle_parameter in varchar, user_name_parameter in VARCHAR, 
                                        id_park_end_parameter in VARCHAR, distance_parameter in number) is
    
    
    start_timestamp timestamp;
    end_timestamp timestamp;

    rent_cost_variable number(5,0);
    rent_hours_duration number(3,0);

    start_elevation number(3,0);
    end_elevation number(3,0);

    user_email_parameter varchar(20);

    id_park_start_variable varchar(10);

    id_rent_variable varchar(10);

    latitude_end_park number(8,6);
    longitude_end_park number(8,6);

    rent_time number(10,4);

    begin
        select user_email into user_email_parameter
        from app_user
        where app_user.user_name = user_name_parameter;
    -- get latitude and longitude of the end park
        select latitude_place into latitude_end_park
        from place
        where place.id_place = id_park_end_parameter;

        select longitude_place into longitude_end_park
        from place
        where place.id_place = id_park_end_parameter;

    -- get the rent id
        select id_rent into id_rent_variable
        from rent
        where user_email_parameter = rent.user_email and rent.id_park_end  is null;

    -- update the rent 
        update rent set date_hour_finish = systimestamp, id_park_end = id_park_end_parameter, distance = distance_parameter, user_email = user_email_parameter, id_vehicle = id_vehicle_parameter
        where rent.id_rent = id_rent_variable;

    -- get the id of the start park
        select id_park_start into id_park_start_variable
        from rent
        where rent.id_rent = id_rent_variable;



    -- get start and end elevation
        SELECT elevation into start_elevation
        FROM place
        where id_place = id_park_start_variable;

        SELECT elevation into end_elevation
        FROM place
        where id_place = id_park_end_parameter;

    -- update the cost of the rent
    rent_time := (getdifferencetimestamps(start_timestamp, end_timestamp) / (1000 * 3600));

    IF rent_time >= 1.00 then
        update rent set rent_cost = 1.5*rent_time where rent.id_rent = id_rent_variable;
    end if;

    -- update the points given  
    if (end_elevation-start_elevation) >= 50 then
        update rent set points_rent = 15 where rent.id_rent = id_rent_variable;
    else if (end_elevation-start_elevation) >= 25 then 
        update rent set points_rent = 5 where rent.id_rent = id_rent_variable;
    else if (end_elevation-start_elevation) < 25 then
        update rent set points_rent = 0 where rent.id_rent = id_rent_variable;
    end if;
    end if;
    end if;

    end;
/
