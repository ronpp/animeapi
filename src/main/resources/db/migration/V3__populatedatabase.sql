CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO usser (username, password) VALUES ('admin', crypt('passs', gen_salt('bf')));
INSERT INTO usser (username, password) VALUES ('ronny', crypt('pass', gen_salt('bf')));
INSERT INTO usser (username, password) VALUES ('andreu', crypt('pass', gen_salt('bf')));
INSERT INTO usser (username, password) VALUES ('raul', crypt('pass', gen_salt('bf')));
INSERT INTO usser (username, password) VALUES ('dani', crypt('pass', gen_salt('bf')));


-- ANIMES --
INSERT INTO anime(name, type, year_release, episodes ,imageurl, description) VALUES
    ('Bleach', 'TV', 2004, 366, 'https://cdn.myanimelist.net/images/anime/3/40451l.jpg',
    'Bleach follows the adventures of the hotheaded teenager Ichigo Kurosaki, who inherits his parents destiny after he obtains the powers of a Soul Reaper—a death personification similar to the Grim Reaper—from another Soul Reaper, Rukia Kuchiki. His new-found powers force him to take on the duties of defending humans from evil spirits and guiding departed souls to the afterlife, and set him on journeys to various ghostly realms of existence.'),
    ('Black Clover', 'TV', 2017, 170, 'https://cdn.myanimelist.net/images/anime/2/88336l.jpg',
     'The story follows Asta, a young boy born without any magic power. This is unknown to the world he lives in because seemingly everyone has some sort of magic power. With his fellow mages from the Black Bulls, Asta plans to become the next Wizard King.'),
    ('Dragon Ball', 'TV', 1986, 153, 'https://cdn.myanimelist.net/images/anime/1887/92364l.jpg',
     'son Goku is a young boy who lives in the woods all alone—that is, until a girl named Bulma runs into him in her search for a set of magical objects called the "Dragon Balls". Since the artifacts are said to grant one wish to whoever collects all seven, Bulma hopes to gather them and wish for a perfect boyfriend. Gokuu happens to be in possession of a dragon ball, but unfortunately for Bulma, he refuses to part ways with it, so she makes him a deal: he can tag along on her journey if he lets her borrow the dragon balls power. '),
    ('Dragon Ball Z', 'TV', 1989, 167, 'https://cdn.myanimelist.net/images/anime/1180/93671l.jpg',
     'Five years after winning the World Martial Arts tournament, Goku is now living a peaceful life with his wife and son. This changes, however, with the arrival of a mysterious enemy named Raditz who presents himself as Goku long-lost brother. He reveals that Goku is a warrior from the once powerful but now virtually extinct Saiyan race, whose homeworld was completely annihilated. When he was sent to Earth as a baby, Goku sole purpose was to conquer and destroy the planet; but after suffering amnesia from a head injury, his violent and savage nature changed, and instead was raised as a kind and well-mannered boy, now fighting to protect others.'),
    ('Jujutsu Kaisen', 'TV', 2020, 24, 'https://cdn.myanimelist.net/images/anime/1171/109222l.jpg',
     'In Jujutsu Kaisen, all living beings emanate an energy called Cursed Energy, which arises from negative emotions that naturally flow throughout the body. Normal people cannot control this flow in their bodies. As a result, they continually lose Cursed Energy, resulting in the birth of Curses,a race of spiritual beings whose primary desire is to bring harm to humanity. These curses are shown as gruesome monsters.'),
    ('Jujutsu Kaisen 0', 'Film', 2021, 0, 'https://cdn.myanimelist.net/images/anime/1121/119044l.jpg',
      'A young isolated high school student named Yuta Okkotsu suffers from a curse from his late girlfriend who follows him everywhere. Upon meeting a sorcerer named Satoru Gojo, Yuta decides to follow him to his school, in order to control the power of the curse.'),
    ('One Piece', 'TV', 1999, 1010, 'https://m.media-amazon.com/images/M/MV5BODcwNWE3OTMtMDc3MS00NDFjLWE1OTAtNDU3NjgxODMxY2UyXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_.jpg',
      'The series focuses on Monkey D. Luffy, a young man made of rubber, whom, inspired by his childhood idol, the powerful pirate Red Haired Shanks, sets off on a journey from the East Blue Sea to find the mythical treasure, the One Piece, and proclaim himself the King of the Pirates. In an effort to organize his own crew, the Straw Hat Pirates, Luffy rescues and befriends a pirate hunter and swordsman named Roronoa Zoro, and they head off in search of the titular treasure. They are joined in their journey by Nami, a money-obsessed thief and navigator; Usopp, a sniper and compulsive liar; and Sanji, a perverted but chivalrous chef. They acquire a ship, the Going Merry, and engage in confrontations with notorious pirates of the East Blue.'),
    ('Kimetsu no Yaiba(Demon Slayer)', 'TV', 2019, 26, 'https://cdn.myanimelist.net/images/anime/1286/99889l.jpg',
      'The story takes place in Taishō-era Japan, where a secret society, known as the Demon Slayer Corps, has been waging a secret war against demons for centuries. The demons are former humans who were turned into demons by Muzan injecting them with his own blood, and they feed on humans and possess supernatural abilities such as super strength, powers that demons can obtain called Blood Demon Art, and regeneration. Demons can only be killed if theyre decapitated with weapons crafted from an alloy known as Sun Steel, injected with poison extracted from wisteria flowers, or exposed to sunlight. The Demon Slayers, on the other hand, are entirely human; however, they employ special breathing techniques, known as Breathing Styles, which grant them superhuman strength and increased resistance.'),
    ('Kimetsu no Yaiba Mugen Ressha-hen(Demon Slayer: Infinity Train)', 'Film', 2020, 0, 'https://cdn.myanimelist.net/images/anime/1065/118763l.jpg',
     'Tanjiro Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boars head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, board the Infinity Train on a new mission with the Flame Pillar, Kyojuro Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it.'),
    ('Shingeki no Kyojin(Attack on Titan)', 'TV', 2013, 81, 'https://cdn.myanimelist.net/images/anime/10/47347l.jpg',
     'The story is set in a world where humanity lives inside cities surrounded by three enormous walls that protect them from the gigantic man-eating humanoids referred to as Titans,the story follows Eren Yeager, who vows to exterminate the Titans after a Titan brings about the destruction of his hometown and the death of his mother'),
    ('Hunter x Hunter', 'TV', 2011, 148, 'https://cdn.myanimelist.net/images/anime/1337/99013l.jpg',
      'The story is set in a world where Hunters exist to perform all manner of dangerous tasks like capturing criminals and bravely searching for lost treasures in uncharted territories. Twelve-year-old Gon Freecss is determined to become the best Hunter possible in hopes of finding his father, who was a Hunter himself and had long ago abandoned his young son. However, Gon soon realizes the path to achieving his goals is far more challenging than he could have ever imagined. Along the way to becoming an official Hunter, Gon befriends the lively doctor-in-training Leorio, vengeful Kurapika, and rebellious ex-assassin Killua. To attain their own goals and desires, together the four of them take the Hunter Exam, notorious for its low success rate and high probability of death.'),
    ('Hunter x Hunter: Phantom Rouge', 'Film', 2013, 0, 'https://cdn.myanimelist.net/images/anime/6/53073l.jpg',
      'After completing their work at Yorknew City, Leorio Paladiknight and Kurapika investigate the rumored sightings of a boy with scarlet red eyes, as they believe this person to be a member of the now non-existent Kurta Clan. Kurapika hopes to find another survivor of the clan besides himself, but instead ends up losing both his eyes after an attack from someone who seems to be his childhood friend. Leorio tends to Kurapikas wounds, and then sends for both Gon Freecss and Killua Zoldyck to help retrieve Kurapika eyeballs. However, their search brings them face-to-face with the infamous group of thieves known as Phantom Troupe—the same people who massacred the entire Kurta Clan five years ago for their scarlet eyes, which change color during moments of rage.'),
    ('Boku no hero academia(My Hero Academia)', 'TV', 2016, 113, 'https://cdn.myanimelist.net/images/anime/10/78745l.jpg',
      'The story of My Hero Academia is set in a world where currently most of the human population has gained the ability to develop superpowers called Quirks(Kosei), which occur in children within the age of four: it is estimated that around 80% of the world population has a Quirk. There are an endless number of Quirks, and it is extremely unlikely to find two people who have the exact same power, unless they are closely related. Among the Quirk-enhanced individuals, a few of them earn the title of Heroes, who cooperate with the authorities in rescue operations and apprehending criminals who abuse their powers, commonly known as Villains. In addition, Heroes who excel on their duties gain celebrity status and are recognized as Pro Heroes.');


