/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Alumno;
import entidades.Sesion;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class SesionDTO {

    private ObjectId id;
    private Date fecha;
    private ObjectId idClase;
    private int matricula;
    private List<Alumno> alumnos;

    /**
     * Constructor por omision
     */
    public SesionDTO() {
    }

    /**
     * Constructor que inicializa los atributos de la clase a excepcion del ID
     *
     * @param fecha Fecha de la sesion
     * @param idClase ID de la clase de la sesion
     * @param matricula Matricula de el maestro que imparte la sesion
     * @param alumnos Lista de alumnos y su estado de asistencia de la sesion
     */
    public SesionDTO(Date fecha, ObjectId idClase, int matricula, List<Alumno> alumnos) {
        this.fecha = fecha;
        this.idClase = idClase;
        this.matricula = matricula;
        this.alumnos = alumnos;
    }

    /**
     * Constructor que inicializa los atributos de la clase mediante un objeto
     * Sesion
     *
     * @param sesion Objeto tipo Sesion con los datos de la sesion
     */
    public SesionDTO(Sesion sesion) {
        this.id = sesion.getId();
        this.fecha = sesion.getFecha();
        this.idClase = sesion.getIdClase();
        this.matricula = sesion.getMatriculaMaestro();
        this.alumnos = sesion.getAlumnos();
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
     * @return Matricula del maestro que imparte la sesion obtenido
     */
    public int getMatriculaMaestro() {
        return matricula;
    }

    /**
     * Metodo que establece el ID de el maestro que imparte la seion
     *
     * @param matricula Matricula del maestro que imparte la sesion a establecer
     */
    public void setMatriculaMaestro(int matricula) {
        this.matricula = matricula;
    }

    /**
     * Metodo que obtiene la lista de los alumnos con su estado de asistencia en
     * la sesion
     *
     * @return Lista de alumnos con su estado de asistencia en la sesion
     * obtenida
     */
    public List<Alumno> getAlumno() {
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

}
