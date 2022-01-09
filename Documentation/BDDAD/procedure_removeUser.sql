create or replace procedure removeUser(user_email_parameter in VARCHAR) is
begin
     DELETE FROM App_User
     WHERE user_email_parameter = App_User.user_email;

COMMIT;

end;
/
