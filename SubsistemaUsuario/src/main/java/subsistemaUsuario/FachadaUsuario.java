/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaUsuario;

import dto.UsuarioDTO;
import entidades.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class FachadaUsuario implements IUsuario {

    ControlUsuario controlUsuario = new ControlUsuario();

    public FachadaUsuario() {
        // Esto es para la version Mock
    }

    /**
     * Metodo que permite iniciar sesion
     *
     * @param id id del usuario
     * @param contrasenia contrasenia del usuario
     * @return true si se inicia sesion. false en caso contrario
     */
    @Override
    public boolean iniciarSesion(int id, String contrasenia) {
        return controlUsuario.iniciarSesion(id, contrasenia);
    }

    /**
     * Metodo que obtiene un objeto usuario
     *
     * @param id Matricula del usuario
     * @return Objeto usuario obtenido
     */
    @Override
    public Usuario getUsuario(int id) {
        return controlUsuario.getUsuario(id);
    }

    /**
     * Metodo que obtiene el rol del usuario
     *
     * @param id Matricula del usuario
     * @return Nombre del rol del usuario
     */
    @Override
    public String getRolUsuario(int id) {
        return controlUsuario.getRolUsuario(id);
    }

    /**
     * Metodo que obtiene el nombre del rol del usuario mediante su ObjectId
     *
     * @param rolId ObjectId del rol
     * @return Nombre del rol del usuario
     */
    @Override
    public String getRolUsuarioViaObjectId(ObjectId rolId) {
        return controlUsuario.getRolUsuarioViaObjectId(rolId);
    }

    /**
     * Metodo que agrega un usuario a la base de datos
     *
     * @param usuario usuario a agregar
     */
    @Override
    public void agregarUsuario(UsuarioDTO usuario) {
        controlUsuario.agregarUsuario(convertirUsuarioDTOaEntidad(usuario));
    }

    /**
     * Metodo que elimina un usuario de la base de datos
     *
     * @param usuario usuario a eliminar
     */
    @Override
    public void eliminarUsuario(UsuarioDTO usuario) {
        controlUsuario.eliminarUsuario(convertirUsuarioDTOaEntidad(usuario));
    }

    /**
     * Metodo que modifica un usuario de la base de datos
     *
     * @param usuario usuario a modificar
     * @param usuarioModificado usuario con la nueva informacin
     */
    @Override
    public void modificarUsuario(UsuarioDTO usuario, UsuarioDTO usuarioModificado) {
        controlUsuario.modificarUsuario(convertirUsuarioDTOaEntidad(usuario), convertirUsuarioDTOaEntidad(usuarioModificado));
    }

    /**
     * Metodo que convierte un UsuarioDTO a un UsuarioEntidad
     *
     * @param dto UsuarioDTO que se transfotrma a UsuarioEntidad
     * @return Usuario de tipo Entidad
     */
    public Usuario convertirUsuarioDTOaEntidad(UsuarioDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setMatricula(dto.getMatricula());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidoPaterno(dto.getApellidoPaterno());
        usuario.setApellidoMaterno(dto.getApellidoMaterno());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasenia(dto.getContrasenia());
        usuario.setRol(dto.getRol());

        return usuario;

    }

    /**
     * Metodo que obtiene toda la lista de usuarios
     *
     * @return Lista de usuarios obtenida
     */
    @Override
    public List<Usuario> obtenerListaUsuarios() {
        return controlUsuario.obtenerListaUsuarios();
    }

}
