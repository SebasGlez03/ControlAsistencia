/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SubsistemaAlumno;

import dto.AlumnoDTO;
import dto.UsuarioDTO;

/**
 *
 * @author joel_
 */
public interface IAlumno {

    /**
     * escanea un codigoQR en el sistema
     */
    public void EscanearQR();

    /**
     * Metodo que obtiene un alumno del sistema.
     *
     * @param alumno Alumno obtenido.
     */
    public void obtenerAlumno(AlumnoDTO alumno);

    /**
     * Agrega un nuevo alumno al sistema.
     *
     * @param alumno Alumno a agregar en el sistema.
     */
    public void agregarAlumno(AlumnoDTO alumno);

    /**
     * Elimina un alumno del sistema.
     *
     * @param alumno Alumno a eliminar en el sistema.
     */
    public void eliminarAlumno(AlumnoDTO alumno);

    /**
     * Modifica un alumno del sistema.
     *
     * @param alumno Alumno a modificar en el sistema.
     * @param alumnoModificado Alumno con la nueva informacion a agregar.
     */
    public void modificarAlumno(AlumnoDTO alumno, AlumnoDTO alumnoModificado);
}
