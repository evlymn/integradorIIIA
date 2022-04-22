package Paciente;

import Pessoa.Pessoa;

public class Paciente extends Pessoa {
    String endereco;

    public Paciente(String nome, String cpf, String endereco) {
        super(nome, cpf);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, CPF: %s, Endereco: %s", super.getNome(), super.getCpf(), getEndereco());
    }
}
