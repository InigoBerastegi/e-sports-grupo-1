package Controlador.ControladorBD;

import Modelo.Equipo;
import Modelo.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ControladorTablaClasificacion {
    private Connection con;
    public ControladorTablaClasificacion(Connection con) {
        this.con = con;
    }
    public List<String> llenarEquiposCompeticion(Integer competicion) throws Exception {

        List<String> listaEquipos=new ArrayList<>();
        String plantilla5 = "SELECT id_equipo FROM clasificacion WHERE id_competicion=?";

        PreparedStatement statement = con.prepareStatement(plantilla5);
        statement.setInt(1, competicion);
        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            listaEquipos.add(rs.getString("id_equipo"));
            System.out.println(rs.getString("id_equipo"));
        }

        statement.close();
        return listaEquipos;
    }
}
