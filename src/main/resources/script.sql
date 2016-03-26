create database ch;
use ch;

create table colaborador(
id int primary key not null auto_increment,
matricula varchar(10) not null,
nome varchar(255) not null,
email varchar(255) not null,
celular varchar(255),
ramal int
);

create table veiculo(
id int primary key not null auto_increment,
tipo varchar(10) not null,
modelo varchar(255) not null,
marca varchar(255) not null,
placa varchar(255) not null,
cor varchar(10) not null,
id_colaborador int not null
);