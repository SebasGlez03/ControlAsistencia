/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

/**
 *
 * @author Ragzard
 */
public class QRDTO {

    private String contenido;
    private Date fechaCreacion;
    private String tipoContenido;
    private long id;

    /**
     * Método constructor vacío.
     */
    public QRDTO() {
    }

    /**
     * Método constructor que inicializa todos los átributos.
     *
     * @param contenido
     * @param fechaCreacion
     * @param tipoContenido
     * @param id
     */
    public QRDTO(String contenido, Date fechaCreacion, String tipoContenido, long id) {
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.tipoContenido = tipoContenido;
        this.id = id;
    }

    /**
     * Obtiene el Contenido.
     *
     * @return contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Asigna el Contenido.
     *
     * @param contenido
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene la fecha de creación.
     *
     * @return fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Asigna la fecha de creación.
     *
     * @param fechaCreacion
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene el tipo contenido.
     *
     * @return tipoContenido
     */
    public String getTipoContenido() {
        return tipoContenido;
    }

    /**
     * Asigna el tipo de contenido
     *
     * @param tipoContenido
     */
    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    /**
     * Obtiene el ID.
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Asigna el ID.
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Metodo toString por default.
     *
     * @return
     */
    @Override
    public String toString() {
        return "QRDTO{" + "contenido=" + contenido + ", fechaCreacion=" + fechaCreacion + ", tipoContenido=" + tipoContenido + ", id=" + id + '}';
    }

}
