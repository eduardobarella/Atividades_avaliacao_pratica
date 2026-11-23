package br.edu.exemplo;

// Eduardo Barella — RA 24088000-2

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void deveOrdenarArrayDesordenado() {
        BubbleSort bs = new BubbleSort(new int[]{5, 3, 1, 4, 2});
        bs.ordenar();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bs.getNumeros());
    }

    @Test
    void deveManterArrayJaOrdenado() {
        BubbleSort bs = new BubbleSort(new int[]{1, 2, 3, 4, 5});
        bs.ordenar();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bs.getNumeros());
    }

    @Test
    void deveOrdenarArrayComRepeticoes() {
        BubbleSort bs = new BubbleSort(new int[]{3, 1, 3, 2, 1});
        bs.ordenar();
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, bs.getNumeros());
    }
}
