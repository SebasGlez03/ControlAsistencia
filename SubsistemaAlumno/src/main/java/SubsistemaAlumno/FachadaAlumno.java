/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubsistemaAlumno;

import dto.AlumnoDTO;
import entidades.Alumno;
import persistencia.IPersistencia;

/**
 *
 * @author joel_
 */
public class FachadaAlumno implements IAlumno {

    private ControlAlumno controlAlumno = new ControlAlumno();

    @Override
    public void EscanearQR() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Metodo que obtiene un alumno del sistema
     *
     * @param matricula Matricula del alumno a obtener
     * @return Objeto AlumnoDTO obtenido
     */
    @Override
    public AlumnoDTO obtenerAlumno(int matricula) {
        return controlAlumno.obtenerAlumno(matricula);
    }

    /**
     * Metodo que agrega un alumno al sistema
     *
     * @param alumno Objeto AlumnoDTO con la informacion de alumno a agregar
     */
    @Override
    public void agregarAlumno(AlumnoDTO alumno) {
        controlAlumno.agregarAlumno(alumno);
    }

    /**
     * Metodo que elimina un alumno del sistema
     *
     * @param alumno Objeto AlumnoDTO a eliminar
     */
    @Override
    public void eliminarAlumno(AlumnoDTO alumno) {
        controlAlumno.eliminarAlumno(alumno);
    }

    /**
     * Metodo que modifica un alumno del sistema
     *
     * @param alumno Objeto AlumnoDTO a modificar
     * @param alumnoModificado Objeto AlumoDTO con la informacion a suplir
     */
    @Override
    public void modificarAlumno(AlumnoDTO alumno, AlumnoDTO alumnoModificado) {
        controlAlumno.modificarAlumno(alumno, alumnoModificado);
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
