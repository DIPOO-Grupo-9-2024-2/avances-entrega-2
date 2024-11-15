package service;

import model.Evaluacion;
import model.Feedback;
import model.RespuestaExamen;
import model.Calificacion;

import java.util.List;

public class EvaluacionService {

    // Método para calificar una evaluación
    public Calificacion calificarEvaluacion(Evaluacion evaluacion, List<RespuestaExamen> respuestas) {
        return evaluacion.calificar(respuestas);
    }

    // Método para agregar feedback a una evaluación
    public void agregarFeedback(Evaluacion evaluacion, String comentario, int calificacion) {
        Feedback feedback = new Feedback(comentario, calificacion);
        // Aquí podríamos almacenar o asociar el feedback a la evaluación
        System.out.println("Feedback añadido: " + feedback);
    }
}
