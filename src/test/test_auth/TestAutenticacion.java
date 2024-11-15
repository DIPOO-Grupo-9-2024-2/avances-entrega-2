package test.test_auth;

import auth.Administrador;
import auth.Autenticacion;
import auth.Estudiante;
import auth.Profesor;
import auth.Usuario;
import java.util.List;

public class TestAutenticacion {

    public static void main(String[] args) {
        // Crear una instancia de la clase Autenticacion
        Autenticacion auth = new Autenticacion();

        // Crear usuarios de prueba
        List<String> intereses = List.of("Java", "Python");

        Usuario profesor = new Profesor(1, "juan@universidad.com", "profesor123","Profesor Juan", "Profesor", intereses);
        Usuario estudiante = new Estudiante(2,  "ana@estudiante.com", "estudiante456", "Estudiante Ana","Estudiante", intereses);
        Usuario administrador = new Administrador(3,  "pedro@admin.com", "admin789","Admin Pedro", "Administrador", intereses);

        // Registrar los usuarios en el sistema
        auth.registrarUsuario(profesor);
        auth.registrarUsuario(estudiante);
        auth.registrarUsuario(administrador);

        // Intentar hacer login con las credenciales correctas
        try {
            Usuario usuarioLogueado = auth.login("juan@universidad.com", "profesor123");
            System.out.println("Bienvenido: " + usuarioLogueado.getNombre());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Intentar hacer login con credenciales incorrectas
        try {
            auth.login("ana@estudiante.com", "contraseñaIncorrecta");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Cambiar la contraseña de un usuario
        auth.cambiarContraseña(estudiante, "nuevaContraseña");
        try {
            auth.login("ana@estudiante.com", "nuevaContraseña");
            System.out.println("Inicio de sesión exitoso con la nueva contraseña.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
