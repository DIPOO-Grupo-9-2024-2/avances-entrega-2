package dpoo_2024_2_LP;


import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auth.Estudiante;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EstudianteTest {
    private Estudiante estudiante;
    private LearningPath learningPath1;
    private LearningPath learningPath2;
    private Actividad actividad1;
    private Actividad actividad2;
    @BeforeEach
    public void setUp() {

        List<String> intereses = Arrays.asList("Java", "Programación");
        estudiante = new Estudiante(1, "estudiante@example.com", "password123", "Juan Perez", "Estudiante", intereses);
        learningPath1 = new LearningPath(1, "Java Básico", "Aprende los fundamentos de Java","Básico",120,4.5, "1.0");
        learningPath2 = new LearningPath(2, "Python Básico", "Introducción a Python","Básico",300,3.7,"2.3");
        
        actividad1 = new ActividadConcreta(1,"Una actividad para aprender los fundamentos de Java", "Sembrar bases para la programación en Java", 120, true);
        actividad2 = new ActividadConcreta(2, "Actividad avanzada sobre Java","Practicar lo aprendido hasta el momento",150, false);

        new Calificacion(85, "Buen trabajo en la actividad");
        new Calificacion(90, "Excelente trabajo en la actividad");
    }

    @Test
    public void testInscribirLearningPath() {
        estudiante.inscribirLearningPath(learningPath1);
        estudiante.inscribirLearningPath(learningPath2);
        assertEquals(2, estudiante.getLearningPathsInscritos().size());
        assertTrue(estudiante.getLearningPathsInscritos().contains(learningPath1));
        assertTrue(estudiante.getLearningPathsInscritos().contains(learningPath2));
    }

    @Test
    public void testInscribirActividad() {

        estudiante.inscribirActividad(actividad1);
        estudiante.inscribirActividad(actividad2);

        assertEquals(2, estudiante.getActividadesInscritas().size());
        assertTrue(estudiante.getActividadesInscritas().contains(actividad1));
        assertTrue(estudiante.getActividadesInscritas().contains(actividad2));
    }

    @Test
    public void testRecomendarLearningPaths() {

        estudiante.inscribirLearningPath(learningPath1);
        estudiante.inscribirLearningPath(learningPath2);

        List<LearningPath> recomendados = estudiante.recomendarLearningPaths(Arrays.asList(learningPath1, learningPath2));


        assertEquals(1, recomendados.size());
        assertTrue(recomendados.contains(learningPath1));
    }

    @Test
    public void testGetProgreso() {

        estudiante.inscribirActividad(actividad1);
        estudiante.inscribirActividad(actividad2);

        Progreso progreso = estudiante.getProgreso(actividad1);
        assertNotNull(progreso);
        assertEquals(2, progreso.getTotalActividades());
        assertEquals(1, progreso.getActividadesCompletadas());  
    }

    @Test
    public void testActualizarProgreso() {

        Estudiante estudiante = new Estudiante(1, "juan@ejemplo.com", "contraseña123", "Juan", "Estudiante", new ArrayList<>());
        Actividad actividad1 = new ActividadConcreta(1,"Una actividad para aprender los fundamentos de Java", "Sembrar bases para la programación en Java", 120, true);
        Actividad actividad2 = new ActividadConcreta(2, "Actividad avanzada sobre Java","Practicar lo aprendido hasta el momento",150, false);
        

        Calificacion calificacion1 = new Calificacion(85,"Buen trabajo");
        Calificacion calificacion2 = new Calificacion(70,"Puede mejorar");

        estudiante.inscribirActividad(actividad1);
        estudiante.inscribirActividad(actividad2);

        estudiante.actualizarProgreso(actividad1, calificacion1);
        estudiante.actualizarProgreso(actividad2, calificacion2);

        assertEquals(2, estudiante.calificaciones.size()); 
        assertTrue(estudiante.calificaciones.contains(calificacion1));  
        assertTrue(estudiante.calificaciones.contains(calificacion2));  
    }

}

