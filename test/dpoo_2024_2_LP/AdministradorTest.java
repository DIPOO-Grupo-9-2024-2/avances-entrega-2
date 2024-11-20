package dpoo_2024_2_LP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auth.Administrador;
import auth.Usuario;
import model.LearningPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AdministradorTest {

    private Administrador administrador;
    private List<Usuario> usuarios;
    private List<LearningPath> learningPaths;
    @BeforeEach
    public void setUp() {
    	
        administrador = new Administrador(1, "Admin", "admin@dominio.com", "admin123", "Administrador", List.of("Gestión", "Educación"));
        usuarios = new ArrayList<>();
        learningPaths = new ArrayList<>();
        usuarios.add(new Usuario(2, "Usuario1", "user1@dominio.com", "pass1", "Estudiante", List.of("Java")) {});
        usuarios.add(new Usuario(3, "Usuario2", "user2@dominio.com", "pass2", "Estudiante", List.of("Python")) {});
        LearningPath lp1 = new LearningPath(1, "LP1", "Descripción LP1", "Intermedio", 90, 4.2, "1.1");
        LearningPath lp2 = new LearningPath(2, "LP2", "Descripción LP2", "Avanzado", 150, 4.8, "2.0");
        learningPaths.add(lp1);
        learningPaths.add(lp2);
    }

    @Test
    public void testGestionarUsuarios() {
    	int tamañoInicial = usuarios.size();
        administrador.gestionarUsuarios(usuarios);

        assertNotSame(tamañoInicial, usuarios.size() + 1, "Debería haberse añadido un nuevo usuario");
        assertEquals("Usuario Modificado", usuarios.get(0).getNombre(), "El nombre del primer usuario debería haberse modificado");
        assertEquals(tamañoInicial, usuarios.size(), "El tamaño de la lista de usuarios debería ser igual al tamaño inicial después de la eliminación");
    }

    @Test
    public void testGestionarLearningPaths() {
        int tamañoInicial = learningPaths.size();

        administrador.gestionarLearningPaths(learningPaths);

        assertNotSame(tamañoInicial, learningPaths.size() + 1, "Debería haberse añadido un nuevo Learning Path");

        assertEquals("Learning Path Modificado", learningPaths.get(0).getTitulo(), "El título del primer Learning Path debería haberse modificado");

        assertEquals(tamañoInicial, learningPaths.size(), "El tamaño de la lista de Learning Paths debería ser igual al tamaño inicial después de la eliminación");
    }

    @Test
    public void testVerEstadisticasGlobales() {
        Map<String, Object> estadisticas = administrador.verEstadisticasGlobales(learningPaths);

        assertEquals(learningPaths.size(), estadisticas.get("Total Learning Paths"), "El total de Learning Paths debería coincidir");
        assertEquals(0, estadisticas.get("Total Estudiantes"), "El total de estudiantes debería ser 0 (sin lógica de estudiantes implementada)");
        
        int totalActividadesEsperado = learningPaths.stream().mapToInt(lp -> lp.getActividades().size()).sum();
        assertEquals(totalActividadesEsperado, estadisticas.get("Total Actividades"), "El total de actividades debería coincidir con la suma de las actividades de los Learning Paths");
    }
}