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

    public MaestroDTO(List<String> materias, String nombre, String correo, Long id, String contrasenia) {
        super(nombre, correo, id, contrasenia);
        this.materias = materias;
    }
    
    public List<String> getMateria(){
        return materias;
    }
    
    
    public void setMateria(List<String> materias){
        this.materias=materias;
    }
}
