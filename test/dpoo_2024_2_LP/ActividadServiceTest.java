package dpoo_2024_2_LP;

import model.Actividad;
import model.ActividadConcreta;
import service.ActividadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ActividadServiceTest {

    private ActividadService actividadService;
    private Actividad actividad;

    @BeforeEach
    public void setUp() {
        actividadService = new ActividadService();
        // Crear una actividad concreta
        actividad = new ActividadConcreta(1, "Estudiar Matemáticas", "Aprender álgebra", 120, true);
    }

    @Test
    public void testCompletarActividad() {
        // Verificar el estado inicial (pendiente)
        assertEquals("pendiente", actividad.getEstado());

        // Completar la actividad
        actividadService.completarActividad(actividad);

        // Verificar que el estado cambió a completada y el resultado fue establecido
        assertEquals("completada", actividad.getEstado());
        assertEquals("Éxito", actividad.getResultado());

        // Verificar que la asignación de resultado también fue cubierta
        assertNotNull(actividad.getResultado());
        assertEquals("Éxito", actividad.getResultado());
    }

    @Test
    public void testListarActividadesPendientes() {
        // Crear una lista de actividades con algunas pendientes y otras completadas
        Actividad actividad1 = new ActividadConcreta(2, "Leer libro", "Leer el libro de Java", 90, false);
        Actividad actividad2 = new ActividadConcreta(3, "Realizar tarea", "Completar la tarea de programación", 150, true);
        actividadService.completarActividad(actividad2); // Marcar como completada

        // Listar las actividades pendientes
        List<Actividad> actividadesPendientes = actividadService.listarActividadesPendientes(List.of(actividad, actividad1, actividad2));

        // Verificar que solo las actividades pendientes estén en la lista
        assertTrue(actividadesPendientes.contains(actividad));
        assertTrue(actividadesPendientes.contains(actividad1));
        assertFalse(actividadesPendientes.contains(actividad2)); // La actividad2 fue completada
    }

    @Test
    public void testObtenerEstadoActividad() {
        // Obtener el estado antes de completar
        assertEquals("pendiente", actividadService.obtenerEstadoActividad(actividad));

        // Completar la actividad
        actividadService.completarActividad(actividad);

        // Obtener el estado después de completar
        assertEquals("completada", actividadService.obtenerEstadoActividad(actividad));
    }

    @Test
    public void testClonacionActividad() {
        // Intentar clonar la actividad y verificar que no haya excepciones
        Actividad actividadClonada = actividad.clonar(null); // En este caso, no necesitamos un Profesor, lo pasamos como null

        assertNotNull(actividadClonada);
        assertEquals(actividad.getId(), actividadClonada.getId());  // Comprobar que el ID es el mismo
        assertEquals(actividad.getDescripcion(), actividadClonada.getDescripcion()); // Verificar que la descripción es la misma
    }

    @Test
    public void testToString() {
        // Obtener la representación en cadena de la actividad
        String actividadString = actividad.toString();

        // Verificar que la cadena contiene los elementos esperados
        assertTrue(actividadString.contains("Actividad ID: 1"));
        assertTrue(actividadString.contains("Descripción: Estudiar Matemáticas"));
        assertTrue(actividadString.contains("Estado: pendiente"));
        assertTrue(actividadString.contains("Resultado: "));
    }

    @Test
    public void testSetEsObligatoria() {
        // Verificar el valor inicial de esObligatoria
        assertTrue(actividad.isEsObligatoria());

        // Cambiar el valor de esObligatoria usando el setter
        actividad.setEsObligatoria(false);

        // Verificar que el valor se actualizó correctamente
        assertFalse(actividad.isEsObligatoria());
    }

    @Test
    public void testSetDescripcion() {
        // Cambiar la descripción de la actividad
        actividad.setDescripcion("Estudiar Física");

        // Verificar que la descripción se actualizó correctamente
        assertEquals("Estudiar Física", actividad.getDescripcion());
    }

    @Test
    public void testSetObjetivo() {
        // Cambiar el objetivo de la actividad
        actividad.setObjetivo("Estudiar geometría");

        // Verificar que el objetivo se actualizó correctamente
        assertEquals("Estudiar geometría", actividad.getObjetivo());
    }

    @Test
    public void testSetId() {
        // Cambiar el ID de la actividad
        actividad.setId(99);

        // Verificar que el ID se actualizó correctamente
        assertEquals(99, actividad.getId());
    }

    @Test
    public void testSetDuracionEsperada() {
        // Cambiar la duración esperada de la actividad
        actividad.setDuracionEsperada(150);

        // Verificar que la duración se actualizó correctamente
        assertEquals(150, actividad.getDuracionEsperada());
    }

    @Test
    public void testSetEstado() {
        // Cambiar el estado de la actividad
        actividad.setEstado("en progreso");

        // Verificar que el estado se actualizó correctamente
        assertEquals("en progreso", actividad.getEstado());
    }
}



