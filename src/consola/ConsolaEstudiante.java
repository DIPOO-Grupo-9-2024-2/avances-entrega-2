package consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import auth.Estudiante;
import model.LearningPath;
import model.Actividad;
import model.Progreso;

public class ConsolaEstudiante {
    private Estudiante estudiante;
    private List<LearningPath> todosLosLearningPaths;
    private Scanner scanner;

    public ConsolaEstudiante(Estudiante estudiante, List<LearningPath> todosLosLearningPaths) {
        this.estudiante = estudiante;
        this.todosLosLearningPaths = todosLosLearningPaths;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("Menú - Estudiante");
            System.out.println("1. Ver LearningPaths recomendados");
            System.out.println("2. Inscribirse en un LearningPath");
            System.out.println("3. Ver LearningPaths inscritos");
            System.out.println("4. Inscribirse en una Actividad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    mostrarRecomendaciones();
                    break;
                case 2:
                    inscribirLearningPath();
                    break;
                case 3:
                    listarLearningPathsInscritos();
                    break;
                case 4:
                    inscribirActividad();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private void mostrarRecomendaciones() {
        List<LearningPath> recomendados = estudiante.recomendarLearningPaths(todosLosLearningPaths);
        if (recomendados.isEmpty()) {
            System.out.println("No hay LearningPaths recomendados según sus intereses.");
        } else {
            System.out.println("LearningPaths recomendados:");
            for (LearningPath lp : recomendados) {
                System.out.println(lp.getId() + ": " + lp.getDescripcion());
            }
        }
    }

    private void inscribirLearningPath() {
        System.out.print("Ingrese el ID del LearningPath que desea inscribirse: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        LearningPath lp = buscarLearningPath(id);
        if (lp != null) {
            estudiante.inscribirLearningPath(lp);
            System.out.println("Se ha inscrito exitosamente en el LearningPath.");
        } else {
            System.out.println("LearningPath no encontrado.");
        }
    }

    private void listarLearningPathsInscritos() {
        List<LearningPath> inscritos = estudiante.getLearningPathsInscritos();
        if (inscritos.isEmpty()) {
            System.out.println("No está inscrito en ningún LearningPath.");
        } else {
            System.out.println("LearningPaths inscritos:");
            for (LearningPath lp : inscritos) {
                System.out.println(lp.getId() + ": " + lp.getDescripcion());
            }
        }
    }
    private List<Actividad> obtenerActividadesDisponibles() {
        List<Actividad> actividadesDisponibles = new ArrayList<>();
        for (LearningPath lp : estudiante.getLearningPathsInscritos()) {
            actividadesDisponibles.addAll(lp.getActividades()); 
        }
        return actividadesDisponibles;
    }


    private void inscribirActividad() {
        System.out.println("Actividades disponibles:");
        List<Actividad> actividadesDisponibles = obtenerActividadesDisponibles();

        if (actividadesDisponibles.isEmpty()) {
            System.out.println("No hay actividades disponibles para inscribirse.");
            return;
        }

        for (int i = 0; i < actividadesDisponibles.size(); i++) {
            Actividad actividad = actividadesDisponibles.get(i);
            System.out.println((i + 1) + ". " + actividad.getDescripcion() + " - Duración: " + actividad.getDuracionEsperada() + " minutos");
        }

        System.out.print("Seleccione una actividad para inscribirse (número): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion < 1 || opcion > actividadesDisponibles.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        Actividad actividadSeleccionada = actividadesDisponibles.get(opcion - 1);
        estudiante.inscribirActividad(actividadSeleccionada);
        System.out.println("Te has inscrito a la actividad: " + actividadSeleccionada.getDescripcion());
    }


    private void verProgreso() {
        List<Actividad> actividades = estudiante.getActividadesInscritas();
        if (actividades.isEmpty()) {
            System.out.println("No tiene actividades inscritas.");
            return;
        }

        System.out.println("Actividades inscritas:");
        for (int i = 0; i < actividades.size(); i++) {
            Actividad act = actividades.get(i);
            System.out.println((i + 1) + ". " + act.getDescripcion() + " (Duración: " + act.getDuracionEsperada() + " minutos)");
        }

        System.out.print("Seleccione una actividad para ver su progreso: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (indice >= 0 && indice < actividades.size()) {
            Actividad actividadSeleccionada = actividades.get(indice);
            Progreso progreso = estudiante.getProgreso(actividadSeleccionada);
            System.out.println("Progreso de la actividad:");
            System.out.println("Total actividades inscritas: " + progreso.getTotalActividades());
            System.out.println("Actividades completadas: " + progreso.getActividadesCompletadas());
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private LearningPath buscarLearningPath(int id) {
        for (LearningPath lp : todosLosLearningPaths) {
            if (lp.getId() == id) {
                return lp;
            }
        }
        return null;
    }
}
