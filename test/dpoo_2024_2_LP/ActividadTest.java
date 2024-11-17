package dpoo_2024_2_LP;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Actividad;
import model.ActividadConcreta;

class ActividadTest {

    private Actividad actividad;

    @BeforeEach
    void setUp() {
        actividad = new ActividadConcreta(1, "Prueba Actividad", "Objetivo de prueba", 60, true);
    }

    @Test
    void testMarcarCompletada() {
        assertEquals("pendiente", actividad.getEstado());

        actividad.marcarCompletada();
        assertEquals("completada", actividad.getEstado());
    }

    @Test
    void testEstablecerResultado() {
        assertEquals("", actividad.getResultado());

        actividad.establecerResultado("Prueba Exitosa");
        assertEquals("Prueba Exitosa", actividad.getResultado());
    }

    @Test
    void testCompletarActividad() {
        assertEquals("pendiente", actividad.getEstado());
        assertEquals("", actividad.getResultado());

        boolean resultado = actividad.completar();

        assertTrue(resultado);
        assertEquals("completada", actividad.getEstado());
        assertEquals("Éxito", actividad.getResultado());
    }

    @Test
    void testClonar() {
        // El test cubre las líneas donde se llama a `this.clone()`
        Actividad clon = actividad.clonar(null);

        // Verificamos que la clonación haya tenido éxito
        assertNotNull(clon);
        assertNotSame(actividad, clon); // Verificamos que no es la misma instancia
        assertEquals(actividad.getId(), clon.getId());
        assertEquals(actividad.getDescripcion(), clon.getDescripcion());
        assertEquals(actividad.getObjetivo(), clon.getObjetivo());
        assertEquals(actividad.getDuracionEsperada(), clon.getDuracionEsperada());
        assertEquals(actividad.esObligatoria(), clon.esObligatoria());
    }

    @Test
    void testClonarLanzaExcepcion() {
        // Actividad que simula una falla en la clonación
        Actividad actividadNoClonable = new ActividadConcretaNoClonable(2, "No Clonable", "Sin objetivo", 45, false);

        // Verificamos que se lanza la excepción RuntimeException
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            actividadNoClonable.clonar(null);
        });

        assertEquals("Error al clonar la actividad", exception.getMessage());
    }

    @Test
    void testToString() {
        String esperado = "Actividad ID: 1, Descripción: Prueba Actividad, Estado: pendiente, Resultado: ";
        assertEquals(esperado, actividad.toString());
    }

    // Subclase para simular una actividad no clonable
    static class ActividadConcretaNoClonable extends ActividadConcreta {
        public ActividadConcretaNoClonable(int id, String descripcion, String objetivo, int duracionEsperada, boolean esObligatoria) {
            super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            // Simulamos la excepción CloneNotSupportedException
            throw new CloneNotSupportedException("Clonación no soportada");
        }
    }
}

