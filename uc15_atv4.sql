-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS lojajob;
USE lojajob;

-- Tabela de produtos
CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL
);

-- Tabela de clientes
CREATE TABLE IF NOT EXISTS clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(20)
);

-- Tabela de pedidos
CREATE TABLE IF NOT EXISTS pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    cliente_id INT,
    valor_total DECIMAL(10,2),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- Dados iniciais para testes

INSERT INTO produtos (nome, preco, quantidade) VALUES
('Notebook', 3500.00, 10),
('Mouse', 50.00, 100),
('Teclado', 120.00, 50);

INSERT INTO clientes (nome, cpf, telefone) VALUES
('Carlos Lima', '123.456.789-00', '11999999999'),
('João Santos', '987.654.321-00', '11888888888');

INSERT INTO pedidos (data, cliente_id, valor_total) VALUES
('2024-04-01', 1, 150.00),
('2024-04-01', 1, 200.00),
('2024-04-01', 2, 175.00),
('2024-04-04', 2, 286.00);