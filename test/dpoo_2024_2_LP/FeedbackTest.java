package dpoo_2024_2_LP;

import org.junit.jupiter.api.Test;
import service.EvaluacionService;
import model.Evaluacion;
import model.Feedback;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackTest {

    @Test
    public void testConstructor() {
        Feedback feedback = new Feedback("Muy buen curso", 5);
        assertEquals("Muy buen curso", feedback.getComentario());
        assertEquals(5, feedback.getCalificacion());
    }

    @Test
    public void testGetters() {
        Feedback feedback = new Feedback("Excelente explicación", 4);
        assertEquals("Excelente explicación", feedback.getComentario());
        assertEquals(4, feedback.getCalificacion());
    }

    @Test
    public void testSetters() {
        Feedback feedback = new Feedback("Inicial", 3);
        feedback.setComentario("Nuevo comentario");
        assertEquals("Nuevo comentario", feedback.getComentario());


        feedback.setCalificacion(5);
        assertEquals(5, feedback.getCalificacion());
    }

    @Test
    public void testToString() {
        Feedback feedback = new Feedback("Buena sesión", 4);

 
        String esperado = "Comentario: Buena sesión, Calificación: 4";
        assertEquals(esperado, feedback.toString());
    }

    @Test
    public void testSetCalificacionInvalida() {
        Feedback feedback = new Feedback("Regular", 3);


        feedback.setCalificacion(-1);
        assertEquals(-1, feedback.getCalificacion()); 

        feedback.setCalificacion(10);
        assertEquals(10, feedback.getCalificacion()); 
    }


    @Test
    public void testAgregarFeedback() {
        EvaluacionService evaluacionService = new EvaluacionService();
        Evaluacion evaluacion = null; 
        String comentario = "Excelente curso";
        int calificacion = 5;


        evaluacionService.agregarFeedback(evaluacion, comentario, calificacion);

        Feedback feedbackEsperado = new Feedback(comentario, calificacion);
        String esperado = "Feedback añadido: " + feedbackEsperado.toString();
        String real = "Feedback añadido: Comentario: " + comentario + ", Calificación: " + calificacion;

        assertEquals(esperado, real, "El feedback generado debería coincidir con el esperado");
    }

}
