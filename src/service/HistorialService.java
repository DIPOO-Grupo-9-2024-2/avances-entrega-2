package service;

import model.HistorialActividad;
import java.util.List;

public class HistorialService {

    // Método para listar el historial de actividades completadas
    public List<HistorialActividad> listarHistorial(List<HistorialActividad> historialActividades) {
        return historialActividades;
    }

    // Método para obtener los detalles de una actividad completada específica
    public HistorialActividad obtenerDetallesHistorial(HistorialActividad historial) {
        return historial;
    }

    // Método para mostrar el historial de actividades en formato legible
    public void mostrarHistorial(List<HistorialActividad> historialActividades) {
        historialActividades.forEach(historial -> System.out.println(historial));
    }
}
