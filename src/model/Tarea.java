package model;

public class Tarea extends Actividad {
    private String instrucciones;

    public Tarea(int id, String descripcion, String objetivo, int duracionEsperada, String instrucciones, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        this.instrucciones = instrucciones;
    }

    @Override
    public boolean completar() {
        this.marcarCompletada();
        this.establecerResultado("Tarea completada con éxito");
        System.out.println("Tarea completada: " + this.getDescripcion());
        return true;
    }

    // Getters y setters
    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
}

