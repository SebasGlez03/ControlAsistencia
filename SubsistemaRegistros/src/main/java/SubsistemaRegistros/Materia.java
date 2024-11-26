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

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int Semestre) {
        this.Semestre = Semestre;
    }
    private Maestro maestro;
    private List<Alumno> alumnosInscritos;

    public Materia() {
    }

    public Materia(int ID, String nombre, int Semestre ,Maestro maestro, List<Alumno> alumnosInscritos) {
        this.ID = ID;
        this.nombre = nombre;
        this.Semestre=Semestre;
        this.maestro=maestro;
        this.alumnosInscritos = alumnosInscritos;
    }
    
    
    
    public void InscribirAlumno(Alumno alumno)throws IllegalArgumentException{
        try {            
           alumnosInscritos.add(alumno); 
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("El alumno ya se encuentra inscrito en la clase");
        }
    }
    
    public void BajaAlumno(Alumno alumno)
    {
        if(!alumnosInscritos.contains(alumno)){
            throw new IllegalArgumentException("el alumno no se encuentra inscrito");
        }
        alumnosInscritos.remove(alumno);
    }
    public List<Alumno> listarAlumnos(){
        return alumnosInscritos;
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

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public List<Alumno> getAlumnosInscritos() {
        return alumnosInscritos;
    }

    public void setAlumnosInscritos(List<Alumno> alumnosInscritos) {
        this.alumnosInscritos = alumnosInscritos;
    }
    
    public boolean estaLlena(){
        if(alumnosInscritos.size()==25){
            return true;
        }
        return false;
    }
}
