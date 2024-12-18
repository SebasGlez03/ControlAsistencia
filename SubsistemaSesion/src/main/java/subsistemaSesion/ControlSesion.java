/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaSesion;

import dto.SesionDTO;
import entidades.Alumno;
import entidades.Sesion;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/**
 *
 * @author PC
 */
public class ControlSesion {
    
    IPersistencia datos = new FachadaPersistencia();

    /**
     * Metodo que obtiene la sesion de la base de datos (solo ObjectIds)
     *
     * @param sesion SesionDTO a obtener de la base de datos
     * @return Objeto SesionDTO obtenido
     */
    public SesionDTO obtenerSesion(SesionDTO sesion) {
        Sesion sesionObtenida = new Sesion();
        SesionDTO sesionRegresar = new SesionDTO();
        
        sesionRegresar.setId(sesionObtenida.getId());
        sesionRegresar.setIdClase(sesionObtenida.getIdClase());
        sesionRegresar.setMatriculaMaestro(sesionObtenida.getMatriculaMaestro());
        sesionRegresar.setFecha(sesionObtenida.getFecha());
        sesionRegresar.setAlumnos(sesionObtenida.getAlumnos());
        
        return sesionRegresar;
    }

    /**
     * Metodo que obtiene la sesion de la base de datos mediante un ObjectId
     *
     * @param idSesion ObjectId de la sesion a buscar en la base de datos
     * @return Objeto Sesion obtenido
     */
    public Sesion obtenerSesion(ObjectId idSesion) {
        return datos.obtenerSesion(idSesion);
    }

    /**
     * Metodo que agrega una sesion a la base de datos
     *
     * @param sesion SesionDTO a agregar a la base de datos
     */
    public void agregarSesion(SesionDTO sesion) {
        datos.agregarSesion(convertirDTOaEntidad(sesion));
    }

    /**
     * Metodo que obtiene la lista de asistencia de los alumnos de la sesion en
     * forma de documento de la base de datos
     *
     * @param sesion SesionDTO con la sesion a obtener
     * @return Lista de documentos con la informacion de los alumnos de la
     * sesion
     */
    public List<Document> obtenerSesionAlumnos(SesionDTO sesion) {
        return datos.obtenerAlumnosSesion(convertirDTOaEntidad(sesion));
    }

    /**
     * Metodo que obtiene la lista de asistencia de los alumnos en la sesion en
     * forma de lista de alumnos
     *
     * @param sesion Objeto SesionDTO con la sesion
     * @return Lista de alumnos de la sesion
     */
    public List<Alumno> obtenerSesionAlumnosNoDocumento(SesionDTO sesion) {
        return datos.obtenerSesionAlumnosNoDocumento(convertirDTOaEntidad(sesion));
    }

    /**
     * Metodo que convierte un objeto SesionDTO a Entidad
     *
     * @param dto Objeto SesionDTO a convertir
     * @return Objeto SesionEntidad obtenido
     */
    public Sesion convertirDTOaEntidad(SesionDTO dto) {
        Sesion sesion = new Sesion();
        
        sesion.setId(dto.getId());
        sesion.setIdClase(dto.getIdClase());
        sesion.setMatriculaMaestro(dto.getMatriculaMaestro());
        sesion.setFecha(dto.getFecha());
        sesion.setAlumnos(dto.getAlumno());
        
        return sesion;
    }
    
}
