package dpoo_2024_2_LP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auth.Usuario;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;

    // Subclase concreta para probar la clase abstracta Usuario
    static class UsuarioConcreto extends Usuario {
        public UsuarioConcreto(int id, String email, String contraseña, String nombre, String rol, List<String> intereses) {
            super(id, email, contraseña, nombre, rol, intereses);
        }
    }

    @BeforeEach
    void setUp() {
        usuario = new UsuarioConcreto(
                1,
                "test@example.com",
                "securepassword",
                "Test User",
                "Estudiante",
                List.of("Java", "Python")
        );
    }

    @Test
    void testGetters() {
        assertEquals(1, usuario.getId());
        assertEquals("test@example.com", usuario.getEmail());
        assertEquals("securepassword", usuario.getContraseña());
        assertEquals("Test User", usuario.getNombre());
        assertEquals("Estudiante", usuario.getRol());
        assertEquals(List.of("Java", "Python"), usuario.getIntereses());
    }

    @Test
    void testSetters() {
        usuario.setId(2);
        usuario.setEmail("newemail@example.com");
        usuario.setContraseña("newpassword");
        usuario.setNombre("New Name");
        usuario.setRol("Administrador");
        usuario.setIntereses(List.of("C++", "Ruby"));

        assertEquals(2, usuario.getId());
        assertEquals("newemail@example.com", usuario.getEmail());
        assertEquals("newpassword", usuario.getContraseña());
        assertEquals("New Name", usuario.getNombre());
        assertEquals("Administrador", usuario.getRol());
        assertEquals(List.of("C++", "Ruby"), usuario.getIntereses());
    }
}

