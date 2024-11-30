/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import org.bson.types.ObjectId;

/**
 * Clase que representa un alumno, que hereda de la clase Usuario. Esta clase
 * añade información específica del alumno, como el semestre en el que se
 * encuentra y su promedio académico.
 *
 * @author PC
 */
public class Alumno extends Usuario {

    private int semestre; // Semestre actual del alumno
    private float promedio; // Promedio académico del alumno

    /**
     * Constructor por omision.
     */
    public Alumno() {
    }

    /**
     * Constructor que inicializa los valores de los atributos de la clase.
     *
     * @param semestre Semestre historico que esta cursando el alumno.
     * @param promedio Promedio con el que cuenta el alumno.
     */
    public Alumno(int semestre, float promedio) {
        this.semestre = semestre;
        this.promedio = promedio;
    }

    /**
     * Constructor que inicializa los valores de los atributos de la clase
     * Alumno y de su clase padre Usuario
     *
     * @param semestre Semestre que cursa el alumno
     * @param promedio Promedio del alumno
     * @param matricula Id del usuario
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario
     * @param correo Correo del usuario
     * @param contrasenia Contrasenia del usuario
     * @param rol Rol del usuario
     */
    public Alumno(int semestre, float promedio, int matricula, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, ObjectId rol) {
        super(matricula, nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, rol);
        this.semestre = semestre;
        this.promedio = promedio;
    }

    /**
     * Constructur qeu inicializa los valores de los atributos de la clase
     * Alumno y de su clase padre Usuario (A excepcion de su Matricula)
     *
     * @param semestre Semestre que cursa el alumno
     * @param promedio Promedio del alumno
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario
     * @param correo Correo del usuario
     * @param contrasenia Contrasenia del usuario
     * @param rol Rol del usuario
     */
    public Alumno(int semestre, float promedio, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, ObjectId rol) {
        super(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, rol);
        this.semestre = semestre;
        this.promedio = promedio;
    }

    /**
     * Obtiene el semestre del alumno.
     *
     * @return Semestre actual del alumno.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre del alumno.
     *
     * @param semestre Semestre a asignar al alumno.
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene el promedio académico del alumno.
     *
     * @return Promedio del alumno.
     */
    public float getPromedio() {
        return promedio;
    }

    /**
     * Establece el promedio académico del alumno.
     *
     * @param promedio Promedio a asignar al alumno.
     */
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    /**
     * Método que retorna una representación en forma de cadena del objeto
     * Alumno, incluyendo información específica del semestre y el promedio.
     *
     * @return Cadena con la información del alumno.
     */
    @Override
    public String toString() {
        return super.toString() + "Alumno{" + "semestre=" + semestre + ", promedio=" + promedio + '}';
    }

}
