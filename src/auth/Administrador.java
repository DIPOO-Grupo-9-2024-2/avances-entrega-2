package auth;

import java.util.List;

public class Administrador extends Usuario {
    public Administrador(int id, String email, String contraseña, String nombre, String rol, List<String> intereses) {
        super(id, email, contraseña, nombre, rol, intereses);
    }

    // Métodos
}
