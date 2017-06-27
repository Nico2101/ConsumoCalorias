INSERT INTO usuario (id, correo, clave, nombre, apellido, max_calorias, peso, fecha_nacimiento) 
	values(1, 'navaja@conscal.cl', '1234', 'Pedro', 'Navaja', 2500, 78, '1980-12-21');
INSERT INTO usuario (id, correo, clave, nombre, apellido, max_calorias, peso, fecha_nacimiento) 
	values(2, 'mesa@conscal.cl', '1234', 'Florinda', 'Mesa', 1250, 64, '1962-07-15');
INSERT INTO usuario (id, correo, clave, nombre, apellido, max_calorias, peso, fecha_nacimiento) 
	values(3, 'shuster@conscal.cl', '1234', 'Augusto', 'Shuster', 3800, 55, '1989-02-23');
INSERT INTO usuario (id, correo, clave, nombre, apellido, max_calorias, peso, fecha_nacimiento) 
	values(0, 'root@conscal.cl', 'clave', 'Martita', 'Muñoz', 0, 0, '2000-01-01');
	
INSERT INTO tipo (id, nombre) values (1, 'Desayuno');
INSERT INTO tipo (id, nombre) values (2, 'Almuerzo');
INSERT INTO tipo (id, nombre) values (3, 'Cena');
INSERT INTO tipo (id, nombre) values (4, 'Colación');

INSERT INTO categoria (id, nombre) values (1, 'Frutas');
INSERT INTO categoria (id, nombre) values (2, 'Comida chatarra');
INSERT INTO categoria (id, nombre) values (3, 'Carnes');
INSERT INTO categoria (id, nombre) values (4, 'Verduras');
INSERT INTO categoria (id, nombre) values (5, 'Pescados');
INSERT INTO categoria (id, nombre) values (6, 'Bebidas');

INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (1, 'Manzana', 52, 100, 'gr', 1, 1);
INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (2, 'Apio', 16, 100, 'gr', 1, 4);
INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (3, 'Papas Fritas',368, 30, 'gr', 1, 2);
INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (4, 'Hamburguesa', 295, 100, 'gr', 2, 3);
INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (5, 'Pollo Asado', 210, 100, 'gr', 2, 3);
INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (6, 'Ensalada de repollo', 17, 250, 'gr', 2, 4);
INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (7, 'Codorniz', 110, 100, 'gr', 2, 3);
INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (8, 'Pescado al horno', 126, 100, 'gr', 3, 5);
INSERT INTO alimento(id, nombre, calorias, cantidad, medida, id_usuario, id_categoria) 
	values (9, 'Vaso de jugo', 112, 250, 'ml', 3, 6);