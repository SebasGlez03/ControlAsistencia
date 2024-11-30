/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author limon
 */
public class EventoDTO {
    
    private String titulo;       // Título del evento
    private String descripcion;  // Descripción del evento
    private Date fechaInicio;    // Fecha de inicio del evento
    private Date fechaFinal;     // Fecha de finalización del evento
    private String horaInicio;   // Hora de inicio del evento
    private String horaFinal;    // Hora de finalización del evento
    private String campus;       // Campus donde se lleva a cabo el evento
    private String categoria;    // Categoría del evento
    
    /**
     * Constructor por defecto que inicializa un objeto de la clase Evento sin valores predefinidos.
     */
    public EventoDTO() {
    }

    /**
     * Constructor que permite crear un evento con todos los parámetros necesarios.
     * 
     * @param titulo Título del evento.
     * @param descripcion Descripción detallada del evento.
     * @param fechaInicio Fecha de inicio del evento.
     * @param fechaFinal Fecha de finalización del evento.
     * @param horaInicio Hora de inicio del evento en formato de 24 horas (HH:mm).
     * @param horaFinal Hora de finalización del evento en formato de 24 horas (HH:mm).
     * @param campus Nombre del campus donde se llevará a cabo el evento.
     * @param categoria Categoría o tipo de evento.
     */
    public EventoDTO(String titulo, String descripcion, Date fechaInicio, Date fechaFinal, 
                  String horaInicio, String horaFinal, String campus, String categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.campus = campus;
        this.categoria = categoria;
    }

    /**
     * Obtiene el título del evento.
     * 
     * @return El título del evento.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del evento.
     * 
     * @param titulo El título del evento.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción del evento.
     * 
     * @return La descripción del evento.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del evento.
     * 
     * @param descripcion La descripción del evento.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha de inicio del evento.
     * 
     * @return La fecha de inicio del evento.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del evento.
     * 
     * @param fechaInicio La fecha de inicio del evento.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de finalización del evento.
     * 
     * @return La fecha de finalización del evento.
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Establece la fecha de finalización del evento.
     * 
     * @param fechaFinal La fecha de finalización del evento.
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Obtiene la hora de inicio del evento.
     * 
     * @return La hora de inicio del evento en formato de 24 horas (HH:mm).
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio del evento.
     * 
     * @param horaInicio La hora de inicio del evento en formato de 24 horas (HH:mm).
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora de finalización del evento.
     * 
     * @return La hora de finalización del evento en formato de 24 horas (HH:mm).
     */
    public String getHoraFinal() {
        return horaFinal;
    }

    /**
     * Establece la hora de finalización del evento.
     * 
     * @param horaFinal La hora de finalización del evento en formato de 24 horas (HH:mm).
     */
    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * Obtiene el campus donde se realiza el evento.
     * 
     * @return El campus del evento.
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Establece el campus donde se realiza el evento.
     * 
     * @param campus El campus del evento.
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }

    /**
     * Obtiene la categoría del evento.
     * 
     * @return La categoría del evento.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del evento.
     * 
     * @param categoria La categoría del evento.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Devuelve una representación en formato String del evento con todos sus atributos.
     * 
     * @return Una cadena de texto que representa el evento.
     */
    @Override
    public String toString() {
        return "Evento{" + "titulo=" + titulo + ", descripcion=" + descripcion + ", fechaInicio=" + 
               fechaInicio + ", fechaFinal=" + fechaFinal + ", horaInicio=" + horaInicio + 
               ", horaFinal=" + horaFinal + ", campus=" + campus + ", categoria=" + categoria + '}';
    }



    
}
