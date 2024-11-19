package dpoo_2024_2_LP;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Notificacion;

import java.time.LocalDateTime;

class NotificacionTest {

    private Notificacion notificacion;

    // Configura una notificación antes de cada prueba
    @BeforeEach
    public void setUp() {
        // Creamos una nueva notificación con un mensaje
        notificacion = new Notificacion("Este es un mensaje de prueba.");
    }

    // Test para verificar la correcta creación de la notificación
    @Test
    public void testNotificacionCreadaCorrectamente() {
        // Verificamos que el mensaje es correcto
        assertEquals("Este es un mensaje de prueba.", notificacion.getMensaje(), "El mensaje debería ser el que se pasó al constructor.");
        
        // Verificamos que la fecha de envío no sea nula y sea la fecha actual
        assertNotNull(notificacion.getFechaEnvio(), "La fecha de envío no debería ser nula.");
        
        // Verificamos que la notificación inicialmente esté marcada como no leída
        assertFalse(notificacion.isLeida(), "La notificación debería estar marcada como no leída por defecto.");
    }

    // Test para verificar que se pueda marcar la notificación como leída
    @Test
    public void testMarcarComoLeida() {
        // Marcamos la notificación como leída
        notificacion.marcarComoLeida();

        // Verificamos que el estado de la notificación se haya actualizado correctamente
        assertTrue(notificacion.isLeida(), "La notificación debería estar marcada como leída.");
    }

    // Test para verificar el setter y getter del mensaje
    @Test
    public void testSetMensaje() {
        // Modificamos el mensaje
        notificacion.setMensaje("Nuevo mensaje de prueba.");
        
        // Verificamos que el mensaje se haya actualizado correctamente
        assertEquals("Nuevo mensaje de prueba.", notificacion.getMensaje(), "El mensaje debería ser actualizado.");
    }

    // Test para verificar el setter y getter de la fecha de envío
    @Test
    public void testSetFechaEnvio() {
        // Definimos una nueva fecha de envío
        LocalDateTime nuevaFecha = LocalDateTime.of(2024, 11, 18, 10, 30, 0, 0);
        notificacion.setFechaEnvio(nuevaFecha);

        // Verificamos que la fecha de envío haya sido actualizada correctamente
        assertEquals(nuevaFecha, notificacion.getFechaEnvio(), "La fecha de envío debería ser actualizada.");
    }

    // Test para verificar el setter y getter del estado de leída
    @Test
    public void testSetLeida() {
        // Cambiamos el estado a leída
        notificacion.setLeida(true);

        // Verificamos que el estado de leída haya sido actualizado correctamente
        assertTrue(notificacion.isLeida(), "La notificación debería estar marcada como leída.");
    }

    // Test para verificar el método toString()
    @Test
    public void testToString() {
        // Obtenemos el resultado de toString
        String expected = "Notificación: Este es un mensaje de prueba., Enviada el: " + notificacion.getFechaEnvio() + ", Leída: false";
        assertEquals(expected, notificacion.toString(), "El método toString debería retornar la cadena correctamente.");
    }
}
