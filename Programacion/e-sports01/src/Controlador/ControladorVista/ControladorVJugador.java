package Controlador.ControladorVista;

import Modelo.Equipo;
import Modelo.Usuario;
import Vista.VentanaJugadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControladorVJugador {

    private ControladorVista cv;
    private Connection con;
    private VentanaJugadores vJugadores;


    public ControladorVJugador(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        vJugadores = new VentanaJugadores();
        vJugadores.setVisible(true);
        vJugadores.addVolver(new BVolverAL());
        vJugadores.addInicio(new BInicioAL());

        vJugadores.addrbNuevoAL(new RbNuevoAL());
        vJugadores.addrbEditarAL(new RbEditarAL());
        vJugadores.addrbEliminarAL(new RbEliminarAL());
        vJugadores.limpiar();
        vJugadores.getpNuevo().setVisible(false);
        vJugadores.getpEditar().setVisible(false);
        vJugadores.getpEliminar().setVisible(false);
        llenarComboEquipo();
    }
    public class BVolverAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarEditar();
            vJugadores.dispose();
        }
    }
    public class BInicioAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarVP();
            vJugadores.dispose();
        }
    }

    public class RbNuevoAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(vJugadores.getRbNuevo().isSelected()){
                vJugadores.limpiar();
                vJugadores.getpNuevo().setVisible(true);
                vJugadores.getpEditar().setVisible(false);
                vJugadores.getpEliminar().setVisible(false);
                vJugadores.addAceptar(new addBotonAceptar());
            }



        }
    }
public class  addBotonAceptar implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {


        if (vJugadores.getRbNuevo().isSelected()) {


            String nombre = vJugadores.getTfNombre().getText();
            String primerApellido = vJugadores.getTfApellido1().getText();
            String segundoApellido = vJugadores.getTfApellido2().getText();
            Integer sueldo = Integer.valueOf(vJugadores.getTfSueldo().getText());
            String nacionalidad = String.valueOf(vJugadores.getCbNacionalidad().getSelectedItem());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate fechaNacimiento = LocalDate.parse(vJugadores.getTfFechaNac().getText(), formatter);
            String nickname = vJugadores.getTfNickname().getText();
            String rol = String.valueOf(vJugadores.getCbRol().getSelectedItem());
            String equipo = String.valueOf(vJugadores.getCbEquipo().getSelectedIndex() + 1);

            try {
                Usuario anadirJugador = cv.crearJugador(nombre, primerApellido, segundoApellido, sueldo, nacionalidad, fechaNacimiento, nickname, rol, equipo);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }else if (vJugadores.getRbEliminar().isSelected()){

            try {

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }else if (vJugadores.getRbEditar().isSelected()){
            JOptionPane.showMessageDialog(null,"editar" );
        }

    }
}

    public class RbEditarAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(vJugadores.getRbEditar().isSelected()){
                vJugadores.limpiar();
                vJugadores.getpNuevo().setVisible(false);
                vJugadores.getpEditar().setVisible(true);
                vJugadores.getpEliminar().setVisible(false);
            }
        }
    }
    public class RbEliminarAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(vJugadores.getRbEliminar().isSelected()){
                vJugadores.limpiar();
                vJugadores.getpNuevo().setVisible(false);
                vJugadores.getpEditar().setVisible(false);
                vJugadores.getpEliminar().setVisible(true);
            }
        }
    }
    public void llenarComboEquipo(){



        String nombre = null;
        try {
            ArrayList<Equipo> listaEquipos = cv.selectEquipo(nombre);
            listaEquipos.forEach(o-> vJugadores.getCbEquipo().addItem(o.getNombre()));


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
