package dpoo_2024_2_LP;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

import model.Calificacion;
import model.Examen;
import model.ExamenConcreto;
import model.RespuestaExamen;
import model.PreguntaAbierta;

public class ExamentTest {
    private Examen examen;

    @BeforeEach
    public void setUp() {
        examen = new ExamenConcreto(1, "Examen de prueba", "Prueba de conocimiento", 60, "Lista de preguntas", 6, 10, true);
    }

    @Test
    public void testCalificarAprobado() {
        PreguntaAbierta preguntaPrueba = new PreguntaAbierta("¿Es Java un lenguaje de programación?", "Sí", "Es un lenguaje orientado a objetos");
        List<RespuestaExamen> respuestas = Arrays.asList(
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "Sí")
        );

        Calificacion Calificacion = examen.calificar(respuestas);
        assertEquals("Examen aprobado", Calificacion.getFeedback(), "El resultado debería indicar que el examen fue aprobado");
        assertTrue(Calificacion.getNota() >= 6, "El puntaje es suficiente para aprobar");
    }

    @Test
    
    public void testCalificarNoAprobado() {
    	PreguntaAbierta preguntaPrueba = new PreguntaAbierta("¿Es Java un lenguaje de programación?", "Sí", "Es un lenguaje orientado a objetos");
        List<RespuestaExamen> respuestas = Arrays.asList(
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "Sí"),
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "No"),
                new RespuestaExamen(preguntaPrueba, "No")
        );

        Calificacion Calificacion = examen.calificar(respuestas);
        assertEquals("Examen no aprobado", Calificacion.getFeedback(), "El resultado debería indicar que el examen no fue aprobado");
        assertTrue(Calificacion.getNota() < 6, "El puntaje debería es para aprobar");
    }

    @Test
    public void testCompletar() {
        assertTrue(examen.completar(), "El examen debería marcarse como completado");
    	}
}
