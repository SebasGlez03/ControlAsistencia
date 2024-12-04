/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import entidades.Alumno;
import entidades.Clase;
import entidades.Maestro;
import entidades.QR;
import java.util.ArrayList;
import java.util.Date;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class QrDAO {

    public static final int PRESENTE = 1;
    public static final int RETARDO = 2;

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

    /**
     * Agrega un alumno a la lista de asistencia basado en el PIN de un QR.
     *
     * @param alumno Alumno que se agregará a la lista de asistencia.
     * @param pin PIN del QR para encontrar la sesión.
     * @return boolean Verdadero si la operación fue exitosa, falso en caso
     * contrario.
     */
    public boolean agregarAlumnoASesion(Alumno alumno, String pin) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> qrCollection = database.getCollection("qr");
        MongoCollection<Document> sesionesCollection = database.getCollection("sesiones");

        try {
            // Buscar el documento QR con el PIN
            Document qrDoc = qrCollection.find(Filters.eq("contenido", pin)).first();

            if (qrDoc == null) {
                System.out.println("QR con el PIN no encontrado.");
                return false;
            }

            // Obtener el ID de la sesión asociada al QR
            ObjectId idSesion = qrDoc.getObjectId("idSesion");

            // Buscar la sesión con el ID encontrado
            Document sesionDoc = sesionesCollection.find(Filters.eq("_id", idSesion)).first();

            if (sesionDoc == null) {
                System.out.println("Sesión no encontrada.");
                return false;
            }

            // Crear el documento del alumno a agregar en la lista de asistencia
            Document nuevoAlumno = new Document()
                    .append("matriculaAlumno", alumno.getMatricula())
                    .append("estadoAsistencia", "Presente"); // Asume estado inicial "Presente"

            // Actualizar la sesión para agregar al alumno en la lista de asistencia
            sesionesCollection.updateOne(
                    Filters.eq("_id", idSesion),
                    Updates.addToSet("listaAsistencia", nuevoAlumno) // addToSet evita duplicados
            );

            System.out.println("Alumno agregado a la sesión correctamente.");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Busca un QR por PIN y determina el estado de asistencia basado en la
     * fecha de creación.
     *
     * @param pin PIN del QR.
     * @return Estado de asistencia (1: PRESENTE, 2: RETARDO).
     * @throws IllegalArgumentException Si el QR no existe o el tiempo excede el
     * límite.
     */
    public int determinarEstadoAsistencia(String pin) throws IllegalArgumentException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> qrCollection = database.getCollection("qr");

        // Buscar el documento QR con el PIN
        Document qrDoc = qrCollection.find(Filters.eq("contenido", pin)).first();

        if (qrDoc == null) {
            throw new IllegalArgumentException("QR con el PIN no encontrado.");
        }

        // Obtener la fecha de creación del QR
        Instant fechaCreacion = qrDoc.getDate("fechaCreacion").toInstant();

        // Obtener la fecha actual
        Instant fechaActual = Instant.now();

        // Calcular la diferencia en minutos entre las fechas
        long minutosDiferencia = ChronoUnit.MINUTES.between(fechaCreacion, fechaActual);

        // Determinar el estado de asistencia
        if (minutosDiferencia <= 5) {
            return PRESENTE;
        } else if (minutosDiferencia <= 10) {
            return RETARDO;
        } else {
            throw new IllegalArgumentException("El tiempo del QR ha expirado.");
        }

    }

    /**
     * Método para obtener el ID de la sesión a partir del PIN.
     *
     * @param pin El PIN del QR.
     * @return El ObjectId de la sesión correspondiente.
     * @throws IllegalArgumentException Si no se encuentra el QR o el PIN no es
     * válido.
     */
    public ObjectId obtenerIdSesionDesdeQR(String pin) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> qrCollection = database.getCollection("qr");

        // Buscar el documento QR con el PIN proporcionado
        Document qrDoc = qrCollection.find(Filters.eq("contenido", pin)).first();

        // Verificar si se encontró el QR con el PIN
        if (qrDoc != null) {
            // Retornar el ObjectId de la sesión asociada a este QR
            return qrDoc.getObjectId("idSesion");
        } else {
            throw new IllegalArgumentException("QR con el PIN no encontrado.");
        }
    }

    /**
     * Método que agrega un alumno a la lista de asistencia de una sesión.
     *
     * @param idSesion El ObjectId de la sesión donde se va a agregar al alumno.
     * @param alumno El objeto Alumno que contiene la información del alumno.
     */
    public void agregarAlumnoASesion(ObjectId idSesion, Alumno alumno) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> sesionesCollection = database.getCollection("sesiones");

        // Buscar la sesión correspondiente por idSesion
        Document sesionDoc = sesionesCollection.find(Filters.eq("_id", idSesion)).first();

        // Verificar si la sesión existe
        if (sesionDoc != null) {
            // Crear el documento del alumno que se va a agregar a la lista de asistencia
            Document alumnoDoc = new Document();
            alumnoDoc.append("matriculaAlumno", alumno.getMatricula());
            alumnoDoc.append("estadoAsistencia", alumno.getEstadoAsistencia()); // Puede ser "Presente" o "Retardo"

            // Agregar el alumno a la lista de asistencia de la sesión
            sesionesCollection.updateOne(
                    Filters.eq("_id", idSesion), // Buscar la sesión por id
                    Updates.addToSet("listaAsistencia", alumnoDoc) // Agregar el alumno a la lista de asistencia
            );

            System.out.println("Alumno agregado a la sesión con éxito.");
        } else {
            System.out.println("No se encontró la sesión con el ID especificado.");
        }

    }
}
