insert into cuisine (name) values ('Italian');
insert into cuisine (name) values ('Brazilian');
insert into cuisine (name) values ('American');
insert into cuisine (name) values ('French');

insert into restaurant (name, address, delivery_fee, cuisine_id, created_date, updated_date, city, grab_and_go, active) values ('Mamma Mia', 'Mamma Street, 14', 10.0, 1, current_timestamp, current_timestamp, 'Venice', false, true);
insert into restaurant (name, address, delivery_fee, cuisine_id, created_date, updated_date, city, grab_and_go, active) values ('Churrascaria', 'Disorder Avenue, 5000', 8.0, 2, current_timestamp, current_timestamp, 'Sertãozinho', true, true);
insert into restaurant (name, address, delivery_fee, cuisine_id, created_date, updated_date, city, grab_and_go, active) values ('Burguer Place', 'Clueless Alley, 10', 5.0, 3, current_timestamp, current_timestamp, 'San Francisco', true, false);
insert into restaurant (name, address, delivery_fee, cuisine_id, created_date, updated_date, city, grab_and_go, active) values ('La Maison du Croissant ', 'Rue Paris, 7', 15.0, 4, current_timestamp, current_timestamp, 'Paris', false, true);

insert into restaurant (name, address, delivery_fee, cuisine_id, created_date, updated_date, city, grab_and_go, active) values ('Pasta Buona', 'Pasta Street, 4', 2.0, 1, current_timestamp, current_timestamp, 'Roma', true, true);
insert into restaurant (name, address, delivery_fee, cuisine_id, created_date, updated_date, city, grab_and_go, active) values ('Marcante Pizzaria', 'Bricks Street, 21', 9.0, 2, current_timestamp, current_timestamp, 'São Paulo', true, false);
