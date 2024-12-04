/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaAviso;

import dto.AvisoDTO;
import entidades.Aviso;

/**
 *
 * @author Ragzard
 */
public interface IAviso {

    /**
     * Método que permite agregar un aviso nuevo al sistema.
     *
     * @param aviso
     */
    public void agregarAviso(AvisoDTO aviso);

    /**
     * Método para actualizar un aviso existente en el sisterma.
     *
     * @param avisoViejo Aviso que se va a actualizar
     * @param avisoActualizado Aviso actualizado
     */
    public void actualizarAviso(AvisoDTO avisoViejo, AvisoDTO avisoActualizado);

    /**
     * Método para ver / consultar un aviso existente en el sistema.
     *
     * @param aviso
     */
    public void consultarAviso(AvisoDTO aviso);

    /**
     * Método para eliminar un aviso existente en el sistema.
     *
     * @param aviso
     */
    public void eliminarAviso(AvisoDTO aviso);

    /**
     * Método para agregar una respuesta a un aviso en el sistema.
     *
     * @param aviso
     * @param respuesta
     */
    public void responderAviso(AvisoDTO aviso, String respuesta);

}
