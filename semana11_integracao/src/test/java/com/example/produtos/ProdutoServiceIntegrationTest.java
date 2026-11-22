package com.example.produtos;

// Eduardo Barella — RA 24088000-2

import com.example.produtos.model.Produto;
import com.example.produtos.repository.ProdutoRepository;
import com.example.produtos.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoRepository repository;

    // CT01 — cadastro válido: produto recebe ID e é encontrado no repository
    @Test
    void CT01_cadastroValido_deveSalvarComId() {
        Produto salvo = service.cadastrar("Teclado", 150.0);

        assertNotNull(salvo.getId());
        Produto encontrado = repository.findById(salvo.getId()).orElse(null);
        assertNotNull(encontrado);
        assertEquals("Teclado", encontrado.getNome());
        assertEquals(150.0, encontrado.getPreco());
    }

    // CT02 — nome em branco: lança exceção e não aumenta contagem
    @Test
    void CT02_nomeEmBranco_deveLancarExcecaoSemSalvar() {
        long contaAntes = repository.count();
        assertThrows(IllegalArgumentException.class, () -> service.cadastrar("", 80.0));
        assertEquals(contaAntes, repository.count());
    }

    // CT03 (desafio) — atualizar preço: repository retorna novo valor
    @Test
    void CT03_atualizarPreco_repositoryDeveRetornarNovoValor() {
        Produto mouse = service.cadastrar("Mouse", 80.0);
        service.atualizar(mouse.getId(), 95.0);
        Produto atualizado = repository.findById(mouse.getId()).orElseThrow();
        assertEquals(95.0, atualizado.getPreco());
    }
}
