/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author joel_
 */
public class MaestroDTO extends UsuarioDTO {

    protected List<String> materias;

    /**
     * Constructor por omision
     */
    public MaestroDTO() {
    }

    /**
     * Constructor que establece la lista de materias y tambien establece
     * atributos de la clase padre (UsuarioDTO)
     *
     * @param materias
     * @param nombre
     * @param correo
     * @param id
     * @param contrasenia
     */
    public MaestroDTO(List<String> materias, String nombre, String correo, int id, String contrasenia) {
        super(nombre, correo, id, contrasenia);
        this.materias = materias;
    }

    /**
     * Metodo para obtener la lista de materias
     *
     * @return materias
     */
    public List<String> getMateria() {
        return materias;
    }

    /**
     * Metodo para establecer materias nuevas apartir de una lista nueva
     *
     * @param materias
     */
    public void setMateria(List<String> materias) {
        this.materias = materias;
    }
    
    /**
     * Agrega una materia al final de la lista
     * @param materia 
     */
    public void agregarMateria(String materia){
        materias.add(materia);
    }
    /**
     * Elimina una materia dentro de la lista usando el nombre como referencia
     * @param materia 
     */
    public void eliminarMateria(String materia){
        materias.remove(materia);
    }
}
