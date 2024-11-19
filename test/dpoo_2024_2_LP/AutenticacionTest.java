package dpoo_2024_2_LP;
import auth.Autenticacion;
import auth.UsuarioConcreto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import auth.Usuario;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AutenticacionTest {

    private Autenticacion autenticacion;
    private UsuarioConcreto usuario;

    @BeforeEach
    public void setUp() {
        autenticacion = new Autenticacion();

        // Crear una lista de intereses para el usuario
        List<String> intereses = new ArrayList<>();
        intereses.add("Tecnología");
        intereses.add("Deportes");
        intereses.add("Música");

        // Crear un usuario usando la clase concreta
        usuario = new UsuarioConcreto(1, "juan.perez@example.com", "Juan Perez", "12345", intereses);

        // Registrar el usuario en el sistema
        autenticacion.registrarUsuario(usuario);
        System.out.println("Usuario registrado: " + usuario.getEmail()); // Confirmamos que se registró
    }


    @Test
    public void testLoginExitoso() {
        // Creamos una lista de intereses para el usuario
        List<String> intereses = new ArrayList<>();
        intereses.add("Tecnología");
        intereses.add("Deportes");
        intereses.add("Música");

        // Creamos el usuario con los datos necesarios
        Usuario usuario = new UsuarioConcreto(1, "juan.perez@example.com", "12345", "Juan Perez", intereses);

        // Registramos el usuario en el sistema
        autenticacion.registrarUsuario(usuario);

        // Intentamos hacer login con las credenciales correctas
        Usuario usuarioLogueado = autenticacion.login("juan.perez@example.com", "12345");

        // Verificamos que el usuario devuelto no sea null y tenga la información correcta
        assertNotNull(usuarioLogueado, "El usuario debería estar logueado.");
        assertEquals("Juan Perez", usuarioLogueado.getNombre(), "El nombre del usuario debería ser el mismo.");
        assertEquals("juan.perez@example.com", usuarioLogueado.getEmail(), "El email del usuario debería coincidir.");
    }
    @Test
    public void testLoginFallido() {
        // Intentamos hacer login con una contraseña incorrecta
        assertThrows(RuntimeException.class, () -> autenticacion.login("juan.perez@example.com", "incorrecta"),
                "Debería lanzar una excepción por credenciales incorrectas.");
    }

    @Test
    public void testCambiarContraseña() {
        // Verificamos que el usuario está registrado inicialmente
        UsuarioConcreto usuarioRegistrado = (UsuarioConcreto) autenticacion.obtenerUsuario("juan.perez@example.com");
        assertNotNull(usuarioRegistrado, "El usuario debería existir.");

        // Cambiamos la contraseña
        autenticacion.cambiarContraseña(usuario, "nuevaContraseña");

        // Verificamos que la nueva contraseña se haya asignado correctamente
        UsuarioConcreto usuarioActualizado = (UsuarioConcreto) autenticacion.obtenerUsuario("juan.perez@example.com");
        assertNotNull(usuarioActualizado, "El usuario debería existir.");
        assertEquals("nuevaContraseña", usuarioActualizado.getContraseña(), "La contraseña debería haberse actualizado.");
    }



}
