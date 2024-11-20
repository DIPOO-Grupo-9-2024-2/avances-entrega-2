package consola;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import model.LearningPath;
import model.Actividad;
import model.ActividadConcreta;
import model.QuizVerdaderoFalso;

public class ConsolaLearningPath {

    private final Scanner scanner = new Scanner(System.in);
    private final LearningPath learningPath;

    public ConsolaLearningPath(LearningPath learningPath) {
        this.learningPath = learningPath;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Consola Learning Path ---");
            System.out.println("1. Ver detalles del Learning Path");
            System.out.println("2. Agregar actividad");
            System.out.println("3. Iniciar actividad");
            System.out.println("4. Completar actividad");
            System.out.println("5. Calcular progreso");
            System.out.println("6. Resolver quiz de verdadero o falso");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> verDetalles();
                case 2 -> agregarActividad();
                case 3 -> iniciarActividad();
                case 4 -> completarActividad();
                case 5 -> calcularProgreso();
                case 6 -> resolverQuiz();
                case 0 -> System.out.println("Saliendo de la consola del Learning Path.");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void verDetalles() {
        System.out.println("\n--- Detalles del Learning Path ---");
        System.out.println("ID: " + learningPath.getId());
        System.out.println("Título: " + learningPath.getTitulo());
        System.out.println("Descripción: " + learningPath.getDescripcion());
        System.out.println("Nivel de dificultad: " + learningPath.getNivelDificultad());
        System.out.println("Duración (minutos): " + learningPath.getDuracionMinutos());
        System.out.println("Progreso: " + learningPath.getProgreso() + "%");
        System.out.println("Rating: " + learningPath.getRating());
        System.out.println("Fecha de creación: " + learningPath.getFechaCreacion());
        System.out.println("Fecha de modificación: " + learningPath.getFechaModificacion());
        System.out.println("Versión: " + learningPath.getVersion());
    }

   
    private void agregarActividad() {
        System.out.println("\n--- Agregar Actividad ---");
        System.out.println("Ingrese el id: ");
        int id= scanner.nextInt();
        System.out.print("Ingrese la descripción de la actividad: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el objetivo de la actividad: ");
        String objetivo = scanner.nextLine();
        System.out.print("Ingrese la duracion en minutos de la actividad: ");
        int duracionEsperada = scanner.nextInt();
        System.out.print("¿Es obligatoria? (true/false): ");
        boolean esObligatoria = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar buffer

        Actividad nuevaActividad = new ActividadConcreta(id,descripcion,objetivo,duracionEsperada,esObligatoria);
        learningPath.agregarActividad(nuevaActividad);
        System.out.println("Actividad agregada exitosamente.");
    }

    private void iniciarActividad() {
        System.out.println("\n--- Iniciar Actividad ---");
        System.out.print("Ingrese el ID de la actividad: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Actividad actividad = buscarActividadPorId(id);
        if (actividad != null) {
            learningPath.iniciarActividad(actividad);
            System.out.println("Actividad iniciada exitosamente.");
        } else {
            System.out.println("Actividad no encontrada.");
        }
    }

    private void completarActividad() {
        System.out.println("\n--- Completar Actividad ---");
        System.out.print("Ingrese el ID de la actividad: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el resultado de la actividad: ");
        String resultado = scanner.nextLine();

        Actividad actividad = buscarActividadPorId(id);
        if (actividad != null) {
            learningPath.completarActividad(actividad, resultado);
            System.out.println("Actividad completada exitosamente.");
        } else {
            System.out.println("Actividad no encontrada.");
        }
    }

    private void calcularProgreso() {
        System.out.println("\n--- Calcular Progreso ---");
        int progreso = learningPath.calcularProgreso();
        System.out.println("El progreso actual es: " + progreso + "%");
    }

    private void resolverQuiz() {
        System.out.println("\n--- Resolver Quiz de Verdadero o Falso ---");
        System.out.print("Ingrese el ID del quiz: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese su respuesta (true/false): ");
        boolean respuesta = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar buffer

        Actividad actividad = buscarActividadPorId(id);
        if (actividad instanceof QuizVerdaderoFalso quiz) {
            boolean resultado = learningPath.resolverQuizVerdaderoFalso(quiz, respuesta);
            System.out.println("Resultado del quiz: " + (resultado ? "Correcto" : "Incorrecto"));
        } else {
            System.out.println("El ID ingresado no corresponde a un quiz de verdadero o falso.");
        }
    }

    private Actividad buscarActividadPorId(int id) {
        return learningPath.getActividades().stream()
                .filter(actividad -> actividad.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
