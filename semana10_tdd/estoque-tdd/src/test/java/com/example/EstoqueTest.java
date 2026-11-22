package com.example;

// Eduardo Barella — RA 24088000-2

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EstoqueTest {

    private Estoque estoque;

    @BeforeEach
    void setUp() {
        estoque = new Estoque();
    }

    @Test
    void estoqueNovo_devEstarVazio() {
        assertEquals(0, estoque.totalDeProdutos());
    }

    @Test
    void adicionar_deveCriarEntrada() {
        estoque.adicionar("Arroz", 10);
        assertTrue(estoque.contemProduto("Arroz"));
        assertEquals(10, estoque.getQuantidade("Arroz"));
    }

    @Test
    void adicionar_mesmoProduto_deveAcumular() {
        estoque.adicionar("Feijão", 5);
        estoque.adicionar("Feijão", 3);
        assertEquals(8, estoque.getQuantidade("Feijão"));
    }

    @Test
    void adicionar_quantidadeZeroOuNegativa_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> estoque.adicionar("Sal", 0));
        assertThrows(IllegalArgumentException.class, () -> estoque.adicionar("Sal", -2));
    }

    @Test
    void remover_deveReduzirQuantidade() {
        estoque.adicionar("Macarrão", 10);
        estoque.remover("Macarrão", 4);
        assertEquals(6, estoque.getQuantidade("Macarrão"));
    }

    @Test
    void remover_tudoDeUmProduto_deveRemoverEntrada() {
        estoque.adicionar("Óleo", 2);
        estoque.remover("Óleo", 2);
        assertFalse(estoque.contemProduto("Óleo"));
    }

    @Test
    void remover_maisDoQueExiste_deveLancarExcecao() {
        estoque.adicionar("Açúcar", 3);
        assertThrows(IllegalStateException.class, () -> estoque.remover("Açúcar", 5));
    }

    @Test
    void remover_produtoInexistente_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> estoque.remover("Inexistente", 1));
    }

    @Test
    void valorTotal_deveCalcularCorretamente() {
        estoque.adicionar("Arroz", 2);
        estoque.adicionar("Feijão", 3);
        Map<String, Double> precos = Map.of("Arroz", 10.0, "Feijão", 8.0);
        assertEquals(44.0, estoque.valorTotal(precos));
    }
}
