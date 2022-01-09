create or replace FUNCTION getAllRentsByEmail(email in VARCHAR) RETURN
SYS_REFCURSOR is resultado sys_refcursor;

BEGIN
	OPEN resultado FOR
	
	SELECT * FROM Rent
	WHERE user_email = email;
	
	RETURN (resultado);
END;
/