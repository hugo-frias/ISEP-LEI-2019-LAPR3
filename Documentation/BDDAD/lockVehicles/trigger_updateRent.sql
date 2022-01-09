create or replace TRIGGER trgRentUpdate
BEFORE UPDATE ON rent
FOR EACH ROW 

DECLARE
    Pragma Autonomous_Transaction;
    ex_wrongUser EXCEPTION;
    ex_wrongVehicle EXCEPTION;
    ex_wrongRent EXCEPTION;
--    ex_endParkFull exception;

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

     IF(:new.user_email != :old.user_email) then
      raise ex_wrongUser;
      end if;

       IF(:new.id_vehicle != :old.id_vehicle) then
  raise ex_wrongVehicle;
       end if;

        IF(latitude_vehicle_variable != null) then
        raise ex_wrongRent;
        end if;

--        IF(:NEW.id_park_end = rentToBeAnalyzed.id_park_end)then
--            IF( available_bicycles_variable = max_bicycles_variable) THEN
--                RAISE ex_endParkFull;
--            end if;

--       end if;





    end;
    end loop;
EXCEPTION
    WHEN ex_wrongUser THEN
        RAISE_APPLICATION_ERROR(-20024, 'The user is not associated with this vehicle!');
    WHEN ex_wrongVehicle THEN
        RAISE_APPLICATION_ERROR(-20032, 'The vehicle is not associated with this user!');
    when ex_wrongRent then
        RAISE_APPLICATION_ERROR(-20035, 'This rent is unavailable!');
END;
