package Controlador.ControladorVista;

import Controlador.ControladorBD.ControladorTablaEquipo;
import Modelo.*;
import Vista.VentanaClasificacion;
import Vista.VentanaEquipos;
import Vista.VentanaInsertarResultados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorVInsertResultados {
    private ControladorVista cv;
    private VentanaEquipos veq;
    private ControladorTablaEquipo ctequipo;

    private VentanaInsertarResultados vInsertResultados;
    private List<String> listaCompeticiones;
    private List<Integer> listaJornadas;

    public ControladorVInsertResultados(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        vInsertResultados = new VentanaInsertarResultados();
        vInsertResultados.setVisible(true);
        vInsertResultados.addVolver(new BVolverAL());
        vInsertResultados.addInicio(new BInicioAL());

        llenarComboCompeticiones();
        vInsertResultados.addCBCompeticion(new BCompeticionAL());
        vInsertResultados.addCBJornada(new BJornadaAL());

        listaCompeticiones=new ArrayList<>();
        listaJornadas=new ArrayList<>();


    }
    public void llenarComboCompeticiones() {
        try {
            listaCompeticiones = cv.buscarCompeticiones();
            listaCompeticiones.forEach(o -> {
                vInsertResultados.getCbCompeticiones().addItem(o);
                System.out.println("Competicion añadida al combo: " + o);
                vInsertResultados.getCbCompeticiones().setSelectedIndex(-1);
                vInsertResultados.getCbJornadas().setSelectedIndex(-1);
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public class BVolverAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarEditar();
            vInsertResultados.dispose();
        }
    }
    public class BInicioAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarVP();
            vInsertResultados.dispose();
        }
    }

    public class BCompeticionAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                vInsertResultados.getCbJornadas().removeAllItems();
            String nombreCompeticion = vInsertResultados.getCbCompeticiones().getSelectedItem().toString();
                System.out.println(nombreCompeticion);
            Competicion competicion= cv.buscarCompeticion(nombreCompeticion);
            System.out.println(competicion.getIdCompeticion());
            llenarComboJornadas(competicion);
        }catch(Exception ex){
                vInsertResultados.mostrar(ex.getMessage());
            }
        }
    }
    public void llenarComboJornadas(Competicion competicion) {
        try {
            System.out.println(competicion.getIdCompeticion());
            listaJornadas = cv.buscarJornadas(String.valueOf(competicion.getIdCompeticion()));
            listaJornadas.forEach(o -> {
                vInsertResultados.getCbJornadas().addItem(o);
                System.out.println("Jornada añadida al combo: " + o);
            });
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public class BJornadaAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Integer idJornada = (Integer) vInsertResultados.getCbJornadas().getSelectedItem();
                Competicion competicion = cv.buscarCompeticion(vInsertResultados.getCbCompeticiones().getSelectedItem().toString());
                Integer idCompeticion =competicion.getIdCompeticion();
                List<Enfrentamiento> enfrentamientos = cv.buscarEnfrentamientos(idJornada, idCompeticion);
                for (Enfrentamiento enfrentamiento : enfrentamientos) {
                    JPanel panelEnfrentamiento = crearPanelEnfrentamiento(enfrentamiento);
                    vInsertResultados.agregarPanel(panelEnfrentamiento);
                }
            } catch (Exception ex) {
                vInsertResultados.mostrar(ex.getMessage());
            }
        }

        private JPanel crearPanelEnfrentamiento(Enfrentamiento enfrentamiento) {
            JPanel panel = new JPanel();
            // Configuración del panel
            panel.setLayout(new GridLayout(1, 1));

            // Crear el panel de enfrentamiento con los equipos
            PanelEnfrentamiento panelEnf = new PanelEnfrentamiento(enfrentamiento.getEquipoUno().toString(), enfrentamiento.getEquipoDos().toString());

            // Agregar el panel de enfrentamiento al panel principal
            panel.add(panelEnf);

            return panel;
        }
    }
}
