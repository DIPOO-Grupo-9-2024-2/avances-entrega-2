package dpoo_2024_2_LP;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import model.Calificacion;
import model.PreguntaCerrada;
import model.Quiz;
import model.RespuestaExamen;
public class QuizTest {
    private Quiz quiz;

    @BeforeEach
    public void setUp() {
        quiz = new Quiz(1, "Quiz de opción múltiple", "Objetivo del quiz", 30, "Preguntas de prueba", 7, 5, true);
    }

    @Test
    public void testCalificarAprobado() {
    	PreguntaCerrada pregunta1 = new PreguntaCerrada(
                "¿Cuál es la capital de Francia?", 
                Arrays.asList("Madrid", "Berlín", "París", "Lisboa"), 
                "París"
        );
    	PreguntaCerrada pregunta2 = new PreguntaCerrada(
                "¿Cuál es 2 + 2?", 
                Arrays.asList("3", "4", "5", "6"), 
                "4"
        );

        List<RespuestaExamen> respuestas = Arrays.asList(
                new RespuestaExamen(pregunta1, "París"),
                new RespuestaExamen(pregunta2, "4"),
                new RespuestaExamen(pregunta1, "París"),
                new RespuestaExamen(pregunta2, "4"),
                new RespuestaExamen(pregunta1, "París")
        );

        Calificacion calificacion = quiz.calificar(respuestas);
        assertEquals("Examen aprobado", calificacion.getFeedback(), "El resultado debería ser 'Examen aprobado'");
        assertTrue(calificacion.getNota() >= 7, "El puntaje debería ser suficiente para aprobar");
    }

    @Test
    public void testCalificarNoAprobado() {
    	PreguntaCerrada pregunta1 = new PreguntaCerrada(
                "¿Cuál es la capital de Francia?", 
                Arrays.asList("Madrid", "Berlín", "París", "Lisboa"), 
                "París"
        );
    	PreguntaCerrada pregunta2 = new PreguntaCerrada(
                "¿Cuál es 2 + 2?", 
                Arrays.asList("3", "4", "5", "6"), 
                "4"
        );

        List<RespuestaExamen> respuestas = Arrays.asList(
                new RespuestaExamen(pregunta1, "Madrid"),
                new RespuestaExamen(pregunta2, "3"),
                new RespuestaExamen(pregunta1, "Berlín"),
                new RespuestaExamen(pregunta2, "5"),
                new RespuestaExamen(pregunta1, "Lisboa")
        );

        Calificacion calificacion = quiz.calificar(respuestas);
        assertEquals("Examen no aprobado", calificacion.getFeedback(), "El resultado debería ser 'Examen no aprobado'");
        assertTrue(calificacion.getNota() < 7, "El puntaje debería ser insuficiente para aprobar");
    }

    @Test
    public void testCompletar() {
        assertTrue(quiz.completar(), "El quiz debería marcarse como completado");
    }
}

//Revisar
