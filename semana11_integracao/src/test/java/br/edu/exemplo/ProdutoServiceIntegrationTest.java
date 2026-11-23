package br.edu.exemplo;

// Eduardo Barella — RA 24088000-2

import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository repository;

    // CT01 — cadastro válido: produto recebe ID e é encontrado no repository
    @Test
    void deveCadastrarERecuperarProduto() {
        Produto salvo = service.cadastrar("Teclado", 150.0);

        assertNotNull(salvo.getId());
        Produto encontrado = repository.findById(salvo.getId()).orElse(null);
        assertNotNull(encontrado);
        assertEquals("Teclado", encontrado.getNome());
        assertEquals(150.0, encontrado.getPreco());
    }

    // CT02 — nome em branco: lança exceção e não aumenta a contagem
    @Test
    void naoDevePersistirProdutoComNomeEmBranco() {
        long contaAntes = repository.count();
        assertThrows(IllegalArgumentException.class, () -> service.cadastrar("", 80.0));
        assertEquals(contaAntes, repository.count());
    }

    // CT03 (desafio) — atualizar preço: repository retorna novo valor
    @Test
    void deveAtualizarPrecoPersistido() {
        Produto mouse = service.cadastrar("Mouse", 80.0);
        service.atualizarPreco(mouse.getId(), 95.0);
        Produto atualizado = repository.findById(mouse.getId()).orElseThrow();
        assertEquals(95.0, atualizado.getPreco());
    }
}
