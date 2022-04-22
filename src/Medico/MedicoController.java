package Medico;

import Medico.ListaDeMedicos;
import Medico.Medico;
import Utils.Sys;
import Medico.MedicoView;


public class MedicoController {

     ListaDeMedicos listaDeMedicos = new ListaDeMedicos();

    public void mostrarAdicionarMedicos() {

        int auxOp = 1;
        while (auxOp == 1) {
            MedicoView mv = new MedicoView();
            mv.mostrarView();
            if (mv.auxOp < 2) {
                if (verificaSeDadosForamPreenchidos(mv)) {
                    Medico m = new Medico(mv.getNome(), mv.getCpf(), mv.getEspecialidade());
                    listaDeMedicos.add(m);
                }
            }
            auxOp = mv.auxOp;
            Sys.println(listaDeMedicos);
        }
    }

    boolean verificaSeDadosForamPreenchidos(MedicoView mv) {
        return mv.getNome().length() > 0 && mv.getCpf().length() > 0 && mv.getEspecialidade().length() > 0;
    }
}
