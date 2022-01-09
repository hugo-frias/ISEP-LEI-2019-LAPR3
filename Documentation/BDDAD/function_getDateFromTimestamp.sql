create or replace FUNCTION getDate(datahora in TIMESTAMP) 
return DATE as resultado DATE;
begin
    SELECT CAST(TO_TIMESTAMP(datahora) AS DATE) into resultado FROM dual;
return (resultado);

end;
/

--teste:   select getDate(TO_TIMESTAMP('2020-12-05 12:00:00', 'yyyy-mm-dd HH24:MI:SS')) from dual;