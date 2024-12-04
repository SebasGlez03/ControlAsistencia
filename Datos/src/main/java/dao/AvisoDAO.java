/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Aviso;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Ragzard
 */
public class AvisoDAO {

    private final MongoCollection<Document> collection;

    /**
     * Constructor vacío que inicializa la conexión a la base de datos.
     */
    public AvisoDAO() {
        this.collection = conexionDB();
    }

    /**
     * Agrega un aviso a la base de datos.
     *
     * @param aviso Aviso que se quiere agregar.
     */
    public void agregarAviso(Aviso aviso) {
        this.collection.insertOne(convertAvisoToDoc(aviso));
    }

    /**
     * Obtiene un aviso de la lista de avisos de la base de datos.
     *
     * @param aviso Aviso que se va a buscar.
     * @return
     */
    public Aviso obtenerAviso(Aviso aviso) {
        Document query = new Document("_id", aviso.getId());
        Document resultado = this.collection.find(query).first();

        //Si el resultado es diferente de null regresa el documento convertido a [Aviso] si no regresa null.
        return (resultado != null) ? convertDocToAviso(resultado) : null;
    }

    /**
     * Obtiene la lista de todos los avisos en la base de datos.
     *
     * @return
     */
    public List<Aviso> obtenerListaAvisos() {
        List<Aviso> listaAvisos = new ArrayList<>();

        FindIterable<Document> documentos = collection.find();

        for (Document doc : documentos) {
            listaAvisos.add(convertDocToAviso(doc));
        }

        return listaAvisos;
    }

    /**
     * Actualisa un aviso de la base de datos.
     *
     * @param aviso
     * @param avisoActualizado
     */
    public void actualizarAviso(Aviso aviso, Aviso avisoActualizado) {
        Document query = new Document("_id", aviso.getId());
        Document update = new Document("$set", convertAvisoToDoc(avisoActualizado));

        this.collection.updateOne(query, update);
    }

    /**
     * Elimina un aviso de la base de datos.
     *
     * @param aviso
     */
    public void eliminarAviso(Aviso aviso) {
        this.collection.deleteOne(new Document("_id", aviso.getId()));
    }

    /**
     * Conexión a la base de datos.
     *
     * @return
     */
    private MongoCollection<Document> conexionDB() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("cia");

        return database.getCollection("avisos");
    }

    /**
     * Convierte un Objeto [Document] a un objeto [Aviso].
     *
     * @param doc
     * @return
     */
    private Aviso convertDocToAviso(Document doc) {
        return new Aviso(
                doc.getObjectId("_id"),
                doc.getString("titulo"),
                doc.getDate("fechaHora"),
                doc.getString("mensaje"),
                doc.getObjectId("idMaestro"),
                (Map<ObjectId, String>) doc.get("listaRespuestas")
        );
    }

    /**
     * Convierte un objeto [Aviso] en uno de tipo [Document].
     *
     * @param aviso
     * @return
     */
    private Document convertAvisoToDoc(Aviso aviso) {

        Document documentAviso = new Document("titulo", aviso.getTitulo())
                .append("fechaHora", aviso.getFechaHora())
                .append("mensaje", aviso.getMensaje())
                .append("idMaestro", aviso.getIdMaestro())
                .append("listaRespuestas", convertMapToDoc(aviso.getListaRespuestas()));

        return documentAviso;
    }

    private Document convertMapToDoc(Map<ObjectId, String> respuestas) {
        Document respuestasDoc = new Document();

        for (Map.Entry<ObjectId, String> entry : respuestas.entrySet()) {
            respuestasDoc.append(entry.getKey().toHexString(), entry.getValue());
        }

        return respuestasDoc;
    }
}
