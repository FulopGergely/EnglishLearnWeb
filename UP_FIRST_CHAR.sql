create or replace TRIGGER UP_FIRST_CHAR
BEFORE INSERT ON english
FOR EACH ROW
BEGIN
   UPDATE english SET question = INITCAP(question);
END;