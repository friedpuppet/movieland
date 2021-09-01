-- -----------------------------------------------------
-- Schema movieland
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS movieland;

-- -----------------------------------------------------
-- Table movieland.movie
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movieland.movie (
  id SERIAL,
  name_russian VARCHAR(100) NOT NULL,
  name_native VARCHAR(100) NOT NULL,
  year_of_release DATE NOT NULL,
  description VARCHAR(1000) NOT NULL,
  rating REAL NOT NULL,
  price REAL NOT NULL,
  picture_path VARCHAR(500) NOT NULL,
  votes INTEGER NOT NULL DEFAULT 100,
  PRIMARY KEY(id));


-- -----------------------------------------------------
-- Table movieland.genre
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movieland.genre (
  id SERIAL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table movieland.movie_genre
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movieland.movie_genre (
  movie_id INTEGER NOT NULL,
  genre_id INTEGER NOT NULL,
  CONSTRAINT movie_id
    FOREIGN KEY (movie_id)
    REFERENCES movieland.movie (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT genre_id
    FOREIGN KEY (genre_id)
    REFERENCES movieland.genre (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE INDEX movie_genre_movie_id_idx ON movieland.movie_genre (movie_id ASC);
CREATE INDEX movie_genre_genre_id_idx ON movieland.movie_genre (genre_id ASC);


-- -----------------------------------------------------
-- Table movieland.user
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movieland.user (
  id SERIAL,
  nickname VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(100) NOT NULL,
  type VARCHAR(1) NOT NULL DEFAULT 'U',
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table movieland.review
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movieland.review (
  id SERIAL,
  movie_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  description VARCHAR(500) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT review_user_id
    FOREIGN KEY (user_id)
    REFERENCES movieland.user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT review_movie_id
    FOREIGN KEY (movie_id)
    REFERENCES movieland.movie (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE INDEX review_user_id_idx ON movieland.review (user_id ASC);
CREATE INDEX review_movie_id_idx ON movieland.review (movie_id ASC);


-- -----------------------------------------------------
-- Table movieland.country
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movieland.country (
  id SERIAL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table movieland.movie_country
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movieland.movie_country (
  movie_id INTEGER NOT NULL,
  country_id INTEGER NOT NULL,
  CONSTRAINT movie_country_country_id
    FOREIGN KEY (country_id)
    REFERENCES movieland.country (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT movie_country_movie_id
    FOREIGN KEY (movie_id)
    REFERENCES movieland.movie (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE INDEX movie_country_country_id_idx ON movieland.movie_country (country_id ASC);
CREATE INDEX movie_country_movie_id_idx ON movieland.movie_country (movie_id ASC);


CREATE TABLE IF NOT EXISTS movieland.rating (
  user_id INTEGER NOT NULL,
  movie_id INTEGER NOT NULL,
  rating REAL NOT NULL,
  CONSTRAINT rating_user_id
    FOREIGN KEY (user_id)
    REFERENCES movieland.user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT rating_movie_id
    FOREIGN KEY (movie_id)
    REFERENCES movieland.movie (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE INDEX rating_user_id_idx ON movieland.rating (user_id ASC);
CREATE INDEX rating_movie_id_idx ON movieland.rating (movie_id ASC);