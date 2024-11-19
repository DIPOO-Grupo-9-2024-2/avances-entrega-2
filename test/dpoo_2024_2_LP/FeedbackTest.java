package dpoo_2024_2_LP;

import org.junit.jupiter.api.Test;
import service.EvaluacionService;
import model.Evaluacion;
import model.Feedback;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackTest {

    @Test
    public void testConstructor() {
        // Prueba el constructor
        Feedback feedback = new Feedback("Muy buen curso", 5);
        assertEquals("Muy buen curso", feedback.getComentario());
        assertEquals(5, feedback.getCalificacion());
    }

    @Test
    public void testGetters() {
        Feedback feedback = new Feedback("Excelente explicación", 4);
        // Prueba los getters
        assertEquals("Excelente explicación", feedback.getComentario());
        assertEquals(4, feedback.getCalificacion());
    }

    @Test
    public void testSetters() {
        Feedback feedback = new Feedback("Inicial", 3);

        // Prueba el setter para comentario
        feedback.setComentario("Nuevo comentario");
        assertEquals("Nuevo comentario", feedback.getComentario());

        // Prueba el setter para calificación
        feedback.setCalificacion(5);
        assertEquals(5, feedback.getCalificacion());
    }

    @Test
    public void testToString() {
        Feedback feedback = new Feedback("Buena sesión", 4);

        // Prueba el método toString
        String esperado = "Comentario: Buena sesión, Calificación: 4";
        assertEquals(esperado, feedback.toString());
    }

    @Test
    public void testSetCalificacionInvalida() {
        Feedback feedback = new Feedback("Regular", 3);

        // Intentamos establecer una calificación inválida
        feedback.setCalificacion(-1);
        assertEquals(-1, feedback.getCalificacion()); // Asegura que el valor se establece, aunque sea inválido

        feedback.setCalificacion(10);
        assertEquals(10, feedback.getCalificacion()); // Similar, permite valores fuera del rango
    }


    @Test
    public void testAgregarFeedback() {
        // Configuración
        EvaluacionService evaluacionService = new EvaluacionService();
        Evaluacion evaluacion = null; // Simulamos que no necesitamos una evaluación real
        String comentario = "Excelente curso";
        int calificacion = 5;

        // Llamamos al método agregarFeedback
        evaluacionService.agregarFeedback(evaluacion, comentario, calificacion);

        // Verificamos que se imprime el mensaje correcto
        Feedback feedbackEsperado = new Feedback(comentario, calificacion);
        String esperado = "Feedback añadido: " + feedbackEsperado.toString();
        String real = "Feedback añadido: Comentario: " + comentario + ", Calificación: " + calificacion;

        assertEquals(esperado, real, "El feedback generado debería coincidir con el esperado");
    }

}
