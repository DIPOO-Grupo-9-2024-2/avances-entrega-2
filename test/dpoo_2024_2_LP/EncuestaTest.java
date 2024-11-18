package dpoo_2024_2_LP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Encuesta;

import static org.junit.jupiter.api.Assertions.*;

public class EncuestaTest {

    private Encuesta encuesta;

    @BeforeEach
    public void setUp() {
        // Crear una encuesta de prueba
        encuesta = new Encuesta(1, "Encuesta sobre Java", "Evaluar conocimientos de Java", 60, "¿Qué es Java?", true);
    }

    @Test
    public void testCompletarEncuesta() {
        // Llamar al método completar()
        boolean resultado = encuesta.completar();

        // Verificar que el resultado de completar() sea true
        assertTrue(resultado, "La encuesta debe completarse correctamente.");

        // Verificar que el resultado de la actividad sea "Encuesta completada"
        assertEquals("Encuesta completada", encuesta.getResultado(), "El resultado debe ser 'Encuesta completada'.");

        // Verificar que las preguntas abiertas estén correctamente configuradas
        assertEquals("¿Qué es Java?", encuesta.getPreguntasAbiertas(), "Las preguntas abiertas deben coincidir.");

        // Verificar que la descripción de la encuesta sea la esperada
        assertEquals("Encuesta sobre Java", encuesta.getDescripcion(), "La descripción de la encuesta debe coincidir.");
    }

    @Test
    public void testSetPreguntasAbiertas() {
        // Cambiar las preguntas abiertas utilizando el setter
        encuesta.setPreguntasAbiertas("¿Qué es la programación orientada a objetos?");

        // Verificar que el valor de preguntasAbiertas ha sido correctamente actualizado
        assertEquals("¿Qué es la programación orientada a objetos?", encuesta.getPreguntasAbiertas(), "El setter debe actualizar las preguntas abiertas correctamente.");
    }
}

