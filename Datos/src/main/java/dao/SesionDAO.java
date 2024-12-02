/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Aggregates.*;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Projections.*;
import entidades.Alumno;
import entidades.Sesion;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author PC
 */
public class SesionDAO {

    AlumnoDAO alumnoDAO = new AlumnoDAO();

    // Esta hay que probarla
    public Sesion obtenerSesion(Sesion sesion) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("sesiones");

        Document documentSesion = new Document();
        documentSesion.append("fecha", sesion.getFecha());
        documentSesion.append("id_clase", sesion.getIdClase());
        documentSesion.append("id_maestro", sesion.getIdMaestro());
        documentSesion.append("listaAsistencia", sesion.getAlumnos());

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
        documentSesion.append("id_maestro", sesion.getIdMaestro());
        documentSesion.append("listaAsistencia", listaAsistencia);

        collection.insertOne(documentSesion);
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

        return listaAsistenciaConDetalles;
    }

}
