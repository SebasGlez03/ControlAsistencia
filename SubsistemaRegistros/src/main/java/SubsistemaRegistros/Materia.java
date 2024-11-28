/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubsistemaRegistros;
import entidades.Alumno;
import entidades.Maestro;
import java.util.List;
/**
 *
 * @author joel_
 */
public class Materia {
    private int ID;
    private String nombre;
    private int Semestre;

    public Materia() {
    }

    public Materia(int ID, String nombre, int Semestre ) {
        this.ID = ID;
        this.nombre = nombre;
        this.Semestre=Semestre;
        
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int Semestre) {
        this.Semestre = Semestre;
    }

    
}
