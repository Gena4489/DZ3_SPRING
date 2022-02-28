/* =====H2 =========*/


CREATE TABLE  if not exists  premieres (
     id int(11) NOT NULL AUTO_INCREMENT,
     name varchar(64) not NULL,
     description varchar(255) not NULL,
     ageCategory int(8) not NULL,
     numberOfSeats int(8) not NULL,
     PRIMARY KEY (id)
);

