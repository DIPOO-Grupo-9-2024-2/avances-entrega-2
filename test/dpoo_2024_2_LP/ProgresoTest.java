package dpoo_2024_2_LP;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Progreso;

class ProgresoTest {

    private Progreso progreso;

    @BeforeEach
    public void setUp() {
        progreso = new Progreso(10, 2);
    }

    @Test
    public void testCalcularProgresoInicial() {
        assertEquals(20, progreso.getPorcentajeProgreso(), "El porcentaje de progreso inicial debería ser 20%");
    }

    @Test
    public void testCompletarActividad() {
        progreso.completarActividad();
        assertEquals(30, progreso.getPorcentajeProgreso(), "El porcentaje de progreso después de completar una actividad debería ser 30%");
    }

    @Test
    public void testCalculoConTotalActividadesCero() {
        Progreso progresoCero = new Progreso(0, 0);
        assertEquals(0, progresoCero.getPorcentajeProgreso(), "El porcentaje de progreso debería ser 0% si totalActividades es 0");
    }



    @Test
    public void testSetPorcentajeProgreso() {
        progreso.setPorcentajeProgreso(50);
        assertEquals(50, progreso.getPorcentajeProgreso(), "El porcentaje de progreso debería establecerse correctamente");
    }

    @Test
    public void testSetActividadesCompletadas() {
        progreso.setActividadesCompletadas(5);
        assertEquals(5, progreso.getActividadesCompletadas(), "El número de actividades completadas debería establecerse correctamente");
    }

    @Test
    public void testSetTotalActividades() {
        progreso.setTotalActividades(20);
        assertEquals(20, progreso.getTotalActividades(), "El número total de actividades debería establecerse correctamente");
    }

    @Test
    public void testGetTotalActividades() {
        assertEquals(10, progreso.getTotalActividades(), "El número total de actividades debería ser igual a 10 inicialmente");
    }

    @Test
    public void testGetActividadesCompletadas() {
        assertEquals(2, progreso.getActividadesCompletadas(), "El número de actividades completadas debería ser igual a 2 inicialmente");
    }
}
