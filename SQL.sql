CREATE database store;

USE store;
CREATE TABLE clients (
 	id INT AUTO_INCREMENT PRIMARY KEY,
 	name VARCHAR(75) NOT NULL,
 	lastname VARCHAR(75) NOT NULL,
 	docnumber VARCHAR(11) UNIQUE NOT NULL
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

USE store;
CREATE TABLE products(
	id INT AUTO_INCREMENT PRIMARY KEY,
  	description VARCHAR(50),
  	code VARCHAR(50),
  	stock INT,
  	price DOUBLE
);
