package Controlador.ControladorVista;


import Modelo.Competicion;
import Modelo.Equipo;
import Modelo.Jugador;

import Modelo.Usuario;
import Vista.VentanaEditar;
import Vista.VentanaInicioSesion;

import Vista.VentanaPrincipal;
import Vista.VistaPerfil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorVP {
    private ControladorVista cv;
    private VentanaPrincipal vp;
    private ControladorVLogin cvl;
    private VistaPerfil vper;
    private VentanaInicioSesion vsesion;

    public ControladorVP(ControladorVista cv) throws Exception {
        this.cv = cv;
    }

    public void crearMostrar() {
            vp = new VentanaPrincipal();
            vp.setVisible(true);
            vp.addeditar(new BEditarAL());

            vp.addcerrarInsc(new BCerrarInscAL());
            vp.addClasificacion(new BClasificacionAL());
            vp.addInsertResultados(new BInsertResultadosAL());


    }

    public class BEditarAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarEditar();
            vp.dispose();
        }
    }

    public class BCerrarInscAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Competicion> listaCompeticiones = cv.llenarCompeticiones();
                boolean par=true;
                for (Competicion competicion : listaCompeticiones) {
                    int x=0;
                    List<Equipo> listaEquiposCompeticion = cv.llenarEquiposCompeticion(x);
                    int numEquipos = listaEquiposCompeticion.size();

                    if (numEquipos % 2 == 0) {
                        System.out.println("El número de equipos en la competición " + competicion.getNombre() + " es par.");
                    } else {
                        par=false;
                        System.out.println("El número de equipos en la competición " + competicion.getNombre() + " es par.");
                        throw new Exception("El número de equipos en la competición " + competicion.getNombre() + " es impar.");
                    }
                    if(par=true){
                        cv.cerrarCompeticiones();
                        cv.generarCalendario();
                        //cv.asignarEquiposEnfrentamientos();
                    }
                    x=x+1;
                }
            } catch (Exception ex) {
                vp.mostrarMensaje(ex.getMessage());
            }
        }
    }
    public class BClasificacionAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarClasificacion();
            vp.dispose();
        }
    }
    public class BInsertResultadosAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarInsertResultados();
            vp.dispose();
        }
    }





}
