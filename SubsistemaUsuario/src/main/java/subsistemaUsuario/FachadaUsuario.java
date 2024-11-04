/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaUsuario;

import dto.AlumnoDTO;
import dto.MaestroDTO;
import dto.UsuarioDTO;
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
        // Se tiene que converitr el DTO a una entidad
        return this.persistenciaDAO.agregarAlumno(alumno);
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

}
