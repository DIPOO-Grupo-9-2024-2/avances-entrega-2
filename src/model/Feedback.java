package model;

public class Feedback {
    private String comentario;
    private int calificacion; 

    public Feedback(String comentario, int calificacion) {
        this.comentario = comentario;
        this.calificacion = calificacion;
    }


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
