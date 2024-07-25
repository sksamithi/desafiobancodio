package com.thais;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private String nome;
    private int scoreCredito;

    public void analisarEmprestimo() {
        System.out.println("Analisando empréstimo para o cliente: " + nome);
        if (scoreCredito > 600) {
            System.out.println("Empréstimo aprovado!");
        } else {
            System.out.println("Empréstimo negado. Score de crédito insuficiente.");
        }
    }

    public void contratarSeguroVida(ContaPoupanca contaPoupanca) {
        System.out.println("Contratando seguro de vida para o cliente: " + nome);
        if (contaPoupanca.getSaldo() > 200) {
            System.out.println("Seguro de vida contratado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente na conta poupança para contratar seguro de vida.");
        }
    }
}
