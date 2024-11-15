package test.test_model;

import java.util.Arrays;
import model.*;
import service.*;

public class TestSistema {

    public static void main(String[] args) {
        // Crear LearningPathService y EvaluacionService
        LearningPathService learningPathService = new LearningPathService();
        EvaluacionService evaluacionService = new EvaluacionService();

        // Crear un Learning Path
        LearningPath learningPath = new LearningPath(1, "Camino de Programación", "Aprende los conceptos básicos de la programación");

        // Crear actividades
        Tarea tarea1 = new Tarea(1, "Tarea 1", "Completar ejercicios de Java", 120, "Realizar los ejercicios prácticos",true);
        Recurso recurso1 = new Recurso(2, "Recurso 1", "Leer artículo sobre POO", 90, "artículo", "https://articulo.com",false);

        // Agregar actividades al Learning Path
        learningPathService.agregarActividad(learningPath, tarea1);
        learningPathService.agregarActividad(learningPath, recurso1);

        // Crear preguntas para el quiz
        Pregunta pregunta1 = new Pregunta("¿Qué es OOP?", new String[]{
            "A. Programación Orientada a Objetos",
            "B. Programación Funcional",
            "C. Programación Estructurada",
            "D. Ninguna de las anteriores"}, 
            "A. Programación Orientada a Objetos", 
            "OOP significa Programación Orientada a Objetos.");
        
        PreguntaAbierta preguntaAbierta = new PreguntaAbierta("Explica qué es Java.", "Un lenguaje de programación", "Java es un lenguaje de programación.");

        // Crear un quiz con preguntas abiertas y cerradas
        Quiz quiz = new Quiz(3, "Quiz de Programación", "Evaluar conocimientos básicos de programación",30, "Qué es OOP?,¿Qué es Java?",0, 2,false);
 
        // Agregar el quiz al Learning Path
        learningPathService.agregarActividad(learningPath, quiz);

        // Completar algunas actividades y registrar el progreso
        tarea1.completar();
        learningPathService.registrarActividadCompletada(learningPath, tarea1, "Completada con éxito");

        recurso1.completar();
        learningPathService.registrarActividadCompletada(learningPath, recurso1, "Leído el artículo");

        // Progreso actual
        System.out.println("Progreso después de completar las actividades:");
        System.out.println("Progreso del Learning Path: " + learningPathService.obtenerProgreso() + "%");

        // Calificar el quiz
        RespuestaExamen respuesta1 = new RespuestaExamen(pregunta1, "A. Programación Orientada a Objetos");
        RespuestaExamen respuesta2 = new RespuestaExamen(preguntaAbierta, "Un lenguaje de programación");

        Calificacion calificacion = evaluacionService.calificarEvaluacion(quiz, Arrays.asList(respuesta1, respuesta2));
        System.out.println("Resultado del Quiz: " + calificacion);

        // Agregar feedback del estudiante
        evaluacionService.agregarFeedback(quiz, "Me pareció un buen quiz, aunque las preguntas podrían ser más detalladas.", 4);

        // Completar el quiz
        quiz.completar();
        learningPathService.registrarActividadCompletada(learningPath, quiz, "Quiz completado");

        // Progreso final
        System.out.println("Progreso final después de completar todas las actividades:");
        System.out.println("Progreso del Learning Path: " + learningPathService.obtenerProgreso() + "%");

        // Enviar notificación sobre actividades pendientes (debería estar vacío ya)
        learningPathService.enviarNotificacionPendiente(learningPath);
    }
}
