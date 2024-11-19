package auth;

import java.util.ArrayList;
import java.util.List;
import model.LearningPath;
import model.Actividad;
import model.Calificacion;
import model.Progreso;

public class Estudiante extends Usuario {
    private List<LearningPath> learningPathsInscritos;
    private List<Actividad> actividadesInscritas;  // Lista de actividades
    private ArrayList<Object> calificaciones;

    public Estudiante(int id, String email, String contraseña, String nombre, String rol, List<String> intereses) {
        super(id, email, contraseña, nombre, rol, intereses);
        this.learningPathsInscritos = new ArrayList<>();
        this.actividadesInscritas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    // Método para inscribirse en un Learning Path
    public void inscribirLearningPath(LearningPath learningPath) {
        learningPathsInscritos.add(learningPath);
    }

    // Método para inscribirse en una actividad
    public void inscribirActividad(Actividad actividad) {
        actividadesInscritas.add(actividad);  // Agrega la actividad a la lista
    }

    // Método para obtener recomendaciones en base a intereses
    public List<LearningPath> recomendarLearningPaths(List<LearningPath> todosLosLearningPaths) {
        List<LearningPath> recomendados = new ArrayList<>();
        for (LearningPath lp : todosLosLearningPaths) {
            for (String interes : this.getIntereses()) {
                if (lp.getDescripcion().toLowerCase().contains(interes.toLowerCase())) {
                    recomendados.add(lp);
                    break;
                }
            }
        }
        return recomendados;
    }

    // Nuevo método para obtener el progreso de una actividad
    public Progreso getProgreso(Actividad actividad) {
        int totalActividades = actividadesInscritas.size();
        int actividadesCompletadas = 0;

        // Simulación: Contar actividades completadas (puedes ajustarlo según la lógica real)
        for (Actividad act : actividadesInscritas) {
            if (act.equals(actividad)) { // Puedes agregar condiciones más específicas si es necesario
                actividadesCompletadas++;
            }
        }

        return new Progreso(totalActividades, actividadesCompletadas);
    }

    // Getters y setters
    public List<LearningPath> getLearningPathsInscritos() {
        return learningPathsInscritos;
    }

    public void setLearningPathsInscritos(List<LearningPath> learningPathsInscritos) {
        this.learningPathsInscritos = learningPathsInscritos;
    }

    public List<Actividad> getActividadesInscritas() {
        return actividadesInscritas;
    }

    public void setActividadesInscritas(List<Actividad> actividadesInscritas) {
        this.actividadesInscritas = actividadesInscritas;
    }

    public void actualizarProgreso(Actividad actividad, Calificacion calificacion) {
        calificaciones.add(calificacion);
    }
}


