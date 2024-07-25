package com.thais;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void imprimirClientes() {
        System.out.println("Lista de Clientes:");
        for (Conta conta : contas) {
            System.out.println(conta.getCliente().getNome());
        }
    }
}
