/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class Sesion {

    private ObjectId id;
    private Date fecha;
    private ObjectId idClase;
    private ObjectId idMaestro;
    private List<Alumno> alumnos;

    /**
     * Constructor por omision
     */
    public Sesion() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase
     *
     * @param fecha Fecha de la sesion
     * @param idClase ID de la clase de la sesion
     * @param idMaestro ID del maestro que imparte la sesion
     * @param alumnos Lista de alumnos que contiene el ID del alumno y su estado
     * de asistencia
     */
    public Sesion(Date fecha, ObjectId idClase, ObjectId idMaestro, List<Alumno> alumnos) {
        this.fecha = fecha;
        this.idClase = idClase;
        this.idMaestro = idMaestro;
        this.alumnos = alumnos;
    }

    /**
     * Metodo que obtiene el ID de la sesion
     *
     * @return ID de la sesion obtenida
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Metodo que establece el ID de la sesion
     *
     * @param id ID de la sesion a establecer
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene la fecha de la sesion
     *
     * @return Fecha de la sesion obtenida
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Metodo que establece la fecha de la sesion
     *
     * @param fecha Fecha de la sesion a establecer
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo que obtiene el ID de la clase de la sesion
     *
     * @return ID de la clase de la sesion a obtener
     */
    public ObjectId getIdClase() {
        return idClase;
    }

    /**
     * Metodo que establece el ID de la clase de la sesion
     *
     * @param idClase ID de la clase de la sesion a establecer
     */
    public void setIdClase(ObjectId idClase) {
        this.idClase = idClase;
    }

    /**
     * Metodo que obtiene el ID de el maestro que imparte la sesion
     *
     * @return ID del maestro que imparte la sesion obtenido
     */
    public ObjectId getIdMaestro() {
        return idMaestro;
    }

    /**
     * Metodo que establece el ID de el maestro que imparte la seion
     *
     * @param idMaestro ID del maestro que imparte la sesion a establecer
     */
    public void setIdMaestro(ObjectId idMaestro) {
        this.idMaestro = idMaestro;
    }

    /**
     * Metodo que obtiene la lista de los alumnos con su estado de asistencia en
     * la sesion
     *
     * @return Lista de alumnos con su estado de asistencia en la sesion
     * obtenida
     */
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Metodo que establece la lista de los alumnos con su estado de asistencia
     * en la sesion
     *
     * @param alumnos Lista de alumnos con su estado de asistencia en la sesion
     * obtenida
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Metodo que agrega todos los atributos de la clase a un solo dato String
     *
     * @return Objeto tipo String con todos los valores de los atributos de la
     * clase
     */
    @Override
    public String toString() {
        return "Sesion{" + "id=" + id + ", fecha=" + fecha + ", idClase=" + idClase + ", idMaestro=" + idMaestro + ", alumnos=" + alumnos + '}';
    }

}
