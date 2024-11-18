package model;

import java.util.List;

public class Quiz extends Evaluacion {

    int numPreguntas;
    String resultado;

    public Quiz(int id, String descripcion, String objetivo, int duracionEsperada, String preguntas, int calificacionMinima, int numPreguntas, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, preguntas, calificacionMinima, numPreguntas, esObligatoria);
    }

    @Override
    public Calificacion calificar(List<RespuestaExamen> respuestas) {
        int correctas = 0;

        // Contar respuestas correctas
        for (RespuestaExamen respuesta : respuestas) {
            if (respuesta.getPregunta() instanceof PreguntaAbierta) {

            }
            if (respuesta.isCorrecta()) {
                correctas++;
            }
        }

        // Calcular el puntaje basado en respuestas correctas
        int puntaje = (int) ((correctas * 10) / getNumPreguntas());
        boolean aprobado = puntaje >= getCalificacionMinima();
        if (aprobado) {
            resultado = ("Examen aprobado");
        } else {
            resultado = ("Examen no aprobado");
        }
        return new Calificacion(puntaje, resultado);
    }

    @Override
    public boolean completar() {
        this.marcarCompletada();
        this.establecerResultado("Quiz completado con éxito");
        return true;
    }
}




