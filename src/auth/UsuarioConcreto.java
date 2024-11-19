package auth;

import java.util.List;

public class UsuarioConcreto extends Usuario {
    public UsuarioConcreto(int id, String nombre, String email, String contraseña,List<String> intereses) {
        super(id, nombre, email, contraseña, contraseña, intereses);
    }
}
