/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaMaestro;

import entidades.Alumno;
import entidades.Maestro;

/**
 *
 * @author limon
 */
/**
 * Clase ControlMaestro
 * Esta clase permite realizar operaciones relacionadas con el control de clases impartidas por un maestro,
 * incluyendo la asignacion y remocion de clases, evaluacion de alumnos y busqueda de maestros
 */
public class ControlMaestro {

    private Maestro maestro; // Instancia de Maestro que se va a controlar

    /**
     * Constructor que inicializa ControlMaestro con una instancia de Maestro
     * @param maestro Instancia de Maestro a controlar
     */
    public ControlMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    /**
     * Asigna una clase al maestro
     * Verifica que la materia no sea nula ni vacia y que sea una materia valida
     * @param materia Nombre de la materia a impartir
     * @throws IllegalArgumentException si la materia es nula o vacia o ya esta en la lista de materias del maestro
     */
    public void impartirClase(String materia) {
        if (materia == null || materia.isEmpty()) {
            throw new IllegalArgumentException("La materia no puede ser nula o vacia");
        }
        if (maestro.getMaterias().contains(materia)) {
            throw new IllegalArgumentException("La materia ya esta asignada al maestro");
        }
        maestro.getMaterias().add(materia); // Agrega la materia a la lista
        System.out.println("Clase de " + materia + " impartida");
    }

    /**
     * Remueve una clase asignada al maestro
     * Verifica que la materia no sea nula ni vacia y que ya este asignada al maestro
     * @param materia Nombre de la materia a quitar
     * @throws IllegalArgumentException si la materia es nula, vacia o no esta asignada al maestro
     */
    public void quitarClase(String materia) {
        if (materia == null || materia.isEmpty()) {
            throw new IllegalArgumentException("La materia no puede ser nula o vacia");
        }
        if (!maestro.getMaterias().contains(materia)) {
            throw new IllegalArgumentException("La materia no esta asignada al maestro y no se puede quitar");
        }
        maestro.getMaterias().remove(materia); // Quita la materia de la lista
        System.out.println("Clase de " + materia + " quitada");
    }

     /**
     * Evalua a un alumno
     * Verifica que el alumno cumpla con los criterios de promedio y que este inscrito en alguna materia del maestro
     * @param alumno Objeto Alumno a evaluar
     * @return true si la evaluacion es exitosa
     * @throws IllegalArgumentException si el alumno es nulo, tiene un promedio insuficiente o no esta inscrito en una clase del maestro
     */
    public boolean evaluarAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }
        if (alumno.getPromedio() < 6.0) {
            throw new IllegalArgumentException("El alumno tiene un promedio insuficiente para ser evaluado");
        }
        if (!alumnoInscrito(alumno)) {
            throw new IllegalArgumentException("El alumno no esta inscrito en ninguna clase impartida por este maestro");
        }
        System.out.println("Alumno " + alumno.getNombre() + " evaluado");
        return true; // Ejemplo: la evaluacion fue satisfactoria
    }

    /**
     * Busca informacion del maestro basado en un criterio
     * Verifica que el criterio de busqueda no sea nulo ni vacio
     * @param criterio Criterio de busqueda, como ID o nombre del maestro
     * @throws IllegalArgumentException si el criterio es nulo o vacio
     */
    public void buscarMaestro(String criterio) {
        if (criterio == null || criterio.isEmpty()) {
            throw new IllegalArgumentException("Debe especificar un criterio de busqueda");
        }
        System.out.println("Busqueda de maestro con criterio: " + criterio);
    }
    
    private boolean alumnoInscrito(Alumno alumno) {
    // Lógica para verificar si el alumno esta inscrito en alguna clase del maestro
    // Por ejemplo, podríamos verificar en una lista de alumnos inscritos para cada materia
    return true; // Este es solo un ejemplo, debes implementar la logica real
    }
    
}
