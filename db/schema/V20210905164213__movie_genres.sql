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
