
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

        Maestro maestro = new Maestro(listaMaterias, 9876, "Manuel", "Martines", "Montes", "manuel@gmail.com", "algobien");

        IPersistencia bd = new FachadaPersistencia();

        bd.agregarMaestro(maestro);
//        System.out.println(bd.obtenerAlumno(alumno).toString());

//        bd.eliminarUsuario(alumno);
    }

}
