package Pessoa;

import javax.swing.*;
import java.awt.*;


public class PessoaView {
    protected JPanel panel = new JPanel(new GridLayout(3, 5));
    protected JTextField textNome = new JTextField(10);
    protected JTextField textCPF = new JTextField(10);

    public String getNome() {
        return textNome.getText();
    }

    public String getCpf() {
        return textCPF.getText();
    }

    public PessoaView() {
        panel.add(new JLabel("Nome"));
        panel.add(textNome);
        panel.add(new JLabel("CPF"));
        panel.add(textCPF);
    }
}
