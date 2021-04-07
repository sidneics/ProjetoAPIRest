drop database if exists springApiDomingo01;
create database springApiDomingo01;
use springApiDomingo01;
create table cliente(
idcliente integer auto_increment,
 nome varchar(150) not null,
 email varchar(100) not null unique,
 cpf varchar(15) not null unique,
 primary key(idcliente));

desc cliente;

select * from cliente;
