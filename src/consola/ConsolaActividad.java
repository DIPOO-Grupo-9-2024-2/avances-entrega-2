package consola;

import auth.Profesor;
import model.Actividad;
import model.ActividadConcreta;

import java.util.List;
import java.util.Scanner;

public class ConsolaActividad {

    private static Actividad actividadActual;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú Actividad ---");
            System.out.println("1. Crear Actividad");
            System.out.println("2. Ver Detalles de Actividad");
            System.out.println("3. Clonar Actividad");
            System.out.println("4. Marcar Actividad como Completada");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearActividad(scanner);
                    break;
                case 2:
                    verDetallesActividad();
                    break;
                case 3:
                    clonarActividad(scanner);
                    break;
                case 4:
                    marcarCompletada();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }

        scanner.close();
    }

    private static void crearActividad(Scanner scanner) {
        System.out.print("Ingresa el ID de la actividad: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingresa la descripción de la actividad: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingresa el objetivo de la actividad: ");
        String objetivo = scanner.nextLine();

        System.out.print("Ingresa la duración esperada (en minutos): ");
        int duracionEsperada = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Es obligatoria? (true/false): ");
        boolean esObligatoria = scanner.nextBoolean();

        actividadActual = new ActividadConcreta(id, descripcion, objetivo, duracionEsperada, esObligatoria);
        System.out.println("¡Actividad creada exitosamente!");
    }

    private static void verDetallesActividad() {
        if (actividadActual == null) {
            System.out.println("No hay actividad creada.");
        } else {
            System.out.println("Detalles de la Actividad:");
            System.out.println(actividadActual);
        }
    }

    private static void clonarActividad(Scanner scanner) {
        if (actividadActual == null) {
            System.out.println("No hay actividad creada para clonar.");
            return;
        }
        System.out.println("Ingrese el id del profesor: ");
        int id=scanner.nextInt();
        System.out.print("Ingresa el nombre del nuevo creador (Profesor): ");
        String nombreProfesor = scanner.nextLine();
        System.out.print("Ingresa el email del nuevo creador (Profesor): ");
        String email = scanner.nextLine();
        System.out.print("Ingresa la contraseña del nuevo creador(Profesor): ");
        String contrasena = scanner.nextLine();
        System.out.print("Ingresa el rol (Profesor): ");
        String rol = scanner.nextLine();
        System.out.println("Ingrese sus intereses: ");
        System.out.print("Ingresa los intereses separados por comas: ");
        String interesesInput = scanner.nextLine(); 
        List<String> intereses = List.of(interesesInput.split(",\\s*"));
        
        

        Profesor nuevoCreador = new Profesor(id,nombreProfesor,email,contrasena,rol,intereses);
        Actividad clon = actividadActual.clonar(nuevoCreador);
        System.out.println("Actividad clonada exitosamente:");
        System.out.println(clon);
    }

    private static void marcarCompletada() {
        if (actividadActual == null) {
            System.out.println("No hay actividad creada para marcar como completada.");
            return;
        }

        actividadActual.marcarCompletada();
        System.out.println("¡La actividad ha sido marcada como completada!");
    }
}
