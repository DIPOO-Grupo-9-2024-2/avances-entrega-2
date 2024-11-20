package model;

public class Recurso extends Actividad {
    private String tipo;  
    private String fuente;

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

