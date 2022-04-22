package Menu;

import Consulta.ConsultaController;
import Consulta.ConsultaView;
import Consulta.ListaConsultasView;
import Medico.MedicoController;
import Paciente.PacienteController;

import javax.swing.*;
import java.awt.*;

public class MenuView {

    JFrame frame = new JFrame("Integrador III A");
    public MenuView() {

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
         jPanel.add(new JLabel("Opções\n"));
jPanel.add(Box.createHorizontalStrut(300));

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        JButton medicoButton = new JButton("Adicionar Médico");
        medicoButton.addActionListener(e-> mostrarMedicoView());
        jPanel.add(medicoButton, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 2;
        gbc2.gridy = 0;

        JButton pacienteButton = new JButton("Adicionar Paciente");
        pacienteButton.addActionListener(e-> mostrarPacienteView());
        jPanel.add(pacienteButton, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 3;
        gbc3.gridy = 0;

        JButton consultaButton = new JButton("Cadastrar Consulta");

        consultaButton.addActionListener(e-> mostrarConsultaView());
        jPanel.add(consultaButton, gbc3);


        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 4;
        gbc4.gridy = 0;

        JButton consultasButton = new JButton("  Listar Consultas  ");
        consultasButton.addActionListener(e-> mostarListarConsultasView());
        jPanel.add(consultasButton, gbc4);


        frame.setPreferredSize(new Dimension(300, 300));
        frame.getContentPane().add(jPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

   public void setVisible() {
        frame.setVisible(true);
    }
     void mostrarMedicoView() {
        MedicoController mc = new MedicoController();
        mc.mostrarAdicionarMedicos();
    }

    void mostrarPacienteView() {
        PacienteController pc = new PacienteController();
        pc.mostrarAdicionarPacientes();
    }

    void mostrarConsultaView() {
        ConsultaView cc = new ConsultaView();
    }

    void mostarListarConsultasView() {
        ListaConsultasView cc = new ListaConsultasView();
    }
}
