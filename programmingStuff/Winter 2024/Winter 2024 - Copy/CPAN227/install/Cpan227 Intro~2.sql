CREATE TABLE Grocery_items( 
  product_id NUMBER NOT NULL,
  brand VARCHAR2(50),
  description VARCHAR2(50)
);

INSERT INTO grocery_items(product_id, brand, description)
VALUES(110,'Colgate','toothpaste');
INSERT INTO grocery_items(product_id, brand, description)
VALUES(111,'Ivory','soap');
INSERT INTO grocery_items(product_id, brand, description)
VALUES(112,'Heinz','ketchup');
INSERT INTO grocery_items(product_id, brand, description)
VALUES(113,'CocaCola','beverage');


UPDATE grocery_items
SET description='tomato catsup'
WHERE product_id = 112;

INSERT INTO grocery_items
VALUES(114,'Twix','candy');


UPDATE grocery_items
SET brand='Dove'
WHERE product_id = 111;



CREATE TABLE new_items
( 
  product_id NUMBER NOT NULL,
  brand VARCHAR2(50),
  description VARCHAR2(80)
);

INSERT INTO new_items
VALUES(110,'Colgate','dental paste');
INSERT INTO new_items
VALUES(175,'MtnDew','Soda');
INSERT INTO new_items
VALUES(275,'Palmolive','Dish Detergent');



MERGE INTO grocery_items g USING new_items i ON (g.product_id = i.product_id) WHEN MATCHED THEN UPDATE SET g.brand = i.brand, g.description = i.description WHEN NOT MATCHED THEN INSERT VALUES(i.product_id, i.brand, i.description);

SELECT * FROM Grocery_items;-- JOIN new_items USING(id);


CREATE TABLE new_depts AS SELECT * FROM departments; 

DECLARE 
v_max_deptno new_depts.department_id%TYPE;
v_dept_name new_depts.department_name%TYPE := 'A New Department';
v_dept_id new_depts.department_id%TYPE;
BEGIN
SELECT MAX(department_id) INTO v_max_deptno
FROM new_depts;
v_dept_id := v_max_deptno+10;
DBMS_OUTPUT.PUT_LINE('The maximum department id is: ' || v_max_deptno);

END;

