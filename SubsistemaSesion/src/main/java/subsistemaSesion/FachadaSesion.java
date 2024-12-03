/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaSesion;

import dto.SesionDTO;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class FachadaSesion implements ISesion {

    ControlSesion controlSesion = new ControlSesion();

    /**
     * Metodo que obtiene la sesion de la base de datos
     *
     * @param sesion Objeto SesionDTO con la informaciond de la sesion a obtener
     * @return Objeto SesionDTO obtenido
     */
    @Override
    public SesionDTO obtenerSesion(SesionDTO sesion) {
        return controlSesion.obtenerSesion(sesion);
    }

    /**
     * Metodo que agrega una sesion a la base de datos
     *
     * @param sesion Objeto SesionDTO que se va a agregar a la base de dats
     */
    @Override
    public void agregarSesion(SesionDTO sesion) {
        controlSesion.agregarSesion(sesion);
    }

    /**
     * Metodo que obtiene la lista de asistencia de los alumnos de la sesion en
     * forma de documento
     *
     * @param sesion Objeto SesionDTO con la sesion
     * @return Lista de documentos con la informacion de los alumnos de la
     * sesion
     */
    @Override
    public List<Document> obtenerSesionAlumnos(SesionDTO sesion) {
        return controlSesion.obtenerSesionAlumnos(sesion);
    }

}
