DROP TABLE IF EXISTS ENGLISH;
DROP TABLE IF EXISTS TEST;
DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS SCORE;

DROP TABLE ENGLISH;
DROP TABLE TEST;
DROP TABLE ACCOUNT;
DROP TABLE SCORE;



CREATE TABLE ENGLISH(
                        id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                        question VARCHAR2(20) NOT NULL,
                        answer1 VARCHAR2(20) NOT NULL,
                        answer2 VARCHAR2(20) NOT NULL,
                        answer3 VARCHAR2(20) NOT NULL,
                        correct VARCHAR2(20) NOT NULL,
                        type VARCHAR2(20) NOT NULL,
                        test VARCHAR2(20) NOT NULL,
                        PRIMARY KEY(id)
);



CREATE TABLE TEST(
                     TestID NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                     test VARCHAR2(20),
                     name VARCHAR2(20) NOT NULL,
                     score VARCHAR2(20) NOT NULL,
                     tipp VARCHAR2(20),
                     dates DATE NOT NULL,
                     PRIMARY KEY(TestID)
);

CREATE TABLE ACCOUNT(
                        AccountID NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                        name VARCHAR2(20) NOT NULL,
                        password VARCHAR2(20) NOT NULL,
                        email VARCHAR2(20) NOT NULL,
                        PRIMARY KEY(AccountID)
);
CREATE TABLE SCORE(
                      ScoreID NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                      score VARCHAR2(20) NOT NULL,
                      PRIMARY KEY(ScoreID)
);

