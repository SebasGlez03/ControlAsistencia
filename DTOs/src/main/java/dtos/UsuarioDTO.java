/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author PC
 */
public class UsuarioDTO {

    protected String nombre;
    protected String correo;
    protected int id;
    protected String contrasenia;

    /**
     * Constructor por omision de la clase
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor que inicializa el valor de los parametros de la clase
     *
     * @param nombre nombre del usuario
     * @param correo correo del usuario
     * @param id id del usuario
     * @param contrasenia contrasenia del usuario
     */
    public UsuarioDTO(String nombre, String correo, int id, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.id = id;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor que inicializa el valor de los parametros de la clase a
     * excepcion del id
     *
     * @param nombre nombre del usuario
     * @param correo correo del usuario
     * @param contrasenia contrasenia del usuario
     */
    public UsuarioDTO(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     * Metodo que obtiene el nombre del usuario
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre del usuario
     *
     * @param nombre nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obteiene le correo del usuario
     *
     * @return correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que establece el correo del usuario
     *
     * @param correo correo del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que obtiene el id del usuario
     *
     * @return id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que establece el id del usuario
     *
     * @param id id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene la contrasenia
     *
     * @return contrasneia del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Metodo que establece la contrasenia
     *
     * @param contrasenia contrasenia del usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Metodo que devuelve todos los parametros de la clase en una string
     *
     * @return String con los valores de todos los parametros de la clase
     */
    @Override
    public String toString() {
        return "UsuarioDTO{" + "nombre=" + nombre + ", correo=" + correo + ", id=" + id + ", contrasenia=" + contrasenia + '}';
    }

}
