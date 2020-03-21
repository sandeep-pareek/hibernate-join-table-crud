CREATE TABLE IF NOT EXISTS student (
  student_id int(100) NOT NULL AUTO_INCREMENT,
  first_name varchar(50) DEFAULT NULL,
  last_name varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  phone varchar(50) DEFAULT NULL,
  PRIMARY KEY (student_id)
);