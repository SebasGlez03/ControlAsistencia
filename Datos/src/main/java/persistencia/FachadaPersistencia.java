/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.AlumnoDAO;
import dao.MaestroDAO;
import dao.UsuarioDAO;
import entidades.Alumno;
import entidades.Maestro;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author sebastian
 */
public class FachadaPersistencia implements IPersistencia {
    
    @Override
    public Usuario obtenerUsuario(int matricula) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.obtenerUsuario(matricula);
    }
    
    @Override
    public void agregarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.agregarUsuario(usuario);
    }
    
    @Override
    public void eliminarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.eliminarUsuario(usuario);
    }
    
    @Override
    public void modificarUsuario(Usuario usuario, Usuario usuarioModificado) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.modificarUsuario(usuario, usuarioModificado);
    }
    
    @Override
    public Alumno obtenerAlumno(Alumno alumno) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.obtenerAlumno(alumno);
        
    }
    
    @Override
    public void agregarAlumno(Alumno alumno) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.agregarAlumno(alumno);
    }
    
    @Override
    public void modificarAlumno(Alumno alumno, Alumno alumnoModificado) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.modificarAlumno(alumno, alumnoModificado);
    }
    
    @Override
    public Maestro obtenerMaestro(Maestro maestro) {
        MaestroDAO maestroDAO = new MaestroDAO();
        return maestroDAO.obtenerMaestro(maestro);
        
    }
    
    @Override
    public void agregarMaestro(Maestro maestro) {
        // Esta clase recibe una lista que actualmente es mock ya que no es parte de nuestro caso de uso
        MaestroDAO maestroDAO = new MaestroDAO();
        maestroDAO.agregarMaestro(maestro);
    }
    
    @Override
    public void modificarMaestro(Maestro maestro, Maestro maestroModificado) {
        MaestroDAO maestroDAO = new MaestroDAO();
        maestroDAO.modificarMaestro(maestro, maestroModificado);
    }
    
}
