/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import entidades.Usuario;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class UsuarioDAO {

    /**
     * Metodo que obtiene un usuario de la base de datos
     *
     * @param matricula Matricula tipo int que se relaciona con el usuario de la
     * base de datos
     * @return Objeto tipo Usuario obtenido
     */
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

    /**
     * Metodo que obtiene el nombre de el rol del usuario en forma de string
     *
     * @param rolId Id del rol del usuario
     * @return Nombre del rol en forma de String
     */
    public String obtenerNombreRol(ObjectId rolId) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("rolesUsuario");

        Document rolQuery = new Document("_id", rolId);
        Document rolDoc = collection.find(rolQuery).first();

        return (rolDoc != null) ? rolDoc.getString("rol") : "Rol no encontrado";
    }

    /**
     * Metodo que obtiene todos los usuarios de la base de datos
     *
     * @return Lista de objetos tipo Usuario obtenidos
     */
    public List<Usuario> obtenerTodosUsuarios() {
        // Crear una lista para almacenar los usuarios obtenidos
        List<Usuario> listaUsuarios = new ArrayList<>();

        // Conexión con la base de datos MongoDB
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        // Recuperar todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        // Iterar sobre cada documento y mapearlo a un objeto Usuario
        for (Document doc : documentos) {
            int matricula = doc.getInteger("matricula");
            String nombre = doc.getString("nombre");
            String apellidoPaterno = doc.getString("apellidoPaterno");
            String apellidoMaterno = doc.getString("apellidoMaterno");
            String correo = doc.getString("correo");
            String contrasenia = doc.getString("contrasenia");
            ObjectId rol = doc.getObjectId("rol");

            // Crear un objeto Usuario y agregarlo a la lista
            Usuario usuario = new Usuario(matricula, nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, rol);
            listaUsuarios.add(usuario);
        }

        // Cerrar el cliente MongoDB
        mongoClient.close();

        return listaUsuarios;
    }

    /**
     * Metodo que obtiene todos los usuarios de la base de datos con sus roles
     * como Strings.
     *
     * @return Lista de documentos con los datos de los usuarios y sus roles
     * como Strings.
     */
    public List<Document> obtenerTodosUsuariosConRolString() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> usuariosCollection = database.getCollection("usuarios");

        // Crear la consulta de agregación
        List<Bson> pipeline = new ArrayList<>();

        // Realizar el lookup para enlazar la colección "rolesUsuario" con los usuarios
        pipeline.add(Aggregates.lookup(
                "rolesUsuario", // Nombre de la colección con los roles
                "rol", // Campo local en "usuarios" (ObjectId del rol)
                "_id", // Campo remoto en "rolesUsuario" (ObjectId)
                "detalles_rol" // Alias para el resultado del lookup
        ));

        // Descomponer el array "detalles_rol" (debería tener un solo elemento)
        pipeline.add(Aggregates.unwind("$detalles_rol"));

        // Proyección para seleccionar los campos deseados
        pipeline.add(Aggregates.project(Projections.fields(
                Projections.excludeId(), // Excluir el _id original del usuario
                Projections.include("matricula", "nombre", "apellidoPaterno", "apellidoMaterno",
                        "correo", "contrasenia", "detalles_rol.rol") // Incluir datos relevantes
        )));

        // Ejecutar la consulta de agregación
        AggregateIterable<Document> result = usuariosCollection.aggregate(pipeline);

        // Convertir el resultado a una lista
        List<Document> usuariosConRol = new ArrayList<>();
        for (Document usuario : result) {
            usuariosConRol.add(usuario);
        }

        return usuariosConRol;
    }

    /**
     * Metodo que obtiene el rol del usuario de la base de datos
     *
     * @param matricula Matricula tipo int que se relaciona con el usuario de la
     * base de datos
     * @return String con el rol del usuario
     */
    public String obtenerRolUsuario(int matricula) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", matricula);
        Document usuarios = collection.find(query).first();

        System.out.println("Usuario leido: " + usuarios.toJson());

        // Obtener el ObjectId del rol del usuario
        ObjectId rolId = usuarios.getObjectId("rol");

        // Contar con la colecccion de roles
        MongoCollection<Document> rolesCollection = database.getCollection("rolesUsuario");

        // Realizar la consulta de agregacion para obtener el nombre del rol
        List<Bson> pipeline = new ArrayList<>();

        //Buscar el rol con el ObjectId
        pipeline.add(Aggregates.match(Filters.eq("_id", rolId)));

        // Proyeccion para seleccionar el campo "rol" que contiene el nombre del rol
        pipeline.add(Aggregates.project(Projections.fields(Projections.include("rol"))));

        // Ejecutar la agregacion
        AggregateIterable<Document> result = rolesCollection.aggregate(pipeline);

        // Si se encuentra el rol, obtener el nombre del rol
        if (result.iterator().hasNext()) {
            Document rolDocument = result.iterator().next();
            return rolDocument.getString("rol");
        } else {
            return "Rol no encontrado";
        }

    }

    /**
     * Metodo que agrega un usuario a la base de datos
     *
     * @param usuario Objeto de tipo usuario a agregar a la base de datos
     */
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

    /**
     * Metodo que elimina un usuario de la base de datos
     *
     * @param usuario Objeto de tipo Usuario a eliminar de la base de datos
     */
    public void eliminarUsuario(Usuario usuario) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", usuario.getMatricula());

        collection.deleteOne(query);
    }

    /**
     * Metodo que modifica un usuario de la base de datos
     *
     * @param usuario Objeto de tipo Usuario a modificar en la base de datos
     * @param usuarioModificado Objeto tipo Usuario que suplira la informacion
     */
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
