create or replace FUNCTION forHowLongAVehicleIsUnlocked(id_parameter in VARCHAR) 
return NUMBER AS 
resultado NUMBER(10,0);
data_unlocked TIMESTAMP;

begin
    SELECT date_hour_start into data_unlocked
    FROM RENT
    WHERE RENT.id_vehicle = id_parameter AND (RENT.ID_PARK_END IS NULL OR RENT.DATE_HOUR_FINISH IS NULL); 
    
    resultado := getDifferenceTimestamps(data_unlocked, systimestamp) / 1000;
    
    return (resultado);
end;
/