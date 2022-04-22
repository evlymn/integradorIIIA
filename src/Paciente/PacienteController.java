package Paciente;

import Paciente.ListaDePacientes;
import Paciente.Paciente;
import Utils.Sys;
import Paciente.PacienteView;

public class PacienteController {

    ListaDePacientes listaDePacientes = new ListaDePacientes();
    public void mostrarAdicionarPacientes() {
       int auxOp = 1;
        while (auxOp == 1) {
            PacienteView pv = new PacienteView();
            pv.mostrarView();
            if (pv.auxOp < 2) {
                if (verificaSeDadosForamPreenchidos(pv)) {
                    Paciente p = new Paciente(pv.getNome(), pv.getCpf(), pv.getEndereco());
                    listaDePacientes.add(p);
                }
            }
            auxOp = pv.auxOp;
            Sys.println(listaDePacientes);
        }
    }

    boolean verificaSeDadosForamPreenchidos(PacienteView pc  ) {
        return pc.getNome().length() > 0 && pc.getCpf().length() > 0 && pc.getEndereco().length() > 0;
    }
}
