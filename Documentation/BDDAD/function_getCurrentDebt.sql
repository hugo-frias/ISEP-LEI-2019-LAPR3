create or replace FUNCTION getCurrentDebt(username_parameter VARCHAR) 
return NUMBER is rentCost NUMBER(10,0);
mail VARCHAR(20);
begin

    SELECT user_email into mail
    FROM App_User
    WHERE user_name = username_parameter;

    select sum(rent_cost) into rentCost
    from rent WHERE user_email = mail;
return (rentCost);
end;
/