-- AUTHORS --

INSERT INTO author(name, imageurl) VALUES
    ('Tite Kubo','https://www.babelio.com/users/AVT_Tite-Kubo_486.jpeg'),
    ('Yuki Tabata','https://www.babelio.com/users/AVT_Yuki-Tabata_1675.jpg'),
    ('Akira Toriyama','https://www.babelio.com/users/AVT_Akira-Toriyama_8493.jpeg'),
    ('Gege Akutami','https://pbs.twimg.com/media/EvFiWmrXUAM2PP7.jpg'),
    ('Eiichiro Oda','https://www.babelio.com/users/AVT_Eiichiro-Oda_1708.jpeg'),
    ('Koyoharu Gotouge','https://http2.mlstatic.com/D_NQ_NP_860867-MLA43808351691_102020-O.jpg'),
    ('Hajime Isayama','https://www.babelio.com/users/AVT_Hajime-Isayama_8367.jpeg'),
    ('Yoshihiro Togashi','https://www.babelio.com/users/AVT_Yoshihiro-Togashi_1667.jpeg'),
    ('Kohei Horikoshi','https://www.nautiljon.com/images/people/00/84/mini/horikoshi_kohei_31048.jpg?11531774179');


 -- GENRES --
INSERT INTO genre(label) VALUES
    ('Action'),
    ('Adventure'),
    ('Fantasy'),
    ('Supernatural'),
    ('Martial arts'),
    ('Dark Fantasy'),
    ('Comedy'),
    ('Science fantasy'),
    ('Superhero'),
    ('Post-apocalyptic');


