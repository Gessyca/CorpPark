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
cont_torneio int
);

create table torneio(
id int primary key not null auto_increment,
nome varchar(255),
data_torneio datetime,
local varchar(255),
formato int,
cla varchar(255),
qtd_jogadores int,
id_jogador_vencedor int
);