create table categories (id bigserial primary key, title varchar(255));
insert into categories (title) values ('Food');

CREATE table products (id bigserial primary key, title varchar(255), price int, category_id bigint references categories (id));
INSERT into products(title, price, category_id) VALUES
('Honey', 400, 1),
('Chicken', 340, 1),
('Oil', 130, 1),
('Cheese3', 325, 1),
('Cheese4', 325, 1),
('Cheese5', 325, 1),
('Cheese6', 325, 1),
('Cheese7', 325, 1),
('Cheese8', 325, 1),
('Cheese9', 325, 1),
('Cheese11', 325, 1),
('Cheese12', 325, 1),
('Cheese13', 325, 1),
('Cheese14', 325, 1),
('Cheese15', 325, 1),
('Cheese16', 325, 1),
('Cheese17', 325, 1),
('Cheese21', 325, 1),
('Cheese22', 325, 1),
('Cheese23', 325, 1),
('Cheese24', 325, 1);
