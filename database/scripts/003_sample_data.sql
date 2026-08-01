INSERT INTO users
(name_surname, phone_number, password_hash, role_id, created_at)
VALUES
('Ahmet Yılmaz', '05551234567', 'password123', 2, CURRENT_DATE),
('Mehmet Demir', '05552345678', 'password123', 3, CURRENT_DATE),
('Ayşe Kaya', '05553456789', 'password123', 4, CURRENT_DATE),
('Fatma Çelik', '05554567890', 'password123', 1, CURRENT_DATE);

INSERT INTO producer
(user_id, address)
VALUES
(1, 'Eskişehir');

INSERT INTO commission_agent
(user_id, company_name, tax_number)
VALUES
(2, 'Eskişehir Hal Komisyon', '1234567890');

INSERT INTO trader
(user_id, company_name, tax_number)
VALUES
(3, 'Demir Ticaret', '9876543210');

INSERT INTO product
(name, unit_id, created_at)
VALUES
('Tomato', 1, CURRENT_TIMESTAMP),
('Cucumber', 1, CURRENT_TIMESTAMP),
('Pepper', 1, CURRENT_TIMESTAMP);

INSERT INTO product_delivery
(producer_id, commission_agent_id, product_id, quantity, unit_price, delivery_date, created_at, delivery_status_id)
VALUES
(1, 1, 1, 500.00, 30.50, CURRENT_DATE, CURRENT_TIMESTAMP, 2),
(1, 1, 2, 300.00, 18.75, CURRENT_DATE, CURRENT_TIMESTAMP, 2),
(1, 1, 3, 200.00, 42.00, CURRENT_DATE, CURRENT_TIMESTAMP, 2);

INSERT INTO sale
(commission_agent_id, trader_id, sales_date, total_amount, sale_status_id)
VALUES
(1, 1, CURRENT_DATE, 20875.00, 2);

INSERT INTO sale_item
(sale_id, product_delivery_id, quantity, unit_price)
VALUES
(1, 1, 500.00, 30.50),
(1, 2, 300.00, 18.75);

INSERT INTO payment
(sale_id, amount_received, payment_date, created_at, payment_status_id)
VALUES
(1, 20875.00, CURRENT_DATE, CURRENT_TIMESTAMP, 2);

INSERT INTO document
(sale_id, user_id, uploaded_at, file_name)
VALUES
(1, 2, CURRENT_TIMESTAMP, 'invoice_001.pdf');




