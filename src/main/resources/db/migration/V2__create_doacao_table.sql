CREATE TABLE doacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_doacao VARCHAR(20),
    descricao VARCHAR(200),
    data_doacao DATE,
    status_doacao VARCHAR(20),
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);