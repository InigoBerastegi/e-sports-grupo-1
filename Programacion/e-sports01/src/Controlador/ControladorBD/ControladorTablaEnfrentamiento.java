package Controlador.ControladorBD;

import Modelo.Enfrentamiento;
import Modelo.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorTablaEnfrentamiento {
    private Connection con;
    public ControladorTablaEnfrentamiento(Connection con) {
        this.con = con;
    }

    public List<Enfrentamiento> buscarEnfrentamientos(List<String> idJorCompList) throws SQLException {
        List<Enfrentamiento> enfrentamientos = new ArrayList<>();
        String sql = "SELECT id_enfrentamiento, id_local, id_visitante, hora, resultado_local, resultado_visitante FROM enfrentamiento WHERE id_jor_comp = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        for (String idJorComp : idJorCompList) {
            ps.setString(1, idJorComp);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Enfrentamiento enfrentamiento = new Enfrentamiento();
                enfrentamiento.setIdEnfrentamiento(rs.getInt("id_enfrentamiento"));
                enfrentamiento.setHora(rs.getTime("hora").toLocalTime());
                enfrentamiento.setResultadoLocal(rs.getInt("resultado_local"));
                enfrentamiento.setResultadoVisitante(rs.getInt("resultado_visitante"));

                //enfrentamiento.setIdLocal(rs.getInt("id_local"));
                //enfrentamiento.setIdVisitante(rs.getInt("id_visitante"));

                enfrentamientos.add(enfrentamiento);
            }
            rs.close();
        }

        ps.close();

        return enfrentamientos;
    }

    public Integer llenarLocal(Integer id_enf_jor) throws Exception {
        Integer id_equipo=null;

        String plantilla = "SELECT id_local FROM enfrentamiento WHERE id_enf_jor=?";

        PreparedStatement statement = con.prepareStatement(plantilla);
        statement.setString(1, String.valueOf(id_enf_jor));
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            id_equipo= rs.getInt("id_local");
            System.out.println(rs.getString("id_local"));
        }
        statement.close();
        return id_equipo;
    }
    public Integer llenarVisitante(Integer id_enf_jor) throws Exception {
        Integer id_equipo=null;

        String plantilla = "SELECT id_local FROM enfrentamiento WHERE id_enf_jor=?";

        PreparedStatement statement = con.prepareStatement(plantilla);
        statement.setString(1, String.valueOf(id_enf_jor));
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            id_equipo= rs.getInt("id_visitante");
            System.out.println(rs.getString("id_visitante"));
        }
        statement.close();
        return id_equipo;
    }
}
