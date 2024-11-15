package auth;

import java.util.ArrayList;
import java.util.List;
import model.LearningPath;

public class Estudiante extends Usuario {
    private List<LearningPath> learningPathsInscritos;

    public Estudiante(int id, String email, String contraseña, String nombre, String rol, List<String> intereses) {
        super(id, email, contraseña, nombre, rol, intereses);
        this.learningPathsInscritos = new ArrayList<>();
    }

    // Método para inscribirse en un Learning Path
    public void inscribirLearningPath(LearningPath learningPath) {
        learningPathsInscritos.add(learningPath);
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

    // Getters y setters
    public List<LearningPath> getLearningPathsInscritos() {
        return learningPathsInscritos;
    }

    public void setLearningPathsInscritos(List<LearningPath> learningPathsInscritos) {
        this.learningPathsInscritos = learningPathsInscritos;
    }
}

