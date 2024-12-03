/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Clase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class ClaseDAO {

    /**
     * Metodo que obtiene una clase de la base de datos
     *
     * @param clase Objeto de tipo Clase a obtener de la base de datos
     * @return Objeto tipo Clase obtenido
     */
    public Clase obtenerClase(Clase clase) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("clases");

        Document query = new Document("_id", clase.getId());
        Document clases = collection.find(query).first();

        System.out.println("Clase leida: " + clases.toJson());

        ObjectId id = clases.getObjectId("_id");
        String nombre = clases.getString("nombre");
        int semestre = clases.getInteger("semestre");

        Clase claseObtenida = new Clase(nombre, semestre);
        claseObtenida.setId(id);

        return claseObtenida;

    }

    /**
     * Metodo que obtiene la lista de todas las clases de la base de datos
     *
     * @return Lista con todas las clases de la base de datos
     */
    public List<Clase> obtenerTodasClases() {
        // Crear una lista para almacenar las clases obtenidas
        List<Clase> listaClases = new ArrayList<>();

        // Conexión con la base de datos MongoDB
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("clases");

        // Recuperar todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        // Iterar sobre cada documento y mapearlo a un objeto Clase
        for (Document doc : documentos) {
            String nombre = doc.getString("nombre");
            int semestre = doc.getInteger("semestre");

            // Crear un objeto Clase y agregarlo a la lista
            Clase clase = new Clase(nombre, semestre);
            listaClases.add(clase);
        }

        // Cerrar el cliente de mongoDB
        mongoClient.close();

        return listaClases;
    }

    /**
     * Metodo que agrega una clase a la base de datos
     *
     * @param clase Objeto tipo Clase a agregar en la base de datos
     */
    public void agregarClase(Clase clase) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("clases");

        Document documentClase = new Document();
        documentClase.append("nombre", clase.getNombre());
        documentClase.append("semestre", clase.getSemestre());

        collection.insertOne(documentClase);

    }

    /**
     * Metodo que elimina una clase de la base de datos
     *
     * @param clase Objeto tipo Clase a eliminar en la base de datos
     */
    public void eliminarClase(Clase clase) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("clases");

        Document query = new Document("_id", clase.getId());

        collection.deleteOne(query);

    }

    /**
     * Metodo que modifica una clase de la base de datos
     *
     * @param clase Objeto de tipo Clase a modificar en la base de datos
     * @param claseModificada Objeto tipo Clase que suplira la informacion
     */
    public void modificarClase(Clase clase, Clase claseModificada) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("clases");

        Document query = new Document("_id", clase.getId());

        // Define los cambios que se van a realizar
        Document update = new Document("$set", new Document()
                .append("_id", claseModificada.getId())
                .append("nombre", claseModificada.getNombre())
                .append("semestre", claseModificada.getSemestre())
        );

        // Modifica el primer documento que coincida con el filtro
        collection.updateOne(query, update);

        System.out.println("Clase modificada correctamente");
    }
}
