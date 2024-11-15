package model;

import java.util.ArrayList;
import java.util.List;

public class LearningPath {
    private int id;
    private String titulo;
    private String descripcion;
    private List<Actividad> actividades;
    private List<HistorialActividad> historialActividades; // Lista de actividades completadas
    private int progreso;

    public LearningPath(int id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.actividades = new ArrayList<>();
        this.historialActividades = new ArrayList<>();
        this.progreso = 0;
    }
    
    // Método para iniciar una actividad
    public void iniciarActividad(Actividad actividad) {
        HistorialActividad historial = new HistorialActividad(actividad, java.time.LocalDateTime.now());
        historialActividades.add(historial);
    }
    
    // Método para agregar una actividad al Learning Path
    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    // Método para calcular el progreso basado en actividades obligatorias completadas
    public int calcularProgreso() {
        int actividadesObligatorias = 0;
        int actividadesCompletadas = 0;
        for (Actividad actividad : actividades) {
            if (actividad.esObligatoria()) {
                actividadesObligatorias++;
                for (HistorialActividad historial : historialActividades) {
                    if (historial.getActividad().equals(actividad) && historial.getFechaCompletada() != null) {
                        actividadesCompletadas++;
                        break;
                    }
                }
            }
        }
        if (actividadesObligatorias > 0) {
            this.progreso = (actividadesCompletadas * 100) / actividadesObligatorias;
        } else {
            this.progreso = 100;  // Si no hay actividades obligatorias, el progreso es 100%
        }
        return this.progreso;
    }

    // Método para registrar la actividad completada con tiempo dedicado
    public void completarActividad(Actividad actividad, String resultado) {
        for (HistorialActividad historial : historialActividades) {
            if (historial.getActividad().equals(actividad) && historial.getFechaCompletada() == null) {
                historial.completar(resultado);
                break;
            }
        }
    }

    // Nuevo método para resolver un Quiz de Verdadero/Falso
    public boolean resolverQuizVerdaderoFalso(QuizVerdaderoFalso quiz, boolean respuesta) {
        boolean esCorrecto = quiz.evaluar(respuesta);
        String resultado = esCorrecto ? "Correcto" : "Incorrecto";
        completarActividad(quiz, resultado);
        return esCorrecto;
    }

    // Getter para obtener el historial de actividades completadas
    public List<HistorialActividad> getHistorialActividades() {
        return historialActividades;
    }

    // Getters y setters adicionales
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    public void setHistorialActividades(List<HistorialActividad> historialActividades) {
        this.historialActividades = historialActividades;
    }
}




