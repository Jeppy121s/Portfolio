
Error starting at line : 1 in command -
DECLARE  
CURSOR currencies_cur IS 
SELECT  currency_code, currency_name      
FROM  currencies
ORDER BY currency_name;
Error report -
ORA-06550: line 5, column 23:
PLS-00103: Encountered the symbol "end-of-file" when expecting one of the following:

   begin function pragma procedure subtype type <an identifier>
   <a double-quoted delimited-identifier> current cursor delete
   exists prior
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:

Error starting at line : 1 in command -
DECLARE CURSOR currencies_cur IS 
SELECT  currency_code, currency_name      
FROM  currencies
ORDER BY currency_name;
Error report -
ORA-06550: line 4, column 23:
PLS-00103: Encountered the symbol "end-of-file" when expecting one of the following:

   begin function pragma procedure subtype type <an identifier>
   <a double-quoted delimited-identifier> current cursor delete
   exists prior
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:

Error starting at line : 1 in command -
DECLARE  
v_country_name  countries.country_name%TYPE; 
v_national_holiday_name countries.national_holiday_name%TYPE; 
v_national_holiday_date   countries.national_holiday_date%TYPE; 
CURSOR countries_cur IS    
SELECT country_name, national_holiday_name, national_holiday_date
FROM countries      
WHERE region_id = 5 AND national_holiday_date IS NOT NULL;
BEGIN  OPEN countries_cur; 
LOOP   
FETCH countries_cur INTO v_country_name, v_national_holiday_name, v_national_holiday_date;   
EXIT WHEN countries_cur%NOTFOUND;    
DBMS_OUTPUT.PUT_LINE('Country: ' || v_country_name    || ' National holiday: '|| v_national_holiday_name     || ', held on: '|| v_national_holiday_date);  
END LOOP;  
CLOSE countries_cur;END;
Error report -
ORA-06550: line 3, column 35:
PLS-00302: component 'NATIONAL_HOLIDAY_NAME' must be declared
ORA-06550: line 3, column 25:
PL/SQL: Item ignored
ORA-06550: line 4, column 37:
PLS-00302: component 'NATIONAL_HOLIDAY_DATE' must be declared
ORA-06550: line 4, column 27:
PL/SQL: Item ignored
ORA-06550: line 8, column 25:
PL/SQL: ORA-00904: "NATIONAL_HOLIDAY_DATE": invalid identifier
ORA-06550: line 6, column 1:
PL/SQL: SQL Statement ignored
ORA-06550: line 11, column 42:
PLS-00320: the declaration of the type of this expression is incomplete or malformed
ORA-06550: line 11, column 1:
PL/SQL: SQL Statement ignored
ORA-06550: line 13, column 83:
PLS-00320: the declaration of the type of this expression is incomplete or malformed
ORA-06550: line 13, column 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:

Error starting at line : 1 in command -
DECLARE  
v_country_name  countries.country_name%TYPE; 
v_national_holiday_name countries.national_holiday_name%TYPE; 
v_national_holiday_date   countries.national_holiday_date%TYPE; 
CURSOR countries_cur IS    
SELECT country_name, national_holiday_name, national_holiday_date
FROM countries      
WHERE region_id = 5 AND national_holiday_date IS NOT NULL;
BEGIN  OPEN countries_cur; 
LOOP   
FETCH countries_cur INTO v_country_name, v_national_holiday_name, v_national_holiday_date;   
EXIT WHEN countries_cur%NOTFOUND;    
DBMS_OUTPUT.PUT_LINE('Country: ' || v_country_name    || ' National holiday: '|| v_national_holiday_name     || ', held on: '|| v_national_holiday_date);  
END LOOP;  
CLOSE countries_cur;
END;
Error report -
ORA-06550: line 3, column 35:
PLS-00302: component 'NATIONAL_HOLIDAY_NAME' must be declared
ORA-06550: line 3, column 25:
PL/SQL: Item ignored
ORA-06550: line 4, column 37:
PLS-00302: component 'NATIONAL_HOLIDAY_DATE' must be declared
ORA-06550: line 4, column 27:
PL/SQL: Item ignored
ORA-06550: line 8, column 25:
PL/SQL: ORA-00904: "NATIONAL_HOLIDAY_DATE": invalid identifier
ORA-06550: line 6, column 1:
PL/SQL: SQL Statement ignored
ORA-06550: line 11, column 42:
PLS-00320: the declaration of the type of this expression is incomplete or malformed
ORA-06550: line 11, column 1:
PL/SQL: SQL Statement ignored
ORA-06550: line 13, column 83:
PLS-00320: the declaration of the type of this expression is incomplete or malformed
ORA-06550: line 13, column 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:

Error starting at line : 1 in command -
DECLARE  
v_country_name  countries.country_name%TYPE; 
v_national_holiday_name countries.national_holiday_name%TYPE; 
v_national_holiday_date   countries.national_holiday_date%TYPE; 
CURSOR countries_cur IS    
SELECT country_name, national_holiday_name, national_holiday_date
FROM countries      
WHERE region_id = 5 AND national_holiday_date IS NOT NULL;
BEGIN  OPEN countries_cur; 
LOOP   
FETCH countries_cur INTO v_country_name, v_national_holiday_name, v_national_holiday_date;   
EXIT WHEN countries_cur%NOTFOUND;    
DBMS_OUTPUT.PUT_LINE('Country: ' || v_country_name    || ' National holiday: '|| v_national_holiday_name     || ', held on: '|| v_national_holiday_date);  
END LOOP;  
CLOSE countries_cur;
END;
Error report -
ORA-06550: line 3, column 35:
PLS-00302: component 'NATIONAL_HOLIDAY_NAME' must be declared
ORA-06550: line 3, column 25:
PL/SQL: Item ignored
ORA-06550: line 4, column 37:
PLS-00302: component 'NATIONAL_HOLIDAY_DATE' must be declared
ORA-06550: line 4, column 27:
PL/SQL: Item ignored
ORA-06550: line 8, column 25:
PL/SQL: ORA-00904: "NATIONAL_HOLIDAY_DATE": invalid identifier
ORA-06550: line 6, column 1:
PL/SQL: SQL Statement ignored
ORA-06550: line 11, column 42:
PLS-00320: the declaration of the type of this expression is incomplete or malformed
ORA-06550: line 11, column 1:
PL/SQL: SQL Statement ignored
ORA-06550: line 13, column 83:
PLS-00320: the declaration of the type of this expression is incomplete or malformed
ORA-06550: line 13, column 1:
PL/SQL: Statement ignored
06550. 00000 -  "line %s, column %s:\n%s"
*Cause:    Usually a PL/SQL compilation error.
*Action:
