DROP TABLE IF EXISTS phones;
DROP TABLE IF EXISTS subdivisions;
DROP TABLE IF EXISTS vessels;
DROP TABLE IF EXISTS fleets;

CREATE TABLE subdivisions
(
  id          INT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(50) NOT NULL,
  parent_id   INT DEFAULT NULL,
  ordering    INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (parent_id) REFERENCES subdivisions (id)
) AUTO_INCREMENT = 1000;

CREATE TABLE phones
(
  id          INT NOT NULL AUTO_INCREMENT,
  number      VARCHAR(15) NOT NULL,
  username    VARCHAR(50) NOT NULL,
  div_id      INT NOT NULL,
  boss        BOOLEAN DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (div_id) REFERENCES subdivisions (id) ON DELETE CASCADE
) AUTO_INCREMENT = 100000;

CREATE UNIQUE INDEX phones_unique_idx ON phones(number);

CREATE TABLE fleets
(
  id          INT NOT NULL AUTO_INCREMENT,
  name        VARCHAR(50) NOT NULL,
  deleted     BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (id)
) AUTO_INCREMENT = 1000;

CREATE TABLE vessels
(
id            INT NOT NULL AUTO_INCREMENT,
name          VARCHAR(50) NOT NULL,
phone_ukraine VARCHAR(50) DEFAULT NULL,
phone_abroad  VARCHAR(50) DEFAULT NULL,
phone_travel  VARCHAR(50) DEFAULT NULL,
email         VARCHAR(100) DEFAULT NULL,
fleet         INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (fleet) REFERENCES fleets (id) ON DELETE CASCADE
) AUTO_INCREMENT = 10000;

