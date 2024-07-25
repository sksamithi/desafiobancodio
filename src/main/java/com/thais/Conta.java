package com.thais;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class Conta implements InterfaceConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    @Setter
    protected int agencia;
    @Setter
    protected int numero;
    @Setter
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, InterfaceConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void transferirPix(double valor, Conta contaDestino) {
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para a transferência via PIX.");
            return;
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println(String.format("Transferindo via PIX o valor de: %.2f", valor));
        System.out.println(String.format("De: %s (Agência: %d, Conta: %d)", this.cliente.getNome(), this.agencia, this.numero));
        System.out.println(String.format("Para: %s (Agência: %d, Conta: %d)", contaDestino.getCliente().getNome(), contaDestino.getAgencia(), contaDestino.getNumero()));
    }

    public void transferirTed(double valor, Conta contaDestino) {
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para a transferência via TED.");
            return;
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println(String.format("Transferindo via TED o valor de: %.2f", valor));
        System.out.println(String.format("De: %s (Agência: %d, Conta: %d)", this.cliente.getNome(), this.agencia, this.numero));
        System.out.println(String.format("Para: %s (Agência: %d, Conta: %d)", contaDestino.getCliente().getNome(), contaDestino.getAgencia(), contaDestino.getNumero()));
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
