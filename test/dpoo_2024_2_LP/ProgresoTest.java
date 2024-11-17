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
}
