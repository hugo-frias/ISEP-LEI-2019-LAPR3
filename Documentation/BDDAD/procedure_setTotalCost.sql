
create or replace PROCEDURE setTotalCost(mail VARCHAR)
AS
    retorno_funcao NUMBER;

BEGIN
    retorno_funcao := getCurrentDebt(mail);

     UPDATE Invoice
    SET total_cost = retorno_funcao
    WHERE Invoice.user_email = mail;

COMMIT;

END;
/
