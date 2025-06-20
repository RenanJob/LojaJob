# Loja Job

## 📌 Status do Projeto
🚧 Projeto em desenvolvimento

## 💻 Tecnologias Utilizadas
- Java (Java SE)
- Swing (interface gráfica)
- JDBC (acesso a banco de dados)
- MySQL (banco de dados relacional)
- Git & GitHub (versionamento de código)

## 👨‍💻 Desenvolvedor
- Renan Job de Souza  
  Estudante de Análise e Desenvolvimento de Sistemas – UNICID

## 🎯 Objetivo do Sistema
O sistema **Loja Job** é um software desktop desenvolvido para auxiliar o gerenciamento de uma loja de pequeno porte. Ele permite o controle de clientes, produtos e pedidos, centralizando informações essenciais para o funcionamento do negócio.

## ✅ Funcionalidades
- Cadastro de Produtos (nome, preço, quantidade)
- Cadastro de Clientes (nome, CPF, telefone)
- Registro e listagem de Pedidos
- Listagem de pedidos com nome do cliente e valor total
- Exclusão de pedidos
- Tela de login simulada (usuário: `admin`, senha: `admin`)
- Interface gráfica intuitiva desenvolvida com Java Swing

## 🗃️ Estrutura do Projeto
- `view/` – Telas do sistema
- `model/` – Classes de dados (Produto, Cliente, Pedido)
- `dao/` – Acesso ao banco de dados (CRUD)
- `database/` – Conexão com MySQL
- `README.md` – Este arquivo com as descrições

## 📝 Observações
- O banco de dados `lojajob` deve estar criado e em execução no MySQL.
- É necessário configurar o usuário e senha da conexão no arquivo `Conexao.java`.

## 🛠️ Como executar o projeto
1. Clone o repositório com `git clone https://github.com/seu-usuario/lojajob.git`
2. Importe no NetBeans
3. Execute a classe `view.Main`
