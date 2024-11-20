package service;

import model.Actividad;
import java.util.List;

public class ActividadService {


    public void completarActividad(Actividad actividad) {
        actividad.completar();
    }


    public List<Actividad> listarActividadesPendientes(List<Actividad> actividades) {
        return actividades.stream()
            .filter(actividad -> actividad.getEstado().equals("pendiente"))
            .toList();
    }


    public String obtenerEstadoActividad(Actividad actividad) {
        return actividad.getEstado();
    }
}
