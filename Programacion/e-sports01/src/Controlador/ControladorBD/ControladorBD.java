package Controlador.ControladorBD;

import Controlador.ControladorPrincipal;

import Controlador.ControladorVista.ControladorVJuego;
import Modelo.*;

import Modelo.Equipo;
import Modelo.Usuario;


import java.sql.*;


import java.sql.Date;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.*;

public class ControladorBD {
    private ControladorTablaAsistente ctasistente;
    private ControladorTablaClasificacion ctclasificacion;
    private ControladorTablaCompeticion ctcompeticion;
    private ControladorTablaEnfrentamiento ctenfrentamiento;
    private ControladorTablaEntrenador ctentrenador;
    private ControladorTablaEquipo ctequipo;
    private ControladorTablaJornada ctjornada;
    private ControladorTablaJuego ctjuego;
    private ControladorTablaJugador ctjugador;
    private ControladorTablaPatrocinador ctpatrocinador;
    private ControladorTablaUsuario ctUsuario;
    private ControladorPrincipal cp;
    private Connection con;

    public ControladorBD(ControladorPrincipal cp) {
        abrirConexion();
        this.cp = cp;
        ctUsuario = new ControladorTablaUsuario(con);
        ctpatrocinador = new ControladorTablaPatrocinador(con);
        ctjugador = new ControladorTablaJugador(con);
        ctjuego = new ControladorTablaJuego(con);
        ctjornada = new ControladorTablaJornada(con);
        ctequipo = new ControladorTablaEquipo(con);
        ctentrenador = new ControladorTablaEntrenador(con);
        ctenfrentamiento = new ControladorTablaEnfrentamiento(con);
        ctcompeticion = new ControladorTablaCompeticion(con);
        ctclasificacion = new ControladorTablaClasificacion(con);
        ctasistente = new ControladorTablaAsistente(con);
    }

    public ControladorBD() {

    }

