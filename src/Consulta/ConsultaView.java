package Consulta;

import Medico.ListaDeMedicos;
import Paciente.ListaDePacientes;
import Medico.Medico;
import Paciente.Paciente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class ConsultaView extends JFrame {
    List<Medico> listaDeMedicosPesquisa;
    List<Paciente> listaDePacientesPesquisa;
    ListaDeMedicos listaDeMedicos = new ListaDeMedicos();
    ListaDePacientes listaDePacientes = new ListaDePacientes();
    ListaDeConsultas listaDeConsultas = new ListaDeConsultas();
    JTable pacientesTable = new JTable();
    JTable medicosTable = new JTable();
    JTextField pesquisarPacientesText = new JTextField();
    JTextField pesquisarMedicosText = new JTextField();
    JTextField dataText = new JTextField();
    Object[][] objetosDePacientes = null;
    Object[][] objetosDeMedicos = null;
    String[] colunasDePacientes = new String[]{"Nome", "CPF"};
    String[] colunasDeMedicos = new String[]{"Nome", "Especialidade"};

    public ConsultaView() {
        objetosDeMedicos = getObjetosDeMedicos(listaDeMedicos.getList());
        objetosDePacientes = getObjetosDePacientes(listaDePacientes.getList());
        iniciarResetarComponentes();

        JPanel corpoPanel = getCorpoPanel();

        JPanel cabecalhoPanel = getCabecalhoPanel();
        corpoPanel.add(cabecalhoPanel);

        JPanel medicosPacientesPanel = getMedicosPacientesPanels();
        corpoPanel.add(medicosPacientesPanel);

        JPanel datePanel = getDatePanel();
        corpoPanel.add(datePanel);

        iniciarMostarDialog(corpoPanel);
    }

    private void iniciarMostarDialog(JPanel corpoPanel) {
        JDialog dialogFrame = new JDialog(this, "Cadastrar Consultas", Dialog.ModalityType.APPLICATION_MODAL);
        dialogFrame.getContentPane().add(corpoPanel, BorderLayout.PAGE_START);
        dialogFrame.setPreferredSize(new Dimension(500, 500));
        dialogFrame.setLocationRelativeTo(null);
        dialogFrame.pack();
        dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialogFrame.setModal(true);
        dialogFrame.setVisible(true);
    }

    private JPanel getCorpoPanel() {
        JPanel corpoPanel = new JPanel();
        corpoPanel.setLayout(new BoxLayout(corpoPanel, BoxLayout.PAGE_AXIS));
        corpoPanel.add(Box.createVerticalStrut(10));
        return corpoPanel;
    }

    private JPanel getCabecalhoPanel() {
        JLabel titutoLabel = new JLabel("Pesquise m??dicos/especialidades e pacientes.");
        titutoLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        JPanel cabecalhoPanel = new JPanel();
        cabecalhoPanel.add(titutoLabel);
        cabecalhoPanel.setLayout(new GridBagLayout());
        return cabecalhoPanel;
    }

    private JPanel getDatePanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.LINE_AXIS));
        datePanel.setPreferredSize(new Dimension(300, 30));
        datePanel.setMaximumSize(new Dimension(500, 30));
        datePanel.add(Box.createHorizontalStrut(10));
        datePanel.add(new JLabel("Informe uma data (dia/m??s/ano): "));
        datePanel.add(dataText);

        JButton buttonConsulta = new JButton("Adicionar consulta");
        buttonConsulta.addActionListener((e) -> {
            adicionarConsulta();
        });
        datePanel.add(buttonConsulta);
        return datePanel;
    }

    private void adicionarConsulta() {
        String data = dataText.getText();
        Date consultaDate = null;
        try {
            LocalDate localDate = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            consultaDate = Date.valueOf(localDate.toString());
            int compareDate = consultaDate.toLocalDate().compareTo(LocalDate.now());
            if (compareDate < 1) {
                showMessageDialog(null, "Data da consulta deve ser superior a data de hoje!");
                return;
            }
        } catch (Exception ex) {
            showMessageDialog(null, "Por favor informe uma data v??lida! \n Exemplo: 01/03/2020");
            return;
        }

        int pacienteRow = pacientesTable.getSelectedRow();
        int medicoRow = medicosTable.getSelectedRow();
        if (pacienteRow > -1 && medicoRow > -1) {
            Paciente paciente = listaDePacientesPesquisa != null ? listaDePacientesPesquisa.get(pacienteRow) : listaDePacientes.get(pacienteRow);
            Medico medico = listaDeMedicosPesquisa != null ? listaDeMedicosPesquisa.get(medicoRow) : listaDeMedicos.get(medicoRow);
            System.out.println(paciente);
            System.out.println(medico);
            listaDeConsultas.add(new Consulta(medico, paciente, consultaDate));
            showMessageDialog(null, "Consulta cadastrada!");
            iniciarResetarComponentes();
            System.out.println(listaDeConsultas);
        } else {
            showMessageDialog(null, "Informe m??dico e paciente!");
        }
    }

    void iniciarResetarComponentes() {
        listaDeMedicosPesquisa = null;
        listaDePacientesPesquisa = null;

        pesquisarPacientesText.setText("");
        pesquisarMedicosText.setText("");
        dataText.setText("");

        DefaultTableModel pacientesModel = new DefaultTableModel(objetosDePacientes, colunasDePacientes);
        pacientesTable.setModel(pacientesModel);
        pacientesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        DefaultTableModel medicosModel = new DefaultTableModel(objetosDeMedicos, colunasDeMedicos);
        medicosTable.setModel(medicosModel);
        medicosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private JPanel getMedicosPacientesPanels() {
        JPanel medicosPacientesPanel = new JPanel();
        medicosPacientesPanel.setLayout(new GridBagLayout());
        JPanel medicosPanel = getPanelMedicos();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        medicosPacientesPanel.add(medicosPanel, gbc);
        JPanel pacientesPanel = getPanelPacientes();
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = 1;

        medicosPacientesPanel.add(pacientesPanel, gbc);
        return medicosPacientesPanel;
    }

    private JPanel getPanelPacientes() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Pacientes"));
        JPanel pesquisarPanel = new JPanel();
        pesquisarPanel.setLayout(new BoxLayout(pesquisarPanel, BoxLayout.LINE_AXIS));
        pesquisarPanel.add(new JLabel("Pesquisar: "));
        pesquisarPacientesText.setToolTipText("Tecle enter para pesquisar, limpe campo+enter para voltar");
        pesquisarPacientesText.addActionListener(e -> {
            listaDePacientesPesquisa = null;
            if (pesquisarPacientesText.getText().length() > 0) {
                listaDePacientesPesquisa = listaDePacientes.find(pesquisarPacientesText.getText());
                Object[][] pesquisa = getObjetosDePacientes(listaDePacientesPesquisa);
                DefaultTableModel model = new DefaultTableModel(pesquisa, colunasDePacientes);
                pacientesTable.setModel(model);
                System.out.println(listaDePacientesPesquisa);
            } else {
                DefaultTableModel model = new DefaultTableModel(objetosDePacientes, colunasDePacientes);
                pacientesTable.setModel(model);
            }
        });
        pesquisarPanel.add(pesquisarPacientesText);
        panel.add(pesquisarPanel);
        JScrollPane scrollPane = new JScrollPane(pacientesTable);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        panel.add(scrollPane);
        return panel;
    }

    private JPanel getPanelMedicos() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("M??dicos"));


        JPanel pesquisarPanel = new JPanel();
        pesquisarPanel.setLayout(new BoxLayout(pesquisarPanel, BoxLayout.LINE_AXIS));
        pesquisarPanel.add(new JLabel("Pesquisar: "));
        pesquisarMedicosText.setToolTipText("Tecle enter para pesquisar, limpe campo+enter para voltar");
        pesquisarMedicosText.addActionListener(e -> {
            listaDeMedicosPesquisa = null;
            if (pesquisarMedicosText.getText().length() > 0) {
                listaDeMedicosPesquisa = listaDeMedicos.find(pesquisarMedicosText.getText());
                Object[][] pesquisa = getObjetosDeMedicos(listaDeMedicosPesquisa);
                DefaultTableModel model = new DefaultTableModel(pesquisa, colunasDeMedicos);
                medicosTable.setModel(model);
                System.out.println(listaDeMedicosPesquisa);
            } else {
                DefaultTableModel model = new DefaultTableModel(objetosDeMedicos, colunasDeMedicos);
                medicosTable.setModel(model);
            }
        });
        pesquisarPanel.add(pesquisarMedicosText);
        panel.add(pesquisarPanel);
        JScrollPane jscrollpane = new JScrollPane(medicosTable);
        jscrollpane.setPreferredSize(new Dimension(200, 200));
        panel.add(jscrollpane);
        return panel;
    }

    Object[][] getObjetosDeMedicos(List<Medico> medicos) {
        Object[][] objects = new Object[medicos.size()][];
        for (int i = 0; i < medicos.size(); i++) {
            objects[i] = new String[]{medicos.get(i).getNome(), medicos.get(i).getEspecialidade()};
        }
        return objects;
    }

    Object[][] getObjetosDePacientes(List<Paciente> paciente) {
        Object[][] objects = new Object[paciente.size()][];
        for (int i = 0; i < paciente.size(); i++) {
            objects[i] = new String[]{paciente.get(i).getNome(), paciente.get(i).getEndereco()};
        }
        return objects;
    }
}
