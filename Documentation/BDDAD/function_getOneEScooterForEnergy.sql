create or replace FUNCTION getOneEScooterForEnergy(energy in NUMBER) RETURN
SYS_REFCURSOR is resultado sys_refcursor;

BEGIN
    OPEN resultado FOR

    SELECT * FROM ( SELECT Vehicle.*, Electric_Scooter.type_escooter, Electric_Scooter.max_battery, Electric_Scooter.actual_battery, Electric_Scooter.motor FROM Vehicle
            INNER JOIN Electric_Scooter ON 
    		Vehicle.id_vehicle = Electric_Scooter.id_escooter 
    		WHERE Electric_Scooter.actual_battery >= energy
    		ORDER BY id_vehicle DESC );

RETURN (resultado);
END;
/
