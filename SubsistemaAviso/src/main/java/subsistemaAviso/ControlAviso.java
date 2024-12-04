/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaAviso;

import dto.AvisoDTO;
import entidades.Aviso;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.types.ObjectId;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/**
 *
 * @author Ragzard
 */
public class ControlAviso {

    private Aviso aviso;
    private IPersistencia datos = new FachadaPersistencia();

    /**
     * Constructor vacio.
     */
    public void ControlAviso() {

    }

    /**
     * Agrega un aviso al sistema.
     *
     * @param aviso
     */
    public void agregarAviso(AvisoDTO aviso) {
        datos.agregarAviso(convertDtoToEntidad(aviso));
    }

    /**
     * Actualiza un aviso de la base de datos.
     *
     * @param aviso
     * @param avisoActualizado
     */
    public void actualizarAviso(AvisoDTO aviso, AvisoDTO avisoActualizado) {
        datos.actualizarAviso(convertDtoToEntidad(aviso), convertDtoToEntidad(avisoActualizado));
    }

    /**
     * Obtiene un aviso de la base de datos.
     *
     * @param aviso
     * @return
     */
    public AvisoDTO consultarAviso(AvisoDTO aviso) {

        return convertEntidadToDTO(datos.obtenerAviso(convertDtoToEntidad(aviso)));
    }

    public List<AvisoDTO> consultarListaAvisos() {
        List<AvisoDTO> avisosDTO = new ArrayList<>();
        for (Aviso aviso : datos.obtenerListaAvisos()) {
            avisosDTO.add(convertEntidadToDTO(aviso));
        }

        return avisosDTO;
    }

    /**
     * Elimina un aviso de la base de datos.
     *
     * @param aviso
     */
    public void eliminarAviso(AvisoDTO aviso) {
        datos.eliminarAviso(convertDtoToEntidad(aviso));
    }

    /**
     * Agrega una respuesta al aviso.
     *
     * @param aviso
     * @param respuesta
     */
    public void responderAviso(AvisoDTO aviso, Map<ObjectId, String> respuesta) {
        datos.responderAviso(convertDtoToEntidad(aviso), respuesta);
    }

    /**
     * Método para obtener el aviso.
     *
     * @return
     */
    public Aviso getAviso() {
        return aviso;
    }

    /**
     * Método para asignar un aviso.
     *
     * @param aviso
     */
    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    private Aviso convertDtoToEntidad(AvisoDTO dto) {
        return new Aviso(
                dto.getId(),
                dto.getTitulo(),
                dto.getFechaHora(),
                dto.getMensaje(),
                dto.getIdMaestro(),
                dto.getListaRespuestas());
    }

    private AvisoDTO convertEntidadToDTO(Aviso aviso) {
        return new AvisoDTO(
                aviso.getId(),
                aviso.getTitulo(),
                aviso.getFechaHora(),
                aviso.getMensaje(),
                aviso.getIdMaestro(),
                aviso.getListaRespuestas());
    }

}
