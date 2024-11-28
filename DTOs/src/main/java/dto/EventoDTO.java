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
    private Date fecha;          // Fecha en la que se realiza el evento
    private String horaInicio;
    private String horaFinal;
    /**
     * Constructor por defecto.
     */
    public EventoDTO() {
    }

    /**
     * Constructor para inicializar el evento con título y descripción.
     * 
     * @param titulo el título del evento
     * @param descripcion la descripción del evento
     */
    public EventoDTO(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    /**
     * Constructor para inicializar el evento con todos los atributos.
     * 
     * @param titulo el título del evento
     * @param descripcion la descripción del evento
     * @param fecha la fecha en la que se realizará el evento
     * @param horaInicio la hora de inicio del evento
     * @param horaFinal la hora de finalización del evento
     */
    public EventoDTO(String titulo, String descripcion, Date fecha, String horaInicio, String horaFinal) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    /**
     * Obtiene el título del evento.
     * 
     * @return el título del evento
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del evento.
     * 
     * @param titulo el nuevo título del evento
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la descripción del evento.
     * 
     * @return la descripción del evento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del evento.
     * 
     * @param descripcion la nueva descripción del evento
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha del evento.
     * 
     * @return la fecha del evento
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del evento.
     * 
     * @param fecha la nueva fecha del evento
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
    * Obtiene la hora de inicio del evento.
    * 
    * @return una cadena que representa la hora de inicio del evento
    */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio del evento.
     * 
     * @param horaInicio la hora de inicio del evento en formato de cadena
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la hora final del evento.
     * 
     * @return una cadena que representa la hora final del evento
     */
    public String getHoraFinal() {
        return horaFinal;
    }

    /**
     * Establece la hora final del evento.
     * 
     * @param horaFinal la hora final del evento en formato de cadena
     */
    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }



    
}
