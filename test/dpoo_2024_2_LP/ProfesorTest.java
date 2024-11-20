package dpoo_2024_2_LP;
import auth.Profesor;
import auth.Usuario;
import model.Actividad;
import model.ActividadConcreta;
import model.Calificacion;
import model.LearningPath;
import auth.Estudiante;
import model.Progreso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfesorTest {

    private Profesor profesor;
    private Estudiante estudiante;
    private LearningPath learningPath;
    private Actividad actividad;

    @BeforeEach
    void setUp() {

        estudiante = new Estudiante(1, "Estudiante Test", "estudiante@test.com", "password", "Estudiante", List.of("Java"));
        

        profesor = new Profesor(2, "Profesor Test", "profesor@test.com", "password", "Profesor", List.of("Java", "C++"));
        

        learningPath = profesor.crearLearningPath(1, "Java Básico", "Aprende Java desde cero", "Básico", 120, 4.5, "1.0");
        

        actividad = new ActividadConcreta(101, "Actividad 1", "Ejercicio de programación", 30,true);
    }

    @Test
    void testCrearLearningPath() {
 
        assertNotNull(learningPath);
        assertEquals(1, learningPath.getId());
        assertEquals("Java Básico", learningPath.getTitulo());
        assertEquals("Aprende Java desde cero", learningPath.getDescripcion());
        assertEquals("Básico", learningPath.getNivelDificultad());
        assertEquals(120, learningPath.getDuracionMinutos());
        assertEquals(4.5, learningPath.getRating());
        assertEquals("1.0", learningPath.getVersion());
    }

    @Test
    void testEditarLearningPath() {

        profesor.editarLearningPath(learningPath, "Java Intermedio", "Java a un nivel intermedio", "Intermedio", 150);
        

        assertEquals("Java Intermedio", learningPath.getTitulo());
        assertEquals("Java a un nivel intermedio", learningPath.getDescripcion());
        assertEquals("Intermedio", learningPath.getNivelDificultad());
        assertEquals(150, learningPath.getDuracionMinutos());
    }

    @Test
    void testAsignarActividad() {

        profesor.asignarActividad(actividad, List.of(estudiante));

        assertTrue(estudiante.getActividadesInscritas().contains(actividad));
    }

    @Test
    void testCalificarActividad() {

        profesor.calificarActividad(actividad, estudiante, 90, "Bien hecho");


        Progreso progreso = estudiante.getProgreso(actividad);
        assertNotNull(progreso);
        assertEquals(90, progreso.getCalificacion().getCalificacion());
        assertEquals("Bien hecho", progreso.getCalificacion().getFeedback());
    }

    @Test
    void testEditarLearningPathNoPermisos() {

        LearningPath otroLearningPath = new LearningPath(2, "C++ Básico", "Curso de C++", "Básico", 100, 4.0, "1.0");
        

        profesor.editarLearningPath(otroLearningPath, "C++ Intermedio", "Curso de C++ Intermedio", "Intermedio", 120);

        assertNotEquals("C++ Intermedio", otroLearningPath.getTitulo());
        assertNotEquals("Curso de C++ Intermedio", otroLearningPath.getDescripcion());
        assertNotEquals("Intermedio", otroLearningPath.getNivelDificultad());
        assertNotEquals(120, otroLearningPath.getDuracionMinutos());
    }
}
