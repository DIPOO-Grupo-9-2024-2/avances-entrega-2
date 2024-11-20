package model;

public class Calificacion {
    private int nota;     
    private String feedback; 


    public Calificacion(int nota, String feedback) {
        this.nota = nota;
        this.feedback = feedback;
    }

 
    public int getCalificacion() {
        return nota;
    }


    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Nota: " + nota + ", Feedback: " + feedback;
    }
}

