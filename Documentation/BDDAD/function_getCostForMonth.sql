create or replace FUNCTION getCostForMonth(mes NUMBER, id_parameter VARCHAR) 
return NUMBER as custo NUMBER(5,0);
momento TIMESTAMP;
mesTemp NUMBER(1,0);
mail VARCHAR(20);

begin
select user_email into mail from App_User where user_name = id_parameter;

SELECT SUM(rent_cost) into custo FROM Rent WHERE user_email = mail and EXTRACT(Month from date_hour_start) = mes;


return (custo);
end;
