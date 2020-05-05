CREATE DATABASE herosquad;
\c herosquad;
CREATE TABLE heroes (id SERIAL PRIMARY KEY, name VARCHAR, age INTEGER,power VARCHAR ,weakness VARCHAR, createdAt TIMESTAMP , squadId INTEGER);
CREATE TABLE squads (id SERIAL PRIMARY KEY, name VARCHAR, size INTEGER, cause VARCHAR );
CREATE DATABASE herosquad_test WITH TEMPLATE herosquad;