/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaSesion;

import dto.SesionDTO;
import entidades.Alumno;
import entidades.Sesion;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public interface ISesion {

    /**
     * Metodo que obtiene la sesion de la base de datos
     *
     * @param sesion Objeto SesionDTO con la informaciond de la sesion a obtener
     * @return Objeto SesionDTO obtenido
     */
    public SesionDTO obtenerSesion(SesionDTO sesion);

    /**
     * Metodo que obtiene la sesion de la base de datos mediante un ObjectId
     *
     * @param idSesion ObjectId de la sesion a buscar en la base de datos
     * @return Objeto Sesion obtenido
     */
    public Sesion obtenerSesion(ObjectId idSesion);

    /**
     * Metodo que agrega una sesion a la base de datos
     *
     * @param sesion Objeto SesionDTO que se va a agregar a la base de dats
     */
    public void agregarSesion(SesionDTO sesion);

    /**
     * Metodo que obtiene la lista de asistencia de los alumnos de la sesion en
     * forma de documento
     *
     * @param sesion Objeto SesionDTO con la sesion
     * @return Lista de documentos con la informacion de los alumnos de la
     * sesion
     */
    public List<Document> obtenerSesionAlumnos(SesionDTO sesion);

    /**
     * Metodo que obtiene la lista de asistencia de los alumnos en la sesion en
     * forma de lista de alumnos
     *
     * @param sesion Objeto SesionDTO con la sesion
     * @return Lista de alumnos de la sesion
     */
    public List<Alumno> obtenerSesionAlumnosNoDocumento(SesionDTO sesion);
}
