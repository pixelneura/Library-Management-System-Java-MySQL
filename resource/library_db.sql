CREATE DATABASE library_db;
USE library_db;

CREATE TABLE books (
  name VARCHAR(50) NOT NULL,
  author VARCHAR(50) NOT NULL,
  code VARCHAR(50) PRIMARY KEY,
  total INT NOT NULL,
  subject VARCHAR(50) NOT NULL
);

CREATE TABLE issue (
  regno VARCHAR(50) PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  code VARCHAR(50) NOT NULL,
  issue_date VARCHAR(50) NOT NULL,
  FOREIGN KEY (code) REFERENCES books(code)
);
