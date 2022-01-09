create or replace procedure clearDatabase is
begin
DELETE FROM Invoice;
DELETE FROM Travel_Path;
DELETE FROM Rent;
DELETE FROM App_User;
DELETE FROM Park;
DELETE FROM Point_Of_Interest;
DELETE FROM Bicycle;
DELETE FROM Electric_Scooter;
DELETE FROM Place;
DELETE FROM Vehicle;
COMMIT;
end;
/
