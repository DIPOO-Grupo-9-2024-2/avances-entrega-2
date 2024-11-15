package consola;

import java.util.List;
import model.Actividad;
import model.LearningPath;

public class mostrarInfo extends ConsolaBasica {
    
    private final String[] opcionesUsarGaleria = new String[]{ "Mostrar Learning Paths", "Regresar" };
	

    private List<LearningPath> LPS;

    public mostrarInfo(List<LearningPath> LPS) {
        this.LPS = LPS;
    }

    public void mostrarMenu(){

        boolean regresar = false;

        while (!regresar) {
            int opcionSeleccion = mostrarMenu("Menu info basica LP", opcionesUsarGaleria);
            if (opcionSeleccion == 1) {
            	System.out.println("Learning Paths: " + LPS.size());
                for (LearningPath LP : LPS) {
                    System.out.println("Nombre: " + LP.getTitulo());
                    System.out.println("Descripcion: " + LP.getDescripcion());
                    System.out.println("Actividades: ");
                    for (Actividad ac : LP.getActividades()) {
                        System.out.println("Descipcion:" + ac.getDescripcion());
                        System.out.println("Objetivo: " + ac.getObjetivo());
                        System.out.println("Estado: " + ac.getEstado());
                    }
                    System.out.println(" ");
                }
            } else if (opcionSeleccion == 2) {
                regresar = true;
            }

    }
}


}


