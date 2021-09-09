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

