package Modelo;

import java.time.LocalDate;
import java.util.List;

public class Jornada {

    private LocalDate fechaEnfrentamiento;
    private Integer idJornada;
    private List<Enfrentamiento> listaEnfrentamiento;
    private Competicion competicion;

    public Jornada(Integer idJornada, LocalDate fechaEnfrentamiento, Competicion competicion) {
        this.idJornada = idJornada;
        this.fechaEnfrentamiento = LocalDate.parse(String.valueOf(fechaEnfrentamiento));
        this.competicion = competicion;
    }

    public Jornada() {

    }

    public LocalDate getFechaEnfrentamiento() {
        return fechaEnfrentamiento;
    }

    public void setFechaEnfrentamiento(LocalDate fechaEnfrentamiento) {
        this.fechaEnfrentamiento = fechaEnfrentamiento;
    }

    public Integer getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(String idJornada) {
        this.idJornada = Integer.valueOf(idJornada);
    }

    public List<Enfrentamiento> getListaEnfrentamiento() {
        return listaEnfrentamiento;
    }

    public void setListaEnfrentamiento(List<Enfrentamiento> listaEnfrentamiento) {
        this.listaEnfrentamiento = listaEnfrentamiento;
    }

    public Competicion getCompeticion() {
        return competicion;
    }

    public void setCompeticion(Competicion competicion) {
        this.competicion = competicion;
    }
}
