CREATE TABLE departments (
	department_id serial PRIMARY KEY,
	department_name TEXT,
	department_sales decimal(15,2) 
);

CREATE TABLE products (
	product_id serial PRIMARY KEY,
	product_name TEXT,
	product_description TEXT,
	price decimal(15, 2),
	stock int,
	department_id int REFERENCES departments (department_id)
);

INSERT INTO departments (department_name, department_sales)
VALUES ('Kitchen', 5368.33),
       ('Electronics', 7463.75),
       ('Power Tools', 3480.21),
       ('Automotive', 4621.89),
       ('Lawn Care', 3688.55);
      
SELECT * FROM departments;

INSERT INTO products (product_name, product_description, price, stock, department_id)
VALUES ('X2R Industrial Refridgerator', 'Large refridgerator perfect for small buisnesses', 2999.99, 20, 1),
       ('B12 Widescreen Television', '40 inch widescreen TV', 349.99, 35, 2),
       ('F27 Power Drill', 'Battery powered drill with multiple accessories', 139.99, 23, 3),
       ('NJ7 Wiper Blades', 'High-end wiper blades garunteed to last', 39.99, 37, 4),
       ('U25 Lawn Mower', 'Small electric lawn mower with adjustable height', 449.99, 22, 5),
       ('Y2K Personal Computer', 'Mid-range PC with windows 10 pre-installed', 899.99, 14, 2),
       ('G99 Table Saw', 'Large table saw with adjustable base', 599.99, 10, 3),
       ('K88 Battery', 'Car battery for mid-size vehicles', 89.99, 20, 4),
       ('T65 Weed Whacker', 'Battery powered weed whacker', 194.99, 11, 5),
       ('OP8 Dishwasher', 'High capacity dishwasher', 999.99, 14, 1),
       ('P01 Smartphone', 'Modern smartphone with Android OS installed', 249.99, 32, 2),
       ('M67 Power Washer', 'Standard power washer with adjustable head', 159.99, 8, 3),
       ('L35 Brakepads', 'Long lasting brakepads for mid-size vehicles', 49.99, 24, 4),
       ('J14 Leafblower', 'Electric leafblower with spare battery', 199.99, 16, 5);
      
SELECT * FROM products;
       
      
      
DROP TABLE products;
DROP TABLE departments;