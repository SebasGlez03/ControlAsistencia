/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlUsuario;

import dtos.UsuarioDTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class ControlUsuario {

    private UsuarioDTO usuario;

    /**
     * Método que valida que el nombre no sea vacío ni nulo
     *
     * @param usuario el objeto UsuarioDTO a validar
     * @return true si el nombre es válido, false si no
     */
    public static boolean validarNombre(UsuarioDTO usuario) {
        String nombre = usuario.getNombre();
        return nombre != null && !nombre.trim().isEmpty();
    }

    /**
     * Método que valida el formato del correo usando una expresión regular
     *
     * @param usuario el objeto UsuarioDTO a validar
     * @return true si el correo es válido, false si no
     */
    public static boolean validarCorreo(UsuarioDTO usuario) {
        String correo = usuario.getCorreo();
        if (correo == null || correo.trim().isEmpty()) {
            return false;
        }
        // Expresión regular para validar correo electrónico
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    /**
     * Método que valida que la contraseña tenga al menos 8 caracteres
     *
     * @param usuario el objeto UsuarioDTO a validar
     * @return true si la contraseña es válida, false si no
     */
    public static boolean validarContrasenia(UsuarioDTO usuario) {
        String contrasenia = usuario.getContrasenia();
        return contrasenia != null && contrasenia.length() >= 8;
    }

    /**
     * Método que valida si todos los campos del UsuarioDTO son válidos
     *
     * @param usuario el objeto UsuarioDTO a validar
     * @return true si todos los campos son válidos, false si alguno falla
     */
    public static boolean validarUsuario(UsuarioDTO usuario) {
        return validarNombre(usuario) && validarCorreo(usuario) && validarContrasenia(usuario);
    }

}
