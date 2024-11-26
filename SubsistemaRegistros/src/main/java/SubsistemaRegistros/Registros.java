/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package SubsistemaRegistros;
import entidades.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author joel_
 */
public class Registros {
    
    private List<Materia> materiasDisponibles= new ArrayList<>();

    public Registros() {
    }
    
    
    public void agregarMateria(Materia materia){
        if(!materia.estaLlena()){
            materiasDisponibles.add(materia);
        }
    }
    public void inscribirAlumnoEnMateria(Alumno alumno, Materia materia){
        materia.InscribirAlumno(alumno);
    }
    public List<Materia> listarMateriasDisponibles(){
        return materiasDisponibles;
    }
    public List<Alumno> obtenerAlumnosPorMateria(Materia materia){
        return materia.listarAlumnos();
    }
    
    
}
