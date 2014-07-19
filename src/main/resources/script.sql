create database ch;
use ch;

create table jogador(
id int primary key not null auto_increment,
nome varchar(255),
email varchar(255),
sexo int,
pontuacao int,
telefone varchar(255),
data_nascimento datetime,
torneio_id int
);

create table torneio(
id int primary key not null auto_increment,
data_torneio datetime,
local varchar(255),
formato int,
cla varchar(255)
);