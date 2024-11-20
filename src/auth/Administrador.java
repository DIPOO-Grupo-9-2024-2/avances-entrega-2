package auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.LearningPath;

public class Administrador extends Usuario {

    public Administrador(int id, String nombre, String email, String contraseña, String rol, List<String> intereses) {
        super(id, nombre, email, contraseña, rol, intereses);
    }

    public void gestionarUsuarios(List<Usuario> usuarios) {
        Usuario nuevoUsuario = new Usuario(5, "Nuevo Usuario", "nuevo@dominio.com", "contraseña", "Estudiante", List.of("Java", "Python")) {};
        usuarios.add(nuevoUsuario);

        if (!usuarios.isEmpty()) {
            Usuario usuarioModificar = usuarios.get(0);
            usuarioModificar.setNombre("Usuario Modificado");
        }

        if (!usuarios.isEmpty()) {
            usuarios.remove(usuarios.size() - 1);
        }
    }
 
    public void gestionarLearningPaths(List<LearningPath> learningPaths) {
        LearningPath nuevoLearningPath = new LearningPath(
            101,                               
            "Nuevo Learning Path",             
            "Este es un aprendizaje básico.", 
            "Básico",                          
            120,                              
            4.5,                               
            "1.0"                              
        );
        learningPaths.add(nuevoLearningPath);


        if (!learningPaths.isEmpty()) {
            LearningPath lpModificar = learningPaths.get(0);
            lpModificar.setTitulo("Learning Path Modificado");
        }


        if (!learningPaths.isEmpty()) {
            learningPaths.remove(learningPaths.size() - 1);
        }
    }

    public Map<String, Object> verEstadisticasGlobales(List<LearningPath> learningPaths) {
        Map<String, Object> estadisticas = new HashMap<>();
        int totalLearningPaths = learningPaths.size();
        int totalEstudiantes = 0;  
        int totalActividades = 0;

        for (LearningPath lp : learningPaths) {
            totalActividades += lp.getActividades().size();
        }

        estadisticas.put("Total Learning Paths", totalLearningPaths);
        estadisticas.put("Total Estudiantes", totalEstudiantes);
        estadisticas.put("Total Actividades", totalActividades);

        return estadisticas;
    }
}

