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

    private IPersistencia persistenciaDAO;

    private ControlAlumno controlAlumno = new ControlAlumno();

    public FachadaAlumno(IPersistencia persistenciaDAO) {
        this.persistenciaDAO = persistenciaDAO;
    }

    @Override
    public void EscanearQR() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AlumnoDTO obtenerAlumno(int matricula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarAlumno(AlumnoDTO alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarAlumno(AlumnoDTO alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificarAlumno(AlumnoDTO alumno, AlumnoDTO alumnoModificado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
