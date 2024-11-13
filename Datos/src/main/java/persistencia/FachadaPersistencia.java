/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Usuario;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author sebastian
 */
public class FachadaPersistencia implements IPersistencia {

    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", usuario.getMatricula());
        Document usuarios = collection.find(query).first();

        System.out.println("Usuario leido: " + usuarios.toJson());

        int matricula = usuarios.getInteger("matricula");
        String nombre = usuarios.getString("nombre");
        String apellidoPaterno = usuarios.getString("apellidoPaterno");
        String apellidoMaterno = usuarios.getString("apellidoMaterno");
        String correo = usuarios.getString("correo");
        String contrasenia = usuarios.getString("contrasenia");

        Usuario usuarioObtenido = new Usuario(matricula, nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia);

        return usuarioObtenido;

    }

    @Override
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

        collection.insertOne(documentUsuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", usuario.getMatricula());

        collection.deleteOne(query);
    }

    @Override
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
        );

        // Modifica el primer documento que coincida con el filtro
        collection.updateOne(query, update);

        System.out.println("Usuario modificado correctamente");
    }

}
