create or replace function totalPoints(name_parameter in CHAR) 
return NUMBER is 
valor NUMBER(4,0);
mail VARCHAR(20);

BEGIN
    SELECT user_email into mail
    FROM App_User
    WHERE user_name = name_parameter;

    SELECT SUM(points_rent) into valor FROM Rent
    WHERE user_email = mail;

return valor;

END;
/
