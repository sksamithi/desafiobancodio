package com.thais;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    // Método adicional para verificar o saldo
    public double getSaldo() {
        return this.saldo;
    }
}
