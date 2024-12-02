/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaUsuario;

import dto.AlumnoDTO;
import dto.MaestroDTO;
import entidades.Usuario;

/**
 * Esta interfaz define las operaciones relacionadas con la gestión de usuarios
 * en el sistema. Incluye métodos para iniciar sesión, agregar y eliminar tanto
 * alumnos como maestros, y agregar clases asociadas a cada tipo de usuario.
 *
 * @author PC
 */
public interface IUsuario {

    /**
     * Inicia sesión para un usuario dado.
     *
     * @param id El identificador del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return true si la sesión se inicia correctamente, false de lo contrario.
     */
    public boolean iniciarSesion(int id, String contrasenia);

    /**
     * Agrega un nuevo alumno al sistema.
     *
     * @param alumno Alumno a agregar en el sistema.
     */
    public void agregarAlumno(AlumnoDTO alumno);

    /**
     * Agrega un nuevo maestro al sistema.
     *
     * @param maestro Maestro a agregar en el sistema.
     */
    public void agregarMaestro(MaestroDTO maestro);

    /**
     * Elimina un alumno del sistema.
     *
     * @param alumno Alumno a eliminar en el sistema.
     */
    public void eliminarAlumno(AlumnoDTO alumno);

    /**
     * Elimina un maestro del sistema.
     *
     * @param maestro Maestro a eliminar en el sistema.
     */
    public void eliminarMaestro(MaestroDTO maestro);

    /**
     * Modifica un alumno del sistema.
     *
     * @param alumno Alumno a modificar en el sistema.
     * @param alumnoModificado Alumno con la nueva informacion a agregar.
     */
    public void modificarAlumno(AlumnoDTO alumno, AlumnoDTO alumnoModificado);

    /**
     * Modifica un maestro del sistema.
     *
     * @param maestro Maestro a modificar en el sistema.
     * @param maestroModificado Maestro con la nueva informacion a agregar.
     */
    public void modificarMaestro(MaestroDTO maestro, MaestroDTO maestroModificado);

    /**
     * Agrega una clase a un alumno.
     */
    public void agregarClaseAlumno();

    /**
     * Agrega una clase a un maestro.
     */
    public void agregarClaseMaestro();

    /**
     * Obtiene un usuario
     *
     * @param id Matricula del usuario
     * @return Objeto usuario obtenido
     */
    public Usuario getUsuario(int id);

    /**
     * Metodo que obtiene el rol del usuario
     *
     * @param id Matricula del usuario
     * @return Nombre de el rol del usuario
     */
    public String getRolUsuario(int id);
}
