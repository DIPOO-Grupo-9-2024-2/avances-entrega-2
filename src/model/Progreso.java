package model;
import model.Calificacion;

public class Progreso {
    private int totalActividades;
    private int actividadesCompletadas;
    private int porcentajeProgreso;
    private Calificacion calificacion;

    public Progreso(int totalActividades, int actividadesCompletadas) {
        this.totalActividades = totalActividades;
        this.actividadesCompletadas = actividadesCompletadas;
        calcularProgreso();
    }

    public void calcularProgreso() {
        if (totalActividades > 0) {
            this.porcentajeProgreso = (actividadesCompletadas * 100) / totalActividades;
        } else {
            this.porcentajeProgreso = 0;
        }
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

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

