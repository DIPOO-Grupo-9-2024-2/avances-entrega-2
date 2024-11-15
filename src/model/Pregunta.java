package model;

public class Pregunta {
    private String texto;               // El enunciado de la pregunta
    private String[] opciones;          // Opciones de respuesta (en caso de ser de opción múltiple)
    private String respuestaCorrecta;   // La respuesta correcta
    private String explicacion;         // Explicación de la respuesta correcta

    // Constructor
    public Pregunta(String texto, String[] opciones, String respuestaCorrecta, String explicacion) {
        this.texto = texto;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.explicacion = explicacion;
    }

    // Método que verifica si la respuesta dada es correcta
    public boolean esCorrecta(String respuestaEstudiante) {
        return respuestaCorrecta.equals(respuestaEstudiante);
    }

    // Getters y setters
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }
}


