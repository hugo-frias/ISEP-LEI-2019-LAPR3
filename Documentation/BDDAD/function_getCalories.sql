create or replace FUNCTION getCalories(email in VARCHAR, rent in VARCHAR)
RETURN NUMBER as
valor NUMBER(9,0);
height NUMBER(3,0);
weight NUMBER(3,0);
sex VARCHAR(1);
rent_duration NUMBER(6,0);
inicio TIMESTAMP;
fim TIMESTAMP;
-- age = 35   (valor standard devido à omissão nos dados)
--averageSpeed NUMBER;   (to be used if distance is given)

begin

SELECT height into height FROM App_User WHERE App_User.user_email = email;
SELECT weight into weight FROM App_User WHERE App_User.user_email = email;
SELECT gender into sex FROM App_User WHERE App_User.user_email = email;
SELECT date_hour_start into inicio FROM Rent WHERE Rent.id_rent = rent;
SELECT date_hour_finish into fim FROM Rent WHERE Rent.id_rent = rent;
SELECT getDifferenceTimestamps(inicio, fim) / 1000 / 60 into rent_duration FROM dual;

-- (NOT_USED) Calorias = (9,8 * peso_total * vel_pessoa * (coef_atrito_mecanico + inclinação)) + (coef_atrito_aero * vel.vento^2 * vel_pessoa)

--BMR (individual's basal metabolic rate) in cal/day
--The estimated BMR value may be multiplied by a number that corresponds to the individual's activity level; 
--the resulting number is the approximate daily kilocalorie intake to maintain current body weight.
-- Male: 66.4730 + 5.0033 (Height cm) + 13.7516 (Weight kg) – 6.7550 (Age yr)
-- Female: 655.0955 + 1.8496 (Height cm) + 9.5634 (Weight kg) – 4.6756 (Age yr)

--To convert kilocalories per day obtained from the Harris Benedict equation to ml.kg-1.min-1, the following formula is used.
-- kcal.day-1/1440 = kcal.min-1;	 kcal.min-1/5 = L.min-1; 	L.min-1/(weight kg)x1000 = ml.kg-1.min-1
-- (BMR/1440) * (1/5) * (1000/Weight kg)
--MET (metabolic equivalent of task) is the objective measure of the ratio of the rate at which a person expends energy
-- 1 MET = 1 kcal/(kg*h) = 4186.8 J/(kg*h) = 1.163 W/kg
--To obtain the Corrected MET
-- 3.5/BMR (converted) * 7.5 (it is the Bicycling-standard)
--Check Table from https://sites.google.com/site/compendiumofphysicalactivities/corrected-mets
--To obtain the kcal.min
-- Corrected * 3.5 * Weight / 200

IF sex = 'M' THEN 
	SELECT ( ( 3.5 / (  (66.4730 + 5.0033*height + 13.7516*weight - 6.7550*35) / 
    1440 * (1/5) * (1000/weight) ) *7.5 ) * 3.5 * weight / 200 ) * rent_duration INTO valor FROM App_User
    WHERE App_User.user_email IN (SELECT Rent.user_email
                                	FROM Rent
                                	WHERE Rent.id_rent = rent);
ELSE IF sex = 'F' THEN
	SELECT ( ( 3.5 / (  (655.0955 + 1.8496*height + 9.5634*weight - 4.6756*35) / 
    1440 * (1/5) * (1000/weight) ) *7.5 ) * 3.5 * weight / 200 ) * rent_duration INTO valor FROM App_User
    WHERE App_User.user_email IN (SELECT Rent.user_email
                                	FROM Rent
                                	WHERE Rent.id_rent = rent);
end if;
end if;

return (valor);

end;
/
