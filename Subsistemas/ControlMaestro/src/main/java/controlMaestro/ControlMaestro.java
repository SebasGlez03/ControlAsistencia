/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlMaestro;
import dtos.MaestroDTO;
import dtos.AlumnoDTO;
import java.io.IOException;
/**
 *
 * @author PC
 */
public class ControlMaestro {
    private MaestroDTO maestro;

    public ControlMaestro(){}
    
    public ControlMaestro(MaestroDTO maestro) {
        this.maestro = maestro;
    }
    /**
     * este Metodo agrega una materia a la lista de clases a impartir de un maestro
     * @param materia 
     */
    public void impartirClase(String materia){
        maestro.agregarMateria(materia);
    }
    /**
     * Este metodo quita una materia de la lista de clases de un maestro
     * @param materia 
     */
    public void quitarClase (String materia){
        maestro.eliminarMateria(materia);
    }
    /**
     * Este metodo el maestro obtiene el promedio del alumno
     * y verifica si aprobo con un true o reprobo con un false
     * @param alumno
     * @return
     * @throws Exception 
     */
    public boolean evaluarAlumno(AlumnoDTO alumno) throws Exception{
        float prom = alumno.getPromedio();
        try {
            return (prom>=7 && prom<=10);
        } catch (Exception e) {
            throw new Exception("El dato de la calificacion no es valida");
        }
        
    }
}
