package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaInsertarResultados extends JFrame {
    private JPanel panel2;
    private JButton bVolver;
    private JButton bInicio;
    private JTextField resultadoLocal;
    private JPanel panel1;
    private JComboBox cbCompeticiones;
    private JComboBox cbJornadas;
    private JLabel equipoLocal;
    private JLabel equipoVisitante;
    private JTextField resultadoVisitante;
    private JPanel panelEnfrentamiento;


    public VentanaInsertarResultados() {
        setContentPane(panel1);
        setLocationRelativeTo(null);
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanelEnfrentamiento() {
        return panelEnfrentamiento;
    }

    public void setPanelEnfrentamiento(JPanel panelEnfrentamiento) {
        this.panelEnfrentamiento = panelEnfrentamiento;
    }

    public JButton getbVolver() {
        return bVolver;
    }

    public void setbVolver(JButton bVolver) {
        this.bVolver = bVolver;
    }

    public JButton getbInicio() {
        return bInicio;
    }

    public void setbInicio(JButton bInicio) {
        this.bInicio = bInicio;
    }

    public JTextField getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(JTextField resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JComboBox getCbCompeticiones() {
        return cbCompeticiones;
    }

    public void setCbCompeticiones(JComboBox cbCompeticiones) {
        this.cbCompeticiones = cbCompeticiones;
    }

    public JComboBox getCbJornadas() {
        return cbJornadas;
    }

    public void setCbJornadas(JComboBox cbJornadas) {
        this.cbJornadas = cbJornadas;
    }

    public JLabel getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(JLabel equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public JLabel getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(JLabel equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public JTextField getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(JTextField resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    public void addVolver(ActionListener al) {
        bVolver.addActionListener(al);
    }
    public void addInicio(ActionListener al) {
        bInicio.addActionListener(al);
    }
    public void addCBCompeticion(ActionListener al) {
        cbCompeticiones.addActionListener(al);
    }
    public void addCBJornada(ActionListener al) {
        cbJornadas.addActionListener(al);
    }
    public void mostrar(String m){
        JOptionPane.showMessageDialog(null,m);
    }

    public void agregarPanel(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelEnfrentamiento.add(panel, gbc);
        panelEnfrentamiento.revalidate();
        panelEnfrentamiento.repaint();
    }

}
