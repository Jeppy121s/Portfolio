BEGIN 
dbms_output.put_line('Hello World');

END;    

DECLARE v_timestamp DATE;
BEGIN
SELECT ADD_MONTHS(SYSDATE,6) INTO v_timestamp FROM DUAL;
DBMS_OUTPUT.PUT_LINE('In six months, the date will be:'||v_timestamp);
END;