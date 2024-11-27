/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.internal.connection.Time;
import entidades.Evento;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author limon
 */
public class EventoDAO {
    
    public Evento obtenerEvento(Evento evento){
        
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        Document query = new Document("titulo", evento.getTitulo());
        Document eventos = collection.find(query).first();

        System.out.println("Evento leido: " + eventos.toJson());

         // Extraer valores
        String titulo = eventos.getString("titulo");
        String descripcion = eventos.getString("descripcion");
        Date fecha = eventos.getDate("fecha");


        // Crear el objeto Evento
        Evento eventoObtenido = new Evento(titulo, descripcion, fecha);

        return eventoObtenido;
        
    }
    
    public void agregarEvento(Evento evento){
        
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        Document documentEvento = new Document();
        documentEvento.append("titulo", evento.getTitulo());
        documentEvento.append("descripcion", evento.getDescripcion());
        documentEvento.append("fecha", evento.getFecha());

        collection.insertOne(documentEvento);
        
    }
    
    public void modifcarEvento(Evento evento, Evento eventoModificado){
        
         MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        Document query = new Document("titulo", evento.getTitulo());

        // Define los cambios que se van a realizar
        Document update = new Document("$set", new Document()
                .append("titulo", eventoModificado.getTitulo())
                .append("descripcion", eventoModificado.getDescripcion())
                .append("fecha", eventoModificado.getFecha())
        );

        // Modifica el primer documento que coincida con el filtro
        collection.updateOne(query, update);

        System.out.println("Evento modificado correctamente");
        
    }
}
