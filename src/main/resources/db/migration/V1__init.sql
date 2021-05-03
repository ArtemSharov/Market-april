BEGIN;
CREATE table products (id bigserial primary key, title varchar(255), price int);
INSERT into products(title, price) VALUES
('Honey', 400),
('Chicken', 340),
('Oil', 130);
COMMIT;