create or replace FUNCTION getDateByRentId(RentID_parameter in VARCHAR) 
return SYS_REFCURSOR is resultado sys_refcursor;
BEGIN

OPEN resultado FOR

    SELECT Date_hour_finish FROM Rent
    WHERE RentID_parameter = rent.id_rent;

RETURN (resultado);
END;
/
