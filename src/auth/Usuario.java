package auth;

import java.util.List;

public abstract class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String contraseña;
    private String rol;
    protected List<String> intereses;

    public Usuario(int id, String email, String contraseña, String nombre,  String rol, List<String> intereses) {
        this.id = id;
        this.email = email;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.intereses = intereses;
        this.rol = rol;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }
}

