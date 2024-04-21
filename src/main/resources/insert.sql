INSERT INTO public.rol (id, nombre)
    VALUES (DEFAULT, 'Donante'),
            (DEFAULT, 'Beneficiario'),
            (DEFAULT, 'Voluntario');


INSERT INTO public.usuarios(id, nombre, "nombre de usuario", correo_electronico, password, activo, telefono, "fecha de nacimiento", id_rol)
VALUES
    (9, 'Admin', 'Admin', 'Admin@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 2),
    (10, 'Mateo josue Rodriguez Chico', 'Mateo', 'mateo204r@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 1);

INSERT INTO public.producto_carrito (id, id_producto_stock, id_cliente, "cantidad seleccionada", "fecha de agregado")
VALUES
    (5, 10, 1, 1, '2023-09-12 00:00:00'),
    (7, 113, 1, 1, '2023-09-12 00:00:00'),
    (8, 136, 1, 3, '2023-09-12 00:00:00'),
    (9, 114, 1, 3, '2023-09-12 00:00:00');

INSERT INTO public.categoria (id, nombre, descripcion)
VALUES
    (1, 'vegetales', 'Vegetales frescos y saludables'),
    (2, 'frutas', 'Frutas frescas y jugosas'),
    (3, 'granos', 'Productos a base de granos'),
    (4, 'productos lacteos', 'Productos lácteos variados'),
    (5, 'proteinas', 'Fuentes de proteína animal y vegetal'),
    (6, 'otros', 'Otros productos diversos');

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
VALUES (1, 'Huerfanos', 'Aldeas Infantiles', 'de tood tipo', 'SIN FINES DE LUCRO', 'AV.olmos');


INSERT INTO public.donacion (id,cantidad, fecha_adquisicion, hora_adquisicion, donante_id, organizacion_id, producto_id, voluntario_id)
VALUES
    (1,7, '2024-04-18', '09:30:00', 10, 1, 36, 9);
(25, '2024-04-18', '10:15:00', 33, 68, 14, 50),
(77, '2024-04-18', '11:00:00', 14, 7, 25, 11),
(46, '2024-04-18', '12:30:00', 50, 77, 7, 68),
(33, '2024-04-18', '14:45:00', 92, 11, 68, 25),
(14, '2024-04-18', '15:20:00', 46, 25, 33, 14),
(11, '2024-04-18', '16:10:00', 7, 14, 92, 77),
(68, '2024-04-18', '17:00:00', 68, 50, 46, 7),
(50, '2024-04-18', '18:20:00', 11, 33, 77, 46),
(92, '2024-04-18', '19:45:00', 77, 92, 50, 33);







