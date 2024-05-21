package Modelo;

import java.time.LocalDate;
import java.util.List;

import java.util.ArrayList;

public class Competicion {


    private LocalDate fechaInicio;
    private  LocalDate fechaFin;
    private String estado;
    private Integer idCompeticion;
    private String nombre;
    private List<Jornada> listaJornada;
    private Juego juego;


    public Competicion(Integer idCompeticion, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String estado) {

        this.idCompeticion = idCompeticion;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.juego = juego;
    }

    public Competicion() {

    }

    public Competicion(String nombre, LocalDate fechaIni, LocalDate fechaFinal, String estado, Juego juego) {
        this.nombre = nombre;
        this.fechaInicio = fechaIni;
        this.fechaFin = fechaFinal;
        this.estado = estado;
        this.juego = juego;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(Integer idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jornada> getListaJornada() {
        return listaJornada;
    }

    public void setListaJornada(List<Jornada> listaJornada) {
        this.listaJornada = listaJornada;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}