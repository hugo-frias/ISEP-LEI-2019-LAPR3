create or replace function hasFreeSlotsEScootersByParkCoords(infoLatitude in NUMBER, infoLongitude in NUMBER) 
return NUMBER is 
valor NUMBER(2,0);
retorno_funcaoA VARCHAR(10);
retorno_funcaoB VARCHAR(10);

BEGIN
    retorno_funcaoA := getNumberOfEScootersByParkCoords(infoLatitude, infoLongitude);
    retorno_funcaoB := getMaxNumberOfEScootersByParkCoords(infoLatitude, infoLongitude);

   return retorno_funcaoB - retorno_funcaoA;
END;
/
