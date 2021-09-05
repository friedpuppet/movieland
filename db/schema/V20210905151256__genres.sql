-- -----------------------------------------------------
-- Table movieland.genre
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS movieland.genre (
  id SERIAL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));