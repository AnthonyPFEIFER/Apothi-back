DROP TABLE IF EXISTS tatouages;

CREATE TABLE tatouages (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              title VARCHAR(250) NOT NULL,
                              description VARCHAR(250) NOT NULL,
                              photo VARCHAR(250) NOT NULL
);

INSERT INTO tatouages (title, description, photo) VALUES
                 ('papillon', 'un tatouage de papillon tout joli', 'Souriez'),
                 ('papillon2', 'un tatouage de papillon aussi joli', 'Souriez aussi'),
                 ('papillon3', 'un tatouage de papillon pas très joli', 'Souriez peu'),
                 ('papillon4', 'un tatouage de papillon plutôt moche mais franchement ils ont fait ce qu ils ont pu', 'Souriez pas');