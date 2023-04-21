-- DDL **********************************************************************************

CREATE database store;

USE store;
CREATE TABLE clients (
 	id INT AUTO_INCREMENT PRIMARY KEY,
 	name VARCHAR(75) NOT NULL,
 	lastname VARCHAR(75) NOT NULL,
 	docnumber VARCHAR(11) UNIQUE NOT NULL
);

USE store;
CREATE TABLE products(
	id INT AUTO_INCREMENT PRIMARY KEY,
  	description VARCHAR(50),
  	code VARCHAR(50),
  	stock INT,
  	price DOUBLE
);

USE store;
CREATE TABLE invoice(
	id INT AUTO_INCREMENT PRIMARY KEY,
  	client_id INT NOT NULL,
  	created_at DATETIME,
  	total DOUBLE,
  	constraint fk_invoice_clients foreign key(client_id) references clients(id) 
);

USE store;
CREATE TABLE invoice_details(
	id INT AUTO_INCREMENT PRIMARY KEY,
  	invoice_id INT NOT NULL,
  	amoun INT,
  	product_id INT NOT NULL,
  	price DOUBLE,
  	constraint fk_invoicedetails_invoice foreign key(invoice_id) references invoice(id),
  	constraint fk_invoicedetails_products foreign key(product_id) references products(id)
);

-- DML **********************************************************************************

INSERT INTO clients (name, lastname, docnumber) VALUES
('Jorge', 'Sanchez', '12345678901'),
('Laura', 'González', '23456789012'),
('Carlos', 'Ramírez', '34567890123'),
('María', 'Pérez', '45678901234'),
('Juan', 'Ortiz', '56789012345');

INSERT INTO products (description, code, stock, price) VALUES
('Lavadora Whirlpool', 'LAV001', 5, 1599000),
('Nevera LG', 'NEV001', 8, 2149000),
('Televisor Samsung', 'TV001', 3, 2999000),
('Aspiradora Philips', 'ASP001', 12, 299000),
('Horno microondas LG', 'HOR001', 7, 539000),
('Licuadora Oster', 'LIC001', 10, 179000),
('Cafetera DeLonghi', 'CAF001', 4, 999000),
('Batidora KitchenAid', 'BAT001', 6, 399000),
('Plancha Black+Decker', 'PLA001', 15, 99000),
('Ventilador de techo', 'VEN001', 9, 299000);

