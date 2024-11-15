package model;

public class PreguntaAbierta extends Pregunta {
    private String respuestaEsperada;

    public PreguntaAbierta(String texto, String respuestaEsperada, String explicacion) {
        super(texto, null, respuestaEsperada, explicacion); // No hay opciones, ya que es abierta
        this.respuestaEsperada = respuestaEsperada;
    }

    // Verifica si la respuesta es correcta (en este caso, coincide con la esperada)
    @Override
    public boolean esCorrecta(String respuestaEstudiante) {
        return respuestaEsperada.equalsIgnoreCase(respuestaEstudiante.trim());
    }

    // Getters y setters
    public String getRespuestaEsperada() {
        return respuestaEsperada;
    }

    public void setRespuestaEsperada(String respuestaEsperada) {
        this.respuestaEsperada = respuestaEsperada;
    }
}
