package Controlador.ControladorVista;

import Controlador.ControladorBD.ControladorTablaEquipo;
import Modelo.Equipo;
import Vista.VentanaEditar;
import Vista.VentanaEquipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ControladorVEditar {
    private ControladorVista cv;
    private VentanaEditar vEditar;

    public ControladorVEditar(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        vEditar = new VentanaEditar();
        vEditar.setVisible(true);
        vEditar.addPatrocinadores(new BPatrocinadoresAL());
        vEditar.addEquipos(new BEquiposAL());
        vEditar.addJugadores(new BJugadoresAL());
        vEditar.addJuegos(new BJuegosAL());
        vEditar.addStaff(new BStaffAL());
        vEditar.addCompeticiones(new BCompeticionesAL());

        vEditar.addVolver(new BVolverAL());
    }

    public class BVolverAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarVP();
            vEditar.dispose();
        }
    }
    public class BPatrocinadoresAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarPatrocinador();
            vEditar.dispose();
        }
    }
    public class BEquiposAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarEquipos();
            vEditar.dispose();
        }
    }
    public class BJugadoresAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarJugadores();
            vEditar.dispose();
        }
    }
    public class BJuegosAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarJuegos();
            vEditar.dispose();

        }
    }
    public class BStaffAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarStaff();
            vEditar.dispose();
        }
    }
    public class BCompeticionesAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cv.crearMostrarCompeticiones();
            vEditar.dispose();
        }
    }

}