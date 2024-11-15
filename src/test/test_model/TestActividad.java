package test.test_model;

public class TestActividad {

    public static void main(String[] args) {
        // Crear una instancia de TareaPrueba
        TareaPrueba tarea = new TareaPrueba(1, "Tarea de ejemplo", "Entender la herencia en Java", 60,true);

        // Mostrar la actividad antes de completarla
        System.out.println(tarea);

        // Completar la tarea
        tarea.completar();

        // Mostrar la actividad después de completarla
        System.out.println(tarea);
    }
}

