package consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import auth.Administrador;
import auth.Usuario;
import model.LearningPath;

public class ConsolaAdministrador {

    private final Scanner scanner = new Scanner(System.in);
    private final Administrador administrador;
    private final List<Usuario> usuarios;
    private final List<LearningPath> learningPaths;

    public ConsolaAdministrador(Administrador administrador, List<Usuario> usuarios, List<LearningPath> learningPaths) {
        this.administrador = administrador;
        this.usuarios = usuarios;
        this.learningPaths = learningPaths;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Consola Administrador ---");
            System.out.println("1. Gestionar usuarios");
            System.out.println("2. Gestionar Learning Paths");
            System.out.println("3. Ver estadísticas globales");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> gestionarUsuarios();
                case 2 -> gestionarLearningPaths();
                case 3 -> verEstadisticasGlobales();
                case 0 -> System.out.println("Saliendo de la consola del administrador.");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void gestionarUsuarios() {
        System.out.println("\n--- Gestión de Usuarios ---");
        administrador.gestionarUsuarios(usuarios);
        System.out.println("Usuarios gestionados exitosamente. Lista actualizada:");
        usuarios.forEach(usuario -> System.out.println("- " + usuario.getNombre()));
    }

    private void gestionarLearningPaths() {
        System.out.println("\n--- Gestión de Learning Paths ---");
        administrador.gestionarLearningPaths(learningPaths);
        System.out.println("Learning Paths gestionados exitosamente. Lista actualizada:");
        learningPaths.forEach(lp -> System.out.println("- " + lp.getTitulo()));
    }

    private void verEstadisticasGlobales() {
        System.out.println("\n--- Estadísticas Globales ---");
        Map<String, Object> estadisticas = administrador.verEstadisticasGlobales(learningPaths);
        estadisticas.forEach((clave, valor) -> System.out.println(clave + ": " + valor));
    }
}
