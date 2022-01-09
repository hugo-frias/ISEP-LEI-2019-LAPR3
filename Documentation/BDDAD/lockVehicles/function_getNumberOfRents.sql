create or replace function getNumberOfRents return number is
    rents number;
BEGIN
    SELECT COUNT(id_rent) into rents
    FROM rent;
    return rents;
END;
/
