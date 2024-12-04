/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import entidades.Alumno;
import entidades.Sesion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Aggregates.*;
import com.mongodb.client.model.Projections;
import static com.mongodb.client.model.Projections.*;

/**
 *
 * @author PC
 */
public class SesionDAO {

    /**
     * Metodo que obtiene la sesion de la base de datos
     *
     * @param sesion Objeto Sesion a obtener de la base de datos
     * @return Objeto Sesion obtenido
     */
    public Sesion obtenerSesion(Sesion sesion) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("sesiones");

        Document documentSesion = new Document();
        documentSesion.append("fecha", sesion.getFecha());
        documentSesion.append("id_clase", sesion.getIdClase());
        documentSesion.append("matriculaMaestro", sesion.getMatriculaMaestro());
        documentSesion.append("listaAsistencia", sesion.getAlumnos());

        mongoClient.close();

        return sesion;
    }

    /**
     * Metodo que obtiene la sesion de la base de datos mediante un ObjectId
     *
     * @param idSesion ObjectId de la sesion a buscar en la base de datos
     * @return Objeto Sesion obtenido
     */
    public Sesion obtenerSesion(ObjectId idSesion) {
        // Crear cliente y conectarse a la base de datos
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("sesiones");

        // Buscar la sesión por ObjectId
        Document sesionDocument = collection.find(new Document("_id", idSesion)).first();

        // Si no se encuentra, devuelve null o lanza una excepción
        if (sesionDocument == null) {
            return null; // O lanza una excepción personalizada
        }

        // Extraer campos de la sesión
        Date fecha = sesionDocument.getDate("fecha");
        ObjectId idClase = sesionDocument.getObjectId("id_clase");
        int matriculaMaestro = sesionDocument.getInteger("matriculaMaestro");

        // Obtener la lista de asistencia
        List<Document> listaAsistenciaDocs = sesionDocument.getList("listaAsistencia", Document.class);
        List<Alumno> listaAsistencia = new ArrayList<>();

        if (listaAsistenciaDocs != null) {
            for (Document doc : listaAsistenciaDocs) {
                int matriculaAlumno = doc.getInteger("matriculaAlumno");
                String estadoAsistencia = doc.getString("estadoAsistencia");

                Alumno alumno = new Alumno();
                alumno.setMatricula(matriculaAlumno);
                alumno.setEstadoAsistencia(estadoAsistencia);
                listaAsistencia.add(alumno);
            }
        }

        // Crear y devolver el objeto Sesion
        Sesion sesion = new Sesion(fecha, idClase, matriculaMaestro, listaAsistencia);

        mongoClient.close();

        return sesion;
    }

    /**
     * Metodo que agrega una nueva sesion a la base de datos
     *
     * @param sesion Sesion a agregar en la base de datos
     */
    public void agregarSesion(Sesion sesion) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("sesiones");

        List<Document> listaAsistencia = new ArrayList();

        for (Alumno alumno : sesion.getAlumnos()) {
            Document documentListaAsistencia = new Document();
            documentListaAsistencia.append("matriculaAlumno", alumno.getMatricula());
            documentListaAsistencia.append("asistencia", alumno.getEstadoAsistencia());
            listaAsistencia.add(documentListaAsistencia);
        }

        Document documentSesion = new Document();
        documentSesion.append("fecha", sesion.getFecha());
        documentSesion.append("id_clase", sesion.getIdClase());
        documentSesion.append("matriculaMaestro", sesion.getMatriculaMaestro());
        documentSesion.append("listaAsistencia", listaAsistencia);

        collection.insertOne(documentSesion);

        mongoClient.close();
    }

    /**
     * Metodo que obtiene la lista de los alumnos y su asistencia de la sesion
     * para mostrar en uan tabla
     *
     * @param sesion Sesion a obtener de la base de datos
     * @return Lista de los alumnos y su asistendia (representada en documentos)
     */
    public List<Document> obtenerSesionAlumnos(Sesion sesion) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("sesiones");

        // Creacion de la consulta agregacion
        List<Bson> pipeline = new ArrayList<>();

        // Filtro por el ObjectId de la sesion
        pipeline.add(match(Filters.eq("_id", sesion.getId())));

        // Descomponer el array "listaAsistencia"
        pipeline.add(unwind("listaAsistencia"));

        // Realizar el lookup para obtener detalles del alumno desde la coleccion "usuarios"
        pipeline.add(lookup("usuarios",
                "listaAsistencia.matriculaAlumno", // Campo local a relacionar
                "matricula", // Campo de la coleccion "usuarios" que se relaciona
                "detalles_alumno" // Resultado del "lookup"
        ));

        // Descomponer el array "detalles_alumno"
        pipeline.add(unwind("$detalles_alumno"));

        // Proyeccion para seleccionar los campos deseados
        pipeline.add(project(fields(excludeId(),
                include("detalles_alumno.matricula", "detalles_alumno.nombre",
                        "detalles_alumnoapellidoPaterno", "detalles_alumno.apellidoMaterno",
                        "listaAsistencia.asistencia")
        )));

        // Ejecutar la consulta de agregacion
        AggregateIterable<Document> result = collection.aggregate(pipeline);

        // Crear la lista para almacenar los resultados
        List<Document> listaAsistenciaConDetalles = new ArrayList<>();
        for (Document document : result) {
            listaAsistenciaConDetalles.add(document);
        }

        mongoClient.close();

        return listaAsistenciaConDetalles;
    }

    //PRUEBAdadasasddadasasddadasasddadasasddadasasddadasasddadasasddadasasddadasasddadasasddadasasddadasasddadasasddadasasd
    public List<Alumno> obtenerSesionAlumnosNoDocumento(Sesion sesion) {
        System.out.println("Obteniendo alumnos para la sesión: " + sesion.getId());
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("sesiones");

        // Consulta inicial
        List<Bson> pipeline = new ArrayList<>();
        pipeline.add(Aggregates.match(Filters.eq("_id", sesion.getId())));
        pipeline.add(Aggregates.unwind("$listaAsistencia"));
        pipeline.add(Aggregates.lookup("usuarios", "listaAsistencia.matriculaAlumno", "matricula", "detalles_alumno"));
        pipeline.add(Aggregates.unwind("$detalles_alumno"));
        pipeline.add(Aggregates.project(Projections.fields(
                Projections.excludeId(),
                Projections.include("detalles_alumno.matricula", "detalles_alumno.nombre",
                        "detalles_alumno.apellidoPaterno", "detalles_alumno.apellidoMaterno",
                        "listaAsistencia.estadoAsistencia")
        )));

        System.out.println("Pipeline de agregación: " + pipeline);

        AggregateIterable<Document> result = collection.aggregate(pipeline);

        // Validar resultados
        List<Alumno> listaAlumnos = new ArrayList<>();
        for (Document doc : result) {
            System.out.println("Documento procesado: " + doc.toJson());

            // Cambia la forma en que accedes a los datos
            Document detallesAlumno = doc.get("detalles_alumno", Document.class);
            Document listaAsistencia = doc.get("listaAsistencia", Document.class);

            int matricula = detallesAlumno.getInteger("matricula");
            String nombre = detallesAlumno.getString("nombre");
            String apellidoPaterno = detallesAlumno.getString("apellidoPaterno");
            String apellidoMaterno = detallesAlumno.getString("apellidoMaterno");
            String estadoAsistencia = listaAsistencia.getString("estadoAsistencia");

            Alumno alumno = new Alumno();
            alumno.setMatricula(matricula);
            alumno.setNombre(nombre);
            alumno.setApellidoPaterno(apellidoPaterno);
            alumno.setApellidoMaterno(apellidoMaterno);
            alumno.setEstadoAsistencia(estadoAsistencia);

            listaAlumnos.add(alumno);
        }

        if (listaAlumnos.isEmpty()) {
            System.out.println("No se encontraron alumnos para la sesión.");
        }

        return listaAlumnos;
    }

}
