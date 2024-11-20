package model;

import auth.Profesor;

public abstract class Actividad implements Cloneable { 
    private int id;
    private String descripcion;
    private String objetivo;
    private int duracionEsperada;
    private String estado;
    private String resultado;
    private boolean esObligatoria;

    public Actividad(int id, String descripcion, String objetivo, int duracionEsperada, boolean esObligatoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.duracionEsperada = duracionEsperada;
        this.estado = "pendiente";
        this.resultado = "";
        this.esObligatoria = esObligatoria;
    }


    public abstract boolean completar();

 
    public void marcarCompletada() {
        this.estado = "completada";
    }


    public void establecerResultado(String resultado) {
        this.resultado = resultado;
    }


    public Actividad clonar(Profesor nuevoCreador) {
        try {
            Actividad clon = (Actividad) this.clone(); 
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar la actividad");
        }
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }

    public boolean esObligatoria() {
        return esObligatoria;
    }

    public void setObligatoria(boolean esObligatoria) {
        this.esObligatoria = esObligatoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getDuracionEsperada() {
        return duracionEsperada;
    }

    public void setDuracionEsperada(int duracionEsperada) {
        this.duracionEsperada = duracionEsperada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Actividad ID: " + id + ", Descripción: " + descripcion + ", Estado: " + estado + ", Resultado: " + resultado;
    }

    public boolean isEsObligatoria() {
        return esObligatoria;
    }

    public void setEsObligatoria(boolean esObligatoria) {
        this.esObligatoria = esObligatoria;
    }
}

