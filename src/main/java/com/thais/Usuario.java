package com.thais;

public class Usuario {
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.setNome("Banco XYZ");

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Thais Vieira");
        cliente1.setScoreCredito(650);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Thainara Vieira");
        cliente2.setScoreCredito(580);

        Conta correnteCliente1 = new ContaCorrente(cliente1);
        Conta poupancaCliente1 = new ContaPoupanca(cliente1);

        Conta correnteCliente2 = new ContaCorrente(cliente2);
        Conta poupancaCliente2 = new ContaPoupanca(cliente2);

        banco.adicionarConta(correnteCliente1);
        banco.adicionarConta(correnteCliente2);

        correnteCliente1.depositar(100);
        correnteCliente1.transferir(100, poupancaCliente1);

        correnteCliente1.imprimirExtrato();
        poupancaCliente1.imprimirExtrato();

        correnteCliente2.depositar(500);
        correnteCliente2.transferir(300, poupancaCliente2);

        correnteCliente2.imprimirExtrato();
        poupancaCliente2.imprimirExtrato();

        banco.imprimirClientes();

        cliente1.analisarEmprestimo();
        cliente1.contratarSeguroVida((ContaPoupanca) poupancaCliente1);

        cliente2.analisarEmprestimo();
        cliente2.contratarSeguroVida((ContaPoupanca) poupancaCliente2);

        correnteCliente1.transferirPix(50, correnteCliente2);
        correnteCliente2.transferirTed(50, correnteCliente1);
    }
}
