/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;

/**
 * Clase que representa un maestro, que hereda de la clase Usuario. Esta clase
 * incluye una lista de materias que el maestro imparte.
 *
 * @author PC
 */
public class Maestro extends Usuario {

    private List<String> materias; // Lista de materias que el maestro imparte

    // Constructor por defecto
    public Maestro() {
    }

    /**
     * Constructor que inicializa el maestro con una lista de materias.
     *
     * @param materias Lista de materias que el maestro impartirá.
     */
    public Maestro(List<String> materias) {
        this.materias = materias;
    }

    /**
     * Obtiene la lista de materias que el maestro imparte.
     *
     * @return Lista de materias del maestro.
     */
    public List<String> getMaterias() {
        return materias;
    }

    /**
     * Establece la lista de materias que el maestro impartirá.
     *
     * @param materias Lista de materias a asignar al maestro.
     */
    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    /**
     * Método que retorna una representación en forma de cadena del objeto
     * Maestro, incluyendo la información del usuario base y la lista de
     * materias.
     *
     * @return Cadena con la información del maestro.
     */
    @Override
    public String toString() {
        return super.toString() + "Maestro{" + "materias=" + materias + '}';
    }

}
