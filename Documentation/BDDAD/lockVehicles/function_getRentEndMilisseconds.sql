
create or replace FUNCTION getRentUpdateMilisseconds(id_rent_parameter VARCHAR) 

return NUMBER is milisseconds NUMBER(10,0);
date_variable timestamp;
begin

select date_hour_finish into date_variable
from rent
where rent.id_rent = id_rent_parameter;

milisseconds := gettimestampinmiliseconds(date_variable);

return (milisseconds);
end;
/

