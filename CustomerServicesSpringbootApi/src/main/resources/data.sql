DROP TABLE IF EXISTS billionaires;

CREATE TABLE Customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  lastname VARCHAR(250) NOT NULL,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  datecreated TIMESTAMP NULL,
  status VARCHAR(250) NOT NULL
);

INSERT INTO Customer (name, lastname,username, password,email,address,datecreated,status) VALUES
  ('Aliko', 'Dangote','hackblack', 'skjflkass','alikico@mail.com','villamella','2020-01-01 10:10:10','ENABLED'),
  ('Bill', 'Gates','lover', 'khjghjgr','bill@email.com','villamella','2020-01-01 10:10:10','DISABLED'),
  ('Folrunsho', 'Alakija','goodness', 'Billionaire','folmo@mail.com','villamella','2020-01-01 10:10:10','ENABLED');