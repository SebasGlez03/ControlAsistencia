/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaUsuario;

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
    public UsuarioDTO agregarAlumno() {
        // Se tiene que converitr el DTO a una entidad
        this.persistenciaDAO.agregarAlumno(Alumno alumno);
    }

    @Override
    public UsuarioDTO agregarMaestro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioDTO eliminarAlumno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioDTO eliminarMaestro() {
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
