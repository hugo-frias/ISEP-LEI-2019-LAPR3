create or replace procedure addPoi(pi_id in VARCHAR, pi_lat in NUMBER, pi_long in NUMBER, pi_elev in NUMBER, 
pi_desc in CHAR) is
begin
    INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
    VALUES(pi_id, pi_lat, pi_long, pi_elev, pi_desc);
    
    INSERT INTO point_of_interest(id_poi)
    VALUES(pi_id);

--COMMIT;

end;
/
