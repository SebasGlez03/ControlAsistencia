/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 * Clase que representa un usuario en el sistema. Contiene información básica
 * del usuario como su ID, nombre, apellidos, correo electrónico y contraseña.
 *
 * @author PC
 */
public class Usuario {

    // Atributos protegidos del usuario
    protected int matricula; // Identificador único del usuario
    protected String nombre; // Nombre del usuario
    protected String apellidoPaterno; // Apellido paterno del usuario
    protected String apellidoMaterno; // Apellido materno del usuario
    protected String correo; // Correo electrónico del usuario
    protected String contrasenia; // Contraseña del usuario

    // Constructor por defecto
    public Usuario() {
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos.
     *
     * @param matricula Identificador único del usuario
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario
     * @param correo Correo electrónico del usuario
     * @param contrasenia Contraseña del usuario
     */
    public Usuario(int matricula, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor con parámetros que omite el ID, usado para crear un nuevo
     * usuario.
     *
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario
     * @param correo Correo electrónico del usuario
     * @param contrasenia Contraseña del usuario
     */
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    // Métodos getters y setters para acceder y modificar los atributos
    /**
     * Obtiene el identificador único del usuario.
     *
     * @return matricula del usuario.
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param matricula Identificador único a asignar.
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre a asignar al usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return Apellido paterno del usuario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellidoPaterno Apellido paterno a asignar.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return Apellido materno del usuario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellidoMaterno Apellido materno a asignar.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return Correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo Correo electrónico a asignar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia Contraseña a asignar.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método que retorna una representación en forma de cadena del objeto
     * Usuario.
     *
     * @return Cadena con la información del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "matricula=" + matricula + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", contrasenia=" + contrasenia + '}';
    }

}
