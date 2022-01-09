create or replace function totalCost(name in CHAR) 
return NUMBER is 
valor NUMBER(4,0);
mail VARCHAR(20);

BEGIN
    SELECT user_email into mail
    FROM App_User
    WHERE user_name = name;

    SELECT SUM(total_cost) into valor FROM Invoice
    WHERE user_email = mail;

return valor;

END;
/
