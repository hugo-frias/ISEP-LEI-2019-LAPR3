create or replace PROCEDURE setMaxNumberOfBicycles(latitudePar in NUMBER, longitudePar in NUMBER, newMaxNumberOfBicycles in NUMBER) 
AS
    retorno_funcao VARCHAR(10);

BEGIN
    retorno_funcao := getPlace(latitudePar, longitudePar);

    UPDATE PARK
    SET MAX_NUMBICYCLES = newMaxNumberOfBicycles
    WHERE PARK.ID_PARK = retorno_funcao;

COMMIT;

END;
/
