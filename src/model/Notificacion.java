package model;

import java.time.LocalDateTime;

public class Notificacion {
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private boolean leida;

    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
        this.fechaEnvio = LocalDateTime.now();
        this.leida = false;
    }

    // Marcar notificación como leída
    public void marcarComoLeida() {
        this.leida = true;
    }

    // Getters y setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    @Override
    public String toString() {
        return "Notificación: " + mensaje + ", Enviada el: " + fechaEnvio + ", Leída: " + leida;
    }
}
