package dpoo_2024_2_LP;

import org.junit.jupiter.api.Test;

import model.Recurso;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTest {

    @Test
    void testCompletarRecurso() {
        Recurso recurso = new Recurso(1, "Recurso de prueba", "Aprender Java", 30, "video", "https://ejemplo.com", true);
        boolean completado = recurso.completar();
        assertTrue(completado, "El recurso debe marcarse como completado");
        assertEquals("completada", recurso.getEstado(), "El estado debe ser 'completada'");
    }

    @Test
    void testGettersYSetters() {
        Recurso recurso = new Recurso(1, "Recurso de prueba", "Aprender Java", 30, "video", "https://ejemplo.com", true);
        recurso.setTipo("artículo");
        assertEquals("artículo", recurso.getTipo(), "El tipo debe ser 'artículo'");

        recurso.setFuente("https://nuevo-ejemplo.com");
        assertEquals("https://nuevo-ejemplo.com", recurso.getFuente(), "La fuente debe actualizarse correctamente");
    }
}

