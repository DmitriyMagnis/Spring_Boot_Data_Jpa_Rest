CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS demo_db.employees
( id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  phone_number VARCHAR(50) NOT NULL,
  position VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO demo_db.employees (first_name, last_name, phone_number, position) VALUES
('IVAN', 'BERC', '+3809822222222', 'saller');

SELECT * FROM employees