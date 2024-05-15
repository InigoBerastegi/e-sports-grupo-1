package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaPatrocinadores extends JFrame{
    private JRadioButton rbNuevo;
    private JRadioButton rbEliminar;
    private JRadioButton rbEditar;
    private JPanel pPatrocinadores;
    private JButton bInicio;
    private JButton bVolver;
    private JPanel pEditar;
    private JTextField tfNombre;
    private JComboBox cbEquipos;
    private JPanel pEliminar;
    private JPanel pNuevo;
    private JComboBox cbPatrocinadores;
    private JRadioButton rbEditarNombre;
    private JRadioButton rbVincular;
    private JRadioButton rbDesvincular;
    private JTextField tfNuevoNombre;
    private JComboBox cbVincular;
    private JComboBox cbDesvincular;
    private JComboBox cbPatrocinador;

    public VentanaPatrocinadores() {
        setContentPane(pPatrocinadores);
        setLocationRelativeTo(null);
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public JRadioButton getRbNuevo() {
        return rbNuevo;
    }

    public void setRbNuevo(JRadioButton rbNuevo) {
        this.rbNuevo = rbNuevo;
    }

    public JRadioButton getRbEliminar() {
        return rbEliminar;
    }

    public void setRbEliminar(JRadioButton rbEliminar) {
        this.rbEliminar = rbEliminar;
    }

    public JRadioButton getRbEditar() {
        return rbEditar;
    }

    public void setRbEditar(JRadioButton rbEditar) {
        this.rbEditar = rbEditar;
    }

    public JPanel getpEditar() {
        return pEditar;
    }

    public void setpEditar(JPanel pEditar) {
        this.pEditar = pEditar;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    public JComboBox getCbEquipos() {
        return cbEquipos;
    }

    public void setCbEquipos(JComboBox cbEquipos) {
        this.cbEquipos = cbEquipos;
    }

    public JPanel getpEliminar() {
        return pEliminar;
    }

    public void setpEliminar(JPanel pEliminar) {
        this.pEliminar = pEliminar;
    }

    public JPanel getpNuevo() {
        return pNuevo;
    }

    public void setpNuevo(JPanel pNuevo) {
        this.pNuevo = pNuevo;
    }

    public JPanel getpPatrocinadores() {
        return pPatrocinadores;
    }

    public void setpPatrocinadores(JPanel pPatrocinadores) {
        this.pPatrocinadores = pPatrocinadores;
    }

    public JButton getbInicio() {
        return bInicio;
    }

    public void setbInicio(JButton bInicio) {
        this.bInicio = bInicio;
    }

    public JButton getbVolver() {
        return bVolver;
    }

    public void setbVolver(JButton bVolver) {
        this.bVolver = bVolver;
    }

    public JComboBox getCbPatrocinadores() {
        return cbPatrocinadores;
    }

    public void setCbPatrocinadores(JComboBox cbPatrocinadores) {
        this.cbPatrocinadores = cbPatrocinadores;
    }

    public JRadioButton getRbEditarNombre() {
        return rbEditarNombre;
    }

    public void setRbEditarNombre(JRadioButton rbEditarNombre) {
        this.rbEditarNombre = rbEditarNombre;
    }

    public JRadioButton getRbVincular() {
        return rbVincular;
    }

    public void setRbVincular(JRadioButton rbVincular) {
        this.rbVincular = rbVincular;
    }

    public JRadioButton getRbDesvincular() {
        return rbDesvincular;
    }

    public void setRbDesvincular(JRadioButton rbDesvincular) {
        this.rbDesvincular = rbDesvincular;
    }

    public JTextField getTfNuevoNombre() {
        return tfNuevoNombre;
    }

    public void setTfNuevoNombre(JTextField tfNuevoNombre) {
        this.tfNuevoNombre = tfNuevoNombre;
    }

    public JComboBox getCbVincular() {
        return cbVincular;
    }

    public void setCbVincular(JComboBox cbVincular) {
        this.cbVincular = cbVincular;
    }

    public JComboBox getCbDesvincular() {
        return cbDesvincular;
    }

    public void setCbDesvincular(JComboBox cbDesvincular) {
        this.cbDesvincular = cbDesvincular;
    }


    public void addVolver(ActionListener al) {
        bVolver.addActionListener(al);
    }
    public void addInicio(ActionListener al) {
        bInicio.addActionListener(al);
    }

    public void addrbNuevoAL(ActionListener al) {
        rbNuevo.addActionListener(al);
    }
    public void addrbEditarAL(ActionListener al) {
        rbEditar.addActionListener(al);
    }
    public void addrbEliminarAL(ActionListener al) {
        rbEliminar.addActionListener(al);
    }


    public void limpiar() {
        tfNombre.setText("");
        cbEquipos.setSelectedIndex(-1);
        cbPatrocinador.setSelectedIndex(-1);
        cbPatrocinadores.setSelectedIndex(-1);
        tfNuevoNombre.setText("");
        cbVincular.setSelectedIndex(-1);
        cbDesvincular.setSelectedIndex(-1);

    }
}