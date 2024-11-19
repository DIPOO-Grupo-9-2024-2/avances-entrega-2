package auth;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import model.Actividad;
import model.Calificacion;
import model.LearningPath;
import model.Progreso;


    

public class Profesor extends Usuario {
    private List<LearningPath> learningPathsCreados;

    public Profesor(int id, String nombre, String email, String contrasena, String rol,List<String> intereses) {
        super(id, nombre, email, contrasena, rol,intereses);
        this.learningPathsCreados = new ArrayList<>();
    }

    public LearningPath crearLearningPath(int id, String titulo, String descripcion, String nivelDificultad, int duracionMinutos, double rating, String version) {
        LearningPath nuevoPath = new LearningPath(id, titulo, descripcion, nivelDificultad, duracionMinutos, rating, version);
        nuevoPath.setFechaCreacion(LocalDateTime.now()); 
        learningPathsCreados.add(nuevoPath);
        return nuevoPath;
    }


    public void editarLearningPath(LearningPath lp, String nuevoTitulo, String nuevaDescripcion, String nuevoNivelDificultad, int nuevaDuracion) {
        if (learningPathsCreados.contains(lp)) {
            lp.setTitulo(nuevoTitulo);
            lp.setDescripcion(nuevaDescripcion);
            lp.setNivelDificultad(nuevoNivelDificultad);
            lp.setDuracionMinutos(nuevaDuracion);
            lp.setFechaModificacion(LocalDateTime.now()); // Usa LocalDateTime para establecer la fecha actual
            System.out.println("Learning Path actualizado correctamente.");
        } else {
            System.out.println("Error: No tienes permisos para editar este Learning Path.");
        }
    }

    public void asignarActividad(Actividad actividad, List<Estudiante> estudiantes) {
        for (Estudiante estudiante : estudiantes) {
            estudiante.inscribirActividad(actividad); 
        }
    }

    public void calificarActividad(Actividad actividad, Estudiante estudiante, int calificacion, String feedback) {
        Calificacion calif = new Calificacion(calificacion, feedback);
        estudiante.actualizarProgreso(actividad, calif);
        System.out.println("Actividad calificada correctamente.");
    }

    public List<Progreso> verProgresoEstudiantes(LearningPath lp) {
        List<Progreso> progresos = new ArrayList<>();
        for (Estudiante estudiante : lp.getEstudiantesInscritos()) {
            progresos.add(estudiante.getProgreso(lp));
        }
        return progresos;
    }
}
