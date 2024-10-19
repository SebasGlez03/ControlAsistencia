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
public class MaestroDTO extends UsuarioDTO{
    protected List<String> materias;
    
    /**
     * Constructor por omision
     */
    public MaestroDTO(){}
    /**
     * Constructor que establece la lista de materias y tambien establece 
     * atributos de la clase padre (UsuarioDTO)
     * @param materias
     * @param nombre
     * @param correo
     * @param id
     * @param contrasenia 
     */
    public MaestroDTO(List<String> materias, String nombre, String correo, Long id, String contrasenia) {
        super(nombre, correo, id, contrasenia);
        this.materias = materias;
    }
    
    /**
     * Metodo para obtener la lista de materias
     * @return materias
     */
    public List<String> getMateria(){
        return materias;
    }
    
    /**
     * Metodo para establecer materias nuevas apartir de una lista nueva
     * @param materias 
     */
    public void setMateria(List<String> materias){
        this.materias=materias;
    }
}
