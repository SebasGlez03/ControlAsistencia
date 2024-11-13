/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author sebastian
 */
public class ConexionBD implements IConexionBD {

    final String SERVER = "localhost";
    final String BASE_DATOS = "cia";
    final String COLLECTION = "controlasistencia";
    final int PUERTO = 27017;

    /**
     * Metodo que crea la conexion con la base de datos
     */
    @Override
    public void crearConexion() {

        MongoClient mongoClient = new MongoClient(SERVER, PUERTO);
        MongoDatabase database = mongoClient.getDatabase(BASE_DATOS);
        MongoCollection<Document> collection = database.getCollection(COLLECTION);

    }

}