    /*public void abrirConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@a8150ad3dbd3.sn.mynetname.net:33150:xe";
            String user = "proyecto_inigo";
            String passwd = " BryanTeAmo24!";
            con = DriverManager.getConnection(url, user, passwd);
            System.out.println("conexion abierta");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("conexion erronea");
        } catch (SQLException e) {
        }
    }

     */
    public void abrirConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";
            String user = "equipo16";
            String passwd = "equipo16";
            con = DriverManager.getConnection(url, user, passwd);
            System.out.println("conexion abierta");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("conexion erronea");
        } catch (SQLException e) {
        }
    }



    public Integer cantidadEquipos() throws Exception {
        return ctequipo.cantidadEquipos();
    }

    public List<Equipo> llenarEquipos() throws Exception {
        return ctequipo.llenarEquipos();
    }

    public Equipo buscarEquipo(Integer equipo) throws Exception {
        return ctequipo.buscarEquipo(equipo);
    }

    public Patrocinador buscarPatrocinador(Integer idpatrocinador) throws Exception {
        return ctpatrocinador.buscarPatrocinador(idpatrocinador);
    }

    public List<Jugador> llenarJugadores(Integer x) throws Exception {
        return ctjugador.llenarJugadores(x);
    }

    public List<Competicion> llenarCompeticiones() throws Exception {
        return ctcompeticion.llenarCompeticiones();
    }


    public void generarCalendario() throws Exception {
        try {
            java.sql.CallableStatement stmt = con.prepareCall("{call generar_calendario}");
            stmt.execute();
            System.out.println("Calendario generado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al generar el calendario: " + ex.getMessage());
        }
    }
    public void asignarEquiposEnfrentamientos() throws Exception {
        List<Competicion> competiciones = obtenerCompeticiones();

        try {
            for (Competicion competicion : competiciones) {
                List<Equipo> equipos = obtenerEquiposCompeticion(competicion.getNombre());

                int numEquipos = equipos.size();
                int numJornadas = numEquipos - 1;
                int numEnfrentamientosPorJornada = numEquipos / 2;

                for (int jornadaIndex = 0; jornadaIndex < numJornadas; jornadaIndex++) {
                    Jornada jornada = competicion.getListaJornada().get(jornadaIndex);
                    List<Enfrentamiento> enfrentamientosJornada = jornada.getListaEnfrentamiento();

                    for (int enfrentamientoIndex = 0; enfrentamientoIndex < numEnfrentamientosPorJornada; enfrentamientoIndex++) {
                        int equipo1Index = (jornadaIndex + enfrentamientoIndex) % (numEquipos - 1);
                        int equipo2Index = (numEquipos - 1 - enfrentamientoIndex + jornadaIndex) % (numEquipos - 1);

                        if (enfrentamientoIndex == 0) {
                            equipo2Index = numEquipos - 1;
                        }

                        Equipo equipo1 = equipos.get(equipo1Index);
                        Equipo equipo2 = equipos.get(equipo2Index);

                        if (equipo1.getIdEquipo() == -1 || equipo2.getIdEquipo() == -1) {
                            continue;
                        }

                        Enfrentamiento enfrentamiento = enfrentamientosJornada.get(enfrentamientoIndex);
                        enfrentamiento.setEquipoUno(equipo1);
                        enfrentamiento.setEquipoDos(equipo2);

                        // Actualizar el enfrentamiento en la base de datos
                        PreparedStatement ps = con.prepareStatement("UPDATE ENFRENTAMIENTO SET ID_LOCAL = ?, ID_VISITANTE = ? WHERE ID_ENF_JOR = ?");
                        ps.setInt(1, equipo1.getIdEquipo());
                        ps.setInt(2, equipo2.getIdEquipo());
                        ps.setInt(3, enfrentamiento.getIdEnfrentamiento());
                        ps.executeUpdate();
                        ps.close();
                    }
                }
            }
            System.out.println("Equipos asignados a enfrentamientos correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al asignar equipos a enfrentamientos: " + ex.getMessage());
            throw new Exception("Error al asignar equipos a enfrentamientos", ex);
        }
    }

    private List<Competicion> obtenerCompeticiones() throws SQLException {
        List<Competicion> competiciones = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM COMPETICION");
        while (rs.next()) {
            Competicion competicion = new Competicion();
            competicion.setNombre(rs.getString("NOMBRE"));
            competicion.setFechaInicio(rs.getDate("FECHA_INICIO").toLocalDate());
            competicion.setFechaFin(rs.getDate("FECHA_FIN").toLocalDate());
            competicion.setEstado(rs.getString("ESTADO"));
            competicion.setListaJornada(obtenerJornadas(rs.getInt("ID_COMPETICION")));
            competiciones.add(competicion);
        }
        rs.close();
        stmt.close();
        return competiciones;
    }

    private List<Jornada> obtenerJornadas(int idCompeticion) throws SQLException {
        List<Jornada> jornadas = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM JORNADA WHERE ID_COMPETICION = ?");
        ps.setInt(1, idCompeticion);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Jornada jornada = new Jornada();
            jornada.setFechaEnfrentamiento(rs.getDate("FECHA_ENFRENTAMIENTO").toLocalDate());
            jornada.setListaEnfrentamiento(obtenerEnfrentamientos(rs.getInt("ID_JOR_COMP")));
            jornadas.add(jornada);
        }
        rs.close();
        ps.close();
        return jornadas;
    }

    private List<Enfrentamiento> obtenerEnfrentamientos(int idJornada) throws SQLException {
        List<Enfrentamiento> enfrentamientos = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM ENFRENTAMIENTO WHERE ID_JOR_COMP = ?");
        ps.setInt(1, idJornada);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Enfrentamiento enfrentamiento = new Enfrentamiento();
            enfrentamiento.setHora(rs.getTime("HORA").toLocalTime());
            enfrentamiento.setIdEnfrentamiento(rs.getInt("ID_ENF_JOR"));
            enfrentamientos.add(enfrentamiento);
        }
        rs.close();
        ps.close();
        return enfrentamientos;
    }

    private List<Equipo> obtenerEquiposCompeticion(String nombreCompeticion) throws SQLException {
        List<Equipo> equipos = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT EQUIPO.ID_EQUIPO, EQUIPO.NOMBRE FROM CLASIFICACION JOIN EQUIPO ON CLASIFICACION.ID_EQUIPO = EQUIPO.ID_EQUIPO WHERE ID_COMPETICION = (SELECT ID_COMPETICION FROM COMPETICION WHERE NOMBRE = ?)");
        ps.setString(1, nombreCompeticion);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(rs.getInt("ID_EQUIPO"));
            equipo.setNombre(rs.getString("NOMBRE"));
            equipos.add(equipo);
        }
        rs.close();
        ps.close();
        return equipos;
    }

    private int obtenerIdEquipo(String nombreEquipo) throws SQLException {
        int idEquipo = 0;
        PreparedStatement ps = con.prepareStatement("SELECT ID_EQUIPO FROM EQUIPO WHERE NOMBRE = ?");
        ps.setString(1, nombreEquipo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idEquipo = rs.getInt("ID_EQUIPO");
        }
        rs.close();
        ps.close();
        return idEquipo;
    }

    private int obtenerIdEnfrentamiento(LocalDate fechaJornada, String nombreCompeticion, LocalTime hora) throws SQLException {
        int idEnfrentamiento = 0;
        PreparedStatement ps = con.prepareStatement("SELECT ID_ENF_JOR FROM ENFRENTAMIENTO WHERE ID_JOR_COMP = (SELECT ID_JOR_COMP FROM JORNADA WHERE FECHA_ENFRENTAMIENTO = ? AND ID_COMPETICION = (SELECT ID_COMPETICION FROM COMPETICION WHERE NOMBRE = ?)) AND HORA = ?");
        ps.setDate(1, Date.valueOf(fechaJornada));
        ps.setString(2, nombreCompeticion);
        ps.setTime(3, Time.valueOf(hora));
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idEnfrentamiento = rs.getInt("ID_ENF_JOR");
        }
        rs.close();
        ps.close();
        return idEnfrentamiento;
    }
    public void cerrarCompeticiones() throws Exception {
        ctcompeticion.cerrarCompeticiones();
    }

    public Usuario crearJugador(String nombre, String primerApellido, String segundoApellido, Integer sueldo, String nacionalidad, LocalDate fechaNacimiento, String nickname, String rol, String equipo) throws Exception {
        return ctjugador.crearJugador(nombre, primerApellido, segundoApellido, sueldo, nacionalidad, fechaNacimiento, nickname, rol, equipo);
    }
    public Competicion buscarCompeticion(String c) throws Exception {
        return ctcompeticion.buscarCompeticion(c);
    }

    public ArrayList selectEquipo(String nombre) throws Exception {
        return ctequipo.selectEquipo(nombre);
    }

    public Usuario buscarUsuario(String user) throws Exception {
        return ctUsuario.buscarUsuario(user);
    }

    public List<Juego> buscarJuegos() throws SQLException {
        return ctjuego.buscarJuegos();
    }

    public Juego buscarJuego(String nombreJuego) throws Exception {
        return ctjuego.buscarJuego(nombreJuego);
    }

    public void insertarCompeticion(Competicion c) throws Exception {
        ctcompeticion.insertarCompeticion(c);
    }
    public List<Enfrentamiento> buscarEnfrentamientos(Integer idJornada, Integer idCompeticion) throws Exception {
        List<Enfrentamiento> listaEnfrentamientos = new ArrayList<>();
        List<String> idJorCompList = ctjornada.buscarIdJorComp(idJornada, idCompeticion);
        listaEnfrentamientos = ctenfrentamiento.buscarEnfrentamientos(idJorCompList);

        for (Enfrentamiento enf : listaEnfrentamientos) {
            Integer idEquipoLocal = ctenfrentamiento.llenarLocal(enf.getIdEnfrentamiento());
            Equipo equipoLocal = ctequipo.buscarEquipo(idEquipoLocal);
            System.out.println(equipoLocal.getNombre());
            enf.setEquipoUno(equipoLocal);

            Integer idEquipoVisitante = ctenfrentamiento.llenarVisitante(enf.getIdEnfrentamiento());
            Equipo equipoVisitante = ctequipo.buscarEquipo(idEquipoVisitante);
            System.out.println(equipoVisitante.getNombre());
            enf.setEquipoDos(equipoVisitante);
        }

        return listaEnfrentamientos;
    }


    public List<Equipo> llenarEquiposCompeticion(Integer competicion) throws Exception {
        List<String> idEquipos = new ArrayList<>();
        idEquipos = ctclasificacion.llenarEquiposCompeticion(competicion);
        List<Equipo> listaEquipos = new ArrayList<>();
        for (int x = 0; x < idEquipos.size(); x++) {
            listaEquipos = ctequipo.llenarEquiposporID(idEquipos.get(x));
        }
        return listaEquipos;
    }
    public List<String> buscarCompeticiones() throws SQLException {
        return ctcompeticion.buscarCompeticiones();
    }
    public List<Integer> buscarJornadas(String j) throws Exception {
        return ctjornada.buscarJornadas(j);
    }
}