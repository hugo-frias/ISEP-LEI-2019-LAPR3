create or replace function hasFreeSlotsBicyclesByParkID(id_parameter in VARCHAR) 
return NUMBER is 
valor NUMBER(2,0);
retorno_funcaoA VARCHAR(10);
retorno_funcaoB VARCHAR(10);

BEGIN
    retorno_funcaoA := getNumberOfBicyclesByParkID(id_parameter);
    retorno_funcaoB := getMaxNumberOfBicyclesByParkID(id_parameter);

  return retorno_funcaoB - retorno_funcaoA;
END;
/
