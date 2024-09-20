# Sistema de Login Seguro

Este projeto implementa um sistema de autenticação de usuários utilizando técnicas de hashing e salt para proteger as senhas. O projeto está dividido em duas atividades principais: uma implementação básica utilizando SHA-256 e uma implementação avançada utilizando PBKDF2.

## Atividade 1: Implementação Básica de Autenticação com Hash e Salt

### Objetivo

Desenvolver um sistema de autenticação simples que utilize hash e salt para proteger senhas de usuários.

### Estrutura do Projeto

- **SenhaUtil:** Classe responsável por gerar salts aleatórios e hashes de senhas utilizando o algoritmo SHA-256. Esta classe inclui métodos para gerar um salt aleatório e para gerar o hash da senha combinando o salt com a senha original.
- **Autenticacao:** Classe responsável por gerenciar o registro e login dos usuários. Esta classe inclui a lógica para registrar um novo usuário, gerando e armazenando o hash e o salt, e a lógica de login para verificar se a senha fornecida corresponde ao hash armazenado.

### Como Rodar o Sistema

1. **Configuração do Projeto:**
   - Crie um projeto Java no Eclipse ou IDE de sua escolha.
   - Adicione as dependências necessárias para o uso de hashing, se estiver utilizando uma biblioteca específica.

2. **Execução:**
   - Execute a classe `Autenticacao`.
   - O sistema apresentará um menu com opções para registrar um novo usuário, fazer login ou sair.
   - Siga as instruções no console para registrar usuários e fazer login.

## Atividade 2: Implementação Avançada com Proteção de Senhas e Análise de Segurança

### Objetivo

Desenvolver uma aplicação que utiliza técnicas avançadas de hashing, como a aplicação de PBKDF2 (Password-Based Key Derivation Function 2) para proteger senhas.

### Estrutura do Projeto

- **SenhaUtilAvancada:** Classe responsável por gerar salts aleatórios e hashes de senhas utilizando o algoritmo PBKDF2. Esta classe inclui métodos para gerar um salt aleatório e para gerar o hash da senha usando PBKDF2, que inclui um salt e um número de iterações.
- **AutenticacaoAvancada:** Classe responsável por gerenciar o registro e login dos usuários. Esta classe inclui a lógica para registrar um novo usuário, gerando e armazenando o hash e o salt usando PBKDF2, e a lógica de login para verificar se a senha fornecida corresponde ao hash armazenado.

### Como Rodar o Sistema

1. **Configuração do Projeto:**
   - Crie um projeto Java no Eclipse ou IDE de sua escolha.
   - Adicione as dependências necessárias, se estiver usando bibliotecas específicas para PBKDF2.

2. **Execução:**
   - Execute a classe `AutenticacaoAvancada`.
   - O sistema apresentará um menu com opções para registrar um novo usuário, fazer login ou sair.
   - Siga as instruções no console para registrar usuários e fazer login.

## Validações de Entrada

Para garantir a segurança, o sistema valida o nome de usuário e a senha durante o registro:
- **Nome de Usuário:** Deve ter pelo menos 5 caracteres.
- **Senha:** Deve ter pelo menos 8 caracteres, incluindo letras e números.
