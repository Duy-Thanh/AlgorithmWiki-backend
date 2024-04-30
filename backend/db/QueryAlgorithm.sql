CREATE DATABASE AlgorithmBackendDB;
USE AlgorithmBackendDB;

DROP DATABASE AlgorithmBackendDB;

CREATE TABLE UserAccount(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    userpass VARCHAR(255) NOT NULL,
    fullName NVARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    permission VARCHAR(32) NOT NULL
);

CREATE TABLE Algorithms(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    contents TEXT NOT NULL,
    date_added DATETIME NOT NULL,
    ID_user INT,
    FOREIGN KEY (ID_user) REFERENCES UserAccount(ID)
);

CREATE TABLE Rate(
	ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_algorithms INT NOT NULL,
    ID_user_who_rated INT NOT NULL,
    contents_rate TEXT NOT NULL,
    date_added DATETIME NOT NULL,
    FOREIGN KEY (ID_algorithms) REFERENCES Algorithms(ID),
    FOREIGN KEY (ID_user_who_rated) REFERENCES UserAccount(ID)
);

CREATE TABLE Category (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    category_name NVARCHAR(255) NOT NULL,
    category_description TEXT,
    ID_algorithms INT,
    FOREIGN KEY (ID_algorithms) REFERENCES Algorithms(ID)
);
