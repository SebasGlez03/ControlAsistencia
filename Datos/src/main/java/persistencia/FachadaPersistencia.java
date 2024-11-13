/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.AlumnoDAO;
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
    public Usuario obtenerUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.obtenerUsuario(usuario);
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

//    @Override
//    public Maestro obtenerMaestro(Maestro maestro) {
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        MongoDatabase database = mongoClient.getDatabase("cia");
//        MongoCollection<Document> collection = database.getCollection("usuarios");
//
//        Document query = new Document("matricula", maestro.getMatricula());
//        Document maestros = collection.find(query).first();
//
//        System.out.println("Alumno leido: " + maestros.toJson());
//
//        int matricula = maestros.getInteger("matricula");
//        String nombre = maestros.getString("nombre");
//        String apellidoPaterno = maestros.getString("apellidoPaterno");
//        String apellidoMaterno = maestros.getString("apellidoMaterno");
//        String correo = maestros.getString("correo");
//        String contrasenia = maestros.getString("contrasenia");
//        String materias = maestros.getString("clasesImpartidas");
//
//        return maestro;
//
//    }
//    
    @Override
    public Maestro obtenerMaestro(Maestro maestro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarMaestro(Maestro maestro) {
        // Esta clase recibe una lista que actualmente es mock ya que no es parte de nuestro caso de uso
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        List<Document> clasesLista = new ArrayList();

        for (String clase : maestro.getMaterias()) {
            Document documentClase = new Document();
            documentClase.append("id", new ObjectId());
            documentClase.append("nombreClase", clase);
            clasesLista.add(documentClase);
        }

        Document documentMaestro = new Document();
        documentMaestro.append("matricula", maestro.getMatricula());
        documentMaestro.append("nombre", maestro.getNombre());
        documentMaestro.append("apellidoPaterno", maestro.getApellidoPaterno());
        documentMaestro.append("apellidoMaterno", maestro.getApellidoMaterno());
        documentMaestro.append("correo", maestro.getCorreo());
        documentMaestro.append("contrasenia", maestro.getContrasenia());
        documentMaestro.append("clasesImpartidas", clasesLista);

        collection.insertOne(documentMaestro);
    }

}
