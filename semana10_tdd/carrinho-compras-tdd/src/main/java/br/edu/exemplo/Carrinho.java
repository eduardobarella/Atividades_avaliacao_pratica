package br.edu.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        if (produto.getPreco() < 0) throw new IllegalArgumentException("Preço não pode ser negativo");
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularTotal() {
        double total = produtos.stream().mapToDouble(Produto::getPreco).sum();
        if (total >= 500) {
            total *= 0.90;
        }
        return total;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
