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