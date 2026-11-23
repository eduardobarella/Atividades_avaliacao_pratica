package br.edu.exemplo;

// Eduardo Barella — RA 24088000-2

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void novoProdutoDeveIniciarComEstoqueZero() {
        Produto p = new Produto("Caneta");
        assertEquals(0, p.getQuantidade());
    }

    @Test
    void adicionarEstoqueDeveAumentarQuantidade() {
        Produto p = new Produto("Caneta");
        p.adicionarEstoque(10);
        assertEquals(10, p.getQuantidade());
    }

    @Test
    void adicionarEstoqueVariasVezesDeveAcumular() {
        Produto p = new Produto("Caneta");
        p.adicionarEstoque(10);
        p.adicionarEstoque(5);
        assertEquals(15, p.getQuantidade());
    }

    @Test
    void retirarEstoqueDeveReduzirQuantidade() {
        Produto p = new Produto("Caneta");
        p.adicionarEstoque(10);
        p.retirarEstoque(3);
        assertEquals(7, p.getQuantidade());
    }

    @Test
    void retirarMaisDoQueDisponivelDeveManterEstoque() {
        Produto p = new Produto("Caneta");
        p.adicionarEstoque(10);
        p.retirarEstoque(15);
        assertEquals(10, p.getQuantidade());
    }

    @Test
    void adicionarQuantidadeNegativaDeveManterEstoque() {
        Produto p = new Produto("Caneta");
        p.adicionarEstoque(-10);
        assertEquals(0, p.getQuantidade());
    }
}
