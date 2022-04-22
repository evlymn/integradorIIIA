package Medico;

import Pessoa.Pessoa;

public class Medico extends Pessoa {
    String especialidade;

    public Medico(String nome, String cpf, String especialidade ) {
        super(nome, cpf);
        this.especialidade = especialidade;
    }

   public String getEspecialidade(){
        return  especialidade;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, CPF: %s, Especialidade: %s", super.getNome(), super.getCpf(), getEspecialidade());
    }
}
