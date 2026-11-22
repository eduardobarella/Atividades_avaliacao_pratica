package com.example;

// Eduardo Barella — RA 24088000-2

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private final BubbleSort sorter = new BubbleSort();

    @Test
    void arrayVazio_deveRetornarArrayVazio() {
        assertArrayEquals(new int[]{}, sorter.ordenar(new int[]{}));
    }

    @Test
    void umElemento_deveRetornarMesmoArray() {
        assertArrayEquals(new int[]{5}, sorter.ordenar(new int[]{5}));
    }

    @Test
    void arrayJaOrdenado_devePermanecer() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, sorter.ordenar(new int[]{1, 2, 3, 4}));
    }

    @Test
    void arrayInvertido_deveOrdenar() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, sorter.ordenar(new int[]{4, 3, 2, 1}));
    }

    @Test
    void arrayComDuplicatas_deveOrdenar() {
        assertArrayEquals(new int[]{1, 2, 2, 3}, sorter.ordenar(new int[]{3, 1, 2, 2}));
    }

    @Test
    void arrayComNegativos_deveOrdenar() {
        assertArrayEquals(new int[]{-3, -1, 0, 2}, sorter.ordenar(new int[]{0, -1, 2, -3}));
    }
}
