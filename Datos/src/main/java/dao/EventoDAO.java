/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Evento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author limon
 */
public class EventoDAO {

    /**
     * Metodo que obtiene un evento de la base de datos
     *
     * @param evento Objeto de tipo Evento a obtener de la base de datos
     * @return Objeto tipo Evento obtenido
     */
    public Evento obtenerEvento(Evento evento) {

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

    /**
     * Metodo que agrega un evento a base de datos
     *
     * @param evento Objeto tipo Evento a agregar en la base de datos
     */
    public void agregarEvento(Evento evento) {

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

    /**
     * Metodo que modifica un evento en la base de datos
     *
     * @param evento Objeto de tipo Evento a modificar en la base de datos
     * @param eventoModificado Objeto de tipo Evento que suplira la informacion
     */
    public void modificarEvento(Evento evento, Evento eventoModificado) {

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
    
    public Evento obtenerEventoPorTitulo(String titulo) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        Document query = new Document("titulo", titulo);
        Document eventos = collection.find(query).first();

        if (eventos == null) {
            return null; // Si no hay coincidencia
        }

        // Extraer valores
        String descripcion = eventos.getString("descripcion");
        Date fechaInicio = eventos.getDate("fechaInicio");
        Date fechaFinal = eventos.getDate("fechaFinal");
        String horaInicio = eventos.getString("horaInicio");
        String horaFinal = eventos.getString("horaFinal");
        String campus = eventos.getString("campus");
        String categoria = eventos.getString("categoria");

        // Crear el objeto Evento
        return new Evento(titulo, descripcion, fechaInicio, fechaFinal, horaInicio, horaFinal, campus, categoria);
    }
    
    public List<Evento> obtenerTodos() {
        // Conexión a la base de datos
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        // Lista para almacenar los eventos
        List<Evento> eventos = new ArrayList<>();

        // Obtener todos los documentos de la colección
        for (Document doc : collection.find()) {
            String titulo = doc.getString("titulo");
            String descripcion = doc.getString("descripcion");
            Date fechaInicio = doc.getDate("fechaInicio");
            Date fechaFinal = doc.getDate("fechaFinal");
            String horaInicio = doc.getString("horaInicio");
            String horaFinal = doc.getString("horaFinal");
            String campus = doc.getString("campus");
            String categoria = doc.getString("categoria");

            // Crear un objeto Evento y agregarlo a la lista
            Evento evento = new Evento(titulo, descripcion, fechaInicio, fechaFinal, horaInicio, horaFinal, campus, categoria);
            eventos.add(evento);
        }

        return eventos;
    }
    
    public void eliminarEvento(Evento evento) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        Document query = new Document("titulo", evento.getTitulo());

        collection.deleteOne(query);
    }
    
    public List<Evento> obtenerTodosEventos() {
        // Crear una lista para almacenar los usuarios obtenidos
        List<Evento> listaEventos = new ArrayList<>();

        // Conexión con la base de datos MongoDB
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("eventos");

        // Recuperar todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        // Iterar sobre cada documento y mapearlo a un objeto Usuario
        for (Document doc : documentos) {
            String titulo = doc.getString("titulo");
            String descripcion = doc.getString("descripcion");
            Date fechaInicio = doc.getDate("fechaInicio");
            Date fechaFin = doc.getDate("fechaFin");
            String horaInicio = doc.getString("horaInicio");
            String horaFin = doc.getString("horaFin");
            String campus = doc.getString("campus");
            String categoria = doc.getString("categoria");

            // Crear un objeto Usuario y agregarlo a la lista
            Evento evento = new Evento(titulo, descripcion, fechaInicio, fechaFin, horaInicio, horaFin, campus, categoria);
            listaEventos.add(evento);
        }

        // Cerrar el cliente MongoDB
        mongoClient.close();

        return listaEventos;
    }
}
