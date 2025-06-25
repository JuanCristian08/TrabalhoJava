# Cadastro e Consulta de Produtos

Este projeto é um sistema simples de cadastro e consulta de produtos desenvolvido em Java. Utiliza listas paralelas (`ArrayList`) para armazenar nomes e preços dos produtos, com diversas funcionalidades, como cálculo de estatísticas, remoção e atualização de dados.

## Integrantes do Grupo

- **Gustavo Spengler** – Desenvolveu cálculos (média, produto mais caro)
- **Juan Borba** – Implementou cadastro e listagem de produtos e menu.
- **Aline Mess** –  Implementou funcionalidades extras (remoção, atualização)

## Principais Dificuldades

- Tratamento de erros na entrada de dados (números inválidos)
- Implementar a verificação de produtos duplicados
- Codar em equipe

## Estratégia de Testes

- Testes individuais para cada funcionalidade
- Verificação de cenários com listas vazias
- Entrada de dados inválidos (ex.: letras no lugar de números)
- Produtos com nomes duplicados
- Verificação da sincronização entre as listas após remoções

## Funcionamento

O programa utiliza duas listas paralelas (`ArrayList<String>` e `ArrayList<Double>`) para armazenar nomes e preços dos produtos. Cada índice representa um produto completo (nome e preço correspondentes). Um menu interativo permite navegar entre as funcionalidades, que incluem:

- Cadastro de produtos
- Listagem
- Estatísticas (média, produto mais caro, etc.)
- Funcionalidades extras (remoção, atualização)

O sistema possui validações e tratamento de erros para garantir a integridade dos dados inseridos.

## Funcionalidades

### Funcionalidades Obrigatórias

- [x] Cadastrar produto (nome e preço)
- [x] Listar todos os produtos
- [x] Mostrar produto mais caro
- [x] Calcular média de preços
- [x] Listar produtos acima da média
- [x] Menu interativo com `switch`
- [x] Uso de `ArrayList` com listas paralelas

### Funcionalidades Extras (Pontos Adicionais)

- [x] Impedir cadastro de produtos duplicados
- [x] Remover produto pelo nome
- [x] Atualizar preço de um produto
- [x] Calcular valor total do estoque
- [x] Tratamento de erros e validações
- [x] Interface de saída com formatação aprimorada

