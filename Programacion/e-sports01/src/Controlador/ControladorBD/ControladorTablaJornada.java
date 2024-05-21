package Controlador.ControladorBD;

import Modelo.Jornada;
import Modelo.Juego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorTablaJornada {
    private Connection con;
    public ControladorTablaJornada(Connection con) {
        this.con = con;
    }

    public List<Integer> buscarJornadas(String idCompeticion) throws Exception {
        String sql = "SELECT id_jornada FROM jornada WHERE id_competicion= ?";
        List<Integer> listaJornadas = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(idCompeticion));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idJornada = rs.getInt("id_jornada");
                    listaJornadas.add(idJornada);
                }
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar jornadas: " + e.getMessage());
        }

        return listaJornadas;
    }

    public List<String> buscarIdJorComp(Integer idJornada, Integer idCompeticion) throws Exception {
        List<String> idJorCompList = new ArrayList<>();
        String sql = "SELECT id_jor_comp FROM jornada WHERE id_jornada = ? AND id_competicion = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idJornada);
        ps.setInt(2, idCompeticion);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            idJorCompList.add(rs.getString("id_jor_comp"));
        }

        rs.close();
        ps.close();

        return idJorCompList;
    }

}
