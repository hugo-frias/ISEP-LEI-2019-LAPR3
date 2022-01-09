create or replace FUNCTION getDifferenceTimestamps(datahoraInicio in TIMESTAMP, datahoraFim in TIMESTAMP) 
return NUMBER as resultado NUMBER(10,0);
begin
    select extract( day from diff )*24*60*60*1000 +
       extract( hour from diff )*60*60*1000 +
       extract( minute from diff )*60*1000 +
       round(extract( second from diff )*1000) total_milliseconds into resultado
    from (select datahoraFim - datahoraInicio diff from dual);
        
return (resultado);

end;
/

--teste:   select getDifferenceTimestamps(TO_TIMESTAMP('2019-12-20 09:00:00', 'yyyy-mm-dd HH24:MI:SS'), 
--TO_TIMESTAMP('2019-12-22 09:00:00', 'yyyy-mm-dd HH24:MI:SS')) from dual;
