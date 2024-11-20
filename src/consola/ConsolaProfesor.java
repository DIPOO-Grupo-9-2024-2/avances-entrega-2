package consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Actividad;
import model.ActividadConcreta;
import model.LearningPath;
import auth.Profesor;

public class ConsolaProfesor {
    private Profesor profesor;
    private List<LearningPath> learningPaths;
    private Scanner scanner;

    public ConsolaProfesor(Profesor profesor) {
        this.profesor = profesor;
        this.learningPaths = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("Menú - Profesor");
            System.out.println("1. Crear LearningPath");
            System.out.println("2. Editar LearningPath");
            System.out.println("3. Asignar Actividad");
            System.out.println("4. Listar LearningPaths");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearLearningPath();
                    break;
                case 2:
                    editarLearningPath();
                    break;
                case 3:
                    asignarActividad();
                    break;
                case 4:
                    listarLearningPaths();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void crearLearningPath() {
        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese el titulo: ");
        String titulo=scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el nivel de dificultad: ");
        String nivelDificultad= scanner.nextLine();
        System.out.print("Ingrese la duración en minutos: ");
        int duracionMinutos = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Ingrese el rating: ");
        double rating = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Ingrese la versión: ");
        String version = scanner.nextLine();
        
        LearningPath lp = profesor.crearLearningPath(id, titulo,descripcion, nivelDificultad,duracionMinutos, rating, version);
        learningPaths.add(lp);
        System.out.println("LearningPath creado exitosamente.");
    }

    private void editarLearningPath() {
        System.out.print("Ingrese el ID del LearningPath a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        LearningPath lp = buscarLearningPath(id);
        if (lp != null) {
            System.out.println("Ingrese el nuevo titulo");
            String nuevoTitulo=scanner.nextLine();
        	System.out.print("Ingrese la nueva descripción: ");
            String nuevaDescripcion = scanner.nextLine();
            System.out.println("Ingrese el neuvo nivel de dificultad");
            String nuevoNivelDificultad=scanner.nextLine();
            System.out.print("Ingrese la nueva duración en minutos: ");
            int nuevaDuracion = scanner.nextInt();
            profesor.editarLearningPath(lp, nuevoTitulo,nuevaDescripcion,nuevoNivelDificultad,nuevaDuracion);
            System.out.println("LearningPath editado exitosamente.");
        } else {
            System.out.println("LearningPath no encontrado.");
        }
        }
    

    private void asignarActividad() {
    	System.out.print("Ingrese el id: ");
        int id = scanner.nextInt();
    	System.out.print("Ingrese la descripción de la actividad: ");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el objetivo: ");
        String objetivo=scanner.nextLine();
        System.out.print("Ingrese la duración en minutos: ");
        int duracionEsperada = scanner.nextInt();
        scanner.nextLine(); 

        Actividad actividad = new ActividadConcreta(id, descripcion,objetivo, duracionEsperada, false);
        System.out.println("Asignando actividad...");
        profesor.asignarActividad(actividad, new ArrayList<>());
        System.out.println("Actividad asignada exitosamente.");
    }
   

    private void listarLearningPaths() {
        System.out.println("LearningPaths:");
        for (LearningPath lp : learningPaths) {
            System.out.println(lp.getId() + ": " + lp.getDescripcion());
        }
    }

    private LearningPath buscarLearningPath(int id) {
        for (LearningPath lp : learningPaths) {
            if (lp.getId() == id) {
                return lp;
            }
        }
        return null;
    }
}
