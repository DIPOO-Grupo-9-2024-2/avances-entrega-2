package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LearningPath {
    private int id;
    private String titulo;
    private String descripcion;
    private List<Actividad> actividades;
    private List<HistorialActividad> historialActividades; // Lista de actividades completadas
    private int progreso;
    private String nivelDificultad;
    private int duracionMinutos; // Duración calculada en minutos
    private double rating;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String version;

    // Constructor actualizado con los nuevos atributos
    public LearningPath(int id, String titulo, String descripcion, String nivelDificultad, int duracionMinutos, double rating, String version) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.actividades = new ArrayList<>();
        this.historialActividades = new ArrayList<>();
        this.progreso = 0;
        this.nivelDificultad = nivelDificultad;
        this.duracionMinutos = duracionMinutos;
        this.rating = rating;
        this.fechaCreacion = LocalDateTime.now(); // Fecha actual para la creación
        this.fechaModificacion = LocalDateTime.now(); // Fecha de modificación inicial igual a la creación
        this.version = version;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	// Método para iniciar una actividad
    public void iniciarActividad(Actividad actividad) {
        HistorialActividad historial = new HistorialActividad(actividad, LocalDateTime.now());
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
    public List<HistorialActividad> getHistorialActividades() {
        return historialActividades;
    }

    public void setHistorialActividades(List<HistorialActividad> historialActividades) {
        this.historialActividades = historialActividades;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}






