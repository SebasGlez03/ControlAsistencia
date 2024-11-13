
import entidades.Alumno;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class Prueba {
    
    public static void main(String[] args) {
        Alumno alumno = new Alumno(6, (float) 8.2, 235612, "Carlos", "Rivera", "Martinez", "carlos@gmail.com", "hdfags");
        
        IPersistencia bd = new FachadaPersistencia();

        bd.eliminarUsuario(alumno);
        System.out.println(bd.obtenerAlumno(alumno).toString());
        
        
    }
    
}
