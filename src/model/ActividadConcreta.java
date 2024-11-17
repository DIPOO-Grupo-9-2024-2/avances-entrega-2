package model;

public class ActividadConcreta extends Actividad {

    public ActividadConcreta(int id, String descripcion, String objetivo, int duracionEsperada, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
    }

    @Override
    public boolean completar() {
        marcarCompletada();
        establecerResultado("Éxito");
        return true;
    }
}
