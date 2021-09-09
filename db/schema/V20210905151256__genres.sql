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

-- genre
insert into movieland.genre (id, name) values(1, 'драма');
insert into movieland.genre (id, name) values(2, 'криминал');
insert into movieland.genre (id, name) values(3, 'фэнтези');
insert into movieland.genre (id, name) values(4, 'детектив');
insert into movieland.genre (id, name) values(5, 'мелодрама');
insert into movieland.genre (id, name) values(6, 'биография');
insert into movieland.genre (id, name) values(7, 'комедия');
insert into movieland.genre (id, name) values(8, 'фантастика');
insert into movieland.genre (id, name) values(9, 'боевик');
insert into movieland.genre (id, name) values(10, 'триллер');
insert into movieland.genre (id, name) values(11, 'приключения');
insert into movieland.genre (id, name) values(12, 'аниме');
insert into movieland.genre (id, name) values(13, 'мультфильм');
insert into movieland.genre (id, name) values(14, 'семейный');
insert into movieland.genre (id, name) values(15, 'вестерн');