create or replace FUNCTION getRentByUsername(username_parameter VARCHAR) 
return varchar is rentId VARCHAR(10);
mail VARCHAR(20);
begin

    SELECT user_email into mail
    FROM App_User
    WHERE user_name = username_parameter;

    select id_rent into rentId
    from rent WHERE rent.user_email = mail AND rent.id_park_end is null;
return (rentId);
end;
/

