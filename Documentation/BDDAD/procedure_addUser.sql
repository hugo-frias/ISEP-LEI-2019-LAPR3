create or replace procedure addUser(user_name_parameter in VARCHAR, email_parameter in VARCHAR, pass_parameter in CHAR,
                                    height_parameter in NUMBER, weight_parameter in NUMBER, gender_parameter in CHAR,
                                    cyclingAvgSpeed_parameter in NUMBER, visaCardNumber_parameter in NUMBER, points_parameter in NUMBER) is
begin
    INSERT INTO App_User(user_name, user_email, user_pass, height, weight, gender, cyclingAvgSpeed, visaCardNumber, points)
    values (user_name_parameter, email_parameter, pass_parameter, height_parameter, weight_parameter, gender_parameter,
            cyclingAvgSpeed_parameter, visaCardNumber_parameter, points_parameter);

--COMMIT;

end;
/
