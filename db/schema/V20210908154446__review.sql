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