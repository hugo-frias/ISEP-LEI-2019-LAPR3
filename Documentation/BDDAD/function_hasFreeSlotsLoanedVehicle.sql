create or replace function hasFreeSlotsLoanedVehicle(usernamePar in VARCHAR2, id_parameter in VARCHAR) 
return NUMBER is 
retorno_aux VARCHAR2(10);
user_email_parameter VARCHAR2(20);
is_bicycle NUMBER(2,0);
retorno_valor NUMBER(3,0);

BEGIN

    SELECT user_email INTO user_email_parameter
    FROM APP_USER
    WHERE UPPER(user_name) LIKE UPPER(usernamePar);

    SELECT id_vehicle into retorno_aux
    FROM RENT
    WHERE UPPER(user_email) LIKE UPPER(user_email_parameter) AND (id_park_end IS NULL OR date_hour_finish IS NULL);
    
    SELECT COUNT(*) INTO is_bicycle
    FROM Bicycle
    WHERE UPPER(id_bicycle) LIKE retorno_aux;

  IF is_bicycle = 0 then
    return hasfreeslotsescootersbyparkid(id_parameter);
  ELSE
    return hasfreeslotsbicyclesbyparkid(id_parameter);
  END IF;
END;
/
