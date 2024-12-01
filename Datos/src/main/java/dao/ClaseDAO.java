/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Clase;
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
