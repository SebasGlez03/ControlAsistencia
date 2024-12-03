/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.subsistemaclases;

import dto.ClaseDTO;
import entidades.Clase;
import java.util.List;

/**
 *
 * @author PC
 */
public class FachadaClase implements IClase {

    ControlClase controlClase = new ControlClase();

    /**
     * Metodo que obtiene una clase de la base de datos
     *
     * @param clase Objeto ClaseDTO de la clase a obtener
     * @return Objeto ClaseDTO obtenido
     */
    @Override
    public ClaseDTO obtenerClase(ClaseDTO clase) {
        return controlClase.obtenerClase(clase);
    }

    /**
     * Metodo que obtiene la lista de todas las clases de la base de datos
     *
     * @return Lista de objeto ClaseDTO con todas las clases
     */
    @Override
    public List<Clase> obtenerTodasClases() {
        return controlClase.obtenerTodasClases();
    }

    /**
     * Metodo que agrega una clase a la base de datos
     *
     * @param clase Objeto ClaseDTO con la clase a agregar
     */
    @Override
    public void agregarClase(ClaseDTO clase) {
        controlClase.agregarClase(clase);
    }

    /**
     * Metodo que elimina una clase de la base de datos
     *
     * @param clase Objeto ClaseDTO con la clase a eliminar
     */
    @Override
    public void eliminarClase(ClaseDTO clase) {
        controlClase.eliminarClase(clase);
    }

    /**
     * Metodo que modifica una clase de la base de datos
     *
     * @param clase Objeto ClaseDTO con la clase a
     * @param claseModificada
     */
    @Override
    public void modificarClase(ClaseDTO clase, ClaseDTO claseModificada) {
        controlClase.modificarClase(clase, claseModificada);
    }

}
