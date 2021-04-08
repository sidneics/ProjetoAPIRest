drop database if exists projetoSpringApi01;
create database projetoSpringApi01;
use projetoSpringApi01;
create table cliente(
idcliente integer auto_increment,
 nome varchar(150) not null,
 email varchar(100) not null unique,
 cpf varchar(15) not null unique,
 primary key(idcliente));

desc cliente;

select * from cliente;
