CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO usser (username, password) VALUES ('user', crypt('pass', gen_salt('bf')));
INSERT INTO usser (username, password) VALUES ('pepe', crypt('pass', gen_salt('bf')));

INSERT INTO anime(name, description, type, year_release, imageurl) VALUES
    ('Anime I','This is the One Anime','TV',2016,'Anime1.jpg'),
    ('Anime II','The Two Anime is the next','TV',2018,'Anime2.jpg'),
    ('Anime III','The Trilogy','TV',2020,'Anime3.jpg'),
    ('Anime IV','Anime The Movie','Film',2021,'Anime4.jpg');

INSERT INTO author(name, imageurl) VALUES
    ('Author I','author1.jpg'),
    ('Author II','author2.jpg'),
    ('Author III','author3.jpg'),
    ('Author IV','author4.jpg'),
    ('Author V','author5.jpg');

INSERT INTO genre(label) VALUES
    ('Genre I'),
    ('Genre II'),
    ('Genre III');

INSERT INTO anime_author VALUES
    ((SELECT animeid FROM anime WHERE name='Anime I'),(SELECT authorid FROM author WHERE name='Author I')),
    ((SELECT animeid FROM anime WHERE name='Anime I'),(SELECT authorid FROM author WHERE name='Author II')),
    ((SELECT animeid FROM anime WHERE name='Anime II'),(SELECT authorid FROM author WHERE name='Author III')),
    ((SELECT animeid FROM anime WHERE name='Anime II'),(SELECT authorid FROM author WHERE name='Author IV')),
    ((SELECT animeid FROM anime WHERE name='Anime III'),(SELECT authorid FROM author WHERE name='Author IV')),
    ((SELECT animeid FROM anime WHERE name='Anime III'),(SELECT authorid FROM author WHERE name='Author V')),
    ((SELECT animeid FROM anime WHERE name='Anime IV'),(SELECT authorid FROM author WHERE name='Author I')),
    ((SELECT animeid FROM anime WHERE name='Anime IV'),(SELECT authorid FROM author WHERE name='Author IV'));

INSERT INTO anime_genre VALUES
    ((SELECT animeid FROM anime WHERE name='Anime I'),(SELECT genreid FROM genre WHERE label='Genre I')),
    ((SELECT animeid FROM anime WHERE name='Anime I'),(SELECT genreid FROM genre WHERE label='Genre II')),
    ((SELECT animeid FROM anime WHERE name='Anime II'),(SELECT genreid FROM genre WHERE label='Genre I')),
    ((SELECT animeid FROM anime WHERE name='Anime III'),(SELECT genreid FROM genre WHERE label='Genre I')),
    ((SELECT animeid FROM anime WHERE name='Anime III'),(SELECT genreid FROM genre WHERE label='Genre II')),
    ((SELECT animeid FROM anime WHERE name='Anime III'),(SELECT genreid FROM genre WHERE label='Genre III'));


INSERT INTO favorite VALUES
   ((SELECT userid FROM usser WHERE username = 'user'),(SELECT animeid FROM anime WHERE name = 'Anime I'));