package service;

import model.HistorialActividad;
import java.util.List;

public class HistorialService {

    public List<HistorialActividad> listarHistorial(List<HistorialActividad> historialActividades) {
        return historialActividades;
    }


    public HistorialActividad obtenerDetallesHistorial(HistorialActividad historial) {
        return historial;
    }


    public static void mostrarHistorial(List<HistorialActividad> historialActividades) {
        historialActividades.forEach(historial -> System.out.println(historial));
    }
}
