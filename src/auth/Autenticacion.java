package auth;

import java.util.HashMap;
import java.util.Map;

public class Autenticacion {
    // Mapa para almacenar los usuarios registrados
    private Map<String, Usuario> usuariosRegistrados = new HashMap<>();

    // Constructor para inicializar la clase Autenticacion
    public Autenticacion() {
        usuariosRegistrados = new HashMap<>();
    }


    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.put(usuario.getEmail(), usuario);
    }

    // Método para el login
    public Usuario login(String email, String contraseña) {
        Usuario usuario = usuariosRegistrados.get(email);

        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            System.out.println("Inicio de sesión exitoso para: " + usuario.getNombre());
            return usuario; // Login exitoso
        } else {
            throw new RuntimeException("Credenciales inválidas. Intente nuevamente.");
        }
    }





    // Método para cambiar la contraseña de un usuario
    public void cambiarContraseña(Usuario usuario, String nuevaContraseña) {
        if (usuariosRegistrados.containsKey(usuario.getEmail())) {
            usuario.setContraseña(nuevaContraseña); // Cambiar la contraseña

        } else {
   
        }
    }

    // Método para obtener usuarios
    public Map<String, Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    // Método opcional para obtener un usuario por su email (útil para pruebas)
    public Usuario obtenerUsuario(String email) {
        return usuariosRegistrados.get(email);
    }
}


