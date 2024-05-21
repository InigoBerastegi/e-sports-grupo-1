package Modelo;

import javax.swing.*;
import java.awt.*;

public class PanelEnfrentamiento extends JPanel {
    private JLabel lblEquipoLocal;
    private JTextField txtResultadoLocal;
    private JLabel lblGuion;
    private JTextField txtResultadoVisitante;
    private JLabel lblEquipoVisitante;

    public PanelEnfrentamiento(String equipoLocal, String equipoVisitante) {
        // Configuración del panel
        setLayout(new GridLayout(1, 5));

        // Componentes
        lblEquipoLocal = new JLabel(equipoLocal);
        txtResultadoLocal = new JTextField();
        lblGuion = new JLabel("-");
        txtResultadoVisitante = new JTextField();
        lblEquipoVisitante = new JLabel(equipoVisitante);

        // Añadir componentes al panel
        add(lblEquipoLocal);
        add(txtResultadoLocal);
        add(lblGuion);
        add(txtResultadoVisitante);
        add(lblEquipoVisitante);
    }

    // Métodos para obtener los resultados ingresados por el usuario
    public int getResultadoLocal() {
        try {
            return Integer.parseInt(txtResultadoLocal.getText());
        } catch (NumberFormatException e) {
            return -1; // Valor por defecto si no se ingresa un número válido
        }
    }

    public int getResultadoVisitante() {
        try {
            return Integer.parseInt(txtResultadoVisitante.getText());
        } catch (NumberFormatException e) {
            return -1; // Valor por defecto si no se ingresa un número válido
        }
    }

    public JLabel getLblEquipoLocal() {
        return lblEquipoLocal;
    }

    public void setLblEquipoLocal(JLabel lblEquipoLocal) {
        this.lblEquipoLocal = lblEquipoLocal;
    }

    public JTextField getTxtResultadoLocal() {
        return txtResultadoLocal;
    }

    public void setTxtResultadoLocal(JTextField txtResultadoLocal) {
        this.txtResultadoLocal = txtResultadoLocal;
    }

    public JLabel getLblGuion() {
        return lblGuion;
    }

    public void setLblGuion(JLabel lblGuion) {
        this.lblGuion = lblGuion;
    }

    public JTextField getTxtResultadoVisitante() {
        return txtResultadoVisitante;
    }

    public void setTxtResultadoVisitante(JTextField txtResultadoVisitante) {
        this.txtResultadoVisitante = txtResultadoVisitante;
    }

    public JLabel getLblEquipoVisitante() {
        return lblEquipoVisitante;
    }

    public void setLblEquipoVisitante(JLabel lblEquipoVisitante) {
        this.lblEquipoVisitante = lblEquipoVisitante;
    }
}