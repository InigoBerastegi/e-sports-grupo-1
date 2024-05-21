package Controlador.ControladorVista;

import Controlador.ControladorPrincipal;

import Modelo.*;


import Modelo.Equipo;
import Modelo.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class ControladorVista {

    private ControladorPrincipal cp;
    private ControladorVLogin cvlogin;
    private ControladorVEditar cveditar;
    private ControladorVClasificacion cvclasificacion;
    private ControladorVInsertResultados cvInsertResultados;
    private ControladorVP cvp;
    private ControladorVPatrocinador cvpatrocinador;
    private ControladorVEquipo cvequipo;
    private ControladorVJugador cvjugador;
    private ControladorVJuego cvjuego;
    private ControladorVStaff cvstaff;
    private ControladorVCompeticion cvcompeticion;

    public ControladorVista(ControladorPrincipal cp) throws Exception {
        this.cp = cp;
        cvlogin = new ControladorVLogin(this);
        cvlogin.crearMostrar();
        cvp=new ControladorVP(this);
    }

    public void crearMostrarVP() {
        cvp.crearMostrar();
    }
    public void crearMostrarEditar() {
        cveditar=new ControladorVEditar(this);
        cveditar.crearMostrar();
    }
    public void crearMostrarClasificacion() {
        cvclasificacion=new ControladorVClasificacion(this);
        cvclasificacion.crearMostrar();
    }
    public void crearMostrarInsertResultados() {
        cvInsertResultados=new ControladorVInsertResultados(this);
        cvInsertResultados.crearMostrar();
    }
    public void crearMostrarPatrocinador() {
        cvpatrocinador=new ControladorVPatrocinador(this);
        cvpatrocinador.crearMostrar();
    }
    public void crearMostrarEquipos() {
        cvequipo=new ControladorVEquipo(this);
        cvequipo.crearMostrar();
    }
    public void crearMostrarJugadores() {
        cvjugador=new ControladorVJugador(this);
        cvjugador.crearMostrar();
    }
    public void crearMostrarJuegos() {
        cvjuego=new ControladorVJuego(this);
        cvjuego.crearMostrar();
    }
    public void crearMostrarStaff() {
        cvstaff=new ControladorVStaff(this);
        cvstaff.crearMostrar();
    }
    public void crearMostrarCompeticiones() {
        cvcompeticion=new ControladorVCompeticion(this);
        cvcompeticion.crearMostrar();
    }

    public Usuario buscarUsuario(String user) throws Exception {
        return cp.buscarUsuario(user);
    }
    public Competicion buscarCompeticion(String c) throws Exception {
        return cp.buscarCompeticion(c);
    }
    public List<Integer> buscarJornadas(String j) throws Exception {
        return cp.buscarJornadas(j);
    }
    public List<Enfrentamiento> buscarEnfrentamientos(Integer j, Integer c) throws Exception {
        return cp.buscarEnfrentamientos(j,c);
    }

    public Integer cantidadEquipos() throws Exception {
        return cp.cantidadEquipos();
    }
    public List<Equipo> llenarEquipos() throws Exception {
        return cp.llenarEquipos();
    }
    public List<Jugador> llenarJugadores(Integer x) throws Exception {
        return cp.llenarJugadores(x);
    }
    public List<Competicion> llenarCompeticiones() throws Exception {
        return cp.llenarCompeticiones();
    }
    public List<Equipo> llenarEquiposCompeticion(Integer x) throws Exception {
        return cp.llenarEquiposCompeticion(x);
    }
    public void generarCalendario() throws Exception {
        cp.generarCalendario();
    }
    public void cerrarCompeticiones() throws Exception {
        cp.cerrarCompeticiones();
    }


    public Usuario crearJugador(String nombre, String primerApellido, String segundoApellido, Integer sueldo, String nacionalidad, LocalDate fechaNacimiento, String nickname, String rol , String equipo) throws Exception {
        return cp.crearJugador(nombre,primerApellido,segundoApellido,sueldo,nacionalidad,fechaNacimiento,nickname,rol,equipo);
    }
    public ArrayList selectEquipo(String nombre ) throws Exception {
        return cp.selectEquipo(nombre);
    }
    public List<Juego> buscarJuegos() throws SQLException {return cp.buscarJuegos();}
    public Juego buscarJuego(String nombre) throws Exception{return cp.buscarJuego(nombre);}
    public void insertarCompeticion(Competicion c) throws Exception{cp.insertarCompeticion(c);}
    public List<String> buscarCompeticiones() throws SQLException {return cp.buscarCompeticiones();}

    public void asignarEquiposEnfrentamientos() throws Exception{
        cp.asignarEquiposEnfrentamientos();
    }
}
