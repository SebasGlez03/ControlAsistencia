/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.subsistemaclases;

import dto.ClaseDTO;
import entidades.Clase;
import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/**
 *
 * @author PC
 */
public class ControlClase {

    IPersistencia datos = new FachadaPersistencia();

    /**
     * Metodo que obtiene una clase de la base de datos
     *
     * @param clase Objeto ClaseDTO a obtener
     * @return Objeto ClaseDTO obtenido
     */
    public ClaseDTO obtenerClase(ClaseDTO clase) {
        Clase claseObtenida = new Clase();
        ClaseDTO claseRegresar = new ClaseDTO();

        claseRegresar.setId(claseObtenida.getId());
        claseRegresar.setNombre(claseRegresar.getNombre());
        claseRegresar.setSemestre(claseRegresar.getSemestre());

        return claseRegresar;

    }

    /**
     * Metodo que obtiene la lista de todas las clases de la base de datos
     *
     * @return Lista con todos los objetos Clase de la base de datos
     */
    public List<Clase> obtenerTodasClases() {
        return datos.obtenerTodasClases();
    }

    /**
     * Metodo que agrega una clase a la base de datos
     *
     * @param clase Objeto ClaseDTO a agregar en la base de datos
     */
    public void agregarClase(ClaseDTO clase) {
        datos.agregarClase(convertirDTOaEntidad(clase));
    }

    /**
     * Metodo que elimina una clase de la base de datos
     *
     * @param clase Object ClaseDTO a eliminar de la base de datos
     */
    public void eliminarClase(ClaseDTO clase) {
        datos.eliminarClase(convertirDTOaEntidad(clase));
    }

    /**
     * Metodo que modifica una clase de la base de datos
     *
     * @param clase Objecto ClaseDTO con la clase a modificar
     * @param claseModificada Objecto ClaseDTO con la infromacion a suplir
     */
    public void modificarClase(ClaseDTO clase, ClaseDTO claseModificada) {
        Clase claseModificar = convertirDTOaEntidad(clase);
        Clase claseInfoMod = convertirDTOaEntidad(claseModificada);

        datos.modificarClase(claseModificar, claseInfoMod);
    }

    /**
     * Metodo que convierte una ClaseDTO a una entidad
     *
     * @param dto ClaseDTO a obtener su Entidad
     * @return Objeto Entidad con la informacion de ClaseDTO
     */
    public Clase convertirDTOaEntidad(ClaseDTO dto) {
        Clase clase = new Clase();

        clase.setId(dto.getId());
        clase.setNombre(dto.getNombre());
        clase.setSemestre(dto.getSemestre());

        return clase;
    }
}
