package dpoo_2024_2_LP;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Notificacion;

import java.time.LocalDateTime;

class NotificacionTest {

    private Notificacion notificacion;

    @BeforeEach
    public void setUp() {

        notificacion = new Notificacion("Este es un mensaje de prueba.");
    }

    @Test
    public void testNotificacionCreadaCorrectamente() {

        assertEquals("Este es un mensaje de prueba.", notificacion.getMensaje(), "El mensaje debería ser el que se pasó al constructor.");
        

        assertNotNull(notificacion.getFechaEnvio(), "La fecha de envío no debería ser nula.");
        

        assertFalse(notificacion.isLeida(), "La notificación debería estar marcada como no leída por defecto.");
    }


    @Test
    public void testMarcarComoLeida() {

        notificacion.marcarComoLeida();


        assertTrue(notificacion.isLeida(), "La notificación debería estar marcada como leída.");
    }

    @Test
    public void testSetMensaje() {

        notificacion.setMensaje("Nuevo mensaje de prueba.");

        assertEquals("Nuevo mensaje de prueba.", notificacion.getMensaje(), "El mensaje debería ser actualizado.");
    }


    @Test
    public void testSetFechaEnvio() {

        LocalDateTime nuevaFecha = LocalDateTime.of(2024, 11, 18, 10, 30, 0, 0);
        notificacion.setFechaEnvio(nuevaFecha);

        assertEquals(nuevaFecha, notificacion.getFechaEnvio(), "La fecha de envío debería ser actualizada.");
    }

    @Test
    public void testSetLeida() {

        notificacion.setLeida(true);


        assertTrue(notificacion.isLeida(), "La notificación debería estar marcada como leída.");
    }

    @Test
    public void testToString() {
    
        String expected = "Notificación: Este es un mensaje de prueba., Enviada el: " + notificacion.getFechaEnvio() + ", Leída: false";
        assertEquals(expected, notificacion.toString(), "El método toString debería retornar la cadena correctamente.");
    }
}
