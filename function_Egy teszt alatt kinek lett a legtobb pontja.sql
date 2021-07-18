create or replace FUNCTION func RETURN NUMBER AS 
    darab NUMBER;
    a test%ROWTYPE;
    CURSOR kurzor IS SELECT * INTO a FROM test;
    num integer;
    nam varchar2(20); 
BEGIN
    OPEN kurzor;
    num := 0;
    LOOP
        FETCH kurzor INTO a;
        EXIT WHEN kurzor%NOTFOUND;

         IF num < a.score then
            num := a.score;
            nam := a.NAME;
        end if;

    END LOOP;
    DBMS_OUTPUT.PUT_LINE(nam ||' '||  num); 
    RETURN num;
END;