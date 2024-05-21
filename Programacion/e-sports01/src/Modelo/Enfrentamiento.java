package Modelo;

import java.time.LocalTime;

public class Enfrentamiento {

    private Equipo equipoUno;
    private Equipo equipoDos;
    private Integer idEnfrentamiento;
    private LocalTime hora;
    private Integer resultadoLocal;
    private Integer resultadoVisitante;
    private Jornada jornada;
    private Integer idEnfJor;

    public Enfrentamiento(Equipo equipoUno, Equipo equipoDos, Integer idEnfrentamiento, LocalTime hora, Integer resultadoLocal, Integer resultadoVisitante, Jornada jornada) {
        this.equipoUno = equipoUno;
        this.equipoDos = equipoDos;
        this.idEnfrentamiento = idEnfrentamiento;
        this.hora = hora;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
        this.jornada = jornada;
    }

    public Enfrentamiento() {

    }

    public Equipo getEquipoUno() {
        return equipoUno;
    }

    public void setEquipoUno(Equipo equipoUno) {
        this.equipoUno = equipoUno;
    }

    public Equipo getEquipoDos() {
        return equipoDos;
    }

    public void setEquipoDos(Equipo equipoDos) {
        this.equipoDos = equipoDos;
    }

    public Integer getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(Integer idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Integer getIdEnfJor() {
        return idEnfJor;
    }

    public void setIdEnfJor(Integer idEnfJor) {
        this.idEnfJor = idEnfJor;
    }

    public Integer getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(Integer resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public Integer getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(Integer resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }
}
