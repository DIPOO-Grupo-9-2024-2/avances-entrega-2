package test.test_model;

import model.Actividad;

public class TareaPrueba extends Actividad {
    public TareaPrueba(int id, String descripcion, String objetivo, int duracionEsperada, boolean esObligatoria) {
        super(id, descripcion, objetivo, duracionEsperada, esObligatoria);
    }

    @Override
    public boolean completar() {
        // Lógica específica de completar la tarea
        this.marcarCompletada();
        this.establecerResultado("Tarea completada con éxito");
        return true;
    }
}   


