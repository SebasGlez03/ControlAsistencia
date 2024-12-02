/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaUsuario;

import dto.*;
import entidades.Usuario;
import java.util.List;

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
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario Usuario a agregar al sistema
     */
    public void agregarUsuario(UsuarioDTO usuario);

    /**
     * Elimina un alumno del sistema.
     *
     * @param usuario Usuario a eliminar del sistema.
     */
    public void eliminarUsuario(UsuarioDTO usuario);

    /**
     * Modifica un usuario del sistema.
     *
     * @param usuario Usuario a modificar en el sistema.
     * @param usuarioModificado Usuario con la nueva informacion a agregar.
     */
    public void modificarUsuario(UsuarioDTO usuario, UsuarioDTO usuarioModificado);

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

    /**
     * Metodo que obtiene la lista de usuarios
     *
     * @return Lista de usuarios obtenida
     */
    public List<Usuario> obtenerListaUsuarios();
}
