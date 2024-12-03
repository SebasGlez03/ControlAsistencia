/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaClases;

import dto.ClaseDTO;
import entidades.Clase;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IClase {

    /**
     * Metodo que obtiene una clase de la base de datos
     *
     * @param clase Objeto ClaseDTO de la clase a obtener
     * @return Objeto ClaseDTO obtenido
     */
    public ClaseDTO obtenerClase(ClaseDTO clase);

    /**
     * Metodo que obtiene la lista de todas las clases de la base de datos
     *
     * @return Lista de objeto ClaseDTO con todas las clases
     */
    public List<Clase> obtenerTodasClases();

    /**
     * Metodo que agrega una clase a la base de datos
     * @param clase Objeto ClaseDTO con la clase a agregar
     */
    public void agregarClase(ClaseDTO clase);

    /**
     * Metodo que elimina una clase de la base de datos
     * @param clase Objeto ClaseDTO con la clase a eliminar
     */
    public void eliminarClase(ClaseDTO clase);

    /**
     * Metodo que modifica una clase de la base de datos
     * @param clase Objeto ClaseDTO con la clase a 
     * @param claseModificada 
     */
    public void modificarClase(ClaseDTO clase, ClaseDTO claseModificada);

}
