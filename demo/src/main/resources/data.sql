DROP TABLE IF EXISTS demo;
 
CREATE TABLE demo (

 

  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL
  
);
 
INSERT INTO demo (name, address) VALUES
  ('pepe', 'calle'),
  ('Marcos', 'Vector'),
  ('Daniel', 'Seres');