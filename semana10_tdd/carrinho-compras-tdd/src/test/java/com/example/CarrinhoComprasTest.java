package com.example;

// Eduardo Barella — RA 24088000-2

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarrinhoComprasTest {

    private CarrinhoCompras carrinho;

    @BeforeEach
    void setUp() {
        carrinho = new CarrinhoCompras();
    }

    @Test
    void carrinhoVazio_totalDeveSerZero() {
        assertEquals(0.0, carrinho.getTotal());
    }

    @Test
    void carrinhoVazio_totalDeItensDeveSerZero() {
        assertEquals(0, carrinho.totalDeItens());
    }

    @Test
    void adicionarItem_deveAparecerNoCarrinho() {
        carrinho.adicionarItem("Notebook", 2500.0, 1);
        assertEquals(1, carrinho.totalDeItens());
        assertEquals(1, carrinho.getQuantidade("Notebook"));
    }

    @Test
    void adicionarMesmoItem_deveAcumularQuantidade() {
        carrinho.adicionarItem("Caneta", 2.0, 3);
        carrinho.adicionarItem("Caneta", 2.0, 2);
        assertEquals(5, carrinho.getQuantidade("Caneta"));
        assertEquals(1, carrinho.totalDeItens());
    }

    @Test
    void total_deveCalcularCorretamente() {
        carrinho.adicionarItem("Caderno", 15.0, 2);
        carrinho.adicionarItem("Caneta", 3.0, 4);
        assertEquals(42.0, carrinho.getTotal());
    }

    @Test
    void removerItem_deveRetirarDoCarrinho() {
        carrinho.adicionarItem("Borracha", 1.5, 1);
        carrinho.removerItem("Borracha");
        assertEquals(0, carrinho.totalDeItens());
    }

    @Test
    void removerItemInexistente_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> carrinho.removerItem("Inexistente"));
    }

    @Test
    void adicionarItem_precoNegativo_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> carrinho.adicionarItem("X", -1.0, 1));
    }

    @Test
    void adicionarItem_quantidadeNegativa_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> carrinho.adicionarItem("X", 10.0, -1));
    }

    @Test
    void limpar_deveEsvaziarCarrinho() {
        carrinho.adicionarItem("Lápis", 1.0, 5);
        carrinho.limpar();
        assertEquals(0, carrinho.totalDeItens());
        assertEquals(0.0, carrinho.getTotal());
    }
}
