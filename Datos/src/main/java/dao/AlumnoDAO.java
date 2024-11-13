/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Alumno;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class AlumnoDAO {

    public AlumnoDAO() {
    }

    public Alumno obtenerAlumno(Alumno alumno) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", alumno.getMatricula());
        Document alumnos = collection.find(query).first();

        System.out.println("Alumno leido: " + alumnos.toJson());

        int matricula = alumnos.getInteger("matricula");
        String nombre = alumnos.getString("nombre");
        String apellidoPaterno = alumnos.getString("apellidoPaterno");
        String apellidoMaterno = alumnos.getString("apellidoMaterno");
        String correo = alumnos.getString("correo");
        String contrasenia = alumnos.getString("contrasenia");
        int semestre = alumnos.getInteger("semestre");
        double promedio = alumnos.getDouble("promedio");

        Alumno alumnoObtenido = new Alumno(semestre, (float) promedio, matricula, nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia);

        return alumnoObtenido;

    }

    public void agregarAlumno(Alumno alumno) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document documentAlumno = new Document();
        documentAlumno.append("matricula", alumno.getMatricula());
        documentAlumno.append("nombre", alumno.getNombre());
        documentAlumno.append("apellidoPaterno", alumno.getApellidoPaterno());
        documentAlumno.append("apellidoMaterno", alumno.getApellidoMaterno());
        documentAlumno.append("correo", alumno.getCorreo());
        documentAlumno.append("contrasenia", alumno.getContrasenia());
        documentAlumno.append("semestre", alumno.getSemestre());
        documentAlumno.append("promedio", alumno.getPromedio());

        collection.insertOne(documentAlumno);
    }

    public void modificarAlumno(Alumno alumno, Alumno alumnoModificado) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", alumno.getMatricula());

        // Define los cambios que se van a realizar
        Document update = new Document("$set", new Document()
                .append("nombre", alumnoModificado.getNombre())
                .append("apellidoPaterno", alumnoModificado.getApellidoPaterno())
                .append("apellidoMaterno", alumnoModificado.getApellidoMaterno())
                .append("correo", alumnoModificado.getCorreo())
                .append("contrasenia", alumnoModificado.getContrasenia())
                .append("semestre", alumnoModificado.getSemestre())
                .append("promedio", alumno.getPromedio())
        );

        // Modifica el primer documento que coincida con el filtro
        collection.updateOne(query, update);

        System.out.println("Alumno modificado correctamente");
    }

}
