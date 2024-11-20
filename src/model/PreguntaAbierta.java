package model;

public class PreguntaAbierta extends Pregunta {
    private String respuestaEsperada;

    public PreguntaAbierta(String texto, String respuestaEsperada, String explicacion) {
        super(texto, null, respuestaEsperada, explicacion);
        this.respuestaEsperada = respuestaEsperada;
    }


    @Override
    public boolean esCorrecta(String respuestaEstudiante) {
        return respuestaEsperada.equalsIgnoreCase(respuestaEstudiante.trim());
    }


    public String getRespuestaEsperada() {
        return respuestaEsperada;
    }

    public void setRespuestaEsperada(String respuestaEsperada) {
        this.respuestaEsperada = respuestaEsperada;
    }
}
