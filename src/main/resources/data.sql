DROP TABLE IF EXISTS tatouages;
DROP TABLE IF EXISTS photos;

CREATE TABLE tatouages (
                              tatouage_id INT AUTO_INCREMENT  PRIMARY KEY,
                              title VARCHAR(250) NOT NULL,
                              description VARCHAR(250) NOT NULL
);

INSERT INTO tatouages (title, description) VALUES
                 ('papillon', 'un tatouage de papillon tout joli'),
                 ('papillon2', 'un tatouage de papillon aussi joli'),
                 ('papillon3', 'un tatouage de papillon pas très joli'),
                 ('papillon4', 'un tatouage de papillon plutôt moche mais franchement ils ont fait ce qu ils ont pu');

CREATE TABLE photos (
                           photo_id INT AUTO_INCREMENT  PRIMARY KEY,
                           type VARCHAR(250) NOT NULL,
                           name VARCHAR(250) NOT NULL,
                           file_data BLOB
);

INSERT INTO photos(type, name, file_data) VALUES
    ('noir et blanc', 'photo1', null),
    ('noir et blanc', 'photo2', null),
    ('en couleur', 'photo3',  null);

/*
,
                           picByte VARCHAR(250) NOT NULL*/