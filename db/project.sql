CREATE TABLE project (
projectid INT(6) UNSIGNED AUTO_INCREMENT,
userid INT(6) NOT NULL,
projectname VARCHAR(30) NOT NULL,
PRIMARY KEY (projectid),
FOREIGN KEY (userid) REFERENCES user (id)

)project