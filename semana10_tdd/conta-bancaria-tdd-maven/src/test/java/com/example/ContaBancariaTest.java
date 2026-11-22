package com.example;

// Eduardo Barella — RA 24088000-2

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    void novaConta_saldoDeveSerOInformado() {
        ContaBancaria conta = new ContaBancaria(100.0);
        assertEquals(100.0, conta.getSaldo());
    }

    @Test
    void novaConta_saldoNegativo_deveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(-1.0));
    }

    @Test
    void depositar_deveAumentarSaldo() {
        ContaBancaria conta = new ContaBancaria(50.0);
        conta.depositar(30.0);
        assertEquals(80.0, conta.getSaldo());
    }

    @Test
    void depositar_valorZeroOuNegativo_deveLancarExcecao() {
        ContaBancaria conta = new ContaBancaria(50.0);
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(0));
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(-10.0));
    }

    @Test
    void sacar_deveReduzirSaldo() {
        ContaBancaria conta = new ContaBancaria(100.0);
        conta.sacar(40.0);
        assertEquals(60.0, conta.getSaldo());
    }

    @Test
    void sacar_saldoInsuficiente_deveLancarExcecao() {
        ContaBancaria conta = new ContaBancaria(30.0);
        assertThrows(IllegalStateException.class, () -> conta.sacar(50.0));
    }

    @Test
    void sacar_valorZeroOuNegativo_deveLancarExcecao() {
        ContaBancaria conta = new ContaBancaria(100.0);
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(0));
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(-5.0));
    }

    @Test
    void variosMovimentos_saldoDeveEstarCorreto() {
        ContaBancaria conta = new ContaBancaria(0.0);
        conta.depositar(200.0);
        conta.sacar(50.0);
        conta.depositar(10.0);
        assertEquals(160.0, conta.getSaldo());
    }
}
