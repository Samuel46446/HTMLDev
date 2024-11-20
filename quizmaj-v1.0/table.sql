--Création de table sql pour dynamiser le site web

CREATE DATABASE sturpin_webProject;

CREATE TABLE QUESTION(
    ID Serial PRIMARY KEY,
    NIV INTEGER,
    LANG TEXT,
    QuestionTitre TEXT,
    QuestionCode TEXT,
    QuestionRepVrai TEXT,
    QuestionRepFaux1 TEXT,
    QuestionRepFaux2 TEXT,
    QuestionRepFaux3 TEXT
);

INSERT INTO QUESTION
(NIV, LANG, QuestionTitre, QuestionCode, QuestionRepVrai, QuestionRepFaux1, QuestionRepFaux2, QuestionRepFaux3)
 VALUES(1, 'cpp', 'Quel est le type de la fonction main en C++ ?',
    '            ??? main()
            {

            }
', 'int', 'char', 'float', 'boolean');