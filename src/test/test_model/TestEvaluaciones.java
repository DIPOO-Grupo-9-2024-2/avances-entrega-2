package test.test_model;

import java.util.Arrays;
import java.util.List;
import model.*;

public class TestEvaluaciones {

    public static void main(String[] args) {
        // Crear preguntas de opción múltiple
        
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

    

        // Crear un quiz con las preguntas
        Quiz quiz = new Quiz(1, "Quiz de Programación", "Evaluar conocimientos básicos de programación", 30, "Qué es OOP?,¿Qué es Java?",0, 2,false);

        // Crear respuestas del estudiante
        RespuestaExamen respuesta1 = new RespuestaExamen(pregunta1, "A. Programación Orientada a Objetos");
        RespuestaExamen respuesta2 = new RespuestaExamen(pregunta2, "A. Un lenguaje de programación");

        // Crear una lista de respuestas del estudiante
        List<RespuestaExamen> respuestas = Arrays.asList(respuesta1, respuesta2);

        // Calificar el quiz
        Calificacion calificacion = quiz.calificar(respuestas);

        // Mostrar los resultados
        System.out.println("Resultado del Quiz:");
        System.out.println("Nota obtenida: " + calificacion.getNota());
        System.out.println("Feedback: " + calificacion.getFeedback());
    }
}
