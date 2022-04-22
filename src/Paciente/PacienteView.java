package Paciente;
import Pessoa.PessoaView;
import javax.swing.*;

public class PacienteView extends PessoaView {
    JTextField enderecoText = new JTextField(10);
    public int auxOp;

    public PacienteView() {
    }

    public String getEndereco() {
        return enderecoText.getText();
    }

    public void mostrarView() {

        panel.add(new JLabel("Endereço"));
        panel.add(enderecoText);

        ImageIcon icon = new ImageIcon("src/assets/paciente.png");
        Object[] panelOptions = {"Ok", "Ok e adicionar mais", "Cancelar"};

        auxOp = JOptionPane.showOptionDialog(null,
                panel,
                "Adicionar um Paciente",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon, panelOptions, null);

    }
}
