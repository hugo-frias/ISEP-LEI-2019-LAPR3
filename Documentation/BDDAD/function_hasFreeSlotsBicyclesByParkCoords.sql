create or replace function hasFreeSlotsBicyclesByParkCoords(infoLatitude in NUMBER, infoLongitude in NUMBER) 
return NUMBER is 
valor NUMBER(2,0);
retorno_funcaoA VARCHAR(10);
retorno_funcaoB VARCHAR(10);

BEGIN
    retorno_funcaoA := getNumberOfBicyclesByParkCoords(infoLatitude, infoLongitude);
    retorno_funcaoB := getMaxNumberOfBicyclesByParkCoords(infoLatitude, infoLongitude);

  return retorno_funcaoB - retorno_funcaoA;
END;
/