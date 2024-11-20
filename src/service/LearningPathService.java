package service;

import java.time.LocalDateTime;
import java.util.List;
import model.Actividad;
import model.HistorialActividad;
import model.LearningPath;
import model.Notificacion;
import model.Progreso;

public class LearningPathService {
    private Progreso progreso;


    public void agregarActividad(LearningPath learningPath, Actividad actividad) {
        learningPath.agregarActividad(actividad);
        actualizarProgreso(learningPath);
    }


    public void actualizarProgreso(LearningPath learningPath) {
        int totalActividades = learningPath.getActividades().size();
        int actividadesCompletadas = (int) learningPath.getActividades().stream()
                .filter(actividad -> actividad.getEstado().equals("completada"))
                .count();
        progreso = new Progreso(totalActividades, actividadesCompletadas);
        System.out.println("Progreso actualizado: " + progreso.getPorcentajeProgreso() + "%");
    }
    public void registrarActividadCompletada(LearningPath learningPath, Actividad actividad, String resultado) {
        HistorialActividad historial = new HistorialActividad(actividad, LocalDateTime.now());
        learningPath.getHistorialActividades().add(historial);
        actualizarProgreso(learningPath);
    }


    public int obtenerProgreso() {
        return progreso.getPorcentajeProgreso();
    }
    

    public void enviarNotificacionPendiente(LearningPath learningPath) {
        List<Actividad> actividadesPendientes = learningPath.getActividades().stream()
            .filter(actividad -> actividad.getEstado().equals("pendiente"))
            .toList();
        
        if (!actividadesPendientes.isEmpty()) {
            Notificacion notificacion = new Notificacion("Tienes actividades pendientes en el Learning Path: " + learningPath.getTitulo());
            System.out.println("Notificación enviada: " + notificacion);
        }
    }

    public void calcularTasasExitoFracaso(LearningPath learningPath) {
        List<HistorialActividad> historialActividades = learningPath.getHistorialActividades();
        int totalActividades = historialActividades.size();
        int exitos = 0;
        int fracasos = 0;

        for (HistorialActividad historial : historialActividades) {
            if (historial.getResultado().toLowerCase().contains("aprobado")) {
                exitos++;
            } else {
                fracasos++;
            }
        }

        if (totalActividades > 0) {
            double tasaExito = (double) exitos / totalActividades * 100;
            double tasaFracaso = (double) fracasos / totalActividades * 100;

            System.out.println("Tasa de éxito: " + tasaExito + "%");
            System.out.println("Tasa de fracaso: " + tasaFracaso + "%");
        } else {
            System.out.println("No hay actividades registradas.");
        }
    }

}


