create or replace function hasFreeSlotsEScootersByParkID(id_parameter in VARCHAR) 
return NUMBER is 
valor NUMBER(2,0);
retorno_funcaoA VARCHAR(10);
retorno_funcaoB VARCHAR(10);

BEGIN
    retorno_funcaoA := getNumberOfEScootersByParkID(id_parameter);
    retorno_funcaoB := getMaxNumberOfEScootersByParkID(id_parameter);

  return retorno_funcaoB - retorno_funcaoA;
END;
/
