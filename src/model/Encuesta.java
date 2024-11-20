package model;

public class Encuesta extends Actividad {
    private String preguntasAbiertas;

    public Encuesta(int id, String descripcion, String objetivo, int duracionEsperada, String preguntasAbiertas, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        this.preguntasAbiertas = preguntasAbiertas;
    }

    @Override
    public boolean completar() {

        this.marcarCompletada();
        this.establecerResultado("Encuesta completada");
        return true;
    }


    public String getPreguntasAbiertas() {
        return preguntasAbiertas;
    }

    public void setPreguntasAbiertas(String preguntasAbiertas) {
        this.preguntasAbiertas = preguntasAbiertas;
    }
}
