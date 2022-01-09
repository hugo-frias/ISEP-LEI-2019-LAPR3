create or replace FUNCTION getBicycle(bikeId in VARCHAR) RETURN
SYS_REFCURSOR is resultado sys_refcursor;

BEGIN
	OPEN resultado FOR

	SELECT Bicycle.*
        FROM Bicycle
    	WHERE Bicycle.id_bicycle= bikeId;

	RETURN (resultado);
END;
/
