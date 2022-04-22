package Medico;

import Utils.EspecialidadesReader;
import Pessoa.PessoaView;

import javax.swing.*;

public class MedicoView extends PessoaView {

    JComboBox<String> comboEspecialidades = new JComboBox<>();

    public MedicoView() {
    }

    public int auxOp;

    public String getEspecialidade() {
        if (comboEspecialidades.getSelectedItem() != null) {
            return comboEspecialidades.getSelectedItem().toString();
        }
        return "";
    }

    public void mostrarView() {

        panel.add(new JLabel("Especialidade"));

        Object[] especialidades = EspecialidadesReader.getEspecialidades();
        comboEspecialidades.addItem("Selecione...");

        if (especialidades != null) {
            for (Object especialidade : especialidades) {
                comboEspecialidades.addItem(especialidade.toString());
            }
        }

        panel.add(comboEspecialidades);

        ImageIcon icon = new ImageIcon("src/assets/icon-medico.png");
        Object[] panelOptions = {"Ok", "Ok e adicionar mais", "Cancelar"};

        auxOp = JOptionPane.showOptionDialog(null,
                panel,
                "Adicionar um Médico",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon, panelOptions, null);
    }
//
//    public Medico recuperarMedico() {
//        if (comboEspecialidades.getSelectedItem() != null && textNome.getText().length() > 0 && textCPF.getText().length() > 0) {
//            return new Medico(textNome.getText(), textCPF.getText(), comboEspecialidades.getSelectedItem().toString());
//        }
//        return null;
//    }
}
