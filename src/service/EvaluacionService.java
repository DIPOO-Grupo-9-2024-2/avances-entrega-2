package service;

import model.Evaluacion;
import model.Feedback;
import model.RespuestaExamen;
import model.Calificacion;

import java.util.List;

public class EvaluacionService {


    public Calificacion calificarEvaluacion(Evaluacion evaluacion, List<RespuestaExamen> respuestas) {
        return evaluacion.calificar(respuestas);
    }


    public void agregarFeedback(Evaluacion evaluacion, String comentario, int calificacion) {
        Feedback feedback = new Feedback(comentario, calificacion);

    }
}
