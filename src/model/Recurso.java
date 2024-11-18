package model;

public class Recurso extends Actividad {
    private String tipo;  // Tipo de recurso, por ejemplo, "video", "artículo"
    private String fuente; // URL o fuente del recurso

    public Recurso(int id, String descripcion, String objetivo, int duracionEsperada, String tipo, String fuente, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        this.tipo = tipo;
        this.fuente = fuente;
    }

    @Override
    public boolean completar() {
        this.marcarCompletada();
        this.establecerResultado("Recurso completado");

        return true;
    }

    // Getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
}

