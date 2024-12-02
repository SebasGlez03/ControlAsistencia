/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaUsuario;

import dto.AlumnoDTO;
import dto.MaestroDTO;
import dto.UsuarioDTO;
import entidades.Alumno;
import entidades.Maestro;
import entidades.Usuario;
import mock.BaseDatosMock;

/**
 *
 * @author PC
 */
public class FachadaUsuario implements IUsuario {

    ControlUsuario controlUsuario = new ControlUsuario();

    public FachadaUsuario() {
        // Esto es para la version Mock
    }

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

    @Override
    public void agregarUsuario(UsuarioDTO usuario) {
        controlUsuario.agregarUsuario(convertirUsuarioDTOaEntidad(usuario));
    }

    @Override
    public void eliminarUsuario(UsuarioDTO usuario) {
        controlUsuario.eliminarUsuario(convertirUsuarioDTOaEntidad(usuario));
    }

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

}
