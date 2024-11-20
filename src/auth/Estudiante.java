package auth;

import java.util.ArrayList;
import java.util.List;
import model.LearningPath;
import model.Actividad;
import model.Calificacion;
import model.Progreso;

public class Estudiante extends Usuario {
    private List<LearningPath> learningPathsInscritos;
    private List<Actividad> actividadesInscritas; 
    public ArrayList<Object> calificaciones;

    public Estudiante(int id, String email, String contraseña, String nombre, String rol, List<String> intereses) {
        super(id, email, contraseña, nombre, rol, intereses);
        this.learningPathsInscritos = new ArrayList<>();
        this.actividadesInscritas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }


    public void inscribirLearningPath(LearningPath learningPath) {
        learningPathsInscritos.add(learningPath);
    }


    public void inscribirActividad(Actividad actividad) {
        actividadesInscritas.add(actividad);  
    }


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


    public Progreso getProgreso(Actividad actividad) {
        int totalActividades = actividadesInscritas.size();
        int actividadesCompletadas = 0;


        for (Actividad act : actividadesInscritas) {
            if (act.equals(actividad)) { 
                actividadesCompletadas++;
            }
        }

        return new Progreso(totalActividades, actividadesCompletadas);
    }


    public void actualizarProgreso(Actividad actividad, Calificacion calificacion) {
        calificaciones.add(calificacion);
    }


    public ArrayList<Object> getCalificaciones() {
        return calificaciones;
    }


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
}



