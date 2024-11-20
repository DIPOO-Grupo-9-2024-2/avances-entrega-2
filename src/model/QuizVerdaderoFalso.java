package model;

public class QuizVerdaderoFalso extends Actividad {
    private boolean respuestaCorrecta;

    public QuizVerdaderoFalso(int id, String descripcion, String objetivo, int duracionEsperada, 
                              boolean esObligatoria, boolean respuestaCorrecta) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        this.respuestaCorrecta = respuestaCorrecta;
    }


    public boolean evaluar(boolean respuestaUsuario) {
        return this.respuestaCorrecta == respuestaUsuario;
    }

    @Override
    public boolean completar() {

        super.marcarCompletada();
        return true; 
    }

    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
