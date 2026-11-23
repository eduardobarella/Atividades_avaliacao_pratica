package br.edu.exemplo;

// Eduardo Barella — RA 24088000-2

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {

    @Test
    void carrinhoVazioDeveTerTotalZero() {
        Carrinho carrinho = new Carrinho();
        assertEquals(0.0, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void adicionarUmProdutoDeveCalcularTotalCorreto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Notebook", 2500.0));
        assertEquals(2250.0, carrinho.calcularTotal(), 0.001); // desconto 10%
    }

    @Test
    void adicionarVariosProdutosDevesomarPrecos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Caderno", 15.0));
        carrinho.adicionarProduto(new Produto("Caneta", 3.0));
        assertEquals(18.0, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void removerProdutoDeveAtualizarTotal() {
        Carrinho carrinho = new Carrinho();
        Produto p = new Produto("Borracha", 2.0);
        carrinho.adicionarProduto(p);
        carrinho.removerProduto(p);
        assertEquals(0.0, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void precoNegativoDeveLancarExcecao() {
        Carrinho carrinho = new Carrinho();
        assertThrows(IllegalArgumentException.class,
                () -> carrinho.adicionarProduto(new Produto("X", -10.0)));
    }

    @Test
    void totalAcimaDe500DeveAplicarDesconto10Porcento() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("TV", 500.0));
        assertEquals(450.0, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void totalAbaixoDe500NaoDeveAplicarDesconto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Livro", 499.99));
        assertEquals(499.99, carrinho.calcularTotal(), 0.001);
    }
}
