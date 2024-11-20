package model;

import java.util.List;

public abstract class Evaluacion extends Actividad {
    private String preguntas;
    private int calificacionMinima;   
    private int numPreguntas; 

    public Evaluacion(int id, String descripcion, String objetivo, int duracionEsperada, String preguntas, int calificacionMinima, int numPreguntas, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        this.preguntas = preguntas;
        this.calificacionMinima = calificacionMinima;
        this.numPreguntas = numPreguntas;
    }


    public abstract Calificacion calificar(List<RespuestaExamen> respuestas);

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public int getCalificacionMinima() {
        return calificacionMinima;
    }

    public void setCalificacionMinima(int calificacionMinima) {
        this.calificacionMinima = calificacionMinima;
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }
}


