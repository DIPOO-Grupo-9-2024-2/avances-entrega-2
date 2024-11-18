package dpoo_2024_2_LP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.QuizVerdaderoFalso;

import static org.junit.jupiter.api.Assertions.*;

public class QuizVerdaderoFalsoTest {

    private QuizVerdaderoFalso quiz;

    @BeforeEach
    public void setUp() {
        quiz = new QuizVerdaderoFalso(1, "¿El Java es un lenguaje de programación?", 
                                       "Evaluar conocimiento sobre Java", 10, 
                                       true, true);
    }

    @Test
    public void testEvaluarRespuestaCorrecta() {
        boolean respuestaUsuario = true;
        boolean resultado = quiz.evaluar(respuestaUsuario);

        assertTrue(resultado, "La respuesta correcta debe ser evaluada como correcta.");
    }

    @Test
    public void testEvaluarRespuestaIncorrecta() {
        boolean respuestaUsuario = false;
        boolean resultado = quiz.evaluar(respuestaUsuario);

        assertFalse(resultado, "La respuesta incorrecta debe ser evaluada como incorrecta.");
    }

    @Test
    public void testCompletarQuiz() {
        boolean resultado = quiz.completar();

        assertTrue(resultado, "El método completar() debe devolver true.");


    }

    @Test
    public void testSetRespuestaCorrecta() {
        quiz.setRespuestaCorrecta(false);

        assertFalse(quiz.isRespuestaCorrecta(), "El setter debe actualizar la respuesta correcta.");
    }

    @Test
    public void testGettersYSetters() {
        assertEquals("¿El Java es un lenguaje de programación?", quiz.getDescripcion(), 
                     "La descripción debe coincidir con la proporcionada.");
        assertEquals("Evaluar conocimiento sobre Java", quiz.getObjetivo(), 
                     "El objetivo debe coincidir con el proporcionado.");
        assertEquals(10, quiz.getDuracionEsperada(), "La duración esperada debe ser 10 minutos.");
        assertTrue(quiz.isEsObligatoria(), "El quiz debe ser obligatorio.");
    }
}

