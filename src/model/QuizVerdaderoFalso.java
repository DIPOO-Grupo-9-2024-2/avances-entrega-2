package model;

public class QuizVerdaderoFalso extends Actividad {
    private boolean respuestaCorrecta;

    public QuizVerdaderoFalso(int id, String descripcion, String objetivo, int duracionEsperada, 
                              boolean esObligatoria, boolean respuestaCorrecta) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    // Evaluar si la respuesta dada por el usuario es correcta
    public boolean evaluar(boolean respuestaUsuario) {
        return this.respuestaCorrecta == respuestaUsuario;
    }

    @Override
    public boolean completar() {
        // Este método puede usarse para marcar el quiz como completado
        super.marcarCompletada();
        return true; // Quiz completado
    }

    // Getters y setters
    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
