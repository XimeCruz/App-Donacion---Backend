INSERT INTO public.rol (id, nombre)
    VALUES (DEFAULT, 'Donante'),
            (DEFAULT, 'Beneficiario'),
            (DEFAULT, 'Voluntario');


INSERT INTO public.usuarios(id, nombre, "nombre de usuario", correo_electronico, password, activo, telefono, "fecha de nacimiento", id_rol)
VALUES
    (9, 'Admin', 'Admin', 'Admin@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 2),
    (10, 'Mateo josue Rodriguez Chico', 'Mateo', 'mateo204r@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 1);
    (11, 'Juan Pablo García Rodríguez', 'JuanPabloGR', 'juanpablogarciar@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918703', '2003-08-28', 1),
    (12, 'María Fernanda Martínez López', 'MariaFernandaML', 'mariafernandamartinez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918704', '2002-02-07', 1),
    (13, 'Luisa Sofía González García', 'LuisaSofiaGG', 'luisasofiagonzalez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918705', '2001-06-16', 1),
    (14, 'Carlos Alberto Rodríguez Martínez', 'CarlosAlbertoRM', 'carlosalbertorodriguez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918706', '2000-10-25', 1),
    (15, 'Ana Gabriela López Sánchez', 'AnaGabrielaLS', 'anagabrielalopez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918707', '1999-03-06', 1),
    (16, 'Javier Alejandro Pérez García', 'JavierAlejandroPG', 'javieralejandroperez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918708', '1998-07-15', 1),
    (17, 'Catalina Sofía Martínez Rodríguez', 'CatalinaSofiaMR', 'catalinasofiamartinez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918709', '1997-11-24', 1),
    (18, 'Santiago Andrés García López', 'SantiagoAndresGL', 'santiagoandresgarcia@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918710', '1996-04-04', 1),
    (19, 'Camila Valentina Rodríguez Sánchez', 'CamilaValentinaRS', 'camilavalentinarodriguez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918711', '1995-08-13', 1),
    (20, 'Sebastián Felipe Martínez García', 'SebastianFelipeMG', 'sebastianfelipemartinez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918712', '1994-12-22', 1),
    (21, 'Valeria Alejandra López Martínez', 'ValeriaAlejandraLM', 'valeriaalejandralopez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918713', '1993-05-03', 1),
    (22, 'Juan Pablo García Rodríguez', 'JuanPabloGR2', 'juanpablogarciar2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918714', '1992-09-11', 1),
    (23, 'María Fernanda Martínez López', 'MariaFernandaML2', 'mariafernandamartinez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918715', '1991-01-20', 1),
    (24, 'Luisa Sofía González García', 'LuisaSofiaGG2', 'luisasofiagonzalez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918716', '1990-05-31', 1),
    (25, 'Carlos Alberto Rodríguez Martínez', 'CarlosAlbertoRM2', 'carlosalbertorodriguez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918717', '1989-10-09', 1),
    (26, 'Ana Gabriela López Sánchez', 'AnaGabrielaLS2', 'anagabrielalopez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918718', '1988-02-18', 1),
    (27, 'Javier Alejandro Pérez García', 'JavierAlejandroPG2', 'javieralejandroperez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918719', '1987-06-29', 1),
    (28, 'Catalina Sofía Martínez Rodríguez', 'CatalinaSofiaMR2', 'catalinasofiamartinez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918720', '1986-11-08', 1),
    (29, 'Santiago Andrés García López', 'SantiagoAndresGL2', 'santiagoandresgarcia2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918721', '1985-03-19', 1),
    (30, 'Camila Valentina Rodríguez Sánchez', 'CamilaValentinaRS2', 'camilavalentinarodriguez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918722', '1984-07-28', 1),
    (31, 'Sebastián Felipe Martínez García', 'SebastianFelipeMG2', 'sebastianfelipemartinez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918723', '1983-12-07', 1),
    (32, 'Valeria Alejandra López Martínez', 'ValeriaAlejandraLM2', 'valeriaalejandralopez2@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918724', '1982-04-17', 1),
    (33, 'Juan Pablo García Rodríguez', 'JuanPabloGR3', 'juanpablogarciar3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918725', '1981-08-26', 1),
    (34, 'María Fernanda Martínez López', 'MariaFernandaML3', 'mariafernandamartinez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918726', '1980-01-04', 1),
    (35, 'Luisa Sofía González García', 'LuisaSofiaGG3', 'luisasofiagonzalez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918727', '1979-05-15', 1),
    (36, 'Carlos Alberto Rodríguez Martínez', 'CarlosAlbertoRM3', 'carlosalbertorodriguez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918728', '1978-09-24', 1),
    (37, 'Ana Gabriela López Sánchez', 'AnaGabrielaLS3', 'anagabrielalopez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918729', '1977-02-03', 1),
    (38, 'Javier Alejandro Pérez García', 'JavierAlejandroPG3', 'javieralejandroperez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918730', '1976-06-14', 1),
    (39, 'Catalina Sofía Martínez Rodríguez', 'CatalinaSofiaMR3', 'catalinasofiamartinez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918731', '1975-10-23', 1),
    (40, 'Santiago Andrés García López', 'SantiagoAndresGL3', 'santiagoandresgarcia3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918732', '1974-03-04', 1),
    (41, 'Camila Valentina Rodríguez Sánchez', 'CamilaValentinaRS3', 'camilavalentinarodriguez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918733', '1973-07-14', 1),
    (42, 'Sebastián Felipe Martínez García', 'SebastianFelipeMG3', 'sebastianfelipemartinez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918734', '1972-11-23', 1),
    (43, 'Valeria Alejandra López Martínez', 'ValeriaAlejandraLM3', 'valeriaalejandralopez3@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918745', '1971-04-03', 1),
    (44, 'Juan Pablo García Rodríguez', 'JuanPabloGR4', 'juanpablogarciar4@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918746', '1970-08-13', 1),
    (45, 'María Fernanda Martínez López', 'MariaFernandaML4', 'mariafernandamartinez4@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918747', '1969-12-22', 1),
    (46, 'Luisa Sofía González García', 'LuisaSofiaGG4', 'luisasofiagonzalez4@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918748', '1969-05-02', 1),
    (47, 'Carlos Alberto Rodríguez Martínez', 'CarlosAlbertoRM4', 'carlosalbertorodriguez4@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918749', '1968-09-11', 1),
    (48, 'Ana Gabriela López Sánchez', 'AnaGabrielaLS4', 'anagabrielalopez4@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918750', '1967-01-21', 1),
    (49, 'Javier Alejandro Pérez García', 'JavierAlejandroPG4', 'javieralejandroperez4@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918751', '1966-06-01', 1),
    (50, 'Catalina Sofía Martínez Rodríguez', 'CatalinaSofiaMR4', 'catalinasofiamartinez4@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918752', '1965-10-11', 1);
    (51, 'Mariana Patricia González Sánchez', 'MarianaPati', 'marianapatriciagonzalez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918742', '1966-06-26', 1),
    (52, 'Martín Alejandro Rodríguez Martínez', 'MartinAlej', 'martinalejandrorodriguez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918743', '1965-11-04', 1),
    (53, 'Elena Andrea Pérez García', 'ElenaAndP', 'elenaandreaperez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918744', '1964-03-15', 1),
    (54, 'Ricardo Antonio López Martínez', 'RicardoAnL', 'ricardoantoniolopez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918735', '1973-10-19', 1),
    (55, 'Isabella María Hernández Sánchez', 'IsabellaMS', 'isabellamariahernandez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918736', '1972-02-28', 1),
    (56, 'Francisco Javier Pérez Martínez', 'FranciscoJP', 'franciscojavierperez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918737', '1971-07-09', 1),
    (57, 'Valeria Paola González García', 'ValeriaPG', 'valeriapaolagonzalez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918738', '1970-11-18', 1),
    (58, 'Gustavo Alejandro Rodríguez Sánchez', 'GustavoARS', 'gustavoalejandrorodriguez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918739', '1969-05-27', 1),
    (59, 'Lucía Andrea López Martínez', 'LuciaAndLM', 'luciaandrealopez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918740', '1968-10-06', 1),
    (60, 'Hernán Antonio Pérez García', 'HernanAPG', 'hernanantonioperez@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918741', '1967-02-15', 1);

INSERT INTO public.categoria (id, nombre, descripcion)
VALUES
    (1, 'vegetales', 'Vegetales frescos y saludables'),
    (2, 'frutas', 'Frutas frescas y jugosas'),
    (3, 'granos', 'Productos a base de granos'),
    (4, 'productos lacteos', 'Productos lácteos variados'),
    (5, 'proteinas', 'Fuentes de proteína animal y vegetal'),
    (6, 'otros', 'Otros productos diversos');




INSERT INTO public.organizacion (id, area_servicio, nombre_org, tipo_alimento, tipo_org, ubicacion)
VALUES 
    (1, 'Huerfanos', 'Aldeas Infantiles', 'de todo tipo', 'SIN FINES DE LUCRO', 'AV.olmos');
    (2, 'Niños en situación de calle', 'Fundación Manos Unidas', 'frutas, granos, productos lácteos', 'ONG', 'Calle 6 de Agosto #123'),
    (3, 'Personas mayores desamparadas', 'Casa del Abuelo', 'vegetales, productos lácteos, otros', 'Fundación', 'Av. Arce #456'),
    (4, 'Familias de escasos recursos', 'Fundación Compartir', 'vegetales, frutas, granos, productos lácteos, proteinas', 'Asociación', 'Calle Murillo #789'),
    (5, 'Mujeres embarazadas en situación de vulnerabilidad', 'Casa Materna Esperanza', 'productos lácteos, vegetales, proteinas', 'Fundación', 'Av. 20 de Octubre #1010'),
    (6, 'Personas con discapacidad', 'Fundación Vida Nueva', 'vegetales, frutas, granos, proteinas', 'ONG', 'Calle Ballivián #1313'),
    (7, 'Niños en situación de vulnerabilidad', 'Fundación Sonrisas', 'vegetales, frutas, granos, productos lácteos', 'ONG', 'Calle 16 de Julio #1414'),
    (8, 'Personas en situación de calle', 'Casa de Acogida Esperanza', 'vegetales, frutas, granos, productos lácteos, proteinas', 'Fundación', 'Av. Mariscal Santa Cruz #1515'),
    (9, 'Madres solteras y sus hijos', 'Casa Cuna Amor y Esperanza', 'vegetales, frutas, granos, productos lácteos, proteinas', 'Asociación', 'Calle Juan XXIII #1616'),
    (10, 'Personas en recuperación de adicciones', 'Centro de Rehabilitación Nueva Vida', 'vegetales, frutas, granos, productos lácteos, proteinas', 'ONG', 'Av. del Maestro #1717'),
    (11, 'Adultos mayores en situación de abandono', 'Hogar del Anciano San José', 'vegetales, frutas, granos, productos lácteos, proteinas', 'Fundación', 'Calle Bolívar #1818');


INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (7, 'Zanahoria fresca y crujiente', '2024-04-18', null, 'Zanahoria', 1, 50, 1, 10, '/images/zanahoria.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (9, 'Pepino fresco de campo', '2024-04-18', null, 'Pepino', 1, 60, 1, 10, '/images/pepino.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (8, 'Espinacas orgánicas', '2024-04-18', null, 'Espinaca', 1, 40, 1, 10, '/images/espinaca.jpeg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (11, 'Pimiento rojo crujiente', '2024-04-18', null, 'Pimiento', 1, 45, 1, 10, '/images/pimiento.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (10, 'Brócoli verde y nutritivo', '2024-04-18', null, 'Brócoli', 1, 30, 1, 10, '/images/brocoli.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (24, 'Mantequilla cremosa', '2024-04-18', null, 'Mantequilla', 2, 50, 4, 10, '/images/mantequilla.jpeg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (22, 'Yogur natural sin azúcar', '2024-04-18', null, 'Yogur', 1.5, 40, 4, 10, '/images/yogurt.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (12, 'Plátano maduro y dulce', '2024-04-18', null, 'Plátano', 1, 70, 2, 10, '/images/platanos.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (14, 'Uvas moradas sin semillas', '2024-04-18', null, 'Uva', 3, 40, 2, 10, '/images/uva.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (18, 'Avena integral en hojuelas', '2024-04-18', null, 'Avena', 2.5, 80, 3, 10, '/images/avena.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (15, 'Fresas rojas y jugosas', '2024-04-18', null, 'Fresa', 2.5, 55, 2, 10, '/images/fresa.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (27, 'Filete de salmón fresco', '2024-04-18', null, 'Salmón', 8, 20, 5, 10, '/images/salmon.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (23, 'Queso Cheddar en lonchas', '2024-04-18', null, 'Queso Cheddar', 3, 30, 4, 10, '/images/queso.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (26, 'Yogur griego natural sin grasa', '2024-04-18', null, 'Yogur Griego', 2, 35, 4, 10, '/images/yogurt2.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (19, 'Lentejas secas y nutritivas', '2024-04-18', null, 'Lentejas', 3.5, 60, 3, 10, '/images/lenteja.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (16, 'Mango maduro de temporada', '2024-04-18', null, 'Mango', 2, 45, 2, 10, '/images/mango.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (13, 'Naranjas frescas recién recolectadas', '2024-04-18', null, 'Naranja', 1.2, 60, 2, 10, '/images/naranja.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (17, 'Quinoa orgánica de alta calidad', '2024-04-18', null, 'Quinoa', 4, 25, 3, 10, '/images/quinua.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (20, 'Arroz integral de grano largo', '2024-04-18', null, 'Arroz Integral', 2, 70, 3, 10, '/images/arroz.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (25, 'Leche de almendras sin azúcar', '2024-04-18', null, 'Leche de Almendras', 2.5, 45, 4, 10, '/images/leche.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (21, 'Garbanzos secos de alta calidad', '2024-04-18', null, 'Garbanzos', 3, 50, 3, 10, '/images/garbanzo.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (29, 'Tofu orgánico extrafirme', '2024-04-18', null, 'Tofu', 2.5, 40, 5, 10, '/images/tofu.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (34, 'Cepillo de dientes suave', '2024-04-18', null, 'Cepillo de Dientes', 1.5, 70, 6, 10, '/images/cepillo.png');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (36, 'Rollo de papel aluminio resistente', '2024-04-18', null, 'Papel Aluminio', 2, 90, 6, 10, '/images/aluminio.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (32, 'Rollo de papel higiénico suave', '2024-04-18', null, 'Papel Higiénico', 1.2, 100, 6, 10, '/images/higienico.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (31, 'Pechuga de pavo sin hueso', '2024-04-18', null, 'Pechuga de Pavo', 6, 25, 5, 10, '/images/pechuga.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (30, 'Filete de carne de res magra', '2024-04-18', null, 'Carne de Res', 10, 15, 5, 10, '/images/carne.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (28, 'Docena de huevos orgánicos', '2024-04-18', null, 'Huevos', 3, 50, 5, 10, '/images/huevos.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (35, 'Shampoo revitalizante para cabello', '2024-04-18', null, 'Shampoo', 4, 60, 6, 10, '/images/shampoo.jpg');
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen) VALUES (33, 'Detergente líquido para ropa', '2024-04-18', null, 'Detergente', 3, 80, 6, 10, '/images/detergente.jpg');


INSERT INTO public.donacion (id,cantidad, fecha_adquisicion, hora_adquisicion, donante_id, organizacion_id, producto_id, voluntario_id)
VALUES
    (1,7, '2024-04-18', '09:30:00', 10, 1, 7, 9),
    (2,25, '2024-04-18', '10:15:00', 10, 1, 8, 9),
    (3,77, '2024-04-18', '11:00:00', 10, 1, 9, 9),
    (4,46, '2024-04-18', '12:30:00', 10, 1, 10, 9),
    (5,33, '2024-04-18', '14:45:00', 10, 1, 11, 9),
    (6,14, '2024-04-18', '15:20:00', 10, 1, 12, 9),
    (7,11, '2024-04-18', '16:10:00', 10, 1, 13, 9),
    (8,68, '2024-04-18', '17:00:00', 10, 1, 14, 9),
    (9,50, '2024-04-18', '18:20:00', 10, 1, 15, 9),
    (10,92, '2024-04-18', '19:45:00', 10, 1, 16, 9);




INSERT INTO public.producto_carrito (id, id_producto_stock, id_beneficiario, "cantidad seleccionada", "fecha de agregado")
VALUES
    (5, 10, 10, 1, '2023-09-12 00:00:00'),
    (7, 113, 10, 1, '2023-09-12 00:00:00'),
    (8, 136, 10, 3, '2023-09-12 00:00:00'),
    (9, 114, 10, 3, '2023-09-12 00:00:00');


INSERT INTO public.productos_stock (id, nombre, descripcion, id_categoria, precio, cantidad_disponible, id_donante, fecha_publicacion)
VALUES
    (7, 'Zanahoria', 'Zanahoria fresca y crujiente', 1, 1, 50, 10, '2024-04-18'),
    (8, 'Espinaca', 'Espinacas orgánicas', 1, 1, 40, 10, '2024-04-18'),
    (9, 'Pepino', 'Pepino fresco de campo', 1, 1, 60, 10, '2024-04-18'),
    (10, 'Brócoli', 'Brócoli verde y nutritivo', 1, 1, 30, 10, '2024-04-18'),
    (11, 'Pimiento', 'Pimiento rojo crujiente', 1, 1, 45, 10, '2024-04-18');

INSERT INTO public.productos_stock (id, nombre, descripcion, id_categoria, precio, cantidad_disponible, id_donante, fecha_publicacion)
VALUES
    (12, 'Plátano', 'Plátano maduro y dulce', 2, 1, 70, 10, '2024-04-18'),
    (13, 'Naranja', 'Naranjas frescas recién recolectadas', 2, 1.2, 60, 10, '2024-04-18'),
    (14, 'Uva', 'Uvas moradas sin semillas', 2, 3, 40, 10, '2024-04-18'),
    (15, 'Fresa', 'Fresas rojas y jugosas', 2, 2.5, 55, 10, '2024-04-18'),
    (16, 'Mango', 'Mango maduro de temporada', 2, 2, 45, 10, '2024-04-18');

INSERT INTO public.productos_stock (id, nombre, descripcion, id_categoria, precio, cantidad_disponible, id_donante, fecha_publicacion)
VALUES
    (17, 'Quinoa', 'Quinoa orgánica de alta calidad', 3, 4, 25, 10, '2024-04-18'),
    (18, 'Avena', 'Avena integral en hojuelas', 3, 2.5, 80, 10, '2024-04-18'),
    (19, 'Lentejas', 'Lentejas secas y nutritivas', 3, 3.5, 60, 10, '2024-04-18'),
    (20, 'Arroz Integral', 'Arroz integral de grano largo', 3, 2, 70, 10, '2024-04-18'),
    (21, 'Garbanzos', 'Garbanzos secos de alta calidad', 3, 3, 50, 10, '2024-04-18');


INSERT INTO public.productos_stock (id, nombre, descripcion, id_categoria, precio, cantidad_disponible, id_donante, fecha_publicacion)
VALUES
    (22, 'Yogur', 'Yogur natural sin azúcar', 4, 1.5, 40, 10, '2024-04-18'),
    (23, 'Queso Cheddar', 'Queso Cheddar en lonchas', 4, 3, 30, 10, '2024-04-18'),
    (24, 'Mantequilla', 'Mantequilla cremosa', 4, 2, 50, 10, '2024-04-18'),
    (25, 'Leche de Almendras', 'Leche de almendras sin azúcar', 4, 2.5, 45, 10, '2024-04-18'),
    (26, 'Yogur Griego', 'Yogur griego natural sin grasa', 4, 2, 35, 10, '2024-04-18');


INSERT INTO public.productos_stock (id, nombre, descripcion, id_categoria, precio, cantidad_disponible, id_donante, fecha_publicacion)
VALUES
    (27, 'Salmón', 'Filete de salmón fresco', 5, 8, 20, 10, '2024-04-18'),
    (28, 'Huevos', 'Docena de huevos orgánicos', 5, 3, 50, 10, '2024-04-18'),
    (29, 'Tofu', 'Tofu orgánico extrafirme', 5, 2.5, 40, 10, '2024-04-18'),
    (30, 'Carne de Res', 'Filete de carne de res magra', 5, 10, 15, 10, '2024-04-18'),
    (31, 'Pechuga de Pavo', 'Pechuga de pavo sin hueso', 5, 6, 25, 10, '2024-04-18');


INSERT INTO public.productos_stock (id, nombre, descripcion, id_categoria, precio, cantidad_disponible, id_donante, fecha_publicacion)
VALUES
    (32, 'Papel Higiénico', 'Rollo de papel higiénico suave', 6, 1.2, 100, 10, '2024-04-18'),
    (33, 'Detergente', 'Detergente líquido para ropa', 6, 3, 80, 10, '2024-04-18'),
    (34, 'Cepillo de Dientes', 'Cepillo de dientes suave', 6, 1.5, 70, 10, '2024-04-18'),
    (35, 'Shampoo', 'Shampoo revitalizante para cabello', 6, 4, 60, 10, '2024-04-18'),
    (36, 'Papel Aluminio', 'Rollo de papel aluminio resistente', 6, 2, 90, 10, '2024-04-18');


INSERT INTO public.organizacion (id, area_servicio, nombre_org, tipo_alimento, tipo_org, ubicacion)
VALUES (1, 'Huerfanos', 'Aldeas Infantiles', 'de tood tipo', 'SIN FINES DE LUCRO', 'Av.Olmos');


INSERT INTO public.donacion (id,cantidad, fecha_adquisicion, hora_adquisicion, donante_id, organizacion_id, producto_id, voluntario_id)
VALUES
    (1,7, '2024-04-18', '09:30:00', 10, 1, 7, 9),
    (2,25, '2024-04-18', '10:15:00', 10, 1, 8, 9),
    (3,77, '2024-04-18', '11:00:00', 10, 1, 9, 9),
    (4,46, '2024-04-18', '12:30:00', 10, 1, 10, 9),
    (5,33, '2024-04-18', '14:45:00', 10, 1, 11, 9),
    (6,14, '2024-04-18', '15:20:00', 10, 1, 12, 9),
    (7,11, '2024-04-18', '16:10:00', 10, 1, 13, 9),
    (8,68, '2024-04-18', '17:00:00', 10, 1, 14, 9),
    (9,50, '2024-04-18', '18:20:00', 10, 1, 15, 9),
    (10,92, '2024-04-18', '19:45:00', 10, 1, 16, 9);


INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (7, 'Zanahoria fresca y crujiente', '2024-04-18', null, 'Zanahoria', 1, 50, 1, 10, '/images/zanahoria.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (9, 'Pepino fresco de campo', '2024-04-18', null, 'Pepino', 1, 60, 1, 10, '/images/pepino.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (8, 'Espinacas orgánicas', '2024-04-18', null, 'Espinaca', 1, 40, 1, 10, '/images/espinaca.jpeg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (11, 'Pimiento rojo crujiente', '2024-04-18', null, 'Pimiento', 1, 45, 1, 10, '/images/pimiento.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (10, 'Brócoli verde y nutritivo', '2024-04-18', null, 'Brócoli', 1, 30, 1, 10, '/images/brocoli.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (24, 'Mantequilla cremosa', '2024-04-18', null, 'Mantequilla', 2, 50, 4, 10, '/images/mantequilla.jpeg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (22, 'Yogur natural sin azúcar', '2024-04-18', null, 'Yogur', 1.5, 40, 4, 10, '/images/yogurt.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (12, 'Plátano maduro y dulce', '2024-04-18', null, 'Plátano', 1, 70, 2, 10, '/images/platanos.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (14, 'Uvas moradas sin semillas', '2024-04-18', null, 'Uva', 3, 40, 2, 10, '/images/uva.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (18, 'Avena integral en hojuelas', '2024-04-18', null, 'Avena', 2.5, 80, 3, 10, '/images/avena.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (15, 'Fresas rojas y jugosas', '2024-04-18', null, 'Fresa', 2.5, 55, 2, 10, '/images/fresa.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (27, 'Filete de salmón fresco', '2024-04-18', null, 'Salmón', 8, 20, 5, 10, '/images/salmon.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (23, 'Queso Cheddar en lonchas', '2024-04-18', null, 'Queso Cheddar', 3, 30, 4, 10, '/images/queso.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (26, 'Yogur griego natural sin grasa', '2024-04-18', null, 'Yogur Griego', 2, 35, 4, 10, '/images/yogurt2.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (19, 'Lentejas secas y nutritivas', '2024-04-18', null, 'Lentejas', 3.5, 60, 3, 10, '/images/lenteja.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (16, 'Mango maduro de temporada', '2024-04-18', null, 'Mango', 2, 45, 2, 10, '/images/mango.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (13, 'Naranjas frescas recién recolectadas', '2024-04-18', null, 'Naranja', 1.2, 60, 2, 10, '/images/naranja.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (17, 'Quinoa orgánica de alta calidad', '2024-04-18', null, 'Quinoa', 4, 25, 3, 10, '/images/quinua.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (20, 'Arroz integral de grano largo', '2024-04-18', null, 'Arroz Integral', 2, 70, 3, 10, '/images/arroz.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (25, 'Leche de almendras sin azúcar', '2024-04-18', null, 'Leche de Almendras', 2.5, 45, 4, 10, '/images/leche.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (21, 'Garbanzos secos de alta calidad', '2024-04-18', null, 'Garbanzos', 3, 50, 3, 10, '/images/garbanzo.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (29, 'Tofu orgánico extrafirme', '2024-04-18', null, 'Tofu', 2.5, 40, 5, 10, '/images/tofu.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (34, 'Cepillo de dientes suave', '2024-04-18', null, 'Cepillo de Dientes', 1.5, 70, 6, 10, '/images/cepillo.png', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (36, 'Rollo de papel aluminio resistente', '2024-04-18', null, 'Papel Aluminio', 2, 90, 6, 10, '/images/aluminio.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (32, 'Rollo de papel higiénico suave', '2024-04-18', null, 'Papel Higiénico', 1.2, 100, 6, 10, '/images/higienico.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (31, 'Pechuga de pavo sin hueso', '2024-04-18', null, 'Pechuga de Pavo', 6, 25, 5, 10, '/images/pechuga.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (30, 'Filete de carne de res magra', '2024-04-18', null, 'Carne de Res', 10, 15, 5, 10, '/images/carne.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (28, 'Docena de huevos orgánicos', '2024-04-18', null, 'Huevos', 3, 50, 5, 10, '/images/huevos.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (35, 'Shampoo revitalizante para cabello', '2024-04-18', null, 'Shampoo', 4, 60, 6, 10, '/images/shampoo.jpg', true);
INSERT INTO public.productos_stock (id, descripcion, fecha_publicacion, fecha_vencimiento, nombre, precio, cantidad_disponible, id_categoria, id_donante, imagen, confirmado) VALUES (33, 'Detergente líquido para ropa', '2024-04-18', null, 'Detergente', 3, 80, 6, 10, '/images/detergente.jpg', true);


