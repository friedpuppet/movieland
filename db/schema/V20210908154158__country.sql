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

-- country
insert into movieland.country (id, name) values(1, 'США');
insert into movieland.country (id, name) values(2, 'Франция');
insert into movieland.country (id, name) values(3, 'Великобритания');
insert into movieland.country (id, name) values(4, 'Италия');
insert into movieland.country (id, name) values(5, 'Германия');
insert into movieland.country (id, name) values(6, 'Япония');
insert into movieland.country (id, name) values(7, 'Испания');
