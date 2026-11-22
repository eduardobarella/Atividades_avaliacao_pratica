# Semana 11 — Testes de Integração com Spring Boot

Testa o fluxo completo **Controller → Service → Repository → H2** sem mocks.

## Stack

- Java 17 · Maven · Spring Boot 3.2 · Spring Data JPA · H2 · JUnit 5 · MockMvc

## Como rodar

```bash
mvn test
```

## Exercício 1 — Service + Repository + H2

| CT | Cenário | Resultado esperado |
|---|---|---|
| CT01 | Cadastrar "Teclado" R$150 | ID não nulo, `repository.findById()` retorna nome e preço corretos |
| CT02 | Nome em branco | `IllegalArgumentException`, contagem de registros não aumenta |
| CT03 (desafio) | Cadastrar "Mouse" R$80, atualizar para R$95 | `repository.findById()` retorna R$95 |

**Por que `repository.findById()` é diferente de checar o objeto retornado?**
O `findById()` vai ao banco e retorna o estado persistido. O objeto retornado pelo service pode estar em cache JPA e nunca ter tocado o banco de fato.

**Por que `@Transactional` nos testes?**
O Spring faz rollback ao final de cada método, garantindo isolamento total entre os casos.

## Exercício 2 — HTTP com MockMvc

| CT | Cenário | Resultado esperado |
|---|---|---|
| CT04 | `POST /produtos {"nome":"Mouse","preco":80.0}` | HTTP 200, JSON com ID numérico, nome e preço |
| CT05 | POST → pegar ID → `GET /produtos/{id}` | HTTP 200, JSON bate com produto cadastrado |

**Por que MockMvc não precisa de servidor real?**
Despacha requisições direto no `DispatcherServlet`, sem abrir porta TCP — mais rápido, mas testa o mesmo código de produção.

**Diferença para teste unitário com mocks?**
Teste unitário substitui Service e Repository por mocks. Com MockMvc todos os beans são reais — detecta problemas de serialização e interação entre camadas.

## Evidências

```
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```
