create database ch;
use ch;

create table jogador(
id int primary key not null auto_increment,
nome varchar(255),
email varchar(255),
sexo int,
pontuacao int,
telefone varchar(255),
data_nascimento datetime
);

create table torneio(
id int primary key not null auto_increment,
data_torneio datetime,
local varchar(255),
formato int,
clan varchar(255),
vencedor_1_id int,
vencedor_2_id int,
vencedor_3_id int
);

create table jogador_torneio (jogador_id int, torneio_id int);

create table usuario (
id int primary key not null auto_increment,
nome varchar(255),
senha varchar(255)
);