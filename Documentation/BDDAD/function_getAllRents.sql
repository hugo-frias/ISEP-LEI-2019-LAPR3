create or replace FUNCTION getAllRents RETURN
SYS_REFCURSOR is resultado sys_refcursor;

BEGIN
	OPEN resultado FOR
	
	SELECT * FROM Rent;
	
	RETURN (resultado);
END;
/
