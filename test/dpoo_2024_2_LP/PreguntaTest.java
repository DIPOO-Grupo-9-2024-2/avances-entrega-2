package dpoo_2024_2_LP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Pregunta;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class PreguntaTest {

    private Pregunta pregunta;
    private List<String> opciones;

    @BeforeEach
    public void setUp() {
        // Configuración inicial para cada test
        opciones = Arrays.asList("Opción 1", "Opción 2", "Opción 3", "Opción 4");
        pregunta = new Pregunta("¿Cuál es la capital de Francia?", opciones, "Opción 1", "La capital de Francia es París.");
    }

    @Test
    public void testConstructor() {
        // Verificar que el constructor inicializa correctamente los atributos
        assertEquals("¿Cuál es la capital de Francia?", pregunta.getTexto(), "El texto de la pregunta debe ser correcto.");
        assertEquals(opciones, pregunta.getOpciones(), "Las opciones deben coincidir con las proporcionadas.");
        assertEquals("Opción 1", pregunta.getRespuestaCorrecta(), "La respuesta correcta debe ser la opción 1.");
        assertEquals("La capital de Francia es París.", pregunta.getExplicacion(), "La explicación debe coincidir con la proporcionada.");
    }

    @Test
    public void testEsCorrectaRespuestaCorrecta() {
        // Verificar que la respuesta correcta es reconocida como correcta
        assertTrue(pregunta.esCorrecta("Opción 1"), "La respuesta correcta debería ser reconocida como correcta.");
    }

    @Test
    public void testEsCorrectaRespuestaIncorrecta() {
        // Verificar que una respuesta incorrecta no es aceptada
        assertFalse(pregunta.esCorrecta("Opción 2"), "La respuesta incorrecta debería ser reconocida como incorrecta.");
    }

    @Test
    public void testSetTexto() {
        // Cambiar el texto de la pregunta y verificar que se actualiza correctamente
        pregunta.setTexto("¿Cuál es la capital de España?");
        assertEquals("¿Cuál es la capital de España?", pregunta.getTexto(), "El texto de la pregunta debe ser actualizado.");
    }

    @Test
    public void testSetOpciones() {
        // Cambiar las opciones y verificar que se actualizan correctamente
        List<String> nuevasOpciones = Arrays.asList("Madrid", "Barcelona", "Valencia");
        pregunta.setOpciones(nuevasOpciones);
        assertEquals(nuevasOpciones, pregunta.getOpciones(), "Las opciones deben ser actualizadas.");
    }

    @Test
    public void testSetRespuestaCorrecta() {
        // Cambiar la respuesta correcta y verificar que se actualiza correctamente
        pregunta.setRespuestaCorrecta("Madrid");
        assertEquals("Madrid", pregunta.getRespuestaCorrecta(), "La respuesta correcta debe ser actualizada.");
    }

    @Test
    public void testSetExplicacion() {
        // Cambiar la explicación y verificar que se actualiza correctamente
        pregunta.setExplicacion("La capital de España es Madrid.");
        assertEquals("La capital de España es Madrid.", pregunta.getExplicacion(), "La explicación debe ser actualizada.");
    }
}
