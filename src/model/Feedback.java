package model;

public class Feedback {
    private String comentario;
    private int calificacion; // Rango de 1 a 5, por ejemplo

    public Feedback(String comentario, int calificacion) {
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    // Getters y setters
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Comentario: " + comentario + ", Calificación: " + calificacion;
    }
}
