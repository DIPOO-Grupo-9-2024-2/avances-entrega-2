package model;
import model.Calificacion;

public class Progreso {
    private int totalActividades;
    private int actividadesCompletadas;
    private int porcentajeProgreso;
    private Calificacion calificacion; // Nuevo atributo

    public Progreso(int totalActividades, int actividadesCompletadas) {
        this.totalActividades = totalActividades;
        this.actividadesCompletadas = actividadesCompletadas;
        calcularProgreso();
    }

    // Método para calcular el progreso en porcentaje
    public void calcularProgreso() {
        if (totalActividades > 0) {
            this.porcentajeProgreso = (actividadesCompletadas * 100) / totalActividades;
        } else {
            this.porcentajeProgreso = 0;
        }
    }

    // Método para asignar una calificación
    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    // Método para obtener la calificación
    public Calificacion getCalificacion() {
        return calificacion;
    }

    // Método para marcar una actividad como completada
    public void completarActividad() {
        actividadesCompletadas++;
        calcularProgreso();
    }

    // Getters y setters
    public int getTotalActividades() {
        return totalActividades;
    }

    public void setTotalActividades(int totalActividades) {
        this.totalActividades = totalActividades;
    }

    public int getActividadesCompletadas() {
        return actividadesCompletadas;
    }

    public void setActividadesCompletadas(int actividadesCompletadas) {
        this.actividadesCompletadas = actividadesCompletadas;
    }

    public int getPorcentajeProgreso() {
        return porcentajeProgreso;
    }

    public void setPorcentajeProgreso(int porcentajeProgreso) {
        this.porcentajeProgreso = porcentajeProgreso;
    }
}

