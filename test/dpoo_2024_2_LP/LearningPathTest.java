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

        learningPath = new LearningPath(1, "Aprender Java Básico", "Un camino de aprendizaje para principiantes.", "Básico", 120, 4.8, "1.0")
;
        learningPathService = new LearningPathService();  
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

        assertEquals(1, learningPath.getHistorialActividades().size());
        assertEquals(quizObligatorio, learningPath.getHistorialActividades().get(0).getActividad());
        assertNotNull(learningPath.getHistorialActividades().get(0).getFechaInicio());
        assertNull(learningPath.getHistorialActividades().get(0).getFechaCompletada());
    }

    @Test
    public void testCompletarActividad() {

        learningPath.iniciarActividad(quizObligatorio);
        learningPath.completarActividad(quizObligatorio, "Correcto");


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

        assertEquals(0, learningPath.calcularProgreso());


        learningPath.iniciarActividad(quizObligatorio);
        learningPath.completarActividad(quizObligatorio, "Correcto");
        assertEquals(100, learningPath.calcularProgreso());

        QuizVerdaderoFalso otroQuiz = new QuizVerdaderoFalso(
            3, "¿Es posible usar herencia en Java?",
            "Evaluar conocimientos intermedios", 15, true, true
        );
        learningPath.agregarActividad(otroQuiz);
        assertEquals(50, learningPath.calcularProgreso()); 
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

        assertEquals(0, learningPath.getProgreso());
    }

    @Test
    public void testSetProgreso() {
        learningPath.setProgreso(50);
        assertEquals(50, learningPath.getProgreso());
    }

    @Test
    public void testSetHistorialActividades() {

        LocalDateTime fechaInicio = LocalDateTime.now();
        HistorialActividad historial = new HistorialActividad(quizObligatorio, fechaInicio);
        List<HistorialActividad> nuevoHistorial = new ArrayList<>();
        nuevoHistorial.add(historial);


        learningPath.setHistorialActividades(nuevoHistorial);


        assertEquals(1, learningPath.getHistorialActividades().size());
        assertEquals(historial, learningPath.getHistorialActividades().get(0));
    }



    @Test
    public void testAgregarActividadService() {
        learningPathService.agregarActividad(learningPath, quizObligatorio);
        assertEquals(3, learningPath.getActividades().size()); 
    }

    @Test
    public void testActualizarProgreso() {
        learningPathService.actualizarProgreso(learningPath);

        assertNotNull(learningPathService.obtenerProgreso());
    }

    @Test
    public void testRegistrarActividadCompletada() {
        learningPathService.registrarActividadCompletada(learningPath, quizObligatorio, "Correcto");
        assertEquals(1, learningPath.getHistorialActividades().size()); 
    }

    @Test
    public void testObtenerProgreso() {

        Progreso progreso = new Progreso(3, 0); 

        learningPathService.agregarActividad(learningPath, quizObligatorio);
        learningPathService.actualizarProgreso(learningPath);
        

        progreso.completarActividad(); 
        assertEquals(33, progreso.getPorcentajeProgreso());
    }

    @Test
    public void testEnviarNotificacionPendiente() {
        learningPathService.enviarNotificacionPendiente(learningPath);

    }


  
    @Test
    public void testCalcularTasasExitoFracaso() {

        HistorialActividad historial1 = new HistorialActividad(quizObligatorio, LocalDateTime.now());
        historial1.setResultado("Aprobado");  
        
        HistorialActividad historial2 = new HistorialActividad(quizOpcional, LocalDateTime.now());
        historial2.setResultado("Reprobado"); 


        List<HistorialActividad> historialActividades = learningPath.getHistorialActividades();
        historialActividades.add(historial1);
        historialActividades.add(historial2);
        learningPathService.calcularTasasExitoFracaso(learningPath);


        assertTrue(historialActividades.size() > 0); 

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




