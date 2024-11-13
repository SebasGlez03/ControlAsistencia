
import entidades.Maestro;
import java.util.ArrayList;
import java.util.List;
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
        List<String> listaMaterias = new ArrayList();

        listaMaterias.add("Matematicas");
        listaMaterias.add("Calculo");

        List<String> listaMaterias2 = new ArrayList();

        listaMaterias2.add("Ciencias");
        listaMaterias2.add("Quimica");

        Maestro maestro = new Maestro(listaMaterias, 9876, "Manuel", "Martines", "Montes", "manuel@gmail.com", "algobien");

        Maestro maestroModificacion = new Maestro(listaMaterias2, 9876, "Pancho", "Test", "Test", "test@gmail.com", "test");

        IPersistencia bd = new FachadaPersistencia();

<<<<<<< HEAD
//        bd.agregarMaestro(maestro);
//        System.out.println(bd.obtenerMaestro(maestro).toString());
        bd.modificarMaestro(maestro, maestroModificacion);
//        bd.eliminarUsuario(alumno);
=======
        bd.eliminarUsuario(alumno);
        System.out.println(bd.obtenerAlumno(alumno).toString());
        
        
>>>>>>> Nomar
    }

}
