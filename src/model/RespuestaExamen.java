package model;

public class RespuestaExamen {
    private Pregunta pregunta;          // La pregunta a la que el estudiante respondió
    private String respuestaEstudiante; // La respuesta dada por el estudiante
    private boolean correcta;           // Indica si la respuesta es correcta o no

    // Constructor que recibe la pregunta y la respuesta del estudiante
    public RespuestaExamen(Pregunta pregunta, String respuestaEstudiante) {
        this.pregunta = pregunta;
        this.respuestaEstudiante = respuestaEstudiante;
        // Verifica si la respuesta del estudiante es correcta
        this.correcta = pregunta.esCorrecta(respuestaEstudiante);
    }

    // Getters y setters
    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaEstudiante() {
        return respuestaEstudiante;
    }

    public void setRespuestaEstudiante(String respuestaEstudiante) {
        this.respuestaEstudiante = respuestaEstudiante;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }
}


