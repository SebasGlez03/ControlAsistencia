/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaUsuario;

import dto.AlumnoDTO;
import dto.MaestroDTO;
import dto.UsuarioDTO;
import entidades.Alumno;
import persistencia.IPersistencia;

/**
 *
 * @author PC
 */
public class FachadaUsuario implements IUsuario {

    private IPersistencia persistenciaDAO;

    /**
     * Constructor de la clase que implementa la conexion con la clase de
     * persistencia de datos.
     *
     * @param persistenciaDAO conexion con los datos de la base de datos
     */
    public FachadaUsuario(IPersistencia persistenciaDAO) {
        this.persistenciaDAO = persistenciaDAO;
    }

    @Override
    public boolean iniciarSesion(UsuarioDTO id, UsuarioDTO contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarAlumno(AlumnoDTO alumno) {
        this.persistenciaDAO.agregarAlumno(convertirAlumnoDTOaEntidad(alumno));
    }

    @Override
    public void agregarMaestro(MaestroDTO maestro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarAlumno(AlumnoDTO alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarMaestro(MaestroDTO maestro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarClaseAlumno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarClaseMaestro() {
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

        alumno.setId(dto.getId());
        alumno.setNombre(dto.getNombre());
        alumno.setApellidoPaterno(dto.getApellidoPaterno());
        alumno.setApellidoMaterno(dto.getApellidoMaterno());
        alumno.setCorreo(dto.getCorreo());
        alumno.setContrasenia(dto.getContrasenia());
        alumno.setSemestre(dto.getSemestre());
        alumno.setPromedio(dto.getPromedio());

        return alumno;
    }

}
