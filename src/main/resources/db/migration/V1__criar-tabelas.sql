CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL
);

CREATE TABLE topicos (
                         id BIGSERIAL PRIMARY KEY,
                         titulo VARCHAR(200) NOT NULL,
                         mensagem TEXT NOT NULL,
                         data_criacao TIMESTAMP NOT NULL DEFAULT NOW(),
                         status VARCHAR(50) NOT NULL DEFAULT 'ABERTO',
                         autor VARCHAR(100) NOT NULL,
                         curso VARCHAR(100) NOT NULL
);