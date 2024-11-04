/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import dto.AlumnoDTO;
import dto.MaestroDTO;
import dto.UsuarioDTO;

/**
 * Interfaz IPersistencia que define los métodos para realizar operaciones de 
 * persistencia sobre los objetos UsuarioDTO, AlumnoDTO y MaestroDTO.
 * 
 * @author sebastian
 */
public interface IPersistencia {
    
    /**
     * Obtiene un usuario del sistema.
     *
     * @param usuario el objeto UsuarioDTO que se desea obtener.
     */
    public void obtenerUsuario(UsuarioDTO usuario);
    
    /**
     * Obtiene un alumno del sistema.
     *
     * @param alumno el objeto AlumnoDTO que se desea obtener.
     */
    public void obtenerAlumno(AlumnoDTO alumno);
    
    /**
     * Obtiene un maestro del sistema.
     *
     * @param maestro el objeto MaestroDTO que se desea obtener.
     */
    public void obtenerMaestro(MaestroDTO maestro);
    
    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario el objeto UsuarioDTO que se desea agregar.
     */
    public void agregarUsuario(UsuarioDTO usuario);
    
    /**
     * Agrega un nuevo alumno al sistema.
     *
     * @param alumno el objeto AlumnoDTO que se desea agregar.
     */
    public void agregarAlumno(AlumnoDTO alumno);
    
    /**
     * Agrega un nuevo maestro al sistema.
     *
     * @param maestro el objeto MaestroDTO que se desea agregar.
     */
    public void agregarMaestro(MaestroDTO maestro);
    
    /**
     * Elimina un usuario del sistema.
     *
     * @param usuario el objeto UsuarioDTO que se desea eliminar.
     */
    public void eliminarUsuario(UsuarioDTO usuario);
    
    /**
     * Elimina un alumno del sistema.
     *
     * @param alumno el objeto AlumnoDTO que se desea eliminar.
     */
    public void eliminarAlumno(AlumnoDTO alumno);
    
    /**
     * Elimina un maestro del sistema.
     *
     * @param maestro el objeto MaestroDTO que se desea eliminar.
     */
    public void eliminarMaestro(MaestroDTO maestro);
    
    /**
     * Modifica los datos de un usuario en el sistema.
     *
     * @param usuario el objeto UsuarioDTO que se desea modificar.
     */
    public void modificarUsuario(UsuarioDTO usuario);
    
    /**
     * Modifica los datos de un alumno en el sistema.
     *
     * @param alumno el objeto AlumnoDTO que se desea modificar.
     */
    public void modificarAlumno(AlumnoDTO alumno);
    
    /**
     * Modifica los datos de un maestro en el sistema.
     *
     * @param maestro el objeto MaestroDTO que se desea modificar.
     */
    public void modificarMaestro(MaestroDTO maestro);
}
