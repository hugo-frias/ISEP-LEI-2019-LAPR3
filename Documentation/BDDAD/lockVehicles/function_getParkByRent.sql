create or replace FUNCTION getParkByRent(user_name_parameter in VARCHAR) RETURN
SYS_REFCURSOR is resultado sys_refcursor;

id_park_variable varchar(20);
mail varchar(20);

BEGIN


    select user_email into mail
    from app_user 
    where user_name_parameter = app_user.user_name;
    
    select id_park_start into id_park_variable
    from rent
    where mail = rent.user_email and id_park_end is null;
    

OPEN resultado FOR

    SELECT Place.*, Park.max_numbicycles, Park.max_numescooters, Park.available_bicycles, Park.available_escooters, Park.input_voltage_park, Park.input_current_park FROM Park
    INNER JOIN Place ON Park.id_park = Place.id_place
    WHERE id_place = id_park_variable;

RETURN (resultado);
END;
/
