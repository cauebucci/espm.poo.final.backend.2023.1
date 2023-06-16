CREATE DATABASE IF NOT EXISTS restaurante;
USE restaurante;

CREATE TABLE IF NOT EXISTS cliente
(
    cpf varchar(14),
    nome varchar(200) NOT NULL,
    numero varchar(19) NOT NULL,
    CONSTRAINT cpf_pkey PRIMARY KEY (cpf)
);
