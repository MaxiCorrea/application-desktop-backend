SHOW TABLES;

CREATE TABLE IF NOT EXISTS App(
	id int UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	description VARCHAR(200),
	url VARCHAR(500),
	base64 LONGTEXT,
	PRIMARY KEY(id)
);

DESCRIBE App;

CREATE TABLE IF NOT EXISTS Feedback(
	id int UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(150),
	email VARCHAR(150),
	content LONGTEXT,
	PRIMARY KEY(id)
);

DESCRIBE Feedback;