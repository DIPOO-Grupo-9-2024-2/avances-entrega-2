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

        List<String> intereses = new ArrayList<>();
        intereses.add("Tecnología");
        intereses.add("Deportes");
        intereses.add("Música");


        usuario = new UsuarioConcreto(1, "juan.perez@example.com", "Juan Perez", "12345", intereses);


        autenticacion.registrarUsuario(usuario);
        System.out.println("Usuario registrado: " + usuario.getEmail()); 
    }


    @Test
    public void testLoginExitoso() {

        List<String> intereses = new ArrayList<>();
        intereses.add("Tecnología");
        intereses.add("Deportes");
        intereses.add("Música");


        Usuario usuario = new UsuarioConcreto(1, "juan.perez@example.com", "12345", "Juan Perez", intereses);


        autenticacion.registrarUsuario(usuario);


        Usuario usuarioLogueado = autenticacion.login("juan.perez@example.com", "12345");


        assertNotNull(usuarioLogueado, "El usuario debería estar logueado.");
        assertEquals("Juan Perez", usuarioLogueado.getNombre(), "El nombre del usuario debería ser el mismo.");
        assertEquals("juan.perez@example.com", usuarioLogueado.getEmail(), "El email del usuario debería coincidir.");
    }
    @Test
    public void testLoginFallido() {

        assertThrows(RuntimeException.class, () -> autenticacion.login("juan.perez@example.com", "incorrecta"),
                "Debería lanzar una excepción por credenciales incorrectas.");
    }

    @Test
    public void testCambiarContraseña() {

        UsuarioConcreto usuarioRegistrado = (UsuarioConcreto) autenticacion.obtenerUsuario("juan.perez@example.com");
        assertNotNull(usuarioRegistrado, "El usuario debería existir.");


        autenticacion.cambiarContraseña(usuario, "nuevaContraseña");


        UsuarioConcreto usuarioActualizado = (UsuarioConcreto) autenticacion.obtenerUsuario("juan.perez@example.com");
        assertNotNull(usuarioActualizado, "El usuario debería existir.");
        assertEquals("nuevaContraseña", usuarioActualizado.getContraseña(), "La contraseña debería haberse actualizado.");
    }



}
