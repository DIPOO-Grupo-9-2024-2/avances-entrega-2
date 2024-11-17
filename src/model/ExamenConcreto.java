package model;

public class ExamenConcreto extends Examen {

    public ExamenConcreto(int id, String descripcion, String objetivo, int duracionEsperada, String preguntas, int calificacionMinima, int numPreguntas, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, preguntas, calificacionMinima, numPreguntas, esObligatoria);
    }
}