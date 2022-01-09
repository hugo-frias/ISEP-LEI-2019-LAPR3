

create or replace FUNCTION getEnergyByUser(username in VARCHAR, distance in NUMBER)
RETURN NUMBER as
valor NUMBER(9,3);
altura NUMBER(3,0);
peso NUMBER(3,0);
sexo CHAR(1);
average_speed NUMBER(4,2);

begin
SELECT cyclingAvgSpeed into average_speed FROM App_User WHERE App_User.user_name = username;
SELECT height into altura FROM App_User WHERE App_User.user_name = username;
SELECT weight into peso FROM App_User WHERE App_User.user_name = username;
SELECT gender into sexo FROM App_User WHERE App_User.user_name = username;

IF sexo = 'M' THEN 
	SELECT ( ( 3.5 / ( (66.4730 + 5.0033*altura + 13.7516*peso - 6.7550*35) / 
    1440 * (1/5) * (1000/peso) ) *7.5 ) * 3.5 * peso / 200 ) * ((distance*1000) / average_speed) INTO valor FROM App_User
    WHERE App_User.user_name = username;
ELSE IF sexo = 'F' THEN
	SELECT ( ( 3.5 / ( (655.0955 + 1.8496*altura + 9.5634*peso - 4.6756*35) / 
    1440 * (1/5) * (1000/peso) ) *7.5 ) * 3.5 * peso / 200 ) * ((distance*1000) / average_speed) INTO valor FROM App_User
    WHERE App_User.user_name = username;
end if;
end if;

return (valor);
end;
/
