CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO usser (username, password) VALUES ('user', crypt('pass', gen_salt('bf')));
INSERT INTO usser (username, password) VALUES ('pepe', crypt('pass', gen_salt('bf')));

INSERT INTO anime(name, description, type, year_release, imageurl) VALUES
    ('Anime 1','This is the One Anime','TV',2016,'Anime1.jpg'),
    ('Anime 2','The Two Anime is the next','TV',2018,'Anime2.jpg'),
    ('Anime 3','The Trilogy','TV',2020,'Anime3.jpg'),
    ('Anime 4','Anime The Movie','Film',2021,'Anime4.jpg'),
    ('Anime 5','Anime 5 description','Film',2020,'Anime5.jpg');

INSERT INTO author(name, imageurl) VALUES
    ('Author 1','author1.jpg'),
    ('Author 2','author2.jpg'),
    ('Author 3','author3.jpg'),
    ('Author 4','author4.jpg'),
    ('Author 5','author5.jpg');

INSERT INTO genre(label) VALUES
    ('Genre 1'),
    ('Genre 2'),
    ('Genre 3');

INSERT INTO anime_author VALUES
    ((SELECT animeid FROM anime WHERE name='Anime 1'),(SELECT authorid FROM author WHERE name='Author 1')),
    ((SELECT animeid FROM anime WHERE name='Anime 1'),(SELECT authorid FROM author WHERE name='Author 2')),
    ((SELECT animeid FROM anime WHERE name='Anime 2'),(SELECT authorid FROM author WHERE name='Author 3')),
    ((SELECT animeid FROM anime WHERE name='Anime 2'),(SELECT authorid FROM author WHERE name='Author 4')),
    ((SELECT animeid FROM anime WHERE name='Anime 3'),(SELECT authorid FROM author WHERE name='Author 4')),
    ((SELECT animeid FROM anime WHERE name='Anime 3'),(SELECT authorid FROM author WHERE name='Author 5')),
    ((SELECT animeid FROM anime WHERE name='Anime 4'),(SELECT authorid FROM author WHERE name='Author 1')),
    ((SELECT animeid FROM anime WHERE name='Anime 4'),(SELECT authorid FROM author WHERE name='Author 4')),
    ((SELECT animeid FROM anime WHERE name='Anime 5'),(SELECT authorid FROM author WHERE name='Author 2'));

INSERT INTO anime_genre VALUES
    ((SELECT animeid FROM anime WHERE name='Anime 1'),(SELECT genreid FROM genre WHERE label='Genre 1')),
    ((SELECT animeid FROM anime WHERE name='Anime 1'),(SELECT genreid FROM genre WHERE label='Genre 2')),
    ((SELECT animeid FROM anime WHERE name='Anime 2'),(SELECT genreid FROM genre WHERE label='Genre 1')),
    ((SELECT animeid FROM anime WHERE name='Anime 3'),(SELECT genreid FROM genre WHERE label='Genre 1')),
    ((SELECT animeid FROM anime WHERE name='Anime 3'),(SELECT genreid FROM genre WHERE label='Genre 2')),
    ((SELECT animeid FROM anime WHERE name='Anime 3'),(SELECT genreid FROM genre WHERE label='Genre 3')),
    ((SELECT animeid FROM anime WHERE name='Anime 5'),(SELECT genreid FROM genre WHERE label='Genre 3'));


INSERT INTO favorite VALUES
   ((SELECT userid FROM usser WHERE username = 'user'),(SELECT animeid FROM anime WHERE name = 'Anime 1')),
   ((SELECT userid FROM usser WHERE username = 'user'),(SELECT animeid FROM anime WHERE name = 'Anime 4')),
   ((SELECT userid FROM usser WHERE username = 'pepe'),(SELECT animeid FROM anime WHERE name = 'Anime 2')),
   ((SELECT userid FROM usser WHERE username = 'pepe'),(SELECT animeid FROM anime WHERE name = 'Anime 3')),
   ((SELECT userid FROM usser WHERE username = 'pepe'),(SELECT animeid FROM anime WHERE name = 'Anime 4'));

INSERT INTO rating VALUES
   ((SELECT username FROM usser WHERE username = 'pepe'),(SELECT name FROM anime WHERE name = 'Anime 1'), 4.5),
   ((SELECT username FROM usser WHERE username = 'pepe'),(SELECT name FROM anime WHERE name = 'Anime 4'), 3),
   ((SELECT username FROM usser WHERE username = 'user'),(SELECT name FROM anime WHERE name = 'Anime 2'), 4),
   ((SELECT username FROM usser WHERE username = 'user'),(SELECT name FROM anime WHERE name = 'Anime 3'), 5),
   ((SELECT username FROM usser WHERE username = 'user'),(SELECT name FROM anime WHERE name = 'Anime 4'), 4);