/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaUsuario;

import dto.UsuarioDTO;

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
    public boolean iniciarSesion(UsuarioDTO id, UsuarioDTO contrasenia);

    /**
     * Agrega un nuevo alumno al sistema.
     *
     * @return El objeto Usuario que representa al alumno agregado.
     */
    public UsuarioDTO agregarAlumno();

    /**
     * Agrega un nuevo maestro al sistema.
     *
     * @return El objeto Usuario que representa al maestro agregado.
     */
    public UsuarioDTO agregarMaestro();

    /**
     * Elimina un alumno del sistema.
     *
     * @return El objeto Usuario que representa al alumno eliminado.
     */
    public UsuarioDTO eliminarAlumno();

    /**
     * Elimina un maestro del sistema.
     *
     * @return El objeto Usuario que representa al maestro eliminado.
     */
    public UsuarioDTO eliminarMaestro();

    /**
     * Agrega una clase a un alumno.
     */
    public void agregarClaseAlumno();

    /**
     * Agrega una clase a un maestro.
     */
    public void agregarClaseMaestro();
}
