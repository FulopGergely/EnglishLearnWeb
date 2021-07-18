
create or replace TRIGGER TRIGGER2
BEFORE INSERT ON Test
BEGIN
   UPDATE rank SET summ = summ + 1;
END;