# Atividades — Avaliação Prática (Prova 02)

Disciplina: Projeto, Implementação e Teste de Software 2026

## Colaboradores

| Nome | RA | GitHub |
|---|---|---|
| Eduardo Barella | 24088000-2 | [@eduardobarella](https://github.com/eduardobarella) |

---

## Semana 10 — TDD (Test-Driven Development)

Quatro projetos Java com testes escritos antes da implementação (fase RED → GREEN → REFACTOR).

| Projeto | Testes |
|---|---|
| bubblesort-tdd | 6 testes |
| conta-bancaria-tdd-maven | 8 testes |
| estoque-tdd | 9 testes |
| carrinho-compras-tdd | 10 testes |

## Semana 11 — Testes de Integração com Spring Boot

Cinco casos de teste integrando Controller → Service → Repository → H2, sem mocks.

| CT | Descrição |
|---|---|
| CT01 | Cadastro válido salva com ID no repository |
| CT02 | Nome em branco lança exceção sem salvar |
| CT03 | Atualização de preço persiste no repository |
| CT04 | POST /produtos retorna HTTP 200 com JSON |
| CT05 | GET /produtos/{id} retorna produto cadastrado |

## Semana 14 — Teste de Usuário Final

Teste de usabilidade realizado com usuário real. Sem código.

---

## Como rodar

Requer Java 17+ e Maven.

```bash
# Semana 10 (TDD)
cd semana10_tdd
mvn test

# Semana 11 (Integração)
cd semana11_integracao
mvn test
```
