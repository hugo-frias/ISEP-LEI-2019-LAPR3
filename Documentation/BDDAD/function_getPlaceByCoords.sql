create or replace FUNCTION getPlaceByCoords(latitude in NUMBER, longitude in NUMBER) 
return VARCHAR as place VARCHAR(10);
begin

    select id_place into place
    from Place WHERE LATITUDE_Place = latitude
    		AND LONGITUDE_Place = longitude;
return (place);

end;
/