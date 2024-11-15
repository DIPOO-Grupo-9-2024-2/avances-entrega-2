package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class HistorialActividad {
    private Actividad actividad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCompletada;
    private String resultado;
    private Duration tiempoDedicado; // Nueva métrica para el tiempo dedicado


    public HistorialActividad(Actividad actividad, LocalDateTime fechaInicio) {
        this.actividad = actividad;
        this.fechaInicio = fechaInicio;
        this.resultado = "";
        this.tiempoDedicado = Duration.ZERO;
    }
    // Getters y setters
    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaCompletada() {
        return fechaCompletada;
    }

    public void setFechaCompletada(LocalDateTime fechaCompletada) {
        this.fechaCompletada = fechaCompletada;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    public Duration getTiempoDedicado() {
        return tiempoDedicado;
    }
    
    // Método para completar la actividad
    public void completar(String resultado) {
        this.fechaCompletada = LocalDateTime.now();
        this.resultado = resultado;
        this.tiempoDedicado = Duration.between(fechaInicio, fechaCompletada);
    }
    @Override
    public String toString() {
        return "Actividad: " + actividad.getDescripcion() + ", Completada en: " + fechaCompletada + ", Resultado: " + resultado;
    }
}

