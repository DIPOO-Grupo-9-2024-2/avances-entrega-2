package dpoo_2024_2_LP;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Calificacion;

class CalificacionTest {

    private Calificacion calificacion;

    @BeforeEach
    public void setUp() {
    
        calificacion = new Calificacion(8, "Aprobado");
    }

    @Test
    public void testGetNota() {
        assertEquals(8, calificacion.getNota(), "La nota debería ser 8");
    }

    @Test
    public void testSetNota() {
        calificacion.setNota(9);
        assertEquals(9, calificacion.getNota(), "La nota debería ser 9 después de modificarla");
    }

    @Test
    public void testGetFeedback() {
        assertEquals("Aprobado", calificacion.getFeedback(), "El feedback debería ser 'Aprobado'");
    }

    @Test
    public void testSetFeedback() {
        calificacion.setFeedback("Excelente");
        assertEquals("Excelente", calificacion.getFeedback(), "El feedback debería ser 'Excelente' después de modificarlo");
    }

    @Test
    public void testToString() {
        String expected = "Nota: 8, Feedback: Aprobado";
        assertEquals(expected, calificacion.toString(), "El método toString debería retornar 'Nota: 8, Feedback: Aprobado'");
    }

    @Test
    public void testCalificarEvaluacion() {

        Calificacion resultado = new Calificacion(8, "Aprobado");


        assertNotNull(resultado, "La calificación no debe ser nula");
        assertEquals(8, resultado.getNota(), "La nota de la calificación debería ser 8");
        assertEquals("Aprobado", resultado.getFeedback(), "El feedback de la calificación debería ser 'Aprobado'");
    }
}

