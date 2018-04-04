create database adlister_db;

create user "adlister_admin"@"localhost" identified by "admin123";

grant all on adlister_db.* to "adlister_admin"@"localhost";

use adlister_db;
  
create table users
(
id int not null auto_increment,
username varchar(250),
password binary(32),
email varchar(320),
primary key(id)
);

create table ads
(
id int not null auto_increment,
user_id int not null,
title varchar(250),
description varchar(250),
primary key(id),
foreign key (user_id) references users(id)
);
