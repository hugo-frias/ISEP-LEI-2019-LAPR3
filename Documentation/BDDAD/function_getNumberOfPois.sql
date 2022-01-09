create or replace function getNumberOfPois return NUMBER is
    numberOfPois NUMBER(2,0);
BEGIN
    SELECT COUNT(*) into numberOfPois FROM Point_Of_Interest;

    return numberOfPois;

END;
/
