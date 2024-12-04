/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Clase;
import entidades.Maestro;
import entidades.QR;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class QrDAO {

    public QR obtenerQR(QR qr) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("qr");

        Document documentQr = new Document();
        documentQr.append("contenido", qr.getContenido());
        documentQr.append("fechaCreacion", qr.getFechaCreacion());
        documentQr.append("idSesion", qr.getIdSesion());

        mongoClient.close();

        return qr;

    }

    public void agregarQR(QR qr) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("qr");

        Document documentQr = new Document();
        documentQr.append("contenido", qr.getContenido());
        documentQr.append("fechaCreacion", qr.getFechaCreacion());
        documentQr.append("idSesion", qr.getIdSesion());

        collection.insertOne(documentQr);

        mongoClient.close();
    }

    /**
     * Guarda un QR en la base de datos.
     *
     * @param qr Objeto QR que se desea guardar.
     */
    public void guardarQR(QR qr) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> qrCollection = database.getCollection("qr");
        Document qrDocument = new Document();
        qrDocument.append("idSesion", qr.getIdSesion());
        qrDocument.append("contenido", qr.getContenido());
        qrDocument.append("fechaCreacion", qr.getFechaCreacion());
        qrCollection.insertOne(qrDocument);

        mongoClient.close();
    }

    /**
     * Crea una nueva sesión vinculada a un QR en la base de datos.
     *
     * @param idSesion ID de la sesión.
     * @param clase Clase asociada a la sesión.
     * @param maestro Maestro asociado a la sesión.
     */
    public void crearSesion(ObjectId idSesion, Clase clase, Maestro maestro) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> sesionesCollection = database.getCollection("sesiones");
        Document sesionDocument = new Document();
        sesionDocument.append("_id", idSesion);
        sesionDocument.append("fecha", new Date());
        sesionDocument.append("id_clase", clase.getId());
        sesionDocument.append("matriculaMaestro", maestro.getMatricula());
        sesionDocument.append("listaAsistencia", new ArrayList<>()); // Lista de asistencia vacía
        sesionesCollection.insertOne(sesionDocument);

        mongoClient.close();
    }

}
