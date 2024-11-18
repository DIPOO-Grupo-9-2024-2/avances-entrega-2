package model;

import java.util.List;

public class PreguntaCerrada extends Pregunta {
    private List<String> opciones;
    private String respuestaCorrecta;

    public PreguntaCerrada(String enunciado, List<String> list, String respuestaCorrecta) {
        super(enunciado, list, respuestaCorrecta, null);
        this.opciones = list;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean esCorrecta(String respuesta) {
        return respuesta.equalsIgnoreCase(respuestaCorrecta);
    }

    public List<String> getOpciones() {
        return opciones;
    }
}
