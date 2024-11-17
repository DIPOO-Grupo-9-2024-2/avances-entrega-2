package dpoo_2024_2_LP;

import org.junit.jupiter.api.Test;

import model.Tarea;

import static org.junit.jupiter.api.Assertions.*;

class TareaTest {

    @Test
    public void testCompletarTarea() {
        Tarea tarea = new Tarea(2, "Tarea de prueba", "Resolver ejercicios", 60, "Lee el capítulo 1", true);
        boolean completada = tarea.completar();
        assertTrue(completada, "La tarea debe marcarse como completada");
        assertEquals("completada", tarea.getEstado(), "El estado debe ser 'completada'");
    }
}


