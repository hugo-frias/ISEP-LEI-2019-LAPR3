create or replace FUNCTION getTimestampInMiliseconds(datahora in TIMESTAMP) 
return NUMBER as resultado NUMBER(10,0);
begin
select sum( extract( day from moment )*24*60*60*1000 +
       extract( hour from moment )*60*60*1000 +
       extract( minute from moment )*60*1000 +
       round(extract( second from moment )*1000)) total_miliseconds into resultado
    from (select datahora moment from dual);
        
return (resultado);

end;
/

--teste:   select getTimestampInMiliseconds(TO_TIMESTAMP('2019-12-20 09:00:00', 'yyyy-mm-dd HH24:MI:SS')) from dual;
