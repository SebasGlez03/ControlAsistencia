/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mock;

import entidades.Alumno;
import entidades.Maestro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Preuba {

    public static void main(String[] args) {

        Alumno a = new Alumno(0, 0);
        Alumno a2 = new Alumno();
        Alumno a3 = new Alumno();
        Alumno a4 = new Alumno();

        Maestro m = new Maestro();
        Maestro m2 = new Maestro();
        Maestro m3 = new Maestro();

        BaseDatosMock bd = new BaseDatosMock();

        List<String> materias = new ArrayList<>();
        List<String> materias2 = new ArrayList<>();
        List<String> materias3 = new ArrayList<>();

        materias.add("Matematicas");
        materias2.add("Matematicas");
        materias.add("Ciencias");
        materias3.add("Fisica");

        a.setId(7);
        a.setNombre("Juan");
        a.setApellidoPaterno("Lopez");
        a.setApellidoMaterno("Perez");
        a.setCorreo("juan@gmail.com");
        a.setContrasenia("123321");
        a.setPromedio((float) 8.2);
        a.setSemestre(5);

        a2.setId(6);
        a2.setNombre("Pedro");
        a2.setApellidoPaterno("Gutierrez");
        a2.setApellidoMaterno("Hernandez");
        a2.setCorreo("pedro@gmail.com");
        a2.setContrasenia("321123");
        a2.setPromedio((float) 9.6);
        a2.setSemestre(2);

        a3.setId(5);
        a3.setNombre("Carlos");
        a3.setApellidoPaterno("Martinez");
        a3.setApellidoMaterno("Tapia");
        a3.setCorreo("carlos@gmail.com");
        a3.setContrasenia("123321");
        a3.setPromedio((float) 8.2);
        a3.setSemestre(5);

        a4.setId(4);
        a4.setNombre("Alfonzo");
        a4.setApellidoPaterno("Ramirez");
        a4.setApellidoMaterno("Perez");
        a4.setCorreo("alfonzo@gmail.com");
        a4.setContrasenia("123321");
        a4.setPromedio((float) 8.2);
        a4.setSemestre(5);

        m.setId(3);
        m.setNombre("Paco");
        m.setApellidoPaterno("Gonzalez");
        m.setApellidoMaterno("Herrera");
        m.setCorreo("paco@gmail.com");
        m.setContrasenia("123321");
        m.setMaterias(materias);

        m2.setId(2);
        m2.setNombre("Hector");
        m2.setApellidoPaterno("Alejandria");
        m2.setApellidoMaterno("Olivera");
        m2.setCorreo("hector@gmail.com");
        m2.setContrasenia("123321");
        m2.setMaterias(materias2);

        m3.setId(1);
        m3.setNombre("Sandra");
        m3.setApellidoPaterno("Lopez");
        m3.setApellidoMaterno("Perez");
        m3.setCorreo("sandra@gmail.com");
        m3.setContrasenia("123321");
        m3.setMaterias(materias3);

        bd.agregarAlumno(a);
        bd.agregarAlumno(a2);
        bd.agregarAlumno(a3);
        bd.agregarAlumno(a4);
        bd.agregarMaestro(m);
        bd.agregarMaestro(m2);
        bd.agregarMaestro(m3);

        System.out.println("ALUMNOS");
        for (Alumno alumnos : bd.getAlumnos()) {
            System.out.println(alumnos);
        }

        System.out.println("Maestros");
        for (Maestro maestro : bd.getMaestros()) {
            System.out.println(maestro);
        }

        System.out.println("-------------------------------------------------");

        bd.eliminarAlumno(a2);
        bd.eliminarMaestro(m);

        System.out.println("ALUMNOS");
        for (Alumno alumnos : bd.getAlumnos()) {
            System.out.println(alumnos);
        }

        System.out.println("Maestros");
        for (Maestro maestro : bd.getMaestros()) {
            System.out.println(maestro);
        }

        System.out.println("-------------------------------------------------");

        System.out.println("Alumno sin modificar:");
        System.out.println(a);
        Alumno aMod = new Alumno();
        aMod.setId(7);
        aMod.setNombre("Modificacion");
        aMod.setApellidoPaterno("Modificacion");
        aMod.setApellidoMaterno("Modificacion");
        aMod.setCorreo("Modificacion@gmail.com");
        aMod.setContrasenia("Modificacion");
        aMod.setPromedio((float) 10.0);
        aMod.setSemestre(9);
        bd.modificarAlumno(a, aMod);
        System.out.println("Alumno modificado");
        System.out.println(a);

        System.out.println("Maestro sin modificar:");
        System.out.println(m2);
        Maestro mMod = new Maestro();
        mMod.setId(2);
        mMod.setNombre("Momomomo");
        mMod.setApellidoPaterno("Momomomo");
        mMod.setApellidoMaterno("Momomomo");
        mMod.setCorreo("Momomomo@gmail.com");
        mMod.setContrasenia("Momomomo");
        mMod.setMaterias(materias2);
        bd.modificarMaestro(m2, mMod);
        System.out.println("Maestro modificado");
        System.out.println(m2);

    }

}
