/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Alumno;
import entidades.Maestro;
import entidades.Usuario;

/**
 * Interfaz IPersistencia que define los métodos para realizar operaciones de
 * persistencia sobre los objetos Usuario, Alumno y Maestro.
 *
 * @author sebastian
 */
public interface IPersistencia {

    /**
     * Obtiene un usuario del sistema.
     *
     * @param usuario el objeto Usuario que se desea obtener.
     */
    public void obtenerUsuario(Usuario usuario);

    /**
     * Obtiene un alumno del sistema.
     *
     * @param alumno el objeto Alumno que se desea obtener.
     */
    public void obtenerAlumno(Alumno alumno);

    /**
     * Obtiene un maestro del sistema.
     *
     * @param maestro el objeto Maestro que se desea obtener.
     */
    public void obtenerMaestro(Maestro maestro);

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario el objeto Usuario que se desea agregar.
     */
    public void agregarUsuario(Usuario usuario);

    /**
     * Agrega un nuevo alumno al sistema.
     *
     * @param alumno el objeto Alumno que se desea agregar.
     */
    public void agregarAlumno(Alumno alumno);

    /**
     * Agrega un nuevo maestro al sistema.
     *
     * @param maestro el objeto Maestro que se desea agregar.
     */
    public void agregarMaestro(Maestro maestro);

    /**
     * Elimina un usuario del sistema.
     *
     * @param usuario el objeto Usuario que se desea eliminar.
     */
    public void eliminarUsuario(Usuario usuario);

    /**
     * Elimina un alumno del sistema.
     *
     * @param alumno el objeto Alumno que se desea eliminar.
     */
    public void eliminarAlumno(Alumno alumno);

    /**
     * Elimina un maestro del sistema.
     *
     * @param maestro el objeto Maestro que se desea eliminar.
     */
    public void eliminarMaestro(Maestro maestro);

    /**
     * Modifica los datos de un usuario en el sistema.
     *
     * @param usuario el objeto Usuario que se desea modificar.
     */
    public void modificarUsuario(Usuario usuario);

    /**
     * Modifica los datos de un alumno en el sistema.
     *
     * @param alumno el objeto Alumno que se desea modificar.
     */
    public void modificarAlumno(Alumno alumno);

    /**
     * Modifica los datos de un maestro en el sistema.
     *
     * @param maestro el objeto Maestro que se desea modificar.
     */
    public void modificarMaestro(Maestro maestro);
}
