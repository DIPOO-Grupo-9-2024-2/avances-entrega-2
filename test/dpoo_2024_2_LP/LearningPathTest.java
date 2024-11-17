package dpoo_2024_2_LP;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.LearningPath;
import model.QuizVerdaderoFalso;

class LearningPathTest {

    private LearningPath learningPath;
    private QuizVerdaderoFalso quizObligatorio;
    private QuizVerdaderoFalso quizOpcional;

    @BeforeEach
    void setUp() {
        // Configuración inicial
        learningPath = new LearningPath(1, "Aprender Java Básico", "Un camino de aprendizaje para principiantes.");

        // Crear actividades para pruebas
        quizObligatorio = new QuizVerdaderoFalso(
            1, "¿Java es un lenguaje de programación orientado a objetos?",
            "Evaluar conocimientos básicos de Java", 10, true, true
        );

        quizOpcional = new QuizVerdaderoFalso(
            2, "¿Java fue desarrollado por Microsoft?",
            "Evaluar conocimientos generales de historia de Java", 5, false, false
        );

        learningPath.agregarActividad(quizObligatorio);
        learningPath.agregarActividad(quizOpcional);
    }

    @Test
    void testAgregarActividad() {
        assertEquals(2, learningPath.getActividades().size());
        assertTrue(learningPath.getActividades().contains(quizObligatorio));
        assertTrue(learningPath.getActividades().contains(quizOpcional));
    }

    @Test
    void testIniciarActividad() {
        learningPath.iniciarActividad(quizObligatorio);

        // Verificar que la actividad haya sido añadida al historial
        assertEquals(1, learningPath.getHistorialActividades().size());
        assertEquals(quizObligatorio, learningPath.getHistorialActividades().get(0).getActividad());
        assertNotNull(learningPath.getHistorialActividades().get(0).getFechaInicio());
        assertNull(learningPath.getHistorialActividades().get(0).getFechaCompletada());
    }

    @Test
    void testCompletarActividad() {
        // Iniciar y completar la actividad
        learningPath.iniciarActividad(quizObligatorio);
        learningPath.completarActividad(quizObligatorio, "Correcto");

        // Verificar que la actividad fue completada
        assertEquals(1, learningPath.getHistorialActividades().size());
        assertEquals("Correcto", learningPath.getHistorialActividades().get(0).getResultado());
        assertNotNull(learningPath.getHistorialActividades().get(0).getFechaCompletada());
    }

    @Test
    void testResolverQuizVerdaderoFalso_Correcto() {
        learningPath.iniciarActividad(quizObligatorio);
        boolean resultado = learningPath.resolverQuizVerdaderoFalso(quizObligatorio, true);

        assertTrue(resultado);
        assertEquals("Correcto", learningPath.getHistorialActividades().get(0).getResultado());
    }

    @Test
    void testResolverQuizVerdaderoFalso_Incorrecto() {
        learningPath.iniciarActividad(quizObligatorio);
        boolean resultado = learningPath.resolverQuizVerdaderoFalso(quizObligatorio, false);

        assertFalse(resultado);
        assertEquals("Incorrecto", learningPath.getHistorialActividades().get(0).getResultado());
    }

    @Test
    void testCalcularProgreso() {
        // Caso inicial: sin actividades completadas
        assertEquals(0, learningPath.calcularProgreso());

        // Completar la actividad obligatoria
        learningPath.iniciarActividad(quizObligatorio);
        learningPath.completarActividad(quizObligatorio, "Correcto");
        assertEquals(100, learningPath.calcularProgreso());

        // Agregar otra actividad obligatoria y no completarla
        QuizVerdaderoFalso otroQuiz = new QuizVerdaderoFalso(
            3, "¿Es posible usar herencia en Java?",
            "Evaluar conocimientos intermedios", 15, true, true
        );
        learningPath.agregarActividad(otroQuiz);
        assertEquals(50, learningPath.calcularProgreso()); // Progreso debe ser 50%
    }

    @Test
    void testSinActividadesObligatorias() {
        LearningPath pathSinObligatorias = new LearningPath(2, "Camino sin obligatorias", "Un test adicional.");
        pathSinObligatorias.agregarActividad(quizOpcional);

        // Progreso debería ser 100% porque no hay actividades obligatorias
        assertEquals(100, pathSinObligatorias.calcularProgreso());
    }
}



