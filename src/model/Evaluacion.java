package model;

import java.util.List;

public abstract class Evaluacion extends Actividad {
    private String preguntas;   // Lista de preguntas asociadas a la evaluación
    private int calificacionMinima;   // Calificación mínima requerida para aprobar la evaluación
    private int numPreguntas; // Número de preguntas de la evaluación

    public Evaluacion(int id, String descripcion, String objetivo, int duracionEsperada, String preguntas, int calificacionMinima, int numPreguntas, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        this.preguntas = preguntas;
        this.calificacionMinima = calificacionMinima;
        this.numPreguntas = numPreguntas;
    }

    // Método abstracto que las subclases deben implementar para calificar la evaluación
    public abstract Calificacion calificar(List<RespuestaExamen> respuestas);

    // Getters y setters para acceder a los atributos
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


