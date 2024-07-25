package com.thais;

public class Usuario {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Thais Vieira");

        Conta correnteCliente1 = new ContaCorrente(cliente1);
        Conta poupancaCliente1 = new ContaPoupanca(cliente1);

        correnteCliente1.depositar(100);
        correnteCliente1.transferir(100, poupancaCliente1);

        correnteCliente1.imprimirExtrato();
        poupancaCliente1.imprimirExtrato();

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Thainara Vieira");

        Conta correnteCliente2 = new ContaCorrente(cliente2);
        Conta poupancaCliente2 = new ContaPoupanca(cliente2);

        correnteCliente2.depositar(500);
        correnteCliente2.transferir(300, poupancaCliente2);

        correnteCliente2.imprimirExtrato();
        poupancaCliente2.imprimirExtrato();
    }
}
