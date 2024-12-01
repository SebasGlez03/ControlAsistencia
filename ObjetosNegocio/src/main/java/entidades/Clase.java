/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class Clase {

    private ObjectId id;
    private String nombre;
    private int semestre;

    /**
     * Constructor por omision
     */
    public Clase() {
    }

    /**
     * Constructor que inicializa los atributos de la clase a excepcion del ID
     * que se genra por MongoDb
     *
     * @param nombre Nombre de la clase
     * @param semestre Semestre en el que se imprate la clase
     */
    public Clase(String nombre, int semestre) {
        this.nombre = nombre;
        this.semestre = semestre;
    }

    /**
     * Metodo para obtener el ID de la Clase
     *
     * @return Id de la clase
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Metdo para establecer el ID de la clase
     *
     * @param id Id de la clase a establecer
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el nombre de la clase
     *
     * @return Nombre de la clase
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre de la clase
     *
     * @param nombre Nombre de la clase a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el semestre en el que se imparte la clase
     *
     * @return Semestre en el que se imparte la clase
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Metodo que establece el semestre en el que se imparte la clase
     *
     * @param semestre Semestre en el que se imparte la clase a establecer
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Metodo que convierte todos los atributos de la clase a un solo valor
     * String
     *
     * @return String con todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "Clase{" + "id=" + id + ", nombre=" + nombre + ", semestre=" + semestre + '}';
    }

}
