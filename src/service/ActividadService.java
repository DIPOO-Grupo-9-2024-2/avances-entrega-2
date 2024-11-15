package service;

import model.Actividad;
import java.util.List;

public class ActividadService {

    // Método para marcar una actividad como completada
    public void completarActividad(Actividad actividad) {
        actividad.completar();
    }

    // Método para listar actividades pendientes en un Learning Path
    public List<Actividad> listarActividadesPendientes(List<Actividad> actividades) {
        return actividades.stream()
            .filter(actividad -> actividad.getEstado().equals("pendiente"))
            .toList();
    }

    // Método para obtener el estado de una actividad
    public String obtenerEstadoActividad(Actividad actividad) {
        return actividad.getEstado();
    }
}
