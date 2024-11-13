/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Usuario;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para el usuario.
 * Esta clase se utiliza para transportar datos del usuario entre diferentes capas de la aplicación.
 * 
 * @author PC
 */
public class UsuarioDTO {

    private int matricula; // Identificador único del usuario
    private String nombre; // Nombre del usuario
    private String apellidoPaterno; // Apellido paterno del usuario
    private String apellidoMaterno; // Apellido materno del usuario
    private String correo; // Correo electrónico del usuario
    private String contrasenia; // Contraseña del usuario

    /** 
     * Constructor vacío para la clase UsuarioDTO.
     */
    public UsuarioDTO() {
    }

    /** 
     * Constructor que inicializa todos los atributos del usuario.
     * 
     * @param matricula Identificador único del usuario
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario
     * @param correo Correo electrónico del usuario
     * @param contrasenia Contraseña del usuario
     */
    public UsuarioDTO(int matricula, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /** 
     * Constructor que inicializa el DTO a partir de un objeto Usuario.
     * 
     * @param usuario Objeto Usuario del cual se obtienen los datos
     */
    public UsuarioDTO(Usuario usuario) {
        this.matricula = usuario.getMatricula();
        this.nombre = usuario.getNombre();
        this.apellidoPaterno = usuario.getApellidoPaterno();
        this.apellidoMaterno = usuario.getApellidoMaterno();
        this.correo = usuario.getCorreo();
        this.contrasenia = usuario.getContrasenia();
    }

    /** 
     * Constructor que inicializa todos los atributos excepto el id.
     * 
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario
     * @param correo Correo electrónico del usuario
     * @param contrasenia Contraseña del usuario
     */
    public UsuarioDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /** 
     * Obtiene el identificador del usuario.
     * 
     * @return El identificador único del usuario
     */
    public int getMatricula() {
        return matricula;
    }

    /** 
     * Establece el identificador del usuario.
     * 
     * @param matricula Identificador único del usuario
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /** 
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /** 
     * Establece el nombre del usuario.
     * 
     * @param nombre Nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * Obtiene el apellido paterno del usuario.
     * 
     * @return El apellido paterno del usuario
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /** 
     * Establece el apellido paterno del usuario.
     * 
     * @param apellidoPaterno Apellido paterno del usuario
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /** 
     * Obtiene el apellido materno del usuario.
     * 
     * @return El apellido materno del usuario
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /** 
     * Establece el apellido materno del usuario.
     * 
     * @param apellidoMaterno Apellido materno del usuario
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /** 
     * Obtiene el correo electrónico del usuario.
     * 
     * @return El correo electrónico del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /** 
     * Establece el correo electrónico del usuario.
     * 
     * @param correo Correo electrónico del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /** 
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /** 
     * Establece la contraseña del usuario.
     * 
     * @param contrasenia Contraseña del usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
