/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
        Date fechaInicio = eventos.getDate("fechaInicio");
        Date fechaFinal = eventos.getDate("fechaFinal");
        String horaInicio = eventos.getString("horaInicio");
        String horaFinal = eventos.getString("horaFinal");
        String campus = eventos.getString("campus");
        String categoria = eventos.getString("categoria");
                


        // Crear el objeto Evento
        Evento eventoObtenido = new Evento(titulo, descripcion, fechaInicio, fechaFinal, horaInicio, horaFinal, campus, categoria);

        return eventoObtenido;
        
    }
    
    public void agregarEvento(Evento evento){
        
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        Document documentEvento = new Document();
        documentEvento.append("titulo", evento.getTitulo());
        documentEvento.append("descripcion", evento.getDescripcion());
        documentEvento.append("fechaInicio", evento.getFechaInicio());
        documentEvento.append("fechaFinal", evento.getFechaFinal());
        documentEvento.append("horaInicio", evento.getHoraInicio());
        documentEvento.append("horaFinal", evento.getHoraFinal());
        documentEvento.append("campus", evento.getCampus());
        documentEvento.append("categoria", evento.getCategoria());

        collection.insertOne(documentEvento);
        
    }
    
    public void modificarEvento(Evento evento, Evento eventoModificado){
        
         MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        Document query = new Document("titulo", evento.getTitulo());

        // Define los cambios que se van a realizar
        Document update = new Document("$set", new Document()
                .append("titulo", eventoModificado.getTitulo())
                .append("descripcion", eventoModificado.getDescripcion())
                .append("fechaInicio", eventoModificado.getFechaInicio())
                .append("fechaFinal", eventoModificado.getFechaFinal())
                .append("horaInicio", eventoModificado.getHoraInicio())
                .append("horaFinal", eventoModificado.getHoraFinal())
                .append("campus", eventoModificado.getCampus())
                .append("categoria", eventoModificado.getCategoria())
        );

        // Modifica el primer documento que coincida con el filtro
        collection.updateOne(query, update);

        System.out.println("Evento modificado correctamente");
        
    }
}
