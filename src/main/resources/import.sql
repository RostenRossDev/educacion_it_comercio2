-- ========================
-- GÉNEROS
-- ========================
INSERT INTO gender (id, name) VALUES (1, 'Acción');
INSERT INTO gender (id, name) VALUES (2, 'Aventura');
INSERT INTO gender (id, name) VALUES (3, 'Comedia');
INSERT INTO gender (id, name) VALUES (4, 'Drama');
INSERT INTO gender (id, name) VALUES (5, 'Ciencia Ficción');
INSERT INTO gender (id, name) VALUES (6, 'Fantasía');
INSERT INTO gender (id, name) VALUES (7, 'Terror');
INSERT INTO gender (id, name) VALUES (8, 'Animación');
INSERT INTO gender (id, name) VALUES (9, 'Romance');
INSERT INTO gender (id, name) VALUES (10, 'Suspenso');

-- ========================
-- PELÍCULAS / SERIES
-- ========================
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (1, 'Ecos del Futuro', '2021-05-12', 5);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (2, 'La Última Frontera', '2019-03-22', 4);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (3, 'Risas Eternas', '2020-11-10', 3);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (4, 'Sombras del Pasado', '2022-08-17', 5);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (5, 'Código Estelar', '2023-01-30', 4);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (6, 'Aventuras del Norte', '2018-07-09', 3);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (7, 'El Reino Perdido', '2020-09-15', 4);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (8, 'Noche de Sombras', '2021-10-31', 5);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (9, 'Amor en París', '2017-02-14', 4);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (10, 'La Risa del Dragón', '2019-06-02', 3);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (11, 'Sueños en Marte', '2024-04-11', 5);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (12, 'Sombras del Desierto', '2018-01-05', 4);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (13, 'El Bosque Encantado', '2016-12-20', 3);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (14, 'Código Oculto', '2023-09-01', 5);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (15, 'Planeta Azul', '2015-03-18', 4);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (16, 'Sombras de Acero', '2019-12-05', 4);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (17, 'Luz de Luna', '2022-06-21', 5);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (18, 'Universo 9', '2024-02-28', 5);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (19, 'La Isla del Tiempo', '2018-08-13', 3);
INSERT INTO pelicula_serie (id, titulo, fecha_creacion, calificacion) VALUES (20, 'El Refugio', '2021-04-03', 4);

-- ========================
-- RELACIÓN GÉNERO - PELÍCULA
-- ========================
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (1, 5);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (1, 10);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (2, 1);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (3, 3);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (4, 4);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (5, 5);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (6, 2);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (7, 6);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (8, 7);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (9, 9);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (10, 8);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (11, 5);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (12, 1);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (13, 6);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (14, 10);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (15, 2);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (16, 4);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (17, 9);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (18, 5);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (19, 2);
INSERT INTO genero_pelicula (fk_pelicula_serie_id, fk_genero_id) VALUES (20, 4);

-- ========================
-- PERSONAJES
-- ========================
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (1, 'Lara Vega', 28, 60, 'Una científica en busca de respuestas en un futuro distópico.', 1);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (2, 'Max Orion', 35, 80, 'Piloto que lidera la exploración del espacio exterior.', 2);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (3, 'Sofía Luna', 25, 55, 'Comediante que encuentra la risa en los momentos más difíciles.', 3);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (4, 'Ethan Crow', 40, 78, 'Detective atormentado por su pasado.', 4);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (5, 'Iris Nova', 30, 62, 'Hacker que descubre secretos intergalácticos.', 5);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (6, 'Tom Frost', 33, 70, 'Explorador enfrentando los climas más extremos.', 6);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (7, 'Ayla', 22, 50, 'Guerrera del reino mágico de Eldoria.', 7);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (8, 'Victor Kane', 38, 82, 'Cazador de criaturas nocturnas.', 8);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (9, 'Emma Belle', 27, 58, 'Fotógrafa que se enamora en París.', 9);
INSERT INTO "character" (id, name, age, weight, lore, fk_peliculaSerie_id) VALUES (10, 'Draco', 120, 500, 'El dragón más bromista del reino.', 10);