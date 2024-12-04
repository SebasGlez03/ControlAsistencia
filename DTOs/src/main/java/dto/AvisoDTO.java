/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Aviso;
import java.util.Date;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author Ragzard
 */
public class AvisoDTO {

    private ObjectId id;
    private String titulo; // Titulo del aviso. [Maestro]
    private Date fechaHora; // Fecha y hora en la que se creó el aviso. [Maestro]
    private String mensaje; // Mensaje del aviso. [Maestro]
    private ObjectId idMaestro;
    private Map<ObjectId, String> listaRespuestas; // Respuestas del aviso. [Alumno]

    /**
     * Constructor vacio / por defecto.
     */
    public AvisoDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos desde un objeto [Aviso].
     *
     * @param aviso
     */
    public AvisoDTO(Aviso aviso) {
        this.id = aviso.getId();
        this.titulo = aviso.getTitulo();
        this.fechaHora = aviso.getFechaHora();
        this.mensaje = aviso.getMensaje();
        this.idMaestro = aviso.getIdMaestro();
        this.listaRespuestas = aviso.getListaRespuestas();
    }

    /**
     * Constructor que inicializa todos los atributos.
     *
     * @param id
     * @param titulo
     * @param fechaHora
     * @param mensaje
     * @param idMaestro
     * @param listaRespuestas
     */
    public AvisoDTO(ObjectId id, String titulo, Date fechaHora, String mensaje, ObjectId idMaestro, Map<ObjectId, String> listaRespuestas) {
        this.id = id;
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.idMaestro = idMaestro;
        this.listaRespuestas = listaRespuestas;
    }

    /**
     * Constructor que inicializa un aviso sin respuestas.
     *
     * @param id
     * @param titulo
     * @param fechaHora
     * @param mensaje
     * @param idMaestro
     */
    public AvisoDTO(ObjectId id, String titulo, Date fechaHora, String mensaje, ObjectId idMaestro) {
        this.id = id;
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.idMaestro = idMaestro;
    }

    /**
     * Constructor que inicializa un aviso sin respuestas ni mensaje.
     *
     * @param id
     * @param titulo
     * @param fechaHora
     * @param idMaestro
     */
    public AvisoDTO(ObjectId id, String titulo, Date fechaHora, ObjectId idMaestro) {
        this.id = id;
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.idMaestro = idMaestro;
    }

    /**
     * Constructor que solo inicializa Titulo, Fecha y mensaje
     *
     * @param titulo
     * @param fechaHora
     * @param mensaje
     */
    public AvisoDTO(String titulo, Date fechaHora, String mensaje) {
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
    }

    /**
     * Constructor que solo inicializa todos los atributos sin el ID.
     *
     * @param titulo
     * @param fechaHora
     * @param mensaje
     * @param idMaestro
     * @param listaRespuestas
     */
    public AvisoDTO(String titulo, Date fechaHora, String mensaje, ObjectId idMaestro, Map<ObjectId, String> listaRespuestas) {
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.idMaestro = idMaestro;
        this.listaRespuestas = listaRespuestas;
    }

    /**
     * Método para obtener el ID del aviso.
     *
     * @return
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para asignar un ID al aviso.
     *
     * @param id
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener el titulo del aviso.
     *
     * @return String titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para asignar un titulo al aviso.
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método para obtener la fecha del aviso.
     *
     * @return Date fecha
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Método para asignar una fecha al aviso
     *
     * @param fechaHora
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Método para obtener el mensaje del aviso.
     *
     * @return String mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método para asignar un mensaje al aviso.
     *
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Método para obtener el ID del maestro que publico el aviso.
     *
     * @return
     */
    public ObjectId getIdMaestro() {
        return idMaestro;
    }

    /**
     * Método para asignar el ID del maestro que publica el aviso.
     *
     * @param idMaestro
     */
    public void setIdMaestro(ObjectId idMaestro) {
        this.idMaestro = idMaestro;
    }

    /**
     * Método para obtener las respuestas del aviso.
     *
     * @return
     */
    public Map<ObjectId, String> getListaRespuestas() {
        return listaRespuestas;
    }

    /**
     * Método para asignar una respuesta al aviso.
     *
     * @param listaRespuestas
     */
    public void setListaRespuestas(Map<ObjectId, String> listaRespuestas) {
        this.listaRespuestas = listaRespuestas;
    }

    /**
     * Método toString por defecto.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Aviso{" + "id=" + id
                + ", titulo=" + titulo
                + ", fechaHora=" + fechaHora
                + ", mensaje=" + mensaje
                + ", idMaestro=" + idMaestro
                + ", listaRespuestas=" + listaRespuestas + '}';
    }

}
