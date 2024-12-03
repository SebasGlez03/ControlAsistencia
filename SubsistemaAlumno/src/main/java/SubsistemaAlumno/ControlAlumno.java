/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubsistemaAlumno;

import dto.AlumnoDTO;
import entidades.Alumno;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/**
 *
 * @author joel_
 */
public class ControlAlumno {

    private AlumnoDTO alumno;
    IPersistencia datos = new FachadaPersistencia();

    public ControlAlumno() {
    }

    public ControlAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

    /**
     * Metodo que valida que el alumno esta registrado en un semestre que este
     * dentro de los parametros
     *
     * @param alumnoDTO
     * @return
     */
    public int validarSemestre(AlumnoDTO alumnoDTO) {
        int semestre = alumnoDTO.getSemestre();

        if (semestre <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        } else {
            return semestre;
        }
    }

    /**
     * metodo que valida que el alumno tiene registrada una calificacion que
     * esta dentro de los parámetros
     *
     * @param alumnoDTO
     * @return
     */
    public float validadPromedio(AlumnoDTO alumnoDTO) {
        float prom = alumnoDTO.getSemestre();

        if (prom < 0 || prom > 10) {
            throw new IllegalArgumentException("Valor invalido");
        } else {
            return prom;
        }
    }

    /**
     * Metodo que verifica que un alumno es legitimo apartir del ID
     *
     * @param alumnoDTO
     * @return
     */
    public AlumnoDTO validarAlumno(AlumnoDTO alumnoDTO) {
        String id = Integer.toString(alumnoDTO.getMatricula());
        if (!id.matches("^00000[1-9]{6}&")) {
            throw new IllegalArgumentException("ID invalida");
        } else {
            return alumnoDTO;
        }
    }

    /**
     * Metodo que busca a un alumno
     *
     * @param alumnoDTO
     */
    public void BuscarAlumno(AlumnoDTO alumnoDTO) {
        String id = Integer.toString(alumnoDTO.getMatricula());

        if (!id.matches("^00000[1-9]{6}&")) {
            throw new IllegalArgumentException("El Alumno no existe");
        } else {
            System.out.println(alumnoDTO.getNombre() + " "
                    + alumnoDTO.getApellidoPaterno() + " " + alumnoDTO.getApellidoMaterno());
            System.out.println(alumnoDTO.getMatricula());
            System.out.println(alumnoDTO.getSemestre());
        }
    }

    /**
     * Metodo que obtiene un alumno de la base de datos
     *
     * @param matricula Matricula de el alumno a obtener
     * @return Objeto tipo AlumnoDTO con el alumno obtenido
     */
    public AlumnoDTO obtenerAlumno(int matricula) {
        Alumno alumnoObtenido = datos.obtenerAlumno(matricula);
        AlumnoDTO alumno = new AlumnoDTO();

        alumno.setMatricula(alumnoObtenido.getMatricula());
        alumno.setNombre(alumnoObtenido.getNombre());
        alumno.setApellidoPaterno(alumnoObtenido.getApellidoPaterno());
        alumno.setApellidoMaterno(alumnoObtenido.getApellidoMaterno());
        alumno.setCorreo(alumnoObtenido.getCorreo());
        alumno.setContrasenia(alumnoObtenido.getContrasenia());
        alumno.setPromedio(alumnoObtenido.getPromedio());
        alumno.setSemestre(alumnoObtenido.getSemestre());
        alumno.setRol(alumnoObtenido.getRol());

        return alumno;

    }

    /**
     * Metodo que agrega un alumno a la base de datos
     *
     * @param alumno Objeto AlumnoDTO con la informacion del alumno
     */
    public void agregarAlumno(AlumnoDTO alumno) {
        Alumno alumnoAgregar = new Alumno();

        alumnoAgregar.setMatricula(alumno.getMatricula());
        alumnoAgregar.setNombre(alumno.getNombre());
        alumnoAgregar.setApellidoPaterno(alumno.getApellidoPaterno());
        alumnoAgregar.setApellidoMaterno(alumno.getApellidoMaterno());
        alumnoAgregar.setCorreo(alumno.getCorreo());
        alumnoAgregar.setContrasenia(alumno.getContrasenia());
        alumnoAgregar.setPromedio(alumno.getPromedio());
        alumnoAgregar.setSemestre(alumno.getSemestre());
        alumnoAgregar.setRol(alumno.getRol());

        datos.agregarAlumno(alumnoAgregar);
    }

    /**
     * Metodo que elimina un alumno de la base de datos
     *
     * @param alumno Objeto AlumnoDTO que se va a eliminar
     */
    public void eliminarAlumno(AlumnoDTO alumno) {
        Alumno alumnoEliminar = new Alumno();

        alumnoEliminar.setMatricula(alumno.getMatricula());
        alumnoEliminar.setNombre(alumno.getNombre());
        alumnoEliminar.setApellidoPaterno(alumno.getApellidoPaterno());
        alumnoEliminar.setApellidoMaterno(alumno.getApellidoMaterno());
        alumnoEliminar.setCorreo(alumno.getCorreo());
        alumnoEliminar.setContrasenia(alumno.getContrasenia());
        alumnoEliminar.setPromedio(alumno.getPromedio());
        alumnoEliminar.setSemestre(alumno.getSemestre());
        alumnoEliminar.setRol(alumno.getRol());

        datos.eliminarUsuario(alumnoEliminar);
    }

    /**
     * Metodo que modifica un alumno de la base de datos
     *
     * @param alumno Objeto AlumnoDTO que se va a modificar
     * @param alumnoModificado Objeto AlumnoDTO con la informacion nueva a
     * suplir
     */
    public void modificarAlumno(AlumnoDTO alumno, AlumnoDTO alumnoModificado) {
        Alumno alumnoModificar = new Alumno();
        Alumno alumnoInfoMod = new Alumno();

        // Informacion del alumno
        alumnoModificar.setMatricula(alumno.getMatricula());
        alumnoModificar.setNombre(alumno.getNombre());
        alumnoModificar.setApellidoPaterno(alumno.getApellidoPaterno());
        alumnoModificar.setApellidoMaterno(alumno.getApellidoMaterno());
        alumnoModificar.setCorreo(alumno.getCorreo());
        alumnoModificar.setContrasenia(alumno.getContrasenia());
        alumnoModificar.setPromedio(alumno.getPromedio());
        alumnoModificar.setSemestre(alumno.getSemestre());
        alumnoModificar.setRol(alumno.getRol());

        // Informacion del alumno con la nueva informacion
        alumnoInfoMod.setMatricula(alumno.getMatricula());
        alumnoInfoMod.setNombre(alumno.getNombre());
        alumnoInfoMod.setApellidoPaterno(alumno.getApellidoPaterno());
        alumnoInfoMod.setApellidoMaterno(alumno.getApellidoMaterno());
        alumnoInfoMod.setCorreo(alumno.getCorreo());
        alumnoInfoMod.setContrasenia(alumno.getContrasenia());
        alumnoInfoMod.setPromedio(alumno.getPromedio());
        alumnoInfoMod.setSemestre(alumno.getSemestre());
        alumnoInfoMod.setRol(alumno.getRol());

        datos.modificarAlumno(alumnoModificar, alumnoInfoMod);
    }

}
