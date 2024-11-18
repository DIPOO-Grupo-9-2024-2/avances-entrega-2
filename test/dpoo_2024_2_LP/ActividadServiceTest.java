package dpoo_2024_2_LP;

import model.Actividad;
import model.ActividadConcreta;
import model.HistorialActividad;
import service.ActividadService;
import service.HistorialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActividadServiceTest {

    private ActividadService actividadService;
    private HistorialService historialService;
    private Actividad actividad;
    private List<HistorialActividad> historialActividades;

    @BeforeEach
    public void setUp() {
        actividadService = new ActividadService();
        historialService = new HistorialService();
        historialActividades = new ArrayList<>();

        // Crear una actividad concreta
        actividad = new ActividadConcreta(1, "Estudiar Matemáticas", "Aprender álgebra", 120, true);

        // Crear un historial inicial de actividades
        historialActividades.add(new HistorialActividad(actividad, LocalDateTime.of(2024, 11, 15, 0, 0)));
    }

    @Test
    public void testCompletarActividad() {
        assertEquals("pendiente", actividad.getEstado());
        actividadService.completarActividad(actividad);
        assertEquals("completada", actividad.getEstado());
        assertEquals("Éxito", actividad.getResultado());
        assertNotNull(actividad.getResultado());
    }

    @Test
    public void testListarActividadesPendientes() {
        Actividad actividad1 = new ActividadConcreta(2, "Leer libro", "Leer el libro de Java", 90, false);
        Actividad actividad2 = new ActividadConcreta(3, "Realizar tarea", "Completar la tarea de programación", 150, true);
        actividadService.completarActividad(actividad2);

        List<Actividad> actividadesPendientes = actividadService.listarActividadesPendientes(List.of(actividad, actividad1, actividad2));

        assertTrue(actividadesPendientes.contains(actividad));
        assertTrue(actividadesPendientes.contains(actividad1));
        assertFalse(actividadesPendientes.contains(actividad2));
    }

    @Test
    public void testObtenerEstadoActividad() {
        assertEquals("pendiente", actividadService.obtenerEstadoActividad(actividad));
        actividadService.completarActividad(actividad);
        assertEquals("completada", actividadService.obtenerEstadoActividad(actividad));
    }

    @Test
    public void testClonacionActividad() {
        Actividad actividadClonada = actividad.clonar(null);
        assertNotNull(actividadClonada);
        assertEquals(actividad.getId(), actividadClonada.getId());
        assertEquals(actividad.getDescripcion(), actividadClonada.getDescripcion());
    }

    @Test
    public void testToString() {
        String actividadString = actividad.toString();
        assertTrue(actividadString.contains("Actividad ID: 1"));
        assertTrue(actividadString.contains("Descripción: Estudiar Matemáticas"));
        assertTrue(actividadString.contains("Estado: pendiente"));
        assertTrue(actividadString.contains("Resultado: "));
    }

    @Test
    public void testSetEsObligatoria() {
        assertTrue(actividad.isEsObligatoria());
        actividad.setEsObligatoria(false);
        assertFalse(actividad.isEsObligatoria());
    }

    @Test
    public void testSetDescripcion() {
        actividad.setDescripcion("Estudiar Física");
        assertEquals("Estudiar Física", actividad.getDescripcion());
    }

    @Test
    public void testSetObjetivo() {
        actividad.setObjetivo("Estudiar geometría");
        assertEquals("Estudiar geometría", actividad.getObjetivo());
    }

    @Test
    public void testSetId() {
        actividad.setId(99);
        assertEquals(99, actividad.getId());
    }

    @Test
    public void testSetDuracionEsperada() {
        actividad.setDuracionEsperada(150);
        assertEquals(150, actividad.getDuracionEsperada());
    }

    @Test
    public void testSetEstado() {
        actividad.setEstado("en progreso");
        assertEquals("en progreso", actividad.getEstado());
    }

    // Nuevos tests para HistorialService
    @Test
    public void testListarHistorial() {
        List<HistorialActividad> resultado = historialService.listarHistorial(historialActividades);
        assertEquals(historialActividades, resultado);
    }

    @Test
    public void testObtenerDetallesHistorial() {
        HistorialActividad historial = historialActividades.get(0);
        HistorialActividad resultado = historialService.obtenerDetallesHistorial(historial);
        assertEquals(historial, resultado);
    }


}


