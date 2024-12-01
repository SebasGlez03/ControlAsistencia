/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Maestro;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class MaestroDAO {

    public MaestroDAO() {
    }

    public Maestro obtenerMaestro(Maestro maestro) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", maestro.getMatricula());
        Document maestros = collection.find(query).first();

        System.out.println("Maestro leido: " + maestros.toJson());

        int matricula = maestros.getInteger("matricula");
        String nombre = maestros.getString("nombre");
        String apellidoPaterno = maestros.getString("apellidoPaterno");
        String apellidoMaterno = maestros.getString("apellidoMaterno");
        String correo = maestros.getString("correo");
        String contrasenia = maestros.getString("contrasenia");
        ObjectId rol = maestros.getObjectId("rol");
        List<Document> clasesImpartidas = maestros.getList("clasesImpartidas", Document.class);

        List<String> materias = new ArrayList<>();

        for (Document clase : clasesImpartidas) {
            String nombreClase = clase.getString("nombreClase");
            if (nombreClase != null) {
                materias.add(nombreClase);
            }
        }

        Maestro maestroObtenido = new Maestro(materias, matricula, nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, rol);

        return maestroObtenido;

    }

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
        documentMaestro.append("rol", maestro.getRol());

        collection.insertOne(documentMaestro);
    }

    public void modificarMaestro(Maestro maestro, Maestro maestroModificado) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", maestro.getMatricula());

        List<Document> clasesLista = new ArrayList();

//        maestro.getMaterias().clear();
        for (String clase : maestroModificado.getMaterias()) {
            Document documentClase = new Document();
            documentClase.append("id", new ObjectId());
            documentClase.append("nombreClase", clase);
            clasesLista.add(documentClase);
        }

        // Define los cambios que se van a realizar
        Document update = new Document("$set", new Document()
                .append("nombre", maestroModificado.getNombre())
                .append("apellidoPaterno", maestroModificado.getApellidoPaterno())
                .append("apellidoMaterno", maestroModificado.getApellidoMaterno())
                .append("correo", maestroModificado.getCorreo())
                .append("contrasenia", maestroModificado.getContrasenia())
                .append("clasesImpartidas", clasesLista)
                .append("rol", maestroModificado.getRol())
        );

        // Modifica el primer documento que coincida con el filtro
        collection.updateOne(query, update);

        System.out.println("Maestro modificado correctamente");
    }

}
