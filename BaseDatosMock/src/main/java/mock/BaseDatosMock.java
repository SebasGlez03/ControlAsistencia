/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class BaseDatosMock {

    private List<Alumno> alumnosDAOmock;
    private List<Maestro> maestrosDAOmock;

    public BaseDatosMock() {
//        this.alumnosDAOmock = new ArrayList<>(); // Inicializa la lista de alumnos
//        this.maestrosDAOmock = new ArrayList<>(); // Inicializa la lista de maestro

        this.alumnosDAOmock = llenarListaAlumno();
        this.maestrosDAOmock = llenarListaMaestros();
    }

    // Método para agregar un alumno a la lista
    public void agregarAlumno(Alumno alumno) {
        this.alumnosDAOmock.add(alumno);
    }

    // Método para agregar un maestro a la lista
    public void agregarMaestro(Maestro maestro) {
        this.maestrosDAOmock.add(maestro);
    }

    // Metodo para eliminar un alumno de la lista
    public void eliminarAlumno(Alumno alumno) {
        this.alumnosDAOmock.remove(alumno);
    }

    // Metodo para eliminar un maestro de la lista
    public void eliminarMaestro(Maestro maestro) {
        this.maestrosDAOmock.remove(maestro);
    }

    // Metodo para modificar el alumno de la lista
    public void modificarAlumno(Alumno alumno, Alumno alumnoModificacion) {
        for (Alumno a : alumnosDAOmock) {
            if (a.getMatricula() == alumno.getMatricula()) {
                a.setMatricula(alumnoModificacion.getMatricula());
                a.setNombre(alumnoModificacion.getNombre());
                a.setApellidoPaterno(alumnoModificacion.getApellidoPaterno());
                a.setApellidoMaterno(alumnoModificacion.getApellidoMaterno());
                a.setCorreo(alumnoModificacion.getCorreo());
                a.setContrasenia(alumnoModificacion.getContrasenia());
                a.setPromedio(alumnoModificacion.getPromedio());
                a.setSemestre(alumnoModificacion.getSemestre());
                break;
            }
        }
    }

    // Metodo para modificar el maestro de la lista
    public void modificarMaestro(Maestro maestro, Maestro maestroModificado) {
        for (Maestro m : maestrosDAOmock) {
            if (m.getMatricula() == maestroModificado.getMatricula()) {
                m.setMatricula(maestroModificado.getMatricula());
                m.setNombre(maestroModificado.getNombre());
                m.setApellidoPaterno(maestroModificado.getApellidoPaterno());
                m.setApellidoMaterno(maestroModificado.getApellidoMaterno());
                m.setCorreo(maestroModificado.getCorreo());
                m.setContrasenia(maestroModificado.getContrasenia());
                m.setMaterias(maestroModificado.getMaterias());
                break;
            }
        }
    }

    // Método para obtener la lista de alumnos
    public List<Alumno> getAlumnos() {
        return alumnosDAOmock;
    }

    // Método para obtener la lista de maestros
    public List<Maestro> getMaestros() {
        return maestrosDAOmock;
    }

    // Se agrego con la base de datos mock
    private List<Alumno> llenarListaAlumno() {

        Alumno a = new Alumno(0, 0);
        Alumno a2 = new Alumno();
        Alumno a3 = new Alumno();
        Alumno a4 = new Alumno();

        List<Alumno> alumnosLlenos = new ArrayList<>();

        a.setMatricula(7);
        a.setNombre("Juan");
        a.setApellidoPaterno("Lopez");
        a.setApellidoMaterno("Perez");
        a.setCorreo("juan@gmail.com");
        a.setContrasenia("123321");
        a.setPromedio((float) 8.2);
        a.setSemestre(5);

        a2.setMatricula(6);
        a2.setNombre("Pedro");
        a2.setApellidoPaterno("Gutierrez");
        a2.setApellidoMaterno("Hernandez");
        a2.setCorreo("pedro@gmail.com");
        a2.setContrasenia("321123");
        a2.setPromedio((float) 9.6);
        a2.setSemestre(2);

        a3.setMatricula(5);
        a3.setNombre("Carlos");
        a3.setApellidoPaterno("Martinez");
        a3.setApellidoMaterno("Tapia");
        a3.setCorreo("carlos@gmail.com");
        a3.setContrasenia("123321");
        a3.setPromedio((float) 8.2);
        a3.setSemestre(5);

        a4.setMatricula(4);
        a4.setNombre("Alfonzo");
        a4.setApellidoPaterno("Ramirez");
        a4.setApellidoMaterno("Perez");
        a4.setCorreo("alfonzo@gmail.com");
        a4.setContrasenia("123321");
        a4.setPromedio((float) 8.2);
        a4.setSemestre(5);

        alumnosLlenos.add(a);
        alumnosLlenos.add(a2);
        alumnosLlenos.add(a3);
        alumnosLlenos.add(a4);

        return alumnosLlenos;

    }

    // Se agrego con la base de datos mock
    private List<Maestro> llenarListaMaestros() {

        Maestro m = new Maestro();
        Maestro m2 = new Maestro();
        Maestro m3 = new Maestro();
        List<String> materias = new ArrayList<>();
        List<String> materias2 = new ArrayList<>();
        List<String> materias3 = new ArrayList<>();

        List<Maestro> maestrosLlenos = new ArrayList<>();

        m.setMatricula(3);
        m.setNombre("Paco");
        m.setApellidoPaterno("Gonzalez");
        m.setApellidoMaterno("Herrera");
        m.setCorreo("paco@gmail.com");
        m.setContrasenia("123321");
        m.setMaterias(materias);

        m2.setMatricula(2);
        m2.setNombre("Hector");
        m2.setApellidoPaterno("Alejandria");
        m2.setApellidoMaterno("Olivera");
        m2.setCorreo("hector@gmail.com");
        m2.setContrasenia("123321");
        m2.setMaterias(materias2);

        m3.setMatricula(1);
        m3.setNombre("Sandra");
        m3.setApellidoPaterno("Lopez");
        m3.setApellidoMaterno("Perez");
        m3.setCorreo("sandra@gmail.com");
        m3.setContrasenia("123321");
        m3.setMaterias(materias3);

        maestrosLlenos.add(m);
        maestrosLlenos.add(m2);
        maestrosLlenos.add(m3);

        return maestrosLlenos;

    }
}
