package Consulta;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaConsultasView extends JFrame {
    ListaDeConsultas listaDeConsultas = new ListaDeConsultas();
    List<Consulta> listaDeConsultasPesquisa = null;
    JTextField pesquisarText = new JTextField();
    JTable table = new JTable();
    Object[][] objetos = null;
    String[] colunas = new String[]{"Paciente", "Especialidade", "Data"};

    public ListaConsultasView() {

        JDialog frame = new JDialog(this, "Listar Consultas", Dialog.ModalityType.APPLICATION_MODAL);
        JPanel corpoPanel = new JPanel();
        corpoPanel.setLayout(new BoxLayout(corpoPanel, BoxLayout.PAGE_AXIS));

        JPanel cabecalhoPanel = new JPanel();

        cabecalhoPanel.setLayout(new BoxLayout(cabecalhoPanel, BoxLayout.LINE_AXIS));
        cabecalhoPanel.setPreferredSize(new Dimension(300, 30));
        cabecalhoPanel.setMaximumSize(new Dimension(500, 30));
        cabecalhoPanel.add(Box.createHorizontalStrut(10));
        cabecalhoPanel.add(new JLabel("Pesquisa: "));


        cabecalhoPanel.add(pesquisarText);
        JButton buttonConsulta = new JButton("Pesquisar");
        pesquisarText.addActionListener(e-> {
            pesuisarConsulta();
        });
        buttonConsulta.addActionListener((e) -> {
            pesuisarConsulta();
        });
        cabecalhoPanel.add(buttonConsulta);
        corpoPanel.add(cabecalhoPanel);


        objetos = getObjetosConsultas(listaDeConsultas.getList());
        DefaultTableModel model = new DefaultTableModel(objetos, colunas);
        table.setModel(model);
        table.setDragEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        corpoPanel.add(Box.createVerticalStrut(10));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
         corpoPanel.add(scrollPane);

        frame.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(corpoPanel, BorderLayout.PAGE_START);
        frame.setLocationRelativeTo(null);
        frame.setMaximumSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(500, 500));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setModal(true);
        frame.setVisible(true);
    }

    void pesuisarConsulta() {
        listaDeConsultasPesquisa = null;
        if (pesquisarText.getText().length() > 0) {

            listaDeConsultasPesquisa = listaDeConsultas.find(pesquisarText.getText());
            Object[][] objects = getObjetosConsultas(listaDeConsultasPesquisa);
            DefaultTableModel model = new DefaultTableModel(objects, colunas);
            table.setModel(model);
        } else {
            DefaultTableModel model = new DefaultTableModel(objetos, colunas);
            table.setModel(model);
        }

    }


    Object[][] getObjetosConsultas(List<Consulta> consultas) {
        Object[][] objects = new Object[consultas.size()][];
        for (int i = 0; i < consultas.size(); i++) {
            objects[i] = new String[]{consultas.get(i).getPaciente().getNome(), consultas.get(i).getMedico().getEspecialidade(), consultas.get(i).getDataConsultaFormatted()};
        }
        return objects;
    }
}
