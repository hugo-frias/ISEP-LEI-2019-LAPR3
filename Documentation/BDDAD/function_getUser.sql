create or replace FUNCTION getUser(mail VARCHAR) RETURN
SYS_REFCURSOR is resultado sys_refcursor;

BEGIN
    OPEN resultado FOR

    SELECT * FROM App_User 
    WHERE user_email = mail;

RETURN (resultado);
END;
/
