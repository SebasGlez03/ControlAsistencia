/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package subsistemaAviso;

import dto.AvisoDTO;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author Ragzard
 */
public class SubsistemaAviso {

    public static void main(String[] args) {
//        AvisoDTO aviso = new AvisoDTO(
//                new ObjectId(),
//                "Aviso de prueva",
//                new Date().getTime(),
//                "Esto es un aviso de prueba",
//                new ObjectId,
//                new Map<idUsuario, "Respuesta de prueba">);
        IAviso controlAviso = new FachadaAviso();

        Map<ObjectId, String> respuestas = new HashMap<>();
        respuestas.put(new ObjectId(), "Esta es la primer respuesta de prueba");
        respuestas.put(new ObjectId(), "Segunda respuesta");

        AvisoDTO aviso = new AvisoDTO(
                "Este es un Aviso de prueba",
                new Date(),
                "Mensaje de Pureba para el Aviso",
                null,
                respuestas);

        System.out.println("El aviso es: " + aviso.toString());

        controlAviso.agregarAviso(aviso);
    }
}
