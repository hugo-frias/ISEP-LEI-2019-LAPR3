create or replace PROCEDURE setMaxNumberOfEScooters(latitudePar in NUMBER, longitudePar in NUMBER, newMaxNumberOfEScooters in NUMBER)
AS
    retorno_funcao VARCHAR(10);

BEGIN
    retorno_funcao := getPlace(latitudePar, longitudePar);

    UPDATE PARK
    SET MAX_NUMESCOOTERS = newMaxNumberOfEScooters
    WHERE PARK.ID_PARK = retorno_funcao;

COMMIT;

END;
/
