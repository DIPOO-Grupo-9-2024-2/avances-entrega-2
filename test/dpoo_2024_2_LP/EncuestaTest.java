package dpoo_2024_2_LP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Encuesta;

import static org.junit.jupiter.api.Assertions.*;

public class EncuestaTest {

    private Encuesta encuesta;

    @BeforeEach
    public void setUp() {

        encuesta = new Encuesta(1, "Encuesta sobre Java", "Evaluar conocimientos de Java", 60, "¿Qué es Java?", true);
    }

    @Test
    public void testCompletarEncuesta() {
        boolean resultado = encuesta.completar();
        assertTrue(resultado, "La encuesta debe completarse correctamente.");
        assertEquals("Encuesta completada", encuesta.getResultado(), "El resultado debe ser 'Encuesta completada'.");
        assertEquals("¿Qué es Java?", encuesta.getPreguntasAbiertas(), "Las preguntas abiertas deben coincidir.");
        assertEquals("Encuesta sobre Java", encuesta.getDescripcion(), "La descripción de la encuesta debe coincidir.");
    }

    @Test
    public void testSetPreguntasAbiertas() {

        encuesta.setPreguntasAbiertas("¿Qué es la programación orientada a objetos?");


        assertEquals("¿Qué es la programación orientada a objetos?", encuesta.getPreguntasAbiertas(), "El setter debe actualizar las preguntas abiertas correctamente.");
    }
}

