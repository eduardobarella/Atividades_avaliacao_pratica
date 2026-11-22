package com.example;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    private final Map<String, Integer> itens = new HashMap<>();

    public void adicionar(String produto, int quantidade) {
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser positiva");
        itens.merge(produto, quantidade, Integer::sum);
    }

    public void remover(String produto, int quantidade) {
        if (!itens.containsKey(produto)) throw new IllegalArgumentException("Produto não encontrado: " + produto);
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser positiva");
        int atual = itens.get(produto);
        if (quantidade > atual) throw new IllegalStateException("Estoque insuficiente para: " + produto);
        int novo = atual - quantidade;
        if (novo == 0) itens.remove(produto);
        else itens.put(produto, novo);
    }

    public int getQuantidade(String produto) {
        return itens.getOrDefault(produto, 0);
    }

    public boolean contemProduto(String produto) {
        return itens.containsKey(produto);
    }

    public int totalDeProdutos() {
        return itens.size();
    }

    public double valorTotal(Map<String, Double> precos) {
        return itens.entrySet().stream()
                .mapToDouble(e -> e.getValue() * precos.getOrDefault(e.getKey(), 0.0))
                .sum();
    }
}
