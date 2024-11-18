package model;

public class Encuesta extends Actividad {
    private String preguntasAbiertas;

    public Encuesta(int id, String descripcion, String objetivo, int duracionEsperada, String preguntasAbiertas, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        this.preguntasAbiertas = preguntasAbiertas;
    }

    @Override
    public boolean completar() {
        // Simula la lógica de completado de la encuesta
        this.marcarCompletada();
        this.establecerResultado("Encuesta completada");
        return true;
    }

    // Getters y setters
    public String getPreguntasAbiertas() {
        return preguntasAbiertas;
    }

    public void setPreguntasAbiertas(String preguntasAbiertas) {
        this.preguntasAbiertas = preguntasAbiertas;
    }
}
