# ☕ Programação Orientada a Objetos — PUCPR

Resoluções dos exercícios da disciplina de Programação Orientada a Objetos,
do curso de Tecnologia em Jogos Digitais da PUCPR. Cada aula contém os
enunciados originais (PDF) e as respectivas implementações em Java.

## 📖 Sobre o Projeto

Este repositório documenta minha evolução em POO com Java, partindo dos
fundamentos (encapsulamento, construtores, `this`) até a construção de
sistemas com múltiplas classes interagindo entre si (validação por
exceções, composição, sobrecarga de métodos e organização em pacotes).

## 📋 Conteúdo

| Aula | Tema | Exercícios |
| --- | --- | --- |
| **Aula 01** | Classes Estáticas | Calculadora com métodos estáticos |
| **Aula 02** | Fundamentos de POO | Produto/ItemPedido, Motocicleta, Estudante/Professor, Carro (array de objetos, direção aleatória, cálculo de velocidade/tempo) |
| **Aula 03** | Interação entre Objetos | Sistema de Compras integrado com ContaBancaria (sobrecarga de método), Livro/Leitor (empréstimo de biblioteca), Combate RPG |
| **Aula 04** | Exercícios de Fixação | Automação Residencial, Reserva de Voos, Simulador de Corrida, Simulação Agrícola, Sistema Bancário, Sistema Pet Shop, Sistema RPG com Itens |

## 🧩 Conceitos Trabalhados

- **Encapsulamento**: atributos sempre `private`, acesso via getters/setters
  (convenção `getXxx()`), com métodos de negócio em `snake_case` por escolha
  própria
- **Construtores**: inicialização e validação de valores de entrada
- **Exceções (`try/catch`, `throw`)**: usadas para validar condições
  realmente inválidas (saldo negativo, estoque insuficiente, voo lotado),
  não eventos esperados do domínio (ex: dano fatal em combate não é erro)
- **Sobrecarga de método (overloading)**: mesmo nome, parâmetros
  diferentes, resolvido em tempo de compilação
- **Composição**: uma classe guardando referência de outra e se comunicando
  por métodos (`Interruptor` → `Lampada`, `Pedido` → `Produto`)
- **Pacotes e visibilidade**: um `public class` por arquivo; classes sem
  `public` só visíveis dentro do mesmo pacote
- **Arrays de objetos**: `new Tipo[n]` cria posições nulas; cada posição
  precisa de `new Tipo()` manual
- **Campos vs. variáveis locais**: inicializadores de campo rodam uma única
  vez, na criação do objeto

## 📚 O Que Aprendi

Comecei com dificuldade em `this`, formatação de `printf` e a lógica básica
de encapsulamento. Ao longo das aulas, passei a antecipar problemas de ordem
de execução, questionar minhas próprias decisões de design (quando usar
exceção, responsabilidade única de métodos) e manter consistência de estilo
no projeto inteiro sem precisar ser lembrado a cada exercício. Nos últimos
exercícios (Reserva de Voos, Simulação Agrícola, RPG com Itens), já
conseguia rastrear a stack trace e identificar a linha problemática antes de
pedir ajuda.

Padrões de bug que se repetiram — e que aprendi a reconhecer:
- Ordem de operações: usar/exibir um valor **depois** de já tê-lo apagado ou
  sobrescrito
- Reaproveitar um método para dois propósitos diferentes sem ajustar a
  lógica pro novo contexto
- Confundir "retornar" com "exibir" (getter deve retornar; quem exibe
  decide isso por fora)

## 🛠️ Tecnologias

- Java

## 👤 Autor

Gabriel Apolinário — [LinkedIn](https://linkedin.com/in/gabapolinario) · [itch.io](https://gabriel-apolinario.itch.io)
