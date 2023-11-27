create database biblioteca;

use biblioteca;

CREATE TABLE livro(
	id_livro INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(300),
    valor DECIMAL,
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categoria(
	id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(300),
    data_Criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cliente(
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    CPF VARCHAR(15),
    RG VARCHAR(15),
    idade INT,
    data_criacao datetime DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE funcionario(
	id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    CPF VARCHAR(15),
    RG VARCHAR(15),
    idade INT,
    data_criacao datetime DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE reserva(
	id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT,
    id_cliente INT,
    id_livro INT,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_livro) REFERENCES livro(id_livro),
    datainicio DATETIME,
    datafim DATETIME,
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

alter table livro add column id_categoria INT;
alter table livro add constraint foreign key (id_categoria) REFERENCES categoria(id_categoria);

CREATE TABLE login(
	id_login int UNIQUE primary key,
	login varchar(50) not null unique,
    senha varchar(200) not null,
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

alter table funcionario add column id_login int;
alter table funcionario add constraint foreign key (id_login) references login(id_login);

alter table cliente add column id_login int;
alter table cliente add constraint foreign key (id_login) references login(id_login);


SELECT * FROM funcionario;
select * from cliente;
select * from login;




