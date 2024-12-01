/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Clase;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class ClaseDTO {

    private ObjectId id;
    private String nombre;
    private int semestre;

    /**
     * Construtor por omision
     */
    public ClaseDTO() {
    }

    /**
     * Constructor que inicializa los atributos de la clase a excepcion de el ID
     *
     * @param nombre Nombre de la clase
     * @param semestre Semestre en el que se imparte la clase
     */
    public ClaseDTO(String nombre, int semestre) {
        this.nombre = nombre;
        this.semestre = semestre;
    }

    /**
     * Metodo que inicializa los atributos de la clase con una clase de tipo
     * Entidad dada
     *
     * @param clase Clase de tipo Entidad de la que se obtendran los datos
     */
    public ClaseDTO(Clase clase) {
        this.id = clase.getId();
        this.nombre = clase.getNombre();
        this.semestre = clase.getSemestre();
    }

    /**
     * Metodo que obtiene el Id de la clase
     *
     * @return Id de la clase
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Metodo que establece el id de la clase
     *
     * @param id Id de la clase a establecer
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene el nombre de la clase
     *
     * @return Nombre de la clase
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre de la clase
     *
     * @param nombre Nombre de la clase a obtener
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el semestre en el que se cursa la clase
     *
     * @return Semestre en el que se cursa la clase
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Metodo que establece el semestre en el que se cursa la clase
     *
     * @param semestre Smestre en el que se cursa la clase a establecer
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

}
