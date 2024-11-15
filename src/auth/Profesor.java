package auth;

import java.util.List;

public class Profesor extends Usuario {
    public Profesor(int id, String email, String contraseña, String nombre, String rol, List<String> intereses) {
        super(id, email, contraseña, nombre, rol, intereses);
    }

    public void crearLearningPath(String titulo, String descripcion) {
        // Lógica para crear un Learning Path
        System.out.println("Creando Learning Path: " + titulo);
    }

    //métodos
}
