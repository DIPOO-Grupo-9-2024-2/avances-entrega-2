package model;

import java.util.List;

public abstract  class Examen extends Evaluacion {

    String resultado;
    int numPreguntas;

    public Examen(int id, String descripcion, String objetivo, int duracionEsperada, String preguntas, int calificacionMinima, int numPreguntas, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, preguntas, calificacionMinima, numPreguntas, esObligatoria);
    }

    @Override
    public Calificacion calificar(List<RespuestaExamen> respuestas) {
        int correctas = 0;

        // Contar respuestas correctas
        for (RespuestaExamen respuesta : respuestas) {
            if (respuesta.isCorrecta()) {
                correctas++;
            }
        }

        // Calcular calificación basada en respuestas correctas
        int puntaje = (int) correctas / numPreguntas * 10;
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
        this.establecerResultado("Examen completado con éxito");
        return true;
    }
}



