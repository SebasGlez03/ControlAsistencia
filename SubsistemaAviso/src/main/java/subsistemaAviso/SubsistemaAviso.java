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

        IAviso controlAviso = new FachadaAviso();

        Map<ObjectId, String> respuestas = new HashMap<>();
        respuestas.put(new ObjectId(), "Esta es la primer respuesta de prueba");
        respuestas.put(new ObjectId(), "Segunda respuesta");
        
        Map<ObjectId, String> respuestas2 = new HashMap<>();
        respuestas2.put(new ObjectId(), "Si se agrega esto funciona");
        respuestas2.put(new ObjectId(), "Saludos gracias!");
        respuestas2.put(new ObjectId(), "Wow si funciona!!!");
        
        Map<ObjectId, String> respuestas3 = new HashMap<>();
        respuestas2.put(new ObjectId(), "Tiene que se una 4 respuesta");
        
        
        

        AvisoDTO aviso1 = new AvisoDTO("[1]Este es un Aviso de prueba", new Date(), "Mensaje de Pureba para el Aviso", null, respuestas);
        AvisoDTO aviso2 = new AvisoDTO("[2]Fecha de examen actualizada", new Date(), "La fecha del examen de cambió para el próximo lunes", null, null);
        AvisoDTO aviso3 = new AvisoDTO("[3]Cambio de aula", new Date(), "El nuevo salon va a ser el LV-1825", null, null);

        AvisoDTO aviso4 = new AvisoDTO("[4]Aviso actualizado", new Date(), "Se actualizo el aviso 1 por el aviso4", null, null);
        AvisoDTO aviso5 = new AvisoDTO("[5]Aviso actualizado", new Date(), "Se actualizo el aviso 2 por el aviso5", null, null);
        AvisoDTO aviso6 = new AvisoDTO("[6]Aviso actualizado", new Date(), "Se actualizo el aviso 3 por el aviso6", null, respuestas);

        //-----------[Agregar Aviso]------------ | Funciona
//        controlAviso.agregarAviso(aviso1);
//        controlAviso.agregarAviso(aviso2);
//        controlAviso.agregarAviso(aviso3);
        //---------[Actualizar Aviso]----------- | Funciona
        //controlAviso.actualizarAviso(controlAviso.consultarListaAvisos().get(0), aviso4);
//        controlAviso.actualizarAviso(controlAviso.consultarListaAvisos().get(1), aviso5);
//        controlAviso.actualizarAviso(controlAviso.consultarListaAvisos().get(2), aviso6);
        //------------[Eliminar Aviso]---------- | Funciona
//        controlAviso.eliminarAviso(controlAviso.consultarListaAvisos().get(1));//Aviso 5

        //-----[Consultar lista de avisos]------  | Funciona
//        System.out.println("Lista de avisos: " + controlAviso.consultarListaAvisos());
        
        //-----------[Responder Aviso]----------
        controlAviso.responderAviso(controlAviso.consultarListaAvisos().get(0), respuestas2);
    }
}
