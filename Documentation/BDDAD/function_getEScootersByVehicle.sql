create or replace FUNCTION getEScooterByVehicle(id_parameter in VARCHAR) RETURN
SYS_REFCURSOR AS
resultado sys_refcursor;

BEGIN
OPEN resultado FOR
	
    SELECT Vehicle.*, Electric_Scooter.type_escooter, Electric_Scooter.max_battery, Electric_Scooter.actual_battery, Electric_Scooter.motor
    FROM Vehicle, Electric_Scooter
    WHERE Vehicle.id_vehicle = id_parameter AND Electric_Scooter.id_escooter = id_parameter;

RETURN (resultado);
END;
/
