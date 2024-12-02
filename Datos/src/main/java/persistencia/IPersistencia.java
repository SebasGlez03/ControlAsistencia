/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.*;
import java.util.List;
import org.bson.Document;

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
     * @param matricula la matricula del usuario a obtener.
     * @return Objeto de tipo Usuario con la informacion del usuario a obtener
     */
    public Usuario obtenerUsuario(int matricula);

    /**
     * Obtiene el nombre del rol de un usuario del sistema.
     *
     * @param matricula La matricula del usuario a obtener su rol.
     * @return String con el nombre del rol del usuario
     */
    public String obtenerRolUsuario(int matricula);

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

    /**
     * Modifica los datos de un maestro en el sistema.
     *
     * @param maestro El objeto Maestro que se desea modificar.
     * @param maestroModificado El objeto Maestro con la informacion a
     * modificar.
     */
    public void modificarMaestro(Maestro maestro, Maestro maestroModificado);

    /**
     * Obtiene una clase del sistema.
     *
     * @param clase El objeto Clase que se desea obtener.
     * @return Objeto del tipo Clase con la informacion de la clase a obtener.
     */
    public Clase obtenerClase(Clase clase);

    /**
     * Agrega una nueva clase al sistema.
     *
     * @param clase El objeto Clase que se desea agregar.
     */
    public void agregarClase(Clase clase);

    /**
     * Elimina una clase del sistema
     *
     * @param clase El objeto Clase que se desea eliminar.
     */
    public void eliminarClase(Clase clase);

    /**
     * Modifica los datos de una clase en el sistema.
     *
     * @param clase El objeto Clase que se desea modificar.
     * @param claseModificada El objeto Clase con la informacion a modificar.
     */
    public void modificarClase(Clase clase, Clase claseModificada);

    /**
     * Obtiene una sesion del sistema.
     *
     * @param sesion El objeto Sesion que se desea obtener.
     * @return Objeto del tipo Sesion con la informacion a obtener.
     */
    public Sesion obtenerSesion(Sesion sesion);

    /**
     * Agrega una nueva sesion al sistema.
     *
     * @param sesion El objeto Sesion que desea agregar.
     */
    public void agregarSesion(Sesion sesion);

    /**
     * Obtiene la lista de los alumnos y su asistencia de una sesion.
     *
     * @param sesion Sesion de la que se desea obtener esta informacion.
     * @return Sesion con la informacion de los alumnos y su asistencia.
     */
    public List<Document> obtenerAlumnosSesion(Sesion sesion);

}
