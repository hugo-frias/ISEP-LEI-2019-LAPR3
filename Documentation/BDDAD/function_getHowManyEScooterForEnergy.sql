create or replace FUNCTION getHowManyEScooterForEnergy(energy in NUMBER) RETURN
NUMBER is resultado NUMBER(1,0);

BEGIN
    SELECT COUNT (id_vehicle) into resultado FROM Vehicle
    		INNER JOIN Electric_Scooter ON 
    		Vehicle.id_vehicle = Electric_Scooter.id_escooter
    		WHERE Electric_Scooter.actual_battery >= energy;

RETURN (resultado);
END;
/
