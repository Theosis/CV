drop schema cv;
create schema cv;
use cv;

create table person (
id int not null auto_increment primary key, 
name varchar(50), 
email varchar(50)
-- , eduId int,
--   wrkId int,
--   sklId int
);

create table edu (
id int not null auto_increment primary key, 
persId int, 
ach varchar(140), 
org varchar(50), 
yr int 
);

create table wrk (
id int not null auto_increment primary key, 
persId int, 
role varchar(200), 
org varchar(40), 
era varchar(30) 
);

create table skl (
id int not null auto_increment primary key, 
persId int, 
skl varchar(40), 
lvl varchar (30)
);


create table dty (
id int not null auto_increment primary key, 
wrkId int, 
duty varchar(200) 
);
