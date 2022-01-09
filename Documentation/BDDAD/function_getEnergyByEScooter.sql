
create or replace FUNCTION getEnergyByEScooter(motor NUMBER, distancia NUMBER) 
return NUMBER is energy NUMBER(10,0);

begin
    energy := motor * distancia / 15;
return (energy);
end;
/
