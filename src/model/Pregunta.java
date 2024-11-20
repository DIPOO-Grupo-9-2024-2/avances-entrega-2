package model;

import java.util.List;

public class Pregunta {
    private String texto;               
    private List<String> opciones;          
    private String respuestaCorrecta;   
    private String explicacion;        


    public Pregunta(String texto, List<String> list, String respuestaCorrecta, String explicacion) {
        this.texto = texto;
        this.opciones = list;
        this.respuestaCorrecta = respuestaCorrecta;
        this.explicacion = explicacion;
    }


    public boolean esCorrecta(String respuestaEstudiante) {
        return respuestaCorrecta.equals(respuestaEstudiante);
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
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


