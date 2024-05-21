package Controlador.ControladorBD;

import Modelo.Competicion;
import Modelo.Equipo;
import Modelo.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorTablaCompeticion {
    private Connection con;
    private ControladorTablaJuego ctj;
    private Competicion c;
    private List<Competicion> listaCompeticiones;
    private int contadorComp;
    private List<String> listaNombreCompeticiones;


    public ControladorTablaCompeticion(Connection con) {
        this.con = con;
    }
    public List<Competicion> llenarCompeticiones() throws Exception {
        List<Competicion> llenarCompeticiones=new ArrayList<>();

        String plantilla = "SELECT * FROM competicion";

        PreparedStatement statement = con.prepareStatement(plantilla);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Competicion competicion=new Competicion();
            competicion.setNombre(rs.getString("nombre"));
            llenarCompeticiones.add(competicion);
            System.out.println(rs.getString("nombre"));
        }

        statement.close();
        return llenarCompeticiones;
    }
        public void insertarCompeticion(Competicion c) throws Exception {

            String sql = "{call competicion_pkg.crear_competicion(?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = con.prepareCall(sql)) {
                stmt.setString(1, c.getNombre());
                stmt.setDate(2, Date.valueOf(c.getFechaInicio()));
                stmt.setDate(3, Date.valueOf(c.getFechaFin()));
                stmt.setString(4, c.getEstado());
                stmt.setInt(5, c.getJuego().getIdJuego());
                stmt.execute();
                System.out.println("Competición creada correctamente.");
            } catch (SQLException ex) {
                System.out.println("Error al crear la competición: " + ex.getMessage());
                throw new Exception("Error al crear la competición", ex);
            }
        }


    public Competicion buscarCompeticion(String nombre) throws Exception {
        Competicion c = null;

        String plantilla = "SELECT id_competicion, nombre,fecha_inicio, fecha_fin, estado FROM competicion WHERE nombre=?";

        PreparedStatement buscarCompeticion = con.prepareStatement(plantilla);
        buscarCompeticion.setString(1, nombre);

        ResultSet rs = buscarCompeticion.executeQuery();

        if (rs.next()) {
            c = new Competicion();
            c.setNombre(rs.getString("nombre"));
            c.setIdCompeticion(rs.getInt("id_competicion"));
            c.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
            c.setFechaFin(rs.getDate("fecha_fin").toLocalDate());
            c.setEstado(rs.getString("estado"));
        } else {
            System.out.println("Competicion no encontrada.");
        }
        rs.close();
        buscarCompeticion.close();

        return c;
    }
    public List<String> buscarCompeticiones() throws SQLException {
        listaNombreCompeticiones = new ArrayList<>();
        String plantilla ="SELECT nombre from competicion";

        PreparedStatement sentencia = con.prepareStatement(plantilla);

        ResultSet resultado = sentencia.executeQuery();

        while (resultado.next()){
            listaNombreCompeticiones.add(resultado.getString("nombre"));
        }
        sentencia.close();
        return listaNombreCompeticiones;
    }
    public int contarCompeticiones() throws SQLException {
        String plantilla = "SELECT COUNT(*) AS total FROM competicion";
        PreparedStatement sentencia = con.prepareStatement(plantilla);
        ResultSet resultado = sentencia.executeQuery();
        if (resultado.next()){
            contadorComp = resultado.getInt("total");
        }
        sentencia.close();
        return contadorComp;
    }
    public void cerrarCompeticiones() throws Exception {
        String sql = "UPDATE competicion SET estado = 'cerrado' WHERE estado = 'abierto'";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Competiciones abiertas cerradas: " + rowsUpdated);
        } catch (SQLException ex) {
            System.out.println("Error al cerrar competiciones: " + ex.getMessage());
            throw new SQLException("Error al cerrar competiciones", ex);
        }
    }

    /*public void crearCompeticion(String nombre, Date fechaInicio, Date fechaFin, String estado, int idJuego) throws SQLException {
        CallableStatement cs = null;

        try {
            cs = con.prepareCall("{call competicion_pkg.crear_competicion(?, ?, ?, ?, ?)}");
            cs.setString(1, nombre);
            cs.setDate(2, fechaInicio);
            cs.setDate(3, fechaFin);
            cs.setString(4, estado);
            cs.setInt(5, idJuego);

            cs.execute();
            System.out.println("Competición creada correctamente.");
        } finally {
            if (cs != null) {
                cs.close();
            }
        }
    }

    public void eliminarCompeticion(int idCompeticion) throws SQLException {
        CallableStatement cs = null;

        try {
            cs = con.prepareCall("{call competicion_pkg.eliminar_competicion(?)}");
            cs.setInt(1, idCompeticion);

            cs.execute();
            System.out.println("Competición eliminada correctamente.");
        } finally {
            if (cs != null) {
                cs.close();
            }
        }
    }

    public void modificarCompeticion(int idCompeticion, String nombre, Date fechaInicio, Date fechaFin, String estado, int idJuego) throws SQLException {
        CallableStatement cs = null;

        try {
            cs = con.prepareCall("{call competicion_pkg.modificar_competicion(?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, idCompeticion);
            cs.setString(2, nombre);
            cs.setDate(3, fechaInicio);
            cs.setDate(4, fechaFin);
            cs.setString(5, estado);
            cs.setInt(6, idJuego);

            cs.execute();
            System.out.println("Competición modificada correctamente.");
        } finally {
            if (cs != null) {
                cs.close();
            }
}
}*/
}