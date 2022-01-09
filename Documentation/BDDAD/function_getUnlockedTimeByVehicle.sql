create or replace FUNCTION getUnlockedTimeByVehicle(vehicle_parameter in VARCHAR) RETURN
NUMBER is
resultado NUMBER(30,0);
comeco TIMESTAMP;
fim TIMESTAMP;

BEGIN
    SELECT date_hour_start into comeco
    FROM Rent
    WHERE id_vehicle = vehicle_parameter;

    SELECT date_hour_finish into fim
    FROM Rent
    WHERE id_vehicle = vehicle_parameter;

    resultado := (getDifferenceTimestamps(comeco, fim)) / 1000;

RETURN (resultado);
END;
/
