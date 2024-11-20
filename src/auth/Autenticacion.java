package auth;

import java.util.HashMap;
import java.util.Map;

public class Autenticacion {

    private Map<String, Usuario> usuariosRegistrados = new HashMap<>();


    public Autenticacion() {
        usuariosRegistrados = new HashMap<>();
    }


    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.put(usuario.getEmail(), usuario);
    }


    public Usuario login(String email, String contraseña) {
        Usuario usuario = usuariosRegistrados.get(email);

        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            System.out.println("Inicio de sesión exitoso para: " + usuario.getNombre());
            return usuario; 
        } else {
            throw new RuntimeException("Credenciales inválidas. Intente nuevamente.");
        }
    }






    public void cambiarContraseña(Usuario usuario, String nuevaContraseña) {
        if (usuariosRegistrados.containsKey(usuario.getEmail())) {
            usuario.setContraseña(nuevaContraseña); 

        } else {
   
        }
    }


    public Map<String, Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }


    public Usuario obtenerUsuario(String email) {
        return usuariosRegistrados.get(email);
    }
}


