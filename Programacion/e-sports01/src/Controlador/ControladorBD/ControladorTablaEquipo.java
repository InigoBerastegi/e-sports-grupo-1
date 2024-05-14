package Controlador.ControladorBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControladorTablaEquipo {
    private Connection con;
    public ControladorTablaEquipo(Connection con) {
        this.con = con;
    }


    public String rellenarNombre() throws Exception {
        String nombre = null;

        String plantilla9 = "SELECT nombre FROM equipo WHERE id_equipo=1";

        PreparedStatement statement = con.prepareStatement(plantilla9);
        ResultSet rs = statement.executeQuery();


        if (rs.next()) {

            nombre = rs.getString("nombre");
            System.out.println(nombre);
        }

        statement.close();
        return nombre;
    }
}
