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
 * persistencia sobre los objetos Usuario.
 *
 * @author sebastian
 */
public interface IPersistencia {

    /**
     * Obtiene un usuario del sistema.
     *
     * @param usuario el objeto Usuario que se desea obtener.
     * @return Objeto de tipo Usuario con la informacion del usuario a obtener
     */
    public Usuario obtenerUsuario(Usuario usuario);

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario el objeto Usuario que se desea agregar.
     */
    public void agregarUsuario(Usuario usuario);

    /**
     * Elimina un usuario del sistema.
     *
     * @param usuario el objeto Usuario que se desea eliminar.
     */
    public void eliminarUsuario(Usuario usuario);

    /**
     * Modifica los datos de un usuario en el sistema.
     *
     * @param usuario el objeto Usuario que se desea modificar.
     * @param usuarioModificado el objeto Usuario con la informacion a
     * modificar.
     */
    public void modificarUsuario(Usuario usuario, Usuario usuarioModificado);

    /**
     * Obtiene un alumno del sistema.
     *
     * @param alumno El objeto Alumno que se desea obtener.
     * @return Objeto de tipo Alumno con la informacion del Alumno a obtener
     */
    public Alumno obtenerAlumno(Alumno alumno);

    /**
     * Agrega un nuevo alumno al sistema.
     *
     * @param alumno El objeto Alumno que se desea agregar.
     */
    public void agregarAlumno(Alumno alumno);

    /**
     * Modifica los datos de un alumno en el sistema.
     *
     * @param alumno El objeto Alumno que se desea modificar.
     * @param alumnoModificado El objeto Alumno con la informacion a modificar.
     */
    public void modificarAlumno(Alumno alumno, Alumno alumnoModificado);

    /**
     * Obtiene un maestro del sistema.
     *
     * @param maestro El objeto Maestro que se desea obtener.
     * @return Objeto de tipo Maestro con la informacion del Maestro a obtener.
     */
    public Maestro obtenerMaestro(Maestro maestro);

    /**
     * Agrega un nuevo maestro al sistema.
     *
     * @param maestro El objeto Maestro que se desea agregar.
     */
    public void agregarMaestro(Maestro maestro);

}
