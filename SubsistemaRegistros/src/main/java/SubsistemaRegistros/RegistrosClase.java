/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package SubsistemaRegistros;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.*;
import java.util.ArrayList;
import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;
import java.util.*;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * 
 *
 * @author joel_
 */
public class RegistrosClase {
    
    
    private IPersistencia IPer = new FachadaPersistencia();
    public RegistrosClase() {
    }
    
    
    public void agregarMateria(Materia materia, Maestro maestro){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("Sesiones");
        
        List<Alumno> listaAsistencia = new ArrayList<Alumno>();
        
        Materia materiaNueva= new Materia(materia.getID(),
                materia.getNombre(),
                materia.getSemestre());
        
        Document document = new Document();
        document.append("_id", new ObjectId());
        //document.append("fecha", )
        document.append("id_clase", new ObjectId());
        document.append("id_maestro", maestro.getMatricula());
        document.append("listaAsistencia",listaAsistencia);
        
        collection.insertOne(document);
    }
    
    
    
    public void inscribirAlumnoEnMateria(Alumno alumno, Materia materia){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("Sesiones");
        
        collection.find();
    }
    
//    public List<Materia> listarMateriasDisponibles(){
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        MongoDatabase database = mongoClient.getDatabase("cia");
//        MongoCollection<Materia> collection = database.getCollection("clases",Materia.class);
//        
//        
//    }
    /**
    public List<Alumno> obtenerAlumnosPorMateria(Materia materia){
        
    }**/
    
    
}
