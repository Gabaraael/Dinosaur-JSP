CREATE TABLE usuario
(
	id bigserial NOT NULL,
	ativo boolean,
	cpf character varying(30),
	data_nascimento date, 
	email character varying(50),
	login character varying(50),
	nome character varying(255),
	password character varying(255),
	CONSTRAINT usuario_pk PRIMARY KEY (ID)
)