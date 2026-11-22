package com.example;

public class BubbleSort {

    public int[] ordenar(int[] array) {
        if (array == null || array.length <= 1) return array;
        int[] resultado = array.clone();
        int n = resultado.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (resultado[j] > resultado[j + 1]) {
                    int temp = resultado[j];
                    resultado[j] = resultado[j + 1];
                    resultado[j + 1] = temp;
                }
            }
        }
        return resultado;
    }
}
