CREATE DATABASE library_db;

USE library_db;

CREATE TABLE books (
    name VARCHAR(255),
    author VARCHAR(255),
    code VARCHAR(50) PRIMARY KEY,
    total INT,
    subject VARCHAR(100)
);

CREATE TABLE issue (
    regno VARCHAR(50),
    name VARCHAR(255),
    code VARCHAR(50),
    issueDate DATE,
    FOREIGN KEY (code) REFERENCES books(code)
);
