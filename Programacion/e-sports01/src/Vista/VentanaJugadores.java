package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaJugadores extends JFrame {
    private JRadioButton rbNuevo;
    private JRadioButton rbEliminar;
    private JRadioButton rbEditar;
    private JPanel pNuevo;
    private JTextField tfNombre;
    private JComboBox cbNacionalidad;
    private JPanel pEliminar;
    private JButton bInicio;
    private JButton bVolver;
    private JPanel pJugadores;
    private JTextField tfNuevoNombre;
    private JLabel labelJugador;
    private JTextField tfApellido1;
    private JTextField tfSueldo;
    private JTextField tfApellido2;
    private JTextField tfFechaNac;
    private JTextField tfNickname;
    private JComboBox cbRol;
    private JComboBox cbEquipo;
    private JComboBox cbJugadorEliminar;
    private JPanel pEditar;
    private JLabel labelJugadorM;
    private JComboBox cbEditJugadores;
    private JRadioButton rbEditarNombre;
    private JRadioButton rbEditApellido1;
    private JRadioButton rbEditApellido2;
    private JRadioButton rbEditSueldo;
    private JRadioButton rbEditNacionalidad;
    private JComboBox cbNuevaNacionalidad;
    private JTextField tfNuevoSueldo;
    private JTextField tfNuevoApellido1;
    private JTextField tfNuevoApellido2;
    private JRadioButton rbEditFechaNac;
    private JTextField tfNuevaFechaNac;
    private JRadioButton rbEditNickName;
    private JTextField tfNuevoNick;
    private JRadioButton rbEditRol;
    private JComboBox cbNuevoRol;
    private JRadioButton rbEditEquipo;
    private JComboBox cbNuevoEquipo;
    private JButton btAceptar;
    private JComboBox cbEquipoElim;

    public VentanaJugadores() {
        setContentPane(pJugadores);
        setLocationRelativeTo(null);
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public void addVolver(ActionListener al) {
        bVolver.addActionListener(al);
    }
    public void addInicio(ActionListener al) {
        bInicio.addActionListener(al);
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

    public JPanel getpNuevo() {
        return pNuevo;
    }

    public void setpNuevo(JPanel pNuevo) {
        this.pNuevo = pNuevo;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    public JComboBox getCbNacionalidad() {
        return cbNacionalidad;
    }

    public void setCbNacionalidad(JComboBox cbNacionalidad) {
        this.cbNacionalidad = cbNacionalidad;
    }

    public JPanel getpEliminar() {
        return pEliminar;
    }

    public void setpEliminar(JPanel pEliminar) {
        this.pEliminar = pEliminar;
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

    public JPanel getpJugadores() {
        return pJugadores;
    }

    public JComboBox getCbJugadorEliminar() {
        return cbJugadorEliminar;
    }

    public void setCbJugadorEliminar(JComboBox cbJugadorEliminar) {
        this.cbJugadorEliminar = cbJugadorEliminar;
    }

    public JButton getBtAceptar() {
        return btAceptar;
    }

    public void setBtAceptar(JButton btAceptar) {
        this.btAceptar = btAceptar;
    }

    public void setpJugadores(JPanel pJugadores) {
        this.pJugadores = pJugadores;
    }

    public JTextField getTfNuevoNombre() {
        return tfNuevoNombre;
    }

    public void setTfNuevoNombre(JTextField tfNuevoNombre) {
        this.tfNuevoNombre = tfNuevoNombre;
    }

    public JLabel getLabelJugador() {
        return labelJugador;
    }

    public void setLabelJugador(JLabel labelJugador) {
        this.labelJugador = labelJugador;
    }

    public JTextField getTfApellido1() {
        return tfApellido1;
    }

    public void setTfApellido1(JTextField tfApellido1) {
        this.tfApellido1 = tfApellido1;
    }

    public JTextField getTfSueldo() {
        return tfSueldo;
    }

    public void setTfSueldo(JTextField tfSueldo) {
        this.tfSueldo = tfSueldo;
    }

    public JTextField getTfApellido2() {
        return tfApellido2;
    }

    public void setTfApellido2(JTextField tfApellido2) {
        this.tfApellido2 = tfApellido2;
    }

    public JTextField getTfFechaNac() {
        return tfFechaNac;
    }

    public void setTfFechaNac(JTextField tfFechaNac) {
        this.tfFechaNac = tfFechaNac;
    }

    public JTextField getTfNickname() {
        return tfNickname;
    }

    public void setTfNickname(JTextField tfNickname) {
        this.tfNickname = tfNickname;
    }

    public JComboBox getCbRol() {
        return cbRol;
    }

    public void setCbRol(JComboBox cbRol) {
        this.cbRol = cbRol;
    }

    public JComboBox getCbEquipo() {
        return cbEquipo;
    }

    public void setCbEquipo(JComboBox cbEquipo) {
        this.cbEquipo = cbEquipo;
    }

    public JComboBox getCbJugador() {
        return cbJugadorEliminar;
    }

    public void setCbJugador(JComboBox cbJugador) {
        this.cbJugadorEliminar = cbJugador;
    }

    public JPanel getpEditar() {
        return pEditar;
    }

    public void setpEditar(JPanel pEditar) {
        this.pEditar = pEditar;
    }

    public JLabel getLabelJugadorM() {
        return labelJugadorM;
    }

    public void setLabelJugadorM(JLabel labelJugadorM) {
        this.labelJugadorM = labelJugadorM;
    }

    public JComboBox getCbEditJugadores() {
        return cbEditJugadores;
    }

    public void setCbEditJugadores(JComboBox cbEditJugadores) {
        this.cbEditJugadores = cbEditJugadores;
    }

    public JRadioButton getRbEditarNombre() {
        return rbEditarNombre;
    }

    public void setRbEditarNombre(JRadioButton rbEditarNombre) {
        this.rbEditarNombre = rbEditarNombre;
    }

    public JRadioButton getRbEditApellido1() {
        return rbEditApellido1;
    }

    public void setRbEditApellido1(JRadioButton rbEditApellido1) {
        this.rbEditApellido1 = rbEditApellido1;
    }

    public JRadioButton getRbEditApellido2() {
        return rbEditApellido2;
    }

    public void setRbEditApellido2(JRadioButton rbEditApellido2) {
        this.rbEditApellido2 = rbEditApellido2;
    }

    public JRadioButton getRbEditSueldo() {
        return rbEditSueldo;
    }

    public void setRbEditSueldo(JRadioButton rbEditSueldo) {
        this.rbEditSueldo = rbEditSueldo;
    }

    public JRadioButton getRbEditNacionalidad() {
        return rbEditNacionalidad;
    }

    public void setRbEditNacionalidad(JRadioButton rbEditNacionalidad) {
        this.rbEditNacionalidad = rbEditNacionalidad;
    }

    public JComboBox getCbNuevaNacionalidad() {
        return cbNuevaNacionalidad;
    }

    public void setCbNuevaNacionalidad(JComboBox cbNuevaNacionalidad) {
        this.cbNuevaNacionalidad = cbNuevaNacionalidad;
    }

    public JTextField getTfNuevoSueldo() {
        return tfNuevoSueldo;
    }

    public void setTfNuevoSueldo(JTextField tfNuevoSueldo) {
        this.tfNuevoSueldo = tfNuevoSueldo;
    }

    public JTextField getTfNuevoApellido1() {
        return tfNuevoApellido1;
    }

    public void setTfNuevoApellido1(JTextField tfNuevoApellido1) {
        this.tfNuevoApellido1 = tfNuevoApellido1;
    }

    public JTextField getTfNuevoApellido2() {
        return tfNuevoApellido2;
    }

    public void setTfNuevoApellido2(JTextField tfNuevoApellido2) {
        this.tfNuevoApellido2 = tfNuevoApellido2;
    }

    public JRadioButton getRbEditFechaNac() {
        return rbEditFechaNac;
    }

    public void setRbEditFechaNac(JRadioButton rbEditFechaNac) {
        this.rbEditFechaNac = rbEditFechaNac;
    }

    public JTextField getTfNuevaFechaNac() {
        return tfNuevaFechaNac;
    }

    public void setTfNuevaFechaNac(JTextField tfNuevaFechaNac) {
        this.tfNuevaFechaNac = tfNuevaFechaNac;
    }

    public JRadioButton getRbEditNickName() {
        return rbEditNickName;
    }

    public void setRbEditNickName(JRadioButton rbEditNickName) {
        this.rbEditNickName = rbEditNickName;
    }

    public JTextField getTfNuevoNick() {
        return tfNuevoNick;
    }

    public void setTfNuevoNick(JTextField tfNuevoNick) {
        this.tfNuevoNick = tfNuevoNick;
    }

    public JRadioButton getRbEditRol() {
        return rbEditRol;
    }

    public void setRbEditRol(JRadioButton rbEditRol) {
        this.rbEditRol = rbEditRol;
    }

    public JComboBox getCbNuevoRol() {
        return cbNuevoRol;
    }

    public void setCbNuevoRol(JComboBox cbNuevoRol) {
        this.cbNuevoRol = cbNuevoRol;
    }

    public JRadioButton getRbEditEquipo() {
        return rbEditEquipo;
    }

    public void setRbEditEquipo(JRadioButton rbEditEquipo) {
        this.rbEditEquipo = rbEditEquipo;
    }

    public JComboBox getCbNuevoEquipo() {
        return cbNuevoEquipo;
    }

    public void setCbNuevoEquipo(JComboBox cbNuevoEquipo) {
        this.cbNuevoEquipo = cbNuevoEquipo;
    }

    public JComboBox getCbEquipoElim() {
        return cbEquipoElim;
    }

    public void setCbEquipoElim(JComboBox cbEquipoElim) {
        this.cbEquipoElim = cbEquipoElim;
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
    public void addAceptar(ActionListener al) {
        btAceptar.addActionListener(al);
    }

    public void limpiar() {
        tfNombre.setText("");
        tfApellido1.setText("");
        tfApellido2.setText("");
        tfSueldo.setText("");
        cbNacionalidad.setSelectedIndex(-1);
        tfFechaNac.setText("");
        tfNickname.setText("");
        cbRol.setSelectedIndex(-1);
        cbEquipo.setSelectedIndex(-1);
        cbJugadorEliminar.setSelectedIndex(-1);
        cbEditJugadores.setSelectedIndex(-1);
        tfNuevoNombre.setText("");
        tfNuevoApellido1.setText("");
        tfNuevoApellido2.setText("");
        tfNuevaFechaNac.setText("");
        cbNuevoRol.setSelectedIndex(-1);
        cbNuevoEquipo.setSelectedIndex(-1);
        tfNuevoNick.setText("");
    }


}
