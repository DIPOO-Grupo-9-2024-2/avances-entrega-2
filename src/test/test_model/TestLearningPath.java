package test.test_model;

import java.util.Arrays;
import model.*;

public class TestLearningPath {

    public static void main(String[] args) {
        // Crear un Learning Path
        LearningPath learningPath = new LearningPath(1, "Camino de Programación", "Aprende los conceptos básicos de la programación");

        // Crear algunas actividades (tareas, recursos y un quiz)
        Tarea tarea1 = new Tarea(1, "Tarea 1", "Completar ejercicios de programación", 120, "Ejercicios prácticos de Java", false);
        Recurso recurso1 = new Recurso(2, "Recurso 1", "Leer artículo sobre POO", 90, "artículo", "https://articulo.com", false);

        // Crear preguntas para el quiz
        Pregunta pregunta1 = new Pregunta("¿Qué es OOP?", new String[]{
            "A. Programación Orientada a Objetos",
            "B. Programación Orientada a Procedimientos",
            "C. Programación Funcional",
            "D. Ninguna de las anteriores"}, 
            "A. Programación Orientada a Objetos", 
            "OOP significa Programación Orientada a Objetos.");
        
        Pregunta pregunta2 = new Pregunta("¿Qué es Java?", new String[]{
            "A. Un lenguaje de programación",
            "B. Un framework",
            "C. Un sistema operativo",
            "D. Ninguna de las anteriores"}, 
            "A. Un lenguaje de programación", 
            "Java es un lenguaje de programación.");

        // Crear un quiz
        Quiz quiz1 = new Quiz(3, "Quiz de Programación", "Evaluar conocimientos básicos de programación",30, "Qué es OOP?,¿Qué es Java?",0, 2,false);
 
        // Agregar actividades al Learning Path
        learningPath.agregarActividad(tarea1);
        learningPath.agregarActividad(recurso1);
        learningPath.agregarActividad(quiz1);

        // Completar algunas actividades
        tarea1.completar();
        recurso1.completar();

        // Calcular el progreso del estudiante
        int progreso = learningPath.calcularProgreso();

        // Mostrar el progreso
        System.out.println("Progreso del Learning Path: " + progreso + "%");

        // Completar el quiz
        RespuestaExamen respuesta1 = new RespuestaExamen(pregunta1, "A. Programación Orientada a Objetos");
        RespuestaExamen respuesta2 = new RespuestaExamen(pregunta2, "A. Un lenguaje de programación");

        quiz1.calificar(Arrays.asList(respuesta1, respuesta2));
        quiz1.completar();

        // Recalcular el progreso del estudiante
        progreso = learningPath.calcularProgreso();

        // Mostrar el progreso actualizado
        System.out.println("Progreso actualizado del Learning Path: " + progreso + "%");
    }
}

