/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import entidades.Clase;
import entidades.Maestro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class MaestroDAO {

    /**
     * Metodo que obtiene un maestro de la base de datos
     *
     * @param matricula Matricula del maestro a obtener
     * @return Objeto tipo Maestro obtenido
     */
    public Maestro obtenerMaestro(int matricula) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        // Consultamos al maestro por su matrícula
        Document query = new Document("matricula", matricula);
        Document maestroDoc = collection.find(query).first();

        if (maestroDoc == null) {
            System.out.println("No se encontró un maestro con esa matrícula.");
            return null;  // Manejar el caso de que no se encuentre el maestro
        }

        // Obtener la información del maestro
        int matriculaObtenida = maestroDoc.getInteger("matricula");
        String nombre = maestroDoc.getString("nombre");
        String apellidoPaterno = maestroDoc.getString("apellidoPaterno");
        String apellidoMaterno = maestroDoc.getString("apellidoMaterno");
        String correo = maestroDoc.getString("correo");
        String contrasenia = maestroDoc.getString("contrasenia");
        ObjectId rol = maestroDoc.getObjectId("rol");

        // Obtener el campo 'materiasImpartidas', que es una lista de documentos con id_materia
        List<Document> materiasImpartidas = (List<Document>) maestroDoc.get("materiasImpartidas");

        // Verificar si la lista es null o vacía
        if (materiasImpartidas == null || materiasImpartidas.isEmpty()) {
            System.out.println("El maestro no tiene materias impartidas.");
            materiasImpartidas = new ArrayList<>();  // Asignamos una lista vacía si no hay materias
        }

        List<Clase> materias = new ArrayList<>();

        // Iterar sobre cada elemento de 'materiasImpartidas' y obtener el ObjectId
        for (Document materia : materiasImpartidas) {
            ObjectId idMateria = materia.getObjectId("id_materia");

            if (idMateria != null) {
                // Aquí, si deseas más detalles de la materia, podrías hacer otra consulta.
                // Por ejemplo, obtener el nombre de la materia de una colección 'materias'
                Document materiaDoc = database.getCollection("clases").find(new Document("_id", idMateria)).first();

                if (materiaDoc != null) {
                    ObjectId idClase = materiaDoc.getObjectId("_id");
                    String nombreMateria = materiaDoc.getString("nombre");  // Suponiendo que 'materias' tiene un campo 'nombre'
                    int semestre = materiaDoc.getInteger("semestre");
                    // Crear un objeto Clase (que debe tener el nombre de la materia o cualquier otro dato necesario)
                    Clase claseObj = new Clase(nombreMateria, semestre);
                    claseObj.setId(idClase);
                    materias.add(claseObj);
                }
            }
        }

        // Crear y devolver el objeto Maestro
        Maestro maestroObtenido = new Maestro(materias, matriculaObtenida, nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, rol);

        mongoClient.close();

        return maestroObtenido;
    }

    /**
     * Metodo que agrega un maestro en la base de datos
     *
     * @param maestro Objeto de tipo Maestro a agregar en la base de datos
     */
    public void agregarMaestro(Maestro maestro) {
        // Esta clase recibe una lista que actualmente es mock ya que no es parte de nuestro caso de uso
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        List<Document> clasesLista = new ArrayList();

        for (Clase clase : maestro.getMaterias()) {
            Document documentClase = new Document();
            documentClase.append("id", new ObjectId());
            documentClase.append("nombreClase", clase);
            clasesLista.add(documentClase);
        }

        Document documentMaestro = new Document();
        documentMaestro.append("matricula", maestro.getMatricula());
        documentMaestro.append("nombre", maestro.getNombre());
        documentMaestro.append("apellidoPaterno", maestro.getApellidoPaterno());
        documentMaestro.append("apellidoMaterno", maestro.getApellidoMaterno());
        documentMaestro.append("correo", maestro.getCorreo());
        documentMaestro.append("contrasenia", maestro.getContrasenia());
        documentMaestro.append("materiasImpartidas", clasesLista);
        documentMaestro.append("rol", maestro.getRol());

        collection.insertOne(documentMaestro);

        mongoClient.close();
    }

    /**
     * Metodo que modifica un maestro en la base de datos
     *
     * @param maestro Objeto de tipo Maestro a modificar en la base de datos
     * @param maestroModificado Objeto tipo Maestro que suplira la informacion
     */
    public void modificarMaestro(Maestro maestro, Maestro maestroModificado) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document query = new Document("matricula", maestro.getMatricula());

        List<Document> clasesLista = new ArrayList();

//        maestro.getMaterias().clear();
        for (Clase clase : maestroModificado.getMaterias()) {
            Document documentClase = new Document();
            documentClase.append("id", new ObjectId());
            documentClase.append("nombreClase", clase);
            clasesLista.add(documentClase);
        }

        // Define los cambios que se van a realizar
        Document update = new Document("$set", new Document()
                .append("nombre", maestroModificado.getNombre())
                .append("apellidoPaterno", maestroModificado.getApellidoPaterno())
                .append("apellidoMaterno", maestroModificado.getApellidoMaterno())
                .append("correo", maestroModificado.getCorreo())
                .append("contrasenia", maestroModificado.getContrasenia())
                .append("materiasImpartidas", clasesLista)
                .append("rol", maestroModificado.getRol())
        );

        // Modifica el primer documento que coincida con el filtro
        collection.updateOne(query, update);

        System.out.println("Maestro modificado correctamente");

        mongoClient.close();
    }

    /**
     * Obtiene la lista de materias impartidas por un maestro con sus nombres e
     * IDs.
     *
     * @param matricula Matricula del maestro.
     * @return Lista de objetos Clase que contienen el ID y nombre de las
     * materias.
     */
    public List<Clase> obtenerMateriasConNombresPorMaestro(int matricula) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");
        MongoCollection<Document> collection = database.getCollection("usuarios");
        MongoCollection<Document> collectionClases = database.getCollection("clases");

        // Obtener el documento del maestro
        Document maestro = collection.find(Filters.eq("matricula", matricula)).first();

        if (maestro != null && maestro.containsKey("materiasImpartidas")) {
            List<Document> materiasImpartidas = maestro.getList("materiasImpartidas", Document.class);
            List<ObjectId> idsMaterias = materiasImpartidas.stream()
                    .map(materia -> materia.getObjectId("id_materia"))
                    .collect(Collectors.toList());

            // Consultar la colección de materias para obtener sus detalles
            List<Document> materiasDetalles = collectionClases.find(Filters.in("_id", idsMaterias)).into(new ArrayList<>());

            // Convertir los documentos a objetos Clase usando el constructor vacío y los setters
            List<Clase> listaClases = new ArrayList<>();
            for (Document doc : materiasDetalles) {
                Clase clase = new Clase(); // Constructor vacío
                clase.setId(doc.getObjectId("_id")); // Configurar el ID
                clase.setNombre(doc.getString("nombre")); // Configurar el nombre
                listaClases.add(clase); // Agregar a la lista
            }

            mongoClient.close();

            return listaClases;
        } else {
            System.out.println("No se encontró el maestro o no tiene materias asignadas.");
            mongoClient.close();
            return new ArrayList<>();

        }

    }

}
