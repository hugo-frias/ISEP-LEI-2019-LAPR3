create or replace FUNCTION getAllRentsByUsername(username_parameter VARCHAR) 
RETURN SYS_REFCURSOR is resultado sys_refcursor;
mail VARCHAR(20);

begin

    SELECT user_email into mail
    FROM App_User
    WHERE user_name = username_parameter;
    
OPEN resultado FOR

    SELECT *
    FROM rent WHERE rent.user_email = mail;

return (resultado);
end;
/
