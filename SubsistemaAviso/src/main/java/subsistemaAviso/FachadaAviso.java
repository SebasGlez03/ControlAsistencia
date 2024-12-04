/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaAviso;

import dto.AvisoDTO;
import entidades.Aviso;

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
    public void consultarAviso(AvisoDTO aviso) {
        controlAviso.consultarAviso(aviso);
    }
    
    /**
     * Elimina un aviso de la base de datos.
     * @param aviso 
     */
    @Override
    public void eliminarAviso(AvisoDTO aviso) {
        controlAviso.eliminarAviso(aviso);
    }
    
    @Override
    public void responderAviso(AvisoDTO aviso, String respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
