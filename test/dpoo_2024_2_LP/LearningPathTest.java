package dpoo_2024_2_LP;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.LearningPath;
import model.Progreso;
import model.QuizVerdaderoFalso;
import model.Actividad;
import model.HistorialActividad;
import service.LearningPathService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class LearningPathTest {

    private LearningPath learningPath;
    private QuizVerdaderoFalso quizObligatorio;
    private QuizVerdaderoFalso quizOpcional;
    private LearningPathService learningPathService;

    @BeforeEach
    public void setUp() {
        // Configuración inicial
        learningPath = new LearningPath(1, "Aprender Java Básico", "Un camino de aprendizaje para principiantes.", "Básico", 120, 4.8, "1.0")
;
        learningPathService = new LearningPathService();  // Crear una instancia de LearningPathService

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
    public void testAgregarActividad() {
        assertEquals(2, learningPath.getActividades().size());
        assertTrue(learningPath.getActividades().contains(quizObligatorio));
        assertTrue(learningPath.getActividades().contains(quizOpcional));
    }

    @Test
    public void testIniciarActividad() {
        learningPath.iniciarActividad(quizObligatorio);

        // Verificar que la actividad haya sido añadida al historial
        assertEquals(1, learningPath.getHistorialActividades().size());
        assertEquals(quizObligatorio, learningPath.getHistorialActividades().get(0).getActividad());
        assertNotNull(learningPath.getHistorialActividades().get(0).getFechaInicio());
        assertNull(learningPath.getHistorialActividades().get(0).getFechaCompletada());
    }

    @Test
    public void testCompletarActividad() {
        // Iniciar y completar la actividad
        learningPath.iniciarActividad(quizObligatorio);
        learningPath.completarActividad(quizObligatorio, "Correcto");

        // Verificar que la actividad fue completada
        assertEquals(1, learningPath.getHistorialActividades().size());
        assertEquals("Correcto", learningPath.getHistorialActividades().get(0).getResultado());
        assertNotNull(learningPath.getHistorialActividades().get(0).getFechaCompletada());
    }

    @Test
    public void testResolverQuizVerdaderoFalso_Correcto() {
        learningPath.iniciarActividad(quizObligatorio);
        boolean resultado = learningPath.resolverQuizVerdaderoFalso(quizObligatorio, true);

        assertTrue(resultado);
        assertEquals("Correcto", learningPath.getHistorialActividades().get(0).getResultado());
    }

    @Test
    public void testResolverQuizVerdaderoFalso_Incorrecto() {
        learningPath.iniciarActividad(quizObligatorio);
        boolean resultado = learningPath.resolverQuizVerdaderoFalso(quizObligatorio, false);

        assertFalse(resultado);
        assertEquals("Incorrecto", learningPath.getHistorialActividades().get(0).getResultado());
    }

    @Test
    public void testCalcularProgreso() {
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
    public void testSinActividadesObligatorias() {
        LearningPath pathSinObligatorias = new LearningPath(
        	    2,                                  
        	    "Camino sin obligatorias",          
        	    "Un test adicional.",               
        	    "Intermedio",                       
        	    90,                                
        	    4.2,                                
        	    "1.0"                               
        	);

        pathSinObligatorias.agregarActividad(quizOpcional);

        // Progreso debería ser 100% porque no hay actividades obligatorias
        assertEquals(100, pathSinObligatorias.calcularProgreso());
    }

    @Test
    public void testSetActividades() {
        List<Actividad> nuevasActividades = new ArrayList<>();
        nuevasActividades.add(quizObligatorio);
        nuevasActividades.add(quizOpcional);
        learningPath.setActividades(nuevasActividades);

        assertEquals(2, learningPath.getActividades().size());
        assertTrue(learningPath.getActividades().contains(quizObligatorio));
        assertTrue(learningPath.getActividades().contains(quizOpcional));
    }

    @Test
    public void testGetProgreso() {
        // Caso inicial: sin actividades completadas
        assertEquals(0, learningPath.getProgreso());
    }

    @Test
    public void testSetProgreso() {
        learningPath.setProgreso(50);
        assertEquals(50, learningPath.getProgreso());
    }

    @Test
    public void testSetHistorialActividades() {
        // Crear un historial con una actividad
        LocalDateTime fechaInicio = LocalDateTime.now();
        HistorialActividad historial = new HistorialActividad(quizObligatorio, fechaInicio);
        List<HistorialActividad> nuevoHistorial = new ArrayList<>();
        nuevoHistorial.add(historial);

        // Establecer el nuevo historial de actividades
        learningPath.setHistorialActividades(nuevoHistorial);

        // Verificar que se ha asignado correctamente
        assertEquals(1, learningPath.getHistorialActividades().size());
        assertEquals(historial, learningPath.getHistorialActividades().get(0));
    }

    // Nuevas pruebas para LearningPathService

    @Test
    public void testAgregarActividadService() {
        learningPathService.agregarActividad(learningPath, quizObligatorio);
        assertEquals(3, learningPath.getActividades().size());  // Debe agregar una actividad más
    }

    @Test
    public void testActualizarProgreso() {
        learningPathService.actualizarProgreso(learningPath);
        // Se espera que el progreso esté actualizado, pero por ahora se valida visualmente
        assertNotNull(learningPathService.obtenerProgreso());
    }

    @Test
    public void testRegistrarActividadCompletada() {
        learningPathService.registrarActividadCompletada(learningPath, quizObligatorio, "Correcto");
        assertEquals(1, learningPath.getHistorialActividades().size());  // Debe agregar al historial
    }

    @Test
    public void testObtenerProgreso() {
        // Crear una instancia de Progreso para el LearningPath
        Progreso progreso = new Progreso(3, 0); // Suponiendo que el LearningPath tiene 3 actividades, y ninguna completada al principio.
        
        // Inicializamos el progreso en el LearningPathService
        learningPathService.agregarActividad(learningPath, quizObligatorio);
        learningPathService.actualizarProgreso(learningPath);
        
        // Agregar una actividad completada
        progreso.completarActividad(); // Marcamos una actividad como completada

        // Verificamos que el progreso es 33% si solo una de tres actividades está completada
        assertEquals(33, progreso.getPorcentajeProgreso());
    }

    @Test
    public void testEnviarNotificacionPendiente() {
        learningPathService.enviarNotificacionPendiente(learningPath);
        // Verifica visualmente que la notificación ha sido enviada
    }


  
    @Test
    public void testCalcularTasasExitoFracaso() {
        // Crear historial de actividades con resultados
        HistorialActividad historial1 = new HistorialActividad(quizObligatorio, LocalDateTime.now());
        historial1.setResultado("Aprobado");  // Suponiendo que "Aprobado" indica éxito
        
        HistorialActividad historial2 = new HistorialActividad(quizOpcional, LocalDateTime.now());
        historial2.setResultado("Reprobado"); // "Reprobado" indica fracaso

        // Agregar los elementos al historial de actividades del LearningPath
        List<HistorialActividad> historialActividades = learningPath.getHistorialActividades();
        historialActividades.add(historial1);
        historialActividades.add(historial2);

        // Calcular tasas de éxito y fracaso
        learningPathService.calcularTasasExitoFracaso(learningPath);

        // Verificar visualmente si la tasa de éxito y fracaso se calcularon correctamente
        assertTrue(historialActividades.size() > 0);  // Verifica que el historial contiene actividades
        // Se espera que el servicio calcule las tasas correctamente internamente
    }


    @Test
    public void testSetId() {
        learningPath.setId(3);
        assertEquals(3, learningPath.getId());
    }

    @Test
    public void testGetId() {
        assertEquals(1, learningPath.getId());
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Aprender Java Básico", learningPath.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        learningPath.setTitulo("Aprender Java Avanzado");
        assertEquals("Aprender Java Avanzado", learningPath.getTitulo());
    }
}




