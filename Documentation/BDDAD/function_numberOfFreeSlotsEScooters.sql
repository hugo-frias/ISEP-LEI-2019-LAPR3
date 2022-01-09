create or replace function numberOfFreeSlotsEScooters(id_parameter in VARCHAR) 
return NUMBER is 
valor NUMBER(2,0);
lati NUMBER(8,6);
longi NUMBER(8,6);
retorno_funcaoA VARCHAR(10);
retorno_funcaoB VARCHAR(10);

BEGIN
    SELECT latitude_place into lati
    FROM Place
    WHERE id_place = id_parameter;

    SELECT longitude_place into longi
    FROM Place
    WHERE id_place = id_parameter;


    retorno_funcaoA := getNumberOfEScootersByCoords(lati, longi);
    retorno_funcaoB := getMaxNumberOfEScootersByParkCoords(lati, longi);

    valor := retorno_funcaoB - retorno_funcaoA;
return valor;

END;
/