INSERT INTO anime_author VALUES
    ((SELECT animeid FROM anime WHERE name='Bleach'),(SELECT authorid FROM author WHERE name='Tite Kubo')),
    ((SELECT animeid FROM anime WHERE name='Black Clover'),(SELECT authorid FROM author WHERE name='Yuki Tabata')),
    ((SELECT animeid FROM anime WHERE name='Dragon Ball'),(SELECT authorid FROM author WHERE name='Akira Toriyama')),
    ((SELECT animeid FROM anime WHERE name='Dragon Ball Z'),(SELECT authorid FROM author WHERE name='Akira Toriyama')),
    ((SELECT animeid FROM anime WHERE name='Jujutsu Kaisen'),(SELECT authorid FROM author WHERE name='Gege Akutami')),
    ((SELECT animeid FROM anime WHERE name='Jujutsu Kaisen 0'),(SELECT authorid FROM author WHERE name='Gege Akutami')),
    ((SELECT animeid FROM anime WHERE name='One Piece'),(SELECT authorid FROM author WHERE name='Eiichiro Oda')),
    ((SELECT animeid FROM anime WHERE name='Kimetsu no Yaiba(Demon Slayer)'),(SELECT authorid FROM author WHERE name='Koyoharu Gotouge')),
    ((SELECT animeid FROM anime WHERE name='Kimetsu no Yaiba Mugen Ressha-hen(Demon Slayer: Infinity Train)'),(SELECT authorid FROM author WHERE name='Koyoharu Gotouge')),
    ((SELECT animeid FROM anime WHERE name='Shingeki no Kyojin(Attack on Titan)'),(SELECT authorid FROM author WHERE name='Hajime Isayama')),
    ((SELECT animeid FROM anime WHERE name='Hunter x Hunter'),(SELECT authorid FROM author WHERE name='Yoshihiro Togashi')),
    ((SELECT animeid FROM anime WHERE name='Hunter x Hunter: Phantom Rouge'),(SELECT authorid FROM author WHERE name='Yoshihiro Togashi')),
    ((SELECT animeid FROM anime WHERE name='Boku no hero academia(My Hero Academia)'),(SELECT authorid FROM author WHERE name='Kohei Horikoshi'));


