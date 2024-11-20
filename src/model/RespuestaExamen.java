package model;

public class RespuestaExamen {
    private Pregunta pregunta;          
    private String respuestaEstudiante; 
    private boolean correcta;         


    public RespuestaExamen(Pregunta pregunta, String respuestaEstudiante) {
        this.pregunta = pregunta;

        this.correcta = pregunta.esCorrecta(respuestaEstudiante);
    }


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


