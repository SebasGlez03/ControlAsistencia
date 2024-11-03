/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 * Clase que representa un código QR. Contiene información sobre el contenido
 * del código y la fecha en que fue creado.
 *
 * @author PC
 */
public class QR {

    private String contenido; // Contenido del código QR
    private Date fechaCreacion; // Fecha de creación del código QR

    // Constructor por defecto
    public QR() {
    }

    /**
     * Constructor que inicializa un objeto QR con contenido y fecha de
     * creación.
     *
     * @param contenido Contenido del código QR.
     * @param fechaCreacion Fecha de creación del código QR.
     */
    public QR(String contenido, Date fechaCreacion) {
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene el contenido del código QR.
     *
     * @return Contenido del código QR.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del código QR.
     *
     * @param contenido Contenido a asignar al código QR.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene la fecha de creación del código QR.
     *
     * @return Fecha de creación del código QR.
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación del código QR.
     *
     * @param fechaCreacion Fecha a asignar al código QR.
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Método que retorna una representación en forma de cadena del objeto QR,
     * incluyendo el contenido y la fecha de creación.
     *
     * @return Cadena con la información del código QR.
     */
    @Override
    public String toString() {
        return "QR{" + "contenido=" + contenido + ", fechaCreacion=" + fechaCreacion + '}';
    }

}
