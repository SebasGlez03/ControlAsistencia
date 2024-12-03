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
        Alumno alumnoAgregar = convertirAlumnoDTOaEntidad(alumno);

        datos.agregarAlumno(alumnoAgregar);
    }

    /**
     * Metodo que elimina un alumno de la base de datos
     *
     * @param alumno Objeto AlumnoDTO que se va a eliminar
     */
    public void eliminarAlumno(AlumnoDTO alumno) {
        Alumno alumnoEliminar = convertirAlumnoDTOaEntidad(alumno);

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

        // Informacion del alumno
        Alumno alumnoModificar = convertirAlumnoDTOaEntidad(alumno);

        // Informacion del alumno con la nueva informacion
        Alumno alumnoInfoMod = convertirAlumnoDTOaEntidad(alumnoModificado);

        datos.modificarAlumno(alumnoModificar, alumnoInfoMod);
    }

    /**
     * Metodo que convierte un AlumnoDTO a un AlumnoEntidad
     *
     * @param dto AlumnoDTO que se transformara a AlumnoEntidad
     * @return Alumno de tipo Entidad
     */
    public Alumno convertirAlumnoDTOaEntidad(AlumnoDTO dto) {

        Alumno alumno = new Alumno();

        alumno.setMatricula(dto.getMatricula());
        alumno.setNombre(dto.getNombre());
        alumno.setApellidoPaterno(dto.getApellidoPaterno());
        alumno.setApellidoMaterno(dto.getApellidoMaterno());
        alumno.setCorreo(dto.getCorreo());
        alumno.setContrasenia(dto.getContrasenia());
        alumno.setRol(dto.getRol());
        alumno.setSemestre(dto.getSemestre());
        alumno.setPromedio(dto.getPromedio());
        alumno.setEstadoAsistencia(dto.getEstadoAsistencia());

        return alumno;
    }

}
