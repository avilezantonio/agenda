create database agenda;

use agenda;

create table contact(
id int auto_increment primary key, 
name varchar(100),
last_name varchar(100),
nick_name varchar(25));

create table address(
id int auto_increment primary key, 
contact_id int not null,
line varchar(100), 
city varchar(50), 
state varchar(50), 
zipcode int, 
type int,
FOREIGN KEY (contact_id) REFERENCES contact(id));

create table phone(
id int auto_increment primary key, 
contact_id int not null,
phone varchar(100), 
type int,
FOREIGN KEY (contact_id) REFERENCES contact(id));


create table email(
id int auto_increment primary key, 
contact_id int not null,
email varchar(100), 
type int,
FOREIGN KEY (contact_id) REFERENCES contact(id));

