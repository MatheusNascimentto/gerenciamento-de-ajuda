CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    tipo_usuario VARCHAR(20),
    telefone VARCHAR(20),
    rua VARCHAR(100),
    numero VARCHAR(10),
    bairro VARCHAR(100)
);