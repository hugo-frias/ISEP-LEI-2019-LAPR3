CREATE OR REPLACE TRIGGER trgRent
BEFORE INSERT ON rent
FOR EACH ROW 

DECLARE
    Pragma Autonomous_Transaction;
    ex_foundUser EXCEPTION;
    ex_foundVehicle EXCEPTION;
--    ex_endParkFull exception;
    ex_vehicleNotInPark exception;
--    available_bicycles_variable NUMBER;
--    max_bicycles_variable NUMBER;
    latitude_vehicle_variable NUMBER;
    longitude_vehicle_variable NUMBER;
    latitude_park_variable NUMBER;
    longitude_park_variable NUMBER;

BEGIN

  
  FOR rentToBeAnalyzed IN (SELECT * FROM Rent)
    LOOP
    BEGIN
        select latitude_vehicle into latitude_vehicle_variable from vehicle where :new.id_vehicle = id_vehicle;
        select longitude_vehicle into longitude_vehicle_variable from vehicle where :new.id_vehicle = id_vehicle;        
        select latitude_place into latitude_park_variable from place where :new.id_park_start = id_place;
        select longitude_place into longitude_park_variable from place where :new.id_park_start = id_place;
        
--        select available_bicycles into available_bicycles_variable from park where id_park = rentToBeAnalyzed.id_park_end;
--       select max_numbicycles into max_bicycles_variable from park where id_park = rentToBeAnalyzed.id_park_end;
       IF (rentToBeAnalyzed.id_park_end IS null) AND rentToBeAnalyzed.user_email = :NEW.user_email THEN
       RAISE ex_foundUser;
       end if;
       
       IF (rentToBeAnalyzed.id_park_end is null)  AND rentToBeAnalyzed.id_vehicle = :NEW.id_vehicle THEN
       RAISE ex_foundVehicle;
       end if;
       
--        IF(:NEW.id_park_end = rentToBeAnalyzed.id_park_end)then
--            IF( available_bicycles_variable = max_bicycles_variable) THEN
--                RAISE ex_endParkFull;
--            end if;
            
--       end if;
       
       IF(:new.id_park_end = rentToBeAnalyzed.id_park_end) then
            IF(latitude_vehicle_variable != latitude_park_variable OR longitude_vehicle_variable != longitude_park_variable) then
                    RAISE ex_vehicleNotInPark;
            end if;
        end if;
       
       
       
    end;
    end loop;
EXCEPTION
    WHEN ex_foundUser THEN
        RAISE_APPLICATION_ERROR(-20008, 'The user already has a rent associated to him in execution');
    WHEN ex_foundVehicle THEN
        RAISE_APPLICATION_ERROR(-20010, 'The vehicle already has a rent associated to him in execution');
 --   WHEN ex_endParkFull THEN
 --       RAISE_APPLICATION_ERROR(-20011, 'The end park is full! Choose another park!');
    WHEN ex_vehicleNotInPark then
        RAISE_APPLICATION_ERROR(-20011, 'The vehicle is not currently in this park');
END;
/
