package Controlador.ControladorVista;

import Controlador.ControladorBD.ControladorTablaEquipo;
import Vista.VentanaClasificacion;
import Vista.VentanaEditar;
import Vista.VentanaEquipos;

import java.sql.Connection;

public class ControladorVClasificacion {
    private ControladorVista cv;
    private VentanaEquipos veq;
    private ControladorTablaEquipo ctequipo;

    private VentanaClasificacion vClasificacion;

    public ControladorVClasificacion(ControladorVista cv) {
        this.cv = cv;
    }

    public void crearMostrar() {
        vClasificacion = new VentanaClasificacion();
        vClasificacion.setVisible(true);
    }
}
