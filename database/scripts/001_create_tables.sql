CREATE TABLE role (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE users (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name_surname VARCHAR(50) NOT NULL,
	phone_number VARCHAR(15) NOT NULL,
	password_hash VARCHAR(255)  NOT NULL,
	role_id INTEGER NOT NULL,
	created_at DATE,

	FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE producer(
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	users_id INTEGER NOT NULL,
	address VARCHAR(125) NOT NULL,

	FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE commission_agent(
        id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        users_id INTEGER NOT NULL,
        company_name  VARCHAR(50) NOT NULL,
	tax_number VARCHAR(20) NOT NULL,

        FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE trader (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	users_id INTEGER NOT NULL,
	company_name  VARCHAR(50) NOT NULL,
	tax_number INTEGER NOT NULL,

	FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE unit (
        id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE product (
        id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        unit_id INTEGER NOT NULL,
        created_at TIMESTAMP NOT NULL,

        FOREIGN KEY (unit_id) REFERENCES unit(id)
);



CREATE TABLE delivery_status (
       	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
       	name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE product_delivery (
       	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    	producer_id INTEGER NOT NULL,
    	commission_agent_id INTEGER NOT NULL,
    	product_id INTEGER NOT NULL,
	quantity NUMERIC(10,2) NOT NULL,
     	unit_price NUMERIC(10,2) NOT NULL,
	delivery_date DATE NOT NULL,
	created_at TIMESTAMP NOT NULL,
	delivery_status_id INTEGER NOT NULL,

	FOREIGN KEY (producer_id) REFERENCES producer(id),
	FOREIGN KEY (commission_agent_id) REFERENCES commission_agent(id),
	FOREIGN KEY (product_id) REFERENCES product(id),
	FOREIGN KEY (delivery_status_id) REFERENCES delivery_status(id)
);

CREATE TABLE sale_status (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE sale (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	commission_agent_id INTEGER NOT NULL,
	trader_id INTEGER NOT NULL,
	sales_date DATE NOT NULL,
	total_amount NUMERIC(10,2) NOT NULL,
	sale_status_id INTEGER NOT NULL,

	FOREIGN KEY (sale_status_id) REFERENCES sale_status(id),
	FOREIGN KEY (commission_agent_id) REFERENCES commission_agent(id),
	FOREIGN KEY (trader_id) REFERENCES trader(id)
);
CREATE TABLE sale_item (
        id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        sale_id INTEGER NOT NULL,
        product_delivery_id INTEGER NOT NULL,
        quantity NUMERIC(10,2) NOT NULL,
        unit_price NUMERIC(10,2) NOT NULL,

        FOREIGN KEY (sale_id) REFERENCES sale(id),
        FOREIGN KEY (product_delivery_id) REFERENCES product_delivery(id)
);


CREATE TABLE payment_status (
        id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE payment (
	id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	sale_id INTEGER NOT NULL,
	amount_received NUMERIC(10,2) NOT NULL,
	payment_date DATE NOT NULL,
	created_at TIMESTAMP NOT NULL,
	payment_status_id INTEGER NOT NULL,

	FOREIGN KEY (sale_id) REFERENCES sale(id),
	FOREIGN KEY (payment_status_id) REFERENCES payment_status(id)
);


CREATE TABLE document (
        id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        sale_id INTEGER NOT NULL,
        users_id INTEGER NOT NULL,
        uploaded_at TIMESTAMP NOT NULL,
        file_name VARCHAR(255) NOT NULL,

        FOREIGN KEY (sale_id) REFERENCES sale(id),
        FOREIGN KEY (user_id) REFERENCES users(id),
);

