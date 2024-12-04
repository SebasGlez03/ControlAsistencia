/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaAviso;

import dto.AvisoDTO;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;

/**
 *
 * @author Ragzard
 */
public class FachadaAviso implements IAviso {

    ControlAviso controlAviso = new ControlAviso();

    /**
     * Método para agregar un aviso nuevo a la BD.
     *
     * @param aviso
     */
    @Override
    public void agregarAviso(AvisoDTO aviso) {
        controlAviso.agregarAviso(aviso);
    }

    /**
     * Actualiza un aviso de la base de datos.
     *
     * @param aviso
     * @param avisoActualizado
     */
    @Override
    public void actualizarAviso(AvisoDTO aviso, AvisoDTO avisoActualizado) {
        controlAviso.actualizarAviso(aviso, avisoActualizado);
    }

    /**
     * Obtiene un aviso de la base de datos.
     *
     * @param aviso
     */
    @Override
    public AvisoDTO consultarAviso(AvisoDTO aviso) {
        return controlAviso.consultarAviso(aviso);
    }

    @Override
    public List<AvisoDTO> consultarListaAvisos() {
        return controlAviso.consultarListaAvisos();
    }

    /**
     * Elimina un aviso de la base de datos.
     *
     * @param aviso
     */
    @Override
    public void eliminarAviso(AvisoDTO aviso) {
        controlAviso.eliminarAviso(aviso);
    }

    /**
     * Agrega una respuesta al aviso dado por el parametro.
     *
     * @param aviso
     * @param respuesta
     */
    @Override
    public void responderAviso(AvisoDTO aviso, Map<ObjectId, String> respuesta) {
        controlAviso.responderAviso(aviso, respuesta);
    }

}
