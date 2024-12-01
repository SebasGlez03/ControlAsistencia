/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Usuario;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class UsuarioDAO {

    public UsuarioDAO() {
    }

    public Usuario obtenerUsuario(int matricula) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", matricula);
        Document usuarios = collection.find(query).first();

        System.out.println("Usuario leido: " + usuarios.toJson());

        int matriculaObtener = usuarios.getInteger("matricula");
        String nombre = usuarios.getString("nombre");
        String apellidoPaterno = usuarios.getString("apellidoPaterno");
        String apellidoMaterno = usuarios.getString("apellidoMaterno");
        String correo = usuarios.getString("correo");
        String contrasenia = usuarios.getString("contrasenia");
        ObjectId rol = usuarios.getObjectId("rol");

        Usuario usuarioObtenido = new Usuario(matriculaObtener, nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, rol);

        return usuarioObtenido;

    }

    public void agregarUsuario(Usuario usuario) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document documentUsuario = new Document();
        documentUsuario.append("matricula", usuario.getMatricula());
        documentUsuario.append("nombre", usuario.getNombre());
        documentUsuario.append("apellidoPaterno", usuario.getApellidoPaterno());
        documentUsuario.append("apellidoMaterno", usuario.getApellidoMaterno());
        documentUsuario.append("correo", usuario.getCorreo());
        documentUsuario.append("contrasenia", usuario.getContrasenia());
        documentUsuario.append("rol", usuario.getRol());

        collection.insertOne(documentUsuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", usuario.getMatricula());

        collection.deleteOne(query);
    }

    public void modificarUsuario(Usuario usuario, Usuario usuarioModificado) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", usuario.getMatricula());

        // Define los cambios que se van a realizar
        Document update = new Document("$set", new Document()
                .append("nombre", usuarioModificado.getNombre())
                .append("apellidoPaterno", usuarioModificado.getApellidoPaterno())
                .append("apellidoMaterno", usuarioModificado.getApellidoMaterno())
                .append("correo", usuarioModificado.getCorreo())
                .append("contrasenia", usuarioModificado.getContrasenia())
                .append("rol", usuarioModificado.getRol())
        );

        // Modifica el primer documento que coincida con el filtro
        collection.updateOne(query, update);

        System.out.println("Usuario modificado correctamente");
    }

}
