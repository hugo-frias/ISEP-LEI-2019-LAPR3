create or replace procedure removeBicycle(id_parameter in VARCHAR) is
aux VARCHAR(10);
lati NUMBER(8,6);
longi NUMBER(8,6);

BEGIN
    SELECT latitude_vehicle into lati
    FROM Vehicle
    WHERE id_vehicle = id_parameter;

    SELECT longitude_vehicle into longi
    FROM Vehicle
    WHERE id_vehicle = id_parameter;


    DELETE FROM Bicycle
    WHERE Bicycle.id_bicycle = id_parameter;

    DELETE FROM Vehicle
    WHERE Vehicle.id_vehicle = id_parameter;


    SELECT id_Place into aux
    FROM Place
    WHERE latitude_place = lati AND longitude_place = longi;

    UPDATE Park SET available_bicycles = available_bicycles - 1 WHERE id_park = aux;

COMMIT;

end;
/
