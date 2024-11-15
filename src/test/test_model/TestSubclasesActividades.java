package test.test_model;

import model.Encuesta;
import model.Recurso;
import model.Tarea;

public class TestSubclasesActividades {

    public static void main(String[] args) {
        // Crear una instancia de Tarea
        Tarea tarea = new Tarea(1, "Tarea 1", "Aprender OOP", 120, "Instrucciones para la tarea 1",true);
        tarea.completar();

        // Crear una instancia de Recurso
        Recurso recurso = new Recurso(2, "Recurso 1", "Ver video de patrones de diseño", 90, "video", "https://video.com",false);
        recurso.completar();

        // Crear una instancia de Encuesta
        Encuesta encuesta = new Encuesta(3, "Encuesta 1", "Feedback sobre el curso", 30, "¿Te gustó el curso?,¿Qué mejorarías?",false);
        encuesta.completar();
    }
}
