package com.example;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoCompras {

    private final Map<String, double[]> itens = new HashMap<>(); // nome -> [preco, quantidade]

    public void adicionarItem(String nome, double preco, int quantidade) {
        if (preco <= 0) throw new IllegalArgumentException("Preço deve ser positivo");
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser positiva");
        if (itens.containsKey(nome)) {
            itens.get(nome)[1] += quantidade;
        } else {
            itens.put(nome, new double[]{preco, quantidade});
        }
    }

    public void removerItem(String nome) {
        if (!itens.containsKey(nome)) throw new IllegalArgumentException("Item não encontrado: " + nome);
        itens.remove(nome);
    }

    public double getTotal() {
        return itens.values().stream().mapToDouble(v -> v[0] * v[1]).sum();
    }

    public int getQuantidade(String nome) {
        double[] item = itens.get(nome);
        return item == null ? 0 : (int) item[1];
    }

    public int totalDeItens() {
        return itens.size();
    }

    public void limpar() {
        itens.clear();
    }

    public double getTotalComDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) throw new IllegalArgumentException("Desconto inválido");
        return getTotal() * (1 - percentual / 100);
    }
}