INSERT INTO anime_genre VALUES
    ((SELECT animeid FROM anime WHERE name='Bleach'),(SELECT genreid FROM genre WHERE label='Action')),
    ((SELECT animeid FROM anime WHERE name='Bleach'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Bleach'),(SELECT genreid FROM genre WHERE label='Supernatural')),
    ((SELECT animeid FROM anime WHERE name='Black Clover'),(SELECT genreid FROM genre WHERE label='Action')),
    ((SELECT animeid FROM anime WHERE name='Black Clover'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Black Clover'),(SELECT genreid FROM genre WHERE label='Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Dragon Ball'),(SELECT genreid FROM genre WHERE label='Martial arts')),
    ((SELECT animeid FROM anime WHERE name='Dragon Ball'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Dragon Ball'),(SELECT genreid FROM genre WHERE label='Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Dragon Ball Z'),(SELECT genreid FROM genre WHERE label='Martial arts')),
    ((SELECT animeid FROM anime WHERE name='Dragon Ball Z'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Dragon Ball Z'),(SELECT genreid FROM genre WHERE label='Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Jujutsu Kaisen'),(SELECT genreid FROM genre WHERE label='Supernatural')),
    ((SELECT animeid FROM anime WHERE name='Jujutsu Kaisen'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Jujutsu Kaisen'),(SELECT genreid FROM genre WHERE label='Dark Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Jujutsu Kaisen 0'),(SELECT genreid FROM genre WHERE label='Supernatural')),
    ((SELECT animeid FROM anime WHERE name='Jujutsu Kaisen 0'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Jujutsu Kaisen 0'),(SELECT genreid FROM genre WHERE label='Dark Fantasy')),
    ((SELECT animeid FROM anime WHERE name='One Piece'),(SELECT genreid FROM genre WHERE label='Action')),
    ((SELECT animeid FROM anime WHERE name='One Piece'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='One Piece'),(SELECT genreid FROM genre WHERE label='Fantasy')),
    ((SELECT animeid FROM anime WHERE name='One Piece'),(SELECT genreid FROM genre WHERE label='Comedy')),
    ((SELECT animeid FROM anime WHERE name='Kimetsu no Yaiba(Demon Slayer)'),(SELECT genreid FROM genre WHERE label='Action')),
    ((SELECT animeid FROM anime WHERE name='Kimetsu no Yaiba(Demon Slayer)'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Kimetsu no Yaiba(Demon Slayer)'),(SELECT genreid FROM genre WHERE label='Dark Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Kimetsu no Yaiba Mugen Ressha-hen(Demon Slayer: Infinity Train)'),(SELECT genreid FROM genre WHERE label='Action')),
    ((SELECT animeid FROM anime WHERE name='Kimetsu no Yaiba Mugen Ressha-hen(Demon Slayer: Infinity Train)'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Kimetsu no Yaiba Mugen Ressha-hen(Demon Slayer: Infinity Train)'),(SELECT genreid FROM genre WHERE label='Dark Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Shingeki no Kyojin(Attack on Titan)'),(SELECT genreid FROM genre WHERE label='Action')),
    ((SELECT animeid FROM anime WHERE name='Shingeki no Kyojin(Attack on Titan)'),(SELECT genreid FROM genre WHERE label='Post-apocalyptic')),
    ((SELECT animeid FROM anime WHERE name='Shingeki no Kyojin(Attack on Titan)'),(SELECT genreid FROM genre WHERE label='Dark Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Hunter x Hunter'),(SELECT genreid FROM genre WHERE label='Martial arts')),
    ((SELECT animeid FROM anime WHERE name='Hunter x Hunter'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Hunter x Hunter'),(SELECT genreid FROM genre WHERE label='Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Hunter x Hunter: Phantom Rouge'),(SELECT genreid FROM genre WHERE label='Martial arts')),
    ((SELECT animeid FROM anime WHERE name='Hunter x Hunter: Phantom Rouge'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Hunter x Hunter: Phantom Rouge'),(SELECT genreid FROM genre WHERE label='Fantasy')),
    ((SELECT animeid FROM anime WHERE name='Boku no hero academia(My Hero Academia)'),(SELECT genreid FROM genre WHERE label='Adventure')),
    ((SELECT animeid FROM anime WHERE name='Boku no hero academia(My Hero Academia)'),(SELECT genreid FROM genre WHERE label='Science fantasy')),
    ((SELECT animeid FROM anime WHERE name='Boku no hero academia(My Hero Academia)'),(SELECT genreid FROM genre WHERE label='Superhero'));



-- FAVORITES --
INSERT INTO favorite VALUES
   ((SELECT userid FROM usser WHERE username = 'ronny'),(SELECT animeid FROM anime WHERE name = 'Bleach')),
   ((SELECT userid FROM usser WHERE username = 'ronny'),(SELECT animeid FROM anime WHERE name = 'Jujutsu Kaisen')),
   ((SELECT userid FROM usser WHERE username = 'ronny'),(SELECT animeid FROM anime WHERE name = 'Hunter x Hunter')),
   ((SELECT userid FROM usser WHERE username = 'andreu'),(SELECT animeid FROM anime WHERE name = 'Kimetsu no Yaiba(Demon Slayer)')),
   ((SELECT userid FROM usser WHERE username = 'andreu'),(SELECT animeid FROM anime WHERE name = 'Shingeki no Kyojin(Attack on Titan)')),
   ((SELECT userid FROM usser WHERE username = 'raul'),(SELECT animeid FROM anime WHERE name = 'One Piece')),
   ((SELECT userid FROM usser WHERE username = 'raul'),(SELECT animeid FROM anime WHERE name = 'Boku no hero academia(My Hero Academia)')),
   ((SELECT userid FROM usser WHERE username = 'dani'),(SELECT animeid FROM anime WHERE name = 'One Piece')),
   ((SELECT userid FROM usser WHERE username = 'dani'),(SELECT animeid FROM anime WHERE name = 'Dragon Ball Z')),
   ((SELECT userid FROM usser WHERE username = 'dani'),(SELECT animeid FROM anime WHERE name = 'Kimetsu no Yaiba Mugen Ressha-hen(Demon Slayer: Infinity Train)'));


-- RATING --
INSERT INTO rating VALUES
   ((SELECT username FROM usser WHERE username = 'ronny'),(SELECT name FROM anime WHERE name = 'Bleach'), 7.9),
   ((SELECT username FROM usser WHERE username = 'ronny'),(SELECT name FROM anime WHERE name = 'Jujutsu Kaisen'), 9.5),
   ((SELECT username FROM usser WHERE username = 'ronny'),(SELECT name FROM anime WHERE name = 'Hunter x Hunter'), 8),
   ((SELECT username FROM usser WHERE username = 'andreu'),(SELECT name FROM anime WHERE name = 'Kimetsu no Yaiba(Demon Slayer)'), 7),
   ((SELECT username FROM usser WHERE username = 'andreu'),(SELECT name FROM anime WHERE name = 'Shingeki no Kyojin(Attack on Titan)'), 9.8),
   ((SELECT username FROM usser WHERE username = 'raul'),(SELECT name FROM anime WHERE name = 'One Piece'), 8.8),
   ((SELECT username FROM usser WHERE username = 'raul'),(SELECT name FROM anime WHERE name = 'Boku no hero academia(My Hero Academia)'), 8),
   ((SELECT username FROM usser WHERE username = 'dani'),(SELECT name FROM anime WHERE name = 'Dragon Ball Z'), 7),
   ((SELECT username FROM usser WHERE username = 'dani'),(SELECT name FROM anime WHERE name = 'One Piece'), 8.4),
   ((SELECT username FROM usser WHERE username = 'dani'),(SELECT name FROM anime WHERE name = 'Kimetsu no Yaiba Mugen Ressha-hen(Demon Slayer: Infinity Train)'), 10);