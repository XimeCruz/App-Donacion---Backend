INSERT INTO public.rol (id, nombre)
    VALUES (DEFAULT, 'Donante'),
            (DEFAULT, 'Beneficiario'),
            (DEFAULT, 'Voluntario');


INSERT INTO public.usuarios(id, nombre, "nombre de usuario", correo_electronico, password, activo, telefono, "fecha de nacimiento", id_rol)
VALUES
    (9, 'Admin', 'Admin', 'Admin@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 2),
    (10, 'Mateo josue Rodriguez Chico', 'Mateo', 'mateo204r@gmail.com', '$2a$10$zfHAlRP5PqQLFewPFxDyNO1bTGgOE98OAIPEkoLK4/6HJgDytRRl6', 1, '3148918702', '2004-03-04', 1);

INSERT INTO public.producto_carrito (id, id_producto_stock, id_beneficiario, "cantidad seleccionada", "fecha de agregado")
VALUES
    (5, 10, 10, 1, '2023-09-12 00:00:00'),
    (7, 113, 10, 1, '2023-09-12 00:00:00'),
    (8, 136, 10, 3, '2023-09-12 00:00:00'),
    (9, 114, 10, 3, '2023-09-12 00:00:00');

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

