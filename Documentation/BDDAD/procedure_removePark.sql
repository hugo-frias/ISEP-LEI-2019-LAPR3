create or replace procedure removePark(id_parameter in VARCHAR) AS
lati NUMBER(8,6);
longi NUMBER(8,6);

begin
    SELECT latitude_place into lati
    FROM Place
    WHERE id_place = id_parameter;

    SELECT longitude_place into longi
    FROM Place
    WHERE id_place = id_parameter;

    DELETE FROM Bicycle
    WHERE Bicycle.id_bicycle IN (SELECT Vehicle.id_vehicle
                                FROM Vehicle
                                WHERE latitude_vehicle = lati
                                AND longitude_vehicle = longi);

    DELETE FROM Electric_Scooter
    WHERE Electric_Scooter.id_escooter IN (SELECT Vehicle.id_vehicle
                                	FROM Vehicle
                                	WHERE latitude_vehicle = lati
                                	AND longitude_vehicle = longi);

    DELETE FROM Vehicle
    WHERE latitude_vehicle = lati
    AND longitude_vehicle = longi;

    DELETE FROM Park
    WHERE id_parameter = Park.id_park;

    DELETE FROM Place
    WHERE id_parameter = Place.id_place;

COMMIT;

end;
/
